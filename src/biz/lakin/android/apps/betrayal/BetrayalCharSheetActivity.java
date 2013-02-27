package biz.lakin.android.apps.betrayal;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

public class BetrayalCharSheetActivity extends Activity {

	private ArrayList<View> speedButtons = new ArrayList<View>();
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
