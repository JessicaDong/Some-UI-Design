package com.JessicaDong.knowtheworld;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;



import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.provider.MediaStore.MediaColumns;
import android.R.integer;
import android.R.string;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.DatePicker.OnDateChangedListener;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;


public class Release2 extends Activity{
	public ImageButton back1;
	private Bundle bundle;
	private Bundle bundle2;
	private String path;
	private Context context = Release2.this;
	private ImageView imageView;
	private DatePicker datePicker;
	private TimePicker timePicker;
	
	//城市和县区那里弹出popwindow
	private ArrayList<String> citylist;
	private ArrayList<String> districtlist;
	private TextView textViewcity;
	private TextView textViewdistrict;
	private MyspinnerAdapter adapter2;
	private MyspinnerAdapter adapter3;
	//相机图标那里弹出选择拍照还是打开相册
	private ArrayList<String> list;
	private PopupWindow popupWindow;
	private MyspinnerAdapter adapter;
	private LinearLayout layout;
	private ListView listView;
	private int SCALE=10;
	private Bitmap bitmap;
	private Bitmap bmps[];
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		  requestWindowFeature(Window.FEATURE_NO_TITLE);// 填充标题栏
		setContentView(R.layout.activity_release2);
		back1 = (ImageButton) findViewById(R.id.back20);
		 back1.setScaleType(ImageView.ScaleType.FIT_XY);
		datePicker=(DatePicker)findViewById(R.id.datePicker1);
		textViewcity=(TextView)findViewById(R.id.editText2);
		textViewdistrict=(TextView)findViewById(R.id.editText3);
		 imageView=(ImageView)findViewById(R.id.preview1);
		 //时间选择器datapicker 和timepicker
		 datePicker = (DatePicker) findViewById(R.id.datePicker1);
         timePicker = (TimePicker) findViewById(R.id.timePicker1); 
         datePicker.init(2014, 3, 17, new OnDateChangedListener() {
        	 @Override
        	              public void onDateChanged(DatePicker view, int year,
        	                      int monthOfYear, int dayOfMonth) {
        	                  // 获取一个日历对象，并初始化为当前选中的时间
        	                  Calendar calendar = Calendar.getInstance();
        	                  calendar.set(year, monthOfYear, dayOfMonth);
        	                  SimpleDateFormat format = new SimpleDateFormat(
        	                          "yyyy年MM月dd日  HH:mm");
        	                  Toast.makeText(Release2.this,format.format(calendar.getTime()), Toast.LENGTH_SHORT)
        	                          .show();
        	              }
         });
         
