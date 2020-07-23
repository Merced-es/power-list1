package edu.cnm.deepdive.powerlist1.controller;

import android.net.Uri;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import edu.cnm.deepdive.powerlist1.R;
import edu.cnm.deepdive.powerlist1.controller.HomeFragment.OnFragmentInteractionListenerHome;

public class MainActivity extends AppCompatActivity implements OnFragmentInteractionListenerHome {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
  }

  @Override
  public void onFragmentInteractionHome(Uri uri) {

  }
}
