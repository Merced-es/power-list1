package edu.cnm.deepdive.powerlist1.controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import edu.cnm.deepdive.powerlist1.R;

public class GoalEditFragment extends Fragment {

  @Override
  public View onCreateView(
      LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    return inflater.inflate(R.layout.fragment_goal_edit, container, false);
  }

  public class NavigationActivity extends AppCompatActivity implements View.OnClickListener {

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_navigation);
      Button button1 = findViewById(R.id.goals_fragment);
      Button button2 = findViewById(R.id.power_list_fragment);
      Button button3 = findViewById(R.id.vision_board_fragment);
      button1.setOnClickListener(this);
      button2.setOnClickListener(this);
      button3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
      Intent intent;
      switch (v.getId()) {
        case R.id.goals_fragment:
          intent = new Intent(this, GoalsFragment.class);
          break;
        case R.id.power_list_fragment:
          intent = new Intent(this, PowerListFragment.class);
          break;
        case R.id.vision_board_fragment:
          intent = new Intent(this, VisionBoardFragment.class);
          break;
      }
      startActivity(intent);
    }

  }