         timePicker.setIs24HourView(true);
                  timePicker
                          .setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
                              @Override
                              public void onTimeChanged(TimePicker view, int hourOfDay,
                                      int minute) {
                                  //Toast.makeText(Release2.this, hourOfDay + "时" + minute + "分",Toast.LENGTH_SHORT).show();
                            	  
                              }
                          });
                  list=new ArrayList<String>();
                  list.add("拍照");
                  list.add("打开相册");
                  adapter=new MyspinnerAdapter(this,list);
                  
                  //弹出的city 的popwindow
                  citylist = new ArrayList<String>();
                  citylist.add("北京");
  				// 实例化一个适配器，list的数据作为Adapter的数据
  				adapter2 = new MyspinnerAdapter(this,citylist);
  				
  				 //弹出的县区 的popwindow
                districtlist = new ArrayList<String>();
                districtlist.add("海淀");
                districtlist.add("朝阳");
                districtlist.add("东城");
				// 实例化一个适配器，list的数据作为Adapter的数据
				adapter3 = new MyspinnerAdapter(this, districtlist);
		// Log.i("click", "1");
	} 
	public void backclick20(View v)
	{
		//Intent it = new Intent(Release.this, TestWeiXinWhatsNewActivity.class);
		//startActivity(it);
		Log.i("click", "stop");
		Release2.this.finish();
	}
	

	public void release3(View v)
	{
		Toast.makeText(Release2.this, "成功发布",Toast.LENGTH_SHORT ).show();
		Release2.this.finish();
	}
	public void camera(View v)
	{
		//调用照相机
		Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
		startActivityForResult(intent, 1);
	}
	//把调用相册加进去，request code 为2
	 protected void onActivityResult(int requestCode, int resultCode, Intent data) {  
	        super.onActivityResult(requestCode, resultCode, data);  
	        switch (requestCode) {
			case 1:{
				if (resultCode == Activity.RESULT_OK) {  
		            String sdStatus = Environment.getExternalStorageState();  
		            if (!sdStatus.equals(Environment.MEDIA_MOUNTED)) { 
		            	// 检测sd是否可用  
		            	//MEDIA_MOUNTED： media is present and mounted at its mount point with read/write access.记住这种情况可读写可用就行
		                Toast.makeText(context, "SD卡不存在！", 1000);  
		                return;  
		            }  
		            bundle = data.getExtras();  
		             bitmap = (Bitmap) bundle.get("data");// 获取相机返回的数据，并转换为Bitmap图片格式  
		            FileOutputStream b = null;  
		            File file = new File("/sdcard/channel/");  
		            file.mkdirs();// 创建文件夹  
		            path = "/sdcard/channel/" + formatDatetime(new Date(), "yyyyMMddHHmmss") + ".jpg";  
		            try {  
		                System.out.println("path：" + path);  
		                b = new FileOutputStream(path);  
		                bitmap.compress(Bitmap.CompressFormat.JPEG,100, b);// 把数据写入文件  
		               // getImageBinary();  
		            } catch (FileNotFoundException e) {  
		                e.printStackTrace();  
		            } finally {  
		                try {  
		                    b.flush();  
		                    b.close();  
		                } catch (IOException e) {  
		                    e.printStackTrace();  
		                }  
		            }  
		            bitmap= Bitmap.createScaledBitmap(bitmap, 100, 250, true);  
		            this.imageView.setImageBitmap(bitmap);// 将图片显示在ImageView里  
		        }  
			}
				break;
			case 2:{
				 if (resultCode != RESULT_OK) {        //此处的 RESULT_OK 是系统自定义得一个常量
				        return;
				    }
				   // Bitmap bm = null;
				    //外界的程序访问ContentProvider所提供数据 可以通过ContentResolver接口
				    ContentResolver resolver = getContentResolver();
				    //此处的用于判断接收的Activity是不是你想要的那个	
				    Uri originalUri = data.getData(); 
				  
				    String path=getFilePathFromContentUri(originalUri,resolver);
				    Log.i("uri", originalUri.toString());
				    Log.i("path",path);
//				        try {
////
////				           // Uri originalUri = data.getData();        //获得图片的uri 				      
//				        	 bitmap = MediaStore.Images.Media.getBitmap(resolver,originalUri);  
//				        	 if (bitmap != null) {
//		                        //为防止原始图片过大导致内存溢出，这里先缩小原图显示，然后释放原始Bitmap占用的内存
//		                        Bitmap smallBitmap = zoomBitmap(bitmap, bitmap.getWidth() / SCALE, bitmap.getHeight() / SCALE);
//		                        //释放原始图片占用的内存，防止out of memory异常发生
//		                        bitmap.recycle();
//		                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               
//		                        this.imageView.setImageBitmap(smallBitmap);
////		                         
////		                        
//		                    }				        	 				        	
				        	// Log.i("bitmap", bitmap.toString());
				        	// FileOutputStream b = null;
				        	// b = new FileOutputStream(originalUri);  
				        	// photo.compress(Bitmap.CompressFormat.JPEG,100, b);
				        	 //this.imageView.setImageBitmap(bitmap);
				        	// bitmap.recycle();  
				        	 BitmapFactory.Options options =new BitmapFactory.Options();
				        	 options.inJustDecodeBounds=true;
				        	 bitmap=BitmapFactory.decodeFile(path, options);
				        	 options.inJustDecodeBounds=false;
				        	 int be=(int)(options.outHeight/(float)200);
				        	 if(be<=0) be=1;
				        	 options.inSampleSize = be;
				        	 bitmap=BitmapFactory.decodeFile(path, options);
				        	 int w=bitmap.getWidth();
				        	 int h=bitmap.getHeight();
				        	 System.out.println(w+" "+h);
				        	 bitmap= Bitmap.createScaledBitmap(bitmap, 250, 200, true);  
				        	 this.imageView.setImageBitmap(bitmap);
				        	// bitmap.recycle();

//				        }catch (IOException e) {
//
//				        }
				  break;}
			default:
				break;
			}	       
	    }  		
	/**
	 * 根据指定的日期格式生成日式字符串，组成存储路径的一部分
	 * 
	 * @param format 日期格式yyyMMdd
	 * @return dateTimeString
	 */
	public static String formatDatetime(Date date, String format) {
		DateFormat df = new SimpleDateFormat(format);
		return df.format(date);
	}
	
	@SuppressWarnings("deprecation")
	public void showWindow1(View v) {
		//Log.i("addicon", "showview2");
		// 鎵惧埌甯冨眬鏂囦欢
		layout = (LinearLayout) LayoutInflater.from(this).inflate(R.layout.mypinner_dropdown, null);
		// 瀹炰緥鍖杔istView
		listView = (ListView) layout.findViewById(R.id.listView);
		// 璁剧疆listView鐨勯?閰嶅櫒
		//listView.setAdapter(adapter);
		listView.setAdapter(adapter);
		// 瀹炰緥鍖栦竴涓狿opuWindow瀵硅薄
		popupWindow = new PopupWindow(v);
		// 璁剧疆寮规鐨勫搴︿负甯冨眬鏂囦欢鐨勫
		popupWindow.setWidth(180);
		// 楂樺害闅忕潃鍐呭鍙樺寲
		popupWindow.setHeight(LayoutParams.WRAP_CONTENT);
		// 璁剧疆涓?釜閫忔槑鐨勮儗鏅紝涓嶇劧鏃犳硶瀹炵幇鐐瑰嚮寮规澶栵紝寮规娑堝け
		popupWindow.setBackgroundDrawable(new BitmapDrawable());
		// 璁剧疆鐐瑰嚮寮规澶栭儴锛屽脊妗嗘秷澶?
		popupWindow.setOutsideTouchable(true);
		// 璁剧疆鐒︾偣
		popupWindow.setFocusable(true);
		// 璁剧疆鎵?湪甯冨眬
		popupWindow.setContentView(layout);
		// 璁剧疆寮规鍑虹幇鐨勪綅缃紝鍦╲鐨勬涓嬫柟妯酱鍋忕Щtextview鐨勫搴︼紝涓轰簡瀵归綈~绾佃酱涓嶅亸绉?
		popupWindow.showAsDropDown(v, 200, 0);
		// listView鐨刬tem鐐瑰嚮浜嬩欢
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
				// TODO Auto-generated method stub
				
				// 寮规娑堝け
				switch( arg2)
				{
		    	
		    	case 0: 
		    	{
		    		Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
		    		startActivityForResult(intent, 1);break;
		    	}
		    	case 1: 
		    	{
		    		Intent intent = new Intent(Intent.ACTION_GET_CONTENT);  
		    		intent.setType("image/*");  
		    		startActivityForResult(intent, 2);  
//		    		Intent intent = new Intent(Intent.ACTION_PICK, null);  
//		    		 intent.setDataAndType(  
//                             MediaStore.Images.Media.EXTERNAL_CONTENT_URI,  
//                             "image/*");  
//                     startActivityForResult(intent, 2);  
		    		


		    	}
		    	
		    	};
				popupWindow.dismiss();
				popupWindow = null;
			}
		});	

	}
	/** 缩放Bitmap图片 **/
    public Bitmap zoomBitmap(Bitmap bitmap, int width, int height) {
        int w = bitmap.getWidth();
        int h = bitmap.getHeight();
        Matrix matrix = new Matrix();
        float scaleWidth = ((float) width / w);
        float scaleHeight = ((float) height / h);
        matrix.postScale(scaleWidth, scaleHeight);// 利用矩阵进行缩放不会造成内存溢出
        Bitmap newbmp = Bitmap.createBitmap(bitmap, 0, 0, w, h, matrix, true);
        return newbmp;
    }
	/**
	 * Gets the corresponding path to a file from the given content:// URI
	 * @param selectedVideoUri The content:// URI to find the file path from
	 * @param contentResolver The content resolver to use to perform the query.
	 * @return the file path as a string
	 * uri 得到filepath
	 */
	public static String getFilePathFromContentUri(Uri selectedVideoUri,
	        ContentResolver contentResolver) {
	    String filePath;
	    String[] filePathColumn = {MediaColumns.DATA};

	    Cursor cursor = contentResolver.query(selectedVideoUri, filePathColumn, null, null, null);
//	    也可用下面的方法拿到cursor
//	    Cursor cursor = this.context.managedQuery(selectedVideoUri, filePathColumn, null, null, null);
	    
	    cursor.moveToFirst();

	    int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
	    filePath = cursor.getString(columnIndex);
	    cursor.close();
	    return filePath;
	}
	
	//城市点击弹出的popwindow
	@SuppressWarnings("deprecation")
	public void cityclick(View v) {
		//Log.i("addicon", "showview2");
		// 鎵惧埌甯冨眬鏂囦欢
		layout = (LinearLayout) LayoutInflater.from(this).inflate(R.layout.mypinner_dropdown, null);
		// 瀹炰緥鍖杔istView
		listView = (ListView) layout.findViewById(R.id.listView);
		// 璁剧疆listView鐨勯?閰嶅櫒
		//listView.setAdapter(adapter);
		listView.setAdapter(adapter2);
		// 瀹炰緥鍖栦竴涓狿opuWindow瀵硅薄
		popupWindow = new PopupWindow(v);
		// 璁剧疆寮规鐨勫搴︿负甯冨眬鏂囦欢鐨勫
		popupWindow.setWidth(120);
		// 楂樺害闅忕潃鍐呭鍙樺寲
		popupWindow.setHeight(LayoutParams.WRAP_CONTENT);
		// 璁剧疆涓?釜閫忔槑鐨勮儗鏅紝涓嶇劧鏃犳硶瀹炵幇鐐瑰嚮寮规澶栵紝寮规娑堝け
		popupWindow.setBackgroundDrawable(new BitmapDrawable());
		// 璁剧疆鐐瑰嚮寮规澶栭儴锛屽脊妗嗘秷澶?
		popupWindow.setOutsideTouchable(true);
		// 璁剧疆鐒︾偣
		popupWindow.setFocusable(true);
		// 璁剧疆鎵?湪甯冨眬
		popupWindow.setContentView(layout);
		// 璁剧疆寮规鍑虹幇鐨勪綅缃紝鍦╲鐨勬涓嬫柟妯酱鍋忕Щtextview鐨勫搴︼紝涓轰簡瀵归綈~绾佃酱涓嶅亸绉?
		popupWindow.showAsDropDown(v, 0, 0);
		// listView鐨刬tem鐐瑰嚮浜嬩欢
		listView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
				// TODO Auto-generated method stub				
				// 寮规娑堝け
				switch( arg2)
				{		    	
		    	case 0: 
		    	{
		    		textViewcity.setText("北京");
		    	}	    	
		    	};
				popupWindow.dismiss();
				popupWindow = null;
			}
		});	
	}
	

	//县区点击弹出的popwindow
	@SuppressWarnings("deprecation")
	public void districtclick(View v) {
		//Log.i("addicon", "showview2");
		// 鎵惧埌甯冨眬鏂囦欢
		layout = (LinearLayout) LayoutInflater.from(this).inflate(R.layout.mypinner_dropdown, null);
		// 瀹炰緥鍖杔istView
		listView = (ListView) layout.findViewById(R.id.listView);
		// 璁剧疆listView鐨勯?閰嶅櫒
		//listView.setAdapter(adapter);
		listView.setAdapter(adapter3);
		// 瀹炰緥鍖栦竴涓狿opuWindow瀵硅薄
		popupWindow = new PopupWindow(v);
		// 璁剧疆寮规鐨勫搴︿负甯冨眬鏂囦欢鐨勫
		popupWindow.setWidth(120);
		// 楂樺害闅忕潃鍐呭鍙樺寲
		popupWindow.setHeight(LayoutParams.WRAP_CONTENT);
		// 璁剧疆涓?釜閫忔槑鐨勮儗鏅紝涓嶇劧鏃犳硶瀹炵幇鐐瑰嚮寮规澶栵紝寮规娑堝け
		popupWindow.setBackgroundDrawable(new BitmapDrawable());
		// 璁剧疆鐐瑰嚮寮规澶栭儴锛屽脊妗嗘秷澶?
		popupWindow.setOutsideTouchable(true);
		// 璁剧疆鐒︾偣
		popupWindow.setFocusable(true);
		// 璁剧疆鎵?湪甯冨眬
		popupWindow.setContentView(layout);
		// 璁剧疆寮规鍑虹幇鐨勪綅缃紝鍦╲鐨勬涓嬫柟妯酱鍋忕Щtextview鐨勫搴︼紝涓轰簡瀵归綈~绾佃酱涓嶅亸绉?
		popupWindow.showAsDropDown(v, 0, 0);
		// listView鐨刬tem鐐瑰嚮浜嬩欢
		listView.setOnItemClickListener(new OnItemClickListener() {
			@SuppressLint("ResourceAsColor")
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
				// TODO Auto-generated method stub				
				// 寮规娑堝け
				//textViewdistrict.setTextColor(R.color.black);
				switch( arg2)
				{		    	
		    	case 0: 
		    	{
		    		textViewdistrict.setText("海淀");break;
		    	}	
		    	case 1: 
		    	{
		    		textViewdistrict.setText("朝阳");break;
		    	}	
		    	case 3: 
		    	{
		    		textViewdistrict.setText("东城");break;
		    	}	
		    	};
				popupWindow.dismiss();
				popupWindow = null;
			}
		});	
	}
}
