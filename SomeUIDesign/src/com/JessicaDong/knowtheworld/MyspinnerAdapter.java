package com.JessicaDong.knowtheworld;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * @author liangjie
 * @version create time:2013-9-23_����10:53:29
 * @Description ������adpter
 */
public class MyspinnerAdapter extends BaseAdapter {
	LayoutInflater inflater;
	Context context;
	ArrayList<String> list;

	public MyspinnerAdapter(Context context, ArrayList<String> list) {
		super();
		this.context = context;
		this.list = list;
		inflater = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder viewHolder = null;
		if (convertView == null) {
			convertView = inflater.inflate(R.layout.myspinner_dropdown_items, null);
			viewHolder = new ViewHolder();
			viewHolder.textView = (TextView) convertView.findViewById(R.id.text1);
			convertView.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) convertView.getTag();
		}
		viewHolder.textView.setText(list.get(position));
		return convertView;
	}

	public class ViewHolder {
		TextView textView;
	}

	public void refresh(List<String> l) {
		this.list.clear();
		list.addAll(l);
		notifyDataSetChanged();
	}

	public void add(String str) {
		list.add(str);
		notifyDataSetChanged();
	}

	public void add(ArrayList<String> str) {
		list.addAll(str);
		notifyDataSetChanged();

	}
}