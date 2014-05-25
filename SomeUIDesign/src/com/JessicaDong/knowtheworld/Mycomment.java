package com.JessicaDong.knowtheworld;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;

public class Mycomment extends Activity {
	ImageButton back9;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		  requestWindowFeature(Window.FEATURE_NO_TITLE);// ÃÓ≥‰±ÍÃ‚¿∏
		setContentView(R.layout.activity_mycomment);
		back9 = (ImageButton) findViewById(R.id.back9);
		 back9.setScaleType(ImageView.ScaleType.FIT_XY);
	} 
	
	public void backclick9(View v)
	{
		//Intent it = new Intent(Release.this, TestWeiXinWhatsNewActivity.class);
		//startActivity(it);
		Log.i("click", "stop");
		Mycomment.this.finish();
	}

}
