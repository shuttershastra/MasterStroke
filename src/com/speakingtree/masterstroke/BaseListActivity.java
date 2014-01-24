package com.speakingtree.masterstroke;

import android.content.Intent;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockListActivity;
import com.actionbarsherlock.app.ActionBar.Tab;

public class BaseListActivity extends SherlockListActivity implements ActionBar.TabListener {
	protected boolean init = false;
	private final static int NUM_CATEGORIES = 4;
	
	@Override
    public void onTabReselected(Tab tab, FragmentTransaction transaction) {
    }

    @Override
    public void onTabSelected(Tab tab, FragmentTransaction transaction) {
    	if (!init) return;
    	
    	switch(tab.getPosition()) {
	    	case 0:
	    		Intent intent = new Intent(this, MainActivity.class);
	    		startActivity(intent);
	    		break;
	    	case 1:
	    		Intent interact_intent = new Intent(this, SignInActivity.class);
	    		startActivity(interact_intent);
	    		break;
	    	case 2:
	    		Intent connect_intent = new Intent(this, ConnectActivity.class);
	    		startActivity(connect_intent);
	    		break;
	    	case 3:
	    		Intent customize_intent = new Intent(this, CustomizeActivity.class);
	    		startActivity(customize_intent);
	    		break;
    	}
    }

    @Override
    public void onTabUnselected(Tab tab, FragmentTransaction transaction) {
    }

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		getSupportActionBar().setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        for (int i = 0; i < NUM_CATEGORIES; i++) {
            ActionBar.Tab tab = getSupportActionBar().newTab();
            tab.setText(BaseActivity.getTabTitle(i));
            tab.setTabListener(this);
            getSupportActionBar().addTab(tab);
        }
        
      //This is a workaround for http://b.android.com/15340 from http://stackoverflow.com/a/5852198/132047
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.ICE_CREAM_SANDWICH) {
            BitmapDrawable bg = (BitmapDrawable)getResources().getDrawable(R.drawable.bg_striped);
            bg.setTileModeXY(TileMode.REPEAT, TileMode.REPEAT);
            getSupportActionBar().setBackgroundDrawable(bg);

            BitmapDrawable bgSplit = (BitmapDrawable)getResources().getDrawable(R.drawable.bg_striped_split_img);
            bgSplit.setTileModeXY(TileMode.REPEAT, TileMode.REPEAT);
            getSupportActionBar().setSplitBackgroundDrawable(bgSplit);
        }

		init = true;
	}

}
