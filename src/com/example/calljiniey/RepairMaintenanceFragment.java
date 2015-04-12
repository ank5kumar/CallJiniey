package com.example.calljiniey;

import java.util.ArrayList;
import java.util.HashMap;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Filterable;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class RepairMaintenanceFragment extends Fragment {

	private static final String TAG = "RepairServiceMaintenanceFragment";
	private ArrayList<RepairService> mRepairs ;
	private ArrayList<String> mTitle;
	private EditText msearchServices;
	RepairServiceAdapter mserviceAdapter;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		mRepairs = RepairLab.get(getActivity().getApplicationContext()).getCrimes();

	}

	@Override
	public void onResume() {
		super.onResume();
		//((RepairServiceAdapter)getListAdapter()).notifyDataSetChanged();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreateView(inflater, container, savedInstanceState);
		View repairview = inflater.inflate(R.layout.fragment_repair_maintenance, container,false);
		ListView lv = (ListView)repairview.findViewById(R.id.fragment_repair_maintenance_services_list_view_services);
		msearchServices= (EditText)repairview.findViewById(R.id.fragment_repair_maintenance_input_search_services);
		msearchServices.addTextChangedListener(tw);

		mserviceAdapter = new RepairServiceAdapter(getActivity().getApplicationContext(),R.layout.fragment_repair_item_repair,mRepairs);
		lv.setAdapter(mserviceAdapter);
		lv.setOnItemClickListener(listener);
		return repairview;
		//	return super.onCreateView(inflater, container, savedInstanceState);

	}
	private OnItemClickListener listener= new OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			Intent i = new Intent(getActivity(),RepairsActivity.class);
			startActivity(i);
			// TODO Auto-generated method stub
			
		}
	};
	

	
	
	private TextWatcher tw = new TextWatcher() {

		@Override
		public void onTextChanged(CharSequence s, int start, int before, int count) {
			// TODO Auto-generated method stub
			mserviceAdapter.getFilter().filter(s); 

		}

		@Override
		public void beforeTextChanged(CharSequence s, int start, int count,
				int after) {
			// TODO Auto-generated method stub

		}

		@Override
		public void afterTextChanged(Editable s) {
			// TODO Auto-generated method stub

		}
	};


	private class RepairServiceAdapter extends ArrayAdapter<RepairService>   {

		public RepairServiceAdapter(Context context, int resource) {
			super(context, resource);
			// TODO Auto-generated constructor stub
		}
		public RepairServiceAdapter(Context mContext, int layoutResourceId, ArrayList<RepairService> data) {
			//super(getActivity(), 0, crimes);
			super(mContext, layoutResourceId, data);

		}
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// If we weren't given a view, inflate one
			if (convertView == null) {
				convertView = getActivity().getLayoutInflater()
						.inflate(R.layout.fragment_repair_item_repair, null);
			}
			// Configure the view for this Crime
			RepairService c = getItem(position);
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