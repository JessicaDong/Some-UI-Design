package com.JessicaDong.knowtheworld;



import java.util.List;
import android.content.Context;
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

public class SlideDeleteAdapter extends BaseAdapter {

	private List<View> arrays = null;
	private Context mContext;
	private Button curDel_btn;
	private float x,ux;

	public SlideDeleteAdapter(Context mContext, List<View> arrays) {
		this.mContext = mContext;
		this.arrays = arrays;
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
			//viewHolder.tvTitle = (TextView) view.findViewById(R.id.title);
			viewHolder.image = (ImageView) view.findViewById(R.id.img);
			viewHolder.btnDel = (Button) view.findViewById(R.id.del);
			view.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) view.getTag();
		}
		
		//Ϊÿһ��view�����ô��ؼ���
		view.setOnTouchListener(new OnTouchListener() {
			public boolean onTouch(View v, MotionEvent event) {
				
				final ViewHolder holder = (ViewHolder) v.getTag();
				
				//������ʱ����
				if (event.getAction() == MotionEvent.ACTION_DOWN) {
					
					//���ñ���Ϊѡ��״̬
				//	v.setBackgroundResource(R.drawable.mm_listitem_pressed);
					//��ȡ����ʱ��x������
					x = event.getX();
					//�ж�֮ǰ�Ƿ������ɾ����ť������ھ�����
					if (curDel_btn != null) {
						curDel_btn.setVisibility(View.GONE);
					}
					
				} else if (event.getAction() == MotionEvent.ACTION_UP) {// �ɿ�����
					
					//���ñ���Ϊδѡ������״̬
				//	v.setBackgroundResource(R.drawable.mm_listitem_simple);
					//��ȡ�ɿ�ʱ��x����
					ux = event.getX();
					
					//�жϵ�ǰ���а�ť�ؼ���Ϊ��ʱ
					if (holder.btnDel != null) {
						
						//���º��ɿ�����ֵ�����20ʱ��ʾɾ����ť��������ʾ
						
						if (Math.abs(x - ux) > 20) {
							holder.btnDel.setVisibility(View.VISIBLE);
							curDel_btn = holder.btnDel;
						}
					}
				} else if (event.getAction() == MotionEvent.ACTION_MOVE) {//������ʱ����Ϊѡ��״̬

				//	v.setBackgroundResource(R.drawable.mm_listitem_pressed);
					
				} else {//����ģʽ
					//���ñ���Ϊδѡ������״̬
				//	v.setBackgroundResource(R.drawable.mm_listitem_simple);
				}

				return true;
			}
		});
		//viewHolder.tvTitle.setText(this.arrays.get(position));
		
		//Ϊɾ����ť���Ӽ����¼���ʵ�ֵ��ɾ����ťʱɾ������
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
		ImageView image;
		Button btnDel;
	}
}