package com.deepakbaliga.bescommeeting;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.deepakbaliga.bescommeeting.Adapter.ViewPagerAdapter;
import com.deepakbaliga.bescommeeting.callback.DetailsCallback;
import com.deepakbaliga.bescommeeting.fragments.AgendaFragment;
import com.deepakbaliga.bescommeeting.fragments.MinutesFragment;
import com.deepakbaliga.bescommeeting.fragments.ParticipantsFragment;
import com.deepakbaliga.bescommeeting.fragments.TodoFragment;
import com.deepakbaliga.bescommeeting.model.Meeting;
import com.deepakbaliga.bescommeeting.model.MeetingDetail;
import com.deepakbaliga.bescommeeting.retrofit.APIAdapter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DetailsActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private CollapsingToolbarLayout collapsingToolbarLayout;
    private CoordinatorLayout coordinatorLayout;
    private ViewPager viewPager;

    private int id;
    private APIAdapter apiAdapter;
    private MeetingDetail detail;

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

        adapter.addFrag(new ParticipantsFragment(), "Participants");
        adapter.addFrag(new AgendaFragment(), "Agenda");
        adapter.addFrag(new MinutesFragment(), "Minutes");
        adapter.addFrag(new TodoFragment(), "TODO");
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

}
