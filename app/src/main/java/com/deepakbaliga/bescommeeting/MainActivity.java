package com.deepakbaliga.bescommeeting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.animation.OvershootInterpolator;
import android.widget.Toast;

import com.deepakbaliga.bescommeeting.Adapter.MeetingsAdapter;
import com.deepakbaliga.bescommeeting.callback.MeetingsCallback;
import com.deepakbaliga.bescommeeting.model.Meeting;
import com.deepakbaliga.bescommeeting.retrofit.APIAdapter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jp.wasabeef.recyclerview.animators.FadeInAnimator;
import jp.wasabeef.recyclerview.animators.SlideInLeftAnimator;
import jp.wasabeef.recyclerview.animators.SlideInUpAnimator;
import si.virag.fuzzydateformatter.FuzzyDateTimeFormatter;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private GridLayoutManager gridLayoutManager;
    private APIAdapter apiAdapter;
    private MeetingsAdapter adapter;
    private List<Meeting> meetings =  new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        apiAdapter =  new APIAdapter();
        linearLayoutManager =  new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setItemAnimator(new SlideInUpAnimator(new OvershootInterpolator(1f)));


        loadData();

    }

    private void loadData(){
        apiAdapter.getMeetings(new MeetingsCallback() {
            @Override
            public void onSuccess(List<Meeting> meetings) {
                adapter =  new MeetingsAdapter(MainActivity.this, meetings);
                recyclerView.setAdapter(adapter);



            }

            @Override
            public void onFailed(String error) {
                Toast.makeText(MainActivity.this, error, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
