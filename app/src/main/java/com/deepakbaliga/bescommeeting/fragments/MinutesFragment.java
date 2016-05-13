package com.deepakbaliga.bescommeeting.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.deepakbaliga.bescommeeting.Adapter.AgendaAdapter;
import com.deepakbaliga.bescommeeting.Adapter.MinutesAdapter;
import com.deepakbaliga.bescommeeting.R;
import com.deepakbaliga.bescommeeting.callback.OnClickMeeting;
import com.deepakbaliga.bescommeeting.model.Agenda;
import com.deepakbaliga.bescommeeting.model.Minute;

import java.util.ArrayList;
import java.util.List;


public class MinutesFragment extends Fragment {


    private List<Minute> minutes =  new ArrayList<>();
    private MinutesAdapter adapter;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;

    public MinutesFragment() {
        // Required empty public constructor
    }

    public void setMinutes(List<Minute> minutes) {
        this.minutes = minutes;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_minutes, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);
        linearLayoutManager =  new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);

        TextView notfound = (TextView) view.findViewById(R.id.notfound);

        if(minutes.size()==0){
            notfound.setVisibility(View.VISIBLE);
        }

        OnClickMeeting clickMeeting =  new OnClickMeeting() {
            @Override
            public void clicked(int position) {

            }
        };


        adapter =  new MinutesAdapter(getContext(), minutes);
        recyclerView.setAdapter(adapter);
        return view;
    }


}
