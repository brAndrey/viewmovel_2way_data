package com.example.viewmovel_2way_data.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.viewmovel_2way_data.viewmodel.Fragment2ViewModel;
import com.example.viewmovel_2way_data.viewmodel.MainActivityViewModel;
import com.example.viewmovel_2.R;

public class Fragment2 extends Fragment {

    //String NAME = new Object(){}.getClass().getEnclosingMethod().getName();


    public class DetailFragment extends Fragment {

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_second, container, false);
        TextView textView = view.findViewById(R.id.textViewFragment2);
        TextView textView2 = view.findViewById(R.id.textViewFragmentST);

        // подписываемся ViewModel короткого пути
        MainActivityViewModel model = ViewModelProviders.of(getActivity()).get(MainActivityViewModel.class);
        model.getSelected().observe(this, intText -> {
            Log.e(this.getClass().getSimpleName(), " " + new Throwable().getStackTrace()[0].getMethodName() + "  " + Thread.currentThread().getName() + " " + System.currentTimeMillis());
            textView.setText(intText);
        });

        // подписываемся на ViewModel длинного пути
        Fragment2ViewModel model2 = ViewModelProviders.of(getActivity()).get(Fragment2ViewModel.class);
        model2.gatData().observe(this, st -> textView2.setText(st));

        return view;
    }
}
