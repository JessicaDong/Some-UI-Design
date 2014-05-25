package com.JessicaDong.knowtheworld;

import java.util.HashMap;
import java.util.List;
import java.util.Map;



import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;

public class Me6Adapter extends BaseAdapter{
    private Context mContext;
    private LayoutInflater mInflater;  
    private List<Map<String, Object>> list;
	public Me6Adapter (Context context, List<Map<String, Object>> list)
	{
		this.mInflater = LayoutInflater.from(context);
		this.list=list;
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
		//return 0;
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

	@Override
	public View getView(final int position, View convertView, ViewGroup arg2) {
		// TODO Auto-generated method stub
		

		ViewHolder holder = null;
		if (convertView == null) {
			
		
			holder=new ViewHolder();  
			
			convertView = mInflater.inflate(R.layout.vlist6, null);
			holder.img = (ImageView)convertView.findViewById(R.id.imgpost);
			holder.viewBtndelete = (Button)convertView.findViewById(R.id.view_btndelete);
			holder.viewBtnadd = (Button)convertView.findViewById(R.id.view_btnadd);
			convertView.setTag(holder);
			Log.i("final position", position+"");
		}else {
			
			holder = (ViewHolder)convertView.getTag();
		}
		holder.img.setBackgroundResource((Integer)list.get(position).get("img"));
		holder.viewBtndelete.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				//点击delete
				list.remove(position);
				notifyDataSetChanged();  
			}
		});
		holder.viewBtnadd.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Map<String, Object> map = new HashMap<String, Object>();
				
				map.put("img", R.drawable.f1);
				list.add(map);
				notifyDataSetChanged(); 
				Log.i("Me66add", "调用了add");
			}
		});
		return convertView;
		//return null;
	}
	public final class ViewHolder{
		public ImageView img;
		public Button viewBtndelete;
		public Button viewBtnadd;
	}

}
