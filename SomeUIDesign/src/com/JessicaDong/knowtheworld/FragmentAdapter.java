package com.JessicaDong.knowtheworld;


import java.util.Locale;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerTitleStrip;

/*
 * 涓嶮ainActivity1 閰嶅悎浣跨敤瀹炵幇tab鍜寁iewpager涓?捣婊戝姩
 */

public class FragmentAdapter extends FragmentPagerAdapter{

	private Context mContext;
	

		public FragmentAdapter(Context context, FragmentManager fm) {
			super(fm);
			mContext = context;
			
		}

		@Override
		public Fragment getItem(int position) {
			Fragment fragment;
//			if (position == 2) {
//				fragment = new AboutMeFragment();
//			} else {
//				fragment = new TabFragment();
//				Bundle args = new Bundle();
//				args.putInt(TabFragment.TAB_POSITION, position + 1);
//				fragment.setArguments(args);
//			}
			
			int newposition;
			 newposition=(position)%3;//改为三个页面%3
			
			
			switch ( newposition) {
			case 0:fragment = new ColFragment();
				return fragment;
				
			case 1:fragment = new FriFregment();
				return fragment;
			
			case 2:fragment = new CatFragment(); //由HotFragment 改为CatFragment
				return fragment;
			
//			case 3:fragment = new CatFragment();
//				return fragment;                       主页第四个界面
				default : return null;
			}
			//return fragment;
		}
//鎬婚〉闈釜鏁?
		@Override
		public int getCount() {
			//return 4;
			return Integer.MAX_VALUE;
		}

		@Override
		public CharSequence getPageTitle(int position) {
//			if (position == 2) {
//				return mContext.getString(R.string.about_me_title);
//			} else {
//				Locale l = Locale.getDefault();
//				return mContext.getString(R.string.tab_fragment_title, position + 1).toUpperCase(l);
//			}
			int newposition;
			 newposition=(position)%3; //主页由4个改为3个，所以%3
			//if(position>=0) newposition=(position+400)%4;
			//else newposition = (-position)%4;
			
			switch ( newposition) {
			case 0:
				return mContext.getString(R.string.about_col);
				
			case 1:
				return mContext.getString(R.string.about_friend);
			
			case 2:
				return mContext.getString(R.string.about_cat); //hot改为cat
			
//			case 3:
//				return mContext.getString(R.string.about_cat); 改为3个主页面，注释掉
				default : return null;
			

			}
		}
	

	
}
