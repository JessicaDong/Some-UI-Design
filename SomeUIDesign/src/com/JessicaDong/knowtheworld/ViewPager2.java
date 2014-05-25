package com.JessicaDong.knowtheworld;



import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.widget.LinearLayout;

public class ViewPager2 extends LinearLayout{
	 public final static String TAG2 = "TabViewPager2";
	private Context mContext2;
	private ViewPager mViewPager2;
	
	public ViewPager2(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		mContext2 = context;
		inflate(context, R.layout.teb_view_pager2, this);
		 initViews2();
	}
	
	private void initViews2(){
		mViewPager2= (ViewPager)findViewById(R.id.view_pager2);
	}
	
	public void SetAdapter2( PagerAdapter adapter2){
		mViewPager2.setAdapter(adapter2);
		
		mViewPager2.setOnPageChangeListener( new OnPageChangeListener() {
			
			private int currentPosition2 = -1;
			private int nextPosition2 =-1;
			
			@Override
			public void onPageSelected(int position2) {
				// TODO Auto-generated method stub
				nextPosition2 = position2;
			}
			
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub
				currentPosition2 = arg0;
				
			}
			
			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
	}
}
