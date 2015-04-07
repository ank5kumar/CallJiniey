package com.example.calljiniey;

import java.util.ArrayList;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

public class RepairMaintenanceFragment extends ListFragment{

	private static final String TAG = "RepairServiceMaintenanceFragment";
	private ArrayList<ReapirService> mRepairs ;
	private ArrayList<String> mTitle;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		mRepairs = RepairLab.get(getActivity()).getCrimes();
		RepairServiceAdapter adapter = new RepairServiceAdapter(mRepairs);
		setListAdapter(adapter);
		
	}
	
	@Override
	public void onResume() {
		super.onResume();
		((RepairServiceAdapter)getListAdapter()).notifyDataSetChanged();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		//super.onCreateView(inflater, container, savedInstanceState);
		//inflater.inflate(R.layout.fragment_repair_maintenance, container,false);
		return super.onCreateView(inflater, container, savedInstanceState);

	}


	private class RepairServiceAdapter extends ArrayAdapter<ReapirService> {
		public RepairServiceAdapter(ArrayList<ReapirService> crimes) {
			super(getActivity(), 0, crimes);
		}
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// If we weren't given a view, inflate one
			if (convertView == null) {
				convertView = getActivity().getLayoutInflater()
						.inflate(R.layout.fragment_repair_item_repair, null);
			}
			// Configure the view for this Crime
			ReapirService c = getItem(position);
			TextView titleTextView =
					(TextView)convertView.findViewById(R.id.title);
			titleTextView.setText(c.getTitle());
			TextView dateTextView =
					(TextView)convertView.findViewById(R.id.date);
			dateTextView.setText(c.getDate().toString());
			CheckBox solvedCheckBox =
					(CheckBox)convertView.findViewById(R.id.solved);
			solvedCheckBox.setChecked(c.isSolved());
			return convertView;
		}

	}
}