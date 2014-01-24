package com.speakingtree.masterstroke;

import android.os.Bundle;

import com.actionbarsherlock.app.SherlockActivity;

public class VideoActivity extends SherlockActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_video);
		// Show the Up button in the action bar.
		getSupportActionBar();
	}

}
