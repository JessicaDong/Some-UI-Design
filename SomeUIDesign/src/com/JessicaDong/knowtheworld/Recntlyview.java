package com.JessicaDong.knowtheworld;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;

public class Recntlyview extends Activity {
	ImageButton back10;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		  requestWindowFeature(Window.FEATURE_NO_TITLE);// ÃÓ≥‰±ÍÃ‚¿∏
		setContentView(R.layout.activity_recentview);
		back10 = (ImageButton) findViewById(R.id.back10);
		 back10.setScaleType(ImageView.ScaleType.FIT_XY);
	} 
	
	public void backclick10(View v)
	{
		//Intent it = new Intent(Release.this, TestWeiXinWhatsNewActivity.class);
		//startActivity(it);
		Log.i("click", "stop");
		Recntlyview.this.finish();
	}
	public void detailclick5(View v)
	{
		Intent it = new Intent(Recntlyview.this, Collec.class);
		startActivity(it);
		
	}

}
