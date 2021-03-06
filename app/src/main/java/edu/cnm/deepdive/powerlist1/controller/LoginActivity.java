package edu.cnm.deepdive.powerlist1.controller;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import edu.cnm.deepdive.powerlist1.R;
import edu.cnm.deepdive.powerlist1.service.GoogleSignInService;

public class LoginActivity extends AppCompatActivity {

  private static final int LOGIN_REQUEST_CODE = 1000;

  private GoogleSignInService repository;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    repository = GoogleSignInService.getInstance();
    repository.refresh()
        .addOnSuccessListener((account) -> switchToNavigationActivity())
        .addOnFailureListener((ex) -> {
          setContentView(R.layout.activity_login);
          findViewById(R.id.sign_in).setOnClickListener((v) ->
              repository.startSignIn(this, LOGIN_REQUEST_CODE));
        });
  }

  @Override
  protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
    if (requestCode == LOGIN_REQUEST_CODE) {
      repository.completeSignIn(data)
          .addOnSuccessListener((account) -> switchToNavigationActivity())
          .addOnFailureListener((throwable) ->
              Toast.makeText(this, R.string.login_failure, Toast.LENGTH_LONG).show());
    } else {
      super.onActivityResult(requestCode, resultCode, data);
    }
  }

  private void switchToNavigationActivity() {
    Intent intent = new Intent(this, MainActivity.class);
    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
    startActivity(intent);
  }

}