package com.deepakbaliga.bescommeeting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.deepakbaliga.bescommeeting.Adapter.RecordingsAdapter;
import com.deepakbaliga.bescommeeting.callback.OnClickMeeting;
import com.deepakbaliga.bescommeeting.fragments.PlaybackDialog;
import com.deepakbaliga.bescommeeting.model.RecordDetail;

import io.realm.Realm;
import io.realm.RealmResults;


public class RecordActivity extends AppCompatActivity {

    private LinearLayoutManager linearLayoutManager;
    private RecyclerView recyclerView;
    private RecordingsAdapter adapter;

    private RealmResults<RecordDetail> recordings;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Recordings");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        linearLayoutManager =  new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        Realm myRealm = Realm.getDefaultInstance();

     recordings = myRealm.where(RecordDetail.class).findAll();

        if(recordings.size()>0){
            TextView nothing = (TextView) findViewById(R.id.nothing);
            nothing.setVisibility(View.GONE);
        }


        OnClickMeeting clickMeeting =  new OnClickMeeting() {
            @Override
            public void clicked(int position) {


                PlaybackDialog playbackDialog =  new PlaybackDialog();
                playbackDialog.setFile(recordings.get(position).getFile());

                playbackDialog.show(getSupportFragmentManager(), "PLAYBACK");

            }
        };



        adapter = new RecordingsAdapter(this, recordings,clickMeeting);
        recyclerView.setAdapter(adapter);



    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
