package com.deepakbaliga.bescommeeting;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import android.widget.TextView;
import android.widget.Toast;

import com.deepakbaliga.bescommeeting.Adapter.MeetingsAdapter;
import com.deepakbaliga.bescommeeting.callback.DetailsCallback;
import com.deepakbaliga.bescommeeting.callback.MeetingsCallback;
import com.deepakbaliga.bescommeeting.callback.OnClickMeeting;
import com.deepakbaliga.bescommeeting.model.Meeting;
import com.deepakbaliga.bescommeeting.model.MeetingDetail;
import com.deepakbaliga.bescommeeting.retrofit.APIAdapter;
import com.github.glomadrian.loadingballs.BallView;

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
    private BallView ballView;
    private OnClickMeeting onClickMeeting;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Meetings");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        apiAdapter =  new APIAdapter();
        linearLayoutManager =  new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setItemAnimator(new SlideInUpAnimator(new OvershootInterpolator(1f)));
        ballView = (BallView) findViewById(R.id.progress);

        onClickMeeting = new OnClickMeeting() {
            @Override
            public void clicked(int position) {
                Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
                intent.putExtra("id", meetings.get(position).getMeetingCode());
                startActivity(intent);
            }
        };

        loadData();

    }

    private void loadData(){
        apiAdapter.getMeetings(new MeetingsCallback() {
            @Override
            public void onSuccess(List<Meeting> _meetings) {
                ballView.stop();
                ballView.setVisibility(View.GONE);

                meetings = _meetings;
                adapter =  new MeetingsAdapter(MainActivity.this, meetings, onClickMeeting);
                recyclerView.setAdapter(adapter);


            }

            @Override
            public void onFailed(String error) {
                Toast.makeText(MainActivity.this, error, Toast.LENGTH_SHORT).show();
                ballView.stop();
                ballView.setVisibility(View.GONE);
            }
        });
    }


}
