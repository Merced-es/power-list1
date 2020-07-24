package edu.cnm.deepdive.powerlist1.controller;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import edu.cnm.deepdive.powerlist1.R;

public class HomeFragment extends Fragment {

  @Override
  public View onCreateView(
      LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_home, container, false);
    Button goalButton = view.findViewById(R.id.goals_button);
    Button powerListButton = view.findViewById(R.id.power_list_button);

    goalButton.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View view) {
        Navigation.findNavController(view).navigate(R.id.home_to_goal);
      }
    });

    powerListButton.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View view) {
        Navigation.findNavController(view).navigate(R.id.home_to_powerlist);
      }
    });
    return view;
  }


  public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {


  }

  public interface OnFragmentInteractionListenerHome {
    // TODO update argument type and name if there is time.
    void onFragmentInteractionHome(Uri uri);
  }

}



