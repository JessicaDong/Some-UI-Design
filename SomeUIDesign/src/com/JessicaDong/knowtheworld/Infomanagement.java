package com.JessicaDong.knowtheworld;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;

public class Infomanagement extends Activity{
	ImageButton back15;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		  requestWindowFeature(Window.FEATURE_NO_TITLE);// ÃÓ≥‰±ÍÃ‚¿∏
		setContentView(R.layout.activity_infomanagement);
		back15 = (ImageButton) findViewById(R.id.back15);
		 back15.setScaleType(ImageView.ScaleType.FIT_XY);
	} 
	public void backclick15(View v)
	{
		//Intent it = new Intent(Release.this, TestWeiXinWhatsNewActivity.class);
		//startActivity(it);
		Log.i("click", "stop");
		Infomanagement.this.finish();
	}
}
