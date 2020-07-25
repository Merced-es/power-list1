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
import edu.cnm.deepdive.powerlist1.view.GoalAdapter;
import edu.cnm.deepdive.powerlist1.viewmodel.MainViewModel;


public class GoalFragment extends Fragment implements GoalAdapter.OnClickListener {

    private MainViewModel mainViewModel;
    private RecyclerView goalList;
    private FloatingActionButton add;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mainViewModel = new ViewModelProvider(getActivity())
            .get(MainViewModel.class);
        mainViewModel.getGoal().observe(getViewLifecycleOwner(), (goal) -> {
            goalList.setAdapter(new GoalAdapter(getContext(), goal.this));
        });

    public View onCreateView(@NonNull LayoutInflater inflater,
        ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_goal, container, false);
        goalList = view.findViewById(R.id.recycler_view;
        add = view.findViewById(R.id.add);
        add.setOnClickListener((v) -> editGoal(0));
        return view;
    }

}
}