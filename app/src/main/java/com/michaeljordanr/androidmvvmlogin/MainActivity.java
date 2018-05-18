package com.michaeljordanr.androidmvvmlogin;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.michaeljordanr.androidmvvmlogin.databinding.ActivityMainBinding;
import com.michaeljordanr.androidmvvmlogin.login.ILoginResultListener;
import com.michaeljordanr.androidmvvmlogin.login.LoginViewModel;
import com.michaeljordanr.androidmvvmlogin.login.LoginViewModelFactory;

import es.dmoral.toasty.Toasty;

public class MainActivity extends AppCompatActivity implements ILoginResultListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding activityMainBinding = DataBindingUtil
                .setContentView(this, R.layout.activity_main);
        activityMainBinding.setViewModel(
                ViewModelProviders.of(this, new LoginViewModelFactory(this))
                        .get(LoginViewModel.class));
    }

    @Override
    public void onSuccess(String message) {
        Toasty.success(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onError(String message) {
        Toasty.error(this, message, Toast.LENGTH_SHORT).show();
    }
}
