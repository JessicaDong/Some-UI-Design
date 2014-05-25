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
        //绑定XML中的ListView，作为Item的容器
         list = (ListView) findViewById(R.id.Me33ListView);
        
        //生成动态数组，并且转载数据
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
        //生成适配器，数组===》ListItem
        	 mSchedule = new SimpleAdapter(this, //没什么解释
        		                                    mylist,//数据来源 
        		                                    R.layout.me33item,//ListItem的XML实现
        		                                    
        		                                    //动态数组与ListItem对应的子项        
        		                                    //new String[] {"ItemTitle", "ItemText"}, 
        		                                    new String[] {"Itemview"}, 
        		                                    //ListItem的XML文件里面的两个TextView ID
        		                                    new int[] {R.id.Itemview});
        //添加并且显示
        list.setAdapter(mSchedule);
        
      //添加点击

        list.setOnItemClickListener(new OnItemClickListener()

      {

 

		@Override

		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,long arg3) 

		{

			//String item = (String)listItem.get(arg2).get("ItemTitle");

			//setTitle("点击第"+item);
			if(arg2==0)
			{
				Intent it = new Intent(Me33.this, Collec.class);
				startActivity(it);
			}

		}

	});

     // 添加长按点击,得到点中的index，即参数arg2
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

//      //添加长按点击
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
//			menu.setHeaderTitle("长按菜单-ContextMenu");   
//
//			menu.add(0, 0, 0, "删除审批单");
//
//			menu.add(0, 1, 0, "取消删除");   
//
//	}
//
//		
//
//	}); 
//
//	//长按菜单响应函数
//
//	@Override
//
//	public boolean onContextItemSelected(MenuItem item)
//
//	{
//
//		//setTitle("点击了长按菜单里面的第"+item.getItemId()+"个项目"); 
//
//		int selectedPosition = ((AdapterContextMenuInfo) item.getMenuInfo()).position;//获取点击了第几行
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

    

