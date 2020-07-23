package edu.cnm.deepdive.powerlist1.controller;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import edu.cnm.deepdive.powerlist1.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PowerListFragment extends Fragment {

  public PowerListFragment() {
    // Required empty public constructor
  }


  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    return inflater.inflate(R.layout.fragment_power_list, container, false);
  }
}
