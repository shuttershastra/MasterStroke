package com.speakingtree.masterstroke;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.widget.TabHost;

import com.actionbarsherlock.app.ActionBar.Tab;

public class ConnectActivity extends BaseActivity {
	private boolean init = false;
	private TabHost mTabHost;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getSupportActionBar().setSelectedNavigationItem(2);
		
		setContentView(R.layout.activity_connect);
		final TabHost th = (TabHost)findViewById(R.id.tabhost);
		th.setCurrentTab(0);
		init = true;
	}
	
	@Override
    public void onTabSelected(Tab tab, FragmentTransaction transaction) {      	
    	if (init && tab.getPosition() != 2)
    		super.onTabSelected(tab, transaction);
    }


}
