//package edu.cnm.deepdive.powerlist1.controller;
//
//import android.content.Intent;
//import android.net.Uri;
//import android.os.Bundle;
//import android.widget.Toast;
//import androidx.annotation.NonNull;
//import androidx.lifecycle.ViewModelProvider;
//import com.google.android.material.floatingactionbutton.FloatingActionButton;
//import com.google.android.material.snackbar.Snackbar;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.appcompat.widget.Toolbar;
//import android.view.View;
//import android.view.Menu;
//import android.view.MenuItem;
//import edu.cnm.deepdive.powerlist1.R;
//import edu.cnm.deepdive.powerlist1.controller.HomeFragment.OnFragmentInteractionListenerHome;
//import edu.cnm.deepdive.powerlist1.service.GoogleSignInService;
//import edu.cnm.deepdive.powerlist1.viewmodel.MainViewModel;
//
//public class MainActivity2 extends AppCompatActivity implements OnFragmentInteractionListenerHome {
//
//  private GoogleSignInService signInService;
//
//  public MainActivity2() {
//
//  }
//
//  public MainActivity2(GoogleSignInService signInService) {
//    this.signInService = signInService;
//  }
//
//  @Override
//  protected void onCreate(Bundle savedInstanceState) {
//    super.onCreate(savedInstanceState);
//    setContentView(R.layout.activity_main2);
//    Toolbar toolbar = findViewById(R.id.toolbar);
//    setSupportActionBar(toolbar);
//
//    FloatingActionButton fab = findViewById(R.id.fab);
//    fab.setOnClickListener(new View.OnClickListener() {
//      @Override
//      public void onClick(View view) {
//        Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//            .setAction("Action", null).show();
//      }
//    });
//  }
//
//  @Override
//  public boolean onCreateOptionsMenu(Menu menu) {
//    super.onCreateOptionsMenu(menu);
//    getMenuInflater().inflate(R.menu.options, menu);
//    return true;
//  }
//
//  @Override
//  public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//    boolean handled = true;
//    //noinspection SwitchStatementWithTooFewBranches
////    switch(item.getItemId()) {
////      case R.id.sign_out:
////        signInService.signOut().addOnCompleteListener((ignored) -> switchToLogin());
////        break;
////      default:
////        handled = super.onOptionsItemSelected(item);
////    }
//    return handled;
//  }
//
//  private void setupObservers() {
//    MainViewModel viewModel = new ViewModelProvider(this).get(MainViewModel.class);
//    getLifecycle().addObserver(viewModel);
//    viewModel.getThrowable().observe(this, (throwable) -> {
//      if (throwable != null) {
//        Toast.makeText(this, throwable.getMessage(), Toast.LENGTH_LONG).show();
//      }
//    });
//    signInService = GoogleSignInService.getInstance();
//  }
//
//
//  private void switchToLogin() {
//    Intent intent = new Intent(this, LoginActivity.class);
//    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
//    startActivity(intent);
//  }
//
//  @Override
//  public void onFragmentInteractionHome(Uri uri) {
//
//  }
//}