package com.JessicaDong.knowtheworld;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.Toast;

public class Me555 extends Activity{
	ImageButton back18;
	// private static final String[] m={"ɾ��","ȡ��"}; 
	 private Spinner spinnerdelete;
	private ArrayList<String> list;
	private MyspinnerAdapter adapter;
	private PopupWindow popupWindow;
	private LinearLayout layout;
	private ListView listView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.activity_me2);
		setContentView(R.layout.activity_me555);
		Log.i("Me222", "oncreat");
		back18 = (ImageButton) findViewById(R.id.back18);
		 back18.setScaleType(ImageView.ScaleType.FIT_XY);
		 

		 list = new ArrayList<String>();
			list.add("ɾ��");
			list.add("ȡ��");
			// ʵ����һ����������list��������ΪAdapter������
			adapter = new MyspinnerAdapter(this, list);
		 
//		 // ��ʼ���ؼ�
//		 spinnerdelete=(Spinner)findViewById(R.id.spinnerdelete);     	
//	// ��������Դ
//	String[] mItems = getResources().getStringArray(R.array.me2spinner);
//	// ����Adapter���Ұ�����Դ
//	ArrayAdapter<String> _Adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, mItems);
//	//�� Adapter���ؼ�
//	spinnerdelete.setAdapter(_Adapter);
//	spinnerdelete.setOnItemSelectedListener(new OnItemSelectedListener() {
//		@Override
//		public void onItemSelected(AdapterView<?> parent, View view,
//				int position, long id) {
//			if(position==0) setContentView(R.layout.activity_me222);
//			else setContentView(R.layout.activity_me2);
//		}
//		@Override
//		public void onNothingSelected(AdapterView<?> parent) {
//			// TODO Auto-generated method stub
//		}
//		
//	});

	} 
	public void backclick18(View v)
	{
		//Intent it = new Intent(Release.this, TestWeiXinWhatsNewActivity.class);
		//startActivity(it);
		Log.i("click", "stop");
		Me555.this.finish();
	}
	
	@SuppressWarnings("deprecation")
	public void showWindowme2(View v) {
		Log.i("addicon", "showview2");
		// 找到布局文件
		layout = (LinearLayout) LayoutInflater.from(this).inflate(R.layout.mypinner_dropdown, null);
		//layout.setBackgroundColor(R.color.white);
	
		listView = (ListView) layout.findViewById(R.id.listView);
		//listView.setBackgroundColor(R.color.white);
		// 设置listView的�?配器
		//listView.setAdapter(adapter);
		listView.setAdapter(adapter);
		
		// 实例化一个PopuWindow对象
		popupWindow = new PopupWindow(v);
		
		// 设置弹框的宽度为布局文件的宽
		popupWindow.setWidth(180);
		// 高度随着内容变化
		popupWindow.setHeight(LayoutParams.WRAP_CONTENT);
		// 设置�?��透明的背景，不然无法实现点击弹框外，弹框消失
		popupWindow.setBackgroundDrawable(new BitmapDrawable());
		// 设置点击弹框外部，弹框消�?
		popupWindow.setOutsideTouchable(true);
		// 设置焦点
		popupWindow.setFocusable(true);
		// 设置�?��布局
		popupWindow.setContentView(layout);
		// 设置弹框出现的位置，在v的正下方横轴偏移textview的宽度，为了对齐~纵轴不偏�?
		popupWindow.showAsDropDown(v, 200, 0);
		// listView的item点击事件
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
				// TODO Auto-generated method stub
				
				// 弹框消失
				switch( arg2)
				{
		    	
		    	case 0: 
		    	{
		    		Intent it1 = new Intent(Me555.this, Me5555.class);
		    		startActivity(it1);Me555.this.finish();break;
		    	}
		    	case 1: 
		    	{
		    		
		    	}
		    	
		    	};
				popupWindow.dismiss();
				popupWindow = null;
			}
		});

	}
	
}
