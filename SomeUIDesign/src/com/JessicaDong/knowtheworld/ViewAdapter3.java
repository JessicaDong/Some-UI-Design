package com.JessicaDong.knowtheworld;



import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;


/**
 * 
 * @{# ViewPagerAdapter.java Create on 2013-5-2 涓嬪�?1:03:39
 * 
 *     class desc: 寮曞椤甸潰閫傞厤鍣�?
 * 
 *     <p>
 *     Copyright: Copyright(c) 2013
 *     </p>
 * @Version 1.0
 * @Author <a href="mailto:gaolei_xj@163.com">Leo</a>
 * 
 * 
 */
public class ViewAdapter3 extends PagerAdapter{

	
	

		// 鐣岄潰鍒楄�?
		private List<View> views;
		private Activity activity;

		private static final String SHAREDPREFERENCES_NAME = "first_pref";

		public ViewAdapter3 (List<View> views, Activity activity) {
			this.views = views;
			this.activity = activity;
		}

		// 閿�瘉arg1浣嶇疆鐨勭晫闈�
		@Override
		public void destroyItem(View arg0, int arg1, Object arg2) {
			((ViewPager) arg0).removeView(views.get(arg1));
		}

		@Override
		public void finishUpdate(View arg0) {
		}

		// 鑾峰緱褰撳墠鐣岄潰鏁�?
		@Override
		public int getCount() {
			if (views != null) {
				return views.size();
			}
			return 0;
		}

		// 鍒濆鍖朼rg1浣嶇疆鐨勭晫闈�
		@Override
		public Object instantiateItem(View arg0, int arg1) {
			((ViewPager) arg0).addView(views.get(arg1), 0);
			if (arg1 == views.size() - 1) {
				ImageView mStartWeiboImageButton = (ImageView) arg0
						.findViewById(R.id.iv_start_weibo);
				mStartWeiboImageButton.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View v) {
						// 璁剧疆宸茬粡寮曞�?
						Log.i("init6 button", "click");
						setGuided();
						goHome();
						

					}

				});
			}
			return views.get(arg1);
		}

		private void goHome() {
			// 璺宠�?
			Log.i("init6 button", "gohome1");
			Intent intent = new Intent(activity, MainActivity1.class); //����ҳ����MainActivity1��ΪMainActivity2
			Log.i("init6 button", "gohome2");
			activity.startActivity(intent);
			Log.i("init6 button", "startintent");
			//for(int i=0;i<views.size();i++)
			//{
			//	destroyItem(activity, i, views);
			//}
			activity.finish();
			//activity.de
			Log.i("init6 button", "finish");
		}

		/**
		 * 
		 * method desc锛氳缃凡缁忓紩�?艰繃浜嗭紝涓嬫鍚姩涓嶇敤鍐嶆寮曞
		 */
		private void setGuided() {
			SharedPreferences preferences = activity.getSharedPreferences(
					SHAREDPREFERENCES_NAME, Context.MODE_PRIVATE);
			Editor editor = preferences.edit();
			// 瀛樺叆鏁版嵁
			editor.putBoolean("isFirstIn", false);
			// 鎻愪氦淇敼
			editor.commit();
			Log.i("init6 button", "setguide");
		}

		// 鍒ゆ柇鏄惁鐢卞璞＄敓鎴愮晫闈�?
		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			return (arg0 == arg1);
		}

		@Override
		public void restoreState(Parcelable arg0, ClassLoader arg1) {
		}

		@Override
		public Parcelable saveState() {
			return null;
		}

		@Override
		public void startUpdate(View arg0) {
		}
		public void startMain(View v)
		{
			Log.i("click", "Main");
			setGuided();
			goHome();
			
		}
		  

}
