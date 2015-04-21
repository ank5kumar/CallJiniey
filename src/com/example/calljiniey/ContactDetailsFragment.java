package com.example.calljiniey;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ContactDetailsFragment extends Fragment {
	

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
		 return inflater.inflate(R.layout.fragment_contact_details, container,false);
	}
	
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


}
