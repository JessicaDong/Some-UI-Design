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
public class Me44 extends ListActivity {

    //public EditText edcity;
	private List<Map<String, Object>> mData;
	public List<Map<String, Object>> list;
	public MyAdapter adapter;
	 private ListView mylistview;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	//	setContentView(R.layout.vlist2);
	// edcity=(EditText)findViewById(R.id.citypost);
		setContentView(R.layout.activity_me44);
		mData = getData();
		mylistview = (ListView) findViewById(R.id.list);
		adapter = new MyAdapter(this);
		mylistview.setAdapter(adapter);
		mylistview.setOnItemClickListener(new OnItemClickListener() {

			   @Override
			   public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
			     long arg3) {
			   if(arg2==0) 
			   {
				   Intent it=new Intent(Me44.this, Collec.class);
				   startActivity(it);
			   }
			   }

			  });
	}

	private List<Map<String, Object>> getData() {
		list = new ArrayList<Map<String, Object>>();

		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("img", R.drawable.commen4);
		list.add(map);
		
		map = new HashMap<String, Object>();		
		map.put("img", R.drawable.commen1);
		list.add(map);

		map = new HashMap<String, Object>();
		map.put("img", R.drawable.commen2);
		list.add(map);
		map = new HashMap<String, Object>();
		map.put("img", R.drawable.commen3);
		list.add(map);
		map = new HashMap<String, Object>();
		map.put("img", R.drawable.commen5);
		list.add(map);
		return list;
	}
	
	
	
	public final class ViewHolder{
		public ImageView img;
		public Button viewBtndelete;
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
				
				convertView = mInflater.inflate(R.layout.me44_item, null);
				holder.img = (ImageView)convertView.findViewById(R.id.commentpost2);
				holder.viewBtndelete = (Button)convertView.findViewById(R.id.view_btndelete);
				
				convertView.setTag(holder);
				Log.i("final position", position+"");
			}else {
				
				holder = (ViewHolder)convertView.getTag();
			}
			holder.img.setBackgroundResource((Integer)mData.get(position).get("img"));
			holder.viewBtndelete.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					//µã»÷delete
					list.remove(position);
					adapter.notifyDataSetChanged();  
				}
			});
			
			return convertView;
		}
	
		
		
	}	
}
