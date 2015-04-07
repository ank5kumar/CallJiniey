package com.example.calljiniey;

import com.example.calljiniey.R;

import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class CallJineyHomeActivity extends CallJineyBaseActivity implements ActionBar.TabListener {
	private String[] tabs = { "Repairs", "ProfeesionalServices", "Other Services" };
	private static  final String TAG="In Transaction Page Activity";

	public ViewPager viewPager;
	public ActionBar actionBar;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_call_jiney_home);
		onCreateDrawer();
		viewPager = (ViewPager) findViewById(R.id.home_pager_tabs);
		actionBar = getActionBar();

		//actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.action_bar_top));
		viewPager.setAdapter(new TabsPagerAdapter(getSupportFragmentManager()));

		actionBar.setTitle("CallJiney");
		//actionBar.setHomeButtonEnabled(false);
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);	
		addTabs(tabs);


	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu items for use in the action bar
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.call_jiney_home, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		switch (item.getItemId()) {
		case R.id.action_search:
			Intent i = new Intent(CallJineyHomeActivity.this, SearchActivity.class);
			startActivity(i);	      
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}


	public void addTabs(String[] tabNames) {
		//actionBar.setStackedBackgroundDrawable(getResources().getDrawable(
		//	R.drawable.actionbar_tab_indicator));
		for (String tab_name : tabNames) {
			actionBar.addTab(actionBar.newTab().setText(tab_name).setTabListener(this));
		}
		viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

			@Override
			public void onPageSelected(int position) {
				// on changing the page
				// make respected tab selected
				actionBar.setSelectedNavigationItem(position);
			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
			}

			@Override
			public void onPageScrollStateChanged(int arg0) {
			}
		});	
	}


	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		viewPager.setCurrentItem(tab.getPosition());

	}


	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub

	}


	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub

	}
}
