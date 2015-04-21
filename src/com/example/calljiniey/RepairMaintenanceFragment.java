package com.example.calljiniey;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
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
	//private EditText msearchServices;
	private RepairServiceAdapter mserviceAdapter;

	private ListView mListView;

	private View fragmentRepairMaintenanceView;

	public  ArrayList<Device> mDeviceList = new ArrayList<Device>();
	
	
	 
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		AsyncCallForGettingDevices as = new AsyncCallForGettingDevices();
		as.execute();


	}

	@Override
	public void onResume() {
		super.onResume();
		if(mserviceAdapter!=null &&mDeviceList.size()!=0)
		{
			mserviceAdapter.clear();
			mserviceAdapter.addAll(mDeviceList);
			mserviceAdapter.notifyDataSetChanged();

		}
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreateView(inflater, container, savedInstanceState);
		fragmentRepairMaintenanceView  = inflater.inflate(R.layout.fragment_repair_maintenance, container,false);

		mListView = (ListView)fragmentRepairMaintenanceView.findViewById(R.id.fragment_repair_maintenance_services_list_view_services);
		ViewGroup header = (ViewGroup)inflater.inflate(R.layout.header_repair_service_list ,mListView,false);

		mListView.addHeaderView(header);

		mserviceAdapter = new RepairServiceAdapter(getActivity().getApplicationContext(),R.layout.fragment_repair_item_repair,mDeviceList);
		mListView.setAdapter(mserviceAdapter);


		mListView.setOnItemClickListener(listener);
		return fragmentRepairMaintenanceView;

	}

	private void SetListView()
	{

		mserviceAdapter.clear();
		mserviceAdapter.addAll(mDeviceList);
		mserviceAdapter.notifyDataSetChanged();



	}
	private OnItemClickListener listener= new OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			Intent i = new Intent(getActivity(),RepairsActivity.class);
			i.putExtra(Utils.SendDeviceId, mDeviceList.get(position-1).getId());
			startActivity(i);
			
			

			//Intent i = new Intent(getActivity(),OpeningPageActivity.class);
			//startActivity(i);

			// TODO Auto-generated method stub

		}
	};






	/*private TextWatcher tw = new TextWatcher() {

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
	 */

	private class AsyncCallForGettingDevices extends AsyncTask<Void, Void, Void> {
		@Override
		protected void onPostExecute(Void result1) {


			SetListView();

			getActivity().findViewById(R.id.loadingPanel).setVisibility(View.GONE);

		}


		@Override
		protected void onPreExecute() {
			getActivity().findViewById(R.id.loadingPanel).setVisibility(View.VISIBLE);
			//getActivity().setVisible(View.VISIBLE);
			//	refresh_dialog.setMessage("Loading Transactions");
		}

		@Override
		protected void onProgressUpdate(Void... values) {
		}

		@Override
		protected Void doInBackground(Void... params) {
			//	getData();
			mDeviceList = FetchData.GetDeviceList();
			return null;

		}

	}


	private class RepairServiceAdapter extends ArrayAdapter<Device>   {

		public RepairServiceAdapter(Context context, int resource) {
			super(context, resource);
			// TODO Auto-generated constructor stub
		}


		public RepairServiceAdapter(Context applicationContext,
				int fragmentRepairItemRepair, ArrayList<Device> mDeviceList) {

			super(applicationContext, 0);
			// TODO Auto-generated constructor stub
		}


		@Override
		public View getView(int position, View convertView, ViewGroup parent) {


			if (convertView == null) {
				convertView = getActivity().getLayoutInflater()
						.inflate(R.layout.fragment_repair_listitem, null);
			}

			String deviceName = mDeviceList.get(position).getDeviceName();

			TextView tv = (TextView)convertView.findViewById(R.id.fragment_repair_list_item_device_name);
			tv.setText(deviceName);

			return convertView;


		}

	}
}