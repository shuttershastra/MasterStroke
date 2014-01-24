package com.speakingtree.masterstroke;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import com.actionbarsherlock.app.ActionBar.Tab;

public class SignInActivity extends BaseActivity {
	private boolean init = false;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getSupportActionBar().setSelectedNavigationItem(1);
		setContentView(R.layout.activity_sign_in);	

//		mPlusClient = new PlusClient.Builder(this, this, this)
//		.setActions("http://schemas.google.com/AddActivity", "http://schemas.google.com/BuyActivity")
//		.build();
		//findViewById(R.id.sign_in_button).setOnClickListener(this);	
		init = true;
	}
	
	@Override
    public void onTabSelected(Tab tab, FragmentTransaction transaction) {      	
    	if (init && tab.getPosition() != 1)
    		super.onTabSelected(tab, transaction);
    }
	
//	@Override
//	public void onClick(View view) {
//		if (view.getId() == R.id.sign_in_button && !mPlusClient.isConnected()) {
//			if (mConnectionResult == null) {
//				mConnectionProgressDialog.show();
//			} else {
//				try {
//					mConnectionResult.startResolutionForResult(this, REQUEST_CODE_RESOLVE_ERR);
//				} catch (SendIntentException e) {
//					// Try connecting again.
//					mConnectionResult = null;
//					mPlusClient.connect();
//				}
//			}
//		}
//	}
	
//	@Override
//	public void onConnected(Bundle connectionHint) {
//		mConnectionProgressDialog.dismiss();
//		Toast.makeText(this, "User is connected!", Toast.LENGTH_LONG).show();
//	}
}
