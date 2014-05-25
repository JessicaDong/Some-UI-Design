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
	// private static final String[] m={"删除","取消"}; 
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
			list.add("删除");
			list.add("取消");
			// 实例化一个适配器，list的数据作为Adapter的数据
			adapter = new MyspinnerAdapter(this, list);
		 
//		 // 初始化控件
//		 spinnerdelete=(Spinner)findViewById(R.id.spinnerdelete);     	
//	// 建立数据源
//	String[] mItems = getResources().getStringArray(R.array.me2spinner);
//	// 建立Adapter并且绑定数据源
//	ArrayAdapter<String> _Adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, mItems);
//	//绑定 Adapter到控件
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
		// 鎵惧埌甯冨眬鏂囦欢
		layout = (LinearLayout) LayoutInflater.from(this).inflate(R.layout.mypinner_dropdown, null);
		//layout.setBackgroundColor(R.color.white);
	
		listView = (ListView) layout.findViewById(R.id.listView);
		//listView.setBackgroundColor(R.color.white);
		// 璁剧疆listView鐨勯?閰嶅櫒
		//listView.setAdapter(adapter);
		listView.setAdapter(adapter);
		
		// 瀹炰緥鍖栦竴涓狿opuWindow瀵硅薄
		popupWindow = new PopupWindow(v);
		
		// 璁剧疆寮规鐨勫搴︿负甯冨眬鏂囦欢鐨勫
		popupWindow.setWidth(180);
		// 楂樺害闅忕潃鍐呭鍙樺寲
		popupWindow.setHeight(LayoutParams.WRAP_CONTENT);
		// 璁剧疆涓?釜閫忔槑鐨勮儗鏅紝涓嶇劧鏃犳硶瀹炵幇鐐瑰嚮寮规澶栵紝寮规娑堝け
		popupWindow.setBackgroundDrawable(new BitmapDrawable());
		// 璁剧疆鐐瑰嚮寮规澶栭儴锛屽脊妗嗘秷澶?
		popupWindow.setOutsideTouchable(true);
		// 璁剧疆鐒︾偣
		popupWindow.setFocusable(true);
		// 璁剧疆鎵?湪甯冨眬
		popupWindow.setContentView(layout);
		// 璁剧疆寮规鍑虹幇鐨勪綅缃紝鍦╲鐨勬涓嬫柟妯酱鍋忕Щtextview鐨勫搴︼紝涓轰簡瀵归綈~绾佃酱涓嶅亸绉?
		popupWindow.showAsDropDown(v, 200, 0);
		// listView鐨刬tem鐐瑰嚮浜嬩欢
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
				// TODO Auto-generated method stub
				
				// 寮规娑堝け
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
