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
import android.content.DialogInterface.OnKeyListener;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

/**
 * @author JessicaDong
 * 
 */
public class Means33 extends ListActivity {

    //public EditText edcity;
	private List<Map<String, Object>> mData;
	public List<Map<String, Object>> list;
	public MyAdapter adapter;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	//	setContentView(R.layout.vlist2);
	// edcity=(EditText)findViewById(R.id.citypost);
		mData = getData();
		adapter = new MyAdapter(this);
		setListAdapter(adapter);
	}

	private List<Map<String, Object>> getData() {
		list = new ArrayList<Map<String, Object>>();

		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("city", "北京");
//		map.put("time", "2014.03.01");
//		map.put("info", "溜冰大赛");
		map.put("img", R.drawable.s1);
		list.add(map);
		map = new HashMap<String, Object>();
//		map.put("city", "苏州街");
//		map.put("time", "2014.03.02");
//		map.put("info", "睡衣派对");
		map.put("img", R.drawable.s2);
		list.add(map);

		map = new HashMap<String, Object>();
//		map.put("city", "中华世纪坛");
//		map.put("time", "2014.03.03");
//		map.put("info", "摄影活动");
		map.put("img", R.drawable.s3);
		list.add(map);
		map = new HashMap<String, Object>();
//		map.put("city", "中华世纪坛");
//		map.put("time", "2014.03.03");
//		map.put("info", "摄影活动");
		map.put("img", R.drawable.s4);
		list.add(map);
		map = new HashMap<String, Object>();
//		map.put("city", "中华世纪坛");
//		map.put("time", "2014.03.03");
//		map.put("info", "摄影活动");
		map.put("img", R.drawable.s5);
		list.add(map);
		
		return list;
	}
	
	// ListView 涓煇椤硅閫変腑鍚庣殑閫昏緫
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		
		Log.v("MyListView4-click", (String)mData.get(position).get("title"));
	}
	
	/**
	 * listview涓偣鍑绘寜閿脊鍑哄璇濇
	 */
	public void showInfo(){
//		edcity=(EditText)findViewById(R.id.citypost);
//		if(edcity==null) Log.i("showinfo", "edcity is");
//		else Log.i("showinfo","edcity is null");
//		edcity.setEnabled(true);
//		edcity.setFocusableInTouchMode(true);
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("city", edcity.getText().toString());
//		list.add(map);
		
	}
	
	public void changetext()
	{
		//edcity.setFocusableInTouchMode(true);
		
	}
	

	
	
	public final class ViewHolder{
		public ImageView img;
		//public TextView title;
		//public TextView info;
//		public EditText city;
//		public TextView time;
//		public TextView info;
		public Button viewBtndelete;
//		public Button viewBtnedit;
//		public Button viewBtnpost;
	}
	
	
	public class MyAdapter extends BaseAdapter{
		  public EditText edcity;
		private LayoutInflater mInflater;
	   
		public MyAdapter(Context context){
			this.mInflater = LayoutInflater.from(context);
			edcity=(EditText)findViewById(R.id.citypost);
		}
		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return mData.size();
		}

		@Override
		public Object getItem(int arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public long getItemId(int arg0) {
			// TODO Auto-generated method stub
			return 0;
		}
public String string;
		@Override
		public View getView(final int position, View convertView, ViewGroup parent) {
			
			ViewHolder holder = null;
			if (convertView == null) {
				
			
				holder=new ViewHolder();  
				
				convertView = mInflater.inflate(R.layout.vlist3, null);
				holder.img = (ImageView)convertView.findViewById(R.id.imgpost);
//				holder.city = (EditText)convertView.findViewById(R.id.citypost);
//				holder.time = (TextView)convertView.findViewById(R.id.timepost);
//				holder.info = (TextView)convertView.findViewById(R.id.infopost);
				holder.viewBtndelete = (Button)convertView.findViewById(R.id.view_btndelete);
//				holder.viewBtnedit = (Button)convertView.findViewById(R.id.view_btnedit);
//				holder.viewBtnpost=(Button)convertView.findViewById(R.id.view_btnpost);
				
				convertView.setTag(holder);
				Log.i("final position", position+"");
			}else {
				
				holder = (ViewHolder)convertView.getTag();
			}
			
			
//			holder.img.setBackgroundResource((Integer)mData.get(position).get("img"));
//			holder.title.setText((String)mData.get(position).get("title"));
//			holder.info.setText((String)mData.get(position).get("info"));
//			
//			holder.viewBtn.setOnClickListener(new View.OnClickListener() 
	//final EditText edcity=(EditText)findViewById(R.id.citypost);;
			holder.img.setBackgroundResource((Integer)mData.get(position).get("img"));
//			holder.city.setText((String)mData.get(position).get("city"));
//			holder.time.setText((String)mData.get(position).get("time"));
//			holder.info.setText((String)mData.get(position).get("info"));
			holder.viewBtndelete.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					//点击delete
					list.remove(position);
					adapter.notifyDataSetChanged();  
				}
			});
//			holder.viewBtnedit.setOnClickListener(new View.OnClickListener()
//			{
//				
//				//点击编辑是调用的方法
//				@Override
//				public void onClick(View v) {
//				//	showInfo();
//					//changetext();
//			edcity=(EditText)findViewById(R.id.citypost);
//			if(edcity!=null) Log.i("edcity", "viewedit ");
//					edcity.setFocusableInTouchMode(true);
//					edcity.setEnabled(true);
//					//holder.city.setText(edcity.getText().toString());
//					//holder.city.setText(edcity.getText().toString());
//					
//				}
//			});
//			holder.viewBtnpost.setOnClickListener(new View.OnClickListener(){
//
//				@Override
//				public void onClick(View arg0) {
//					// TODO Auto-generated method stub
//					string=edcity.getText().toString();
//					Log.i("edcity text",string);
//					Map<String, Object> map = new HashMap<String, Object>();
//					map=list.get(position);
//					map.put("city", string);
//					list.set(position, map);
//					edcity.setFocusableInTouchMode(false);
//					InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
//                    imm.toggleSoftInput(
//                            InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
//                    edcity.setText(string);
//				}
//				
//			});
			//这样写不行，会把listview中每个的city都变成改之后的值，所以上面是改了当前position的值
			//if(string!=null)
			//	edcity.setText(string);
			//holder.city.setText(string);
			return convertView;
			//这样按删除可以删除这个view，编辑可以改地点，但一定要按发布才能把改的值放进去
		}
	}	
}
