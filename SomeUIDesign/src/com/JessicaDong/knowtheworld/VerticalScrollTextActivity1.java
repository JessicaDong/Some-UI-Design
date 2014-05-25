package com.JessicaDong.knowtheworld;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;



public class VerticalScrollTextActivity1 extends Activity{


	VerticalScrollTextView mSampleView;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_verticalscroll);
		mSampleView = (VerticalScrollTextView) findViewById(R.id.sampleView1);
		List lst=new ArrayList<Scentence1>();
		for(int i=0;i<30;i++){
			int t = i%3;
			switch (t) {
			case 0:
				Scentence1 sen1=new Scentence1(i,i+" ");
				lst.add(i, sen1);
				break;
            case 1:
            	Scentence1 sen2=new Scentence1(i,i+" ");
				lst.add(i, sen2);
				break;
            case 2:
            	Scentence1 sen3=new Scentence1(i,i+" ");
				lst.add(i, sen3);
	            break;

			default:
				break;
			}
//			if(i%2==0){
//				Scentence1 sen=new Scentence1(i,i+"、金球奖三甲揭晓 C罗梅西哈维入围 ");
//				lst.add(i, sen);
//			}else{
//				Scentence1 sen=new Scentence1(i,i+"、公牛欲用三大主力换魔兽？？？？");
//				lst.add(i, sen);
//			}
		}	
		//给View传递数据
		mSampleView.setList(lst);
		//更新View
		mSampleView.updateUI();		
	}	
}
