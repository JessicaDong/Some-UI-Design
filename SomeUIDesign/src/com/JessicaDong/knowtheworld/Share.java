package com.JessicaDong.knowtheworld;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;

public class Share extends Activity{
	
	ImageButton back2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		  requestWindowFeature(Window.FEATURE_NO_TITLE);// ÃÓ≥‰±ÍÃ‚¿∏
		setContentView(R.layout.activity_share);
		back2 = (ImageButton) findViewById(R.id.back2);
		 back2.setScaleType(ImageView.ScaleType.FIT_XY);
		 Log.i("click", "1");
	} 
	public void backclick2(View v)
	{
		//Intent it = new Intent(Release.this, TestWeiXinWhatsNewActivity.class);
		//startActivity(it);
		Log.i("click", "stop");
		Share.this.finish();
	}
	
	public void begindetail3(View v)
	{
		Intent it = new Intent(Share.this, Collec.class);
		startActivity(it);
		Log.i("click", "stop");
		//Release.this.finish();
	}
	}


