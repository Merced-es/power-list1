package edu.cnm.deepdive.powerlist1.controller;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import edu.cnm.deepdive.powerlist1.R;
import edu.cnm.deepdive.powerlist1.controller.HomeFragmentDirections.ActionHomeFragmentToSecondFragment;

public class HomeFragment extends Fragment {

  @Override
  public View onCreateView(
      LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState
  ) {
    // Inflate the layout for this fragment
    return inflater.inflate(R.layout.fragment_home, container, false);
  }

  public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);

    view.findViewById(R.id.button_first).setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        ActionHomeFragmentToSecondFragment action =
            HomeFragmentDirections.
                actionHomeFragmentToSecondFragment("From HomeFragment");
        NavHostFragment.findNavController(HomeFragment.this)
            .navigate(action);
      }
    });
  }
}
