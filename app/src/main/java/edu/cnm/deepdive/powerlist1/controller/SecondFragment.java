package edu.cnm.deepdive.powerlist1.controller;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import edu.cnm.deepdive.powerlist1.R;

public class SecondFragment extends Fragment {

  @Override
  public View onCreateView(
      LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState
  ) {
    // Inflate the layout for this fragment
    return inflater.inflate(R.layout.fragment_second, container, false);
  }

  public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);

    String myArg = SecondFragmentArgs.fromBundle(getArguments()).getMyArg();
    TextView textView = view.findViewById(R.id.textview_second);
    textView.setText(getString(R.string.hello_second_fragment, myArg));

    view.findViewById(R.id.button_second).setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        NavHostFragment.findNavController(SecondFragment.this)
            .navigate(R.id.action_SecondFragment_to_HomeFragment);
      }
    });
  }

}


public class NavigationActivity extends AppCompatActivity implements View.OnClickListener {
  private Button button;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_navigation);
    Button button1 = findViewById(R.id.itinerary);
    Button button2 = findViewById(R.id.accommodation);
    Button button3 = findViewById(R.id.points_of_interest);
    Button button4 = findViewById(R.id.about);
    Button button5 = findViewById(R.id.fauna_and_flora);
    Button button6 = findViewById(R.id.general_information);
    button1.setOnClickListener(this);
    button2.setOnClickListener(this);
    button3.setOnClickListener(this);
    button4.setOnClickListener(this);
    button5.setOnClickListener(this);
    button6.setOnClickListener(this);
  }
  @Override
  public void onClick(View v) {
    Intent intent;
    switch (v.getId()) {
      case R.id.itinerary:
        intent = new Intent(this, ItineraryActivity.class);
        break;
      case R.id.accommodation:
        intent = new Intent(this, AccommodationActivity.class);
        break;
      case R.id.points_of_interest :
        intent = new Intent(this, PointsOfInterestActivity.class);
        break;
      case R.id.about :
        intent = new Intent(this, AboutActivity.class);
        break;
      case R.id.fauna_and_flora :
        intent = new Intent(this, FaunaAndFloraActivity.class);
        break;
      default: //case R.id.general_information:
        intent = new Intent(this, GeneralInformationActivity.class);
        break;
    }
    startActivity(intent);
  }
}


