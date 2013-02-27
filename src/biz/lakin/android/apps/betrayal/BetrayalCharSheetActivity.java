package biz.lakin.android.apps.betrayal;

import java.util.HashMap;

import android.app.Activity;
import android.app.backup.RestoreObserver;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;

public class BetrayalCharSheetActivity extends Activity 
  implements OnItemSelectedListener, OnClickListener {
	
	private class Character {
		public String name;
		public String hobbies;
		public String birthday;
		public int age;
		public String height;
		//In lbs
		public int weight;
		public HashMap<String, Integer> initialStatIndexes = new HashMap<String, Integer>();
		public HashMap<String, int[]> stats = new HashMap<String, int[]>();
	}

	private HashMap<String, Character> m_characterStats = new HashMap<String, Character>();
	private HashMap<String, RadioGroup> m_statButtonGroups = new HashMap<String, RadioGroup>();
	private Button m_resetAttrs;
	private Spinner m_nameSpinner;
	
	public BetrayalCharSheetActivity() {
		createCharacters();
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.layout);

		ArrayAdapter<String> aa = 
				new ArrayAdapter<String>(getWindow().getContext(),
		android.R.layout.simple_spinner_item, this.names);
		aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		m_nameSpinner = (Spinner)findViewById(R.id.nameSpinner);
		m_nameSpinner.setAdapter(aa);
		m_nameSpinner.setOnItemSelectedListener(this);
		
		m_resetAttrs = (Button)findViewById(R.id.resetAttrs);
		m_resetAttrs.setOnClickListener(this);
		

		RadioGroup tmp = (RadioGroup)findViewById(R.id.speedGroup);
		m_statButtonGroups.put(statNames[0], tmp);
		tmp = (RadioGroup)findViewById(R.id.mightGroup);
		m_statButtonGroups.put(statNames[1], tmp);
		tmp = (RadioGroup)findViewById(R.id.sanityGroup);
		m_statButtonGroups.put(statNames[2], tmp);
		tmp = (RadioGroup)findViewById(R.id.knowledgeGroup);
		m_statButtonGroups.put(statNames[3], tmp);
	}
	
	@Override
	public void onItemSelected(AdapterView<?> parent, View view, 
            int pos, long id) {
		Object obj = parent.getItemAtPosition(pos);
		if(obj != null) {
			loadInitialStateForCharacter(obj.toString());
		}
    }
	
	@Override
	public void onNothingSelected(AdapterView<?> arg0){	}
	
	@Override
	public void onClick(View v) {
		if(v == m_resetAttrs) {
			final String name = m_nameSpinner.getSelectedItem().toString();
			loadInitialStateForCharacter(name);
		}
	}

	@Override
	protected void onResume() {
		super.onResume();
	}

	@Override
	public void onPause() {
		super.onPause();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
	}
	
	private void loadInitialStateForCharacter(final String charName) {
		final Character c = m_characterStats.get(charName);
		for(int i = 0; i < statNames.length; ++i)
		{
			String statname = statNames[i];
			int[] stats = c.stats.get(statname);
			RadioGroup rg = m_statButtonGroups.get(statname);
			final int childCount = rg.getChildCount();
			final int initialStatIndex = c.initialStatIndexes.get(statname);

			for(int j = 0; j < stats.length; ++j)
			{
				RadioButton rb = (RadioButton)rg.getChildAt(childCount-j-1);
				rb.setText(Integer.toString(stats[j]));
				if(j == initialStatIndex) {
					rb.toggle();
				}
			}
		}
	}
	
	private void createCharacters() {
		Character tmp = null; 
		for(int i = 0; i < names.length; ++i) {
			tmp = new Character();
			tmp.name = names[i];
			tmp.hobbies = hobbies[i];
			tmp.birthday = birthdays[i];
			tmp.age = ages[i];
			tmp.height = heights[i];
			tmp.weight = weights[i];
			for(int j = 0; j < statNames.length; ++j) {
				tmp.initialStatIndexes.put(statNames[j], initialStatIndexes[i][j]);
				tmp.stats.put(statNames[j], stats[i][j]);
			}
			m_characterStats.put(names[i], tmp);
		}
	}
	
	//From here down is data:
	private final int maxStatIndex = 7;
	private final int maxStatNameIndex = 3;
	private final int maxCharacters = 12;
	
	private final String[] names = {
			"Heather", "Jenny",
			"Peter", "Brandon",
			"Professor", "Father",
			"Vivian", "Madame",
			"Ox", "Darrin",
			"Zoe", "Missy"
	};
	private final String[] birthdays = { 
			"August 2nd", "March 4th",
			"September 3rd", "May 21st",
			"July 27th", "April 29th",
			"January 11th", "December 10th",
			"October 18th", "June 6th",
			"November 5th", "February 14th"
	};
	private int[] ages = {
			18, 21,
			13, 12,
			57, 62,
			42, 37,
			23, 20,
			8, 9
	};
	private final String[] heights = {
		"5'2\"", "5'7\"",
		"4'11\"", "5'1\"",
		"5'11\"", "5'9\"",
		"5'5\"", "5'0\"",
		"6'4\"", "5'11\"",
		"3'9\"", "4'2\""
	};
	private final String[] hobbies = {
		"Television, Shopping", "Reading, Soccer",
		"Bugs, Basketball", "Computers, Camping, Hockey",
		"Gaelic Music, Drama, Fine Wines", "Fencing, Gardening",
		"Old Movies, Horses", "Astrology, Cooking, Baseball",
		"Football, Shiny Objects", "Track, Music, Shakesperean Literature",
		"Dolls, Music", "Swimming, Medicine"
	};
	private final int[] weights = {
			//In lbs:
			120, 142,
			98, 109,
			153, 185,
			142, 150,
			288, 188,
			49, 62
	};

	private final String[] statNames = { "Speed", "Might", "Sanity", "Knowledge" };
	private final int[][] initialStatIndexes = {
			{ //Heather
				2,2,2,4
			},
			{ //Jenny
				3,2,4,2
			},
			{ //Peter
				3,2,3,2
			},
			{ //Brandon
				2,3,3,2
			},
			{ //Professor
				3,2,2,4
			},
			{ //Father
				2,2,4,3
			},
			{ //Viv
				3,2,2,3
			},
			{ //Madame
				2,3,2,3
			},
			{ //Ox
				4,2,2,2
			},
			{ //Darrin
				4,2,2,2
			},
			{ //Zoe
				3,3,2,2
			},
			{ //Missy
				2,3,2,3
			}
	};
	private final int[][][] stats = {
			{ //Heather
				{3,3,4,5,6,6,7,8},
				{3,3,3,4,5,6,7,8},
				{3,3,3,4,5,6,6,6},
				{2,3,3,4,5,6,7,8}
			},
			{ //Jenny
				{2,3,4,4,4,5,6,8},
				{3,4,4,4,4,5,6,8},
				{1,1,2,4,4,4,5,6},
				{2,3,3,4,4,5,6,8}
			},
			{ //Peter
				{3,3,3,4,6,6,7,7},
				{2,3,3,4,5,5,6,8},
				{3,4,4,4,5,6,6,7},
				{3,4,4,5,6,7,7,8}
			},
			{ //Brandon
				{3,4,4,4,5,6,7,8},
				{2,3,3,4,5,6,6,7},
				{3,3,3,4,5,6,7,8},
				{1,3,3,5,5,6,6,7}
			},
			{ //Professor
				{2,2,4,4,5,5,6,6},
				{1,2,3,4,5,5,6,6},
				{1,3,3,4,5,5,6,7},
				{4,5,5,5,5,6,7,8}
			},
			{ //Father
				{2,3,3,4,5,6,7,7},
				{1,2,2,4,4,5,5,7},
				{3,4,5,5,6,7,7,8},
				{1,3,3,4,5,6,6,8}
			},
			{ //Viv
				{3,4,4,4,4,6,7,8},
				{2,2,2,4,4,5,6,6},
				{4,4,4,5,6,7,8,8},
				{4,5,5,5,5,6,6,7}
			},
			{ //Madame
				{2,3,3,5,5,6,6,7},
				{2,3,3,4,5,5,5,6},
				{4,4,4,5,6,7,8,8},
				{1,3,4,4,4,5,6,6}
			},
			{ //Ox
				{2,2,2,3,4,5,5,6},
				{4,5,5,6,6,7,8,8},
				{2,2,3,4,5,5,6,7},
				{2,2,3,3,5,5,6,6}
			},
			{ //Darrin
				{4,4,4,5,6,7,7,8},
				{2,3,3,4,5,6,6,7},
				{1,2,3,4,5,5,5,7},
				{2,3,3,4,5,5,5,7}
			},
			{ //Zoe
				{4,4,4,4,5,6,8,8},
				{2,2,3,3,4,4,6,7},
				{3,4,5,5,6,6,7,8},
				{1,2,3,4,4,5,5,5}
			},
			{ //Missy
				{3,4,5,6,6,6,7,7},
				{2,3,3,3,4,5,6,7},
				{1,2,3,4,5,5,6,7},
				{2,3,4,4,5,6,6,6}
			}
	};
}
