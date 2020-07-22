package edu.cnm.deepdive.powerlist1.controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import edu.cnm.deepdive.powerlist1.R;


public class GoalsFragment extends AppCompatActivity implements View.OnClickListener {

  private Button button;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.content_main);
    Button button1 = findViewById(R.id.create_goal);
    Button button2 = findViewById(R.id.create_power_list);
    Button button3 = findViewById(R.id.edit_goal);
    button1.setOnClickListener(this);
    button2.setOnClickListener(this);
    button3.setOnClickListener(this);
  }

  @Override
  public void onClick(View v) {
    Intent intent;
    switch (v.getId()) {
      case R.id.goal_edit_fragment:
        intent = new Intent(this, GoalEditFragment.class);
        break;
      case R.id.power_list_create_fragment:
        intent = new Intent(this, PowerListCreateFragment.class);
        break;
      case R.id.goal_edit_fragment:
        intent = new Intent(this, GoalEditFragment.class);
        break;
    }
    startActivity(intent);
  }
}