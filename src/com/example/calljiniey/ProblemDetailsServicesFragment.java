package com.example.calljiniey;

import java.util.ArrayList;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;



public class ProblemDetailsServicesFragment extends Fragment{

	private Button mButton ;
	private View mProblemDetailsServicesFragmentView;
	private int mDeviceId=-1;
	private ListView mProblemsListView;
	ArrayList<ProblemDevice> mproblemTypes = new ArrayList<ProblemDevice>();
	AsyncCallForGettingProblems mPr;

	private View mContainerView ;
	ProblemDetailsServiceAdapter mProblemAdapter;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		mDeviceId=getArguments().getInt(Utils.SendDeviceId);
		mPr = new AsyncCallForGettingProblems();

	}

	@Override
	public void onResume() {
		super.onResume();
		if(mProblemAdapter!=null &&mproblemTypes.size()!=0)
		{
			mProblemAdapter.clear();
			mProblemAdapter.addAll(mproblemTypes);
			mProblemAdapter.notifyDataSetChanged();

		}
	}


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreateView(inflater, container, savedInstanceState);
		/*	mProblemDetailsServicesFragmentView =  inflater.inflate(R.layout.fragment_repairs_problem_detail, container,false);
		mButton = (Button)mProblemDetailsServicesFragmentView.findViewById(R.id.fragment_repairs_problem_detail_NextButton);
		mButton.setOnClickListener(mButtoListener);

		mProblemsList  = (ListView)mProblemDetailsServicesFragmentView.findViewById(R.id.fragment_repairs_problem_detail_list_view_problem_details);
		mProblemAdapter = new ProblemDetailsServiceAdapter(getActivity().getApplicationContext(), R.layout.fragment_problem_detail_list_item,mproblemTypes);
		mProblemsList.setAdapter(mProblemAdapter);
		 */

		mProblemDetailsServicesFragmentView  = inflater.inflate(R.layout.fragment_repairs_problem_detail, container,false);

		mProblemsListView = (ListView)mProblemDetailsServicesFragmentView.findViewById(R.id.fragment_repairs_problem_detail_list_view_problem_details);

		mProblemsListView.setOnItemClickListener(listener);

		mProblemAdapter = new ProblemDetailsServiceAdapter(getActivity().getApplicationContext(),R.layout.fragment_problem_detail_list_item,mproblemTypes);
		mProblemsListView.setAdapter(mProblemAdapter);

		mButton = (Button)mProblemDetailsServicesFragmentView.findViewById(R.id.fragment_repairs_problem_detail_NextButton);
		mButton.setOnClickListener(mButtonListener);

		mContainerView = mProblemDetailsServicesFragmentView.findViewById(R.id.fragment_repairs_problem_detail_list_container);

		if(mproblemTypes.size()==0)
			mPr.execute();


		return mProblemDetailsServicesFragmentView;
	}

	private void SetListView()
	{

		mProblemAdapter.clear();
		mProblemAdapter.addAll(mproblemTypes);
		mProblemAdapter.notifyDataSetChanged();

	}
	private OnItemClickListener listener= new OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			Intent i = new Intent(getActivity(),OpeningPageActivity.class);
			startActivity(i);



			//Intent i = new Intent(getActivity(),OpeningPageActivity.class);
			//startActivity(i);

			// TODO Auto-generated method stub

		}
	};

	private View.OnClickListener mButtonListener = new View.OnClickListener() {

		public void onClick(View v) {
			ContactDetailsFragment cdf =(ContactDetailsFragment) getActivity().getSupportFragmentManager().findFragmentByTag(TagNamesFragments.TAG_CONTACT_DETAILS_FRAGMENT);
			if(cdf==null)
			{
				cdf = new ContactDetailsFragment();
			}

			FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
			ft.replace(R.id.activity_repairs_fragment_container, cdf);
			ft.addToBackStack(TagNamesFragments.TAG_PROBLEM_DETAILS_SERVICES_FRAGMENT);
			ft.commit();


		}

	};


	private class ProblemDetailsServiceAdapter extends ArrayAdapter<ProblemDevice>
	{

		public ProblemDetailsServiceAdapter(Context context, int resource) {
			super(context, resource);
			// TODO Auto-generated constructor stub
		}


		public ProblemDetailsServiceAdapter(Context applicationContext,
				int fragmentProblemDetailListItem,
				ArrayList<ProblemDevice> mproblemTypes) {
			super(applicationContext, 0);

			// TODO Auto-generated constructor stub
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return mproblemTypes.size();
		}


		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			if (convertView == null) {
				convertView = getActivity().getLayoutInflater()
						.inflate(R.layout.fragment_problem_detail_list_item, null);
			}

			String probLemName = mproblemTypes.get(position).getDesc();

			TextView tv = (TextView)convertView.findViewById(R.id.fragment_problem_detail_list_item_problem_description);
			tv.setText(probLemName);

			return convertView;

		}
	}




	private class AsyncCallForGettingProblems extends AsyncTask<Void, Void, Void> {
		@Override
		protected void onPostExecute(Void result1) {

			SetListView();

			getActivity().findViewById(R.id.loadingPanel).setVisibility(View.GONE);
			mContainerView.setVisibility(View.VISIBLE);

		}


		@Override
		protected void onPreExecute() {
			getActivity().findViewById(R.id.loadingPanel).setVisibility(View.VISIBLE);
			mContainerView.setVisibility(View.GONE);
			//	refresh_dialog.setMessage("Loading Transactions");
		}

		@Override
		protected void onProgressUpdate(Void... values) {
		}

		@Override
		protected Void doInBackground(Void... params) {

			mproblemTypes = FetchData.GetProblemsForDeviceId(mDeviceId);


			return null;

		}

	}



}
