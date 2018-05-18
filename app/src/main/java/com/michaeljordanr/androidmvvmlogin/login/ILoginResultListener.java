package com.michaeljordanr.androidmvvmlogin.login;

public interface ILoginResultListener {
    void onSuccess(String message);
    void onError(String message);
}
