package com.JessicaDong.knowtheworld;

import javax.xml.datatype.Duration;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class Somecomment extends Activity {
	ImageButton back7;
	private Context context;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		  requestWindowFeature(Window.FEATURE_NO_TITLE);// 填充标题栏
		setContentView(R.layout.activity_somecomment);
		back7 = (ImageButton) findViewById(R.id.back7);
		 back7.setScaleType(ImageView.ScaleType.FIT_XY);
		
	} 
	public void backclick7(View v)
	{
		//Intent it = new Intent(Release.this, TestWeiXinWhatsNewActivity.class);
		//startActivity(it);
		Log.i("click", "stop");
		Somecomment.this.finish();
	}
	public void send2(View v)
	{
		Toast.makeText(Somecomment.this, "发布成功",Toast.LENGTH_SHORT).show();
	}
}
