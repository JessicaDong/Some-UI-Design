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
	
	//���к��������ﵯ��popwindow
	private ArrayList<String> citylist;
	private ArrayList<String> districtlist;
	private TextView textViewcity;
	private TextView textViewdistrict;
	private MyspinnerAdapter adapter2;
	private MyspinnerAdapter adapter3;
	//���ͼ�����ﵯ��ѡ�����ջ��Ǵ����
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
		  requestWindowFeature(Window.FEATURE_NO_TITLE);// ��������
		setContentView(R.layout.activity_release2);
		back1 = (ImageButton) findViewById(R.id.back20);
		 back1.setScaleType(ImageView.ScaleType.FIT_XY);
		datePicker=(DatePicker)findViewById(R.id.datePicker1);
		textViewcity=(TextView)findViewById(R.id.editText2);
		textViewdistrict=(TextView)findViewById(R.id.editText3);
		 imageView=(ImageView)findViewById(R.id.preview1);
		 //ʱ��ѡ����datapicker ��timepicker
		 datePicker = (DatePicker) findViewById(R.id.datePicker1);
         timePicker = (TimePicker) findViewById(R.id.timePicker1); 
         datePicker.init(2014, 3, 17, new OnDateChangedListener() {
        	 @Override
        	              public void onDateChanged(DatePicker view, int year,
        	                      int monthOfYear, int dayOfMonth) {
        	                  // ��ȡһ���������󣬲���ʼ��Ϊ��ǰѡ�е�ʱ��
        	                  Calendar calendar = Calendar.getInstance();
        	                  calendar.set(year, monthOfYear, dayOfMonth);
        	                  SimpleDateFormat format = new SimpleDateFormat(
        	                          "yyyy��MM��dd��  HH:mm");
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
                                  //Toast.makeText(Release2.this, hourOfDay + "ʱ" + minute + "��",Toast.LENGTH_SHORT).show();
                            	  
                              }
                          });
                  list=new ArrayList<String>();
                  list.add("����");
                  list.add("�����");
                  adapter=new MyspinnerAdapter(this,list);
                  
                  //������city ��popwindow
                  citylist = new ArrayList<String>();
                  citylist.add("����");
  				// ʵ����һ����������list��������ΪAdapter������
  				adapter2 = new MyspinnerAdapter(this,citylist);
  				
  				 //���������� ��popwindow
                districtlist = new ArrayList<String>();
                districtlist.add("����");
                districtlist.add("����");
                districtlist.add("����");
				// ʵ����һ����������list��������ΪAdapter������
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
		Toast.makeText(Release2.this, "�ɹ�����",Toast.LENGTH_SHORT ).show();
		Release2.this.finish();
	}
	public void camera(View v)
	{
		//���������
		Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
		startActivityForResult(intent, 1);
	}
	//�ѵ������ӽ�ȥ��request code Ϊ2
	 protected void onActivityResult(int requestCode, int resultCode, Intent data) {  
	        super.onActivityResult(requestCode, resultCode, data);  
	        switch (requestCode) {
			case 1:{
				if (resultCode == Activity.RESULT_OK) {  
		            String sdStatus = Environment.getExternalStorageState();  
		            if (!sdStatus.equals(Environment.MEDIA_MOUNTED)) { 
		            	// ���sd�Ƿ����  
		            	//MEDIA_MOUNTED�� media is present and mounted at its mount point with read/write access.��ס��������ɶ�д���þ���
		                Toast.makeText(context, "SD�������ڣ�", 1000);  
		                return;  
		            }  
		            bundle = data.getExtras();  
		             bitmap = (Bitmap) bundle.get("data");// ��ȡ������ص����ݣ���ת��ΪBitmapͼƬ��ʽ  
		            FileOutputStream b = null;  
		            File file = new File("/sdcard/channel/");  
		            file.mkdirs();// �����ļ���  
		            path = "/sdcard/channel/" + formatDatetime(new Date(), "yyyyMMddHHmmss") + ".jpg";  
		            try {  
		                System.out.println("path��" + path);  
		                b = new FileOutputStream(path);  
		                bitmap.compress(Bitmap.CompressFormat.JPEG,100, b);// ������д���ļ�  
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
		            this.imageView.setImageBitmap(bitmap);// ��ͼƬ��ʾ��ImageView��  
		        }  
			}
				break;
			case 2:{
				 if (resultCode != RESULT_OK) {        //�˴��� RESULT_OK ��ϵͳ�Զ����һ������
				        return;
				    }
				   // Bitmap bm = null;
				    //���ĳ������ContentProvider���ṩ���� ����ͨ��ContentResolver�ӿ�
				    ContentResolver resolver = getContentResolver();
				    //�˴��������жϽ��յ�Activity�ǲ�������Ҫ���Ǹ�	
				    Uri originalUri = data.getData(); 
				  
				    String path=getFilePathFromContentUri(originalUri,resolver);
				    Log.i("uri", originalUri.toString());
				    Log.i("path",path);
//				        try {
////
////				           // Uri originalUri = data.getData();        //���ͼƬ��uri 				      
//				        	 bitmap = MediaStore.Images.Media.getBitmap(resolver,originalUri);  
//				        	 if (bitmap != null) {
//		                        //Ϊ��ֹԭʼͼƬ�������ڴ��������������Сԭͼ��ʾ��Ȼ���ͷ�ԭʼBitmapռ�õ��ڴ�
//		                        Bitmap smallBitmap = zoomBitmap(bitmap, bitmap.getWidth() / SCALE, bitmap.getHeight() / SCALE);
//		                        //�ͷ�ԭʼͼƬռ�õ��ڴ棬��ֹout of memory�쳣����
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
	 * ����ָ�������ڸ�ʽ������ʽ�ַ�������ɴ洢·����һ����
	 * 
	 * @param format ���ڸ�ʽyyyMMdd
	 * @return dateTimeString
	 */
	public static String formatDatetime(Date date, String format) {
		DateFormat df = new SimpleDateFormat(format);
		return df.format(date);
	}
	
	@SuppressWarnings("deprecation")
	public void showWindow1(View v) {
		//Log.i("addicon", "showview2");
		// 找到布局文件
		layout = (LinearLayout) LayoutInflater.from(this).inflate(R.layout.mypinner_dropdown, null);
		// 实例化listView
		listView = (ListView) layout.findViewById(R.id.listView);
		// 设置listView的�?配器
		//listView.setAdapter(adapter);
		listView.setAdapter(adapter);
		// 实例化一个PopuWindow对象
		popupWindow = new PopupWindow(v);
		// 设置弹框的宽度为布局文件的宽
		popupWindow.setWidth(180);
		// 高度随着内容变化
		popupWindow.setHeight(LayoutParams.WRAP_CONTENT);
		// 设置�?��透明的背景，不然无法实现点击弹框外，弹框消失
		popupWindow.setBackgroundDrawable(new BitmapDrawable());
		// 设置点击弹框外部，弹框消�?
		popupWindow.setOutsideTouchable(true);
		// 设置焦点
		popupWindow.setFocusable(true);
		// 设置�?��布局
		popupWindow.setContentView(layout);
		// 设置弹框出现的位置，在v的正下方横轴偏移textview的宽度，为了对齐~纵轴不偏�?
		popupWindow.showAsDropDown(v, 200, 0);
		// listView的item点击事件
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
				// TODO Auto-generated method stub
				
				// 弹框消失
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
	/** ����BitmapͼƬ **/
    public Bitmap zoomBitmap(Bitmap bitmap, int width, int height) {
        int w = bitmap.getWidth();
        int h = bitmap.getHeight();
        Matrix matrix = new Matrix();
        float scaleWidth = ((float) width / w);
        float scaleHeight = ((float) height / h);
        matrix.postScale(scaleWidth, scaleHeight);// ���þ���������Ų�������ڴ����
        Bitmap newbmp = Bitmap.createBitmap(bitmap, 0, 0, w, h, matrix, true);
        return newbmp;
    }
	/**
	 * Gets the corresponding path to a file from the given content:// URI
	 * @param selectedVideoUri The content:// URI to find the file path from
	 * @param contentResolver The content resolver to use to perform the query.
	 * @return the file path as a string
	 * uri �õ�filepath
	 */
	public static String getFilePathFromContentUri(Uri selectedVideoUri,
	        ContentResolver contentResolver) {
	    String filePath;
	    String[] filePathColumn = {MediaColumns.DATA};

	    Cursor cursor = contentResolver.query(selectedVideoUri, filePathColumn, null, null, null);
//	    Ҳ��������ķ����õ�cursor
//	    Cursor cursor = this.context.managedQuery(selectedVideoUri, filePathColumn, null, null, null);
	    
	    cursor.moveToFirst();

	    int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
	    filePath = cursor.getString(columnIndex);
	    cursor.close();
	    return filePath;
	}
	
	//���е��������popwindow
	@SuppressWarnings("deprecation")
	public void cityclick(View v) {
		//Log.i("addicon", "showview2");
		// 找到布局文件
		layout = (LinearLayout) LayoutInflater.from(this).inflate(R.layout.mypinner_dropdown, null);
		// 实例化listView
		listView = (ListView) layout.findViewById(R.id.listView);
		// 设置listView的�?配器
		//listView.setAdapter(adapter);
		listView.setAdapter(adapter2);
		// 实例化一个PopuWindow对象
		popupWindow = new PopupWindow(v);
		// 设置弹框的宽度为布局文件的宽
		popupWindow.setWidth(120);
		// 高度随着内容变化
		popupWindow.setHeight(LayoutParams.WRAP_CONTENT);
		// 设置�?��透明的背景，不然无法实现点击弹框外，弹框消失
		popupWindow.setBackgroundDrawable(new BitmapDrawable());
		// 设置点击弹框外部，弹框消�?
		popupWindow.setOutsideTouchable(true);
		// 设置焦点
		popupWindow.setFocusable(true);
		// 设置�?��布局
		popupWindow.setContentView(layout);
		// 设置弹框出现的位置，在v的正下方横轴偏移textview的宽度，为了对齐~纵轴不偏�?
		popupWindow.showAsDropDown(v, 0, 0);
		// listView的item点击事件
		listView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
				// TODO Auto-generated method stub				
				// 弹框消失
				switch( arg2)
				{		    	
		    	case 0: 
		    	{
		    		textViewcity.setText("����");
		    	}	    	
		    	};
				popupWindow.dismiss();
				popupWindow = null;
			}
		});	
	}
	

	//�������������popwindow
	@SuppressWarnings("deprecation")
	public void districtclick(View v) {
		//Log.i("addicon", "showview2");
		// 找到布局文件
		layout = (LinearLayout) LayoutInflater.from(this).inflate(R.layout.mypinner_dropdown, null);
		// 实例化listView
		listView = (ListView) layout.findViewById(R.id.listView);
		// 设置listView的�?配器
		//listView.setAdapter(adapter);
		listView.setAdapter(adapter3);
		// 实例化一个PopuWindow对象
		popupWindow = new PopupWindow(v);
		// 设置弹框的宽度为布局文件的宽
		popupWindow.setWidth(120);
		// 高度随着内容变化
		popupWindow.setHeight(LayoutParams.WRAP_CONTENT);
		// 设置�?��透明的背景，不然无法实现点击弹框外，弹框消失
		popupWindow.setBackgroundDrawable(new BitmapDrawable());
		// 设置点击弹框外部，弹框消�?
		popupWindow.setOutsideTouchable(true);
		// 设置焦点
		popupWindow.setFocusable(true);
		// 设置�?��布局
		popupWindow.setContentView(layout);
		// 设置弹框出现的位置，在v的正下方横轴偏移textview的宽度，为了对齐~纵轴不偏�?
		popupWindow.showAsDropDown(v, 0, 0);
		// listView的item点击事件
		listView.setOnItemClickListener(new OnItemClickListener() {
			@SuppressLint("ResourceAsColor")
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
				// TODO Auto-generated method stub				
				// 弹框消失
				//textViewdistrict.setTextColor(R.color.black);
				switch( arg2)
				{		    	
		    	case 0: 
		    	{
		    		textViewdistrict.setText("����");break;
		    	}	
		    	case 1: 
		    	{
		    		textViewdistrict.setText("����");break;
		    	}	
		    	case 3: 
		    	{
		    		textViewdistrict.setText("����");break;
		    	}	
		    	};
				popupWindow.dismiss();
				popupWindow = null;
			}
		});	
	}
}
