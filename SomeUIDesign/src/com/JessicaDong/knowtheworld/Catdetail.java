package com.JessicaDong.knowtheworld;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class Catdetail extends Activity {
	ImageButton back20;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		  requestWindowFeature(Window.FEATURE_NO_TITLE);// ÃÓ≥‰±ÍÃ‚¿∏
		setContentView(R.layout.activity_catdetail);
		back20 = (ImageButton) findViewById(R.id.back20);
		 back20.setScaleType(ImageView.ScaleType.FIT_XY);
}
	public void backclick20(View v)
	{
		//Intent it = new Intent(Release.this, TestWeiXinWhatsNewActivity.class);
		//startActivity(it);
		Log.i("click", "stop");
		Catdetail.this.finish();
	}

	public void todetail(View v)
	{
		Intent it = new Intent(Catdetail.this, Collec.class);
	    startActivity(it);
		
	}
}
