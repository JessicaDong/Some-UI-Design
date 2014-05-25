package com.JessicaDong.knowtheworld;

//有关背景改变的都注释掉，不需要在按下和抬起时改变背景

import java.util.List;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ListViewAdapter2 extends BaseAdapter {

	//private List<String> arrays = null;
	private List<View> arrays = null;
	private Context mContext;
	private Button curDel_btn;
	private float x,ux;
	private ImageView imageView;

	 private int[] images = { R.drawable.post1, R.drawable.post2, R.drawable.post3,R.drawable.post4,R.drawable.post5 };
	 
	public ListViewAdapter2(Context mContext, List<View> arrays) {
		this.mContext = mContext;
		this.arrays = arrays;
		 for (int i = 0; i < images.length; i++) {
			              imageView = new ImageView(mContext);
			              imageView.setBackgroundResource(images[i]);
			              arrays.add(imageView);
			              Log.i("listadapter", "setview");
			          }

	}

	public int getCount() {
		return this.arrays.size();
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
			view = LayoutInflater.from(mContext).inflate(R.layout.activity_slidedeleteitem, null);
			viewHolder.ivview = (ImageView) view.findViewById(R.id.img);//改了这里，textview变为image'view
			viewHolder.btnDel = (Button) view.findViewById(R.id.del);
			view.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) view.getTag();
		}
		
		//为每一个view项设置触控监听
		view.setOnTouchListener(new OnTouchListener() {
			public boolean onTouch(View v, MotionEvent event) {
				
				final ViewHolder holder = (ViewHolder) v.getTag();
				
				//当按下时处理
				if (event.getAction() == MotionEvent.ACTION_DOWN) {
					
					//设置背景为选中状态
					//v.setBackgroundResource(R.drawable.mm_listitem_pressed);
					//获取按下时的x轴坐标
					x = event.getX();
					//判断之前是否出现了删除按钮如果存在就隐藏
					if (curDel_btn != null) {
						curDel_btn.setVisibility(View.GONE);
					}
					
				} else if (event.getAction() == MotionEvent.ACTION_UP) {// 松开处理
					
					//设置背景为未选中正常状态
				//	v.setBackgroundResource(R.drawable.mm_listitem_simple);
					//获取松开时的x坐标
					ux = event.getX();
					
					//判断当前项中按钮控件不为空时
					if (holder.btnDel != null) {
						
						//按下和松开绝对值差当大于20时显示删除按钮，否则不显示
						
						if (Math.abs(x - ux) > 20) {
							holder.btnDel.setVisibility(View.VISIBLE);
							curDel_btn = holder.btnDel;
						}
					}
				} else if (event.getAction() == MotionEvent.ACTION_MOVE) {//当滑动时背景为选中状态

				//	v.setBackgroundResource(R.drawable.mm_listitem_pressed);
					
				} else {//其他模式
					//设置背景为未选中正常状态
				//	v.setBackgroundResource(R.drawable.mm_listitem_simple);
				}

				return true;
			}
		});
		//viewHolder.tvTitle.setText(this.arrays.get(position));
		//settext换成setview
		//viewHolder.ivview.setima;
		
		//为删除按钮添加监听事件，实现点击删除按钮时删除该项
		viewHolder.btnDel.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				if(curDel_btn!=null)
					curDel_btn.setVisibility(View.GONE);
				arrays.remove(position);
				notifyDataSetChanged();
				
			}
		});
		return view;

	}

	final static class ViewHolder {
		//TextView tvTitle;
		//textview换成imageview
		ImageView ivview;
		Button btnDel;
	}
}