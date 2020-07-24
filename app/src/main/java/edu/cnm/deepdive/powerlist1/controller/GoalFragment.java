package edu.cnm.deepdive.powerlist1.controller;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import edu.cnm.deepdive.powerlist1.R;
import edu.cnm.deepdive.powerlist1.model.pojo.GoalWithList;
import edu.cnm.deepdive.powerlist1.view.GoalAdapter;
import edu.cnm.deepdive.powerlist1.viewmodel.MainViewModel;


public class GoalFragment extends Fragment implements GoalAdapter.OnClickListener {

    private MainViewModel mainViewModel;
    private RecyclerView goalList;
    private FloatingActionButton addGoal;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //noinspection ConstantConditions
//        mainViewModel = new ViewModelProvider(getActivity()).get(MainViewModel.class);
//        mainViewModel.getGoals().observe(getViewLifecycleOwner(), (goals) -> {
//            goalList.setAdapter(new GoalAdapter(getContext(), goals, this));
//        });
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
        ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_goal, container, false);
        Button homeButton = view.findViewById(R.id.home_button);
        Button powerListButton = view.findViewById(R.id.power_list_button);

        homeButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.goal_to_home);
            }
        });

        powerListButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.goal_to_powerlist);
            }
        });
        return view;
    }

    @Override
    public void onClick(View v, int position, GoalWithList goal) {
        editGoal(goal.getGoalId());
    }

    private void editGoal(long goalId) {
        GoalEditFragment fragment = GoalEditFragment.newInstance(goalId);
    }

}