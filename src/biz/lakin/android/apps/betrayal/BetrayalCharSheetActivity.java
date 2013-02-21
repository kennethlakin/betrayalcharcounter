package biz.lakin.android.apps.betrayal;

import android.app.Activity;
import android.os.Bundle;

public class BetrayalCharSheetActivity extends Activity {
	
	private final int maxStatIndex = 7;
	private final int maxStatNameIndex = 3;
	private String[] names = {
			"Heather", "Jenny",
			"Peter", "Brandon",
			"Professor", "Father",
			"Vivian", "Madame",
			"Ox", "Darrin",
			"Zoe", "Missy"
	};
	private String[] statNames = { "Speed", "Might", "Sanity", "Knowledge" };
	private int[][][] charStats = {
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

	public BetrayalCharSheetActivity() {
		
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		/*
		 * Layout:
		 * | Scrollable list of char names
		 * | Hobbies, DOB
		 * | speed, might, san, knowl +/- buttons, vertical 
		 * | speed, might, san, knowl radio button columns to indicate 
		 * |   current value and ticks till top or bottom.
		 * |
		 * 
		 */
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.layout);
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

}
