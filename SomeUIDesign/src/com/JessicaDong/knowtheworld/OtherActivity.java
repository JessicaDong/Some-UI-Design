package com.JessicaDong.knowtheworld;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

public class OtherActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		  requestWindowFeature(Window.FEATURE_NO_TITLE);// ÃÓ≥‰±ÍÃ‚¿∏
		setContentView(R.layout.other);
	}
	
}
