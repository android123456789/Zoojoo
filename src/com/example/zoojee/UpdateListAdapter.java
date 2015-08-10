package com.example.zoojee;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class UpdateListAdapter extends BaseAdapter {

	Context context;

	public UpdateListAdapter(Context context) {
		this.context = context;
	}

	@Override
	public int getCount() {
		return 10;
	}

	@Override
	public Object getItem(int position) {
		return "Test";
	}

	@Override
	public long getItemId(int position) {
		return 10;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		LayoutInflater mInflater = (LayoutInflater) context
				.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.activity_quick_update,
					parent, false);

			TextView counterTxt = (TextView) convertView
					.findViewById(R.id.counter_txt);
			
			TextView updateTitleTxt = (TextView) convertView
					.findViewById(R.id.update_title);

			counterTxt.setText("" + position);
			updateTitleTxt.setText("Read More Books");
		}

		return convertView;
	}
}
