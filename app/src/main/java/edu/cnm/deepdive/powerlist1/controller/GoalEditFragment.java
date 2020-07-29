package edu.cnm.deepdive.powerlist1.controller;

import android.app.Dialog;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import edu.cnm.deepdive.powerlist1.R;
import edu.cnm.deepdive.powerlist1.model.entity.Goal;
import edu.cnm.deepdive.powerlist1.viewmodel.MainViewModel;

/**
 * A simple {@link Fragment} subclass. New Instance creates a new goal.
 */
public class GoalEditFragment extends DialogFragment implements TextWatcher {

    private static final String ID_KEY = "goal_id";

    private long goalId;
    private View root;
    private EditText goalTitle;
    private EditText goalDescription;
    private MainViewModel viewModel;
    private Goal goal;
    private AlertDialog dialog;

    public static GoalEditFragment newInstance(long goalId) {
        GoalEditFragment fragment = new GoalEditFragment();
        Bundle args = new Bundle();
        args.putLong(ID_KEY, goalId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            goalId = getArguments().getLong(ID_KEY, 0);
        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        root = LayoutInflater.from(getContext()).inflate(R.layout.fragment_goal_edit, null, false);
        goalTitle = root.findViewById(R.id.goal_title);
        goalTitle.addTextChangedListener(this);
        goalDescription = root.findViewById(R.id.goal_description);
        goalDescription.addTextChangedListener(this);
        // TODO Add listeners to fields.
        dialog = new AlertDialog.Builder(getContext())
//            .setIcon(android.R.drawable.ic_)
            .setTitle("Goals")
            .setView(root)
            .setPositiveButton(android.R.string.ok,(dlg, which) -> save())
            .setNegativeButton(android.R.string.cancel, (dlg, which) -> {})
            .create();
        dialog.setOnShowListener((dlg) -> checkSubmitCondition());
        return dialog;
    }

    private void save() {
        goal.setDescription(goalDescription.getText().toString().trim());
        goal.setTitle(goalTitle.getText().toString().trim());
        viewModel.saveGoal(goal);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {
        return root;
    }

    @SuppressWarnings("ConstantConditions")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = new ViewModelProvider(getActivity()).get(MainViewModel.class);
        if (goalId != 0) {
            viewModel.getGoal().observe(getViewLifecycleOwner(), (goal) -> {
                this.goal = goal;
                if (goal != null) {
                    goalDescription.setText(goal.getDescription());
                    goalTitle.setText(goal.getTitle());
                }
            });
            viewModel.setGoalId(goalId);
        } else {
            goal = new Goal();
        }
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
    }

    @Override
    public void afterTextChanged(Editable s) {
        checkSubmitCondition();
    }

    private void checkSubmitCondition() {
        Button positive = dialog.getButton(AlertDialog.BUTTON_POSITIVE);
        positive.setEnabled(
            !goalDescription.getText().toString().trim().isEmpty()
            && !goalTitle.getText().toString().trim().isEmpty()
        );
    }

}



