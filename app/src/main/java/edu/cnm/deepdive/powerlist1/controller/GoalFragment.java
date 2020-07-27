package edu.cnm.deepdive.powerlist1.controller;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import edu.cnm.deepdive.powerlist1.R;
import edu.cnm.deepdive.powerlist1.model.entity.Goal;
import edu.cnm.deepdive.powerlist1.model.pojo.GoalWithList;
import edu.cnm.deepdive.powerlist1.view.GoalAdapter;
import edu.cnm.deepdive.powerlist1.viewmodel.MainViewModel;


public class GoalFragment extends Fragment implements GoalAdapter.OnClickListener {

    private MainViewModel mainViewModel;
    private RecyclerView goalList;
    private FloatingActionButton add;

    public View onCreateView(@NonNull LayoutInflater inflater,
        ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_goal, container, false);
        goalList = view.findViewById(R.id.goal_list);
        add = view.findViewById(R.id.add);
        add.setOnClickListener((v) -> editGoal(0));
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mainViewModel = new ViewModelProvider(getActivity())
            .get(MainViewModel.class);
        mainViewModel.getGoals().observe(getViewLifecycleOwner(), (goals) -> {
            GoalAdapter adapter =
                new GoalAdapter(getContext(), goals, this);
            goalList.setAdapter(adapter);
        });
    }

    @Override
    public void onClick(View view, int position, Goal goal) {
        editGoal(goal.getId());
    }

    private void editGoal(long goalId) {
        // TODO display goal edit dialog fragment.
    }
}