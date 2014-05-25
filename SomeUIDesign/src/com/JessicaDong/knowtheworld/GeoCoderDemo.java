package com.JessicaDong.knowtheworld;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.baidu.mapapi.map.MapView; 
import com.baidu.mapapi.BMapManager;//
import com.baidu.mapapi.search.MKPoiInfo;//
import com.baidu.platform.comapi.basestruct.GeoPoint;//
import com.baidu.mapapi.map.ItemizedOverlay;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.OverlayItem;
import com.baidu.mapapi.search.MKAddrInfo;
import com.baidu.mapapi.search.MKBusLineResult;
import com.baidu.mapapi.search.MKDrivingRouteResult;
import com.baidu.mapapi.search.MKPoiResult;
import com.baidu.mapapi.search.MKSearch;
import com.baidu.mapapi.search.MKSearchListener;
import com.baidu.mapapi.search.MKShareUrlResult;
import com.baidu.mapapi.search.MKSuggestionResult;
import com.baidu.mapapi.search.MKTransitRouteResult;
import com.baidu.mapapi.search.MKWalkingRouteResult;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.mapapi.map.Geometry;

import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.map.MapController;
import com.baidu.mapapi.map.MapView;
import com.baidu.platform.comapi.basestruct.GeoPoint;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;




public class GeoCoderDemo extends Activity {

	BMapManager bMapManager = null;  // 定义管理sdk的对象
	MapView mapView = null;  // 定义mapview对象
	MKSearch mSearch = null;	// 搜索模块，也可去掉地图模块独立使用
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.i("geo","run");
		// 初始化管理对象，注意要在setContentView(R.layout.activity_main)之前初始化，否则会报错
		bMapManager = new BMapManager(getApplication());
		bMapManager.init("dnsE8DfEQM39dGaSj571ZjfB", null);
		
		setContentView(R.layout.geocoder);
		
		// 初始化mapview对象，并且设置显示缩放控件
		mapView = (MapView) findViewById(R.id.bmapView);
		mapView.setBuiltInZoomControls(true);
		
		// 定义地图控件，获取mapview的控制，并把地图范围定位北京市
		MapController mapController = mapView.getController();
		GeoPoint point =new GeoPoint((int)(39.915* 1E6),(int)(116.404* 1E6));
		mapController.setCenter(point);
		mapController.setZoom(12);
		 mSearch = new MKSearch();
		 Log.i("geo","mksearch1");
		mSearch.geocode("国家体育馆", "北京");
		Log.i("geo","geo1");
		if(bMapManager!=null) Log.i("geo","mapmanger");
		int lat=40002556;
		int lon =116396588;
		GeoPoint gp=new GeoPoint(lat, lon);
		ItemizedOverlay<OverlayItem> itemOverlay = new ItemizedOverlay<OverlayItem>(null, mapView);//
		//生成Item
		OverlayItem item = new OverlayItem(gp, "", null);
		//得到需要标在地图上的资源
		Drawable marker = getResources().getDrawable(R.drawable.icon_markf);  //
		//为maker定义位置和边界
		marker.setBounds(5, 5, marker.getIntrinsicWidth(), marker.getIntrinsicHeight());
		//给item设置marker
		
