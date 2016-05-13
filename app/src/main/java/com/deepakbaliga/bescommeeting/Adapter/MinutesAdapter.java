package com.deepakbaliga.bescommeeting.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.deepakbaliga.bescommeeting.R;
import com.deepakbaliga.bescommeeting.model.Minute;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by baliga on 13/05/16.
 */
public class MinutesAdapter extends RecyclerView.Adapter<MinutesAdapter.MinutesViewHolder> {

    private Context context;
    private List<Minute> minutes = new ArrayList<>();

    public MinutesAdapter(Context context, List<Minute> minutes) {
        this.context = context;
        this.minutes = minutes;
    }

    @Override
    public MinutesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_minute, parent, false);

        return new MinutesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MinutesViewHolder holder, int position) {

        holder.getMinute().setText(Html.fromHtml(minutes.get(position).getMeetingMinutesDetailDesc().trim()));
    }

    @Override
    public int getItemCount() {
        return minutes.size();
    }

    public class MinutesViewHolder extends RecyclerView.ViewHolder{

        private TextView minute;

        public MinutesViewHolder(View itemView) {
            super(itemView);
            minute = (TextView) itemView.findViewById(R.id.minute);
        }

        public TextView getMinute() {
            return minute;
        }

        public void setMinute(TextView minute) {
            this.minute = minute;
        }
    }
}
