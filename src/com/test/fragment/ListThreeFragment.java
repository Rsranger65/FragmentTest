package com.test.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * @author alexg
 */
public class ListThreeFragment extends ListFragment implements OnClickListener {
	private Callbacks callbacks;
	
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		callbacks = (Callbacks) activity;
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.list_three, container, false);
		return view;
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		
		ArrayAdapter<String> aa = new ArrayAdapter<String>(getActivity(),
			android.R.layout.simple_list_item_1, android.R.id.text1);
		
		aa.add(getArguments().getString(MainActivity.KEY_ARGS));
		aa.add("LV Three");
		aa.add("Foo");
		aa.add("Bar");
		aa.add("Baz");
		
		getListView().setAdapter(aa);
		
		getActivity().findViewById(R.id.button_1).setOnClickListener(this);
		getActivity().findViewById(R.id.button_2).setOnClickListener(this);
		getActivity().findViewById(R.id.button_3).setOnClickListener(this);
	}
	
	@Override
	public void onClick(View v) {
		callbacks.onThreeButtonClick(((TextView) v).getText().toString());
	}
	
	public interface Callbacks {
		public void onThreeButtonClick(String title);
	}
	
}
