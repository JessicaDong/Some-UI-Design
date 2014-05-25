package com.JessicaDong.knowtheworld;


import android.R.string;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.Window;

/**
 * 
 * @{# SplashActivity.java Create on 2013-5-2 涓嬪�?:10:01
 * 
 *     class desc: 鍚姩鐢婚潰 (1)鍒ゆ柇鏄惁鏄娆″姞杞藉簲鐢�?閲囧彇璇诲彇SharedPreferences鐨勬柟娉�?
 *     (2)鏄紝鍒欒繘鍏uideActivity锛涘惁锛屽垯杩涘叆MainActivity (3)3s鍚庢墽琛�?)鎿嶄�?
 * 
 *     <p>
 *     Copyright: Copyright(c) 2013
 *     </p>
 * @Version 1.0
 * @Author <a href="mailto:gaolei_xj@163.com">Leo</a>
 * 
 * 
 */
public class SplashActivity1 extends Activity{

	
	

		boolean isFirstIn = false;

		private static final int GO_HOME = 1000;
		private static final int GO_GUIDE = 1001;
		// 寤惰�?绉�
		private static final long SPLASH_DELAY_MILLIS = 3000;

		private static final String SHAREDPREFERENCES_NAME = "first_pref";

		/**
		 * Handler:璺宠浆鍒颁笉鍚岀晫闈�?
		 */
		private Handler mHandler1 = new Handler() {

			@Override
			public void handleMessage(Message msg) {
				switch (msg.what) {
				case GO_HOME:
					Log.i("splash ", "case to gohome");
					//goHome(); �����ȸĳ�ÿ������������
					goGuide();
					break;
				case GO_GUIDE:
					Log.i("splash ", "case to goguide");
					goGuide();
					break;
				}
				super.handleMessage(msg);
			}
		};

		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			  requestWindowFeature(Window.FEATURE_NO_TITLE);// ��������
			setContentView(R.layout.splash);
Log.i("splash ", "onCreat");
			init();
		}

		private void init() {
			// 璇诲彇SharedPreferences涓渶瑕佺殑鏁版�?
			// 浣跨敤SharedPreferences鏉ヨ褰曠▼搴忕殑浣跨敤娆℃�?
			SharedPreferences preferences = getSharedPreferences(
					SHAREDPREFERENCES_NAME, MODE_PRIVATE);

			// 鍙栧緱鐩稿簲鐨勫�锛屽鏋滄病鏈夎鍊硷紝璇存槑杩樻湭鍐欏叆锛岀敤true浣滀负榛樿鍊�
			isFirstIn = preferences.getBoolean("isFirstIn", true);
			
			Log.i("splash ", "isFirstIn");
			// 鍒ゆ柇绋嬪簭涓庣鍑犳杩愯锛屽鏋滄槸绗竴娆¤繍琛屽垯璺宠浆鍒板紩�?肩晫闈紝鍚�?��璺宠浆鍒颁富鐣岄�?
			if (!isFirstIn) {
				// 浣跨敤Handler鐨刾ostDelayed鏂规硶锛�绉掑悗鎵ц璺宠浆鍒癕ainActivity
				mHandler1.sendEmptyMessageDelayed(GO_HOME, SPLASH_DELAY_MILLIS);
				Log.i("splash ", "isFirstIn  gohome");
			} else {
				mHandler1.sendEmptyMessageDelayed(GO_GUIDE, SPLASH_DELAY_MILLIS);
				Log.i("splash ", "isFirstIn  goguide");
			}

		}

		private void goHome() {
			Log.i("splash ", " gohome");
			Intent intent = new Intent(SplashActivity1.this, MainActivity1.class);
			SplashActivity1.this.startActivity(intent);
			SplashActivity1.this.finish();
		}

		private void goGuide() {
			Log.i("splash ", " private void goguide");
			Intent intent = new Intent(SplashActivity1.this, GuideActivity1.class);
			SplashActivity1.this.startActivity(intent);
			SplashActivity1.this.finish();
		}
	

}
