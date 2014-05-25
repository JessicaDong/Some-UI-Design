/**
 * 
 */
package com.JessicaDong.knowtheworld;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



import android.R.string;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnKeyListener;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

/**
 * @author JessicaDong
 * 
 */
public class Me66 extends ListActivity {

    //public EditText edcity;
	private List<Map<String, Object>> mData;
	public List<Map<String, Object>> list;
	//public MyAdapter adapter;
	private Me6Adapter adapter;
	private ListView friendListView;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.me66);
		Log.i("Me66", "setview");
	// edcity=(EditText)findViewById(R.id.citypost);
		mData = getData();
		//friendListView=(ListView)findViewById(R.id.list);
		friendListView=getListView();
		
		adapter = new Me6Adapter(Me66.this,mData);
		friendListView.setAdapter(adapter);
	}

	private List<Map<String, Object>> getData() {
		list = new ArrayList<Map<String, Object>>();

		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("img", R.drawable.f1);
		list.add(map);
		
		map = new HashMap<String, Object>();		
		map.put("img", R.drawable.f2);
		list.add(map);

		map = new HashMap<String, Object>();
		map.put("img", R.drawable.f3);
		list.add(map);
		map = new HashMap<String, Object>();
		map.put("img", R.drawable.f4);
		list.add(map);
		map = new HashMap<String, Object>();
		map.put("img", R.drawable.f5);
		list.add(map);
		map = new HashMap<String, Object>();
		map.put("img", R.drawable.f6);
		map = new HashMap<String, Object>();
		map.put("img", R.drawable.f7);
		map = new HashMap<String, Object>();
		map.put("img", R.drawable.f8);
		map = new HashMap<String, Object>();
		map.put("img", R.drawable.f9);
		list.add(map);
		
		return list;
	}
	protected void onListItemClick (ListView l, View v, int position, long id)
	{
		Log.i("itemclick", "click");
		if(position==1) 
		{
			Intent it=new Intent(Me66.this,Collec.class);
			startActivity(it);
		}
	}	
	
//	public final class ViewHolder{
//		public ImageView img;
//		public Button viewBtndelete;
//		public Button viewBtnadd;
//	}
//	
//	
//	public class MyAdapter extends BaseAdapter{
//		  public EditText edcity;
//		private LayoutInflater mInflater;
//	   
//		public MyAdapter(Context context){
//			this.mInflater = LayoutInflater.from(context);
//			edcity=(EditText)findViewById(R.id.citypost);
//		}
//		@Override
//		public int getCount() {
//			// TODO Auto-generated method stub
//			return mData.size();
//		}
//
//		@Override
//		public Object getItem(int arg0) {
//			// TODO Auto-generated method stub
//			
//			return null;
//		}
//
//		@Override
//		public long getItemId(int arg0) {
//			// TODO Auto-generated method stub
//			return 0;
//		}
//        public String string;
//		@Override
//		public View getView(final int position, View convertView, ViewGroup parent) {
//			
//			ViewHolder holder = null;
//			if (convertView == null) {
//				
//			
//				holder=new ViewHolder();  
//				
//				convertView = mInflater.inflate(R.layout.vlist6, null);
//				holder.img = (ImageView)convertView.findViewById(R.id.imgpost);
//				holder.viewBtndelete = (Button)convertView.findViewById(R.id.view_btndelete);
//				holder.viewBtnadd = (Button)convertView.findViewById(R.id.view_btnadd);
//				convertView.setTag(holder);
//				Log.i("final position", position+"");
//			}else {
//				
//				holder = (ViewHolder)convertView.getTag();
//			}
//			holder.img.setBackgroundResource((Integer)mData.get(position).get("img"));
//			holder.viewBtndelete.setOnClickListener(new View.OnClickListener() {
//				
//				@Override
//				public void onClick(View arg0) {
//					// TODO Auto-generated method stub
//					//点击delete
//					list.remove(position);
//					adapter.notifyDataSetChanged();  
//				}
//			});
//			holder.viewBtnadd.setOnClickListener(new View.OnClickListener() {
//				
//				@Override
//				public void onClick(View arg0) {
//					// TODO Auto-generated method stub
//					Map<String, Object> map = new HashMap<String, Object>();
//					
//					map.put("img", R.drawable.f1);
//					list.add(map);
//					adapter.notifyDataSetChanged(); 
//					Log.i("Me66add", "调用了add");
//				}
//			});
//			return convertView;
//		}
	}	

