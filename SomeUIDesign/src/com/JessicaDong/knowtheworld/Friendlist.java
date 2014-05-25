package com.JessicaDong.knowtheworld;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;

public class Friendlist extends Activity {
	ImageButton back6;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		  requestWindowFeature(Window.FEATURE_NO_TITLE);// ÃÓ≥‰±ÍÃ‚¿∏
		setContentView(R.layout.activity_friendlist);
		back6 = (ImageButton) findViewById(R.id.back6);
		 back6.setScaleType(ImageView.ScaleType.FIT_XY);
		
	} 
	public void backclick6(View v)
	{
		//Intent it = new Intent(Release.this, TestWeiXinWhatsNewActivity.class);
		//startActivity(it);
		Log.i("click", "stop");
		Friendlist.this.finish();
	}
	public void group2(View v)
	{
		Intent it = new Intent(Friendlist.this, Friendgroup.class);
		startActivity(it);
		//Log.i("click", "stop");
		//Friendlist.this.finish();
	}
}
