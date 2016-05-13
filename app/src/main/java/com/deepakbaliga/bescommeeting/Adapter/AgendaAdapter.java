package com.deepakbaliga.bescommeeting.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
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
 * Created by baliga on 13/05/16.
 */
public class AgendaAdapter extends RecyclerView.Adapter<AgendaAdapter.AgendaViewHolder> {

    private Context context;
    private List<Agenda> agendas =  new ArrayList<>();
    private OnClickMeeting onClickMeeting;
    private int lastPosition = -1;

    public AgendaAdapter(Context context, List<Agenda> agendas, OnClickMeeting onClickMeeting) {
        this.context = context;
        this.agendas = agendas;
        this.onClickMeeting = onClickMeeting;
    }

    @Override
    public AgendaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_agenda, parent, false);
        return new AgendaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AgendaViewHolder holder, int position) {

        Agenda agenda =  agendas.get(position);
        holder.getSubject().setText(agenda.getSubjectName());
        holder.getDescription().setText(Html.fromHtml(agenda.getSubjectDesc().trim()));
        holder.getId().setText(agenda.getSubjectAgendaNumber());
        holder.getApproval().setText(agenda.getApprovalStatusDesc());
        holder.getDepartment().setText(agenda.getDepartmentName());
        holder.getCategory().setText(agenda.getSubjectCategoryName());

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
        return agendas.size();
    }

    public class AgendaViewHolder extends RecyclerView.ViewHolder{

        private TextView subject, category, id, description, approval, department;
        private View view;

        public AgendaViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            subject = (TextView) itemView.findViewById(R.id.subject);
            category = (TextView) itemView.findViewById(R.id.subjectcategory);
            id = (TextView) itemView.findViewById(R.id.subjectid);
            description = (TextView) itemView.findViewById(R.id.subjectdescription);
            approval = (TextView) itemView.findViewById(R.id.subjectapproval);
            department = (TextView) itemView.findViewById(R.id.subjectdepartment);

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

        public TextView getSubject() {
            return subject;
        }

        public void setSubject(TextView subject) {
            this.subject = subject;
        }

        public TextView getCategory() {
            return category;
        }

        public void setCategory(TextView category) {
            this.category = category;
        }

        public TextView getId() {
            return id;
        }

        public void setId(TextView id) {
            this.id = id;
        }

        public TextView getDescription() {
            return description;
        }

        public void setDescription(TextView description) {
            this.description = description;
        }

        public TextView getApproval() {
            return approval;
        }

        public void setApproval(TextView approval) {
            this.approval = approval;
        }

        public TextView getDepartment() {
            return department;
        }

        public void setDepartment(TextView department) {
            this.department = department;
        }
    }
}
