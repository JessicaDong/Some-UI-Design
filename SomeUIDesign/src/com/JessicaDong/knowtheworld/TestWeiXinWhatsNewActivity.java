package com.JessicaDong.knowtheworld;
//package com.chen.weixin.test;
//
//import java.util.ArrayList;  
//import java.util.HashMap;  
//import java.util.List;  
//import java.util.Map;  
//
//
//
//import com.chen.weixin.test.*;
//
//import android.R.anim;
//import android.R.layout;
//import android.app.Activity;
//import android.content.Context;
//import android.content.Intent;
//import android.graphics.drawable.BitmapDrawable;
//import android.os.Bundle;
//import android.util.Log;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.View.OnClickListener;
//import android.view.ViewGroup.LayoutParams;
//import android.view.animation.Animation;
//import android.view.animation.Animation.AnimationListener;
//import android.view.animation.AnimationUtils;
//import android.widget.AdapterView;
//import android.widget.ArrayAdapter;
//import android.widget.Button;
//import android.widget.ImageButton;
//import android.widget.ImageView;
//import android.widget.LinearLayout;
//import android.widget.ListAdapter;
//import android.widget.ListView;
//import android.widget.PopupWindow;
//import android.widget.RelativeLayout;
//import android.widget.SimpleAdapter;
//import android.widget.Spinner;
//import android.widget.TextView;
//import android.widget.AdapterView.OnItemClickListener;
//
//public class TestWeiXinWhatsNewActivity extends Activity implements OnViewChangeListener{
//	
//	private MyScrollLayout mScrollLayout;
//	private ImageView[] imgs;
//	private int count;
//	private int currentItem;
//	private Button startBtn,btnhot,btncat,btnsear;
//	private RelativeLayout mainRLayout;
//	private LinearLayout pointLLayout;
//	private LinearLayout leftLayout;
//	private LinearLayout rightLayout;
//	private LinearLayout animLayout;
//	public  ImageButton release1,share1,comment1,btnsearch1;
//	private Button btncol1;
//	
//	//private Myadapter simpleadapter1;
//	//圆点图片集合
//	private ImageView[] imageViews2 = null; 
//	private Spinner spinneradd = null;// 要读取的下拉列表  
//	private List<Map<String,Object>> addlists = null;  
//	ListAdapter simpleAdapter1;
//	//private SimpleAdapter adapter = null;  
//	
//	private ArrayList<String> list;
//	private PopupWindow popupWindow;
//	private LinearLayout layout;
//	private MyspinnerAdapter adapter;
//	private ListView listView;
//	private ArrayList<String> list2;
//	private MyspinnerAdapter adapter2;
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.main);
//        initView();
//       // release1 = (ImageButton)findViewById(R.id.release1);
//       // release1.setScaleType(ImageView.ScaleType.FIT_XY);
//       // share1 = (ImageButton)findViewById(R.id.share1);
//      //  share1.setScaleType(ImageView.ScaleType.FIT_XY);
//      //  comment1 = (ImageButton)findViewById(R.id.comment1);
//      //  comment1.setScaleType(ImageView.ScaleType.FIT_XY);
//      //  btncol1 = (Button)findViewById(R.id.btncolec1);
//        btnsearch1 = (ImageButton)findViewById(R.id.btnsearch1);
//        btnsearch1.setScaleType(ImageView.ScaleType.FIT_XY);
//        
//        list = new ArrayList<String>();
//		list.add("添加好友");
//		list.add("好友列表");
//		list.add("好友管理");
//		// 实例化一个�?配器，list的数据作为Adapter的数�?//		adapter = new MyspinnerAdapter(this, list);
//		
//		list2 = new ArrayList<String>();
//		list2.add("Angela");
//		list2.add("我的评论");
//		list2.add("�?��浏览");
//		list2.add("设置");
//		list2.add("意见反馈");
//		// 实例化一个�?配器，list的数据作为Adapter的数�?//		adapter2 = new MyspinnerAdapter(this, list2);
//      
//		addlists = Myadapter.getListMap();
//		//simpleAdapter1 = new SimpleAdapter(this, addlists, R.layout.item, new String[]{"ivlogo"},new int[]{R.id.img});
//	    
//    }
//    
//    private void initView()
//    {
//
//      
//                mScrollLayout  = (MyScrollLayout) findViewById(R.id.ScrollLayout);
//                pointLLayout = (LinearLayout) findViewById(R.id.llayout);
//                mainRLayout = (RelativeLayout) findViewById(R.id.mainRLayout);
//              //  startBtn = (Button) findViewById(R.id.startBtn);
//              //  startBtn.setOnClickListener(onClick);
//                animLayout = (LinearLayout) findViewById(R.id.animLayout);
//                leftLayout  = (LinearLayout) findViewById(R.id.leftLayout);
//                rightLayout  = (LinearLayout) findViewById(R.id.rightLayout);
//                count = mScrollLayout.getChildCount();
//                imgs = new ImageView[count];
//                for(int i = 0; i< count;i++) {
//                        imgs[i] = (ImageView) pointLLayout.getChildAt(i);
//                      //  imgs[i].setEnabled(true);
//                     //   imgs[i].setTag(i);
//                }
//                currentItem = 0;
//                imgs[currentItem].setEnabled(false);
//                mScrollLayout.SetOnViewChangeListener(this);
//       }
//    
//    
//
//    
//	
//	public void beginrelease(View v) {
//		Intent it = new Intent(TestWeiXinWhatsNewActivity.this,Release.class);
//		
//		startActivity(it);
//		//MainActivity.this.finish();
//	}
//	
//	public void beginshare(View v) {
//		Intent it = new Intent(TestWeiXinWhatsNewActivity.this,Share.class);
//		
//		startActivity(it);
//		//MainActivity.this.finish();
//	}
//	
//	public void begincomment(View v) {
//		Intent it = new Intent(TestWeiXinWhatsNewActivity.this,Comment.class);
//		
//		startActivity(it);
//		//MainActivity.this.finish();
//	}
//	
//	public void beginhot(View v) {
//		//Intent it = new Intent(TestWeiXinWhatsNewActivity.this,TestWeiXinWhatsNewActivity.class);
//		
//		//startActivity(it);
//		//MainActivity.this.finish();
//	}
//	
//	public void begincat(View v) {
//		Intent it = new Intent(TestWeiXinWhatsNewActivity.this,Cat.class);
//		
//		startActivity(it);
//		//MainActivity.this.finish();
//	}
//	
//	public void beginsear(View v) {
//		Intent it = new Intent(TestWeiXinWhatsNewActivity.this,Sear.class);
//		
//		startActivity(it);
//		//MainActivity.this.finish();
//	}
//	
//	public void begincollec(View v) {
//		Intent it = new Intent(TestWeiXinWhatsNewActivity.this,Collec.class);
//		
//		startActivity(it);
//		//MainActivity.this.finish();
//	}
//	@Override
//	public void OnViewChange(int position) {
//		setcurrentPoint(position);
//	}
//
//
//	private void setcurrentPoint(int position) {
//		if(position < 0 || position > count -1 || currentItem == position) {
//			return;
//		}
//		imgs[currentItem].setEnabled(true);
//		imgs[position].setEnabled(false);
//		currentItem = position;
//	}
//	public void searchtext(View v)
//	{
//		Log.i("主程�?, "点击");
////Intent it = new Intent(TestWeiXinWhatsNewActivity.this,Searchtext1.class);
//		Intent it = new Intent(TestWeiXinWhatsNewActivity.this,Sear.class);	
//		startActivity(it);
//		//MainActivity.this.finish();
//	}
//	public void tohome1(View v)
//	{
//		Log.i("主程�?, "点击");
//Intent it = new Intent(TestWeiXinWhatsNewActivity.this,TestWeiXinWhatsNewActivity.class);
//		
//		startActivity(it);
//		//MainActivity.this.finish();
//	}
//	public void tocat1(View v)
//	{
//		Log.i("主程�?, "点击");
//Intent it = new Intent(TestWeiXinWhatsNewActivity.this,Cat.class);
//		
//		startActivity(it);
//		//MainActivity.this.finish();
//	}
//	public void tofri1(View v)
//	{
//		Log.i("主程�?, "点击");
//Intent it = new Intent(TestWeiXinWhatsNewActivity.this,Friendtotal.class);
//		
//		startActivity(it);
//		//MainActivity.this.finish();
//	}
//	public void tocole1(View v)
//	{
//		Log.i("主程�?, "点击");
//Intent it = new Intent(TestWeiXinWhatsNewActivity.this,Colectotal.class);
//		
//		startActivity(it);
//		//MainActivity.this.finish();
//	}
//	
//	public void begindetail1(View v)
//	{
//		Log.i("主程�?, "点击");
//Intent it = new Intent(TestWeiXinWhatsNewActivity.this,Collec.class);
//		
//		startActivity(it);
//		//MainActivity.this.finish();
//	}
//	/*
//	public void addfriends(View v)
//	{
//		Log.i("主程�?, "点击listactivity");
//		showWindow2(v);
////Intent it = new Intent(TestWeiXinWhatsNewActivity.this,ListActivityImpl.class);
//		
//		//startActivity(it);
//		//MainActivity.this.finish();
//	}
//	*/
//	
//	@SuppressWarnings("deprecation")
//	public void showWindow2(View v) {
//		Log.i("addicon", "showview2");
//		// 找到布局文件
//		layout = (LinearLayout) LayoutInflater.from(this).inflate(R.layout.mypinner_dropdown, null);
//		// 实例化listView
//		listView = (ListView) layout.findViewById(R.id.listView);
//		// 设置listView的�?配器
//		//listView.setAdapter(adapter);
//		listView.setAdapter(adapter);
//		// 实例化一个PopuWindow对象
//		popupWindow = new PopupWindow(v);
//		// 设置弹框的宽度为布局文件的宽
//		popupWindow.setWidth(300);
//		// 高度随着内容变化
//		popupWindow.setHeight(LayoutParams.WRAP_CONTENT);
//		// 设置�?��透明的背景，不然无法实现点击弹框外，弹框消失
//		popupWindow.setBackgroundDrawable(new BitmapDrawable());
//		// 设置点击弹框外部，弹框消�?//		popupWindow.setOutsideTouchable(true);
//		// 设置焦点
//		popupWindow.setFocusable(true);
//		// 设置�?��布局
//		popupWindow.setContentView(layout);
//		// 设置弹框出现的位置，在v的正下方横轴偏移textview的宽度，为了对齐~纵轴不偏�?//		popupWindow.showAsDropDown(v, 200, 0);
//		// listView的item点击事件
//		listView.setOnItemClickListener(new OnItemClickListener() {
//
//			@Override
//			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
//				// TODO Auto-generated method stub
//				
//				// 弹框消失
//				switch( arg2)
//				{
//		    	
//		    	case 0: 
//		    	{
//		    		Intent it1 = new Intent(TestWeiXinWhatsNewActivity.this, Friendadd.class);
//		    		startActivity(it1);break;
//		    	}
//		    	case 1: 
//		    	{
//		    		Intent it2 = new Intent(TestWeiXinWhatsNewActivity.this, Friendlist.class);
//		    		startActivity(it2);break;
//		    	}
//		    	case 2: 
//		    	{
//		    		Intent it3 = new Intent(TestWeiXinWhatsNewActivity.this, Friendmanagement.class);
//		    		startActivity(it3);break;
//		    	}
//		    	};
//				popupWindow.dismiss();
//				popupWindow = null;
//			}
//		});
//
//	}
//	@SuppressWarnings("deprecation")
//	public void showWindow3(View v) {
//		Log.i("infoicon", "showview3");
//		// 找到布局文件
//		layout = (LinearLayout) LayoutInflater.from(this).inflate(R.layout.mypinner_dropdown, null);
//		// 实例化listView
//		listView = (ListView) layout.findViewById(R.id.listView);
//		// 设置listView的�?配器
//		listView.setAdapter(adapter2);
//		// 实例化一个PopuWindow对象
//		popupWindow = new PopupWindow(v);
//		// 设置弹框的宽度为布局文件的宽
//		popupWindow.setWidth(300);
//		// 高度随着内容变化
//		popupWindow.setHeight(LayoutParams.WRAP_CONTENT);
//		// 设置�?��透明的背景，不然无法实现点击弹框外，弹框消失
//		popupWindow.setBackgroundDrawable(new BitmapDrawable());
//		// 设置点击弹框外部，弹框消�?//		popupWindow.setOutsideTouchable(true);
//		// 设置焦点
//		popupWindow.setFocusable(true);
//		// 设置�?��布局
//		popupWindow.setContentView(layout);
//		// 设置弹框出现的位置，在v的正下方横轴偏移textview的宽度，为了对齐~纵轴不偏�?//		popupWindow.showAsDropDown(v, 150, 0);
//		// listView的item点击事件
//		listView.setOnItemClickListener(new OnItemClickListener() {
//
//			@Override
//			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
//				// TODO Auto-generated method stub
//				
//				// 弹框消失
//				switch( arg2)
//				{
//		    	
//		    	case 0: 
//		    	{
//		    		Intent it1 = new Intent(TestWeiXinWhatsNewActivity.this, Angela.class);
//		    		startActivity(it1);break;
//		    	}
//		    	case 1: 
//		    	{
//		    		Intent it2 = new Intent(TestWeiXinWhatsNewActivity.this, Mycomment.class);
//		    		startActivity(it2);break;
//		    	}
//		    	case 2: 
//		    	{
//		    		Intent it3 = new Intent(TestWeiXinWhatsNewActivity.this, Recntlyview.class);
//		    		startActivity(it3);break;
//		    	}
//		    	case 4: 
//		    	{
//		    		Intent it3 = new Intent(TestWeiXinWhatsNewActivity.this, Feedback.class);
//		    		startActivity(it3);break;
//		    	}
//		    	case 3: 
//		    	{
//		    		Intent it3 = new Intent(TestWeiXinWhatsNewActivity.this, Seetings.class);
//		    		startActivity(it3);break;
//		    	}
//		    	};
//				popupWindow.dismiss();
//				popupWindow = null;
//			}
//		});
//
//	}
//	
//	public void tvclick1(View v) {
//		Log.i("click1", "down");
//		Intent it = new Intent(TestWeiXinWhatsNewActivity.this,TestWeiXinWhatsNewActivity.class);
//		
//		startActivity(it);
//		//MainActivity.this.finish();
//	}
//	public void tvclick2(View v) {
//		//Log.i("Te1", "点击�?");
//		//MyScrollLayout msl1;
//		//msl1 =   (MyScrollLayout) findViewById(R.id.ScrollLayout);
//		//msl1.mDefaultScreen =1;
//		//msl1.mCurScreen =1;
//		
//		Intent it = new Intent(TestWeiXinWhatsNewActivity.this,Friendtotal.class);
//		
//		startActivity(it);
//		//MainActivity.this.finish();
//	}
//	public void tvclick3(View v) {
//		Intent it = new Intent(TestWeiXinWhatsNewActivity.this,Hot.class);
//		
//		startActivity(it);
//		//MainActivity.this.finish();
//	}
//	public void tvclick4(View v) {
//		Intent it = new Intent(TestWeiXinWhatsNewActivity.this,Cat.class);
//		
//		startActivity(it);
//		//MainActivity.this.finish();
//	}
//public void begindetail4(View v) {
//		
//		Intent it = new Intent(TestWeiXinWhatsNewActivity.this,Catdetail.class);
//		
//		startActivity(it);
//		//MainActivity.this.finish();
//	}
//	
//	}
//	
