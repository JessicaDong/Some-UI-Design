package com.JessicaDong.knowtheworld;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ViewPager1 extends LinearLayout {
	
	    /* 数据�?begin */
	    public final static String TAG = "TabViewPager";
	    private Context mContext;
	    
	    private LinearLayout mTabHost;
	    private ImageView mUnderline;
	    private ViewPager mViewPager;
	    //主页topic 栏的textview
	    private TextView[] tab2;
	    
	    String[] tabTitles2;
	    //tab��underline��ȣ�Ҳ��underline����С�ƶ�����
	    private int mTabWidth;
	    /* ��ݶ�end */
	    
	    /* �����begin */
	    public ViewPager1(Context context, AttributeSet attrs)
	    {
	        super(context, attrs);
	        
	        mContext = context;
	        
	        inflate(mContext, R.layout.tab_view_pager, this);
	        initViews();
	    }
	    
	    private void initViews()
	    {
	        mTabHost = (LinearLayout) findViewById(R.id.tab_host);
	        mUnderline = (ImageView) findViewById(R.id.tab_underline);
	        mViewPager = (ViewPager) findViewById(R.id.view_pager);
	    }
	    
	    public void initTabs(String[] tabTitles, int parentWidth)
	    {
	    	//得到�?��的textview
	    	tab2 = new TextView[4];
	    	
	        LinearLayout.LayoutParams tabHostLayoutParams;
	        TextView tab;
	        tabTitles2=tabTitles;
	        mTabWidth = parentWidth / tabTitles.length;
	      //  mTabHight =  parentHight / tabTitles.length;
	        
	        //���ÿ��?
	        if (tabTitles.length > 0)
	        {
	            tabHostLayoutParams = new LinearLayout.LayoutParams(mTabWidth, LinearLayout.LayoutParams.WRAP_CONTENT);
	        }
	        else
	        {
	            return;
	        }
	        
	        //��̬���tab
	        for (int loopVal = 0; loopVal < tabTitles.length; loopVal++)
	        {
	            tab = new TextView(mContext);
	            tab.setText(tabTitles[loopVal]);
	            tab.setTextSize(22);
	            //tab.setTextColor(getResources().getColor(R.color.white));
	            tab.setTextColor(getResources().getColor(R.color.black));
	            
	            tabHostLayoutParams.weight = 1;
	            tabHostLayoutParams.gravity = Gravity.CENTER_VERTICAL;
	            tab.setLayoutParams(tabHostLayoutParams);
	            tab.setGravity(Gravity.CENTER);
	            
	            tab.setOnClickListener(new TabOnClickListener(loopVal));
	            
	            
	            mTabHost.addView(tab);
	            tab2[loopVal]=tab;
	        }
	        //初始时第�?��“收藏�?为蓝
	        tab2[0].setTextColor(getResources().getColor(R.color.blue1));
	        
	        //����underline��ȣ�ʹ���»�����tab��ȱ���һ��?
	        FrameLayout.LayoutParams frameLayoutParams = new FrameLayout.LayoutParams(mTabWidth, FrameLayout.LayoutParams.WRAP_CONTENT);
	        frameLayoutParams.gravity = Gravity.BOTTOM;
	        FrameLayout.LayoutParams frameLayoutParams2 = new FrameLayout.LayoutParams(mTabWidth, 3);
	        mUnderline.setLayoutParams(frameLayoutParams);
	       // mUnderline.setBackgroundDrawable(getResources().getDrawable(R.drawable.tab_view_pager_underline));
	    }
	    
	    public void setAdapter(PagerAdapter pagerAdapter)
	    {
	        mViewPager.setAdapter(pagerAdapter);
	        //����viewPagerʱҲҪִ��mUnderline���ƶ�����
	        mViewPager.setOnPageChangeListener(new OnPageChangeListener()
	        {
	            private int currentPosition = -1;
	            private int nextPosition = -1;
	            
	            @SuppressLint("ResourceAsColor")
				@Override
	            public void onPageSelected(int position)
	            {
	                nextPosition = position;
	                //mUnderline���ƶ�����
	                mUnderline.startAnimation(new UnderlineTranslateAnimation(currentPosition * mTabWidth, nextPosition * mTabWidth, 0, 0));
	                
	                //改变选中页字体颜�?
	                for( int i=0;i<4;i++)
	                {
	                	if(i==position)
	                		tab2[i].setTextColor(getResources().getColor(R.color.blue1));
	                	else tab2[i].setTextColor(getResources().getColor(R.color.black));
	                }
	            }
	            
	            @Override
	            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels)
	            {
	                currentPosition = position;
	            }
	            
	            @Override
	            public void onPageScrollStateChanged(int state)
	            {
	            }
	        });
	    }
	    
	    public void setCurrentItem(int position)
	    {
	        //��¼��ǰ��λ�ú�������ѡ��λ��
	        int currentPosition = mViewPager.getCurrentItem();
	        mViewPager.setCurrentItem(position);
	       // tabTitles2[position].setTextColor(getResources().getColor(R.color.blue1));
	      //  tab2[position].setTextColor(getResources().getColor(R.color.blue1));
	        Log.i("zi", "blue");
	        int nextPosition = mViewPager.getCurrentItem();
	        
	        //mUnderline���ƶ�����
	        mUnderline.startAnimation(new UnderlineTranslateAnimation(currentPosition * mTabWidth, nextPosition * mTabWidth, 0, 0));
	    }
	    /* �����end */
	    
	    /* �ڲ���begin */
	    private class TabOnClickListener implements OnClickListener
	    {
	        private int viewPosition = -1;
	        
	        public TabOnClickListener(int position)
	        {
	            viewPosition = position;
	        }
	        
	        @Override
	        public void onClick(View v)
	        {
	           // if (AppEnv.bAppdebug)
	           // {
	           //     Log.d(TAG, "tab onClick --> " + ((TextView) v).getText());
	           // }
	            
	            setCurrentItem(viewPosition);
	        }
	    }
	    
	    private class UnderlineTranslateAnimation extends TranslateAnimation
	    {
	        public UnderlineTranslateAnimation(float fromXDelta, float toXDelta, float fromYDelta, float toYDelta)
	        {
	            super(fromXDelta, toXDelta, fromYDelta, toYDelta);
	            
	            setFillAfter(true);
	        }
	        
	    }
	    /* �ڲ���end */
	}

