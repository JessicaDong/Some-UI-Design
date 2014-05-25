package com.JessicaDong.knowtheworld;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;

public class Friendmanagement extends Activity {
	ImageButton back7;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		  requestWindowFeature(Window.FEATURE_NO_TITLE);// ÃÓ≥‰±ÍÃ‚¿∏
		setContentView(R.layout.activity_friendmanagement);
		back7 = (ImageButton) findViewById(R.id.back7);
		 back7.setScaleType(ImageView.ScaleType.FIT_XY);
	} 
	
	public void backclick7(View v)
	{
		//Intent it = new Intent(Release.this, TestWeiXinWhatsNewActivity.class);
		//startActivity(it);
		Log.i("click", "stop");
		Friendmanagement.this.finish();
	}
}
