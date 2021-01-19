package com.example.brawlstars_app;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

    //Кастомный адаптер для RecyclerView
    class CustomRecyclerViewAdapter extends RecyclerView.Adapter<CustomRecyclerViewAdapter.CustomViewHolder>{
        String[] str_name;
        int image_id;

        public class CustomViewHolder extends RecyclerView.ViewHolder{
            CardView cardView;
            TextView text;
            ImageView image;

            CustomViewHolder(View itemView){
                super(itemView);
                cardView = (CardView)itemView.findViewById(R.id.card_view);
                text = (TextView)itemView.findViewById(R.id.info_text);
                image = (ImageView)itemView.findViewById(R.id.info_image);
            }
        }

        CustomRecyclerViewAdapter(String[] str, int id){
            str_name = str;
            image_id = id;
        }

        @Override
        public int getItemCount(){
            return str_name.length;
        }

        @Override
        public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int i){
            View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.grid_layout_manager_item, viewGroup, false);
            CustomViewHolder customViewHolder = new CustomViewHolder(v);
            return customViewHolder;
        }

        @Override
        public void onBindViewHolder(CustomViewHolder customViewHolder, int i){
            customViewHolder.text.setText(str_name[i]);
            customViewHolder.image.setImageResource(image_id);
        }

        @Override
        public void onAttachedToRecyclerView(RecyclerView recyclerView){
            super.onAttachedToRecyclerView(recyclerView);
        }
    }
