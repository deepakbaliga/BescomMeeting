package com.deepakbaliga.bescommeeting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.deepakbaliga.bescommeeting.model.RecordDetail;

import io.realm.Realm;
import io.realm.RealmResults;


public class RecordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);

        Realm myRealm = Realm.getDefaultInstance();

        RealmResults<RecordDetail> recordings =
                myRealm.where(RecordDetail.class).findAll();

        for (RecordDetail recordDetail : recordings){
            Log.e("DB", recordDetail.getMeetingSubject() );
        }


    }
}
