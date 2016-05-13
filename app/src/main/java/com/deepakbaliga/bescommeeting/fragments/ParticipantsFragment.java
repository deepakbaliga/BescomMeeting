package com.deepakbaliga.bescommeeting.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.deepakbaliga.bescommeeting.Adapter.ParticipantsAdapter;
import com.deepakbaliga.bescommeeting.R;
import com.deepakbaliga.bescommeeting.model.Participant;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ParticipantsFragment extends Fragment {


    private List<Participant> participants = new ArrayList<>();
    private ParticipantsAdapter adapter;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;

    public ParticipantsFragment() {
        // Required empty public constructor
    }

    public void setParticipants(List<Participant> participants) {
        this.participants = participants;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_participants, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);
        linearLayoutManager =  new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);

        adapter =  new ParticipantsAdapter(getContext(), participants);
        recyclerView.setAdapter(adapter);
        return view;
    }

}
