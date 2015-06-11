package com.example.sqlitetest;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class InfoListAdapter extends BaseAdapter {
	
	private Context pContext;
	
	private ArrayList<InfoMode> datalist;
	
	public InfoListAdapter(Context context,ArrayList<InfoMode> list)
	{
		this.pContext=context;
		datalist=list;
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return datalist.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return datalist.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ViewHoder v;
		if(convertView==null)
		{
			convertView=LayoutInflater.from(pContext).inflate(R.layout.infolistview, null);
			v=new ViewHoder();
			v.t=(TextView) convertView.findViewById(R.id.list_title);
			convertView.setTag(v);
		}
		else
		{
			v=(ViewHoder) convertView.getTag();
		}
		String Msg=(String)datalist.get(position).Title;
		v.t.setText(Msg);
		return convertView;
	}
	
	public class ViewHoder
	{
		TextView t;
	}

	
}
