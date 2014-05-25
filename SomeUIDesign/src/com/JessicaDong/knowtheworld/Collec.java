package com.JessicaDong.knowtheworld;

import java.util.ArrayList;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.view.LayoutInflater;

import android.os.Bundle;
import android.os.Parcelable;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
public class Collec extends Activity{
	ImageButton back30;
	
	// 滑动图片的集�?
		private ArrayList<View> imagePageViews = null;
		private ViewGroup main = null;
		private ViewPager viewPager = null;
		// 当前ViewPager索引
		private int pageIndex = 0; 
		// 包含圆点图片的View
		private ViewGroup imageCircleView = null;
		private ImageView[] imageCircleViews = null; 
		
		// 布局设置�?
		private SlideImageLayout slideLayout = null;
		// 数据解析�?
		private NewsXmlParser parser = null; 
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		  requestWindowFeature(Window.FEATURE_NO_TITLE);// ��������
		 setContentView(R.layout.activity_collection);
		back30 = (ImageButton)findViewById(R.id.back30);
        back30.setScaleType(ImageView.ScaleType.FIT_XY);
        Log.i("back","changed");
//       EditText edt1 = (EditText)findViewById(R.id.edt1);
//     //设置EditText的显示方式为多行文本输入  
//       edt1.setInputType(InputType.TYPE_TEXT_FLAG_MULTI_LINE);  
//     //改变默认的单行模�? 
//       edt1.setSingleLine(false);  
//       //水平滚动设置为False  
//       edt1.setHorizontallyScrolling(false);  
      
    // 初始�?
    		initeViews();
	} 
	
	
	/**
	 * 初始�?
	 */
	private void initeViews(){
		// 
		imagePageViews = new ArrayList<View>();
		LayoutInflater inflater = getLayoutInflater();  
		main = (ViewGroup)inflater.inflate(R.layout.activity_collection, null);
		viewPager = (ViewPager) main.findViewById(R.id.image_slide_page);  
		
		// 圆点图片区域
		parser = new NewsXmlParser();
		int length = parser.getSlideImages().length;
		
		slideLayout = new SlideImageLayout(Collec.this);
	
		
		// 圆点图片区域
				
				imageCircleViews = new ImageView[length];
				imageCircleView = (ViewGroup) main.findViewById(R.id.layout_circle_images);
				
				slideLayout.setCircleImageLayout(length);
		
		for(int i = 0;i < length;i++){
			imagePageViews.add(slideLayout.getSlideImageLayout(parser.getSlideImages()[i]));
			
			
			imageCircleViews[i] = slideLayout.getCircleImageLayout(i);
			imageCircleView.addView(slideLayout.getLinearLayout(imageCircleViews[i], 10, 10));
		
		}
		
		
		 setContentView(main);
		
		// 设置ViewPager
        viewPager.setAdapter(new SlideImageAdapter());  
        viewPager.setOnPageChangeListener(new ImagePageChangeListener());
	}
	
	
	// 滑动图片数据适配�?
    private class SlideImageAdapter extends PagerAdapter {  
        @Override  
        public int getCount() { 
            return imagePageViews.size();  
        }  
  
        @Override  
        public boolean isViewFromObject(View arg0, Object arg1) {  
            return arg0 == arg1;  
        }  
  
        @Override  
        public int getItemPosition(Object object) {  
            // TODO Auto-generated method stub  
            return super.getItemPosition(object);  
        }  
  
        @Override  
        public void destroyItem(View arg0, int arg1, Object arg2) {  
            // TODO Auto-generated method stub  
            ((ViewPager) arg0).removeView(imagePageViews.get(arg1));  
        }  
  
        @Override  
        public Object instantiateItem(View arg0, int arg1) {  
            // TODO Auto-generated method stub  
        	((ViewPager) arg0).addView(imagePageViews.get(arg1));
            
            return imagePageViews.get(arg1);  
        }  
  
        @Override  
        public void restoreState(Parcelable arg0, ClassLoader arg1) {  
            // TODO Auto-generated method stub  
  
        }  
  
        @Override  
        public Parcelable saveState() {  
            // TODO Auto-generated method stub  
            return null;  
        }  
  
        @Override  
        public void startUpdate(View arg0) {  
            // TODO Auto-generated method stub  
  
        }  
  
        @Override  
        public void finishUpdate(View arg0) {  
            // TODO Auto-generated method stub  
  
        }  
    }
    
    // 滑动页面更改事件监听�?
    private class ImagePageChangeListener implements OnPageChangeListener {
        @Override  
        public void onPageScrollStateChanged(int arg0) {  
            // TODO Auto-generated method stub  
  
        }  
  
        @Override  
        public void onPageScrolled(int arg0, float arg1, int arg2) {  
            // TODO Auto-generated method stub  
  
        }  
  
        @Override  
        public void onPageSelected(int index) {  
        	pageIndex = index;
        	slideLayout.setPageIndex(index);
            for (int i = 0; i < imageCircleViews.length; i++) {  
            	imageCircleViews[index].setBackgroundResource(R.drawable.page_indicator_focused);
                
                if (index != i) {  
                	imageCircleViews[i].setBackgroundResource(R.drawable.page_indicator_unfocused);  
                }  
            }
           
        }  
    }
	
	public void backclick5(View v) {
		//Intent it = new Intent(Collec.this,Cat.class);
		
		//startActivity(it);
		this.finish();
	}
	public void favclick(View v) {
		Toast.makeText(Collec.this, "���ղ�",  Toast.LENGTH_SHORT).show();
	}
	public void shareclick(View v) {
		Intent it = new Intent(Collec.this,Friendlist.class);
		
		startActivity(it);
		//this.finish();
	}
	public void commentclick(View v) {
		Intent it = new Intent(Collec.this,Somecomment.class);
		
		startActivity(it);
		//this.finish();
	}
	public void map1(View v) {
		Intent it = new Intent(Collec.this,GeoCoderDemo.class);
		
		startActivity(it);
		//this.finish();
	}
}
