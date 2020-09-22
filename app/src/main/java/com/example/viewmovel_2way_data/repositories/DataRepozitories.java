package com.example.viewmovel_2way_data.repositories;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class DataRepozitories {

    private final MutableLiveData<String> selected = new MutableLiveData<String>();

    // инициируем синглтон
    private static DataRepozitories INSTANCE;

    private DataRepozitories() {
    }

    public static DataRepozitories getInstance() {
        if (INSTANCE == null) {
            synchronized (DataRepozitories.class) {
                INSTANCE = new DataRepozitories();
            }
        }
        return INSTANCE;
    }
    //--------------------------

    // принытие данных
    public void setData(String st){
        // изменяем состояние MutableLiveData чем запускаем LiveData <> gatData
        selected.setValue(st);
        Log.e(this.getClass().getSimpleName()," "+ new Throwable().getStackTrace()[0].getMethodName() +"  "+ Thread.currentThread().getName()+" "+System.currentTimeMillis());
        Log.e(this.getClass().getSimpleName(),"  "+st);
    }

    // механизм возврата
    public LiveData<String> getData(){
        return selected;
    }
}
