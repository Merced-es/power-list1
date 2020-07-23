package edu.cnm.deepdive.powerlist1.controller;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
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
        mainViewModel = new ViewModelProvider(getActivity()).get(MainViewModel.class);
        mainViewModel.getGoals().observe(getViewLifecycleOwner(), (goals) -> {
            goalList.setAdapter(new GoalAdapter(getContext(), goals, this));
        });
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
        ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_goal, container, false);
        goalList = root.findViewById(R.id.goal_list);
        addGoal = root.findViewById(R.id.add_goal);
        addGoal.setOnClickListener((v) -> editGoal(0));
        return root;
    }

    @Override
    public void onClick(View v, int position, GoalWithList goal) {
        editGoal(goal.getGoalId());
    }

    private void editGoal(long goalId) {
        GoalEditFragment fragment = GoalEditFragment.newInstance(goalId);
    }

}