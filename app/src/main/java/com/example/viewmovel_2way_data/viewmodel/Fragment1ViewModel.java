package com.example.viewmovel_2way_data.viewmodel;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import com.example.viewmovel_2way_data.repositories.DataRepozitories;

public class Fragment1ViewModel extends ViewModel {

    // инициализируем репозиторий
    DataRepozitories dataRepozitories = DataRepozitories.getInstance();

    public void SetData(String st){
        Log.e(this.getClass().getSimpleName()," "+ new Throwable().getStackTrace()[0].getMethodName() +"  "+ Thread.currentThread().getName()+" "+System.currentTimeMillis());
        dataRepozitories.setData(st);
    }

}
