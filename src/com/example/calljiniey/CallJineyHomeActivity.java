package com.example.calljiniey;

import com.example.calljiniey.R;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class CallJineyHomeActivity extends CallJineyBaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_call_jiney_home);
		onCreateDrawer();
	}	
}
