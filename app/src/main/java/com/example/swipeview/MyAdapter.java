package com.example.swipeview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

class MyAdapter extends RecyclerView.Adapter<MyAdapter.Holder> {

    String data[];
    int images[];

    public MyAdapter( int[] images,String[] data) {
        this.data = data;
        this.images = images;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.singleview, null, false);
        return new Holder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int i) {
        holder.imageView.setImageResource(images[i]);
        holder.textView.setText(data[i]);
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    class Holder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView;

        public Holder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.txtview);
            imageView = itemView.findViewById(R.id.imgview);
        }
    }
}
