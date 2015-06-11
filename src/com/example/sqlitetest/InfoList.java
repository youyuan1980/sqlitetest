package com.example.sqlitetest;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class InfoList extends Activity {

	private Button btn = null;
	private ListView list = null;
	private InfoListAdapter ad = null;
	private EditText edit1=null;
	private ArrayList<InfoMode> datalist = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_info_list);
		btn = (Button) findViewById(R.id.btn);
		edit1=(EditText) findViewById(R.id.edit1);
		btn.setOnClickListener(btnonclicklistener);
		InfoDal dal = new InfoDal(InfoList.this);
		datalist = dal.GetListInfo();
		list = (ListView) findViewById(R.id.list);
		ad = new InfoListAdapter(InfoList.this, datalist);
		list.setAdapter(ad);
	}

	private OnClickListener btnonclicklistener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			InfoDal dal = new InfoDal(InfoList.this);
			dal.AddInfo(edit1.getText().toString());
			datalist.clear();
			datalist.addAll(dal.GetListInfo());
			ad.notifyDataSetChanged();
		}
	};
}
