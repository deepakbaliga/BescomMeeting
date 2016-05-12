package com.deepakbaliga.bescommeeting.Adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.deepakbaliga.bescommeeting.R;
import com.deepakbaliga.bescommeeting.model.Meeting;

import org.ocpsoft.pretty.time.PrettyTime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by baliga on 12/05/16.
 */
public class MeetingsAdapter extends RecyclerView.Adapter<MeetingsAdapter.MeetingViewHolder> {

    private Context context;
    private List<Meeting> meetings =  new ArrayList<>();
    private int lastPosition = -1;

    public MeetingsAdapter(Context context, List<Meeting> meetings) {
        this.context = context;
        this.meetings = meetings;
    }

    @Override
    public MeetingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_meeting, parent, false);
        return new MeetingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MeetingViewHolder holder, int position) {

        Meeting meeting =  meetings.get(position);

        holder.getName().setText(meeting.getMeetingName());
        holder.getSubject().setText(meeting.getSubject());
        holder.getDate().setText(meeting.getMeetingTime());
        holder.getVenue().setText(meeting.getVenue());
        holder.getNumber().setText(meeting.getMeetingNumber());
        holder.getStatus().setText(meeting.getMeetingStatusName());



        String _date = meeting.getMeetingTime();
        _date = _date.replace("T", " ");
        SimpleDateFormat dt = new SimpleDateFormat("yyyyy-mm-dd hh:mm:ss");


        Date date = new Date();
        try {
            date = dt.parse(_date);

            SimpleDateFormat sdf = new SimpleDateFormat("E dd.MM.yyyy 'at' hh:mm aa");
            String time = sdf.format(date);

            holder.getDate().setText(time);

        } catch (ParseException e) {
            holder.getDate().setText(date+"");
            e.printStackTrace();
        }

        setAnimation(holder.getView(), position);

    }

    private void setAnimation(View viewToAnimate, int position)
    {
        // If the bound view wasn't previously displayed on screen, it's animated
        if (position > lastPosition)
        {
            if(position%2==0){

                Animation animation = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left);
                animation.setStartOffset(100);
                viewToAnimate.startAnimation(animation);

            }else {
                Animation animation = AnimationUtils.loadAnimation(context, R.anim.slide_in_right);
                animation.setStartOffset(100);
                viewToAnimate.startAnimation(animation);

            }


            lastPosition = position;
        }
    }

    @Override
    public int getItemCount() {
        return meetings.size();
    }

    public class MeetingViewHolder extends RecyclerView.ViewHolder{

        private TextView name, subject, number, venue, date, status;
        private View view;

        public MeetingViewHolder(View itemView) {
            super(itemView);
            view = itemView;

            name = (TextView) itemView.findViewById(R.id.meetingname);
            subject = (TextView) itemView.findViewById(R.id.meetingsubject);
            number = (TextView) itemView.findViewById(R.id.meetingnumber);
            venue = (TextView) itemView.findViewById(R.id.meetingvenue);
            date = (TextView) itemView.findViewById(R.id.meetingdate);
            status = (TextView) itemView.findViewById(R.id.status);
        }


        public View getView() {
            return view;
        }

        public void setView(View view) {
            this.view = view;
        }

        public TextView getStatus() {
            return status;
        }

        public void setStatus(TextView status) {
            this.status = status;
        }

        public TextView getName() {
            return name;
        }

        public void setName(TextView name) {
            this.name = name;
        }

        public TextView getSubject() {
            return subject;
        }

        public void setSubject(TextView subject) {
            this.subject = subject;
        }

        public TextView getNumber() {
            return number;
        }

        public void setNumber(TextView number) {
            this.number = number;
        }

        public TextView getVenue() {
            return venue;
        }

        public void setVenue(TextView venue) {
            this.venue = venue;
        }

        public TextView getDate() {
            return date;
        }

        public void setDate(TextView date) {
            this.date = date;
        }
    }
}
