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
import edu.cnm.deepdive.powerlist1.model.entity.PowerList;
import edu.cnm.deepdive.powerlist1.service.PowerListRepository;
import edu.cnm.deepdive.powerlist1.view.PowerListAdapter;
import edu.cnm.deepdive.powerlist1.viewmodel.MainViewModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class PowerListFragment extends Fragment implements PowerListAdapter.OnClickListener {

  private MainViewModel mainViewModel;
  private RecyclerView powerlistList;
  private FloatingActionButton add;


  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_power_list, container, false);
    powerlistList = view.findViewById(R.id.powerlist_list);
    add = view.findViewById(R.id.add);
    add.setOnClickListener((v) -> editPowerList(0));
    return view;
  }

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    mainViewModel = new ViewModelProvider(getActivity())
        .get(MainViewModel.class);
    mainViewModel.getPowerLists().observe(getViewLifecycleOwner(), (powerLists) -> {
      PowerListAdapter adapter =
          new PowerListAdapter(getContext(), powerLists, this);
      powerlistList.setAdapter(adapter);
    });
  }

  @Override
      public void onClick(View view, int position, PowerList powerList) {
        editPowerList(powerList.getListId());
  }

  private void editPowerList(long powerListId) {
  // TODO display powerlist edit dialog fragment.
    PowerListEditFragment fragment = PowerListEditFragment.newInstance(powerListId);
    fragment.show(getChildFragmentManager(), fragment.getClass().getName());

  }
}
