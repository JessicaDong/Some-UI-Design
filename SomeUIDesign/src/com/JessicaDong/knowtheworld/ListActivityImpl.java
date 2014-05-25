package com.JessicaDong.knowtheworld;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ListView;
import android.widget.SimpleAdapter;


	public class ListActivityImpl extends ListActivity {  
	    
	    private ArrayList<HashMap<String, Object>> listItems;   //存放文字、图片信�? 
	    private SimpleAdapter listItemAdapter;                  //适配�?    
	      
	    /** Called when the activity is first created. */  
	    @Override  
	    public void onCreate(Bundle icicle)  
	    {  
	        super.onCreate(icicle);  
	        requestWindowFeature(Window.FEATURE_NO_TITLE);// ��������
	        setContentView(R.layout.tab_view_pager);  
	       
	        initListView();  
	        this.setListAdapter(listItemAdapter);    
	       
	    }  
	      
	    /** 
	     * 设置适配器内�?
	     */  
	    private void initListView()   {     
	        listItems = new ArrayList<HashMap<String, Object>>();  
	      //   for(int i=0;i<10;i++)     
	        // {     
	             HashMap<String, Object> map = new HashMap<String, Object>();     
	             //map.put("img", R.drawable.friendadd);//图片     
	             listItems.add(map);    
	             
	             HashMap<String, Object> map2 = new HashMap<String, Object>();       	       
	            // map.put("img", R.drawable.friendlist);//图片     
	             listItems.add(map2);   
	             
	             HashMap<String, Object> map3 = new HashMap<String, Object>();     
	            // map.put("img", R.drawable.friendmanagement);//图片     
	             listItems.add(map3);   
	             
	        // }     
	         //生成适配器的Item和动态数组对应的元素     
	         listItemAdapter = new SimpleAdapter(this,listItems,//数据�?     
	             R.layout.item,//ListItem的XML布局实现     
	             //动�?数组与ImageItem对应的子�?            
	             new String[] {"img"},      
	             //ImageItem的XML文件里面的一个ImageView,两个TextView ID     
	             new int[] {R.id.img}     
	         );     
	    }  
	  
	    @Override  
	    protected void onListItemClick(ListView l, View v, int position, long id) {  
	        // TODO Auto-generated method stub  
	       // Log.e("position", "" + position);  
	       // setTitle("你点击第"+position+"�?);  
	    	switch( position)
	    	{
	    	case 1: 
	    	{
	    		Intent it1 = new Intent(ListActivityImpl.this, Friendadd.class);
	    	}
	    	case 2: 
	    	{
	    		Intent it1 = new Intent(ListActivityImpl.this, Friendlist.class);
	    	}
	    	case 3: 
	    	{
	    		Intent it1 = new Intent(ListActivityImpl.this, Friendmanagement.class);
	    	}
	    	};
	    }     
	   /*   
	    class ClickEvent implements OnClickListener {  
	        @Override  
	        public void onClick(View v) {  
	            // TODO Auto-generated method stub  
	            //添加多一�? 
	             HashMap<String, Object> map = new HashMap<String, Object>();     
	             map.put("Img", R.drawable.music);    
	             listItems.add(map);  
	             //重新设置适配�? 
	             ListActivityImpl.this.setListAdapter(listItemAdapter);  
	        }  
	    } 
	    */ 
	}

