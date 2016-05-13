package com.deepakbaliga.bescommeeting;

import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.blogspot.tonyatkins.recorder.activity.RecordSoundActivity;
import com.deepakbaliga.bescommeeting.Adapter.ViewPagerAdapter;
import com.deepakbaliga.bescommeeting.callback.DetailsCallback;
import com.deepakbaliga.bescommeeting.fragments.AgendaFragment;
import com.deepakbaliga.bescommeeting.fragments.ChooseSubjectDialog;
import com.deepakbaliga.bescommeeting.fragments.MinutesFragment;
import com.deepakbaliga.bescommeeting.fragments.ParticipantsFragment;
import com.deepakbaliga.bescommeeting.fragments.TodoFragment;
import com.deepakbaliga.bescommeeting.model.Meeting;
import com.deepakbaliga.bescommeeting.model.MeetingDetail;
import com.deepakbaliga.bescommeeting.model.RecordDetail;
import com.deepakbaliga.bescommeeting.retrofit.APIAdapter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import io.realm.Realm;

public class DetailsActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private CollapsingToolbarLayout collapsingToolbarLayout;
    private CoordinatorLayout coordinatorLayout;
    private ViewPager viewPager;
    private RelativeLayout relativeLayout;
    private ProgressBar progressBar;
    private int id;
    private APIAdapter apiAdapter;
    private MeetingDetail detail;
    private int request_Code = 1001;
    private ChooseSubjectDialog dialog =  new ChooseSubjectDialog();

    private Realm myRealm ;

    private TextView name, subject, number, venue, date, status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        loadViews();
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        apiAdapter = new APIAdapter();
        myRealm = Realm.getDefaultInstance();

        if(getIntent().getExtras()!=null){
            id = Integer.parseInt(getIntent().getExtras().getString("id"));
            loadDetail(id);
        }

    }

    private void loadDetail(int _id){

            apiAdapter.getMeetingDetails(_id, new DetailsCallback() {
                @Override
                public void onSuccess(MeetingDetail _detail) {
                    detail = _detail;

                    setMeetingDetail(detail.getMeeting());
                    setUpComponents();
                    relativeLayout.setVisibility(View.GONE);
                    progressBar.setVisibility(View.GONE);

                }

                @Override
                public void onFailed(String error) {
                    Toast.makeText(DetailsActivity.this, error, Toast.LENGTH_SHORT).show();

                }
            });
    }

    private void loadViews(){

        name = (TextView) findViewById(R.id.meetingname);
        subject = (TextView) findViewById(R.id.meetingsubject);
        number = (TextView) findViewById(R.id.meetingnumber);
        venue = (TextView) findViewById(R.id.meetingvenue);
        date = (TextView) findViewById(R.id.meetingdate);
        status = (TextView) findViewById(R.id.status);
        progressBar = (ProgressBar) findViewById(R.id.progress);
        relativeLayout = (RelativeLayout) findViewById(R.id.relative_layout);
        relativeLayout.setVisibility(View.VISIBLE);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinatorlayout);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
    }

    private void setMeetingDetail(Meeting meeting) {


        name.setText(meeting.getMeetingName());
        subject.setText(meeting.getSubject());
        date.setText(meeting.getMeetingTime());
        venue.setText(meeting.getVenue());
        number.setText(meeting.getMeetingNumber());
        status.setText(meeting.getMeetingStatusName());


        String _date = meeting.getMeetingTime();
        SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssz");


        Date date = new Date();
        try {
            date = dt.parse(_date);

            SimpleDateFormat sdf = new SimpleDateFormat("E dd.MM.yyyy 'at' hh:mm aa");
            String time = sdf.format(date);

            this.date.setText(time);

        } catch (ParseException e) {
            this.date.setText(date + "");
            e.printStackTrace();

        }
    }



    private void setUpComponents() {

        setupViewPager(viewPager);

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                viewPager.setCurrentItem(tab.getPosition());

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


    }

    private void setupViewPager(ViewPager viewPager) {

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        ParticipantsFragment participantsFragment =  new ParticipantsFragment();
        participantsFragment.setParticipants(detail.getParticipants());
        adapter.addFrag(participantsFragment, "Participants");

        AgendaFragment agendaFragment =  new AgendaFragment();
        agendaFragment.setAgendas(detail.getAgendas());
        adapter.addFrag(agendaFragment, "Agenda");

        MinutesFragment minutesFragment =  new MinutesFragment();
        minutesFragment.setMinutes(detail.getMinutes());
        adapter.addFrag(minutesFragment, "Minutes");

        TodoFragment todoFragment =  new TodoFragment();
        todoFragment.setTodos(detail.getTodos());
        adapter.addFrag(todoFragment, "TODO");


        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);


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
    public void conductMeeting(View view){


        dialog.setAgendas(detail.getAgendas());
        RecordDetail recordDetail =  new RecordDetail();
        recordDetail.setMeetingCode(detail.getMeeting().getMeetingCode());
        recordDetail.setMeetingSubject(detail.getMeeting().getSubject());

        dialog.setRecordDetail(recordDetail);

        FragmentManager fm = getSupportFragmentManager();
        dialog.show(fm, "select");

    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == request_Code) {
            if (resultCode == RESULT_OK) {
                String returnedResult = data.getData().toString();
                Log.e("Record", returnedResult);
                Log.e("Record", dialog.getRecordDetail().getSubjectCode());
                Log.e("Record", dialog.getRecordDetail().getSubjectAgendaNumber());
                Log.e("Record", dialog.getRecordDetail().getSubjectName());
                Log.e("Record", dialog.getRecordDetail().getMeetingCode());
                Log.e("Record", dialog.getRecordDetail().getMeetingSubject());

                myRealm.beginTransaction();
                RecordDetail recordDetail = myRealm.createObject(RecordDetail.class);
                recordDetail.setSubjectName(dialog.getRecordDetail().getSubjectName());
                recordDetail.setSubjectCode(dialog.getRecordDetail().getSubjectCode());
                recordDetail.setSubjectAgendaNumber(dialog.getRecordDetail().getSubjectAgendaNumber());
                recordDetail.setMeetingCode(dialog.getRecordDetail().getMeetingCode());
                recordDetail.setMeetingSubject(dialog.getRecordDetail().getMeetingSubject());
                recordDetail.setFile(returnedResult);
                myRealm.commitTransaction();

            }
        }
    }

}
