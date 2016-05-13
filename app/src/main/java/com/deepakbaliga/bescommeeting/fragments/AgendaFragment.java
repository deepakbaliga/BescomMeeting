package com.deepakbaliga.bescommeeting.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.deepakbaliga.bescommeeting.Adapter.AgendaAdapter;
import com.deepakbaliga.bescommeeting.Adapter.ParticipantsAdapter;
import com.deepakbaliga.bescommeeting.R;
import com.deepakbaliga.bescommeeting.callback.OnClickMeeting;
import com.deepakbaliga.bescommeeting.model.Agenda;
import com.deepakbaliga.bescommeeting.model.Participant;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class AgendaFragment extends Fragment {

    private List<Agenda> agendas =  new ArrayList<>();
    private AgendaAdapter adapter;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;

    public AgendaFragment() {
        // Required empty public constructor
    }

    public void setAgendas(List<Agenda> agendas) {
        this.agendas = agendas;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_agenda, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);
        linearLayoutManager =  new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);

        OnClickMeeting clickMeeting =  new OnClickMeeting() {
            @Override
            public void clicked(int position) {

            }
        };


        adapter =  new AgendaAdapter(getContext(), agendas,clickMeeting );
        recyclerView.setAdapter(adapter);
        return view;
    }


}
