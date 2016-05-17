package com.deepakbaliga.bescommeeting.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.deepakbaliga.bescommeeting.R;
import com.deepakbaliga.bescommeeting.callback.OnClickMeeting;
import com.deepakbaliga.bescommeeting.model.RecordDetail;

import io.realm.RealmResults;

/**
 * Created by baliga on 14/05/16.
 */
public class RecordingsAdapter extends RecyclerView.Adapter<RecordingsAdapter.RecordingViewHolder> {

    private Context context;
    private RealmResults<RecordDetail> recordings;
    private OnClickMeeting onClickMeeting;
    private int lastPoisition = -1;

    public RecordingsAdapter(Context context, RealmResults<RecordDetail> recordings, OnClickMeeting onClickMeeting) {
        this.context = context;
        this.recordings = recordings;
        this.onClickMeeting = onClickMeeting;
    }

    private void setAnimation(View viewToAnimate, int position)
    {
        // If the bound view wasn't previously displayed on screen, it's animated
        if (position > lastPoisition)
        {

                Animation animation = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left);
                animation.setStartOffset(200);
                viewToAnimate.startAnimation(animation);

            lastPoisition = position;
        }
    }
    @Override
    public RecordingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
     final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recording, parent, false);
        return new RecordingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecordingViewHolder holder, int position) {

        RecordDetail detail = recordings.get(position);

        holder.getName().setText(detail.getMeetingSubject());
        holder.getSubject().setText(detail.getSubjectName());
        holder.getSubjectNumber().setText(detail.getSubjectAgendaNumber());

        setAnimation(holder.getView(),position);
    }

    @Override
    public int getItemCount() {
        return recordings.size();
    }

    public class RecordingViewHolder extends RecyclerView.ViewHolder{

        private View view;
        private TextView name, subject, subjectNumber;
        public RecordingViewHolder(View itemView) {
            super(itemView);

            view = itemView;

            name = (TextView) itemView.findViewById(R.id.meetingname);
            subject = (TextView) itemView.findViewById(R.id.subject);
            subjectNumber = (TextView) itemView.findViewById(R.id.subjectid);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onClickMeeting.clicked(getLayoutPosition());
                }
            });
        }

        public View getView() {
            return view;
        }

        public void setView(View view) {
            this.view = view;
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

        public TextView getSubjectNumber() {
            return subjectNumber;
        }

        public void setSubjectNumber(TextView subjectNumber) {
            this.subjectNumber = subjectNumber;
        }
    }
}
