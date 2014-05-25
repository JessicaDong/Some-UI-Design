package com.JessicaDong.knowtheworld;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;





import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import android.widget.PopupWindow;
import android.widget.AdapterView.OnItemClickListener;
public class Sear extends Activity {

	
	private ArrayList<String> list;
	private ArrayList<String> list2;
	private View imgView;
	private TextView textView;
	private LinearLayout layout;
	private ListView listView;
	private MyspinnerAdapter adapter;
	private MyspinnerAdapter adapter2;
	private PopupWindow popupWindow;
	private LinearLayout spinnerlayout;
	private RelativeLayout parentLayout;
	private TextView textview3;
	int width;
	private EditText editText;
	private final static int Requestcode = 2;
	private GridView gridView;
	//private Spinner distance = null;// 要读取的下拉列表
	//private ArrayAdapter<String> distanceadapter = null;// 要使用的Adapter
	// private String[] dislist = new String[] {"1000�?,"5000�?,"10000�?};
	// PopupWindow popupWindow;
	// private Spinner spinneradd;  
	// Myadapter myadapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		  requestWindowFeature(Window.FEATURE_NO_TITLE);// ��������
		setContentView(R.layout.activity_sear);
		textview3=(TextView)findViewById(R.id.textview3);	
		textView = (TextView) findViewById(R.id.text);
		parentLayout=(RelativeLayout)findViewById(R.id.parentlayout);
		imgView = findViewById(R.id.arrowbut);
		// 实例化一个List,添加数据
		list = new ArrayList<String>();
		list.add("5km");
		list.add("10km");
		list.add("25km");
		// 实例化一个�?配器，list的数据作为Adapter的数�?
		adapter = new MyspinnerAdapter(this, list);
		// 默认设置下拉框的标题为数据的第一�?
		textView.setText((CharSequence) adapter.getItem(0));
		spinnerlayout = (LinearLayout) findViewById(R.id.spinnerid);
		// 点击右侧按钮，弹出下拉框
		imgView.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				showWindow(v);

			}
		});
		
		list2 = new ArrayList<String>();
		list2.add("����");
		list2.add("�Ϻ�");
		list2.add("����");
		list2.add("����");
		list2.add("�ɶ�");
		list2.add("����");
		// 实例化一个�?配器，list的数据作为Adapter的数�?
		adapter2 = new MyspinnerAdapter(this, list2);
		// 默认设置下拉框的标题为数据的第一�?
		textview3.setText((CharSequence) adapter2.getItem(0));
		//spinnerlayout = (LinearLayout) findViewById(R.id.spinnerid);
	}

	
	@SuppressWarnings("deprecation")
	public void showWindow(View v) {
		// 找到布局文件
		layout = (LinearLayout) LayoutInflater.from(this).inflate(R.layout.mypinner_dropdown, null);
		// 实例化listView
		listView = (ListView) layout.findViewById(R.id.listView);
		// 设置listView的�?配器
		listView.setAdapter(adapter);
		// 实例化一个PopuWindow对象
		popupWindow = new PopupWindow(v);
		// 设置弹框的宽度为布局文件的宽
		popupWindow.setWidth(spinnerlayout.getWidth());
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
		popupWindow.showAsDropDown(v, -textView.getWidth(), 0);
		// listView的item点击事件
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
				// TODO Auto-generated method stub
				textView.setText(list.get(arg2));// 设置�??的item作为下拉框的标题
				// 弹框消失
				
				
			 /*
				switch( arg2)
				 
				{
		    	
		    	case 0: 
		    	{
		    		Intent it1 = new Intent(Sear.this, Friendadd.class);
		    		startActivity(it1);break;
		    	}
		    	case 1: 
		    	{
		    		Intent it2 = new Intent(Sear.this, Friendlist.class);
		    		startActivity(it2);break;
		    	}
		    	case 2: 
		    	{
		    		Intent it3 = new Intent(Sear.this, Friendmanagement.class);
		    		startActivity(it3);break;
		    	}
		    	};
		    	*/
				popupWindow.dismiss();
				popupWindow = null;
			}
		});

	}
	
	@SuppressWarnings("deprecation")
	public void showcity1(View v) {
		// 找到布局文件
		layout = (LinearLayout) LayoutInflater.from(this).inflate(R.layout.myspinner_dropdown2, null);
		// 实例化listView
		gridView = (GridView) layout.findViewById(R.id.gridView1);
		// 设置listView的�?配器
		gridView.setAdapter(adapter2);
		// 实例化一个PopuWindow对象
		popupWindow = new PopupWindow(v);
		// 设置弹框的宽度为布局文件的宽
		//popupWindow.setWidth(spinnerlayout.getWidth());
		popupWindow.setWidth(parentLayout.getWidth());
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
		popupWindow.showAsDropDown(v, -textView.getWidth(), 0);
		// listView的item点击事件
		gridView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
				// TODO Auto-generated method stub
				// 设置�??的item作为下拉框的标题
				if(arg2==5) showcity(arg1);
				else textview3.setText(list2.get(arg2));
				
				popupWindow.dismiss();
				popupWindow = null;
			}
		});

	}

	
//	public void beginhot3(View v) {
//		Intent it = new Intent(Sear.this, TestWeiXinWhatsNewActivity.class);
//
//		startActivity(it);
//		// MainActivity.this.finish();
//	}
//
//	public void begincat3(View v) {
//		Intent it = new Intent(Sear.this, Cat.class);
//
//		startActivity(it);
//		// MainActivity.this.finish();
//	}
//
//	public void beginsear3(View v) {
//		Intent it = new Intent(Sear.this, Sear.class);
//
//		startActivity(it);
//		// MainActivity.this.finish();
//	}
//
	public void tohome4(View v) {
//		Intent it = new Intent(Sear.this, TestWeiXinWhatsNewActivity.class);
//
//		startActivity(it);
		Sear.this.finish();
		// MainActivity.this.finish();
	}
	public void showcity(View v) {
		Intent it1 = new Intent(Sear.this,CityList.class);	
		startActivityForResult(it1, Requestcode);
	}
	protected void onActivityResult(int requestCode,int resultCode,Intent data)
    {
    	super.onActivityResult(requestCode, resultCode, data);
    	if (resultCode==RESULT_OK) {
    		if(requestCode==Requestcode){
    			textview3.setText(data.getStringExtra("Cityname1"));
    		}
			
		}
    }

}
