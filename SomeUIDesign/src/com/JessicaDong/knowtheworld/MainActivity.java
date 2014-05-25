package com.JessicaDong.knowtheworld;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;








import android.R.integer;
import android.R.string;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class MainActivity extends Activity  {

	ViewPager1 mViewPager;
	ArrayList<View> Views;
	ViewPagerAdapter mAdapter;
	private TextView textViewcity;
	private ImageView imageViewcity;
	private MyspinnerAdapter adaptercity;
	private LinearLayout spinnerlayoutcity;
	//接收返回的�?择城�?
	private final static int Requestcode = 1;
	private TextView citytextTV;
//	//第一次启动页�?
//	ViewPager2 mViewPager2;
//	ArrayList<View> Views2;
//	ViewPagerAdapter2 mAdapter2;
//	
//	String [] str1 = {"收藏","伙伴","热门","分类"};
//	int width;

	private ImageView[] imgs;
	private int count;
	private int currentItem;
	private LinearLayout pointLLayout;
	//圆点图片集合
		private ImageView[] imageViews2 = null; 
		private Spinner spinneradd = null;// 要读取的下拉列表  
		private List<Map<String,Object>> addlists = null;  
		ListAdapter simpleAdapter1;
		//private SimpleAdapter adapter = null;  
		
		private ArrayList<String> list;
		private PopupWindow popupWindow;
		private LinearLayout layout;
		private MyspinnerAdapter adapter;
		private ListView listView;
		private ArrayList<String> list2;
		private MyspinnerAdapter adapter2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		  requestWindowFeature(Window.FEATURE_NO_TITLE);// ��������
		 mViewPager = new ViewPager1(this,null);
	       // mViewPager.setId(R.id.tab_view_pager);
	        setContentView(mViewPager);
		//setContentView(R.layout.tab_view_pager);
	//	ViewPager1 vp1= new ViewPager1(R.layout.tab_view_pager, null);
		//这里先注�?
	        String [] str1 = {"收藏","伙伴","热门","分类"};
		 Display display=getWindowManager().getDefaultDisplay();
		 //这里先注�?
		 @SuppressWarnings("deprecation")
		 
		  int width =display.getWidth();
		 width =display.getWidth();
		 
		//int width=display.getWidth();
		  //这里先注�?
		  mViewPager.initTabs(str1,width );
		  
		  //��ʼ��Views
	        Views=new ArrayList<View>();
	        LayoutInflater Inflater=LayoutInflater.from(this);
	        Views.add(Inflater.inflate(R.layout.activity_collcectotal, null));
	        Views.add(Inflater.inflate(R.layout.activity_friendtotal, null));
	        Views.add(Inflater.inflate(R.layout.activity_hot, null));
	        Views.add(Inflater.inflate(R.layout.activity_cat, null));
	        
	        //��ʼ��������
	        mAdapter=new ViewPagerAdapter(Views);
	        mViewPager.setAdapter(mAdapter);
		  
	    
	        list = new ArrayList<String>();
			list.add("添加好友");
			list.add("好友列表");
			list.add("好友管理");
			// 实例化一个�?配器，list的数据作为Adapter的数�?
			adapter = new MyspinnerAdapter(this, list);
			
			list2 = new ArrayList<String>();
			list2.add("Angela");
			list2.add("我的评论");
			list2.add("�?��浏览");
			list2.add("设置");
			list2.add("意见反馈");
			// 实例化一个�?配器，list的数据作为Adapter的数�?
			adapter2 = new MyspinnerAdapter(this, list2);
	      
			addlists = Myadapter.getListMap();
			
//			//第一次初始页�?
//			 mViewPager2 = new ViewPager2(this);	      
//		     setContentView(mViewPager2);
//			 Display display2=getWindowManager().getDefaultDisplay();
//			  
//			
//			  
//			  //��ʼ��Views
//			    Views2=new ArrayList<View>();
//		        LayoutInflater Inflater2=LayoutInflater.from(this);
//		        Views2.add(Inflater.inflate(R.layout.activity_init1, null));
//		        Views2.add(Inflater.inflate(R.layout.activity_init2, null));
//		        Views2.add(Inflater.inflate(R.layout.activity_init3, null));
//		        Views2.add(Inflater.inflate(R.layout.activity_init4, null));
//		        Views2.add(Inflater.inflate(R.layout.activity_init5, null));
//		        Views2.add(Inflater.inflate(R.layout.activity_init6, null));
//		        
//		        //��ʼ��������
//		        mAdapter2=new ViewPagerAdapter2(Views2);
//		        mViewPager2.SetAdapter2(mAdapter2);
			
			//Bar的最左端下拉列表，�?择地�?
			textViewcity = (TextView) findViewById(R.id.citytext);
			imageViewcity = (ImageView) findViewById(R.id.citychoose);
			// 实例化一个List,添加数据
			list = new ArrayList<String>();
			list.add("北京");
			list.add("上海");
			list.add("广州");
			// 实例化一个�?配器，list的数据作为Adapter的数�?
			adaptercity = new MyspinnerAdapter(this, list);
			// 默认设置下拉框的标题为数据的第一�?
			textViewcity.setText((CharSequence) adaptercity.getItem(0));
			spinnerlayoutcity = (LinearLayout) findViewById(R.id.spinneridcity);
			// 点击右侧按钮，弹出下拉框
		
			citytextTV = (TextView)findViewById(R.id.citytext);
	}

	
	@SuppressWarnings("deprecation")
	public void showWindow2(View v) {
		Log.i("addicon", "showview2");
		// 找到布局文件
		layout = (LinearLayout) LayoutInflater.from(this).inflate(R.layout.mypinner_dropdown, null);
		// 实例化listView
		listView = (ListView) layout.findViewById(R.id.listView);
		// 设置listView的�?配器
		//listView.setAdapter(adapter);
		listView.setAdapter(adapter);
		// 实例化一个PopuWindow对象
		popupWindow = new PopupWindow(v);
		// 设置弹框的宽度为布局文件的宽
		popupWindow.setWidth(300);
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
		    		Intent it1 = new Intent(MainActivity.this, Friendadd.class);
		    		startActivity(it1);break;
		    	}
		    	case 1: 
		    	{
		    		Intent it2 = new Intent(MainActivity.this, Friendlist.class);
		    		startActivity(it2);break;
		    	}
		    	case 2: 
		    	{
		    		Intent it3 = new Intent(MainActivity.this, Friendmanagement.class);
		    		startActivity(it3);break;
		    	}
		    	};
				popupWindow.dismiss();
				popupWindow = null;
			}
		});

	}
	@SuppressWarnings("deprecation")
	public void showWindow3(View v) {
		Log.i("infoicon", "showview3");
		// 找到布局文件
		layout = (LinearLayout) LayoutInflater.from(this).inflate(R.layout.mypinner_dropdown, null);
		// 实例化listView
		listView = (ListView) layout.findViewById(R.id.listView);
		// 设置listView的�?配器
		listView.setAdapter(adapter2);
		// 实例化一个PopuWindow对象
		popupWindow = new PopupWindow(v);
		// 设置弹框的宽度为布局文件的宽
		popupWindow.setWidth(300);
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
		popupWindow.showAsDropDown(v, 150, 0);
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
		    		Intent it1 = new Intent(MainActivity.this,Angela.class);
		    		startActivity(it1);break;
		    	}
		    	case 1: 
		    	{
		    		Intent it2 = new Intent(MainActivity.this, Mycomment.class);
		    		startActivity(it2);break;
		    	}
		    	case 2: 
		    	{
		    		Intent it3 = new Intent(MainActivity.this, Recntlyview.class);
		    		startActivity(it3);break;
		    	}
		    	case 4: 
		    	{
		    		Intent it3 = new Intent(MainActivity.this, Feedback.class);
		    		startActivity(it3);break;
		    	}
		    	case 3: 
		    	{
		    		Intent it3 = new Intent(MainActivity.this, Seetings.class);
		    		startActivity(it3);break;
		    	}
		    	};
				popupWindow.dismiss();
				popupWindow = null;
			}
		});

	}
	//显示�?��边列表显示城�?
	@SuppressWarnings("deprecation")
	public void showWindow4(View v) {
		// 找到布局文件
		layout = (LinearLayout) LayoutInflater.from(this).inflate(R.layout.mypinner_dropdown, null);
		// 实例化listView
		listView = (ListView) layout.findViewById(R.id.listView);
		// 设置listView的�?配器
		listView.setAdapter(adaptercity);
		// 实例化一个PopuWindow对象
		popupWindow = new PopupWindow(v);
		// 设置弹框的宽度为布局文件的宽
		popupWindow.setWidth(spinnerlayoutcity.getWidth());
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
		popupWindow.showAsDropDown(v, -textViewcity.getWidth(), 0);
		// listView的item点击事件
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
				// TODO Auto-generated method stub
				textViewcity.setText(list.get(arg2));// 设置�??的item作为下拉框的标题
		
				popupWindow.dismiss();
				popupWindow = null;
			}
		});

	}
	
	public void searchtext(View v)
	{
		
//Intent it = new Intent(TestWeiXinWhatsNewActivity.this,Searchtext1.class);
		Intent it = new Intent(MainActivity.this,Sear.class);	
		startActivity(it);
		//MainActivity.this.finish();
	}
	public void colclick1(View v)
	{
	
		Intent it = new Intent(MainActivity.this,Collec.class);	
		startActivity(it);
		//MainActivity.this.finish();
	}
	public void friclick1(View v)
	{
		
		Intent it = new Intent(MainActivity.this,Release.class);	
		startActivity(it);
		//MainActivity.this.finish();
	}
	public void friclick2(View v)
	{
		Intent it = new Intent(MainActivity.this,Share.class);	
		startActivity(it);
		//MainActivity.this.finish();
	}
	public void friclick3(View v)
	{
		
		Intent it = new Intent(MainActivity.this,Comment.class);	
		startActivity(it);
		//MainActivity.this.finish();
	}
	public void hotclick1(View v)
	{
		
		Intent it = new Intent(MainActivity.this,Collec.class);	
		startActivity(it);
		//MainActivity.this.finish();
	}
	public void catclick1(View v)
	{
		
		Intent it = new Intent(MainActivity.this,Catdetail.class);	
		startActivity(it);
		//MainActivity.this.finish();
	}
	public void choosecity(View v)
	{
		
		Intent it1 = new Intent(MainActivity.this,CityList.class);	
		startActivityForResult(it1, Requestcode);
		//startActivity(it);
		//MainActivity.this.finish();
	}
	
	protected void onActivityResult(int requestCode,int resultCode,Intent data)
    {
    	super.onActivityResult(requestCode, resultCode, data);
    	if (resultCode==RESULT_OK) {
    		if(requestCode==Requestcode){
    			citytextTV.setText(data.getStringExtra("Cityname1"));
    		}
			
		}
    }
	
	//init 到正式启�?
//	public void startclick(View v)
//	{
//		mViewPager.initTabs(str1,width );
//		
//	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
