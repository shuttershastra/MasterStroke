package com.speakingtree.masterstroke;

import android.os.Bundle;

public class MasterStrokeActivity extends BaseListActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pictures);
		init = true;
	}

}
