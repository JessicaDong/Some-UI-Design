package com.JessicaDong.knowtheworld;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;

public class Seetings extends Activity{
	
	ImageButton back12;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		  requestWindowFeature(Window.FEATURE_NO_TITLE);// ÃÓ≥‰±ÍÃ‚¿∏
		setContentView(R.layout.activity_settings);
		back12 = (ImageButton) findViewById(R.id.back12);
		 back12.setScaleType(ImageView.ScaleType.FIT_XY);
	} 
	
	public void backclick12(View v)
	{
		//Intent it = new Intent(Release.this, TestWeiXinWhatsNewActivity.class);
		//startActivity(it);
		Log.i("click", "stop");
		Seetings.this.finish();
	}
	public void setclick1(View v)
	{
		Intent it = new Intent(Seetings.this, Myaccount.class);
		startActivity(it);
		//Log.i("click", "stop");s
	//	Seetings.this.finish();
	}
	public void setclick2(View v)
	{
		Intent it = new Intent(Seetings.this, Recommend.class);
		startActivity(it);
		//Log.i("click", "stop");s
	//	Seetings.this.finish();
	}
	public void setclick3(View v)
	{
		Intent it = new Intent(Seetings.this, Infomanagement.class);
		startActivity(it);
		//Log.i("click", "stop");s
	//	Seetings.this.finish();
	}
	public void setclick4(View v)
	{
		Intent it = new Intent(Seetings.this, Renew.class);
		startActivity(it);
		//Log.i("click", "stop");s
	//	Seetings.this.finish();
	}
	public void setclick5(View v)
	{
		Intent it = new Intent(Seetings.this, Services.class);
		startActivity(it);
		//Log.i("click", "stop");s
	//	Seetings.this.finish();
	}
	public void setclick6(View v)
	{
		Intent it = new Intent(Seetings.this, About.class);
		startActivity(it);
		//Log.i("click", "stop");s
	//	Seetings.this.finish();
	}
	public void setclick7(View v)
	{
		//Intent it = new Intent(Seetings.this, TestWeiXinWhatsNewActivity.class);
		//startActivity(it);
		//Log.i("click", "stop");s
		Seetings.this.finish();
	}
	
}
