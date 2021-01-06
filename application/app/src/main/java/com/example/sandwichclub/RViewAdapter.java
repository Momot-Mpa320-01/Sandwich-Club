package com.example.sandwichclub;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RViewAdapter extends RecyclerView.Adapter<RViewAdapter.ViewHolder> {
    private ArrayList<Cat> cats;

    RViewAdapter(ArrayList<Cat> cats) {
        this.cats=cats;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list, parent, false);
        return new ViewHolder(view);
    }

    @NonNull
    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.name.setText(cats.get(position).name);
        holder.age.setText(String.valueOf(cats.get(position).age));
        holder.color.setBackgroundColor(cats.get(position).color);
        holder.age.setVisibility(View.GONE);
        holder.color.setVisibility(View.GONE);
    }
    @Override
    public int getItemCount() { return cats.size(); }
    class ViewHolder extends RecyclerView.ViewHolder {
        final TextView name;
        final TextView age;
        final View color;
        private String NAME = "NAME";
        private String AGE = "AGE";
        private String COLOR = "COLOR";

        ViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.name);
            age = view.findViewById(R.id.age);
            color = view.findViewById(R.id.colorCat);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Context context = view.getContext();
                    Intent intent = new Intent(context, DetailActivity.class);
                    intent.putExtra(NAME, name.getText());
                    intent.putExtra(AGE, age.getText());
                    ColorDrawable colorDrawable =(ColorDrawable) color.getBackground();
                    intent.putExtra(COLOR,  colorDrawable.getColor());
                    context.startActivity(intent);
                }
            });

        }
    }


}
