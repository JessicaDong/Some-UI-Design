package com.JessicaDong.knowtheworld;

import android.os.Bundle;
import android.R.integer;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;


public class Comment extends Activity{
	
	ImageButton back3;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		  requestWindowFeature(Window.FEATURE_NO_TITLE);// ��������
		setContentView(R.layout.activity_comment);
		back3 = (ImageButton) findViewById(R.id.back3);
		 back3.setScaleType(ImageView.ScaleType.FIT_XY);
		 Log.i("click", "1");
	} 
	public void backclick3(View v)
	{
		//Intent it = new Intent(Release.this, TestWeiXinWhatsNewActivity.class);
		//startActivity(it);
		Log.i("click", "stop");
		Comment.this.finish();
	}
	
	public void begindetail4(View v)
	{
		//Intent it = new Intent(Release.this, TestWeiXinWhatsNewActivity.class);
		//startActivity(it);
		
			Intent it = new Intent(Comment.this, Collec.class);
			startActivity(it);
			Log.i("click", "stop");
			//Release.this.finish();
		
	}
	}

