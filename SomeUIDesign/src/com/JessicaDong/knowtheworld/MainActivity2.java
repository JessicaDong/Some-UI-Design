package com.JessicaDong.knowtheworld;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;




import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.PagerTitleStrip;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.util.TypedValue;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

/*
 * ֻ��������ҳ���activity
 */
public class MainActivity2 extends FragmentActivity{
	
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
		private ArrayList<String> list3;
		private MyspinnerAdapter adapter3;


		private FragmentAdapter mFragmentAdapter;
		private ViewPager mfViewPager;
		//private PagerTitleStrip pts;
		private PagerTabStrip pts;

		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			  requestWindowFeature(Window.FEATURE_NO_TITLE);// ��������
			setContentView(R.layout.activity_main1);

			int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024);  
			Log.d("TAG", "Max memory is " + maxMemory + "KB");
			
			mFragmentAdapter = new FragmentAdapter(MainActivity2.this, getSupportFragmentManager());

			mfViewPager = (ViewPager) findViewById(R.id.pager);
			mfViewPager.setAdapter(mFragmentAdapter);
			mfViewPager.setCurrentItem(60); //��ҳ��4����Ϊ3����������Ϊ3�ı�����
			//mfViewPager.setCurrentItem(mFragmentAdapter.getCount()/2);
			//pts=(PagerTitleStrip)findViewById(R.id.pager_title_strip);
			pts=(PagerTabStrip)findViewById(R.id.pager_title_strip);
			pts.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
			pts.setNonPrimaryAlpha(0.3f);
			
			/*
			 * Mainactivity
			 */
			
		        
		      
			  
		    
			 list = new ArrayList<String>();
				list.add("���Ӻ���");
				//list.add("�����б�");
				list.add("���ѹ���");
				list.add("��Ϣ����");
				// ʵ����һ����������list��������ΪAdapter������
				adapter = new MyspinnerAdapter(this, list);
				
				list2 = new ArrayList<String>();
				list2.add("Angela");
				//list2.add("�ҵ�����");
				list2.add("������");
				list2.add("����");
				list2.add("�������");
				// ʵ����һ����������list��������ΪAdapter������
				adapter2 = new MyspinnerAdapter(this, list2);
				
				//location ��list
				 list3 = new ArrayList<String>();
					list3.add("����");
					list3.add("�Ϻ�");
					list3.add("����");
					list3.add("����");
					list3.add("����");
					// ʵ����һ����������list��������ΪAdapter������
					adapter3 = new MyspinnerAdapter(this, list3);
		      
				addlists = Myadapter.getListMap();		
				citytextTV = (TextView)findViewById(R.id.citytext);
		}
/*
 * 
 * 原MainAcitivity
 */
