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
import com.deepakbaliga.bescommeeting.model.Agenda;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by baliga on 14/05/16.
 */
public class ChooseAgendaAdapter extends RecyclerView.Adapter<ChooseAgendaAdapter.ChooseAgendaViewHolder> {

    private Context context;
    private List<Agenda> agendas =  new ArrayList<>();
    private OnClickMeeting  onClickMeeting;
    private int lastPosition = -1;

    public ChooseAgendaAdapter(Context context, List<Agenda> agendas, OnClickMeeting onClickMeeting) {
        this.context = context;
        this.agendas = agendas;
        this.onClickMeeting = onClickMeeting;
    }

    @Override
    public ChooseAgendaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_agenda_select, parent, false);
        return new ChooseAgendaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ChooseAgendaViewHolder holder, int position) {

        Agenda agenda =  agendas.get(position);

        holder.getCode().setText(agenda.getSubjectAgendaNumber());
        holder.getDescription().setText(agenda.getSubjectName());
        setAnimation(holder.getView(), position);

    }

    private void setAnimation(View viewToAnimate, int position)
    {
        // If the bound view wasn't previously displayed on screen, it's animated
        if (position > lastPosition)
        {

                Animation animation = AnimationUtils.loadAnimation(context, R.anim.slide_up);
                animation.setStartOffset(100);
                viewToAnimate.startAnimation(animation);




            lastPosition = position;
        }
    }

    @Override
    public int getItemCount() {
        return agendas.size();
    }

    public class ChooseAgendaViewHolder extends RecyclerView.ViewHolder{

        private View view;

        private TextView code, description;
        public ChooseAgendaViewHolder(View itemView) {
            super(itemView);
            view = itemView;

            description = (TextView) itemView.findViewById(R.id.subject);
            code = (TextView) itemView.findViewById(R.id.subjectid);

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

        public TextView getCode() {
            return code;
        }

        public void setCode(TextView code) {
            this.code = code;
        }

        public TextView getDescription() {
            return description;
        }

        public void setDescription(TextView description) {
            this.description = description;
        }
    }
}
