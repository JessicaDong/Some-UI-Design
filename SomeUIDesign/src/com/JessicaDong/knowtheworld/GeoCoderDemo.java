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

	BMapManager bMapManager = null;  // �������sdk�Ķ���
	MapView mapView = null;  // ����mapview����
	MKSearch mSearch = null;	// ����ģ�飬Ҳ��ȥ����ͼģ�����ʹ��
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.i("geo","run");
		// ��ʼ���������ע��Ҫ��setContentView(R.layout.activity_main)֮ǰ��ʼ��������ᱨ��
		bMapManager = new BMapManager(getApplication());
		bMapManager.init("dnsE8DfEQM39dGaSj571ZjfB", null);
		
		setContentView(R.layout.geocoder);
		
		// ��ʼ��mapview���󣬲���������ʾ���ſؼ�
		mapView = (MapView) findViewById(R.id.bmapView);
		mapView.setBuiltInZoomControls(true);
		
		// �����ͼ�ؼ�����ȡmapview�Ŀ��ƣ����ѵ�ͼ��Χ��λ������
		MapController mapController = mapView.getController();
		GeoPoint point =new GeoPoint((int)(39.915* 1E6),(int)(116.404* 1E6));
		mapController.setCenter(point);
		mapController.setZoom(12);
		 mSearch = new MKSearch();
		 Log.i("geo","mksearch1");
		mSearch.geocode("����������", "����");
		Log.i("geo","geo1");
		if(bMapManager!=null) Log.i("geo","mapmanger");
		int lat=40002556;
		int lon =116396588;
		GeoPoint gp=new GeoPoint(lat, lon);
		ItemizedOverlay<OverlayItem> itemOverlay = new ItemizedOverlay<OverlayItem>(null, mapView);//
		//����Item
		OverlayItem item = new OverlayItem(gp, "", null);
		//�õ���Ҫ���ڵ�ͼ�ϵ���Դ
		Drawable marker = getResources().getDrawable(R.drawable.icon_markf);  //
		//Ϊmaker����λ�úͱ߽�
		marker.setBounds(5, 5, marker.getIntrinsicWidth(), marker.getIntrinsicHeight());
		//��item����marker
		
		//MyLocationOverlay poioverlay = new MyLocationOverlay();
		item.setMarker(marker);
		Log.i("geo","setmarker");
	//	item.setMarker();
		//��ͼ�������item
		itemOverlay.addItem(item);//
		Log.i("geo","���marker");
		mapView.getOverlays().clear();
		mapView.getOverlays().add(itemOverlay);
		mapView.refresh();
//		 mSearch.init(this.bMapManager, new MKSearchListener() {
//			 
//		public void onGetAddrResult(MKAddrInfo res, int error) {
//			if(bMapManager!=null) Log.i("geo","mapmanger2");
//			//if(MKSearchListener) Log.i("geo","MKSearchListener");
//			if (error != 0) {
//				String str = String.format("����ţ�%d", error);
//				Toast.makeText(GeoCoderDemo.this, str, Toast.LENGTH_LONG).show();
//				return;
//			}
//			String s1=res.toString();
//			Log.i("res.tpye",res.toString());
//			//��ͼ�ƶ����õ�
//			mapView.getController().animateTo(res.geoPt);	
//			
//			if (res.type == MKAddrInfo.MK_GEOCODE){
//				//������룺ͨ����ַ���������
//				String strInfo = String.format("γ�ȣ�%f ���ȣ�%f", res.geoPt.getLatitudeE6()/1e6, res.geoPt.getLongitudeE6()/1e6);
//				Toast.makeText(GeoCoderDemo.this, strInfo, Toast.LENGTH_LONG).show(); //����ע����
//				
//				//mSearch.poiSearchNearBy("����",new GeoPoint(res.geoPt.getLatitudeE6(), res.geoPt.getLongitudeE6()) , 5000);//
//				Log.i("geo","toast");
//				//MyPoiOverlay poiOverlay = new MyPoiOverlay(GeoCoderDemo.this, mMapView, mSearch);
//
//			}
//			if (res.type == MKAddrInfo.MK_REVERSEGEOCODE){
//				//��������룺ͨ������������ϸ��ַ���ܱ�poi
//				String strInfo = res.strAddr;
//				Toast.makeText(GeoCoderDemo.this, strInfo, Toast.LENGTH_LONG).show();
//				
//			}
//			
//			 //MyPoiOverlay poiOverlay = new MyPoiOverlay(GeoCoderDemo.this, mMapView, mSearch);
//			//position = new GeoPoint (res.geoPt.getLatitudeE6(),res.geoPt.getLongitudeE6());
//			//Geometry geometry = new Geometry ();
//			//geometry.setPoint(position,10);
//			//����ItemizedOverlayͼ��������ע�����
//			ItemizedOverlay<OverlayItem> itemOverlay = new ItemizedOverlay<OverlayItem>(null, mapView);//
//			//����Item
//			OverlayItem item = new OverlayItem(res.geoPt, "", null);
//			//�õ���Ҫ���ڵ�ͼ�ϵ���Դ
//			Drawable marker = getResources().getDrawable(R.drawable.icon_markf);  //
//			//Ϊmaker����λ�úͱ߽�
//			marker.setBounds(5, 5, marker.getIntrinsicWidth(), marker.getIntrinsicHeight());
//			//��item����marker
//			
//			//MyLocationOverlay poioverlay = new MyLocationOverlay();
//			item.setMarker(marker);
//			Log.i("geo","setmarker");
//		//	item.setMarker();
//			//��ͼ�������item
//			itemOverlay.addItem(item);//
//			Log.i("geo","���marker");
//			//poiOverlay.addItem(item);
//			//item.add(new OverlayItem(res.geoPt,"",""));
//			//item.setGeoPoint(res.geoPt);
//			
//			//PoiOverlay poioverlay =new PoiOverlay(SetData )
//			// MyPoiOverlay poiOverlay = new MyPoiOverlay(GeoCoderDemo.this, mMapView, mSearch);
//             //poiOverlay.setGeoPoint(res.geoPt);
//			//�����ͼ����ͼ��
//			mapView.getOverlays().clear();
//			//���һ����עItemizedOverlayͼ��
//			
//			mapView.getOverlays().add(itemOverlay);
//			//mMapView.getOverlays().add(item);
//			//ִ��ˢ��ʹ��Ч
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
	
	//ע����onResume��onDestroy��onPause�п���mapview�͵�ͼ��������״̬

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

