package com.JessicaDong.knowtheworld;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;


/**
 * 
 * @{# GuideActivity.java Create on 2013-5-2 涓嬪�?0:59:08
 * 
 *     class desc: 寮曞鐣岄潰
 * 
 *     <p>
 *     Copyright: Copyright(c) 2013
 *     </p>
 * @Version 1.0
 * @Author <a href="mailto:gaolei_xj@163.com">Leo</a>
 * 
 * 
 */

public class GuideActivity1 extends Activity implements OnPageChangeListener{
	
	

	
	

		private ViewPager vp;
		private ViewAdapter3 vpAdapter;
		private List<View> views3;

		// 搴曢儴灏忕偣鍥剧�?
		private ImageView[] dots;

		// 璁板綍褰撳墠閫変腑浣嶇疆
		private int currentIndex;
		//private LayoutInflater inflater2; 
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			  requestWindowFeature(Window.FEATURE_NO_TITLE);// ��������
			setContentView(R.layout.guide);

			// 鍒濆鍖栭�?闈�
			Log.i("GuideActivity", "onCreat");
			initViews();

			// 鍒濆鍖栧簳閮ㄥ皬鐐�?
			initDots();
		}

		private void initViews() {
			LayoutInflater inflater2 = LayoutInflater.from(this);
			Log.i("GuideActivity", "initviews1");
			views3 = new ArrayList<View>();
			Log.i("GuideActivity", "initviews2");
			// 鍒濆鍖栧紩瀵煎浘鐗囧垪琛�
			views3.add(inflater2.inflate(R.layout.activity_init1, null));
			Log.i("GuideActivity", "init1");
			views3.add(inflater2.inflate(R.layout.activity_init2, null));
			Log.i("GuideActivity", "init2");
			views3.add(inflater2.inflate(R.layout.activity_init3, null));
			Log.i("GuideActivity", "init3");
		    views3.add(inflater2.inflate(R.layout.activity_init4, null));
			Log.i("GuideActivity", "init4");
			views3.add(inflater2.inflate(R.layout.activity_init5, null));
			Log.i("GuideActivity", "init5");
			views3.add(inflater2.inflate(R.layout.activity_init6, null));
			Log.i("GuideActivity", "init6");
			// 鍒濆鍖朅dapter
			vpAdapter = new ViewAdapter3(views3, this);
			Log.i("GuideActivity", "initviews4");
			vp = (ViewPager) findViewById(R.id.viewpagerguide);
			vp.setAdapter(vpAdapter);
			// 缁戝畾鍥炶皟
			vp.setOnPageChangeListener(this);
			Log.i("GuideActivity", "initviews finish");
		}

		private void initDots() {
			Log.i("GuideActivity", "initdots ");
			LinearLayout ll = (LinearLayout) findViewById(R.id.ll);

			dots = new ImageView[views3.size()];
			//dots = new ImageView[6];

			// 寰幆鍙栧緱灏忕偣鍥剧墖
			for (int i = 0; i < views3.size(); i++) {
			//for (int i = 0; i < 6; i++) {
				dots[i] = (ImageView) ll.getChildAt(i);
				dots[i].setEnabled(true);// 閮�?涓虹伆鑹�
			}

			currentIndex = 0;
			dots[currentIndex].setEnabled(false);// 璁剧疆涓虹櫧鑹诧紝鍗抽�涓姸鎬�?
			
			Log.i("GuideActivity", "initdots finish");
		}

		private void setCurrentDot(int position) {
			if (position < 0 || position > views3.size() - 1
					|| currentIndex == position) {
				return;
			}

			dots[position].setEnabled(false);
//			switch (position) {
//			case 0:
//				views3.add(inflater2.inflate(R.layout.activity_init1, null));
//				
//				break;
//			case 1:
//				views3.add(inflater2.inflate(R.layout.activity_init2, null));
//				break;
//			case 2:
//				views3.add(inflater2.inflate(R.layout.activity_init3, null));
//				break;
//			case 3:
//				views3.add(inflater2.inflate(R.layout.activity_init4, null));
//				break;
//			case 4:
//				views3.add(inflater2.inflate(R.layout.activity_init5, null));
//				break;
//			case 5:
//				views3.add(inflater2.inflate(R.layout.activity_init6, null));
//				break;
//
//			default:
//				break;
//			}
			dots[currentIndex].setEnabled(true);

			currentIndex = position;
		}

		// 褰撴粦鍔ㄧ姸鎬佹敼鍙樻椂璋冪�?
		@Override
		public void onPageScrollStateChanged(int arg0) {
		}

		// 褰撳綋鍓嶉�?闈㈣婊戝姩鏃惰皟鐢�?
		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {
		}

		// 褰撴柊鐨勯�?闈㈣閫変腑鏃惰皟鐢�?
		@Override
		public void onPageSelected(int arg0) {
			// 璁剧疆搴曢儴灏忕偣閫変腑鐘舵�?
			setCurrentDot(arg0);
		}

	


}