//		@Override
//		public boolean onCreateOptionsMenu(Menu menu) {
//		//	getMenuInflater().inflate(R.menu.main, menu);
//			return true;
//		}
	
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
			    		Intent it1 = new Intent(MainActivity2.this, Friendadd.class);
			    		startActivity(it1);break;
			    	}
			    	case 1: 
			    	{
			    		Intent it2 = new Intent(MainActivity2.this, Friendmanagement.class);
			    		startActivity(it2);break;
			    	}
			    	case 2: 
			    	{
			    		Intent it3 = new Intent(MainActivity2.this, Release2.class);
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
			popupWindow.showAsDropDown(v, 180, 0);
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
			    		Intent it1 = new Intent(MainActivity2.this,Angela.class);
			    		startActivity(it1);break;
			    	}
			    	case 1: 
			    	{
			    		Intent it2 = new Intent(MainActivity2.this, Mycomment.class);
			    		startActivity(it2);break;
			    	}
			    	case 2: 
			    	{
			    		Intent it3 = new Intent(MainActivity2.this, Recntlyview.class);
			    		startActivity(it3);break;
			    	}
			    	case 4: 
			    	{
			    		Intent it3 = new Intent(MainActivity2.this, Feedback.class);
			    		startActivity(it3);break;
			    	}
			    	case 3: 
			    	{
			    		Intent it3 = new Intent(MainActivity2.this, Seetings.class);
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
		//location��list window
		@SuppressWarnings("deprecation")
		public void showWindow5(View v) {
			Log.i("addicon", "showview5");
			// 找到布局文件
			layout = (LinearLayout) LayoutInflater.from(this).inflate(R.layout.mypinner_dropdown, null);
			// 实例化listView
			listView = (ListView) layout.findViewById(R.id.listView);
			// 设置listView的�?配器
			//listView.setAdapter(adapter);
			listView.setAdapter(adapter3);
			// 实例化一个PopuWindow对象
			popupWindow = new PopupWindow(v);
			// 设置弹框的宽度为布局文件的宽
			popupWindow.setWidth(120);
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
			popupWindow.showAsDropDown(v, 0, 0);
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
			    		citytextTV.setText(list3.get(0));break;
			    	}
			    	case 1: 
			    	{
			    		citytextTV.setText(list3.get(1));break;
			    	}
			    	case 2: 
			    	{
			    		citytextTV.setText(list3.get(2));break;
			    	}
			    	case 3:
			    	{
			    		citytextTV.setText(list3.get(3));break;
			    	}
			    	case 4:
			    	{
			    		Intent it1 = new Intent(MainActivity2.this,CityList.class);	
						startActivityForResult(it1, Requestcode);break;
			    	}
			    	};
					popupWindow.dismiss();
					popupWindow = null;
				}
			});

		}
		
		public void searchtext(View v)
		{
			
	//Intent it = new Intent(TestWeiXinWhatsNewActivity.this,Searchtext1.class);
			Intent it = new Intent(MainActivity2.this,Sear.class);	
			startActivity(it);
			//MainActivity.this.finish();
		}
	
		public void friclick1(View v)
		{
		
			Intent it = new Intent(MainActivity2.this,Release.class);	
			startActivity(it);
			//MainActivity.this.finish();
		}
		public void friclick2(View v)
		{
			
			Intent it = new Intent(MainActivity2.this,Share.class);	
			startActivity(it);
			//MainActivity.this.finish();
		}
		public void friclick3(View v)
		{
			
			Intent it = new Intent(MainActivity2.this,Comment.class);	
			startActivity(it);
			//MainActivity.this.finish();
		}
		public void hotclick1(View v)
		{
			
			//Intent it = new Intent(MainActivity1.this,Collec.class);	
			Intent it = new Intent(MainActivity2.this,VerticalScrollTextActivity1.class);	
			startActivity(it);
			//MainActivity.this.finish();
		}
		public void catclick1(View v)
		{
			
			Intent it = new Intent(MainActivity2.this,Catdetail.class);	
			startActivity(it);
			//MainActivity.this.finish();
		}
		public void catclick2(View v)
		{
			
			Intent it = new Intent(MainActivity2.this,Hot2.class);	
			startActivity(it);
			//MainActivity.this.finish();
		}
		public void choosecity(View v)
		{
			Intent it1 = new Intent(MainActivity2.this,CityList.class);	
			startActivityForResult(it1, Requestcode);
			//startActivity(it);
			//MainActivity.this.finish();
		}
		
		public void colclick1(View v)
		{
			Intent it1 = new Intent(MainActivity2.this,Me1.class);	
			startActivity(it1);
		}
		public void colclick2(View v)
		{
			Intent it1 = new Intent(MainActivity2.this,Me222.class);	
			startActivity(it1);
		}
		public void colclick3(View v)
		{
			Intent it1 = new Intent(MainActivity2.this,Me333.class);	
			startActivity(it1);
		}
		public void colclick4(View v)
		{
			Intent it1 = new Intent(MainActivity2.this,Me44444.class);	
			startActivity(it1);
		}
		public void colclick5(View v)
		{
			Intent it1 = new Intent(MainActivity2.this,Me555.class);	
			startActivity(it1);
		}
		public void colclick6(View v)
		{
			Intent it1 = new Intent(MainActivity2.this,Me666.class);	
			startActivity(it1);
		}
		public void colclick7(View v)
		{
			Intent it1 = new Intent(MainActivity2.this,Me7.class);	
			startActivity(it1);
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
//		public void startclick(View v)
//		{
//			mViewPager.initTabs(str1,width );
//			
//		}
		@Override
		public boolean onCreateOptionsMenu(Menu menu) {
			// Inflate the menu; this adds items to the action bar if it is present.
			//getMenuInflater().inflate(R.menu.main, menu);
			return true;
		}
		public final class ViewHolder{
			public ImageView img;
			public Button viewBtndelete;
			public Button viewBtnadd;
		}

}
