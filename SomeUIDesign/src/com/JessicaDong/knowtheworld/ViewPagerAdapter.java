package com.JessicaDong.knowtheworld;

import java.util.ArrayList;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

public class ViewPagerAdapter extends PagerAdapter{
	
	    //ViewPager çš?Views
	    private ArrayList<View> Views;
	    //ViewPager çš?Titlesï¼?è¿™é‡ŒæŒªåˆ°ViewPager1ä¸­åšäº?
	   // private ArrayList<String> Titles;


	    public ViewPagerAdapter(ArrayList<View> Views)
	    {
	        this.Views=Views;
	      //  this.Titles=Titles;
	    }

	    //ï¿½ï¿½È¡PageTitle
	  //  @Override
	  //  public CharSequence getPageTitle(int position) 
	  //  {
	     //    return Titles.get(position);
	   // }

	    @Override
	    public void destroyItem(View container, int position, Object object) 
	    {
	        ((ViewPager)container).removeView(Views.get(position));
	    }
	    @Override
	    public Object instantiateItem(View container, int position) 
	    {
	        ((ViewPager)container).addView(Views.get(position),0);
	        return Views.get(position);
	    }
	    @Override
	    public int getCount() 
	    {
	        if(Views!=null)
	        {
	               return Views.size();
	        }
	        return 0;
	    }
	    @Override
	    public boolean isViewFromObject(View view, Object object) 
	    {
	        return (view==object);
	    }

}
