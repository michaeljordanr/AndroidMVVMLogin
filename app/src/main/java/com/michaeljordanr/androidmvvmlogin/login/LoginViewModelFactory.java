package com.michaeljordanr.androidmvvmlogin.login;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

public class LoginViewModelFactory extends ViewModelProvider.NewInstanceFactory {
    private ILoginResultListener callback;

    public LoginViewModelFactory(ILoginResultListener callback) {
        this.callback = callback;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new LoginViewModel(callback);
    }
}
