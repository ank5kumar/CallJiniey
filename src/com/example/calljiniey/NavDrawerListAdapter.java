package com.example.calljiniey;


import java.util.ArrayList;


import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class NavDrawerListAdapter extends BaseAdapter {

	private Context context;
	private ArrayList<NavDrawerItem> navDrawerItems;
	
	 int[] listItemBackground = new int[] { R.drawable.list_item_fancy_background1,
	            R.drawable.list_item_fancy_background2 };

	public NavDrawerListAdapter(Context context, ArrayList<NavDrawerItem> navDrawerItems){
		this.context = context;
		this.navDrawerItems = navDrawerItems;
	}

	@Override
	public int getCount() {
		return navDrawerItems.size();
	}

	@Override
	public Object getItem(int position) {		
		return navDrawerItems.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			LayoutInflater mInflater = (LayoutInflater)
					context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
			convertView = mInflater.inflate(R.layout.drawer_list_item, parent,false);
		}

		ImageView imgIcon = (ImageView) convertView.findViewById(R.id.icon);
		imgIcon.setFocusable(false);
		TextView txtTitle = (TextView) convertView.findViewById(R.id.title);
		txtTitle.setFocusable(false);
		TextView txtCount = (TextView) convertView.findViewById(R.id.counter);
		txtCount.setFocusable(false);

		imgIcon.setImageResource(navDrawerItems.get(position).getIcon());        
		txtTitle.setText(navDrawerItems.get(position).getTitle());

		// displaying count
		// check whether it set visible or not
		if(navDrawerItems.get(position).getCounterVisibility()){
			txtCount.setText(navDrawerItems.get(position).getCount());
		}else{
			// hide the counter view
			txtCount.setVisibility(View.GONE);
		}
		/*if(position%2!=0)
			convertView.setBackgroundResource(listItemBackground[1]);
		else
			convertView.setBackgroundResource(listItemBackground[0]);
			//convertView.getBackground().setColorFilter(Color.parseColor("#00ff00"), PorterDuff.Mode.DARKEN);
			//convertView.setBackgroundColor(getResource().getColor());
*/
		return convertView;
	}

}
