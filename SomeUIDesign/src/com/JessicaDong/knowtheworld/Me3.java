package com.JessicaDong.knowtheworld;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class Me3 extends Activity{
	ImageButton back18;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_me3);
		back18 = (ImageButton) findViewById(R.id.back18);
		 back18.setScaleType(ImageView.ScaleType.FIT_XY);
	} 
	public void backclick18(View v)
	{
		//Intent it = new Intent(Release.this, TestWeiXinWhatsNewActivity.class);
		//startActivity(it);
		Log.i("click", "stop");
		Me3.this.finish();
	}
	public void me3click(View v)
	{
		Intent it = new Intent(Me3.this, Collec.class);
		startActivity(it);
		
		
	}
}