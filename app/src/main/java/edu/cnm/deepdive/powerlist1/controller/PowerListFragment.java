package edu.cnm.deepdive.powerlist1.controller;

import android.os.Bundle;
import android.view.View.OnClickListener;
import android.widget.Button;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import edu.cnm.deepdive.powerlist1.R;
import edu.cnm.deepdive.powerlist1.model.pojo.GoalWithList;
import edu.cnm.deepdive.powerlist1.view.GoalAdapter;
import edu.cnm.deepdive.powerlist1.viewmodel.MainViewModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class PowerListFragment extends Fragment implements GoalAdapter.OnClickListener {

  private MainViewModel mainViewModel;
  private RecyclerView powerListList;
  private FloatingActionButton addPowerList;

  public PowerListFragment() {
    // Required empty public constructor
  }


  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_power_list, container, false);
    Button homeButton = view.findViewById(R.id.home_button);
    Button goalsButton = view.findViewById(R.id.goals_button);

    homeButton.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View view) {
        Navigation.findNavController(view).navigate(R.id.powerlist_to_home);
      }
    });

    goalsButton.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View view) {
        Navigation.findNavController(view).navigate(R.id.powerlist_to_goal);
      }
    });
    return view;
  }
  @Override
  public void onClick(View view, int position, GoalWithList goal) {

  }
}
