package com.JessicaDong.knowtheworld;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;

public class Myaccount extends Activity{
	ImageButton back13;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		  requestWindowFeature(Window.FEATURE_NO_TITLE);// ��������
		setContentView(R.layout.activity_myaccount);
		back13 = (ImageButton) findViewById(R.id.back13);
		 back13.setScaleType(ImageView.ScaleType.FIT_XY);
	} 
	public void backclick13(View v)
	{
		//Intent it = new Intent(Release.this, TestWeiXinWhatsNewActivity.class);
		//startActivity(it);
		Log.i("click", "stop");
		Myaccount.this.finish();
	}
}
