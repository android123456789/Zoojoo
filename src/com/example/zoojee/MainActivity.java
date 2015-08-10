package com.example.zoojee;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.swipe.SwipeActionAdapter;
import com.example.swipe.SwipeDirections;

public class MainActivity extends Activity implements  OnClickListener, SwipeActionAdapter.SwipeActionListener{

	ListView updateList;
	
	ImageView navigationBar, defaultProfilePics;
	
	RelativeLayout allChallengesLayout;
	
	Button getGoingBtn, relaxNwBtn;
	
	UpdateListAdapter adapter;
	
	SwipeActionAdapter mAdapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		getActionBar().hide();

		updateList = (ListView) findViewById(R.id.update_list);
		navigationBar = (ImageView)findViewById(R.id.navigation_bar);
		defaultProfilePics = (ImageView)findViewById(R.id.default_profile_pics);
		allChallengesLayout = (RelativeLayout)findViewById(R.id.all_challenges_layout);
		getGoingBtn = (Button)findViewById(R.id.get_going_btn);
		relaxNwBtn = (Button)findViewById(R.id.relax_nw_btn);
		
		adapter = new UpdateListAdapter(getApplicationContext());
		updateList.setAdapter(adapter);
		
		mAdapter = new SwipeActionAdapter(adapter);
        mAdapter.setSwipeActionListener(this)
        		.setListView(updateList);
        updateList.setAdapter(mAdapter);
        
        mAdapter.addBackground(SwipeDirections.DIRECTION_NORMAL_LEFT, R.layout.swipe_left)
        		.addBackground(SwipeDirections.DIRECTION_FAR_LEFT, R.layout.swipe_left_far)
        		.addBackground(SwipeDirections.DIRECTION_NORMAL_RIGHT, R.layout.swipe_right)
        		.addBackground(SwipeDirections.DIRECTION_FAR_RIGHT, R.layout.swipe_right_far);
        
        navigationBar.setOnClickListener(this);
        defaultProfilePics.setOnClickListener(this);
        allChallengesLayout.setOnClickListener(this);
        getGoingBtn.setOnClickListener(this);
        relaxNwBtn.setOnClickListener(this);
	}

	@Override
	public boolean hasActions(int position) {
		return true;
	}

	@Override
	public boolean shouldDismiss(int position, int direction) {
		return false;
	}

	@Override
	public void onSwipe(int[] positionList, int[] directionList) {
		
		for (int i = 0; i < positionList.length; i++) {
			int position = positionList[i];
			int direction = directionList[i];
			
			switch (direction) {
				case SwipeDirections.DIRECTION_FAR_LEFT:
					Toast.makeText(getApplicationContext(), "No", Toast.LENGTH_SHORT).show();
					break;
				case SwipeDirections.DIRECTION_NORMAL_LEFT:
					Toast.makeText(getApplicationContext(), "No", Toast.LENGTH_SHORT).show();
					break;
				case SwipeDirections.DIRECTION_FAR_RIGHT:
					Toast.makeText(getApplicationContext(), "Yes", Toast.LENGTH_SHORT).show();
					break;
				case SwipeDirections.DIRECTION_NORMAL_RIGHT:
					Toast.makeText(getApplicationContext(), "Yes", Toast.LENGTH_SHORT).show();
					break;
			}
			mAdapter.notifyDataSetChanged();
		}
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.navigation_bar:
			Toast.makeText(getApplicationContext(), "Navigation Bar", Toast.LENGTH_SHORT).show();
			break;
		case R.id.default_profile_pics:
			Toast.makeText(getApplicationContext(), "User Profile", Toast.LENGTH_SHORT).show();
			break;
		case R.id.all_challenges_layout:
			Toast.makeText(getApplicationContext(), "All Challenges", Toast.LENGTH_SHORT).show();
			break;
		case R.id.get_going_btn:
			Toast.makeText(getApplicationContext(), "Get Going", Toast.LENGTH_SHORT).show();
			break;	
		case R.id.relax_nw_btn:
			Toast.makeText(getApplicationContext(), "Relax Now", Toast.LENGTH_SHORT).show();
			break;	
		default:
			break;
		}
	}
}