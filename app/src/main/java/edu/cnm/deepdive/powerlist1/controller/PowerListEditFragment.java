package edu.cnm.deepdive.powerlist1.controller;

import android.app.Dialog;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.ViewModelProvider;
import edu.cnm.deepdive.powerlist1.R;
import edu.cnm.deepdive.powerlist1.model.entity.Goal;
import edu.cnm.deepdive.powerlist1.model.entity.PowerList;
import edu.cnm.deepdive.powerlist1.service.PowerListRepository;
import edu.cnm.deepdive.powerlist1.viewmodel.MainViewModel;


/**
 * A simple {@link Fragment} subclass.
 */
public class PowerListEditFragment extends DialogFragment implements TextWatcher {

    private static final String ID_KEY = "list_id";

    private long listId;
    private View root;
    private EditText listTitle;
    private EditText listDescription;
    private MainViewModel viewModel;
    private PowerList powerList;
    private AlertDialog dialog;

    public static PowerListEditFragment newInstance ( long listId){
      PowerListEditFragment fragment = new PowerListEditFragment();
      Bundle args = new Bundle();
      args.putLong(ID_KEY, listId);
      fragment.setArguments(args);
      return fragment;
    }

    @Override
    public void onCreate (Bundle savedInstanceState){
      super.onCreate(savedInstanceState);
      if (getArguments() != null) {
        listId = getArguments().getLong(ID_KEY, 0);
      }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog (@Nullable Bundle savedInstanceState){
      root = LayoutInflater.from(getContext())
          .inflate(R.layout.fragment_power_list_edit, null, false);
      listTitle = root.findViewById(R.id.list_title);
      listTitle.addTextChangedListener(this);
      listDescription = root.findViewById(R.id.list_description);
      listDescription.addTextChangedListener(this);
      // TODO Add listeners to fields.
      dialog = new AlertDialog.Builder(getContext())
//            .setIcon(android.R.drawable.ic_)
          .setTitle("List & To-Dos")
          .setView(root)
          .setPositiveButton(android.R.string.ok,(dlg, which) -> save())
          .setNegativeButton(android.R.string.cancel, (dlg, which) -> {})
          .create();
      dialog.setOnShowListener((dlg) -> checkSubmitCondition());
      return dialog;
    }

    private void save () {
      powerList.setDescription(listDescription.getText().toString().trim());
      powerList.setListTitle(listTitle.getText().toString().trim());
      viewModel.savePowerList(powerList);
    }

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState){
      return root;
    }

    @SuppressWarnings("ConstantConditions")
    @Override
    public void onViewCreated (@NonNull View view, @Nullable Bundle savedInstanceState){
      super.onViewCreated(view, savedInstanceState);
      viewModel = new ViewModelProvider(getActivity()).get(MainViewModel.class);
      if (listId != 0) {
        viewModel.getPowerList().observe(getViewLifecycleOwner(), (powerLists) -> {
          this.powerList = powerList;
          if (powerList != null) {
            listDescription.setText(powerList.getDescription());
            listTitle.setText(powerList.getListTitle());
          }
        });
        viewModel.setGoalId(listId);
      } else {
        powerList = new PowerList();
      }
    }

    @Override
    public void beforeTextChanged (CharSequence s,int start, int count, int after){
    }

    @Override
    public void onTextChanged (CharSequence s,int start, int before, int count){
    }

    @Override
    public void afterTextChanged (Editable s){
      checkSubmitCondition();
    }

    private void checkSubmitCondition () {
      Button positive = dialog.getButton(AlertDialog.BUTTON_POSITIVE);
      positive.setEnabled(
          !listDescription.getText().toString().trim().isEmpty()
          && !listTitle.getText().toString().trim().isEmpty()
      );
    }

  }