package com.example.calljiniey;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;



public class ProblemDetailsServicesFragment extends Fragment{

	private Button mButton ;
	private View mProblemDetailsServicesFragmentView;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		//super.onCreateView(inflater, container, savedInstanceState);
		mProblemDetailsServicesFragmentView =  inflater.inflate(R.layout.fragment_respairs_problem_detail, container,false);
		mButton = (Button)mProblemDetailsServicesFragmentView.findViewById(R.id.fragment_respairs_problem_detail_NextButton);
		mButton.setOnClickListener(mButtoListener);


		return mProblemDetailsServicesFragmentView;
	}

	private View.OnClickListener mButtoListener = new View.OnClickListener() {

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





}
