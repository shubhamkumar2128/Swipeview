package com.example.swipeview;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class One extends Fragment {
    String data[] = new String[]{"manas", "matru", "komal", "pikachu", "monkey", "farah", "mohit", "radhya"};
    int images[] = new int[]{R.drawable.ic_android_black_24dp,R.drawable.ic_android_black_24dp,R.drawable.ic_android_black_24dp,R.drawable.ic_android_black_24dp,R.drawable.ic_android_black_24dp,R.drawable.ic_android_black_24dp,R.drawable.ic_android_black_24dp,R.drawable.ic_android_black_24dp,};
    RecyclerView recyclerView;

    public One() {
        // Required empty public constructor
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d("taggg", "onSaveInstanceState()");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_one, container, false);
        recyclerView = v.findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(new MyAdapter(images, data));
        recyclerView.setHasFixedSize(true);
        return v;

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d("taggg", " onAttach()");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("taggg", "Oncreate()");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("taggg", "onDestroy() ");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d("taggg", "nDestroyView()");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d("taggg", " onPause()");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("taggg", "onResume()");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d("taggg", "onActivityCreated");
    }

}
