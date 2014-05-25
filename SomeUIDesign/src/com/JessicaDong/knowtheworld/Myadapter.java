package com.JessicaDong.knowtheworld;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Myadapter {
	 public void MyAdapter() {  
	        // TODO Auto-generated constructor stub  
	    }  
	      
	  
	      
	    public static List<Map<String, Object>> getListMap(){  
	          
	        List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();  
	          
	        Map<String, Object> map = new HashMap<String, Object>();        
	       // map.put("ivLogo", R.drawable.friendadd);  
	
	          
	        Map<String, Object> map2 = new HashMap<String, Object>();        
	       // map2.put("ivLogo", R.drawable.friendlist);  
	    
	        Map<String, Object> map3 = new HashMap<String, Object>();        
	        //map3.put("ivLogo", R.drawable.friendmanagement);  
	        
	        list.add(map);  
	        list.add(map2);  
	        list.add(map3);
	          
	        return list;  
	          
	    }  
}
