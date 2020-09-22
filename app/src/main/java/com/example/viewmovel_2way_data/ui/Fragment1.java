package com.example.viewmovel_2way_data.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.viewmovel_2way_data.viewmodel.MainActivityViewModel;
import com.example.viewmovel_2way_data.viewmodel.Fragment1ViewModel;
import com.example.viewmovel_2.R;

public class Fragment1 extends Fragment {

    private MainActivityViewModel model;

    private Fragment1ViewModel modelThis;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_first, container, false);

        Button button = view.findViewById(R.id.buttonFragment1);
        EditText editText = view.findViewById(R.id.editTextGrams);
        EditText editText2 = view.findViewById(R.id.editTextSped);

        // инициализация ViewModel - ей
        model = ViewModelProviders.of(getActivity()).get(MainActivityViewModel.class);
        modelThis = ViewModelProviders.of(getActivity()).get(Fragment1ViewModel.class);

        button.setOnClickListener(st -> {
            Log.e(this.getClass().getSimpleName(), " " + new Throwable().getStackTrace()[0].getMethodName() + "  " + Thread.currentThread().getName() + " " + System.currentTimeMillis());
            // передача значения в короткий путь без репозитория
            model.select(editText.getText().toString());
            // перезача значения в длинный путь через репозиторий
            modelThis.SetData(editText2.getText().toString());
        });
        return view;


    }
}
