package com.JessicaDong.knowtheworld;



import java.util.List;
import java.util.Map;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class Me44adapter extends BaseAdapter {
    private List<Map<String, Object>> list;
	//private List<String> arrays = null;
	private Context mContext;
	//private Button curDel_btn;
	//private float x,ux;
	  public EditText edcity;
			private LayoutInflater mInflater;
	public Me44adapter(Context mContext,List<Map<String, Object>> list) {
		//this.mContext = mContext;
		//this.arrays = arrays;
		this.mInflater = LayoutInflater.from(mContext);
		this.list=list;
		//edcity=(EditText)findViewById(R.id.citypost);
	}

	public int getCount() {
		return this.list.size();
	}

	public Object getItem(int position) {
		return null;
	}

	public long getItemId(int position) {
		return position;
	}

	public View getView(final int position, View view, ViewGroup arg2) {
		ViewHolder viewHolder = null;
		if (view == null) {
			viewHolder = new ViewHolder();
			view = LayoutInflater.from(mContext).inflate(R.layout.me44_item, null);
			viewHolder.img = (ImageView)view.findViewById(R.id.commentpost2);
			viewHolder.viewBtndelete = (Button)view.findViewById(R.id.view_btndelete);
			view.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) view.getTag();
		}
		viewHolder.img.setBackgroundResource((Integer)list.get(position).get("img"));
		viewHolder.viewBtndelete.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				//µã»÷delete
				list.remove(position);
				notifyDataSetChanged(); 
			}
		});
		
		
		return view;

	}

	public final class ViewHolder{
		public ImageView img;
		public Button viewBtndelete;
	}
}