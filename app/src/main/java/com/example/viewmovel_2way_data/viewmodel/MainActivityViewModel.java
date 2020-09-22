package com.example.viewmovel_2way_data.viewmodel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainActivityViewModel extends ViewModel {

    private String st;

    private final MutableLiveData<String> selected = new MutableLiveData<String>();

    public void select(String st) {
        this.st=st;
        Log.e(this.getClass().getSimpleName()," "+ new Throwable().getStackTrace()[0].getMethodName() +"  "+ Thread.currentThread().getName()+" "+System.currentTimeMillis());
        Log.i("select" , st);
        selected.setValue(st);
    }

    public LiveData<String> getSelected() {
        Log.e(this.getClass().getSimpleName()," "+ new Throwable().getStackTrace()[0].getMethodName() +"  "+ Thread.currentThread().getName()+" "+System.currentTimeMillis());
        selected.setValue(st);
        //return st;
        return selected;
    }
}
