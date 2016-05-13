package com.deepakbaliga.bescommeeting.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.deepakbaliga.bescommeeting.R;
import com.deepakbaliga.bescommeeting.model.Participant;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by baliga on 12/05/16.
 */
public class ParticipantsAdapter extends RecyclerView.Adapter<ParticipantsAdapter.ParticipantViewHolder> {

    private Context context;
    private List<Participant> participants =  new ArrayList<>();
    private int lastPosition = -1;

    public ParticipantsAdapter(Context context, List<Participant> participants) {
        this.context = context;
        this.participants = participants;
    }

    @Override
    public ParticipantViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_participant, parent, false);
        return new ParticipantViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ParticipantViewHolder holder, int position) {
        Participant participant =  participants.get(position);

        holder.getUsername().setText(participant.getUserName());

        String mandatory = participant.getIsMandatoryParticipant();
        if(mandatory.equals("Y")){
            holder.getMandatory().setText("Mandatory Participant");
        }else {
            holder.getMandatory().setText("Participant not Mandatory");
        }

        String attendance = participant.getIsPresent();


        if(attendance.equals("Y")){
            holder.getAttendance().setText("Present");
        }else {
            holder.getAttendance().setText("Absent");
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
        return participants.size();
    }

    public class ParticipantViewHolder extends RecyclerView.ViewHolder{

        private TextView username, attendance, mandatory;
        private View view;
        public ParticipantViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            username = (TextView) itemView.findViewById(R.id.username);
            attendance = (TextView) itemView.findViewById(R.id.attendance);
            mandatory = (TextView) itemView.findViewById(R.id.mandatory);
        }

        public View getView() {
            return view;
        }

        public TextView getUsername() {
            return username;
        }

        public void setUsername(TextView username) {
            this.username = username;
        }

        public TextView getAttendance() {
            return attendance;
        }

        public void setAttendance(TextView attendance) {
            this.attendance = attendance;
        }

        public TextView getMandatory() {
            return mandatory;
        }

        public void setMandatory(TextView mandatory) {
            this.mandatory = mandatory;
        }
    }
}
