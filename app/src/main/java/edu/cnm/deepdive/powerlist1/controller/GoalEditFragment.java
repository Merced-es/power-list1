package edu.cnm.deepdive.powerlist1.controller;

import android.app.Dialog;
import android.os.Bundle;
import android.text.Editable;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.lifecycle.ViewModelProvider;
import edu.cnm.deepdive.powerlist1.R;
import edu.cnm.deepdive.powerlist1.model.entity.Goal;
import edu.cnm.deepdive.powerlist1.model.entity.PowerList;
import edu.cnm.deepdive.powerlist1.viewmodel.MainViewModel;
import java.util.List;

/**
 * A simple {@link Fragment} subclass. New Instance creates a new goal.
 */
public class GoalEditFragment extends Fragment {

    private static final String ID_KEY = "goal_id";

    private long goalId;
    private EditText goalText;
    private MainViewModel viewModel;
    private Goal goal;
    private List<PowerList> powerLists;

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
}