		//MyLocationOverlay poioverlay = new MyLocationOverlay();
		item.setMarker(marker);
		Log.i("geo","setmarker");
	//	item.setMarker();
		//在图层上添加item
		itemOverlay.addItem(item);//
		Log.i("geo","添加marker");
		mapView.getOverlays().clear();
		mapView.getOverlays().add(itemOverlay);
		mapView.refresh();
//		 mSearch.init(this.bMapManager, new MKSearchListener() {
//			 
//		public void onGetAddrResult(MKAddrInfo res, int error) {
//			if(bMapManager!=null) Log.i("geo","mapmanger2");
//			//if(MKSearchListener) Log.i("geo","MKSearchListener");
//			if (error != 0) {
//				String str = String.format("错误号：%d", error);
//				Toast.makeText(GeoCoderDemo.this, str, Toast.LENGTH_LONG).show();
//				return;
//			}
//			String s1=res.toString();
//			Log.i("res.tpye",res.toString());
//			//地图移动到该点
//			mapView.getController().animateTo(res.geoPt);	
//			
//			if (res.type == MKAddrInfo.MK_GEOCODE){
//				//地理编码：通过地址检索坐标点
//				String strInfo = String.format("纬度：%f 经度：%f", res.geoPt.getLatitudeE6()/1e6, res.geoPt.getLongitudeE6()/1e6);
//				Toast.makeText(GeoCoderDemo.this, strInfo, Toast.LENGTH_LONG).show(); //这里注释了
//				
//				//mSearch.poiSearchNearBy("餐厅",new GeoPoint(res.geoPt.getLatitudeE6(), res.geoPt.getLongitudeE6()) , 5000);//
//				Log.i("geo","toast");
//				//MyPoiOverlay poiOverlay = new MyPoiOverlay(GeoCoderDemo.this, mMapView, mSearch);
//
//			}
//			if (res.type == MKAddrInfo.MK_REVERSEGEOCODE){
//				//反地理编码：通过坐标点检索详细地址及周边poi
//				String strInfo = res.strAddr;
//				Toast.makeText(GeoCoderDemo.this, strInfo, Toast.LENGTH_LONG).show();
//				
//			}
//			
//			 //MyPoiOverlay poiOverlay = new MyPoiOverlay(GeoCoderDemo.this, mMapView, mSearch);
//			//position = new GeoPoint (res.geoPt.getLatitudeE6(),res.geoPt.getLongitudeE6());
//			//Geometry geometry = new Geometry ();
//			//geometry.setPoint(position,10);
//			//生成ItemizedOverlay图层用来标注结果点
//			ItemizedOverlay<OverlayItem> itemOverlay = new ItemizedOverlay<OverlayItem>(null, mapView);//
//			//生成Item
//			OverlayItem item = new OverlayItem(res.geoPt, "", null);
//			//得到需要标在地图上的资源
//			Drawable marker = getResources().getDrawable(R.drawable.icon_markf);  //
//			//为maker定义位置和边界
//			marker.setBounds(5, 5, marker.getIntrinsicWidth(), marker.getIntrinsicHeight());
//			//给item设置marker
//			
//			//MyLocationOverlay poioverlay = new MyLocationOverlay();
//			item.setMarker(marker);
//			Log.i("geo","setmarker");
//		//	item.setMarker();
//			//在图层上添加item
//			itemOverlay.addItem(item);//
//			Log.i("geo","添加marker");
//			//poiOverlay.addItem(item);
//			//item.add(new OverlayItem(res.geoPt,"",""));
//			//item.setGeoPoint(res.geoPt);
//			
//			//PoiOverlay poioverlay =new PoiOverlay(SetData )
//			// MyPoiOverlay poiOverlay = new MyPoiOverlay(GeoCoderDemo.this, mMapView, mSearch);
//             //poiOverlay.setGeoPoint(res.geoPt);
//			//清除地图其他图层
//			mapView.getOverlays().clear();
//			//添加一个标注ItemizedOverlay图层
//			
//			mapView.getOverlays().add(itemOverlay);
//			//mMapView.getOverlays().add(item);
//			//执行刷新使生效
//			
//			mapView.refresh();
//			Log.i("geo","refresh");
//		}
//
//		@Override
//		public void onGetBusDetailResult(MKBusLineResult arg0, int arg1) {
//			// TODO Auto-generated method stub
//			
//		}
//
//		@Override
//		public void onGetDrivingRouteResult(MKDrivingRouteResult arg0, int arg1) {
//			// TODO Auto-generated method stub
//			
//		}
//
//		@Override
//		public void onGetPoiDetailSearchResult(int arg0, int arg1) {
//			// TODO Auto-generated method stub
//			
//		}
//
//		@Override
//		public void onGetPoiResult(MKPoiResult arg0, int arg1, int arg2) {
//			// TODO Auto-generated method stub
//			
//		}
//
//		@Override
//		public void onGetShareUrlResult(MKShareUrlResult arg0, int arg1,
//				int arg2) {
//			// TODO Auto-generated method stub
//			
//		}
//
//		@Override
//		public void onGetSuggestionResult(MKSuggestionResult arg0, int arg1) {
//			// TODO Auto-generated method stub
//			
//		}
//
//		@Override
//		public void onGetTransitRouteResult(MKTransitRouteResult arg0, int arg1) {
//			// TODO Auto-generated method stub
//			
//		}
//
//		@Override
//		public void onGetWalkingRouteResult(MKWalkingRouteResult arg0, int arg1) {
//			// TODO Auto-generated method stub
//			
//		}
//		 });
		 
		
	}
	
	//注意在onResume、onDestroy和onPause中控制mapview和地图管理对象的状态

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		mapView.onResume();
		if(bMapManager!=null){
		bMapManager.start();
		}
		super.onResume();
		Log.i("geo", "resume");
	}
	
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		mapView.destroy();
		if(bMapManager!=null){
			bMapManager.destroy();
			bMapManager=null;
		}
		super.onDestroy();
		Log.i("geo", "destroy");
	}
	
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		mapView.onPause();
		if(bMapManager!=null){
			bMapManager.stop();
		}
		super.onPause();
		Log.i("geo", "pause");
	}
	@Override
    protected void onSaveInstanceState(Bundle outState) {
    	super.onSaveInstanceState(outState);
    	mapView.onSaveInstanceState(outState);
    	
    }
    
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
    	super.onRestoreInstanceState(savedInstanceState);
    	mapView.onRestoreInstanceState(savedInstanceState);
    }
	public void geoback(View v) {
		
		//this.finish();
		//onDestroy();
	}

}

