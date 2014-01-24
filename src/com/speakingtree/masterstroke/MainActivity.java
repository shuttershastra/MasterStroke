package com.speakingtree.masterstroke;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import com.actionbarsherlock.app.ActionBar.Tab;


public class MainActivity extends BaseActivity {
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	
	@Override
    public void onTabSelected(Tab tab, FragmentTransaction transaction) {      	
		if (tab.getPosition() != 0)
    		super.onTabSelected(tab, transaction);
    }
	
	public void openTestimonials(View view) {
    	Intent intent = new Intent(this, TestimonialsActivity.class);
        startActivity(intent);
    }
	
	public void openPictures(View view) {
    	Intent intent = new Intent(this, PhotosActivity.class);
        startActivity(intent);
    }
	
	public void openVideos(View view) {
    	Intent intent = new Intent(this, VideosActivity.class);
        startActivity(intent);
    }
	
	public void openMasterSutra(View view) {
    	Intent intent = new Intent(this, MasterSutraActivity.class);
        startActivity(intent);
    }
	
	public void openMasterJourney(View view) {
    	Intent intent = new Intent(this, MasterJourneyActivity.class);
        startActivity(intent);
    }
	
	public void openEvents(View view) {
    	Intent intent = new Intent(this, EventsActivity.class);
        startActivity(intent);
    }
	
	public void openMasterStroke(View view) {
    	Intent intent = new Intent(this, MasterStrokeActivity.class);
        startActivity(intent);
    }
}
