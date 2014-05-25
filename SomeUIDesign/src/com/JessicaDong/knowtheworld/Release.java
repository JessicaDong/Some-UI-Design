package com.JessicaDong.knowtheworld;

import android.os.Bundle;
import android.R.integer;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;


public class Release extends Activity{
	public ImageButton back1;

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		  requestWindowFeature(Window.FEATURE_NO_TITLE);// ÃÓ≥‰±ÍÃ‚¿∏
		setContentView(R.layout.activity_release);
		back1 = (ImageButton) findViewById(R.id.back1);
		 back1.setScaleType(ImageView.ScaleType.FIT_XY);
		 
		 Log.i("click", "1");
	} 
	public void back(View v)
	{
		//Intent it = new Intent(Release.this, TestWeiXinWhatsNewActivity.class);
		//startActivity(it);
		Log.i("click", "stop");
		Release.this.finish();
	}
	

	public void begindetail2(View v)
	{
		Intent it = new Intent(Release.this, Collec.class);
		startActivity(it);
		Log.i("click", "stop");
		//Release.this.finish();
	}
}
