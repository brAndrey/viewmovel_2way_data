package com.example.viewmovel_2way_data.viewmodel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.viewmovel_2way_data.repositories.DataRepozitories;

public class Fragment2ViewModel extends ViewModel  {


    private final MutableLiveData<String> selected = new MutableLiveData<String>();

    public LiveData<String> gatData() {
        // получаем данные из репозитория , без учёта жизненного цикла observeForever
        DataRepozitories dataRepozitories = DataRepozitories.getInstance();
        dataRepozitories.getData().observeForever(intText -> {
            Log.e(this.getClass().getSimpleName(), " " + new Throwable().getStackTrace()[0].getMethodName() + "  " + Thread.currentThread().getName() + " " + System.currentTimeMillis());
            Log.e(this.getClass().getSimpleName()," "+intText);
            selected.setValue(intText);

            // запуск собственного LIveData
            selected.setValue(intText);
        });



        return selected;

    }

}
