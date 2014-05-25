package com.JessicaDong.knowtheworld;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;




import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;

public class Me2 extends Activity{
	ImageButton back18;
	private ListView mListView;
	private ListViewAdapter2 lvadapter2;
	
	private ImageView imageView;
    private int[] images = { R.drawable.post1, R.drawable.post2, R.drawable.post3,R.drawable.post4,R.drawable.post5 };
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.activity_me2);
		setContentView(R.layout.activity_me2);
		back18 = (ImageButton) findViewById(R.id.back18);
		 back18.setScaleType(ImageView.ScaleType.FIT_XY);
		 
		 mListView = (ListView) this.findViewById(R.id.list);
	        List<View> list = new ArrayList<View>();
//	        for(int i=0;i<10;i++){
//	        	list.add(R.drawable.posttitle);
//	        }
//	        //实例化自定义内容适配类
//	        SlideDeleteAdapter adapter = new SlideDeleteAdapter(this,list);
//	        //为listView设置适配
		 
		 ListViewAdapter2 lvadapter2 = new ListViewAdapter2(this,list);
	        mListView.setAdapter(lvadapter2);
		 
	} 
	public void backclick18(View v)
	{
		//Intent it = new Intent(Release.this, TestWeiXinWhatsNewActivity.class);
		//startActivity(it);
		Log.i("click", "stop");
		Me2.this.finish();
	}
//	//放入图片的mapview
//	private List<Map<String, Object>> getData() {
//		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
//
//		Map<String, Object> map = new HashMap<String, Object>();
//		//map.put("title", "G1");
//		//map.put("info", "google 1");
//		map.put("img", R.drawable.i1);
//		list.add(map);
//
//		map = new HashMap<String, Object>();
//		//map.put("title", "G2");
//		//map.put("info", "google 2");
//		map.put("img", R.drawable.i2);
//		list.add(map);
//
//		map = new HashMap<String, Object>();
//		//map.put("title", "G3");
//		//map.put("info", "google 3");
//		map.put("img", R.drawable.i3);
//		list.add(map);
//		
//		return list;
//	}
}
