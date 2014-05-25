package com.JessicaDong.knowtheworld;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class Hot2 extends Activity{
	ImageButton back25;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_hot2);
		back25 = (ImageButton) findViewById(R.id.back25);
		 back25.setScaleType(ImageView.ScaleType.FIT_XY);
		 
		
	} 
	
	public void backclick25(View v)
	{
		//Intent it = new Intent(Release.this, TestWeiXinWhatsNewActivity.class);
		//startActivity(it);
		Log.i("click", "stop");
		Hot2.this.finish();
	}

	public void todetail5(View v)
	{
		Intent it = new Intent(Hot2.this, Collec.class);
	    startActivity(it);
		
	}
}
