package com.JessicaDong.knowtheworld;

import java.util.ArrayList;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;

public class ViewPagerAdapter2 extends PagerAdapter{
	
	private ArrayList<View> views2;
	
	public ViewPagerAdapter2 (ArrayList<View> views2){
		this.views2 = views2;
	}


    @Override
    public void destroyItem(View container, int position, Object object) 
    {
        ((ViewPager)container).removeView(views2.get(position));
    }
    @Override
    public Object instantiateItem(View container, int position) 
    {
        ((ViewPager)container).addView(views2.get(position),0);
        return views2.get(position);
    }
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		if(views2!=null){
			return views2.size();
		}
			return 0;
	}

	@Override
	public boolean isViewFromObject(View view, Object object) {
		// TODO Auto-generated method stub
		 return (view==object);
	}

}
