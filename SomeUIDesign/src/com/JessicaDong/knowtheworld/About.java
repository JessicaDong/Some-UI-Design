package com.JessicaDong.knowtheworld;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;

public class About extends Activity{
	ImageButton back18;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		  requestWindowFeature(Window.FEATURE_NO_TITLE);// ��������
		setContentView(R.layout.activity_about);
		back18 = (ImageButton) findViewById(R.id.back18);
		 back18.setScaleType(ImageView.ScaleType.FIT_XY);
	} 
	public void backclick18(View v)
	{
		//Intent it = new Intent(Release.this, TestWeiXinWhatsNewActivity.class);
		//startActivity(it);
		Log.i("click", "stop");
		About.this.finish();
	}
}
