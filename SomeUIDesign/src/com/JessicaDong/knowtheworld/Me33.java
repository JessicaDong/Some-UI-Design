package com.JessicaDong.knowtheworld;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.JessicaDong.knowtheworld.Me22.ViewHolder;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class Me33 extends Activity{
	private ListView list;
	private int index;
	private SimpleAdapter mSchedule;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_me33);
        //��XML�е�ListView����ΪItem������
         list = (ListView) findViewById(R.id.Me33ListView);
        
        //���ɶ�̬���飬����ת������
        ArrayList<HashMap<String, Object >> mylist = new ArrayList<HashMap<String, Object>>();
        //for(int i=0;i<30;i++)
       // {
        	HashMap<String, Object> map = new HashMap<String, Object>();
        	map.put("Itemview", R.drawable.myshare1);
        	mylist.add(map);
        	map = new HashMap<String, Object>();
        	map.put("Itemview", R.drawable.myshare2);
        	mylist.add(map);
        	map = new HashMap<String, Object>();
        	map.put("Itemview", R.drawable.myshare3);
        	mylist.add(map);
        	map = new HashMap<String, Object>();
        	map.put("Itemview", R.drawable.myshare4);
        	mylist.add(map);
        	map = new HashMap<String, Object>();
        	map.put("Itemview", R.drawable.myshare5);
        	mylist.add(map);
       // }
        //����������������===��ListItem
        	 mSchedule = new SimpleAdapter(this, //ûʲô����
        		                                    mylist,//������Դ 
        		                                    R.layout.me33item,//ListItem��XMLʵ��
        		                                    
        		                                    //��̬������ListItem��Ӧ������        
        		                                    //new String[] {"ItemTitle", "ItemText"}, 
        		                                    new String[] {"Itemview"}, 
        		                                    //ListItem��XML�ļ����������TextView ID
        		                                    new int[] {R.id.Itemview});
        //��Ӳ�����ʾ
        list.setAdapter(mSchedule);
        
      //��ӵ��

        list.setOnItemClickListener(new OnItemClickListener()

      {

 

		@Override

		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,long arg3) 

		{

			//String item = (String)listItem.get(arg2).get("ItemTitle");

			//setTitle("�����"+item);
			if(arg2==0)
			{
				Intent it = new Intent(Me33.this, Collec.class);
				startActivity(it);
			}

		}

	});

     // ��ӳ������,�õ����е�index��������arg2
     		list.setOnItemLongClickListener(new OnItemLongClickListener() {
     			@Override
     			public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
     					int arg2, long arg3) {
     				// TODO Auto-generated method stub
     				//index = arg2;
     				return false;
     				//list.remove(arg2);
     				//mSchedule.notifyDataSetChanged();
     			}
     		});

//      //��ӳ������
//
//        list.setOnCreateContextMenuListener(new OnCreateContextMenuListener()
//
//	{
//
//
//		@Override
//
//		public void onCreateContextMenu(ContextMenu menu, View v,ContextMenuInfo menuInfo)
//
//		{
//
//			menu.setHeaderTitle("�����˵�-ContextMenu");   
//
//			menu.add(0, 0, 0, "ɾ��������");
//
//			menu.add(0, 1, 0, "ȡ��ɾ��");   
//
//	}
//
//		
//
//	}); 
//
//	//�����˵���Ӧ����
//
//	@Override
//
//	public boolean onContextItemSelected(MenuItem item)
//
//	{
//
//		//setTitle("����˳����˵�����ĵ�"+item.getItemId()+"����Ŀ"); 
//
//		int selectedPosition = ((AdapterContextMenuInfo) item.getMenuInfo()).position;//��ȡ����˵ڼ���
//
//		return super.onContextItemSelected(item);
//
//	}
//
//
//    }
//    
   
}
}

    

