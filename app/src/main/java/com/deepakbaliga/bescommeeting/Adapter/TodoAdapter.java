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
import com.deepakbaliga.bescommeeting.model.Todo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by baliga on 13/05/16.
 */
public class TodoAdapter extends RecyclerView.Adapter<TodoAdapter.TodoViewHolder>{

    private Context context;
    private List<Todo> todos = new ArrayList<>();
    private int lastPosition = -1;

    public TodoAdapter(Context context, List<Todo> todos) {
        this.context = context;
        this.todos = todos;
    }

    @Override
    public TodoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_todo, parent, false);
        return new TodoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TodoViewHolder holder, int position) {

        Todo todo = todos.get(position);

        holder.getDate().setText(todo.getFinishedBy());
        holder.getStatus().setText(todo.getStatus());
        holder.getTodo().setText(todo.getToDoDescription());

        String _date = todo.getFinishedBy();
        SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssz");


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


                Animation animation = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left);
                animation.setStartOffset(100);
                viewToAnimate.startAnimation(animation);




            lastPosition = position;
        }
    }

    @Override
    public int getItemCount() {
        return todos.size();
    }

    public class TodoViewHolder extends RecyclerView.ViewHolder{
        TextView todo, date, status;
        View view;

        public TodoViewHolder(View itemView) {
            super(itemView);
            view = itemView;

            todo = (TextView) itemView.findViewById(R.id.todo);
            status = (TextView) itemView.findViewById(R.id.todostatus);
            date = (TextView) itemView.findViewById(R.id.tododate);
        }

        public View getView() {
            return view;
        }

        public TextView getTodo() {
            return todo;
        }

        public void setTodo(TextView todo) {
            this.todo = todo;
        }

        public TextView getDate() {
            return date;
        }

        public void setDate(TextView date) {
            this.date = date;
        }

        public TextView getStatus() {
            return status;
        }

        public void setStatus(TextView status) {
            this.status = status;
        }
    }
}
