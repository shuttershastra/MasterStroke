package com.speakingtree.masterstroke;

import android.content.Intent;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.widget.TextView;
import android.widget.Toast;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.ActionBar.Tab;
import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.actionbarsherlock.view.SubMenu;

public class BaseActivity extends SherlockActivity implements ActionBar.TabListener {
	public static int THEME = R.style.Theme_Sherlock;
	private final static int NUM_CATEGORIES = 4;
	protected TextView mSelected;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
        getSupportActionBar().setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        for (int i = 0; i < NUM_CATEGORIES; i++) {
            ActionBar.Tab tab = getSupportActionBar().newTab();
            tab.setText(getTabTitle(i));
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
	}
	
	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        SubMenu sub = menu.addSubMenu("Theme");
        sub.add(0, R.style.Theme_Sherlock, 0, "Default");
        sub.add(0, R.style.Theme_Sherlock_Light, 0, "Light");
        sub.add(0, R.style.Theme_Sherlock_Light_DarkActionBar, 0, "Light (Dark Action Bar)");
        sub.getItem().setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS | MenuItem.SHOW_AS_ACTION_WITH_TEXT);
        return true;
    }	

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home || item.getItemId() == 0) {
            return false;
        }
        THEME = item.getItemId();
        Toast.makeText(this, "Theme changed to \"" + item.getTitle() + "\"", Toast.LENGTH_SHORT).show();
        return true;
    }
    
	@Override
    public void onTabReselected(Tab tab, FragmentTransaction transaction) {
    }

    @Override
    public void onTabSelected(Tab tab, FragmentTransaction transaction) {
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

    public final static String getTabTitle(int index) {
    	final String[] category = { "Explore", "Interact", "Connect", "Customize" };
        return category[index];
    }
}
