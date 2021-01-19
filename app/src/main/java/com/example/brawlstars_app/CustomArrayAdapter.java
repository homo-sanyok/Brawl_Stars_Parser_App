package com.example.brawlstars_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;

//Переопределение адаптера ArrayAdapter<String> для того, чтобы элементы ListView были некликабельны
public class CustomArrayAdapter extends ArrayAdapter<String> {

    public CustomArrayAdapter(@NonNull Context context, int resource, @NonNull String[] objects) {
        super(context, resource, objects);
    }

    @Override
    public boolean isEnabled(int position) {
        return false;
    }
}
