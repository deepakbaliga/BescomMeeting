package com.deepakbaliga.bescommeeting.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.deepakbaliga.bescommeeting.R;
import com.deepakbaliga.bescommeeting.model.Participant;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ParticipantsFragment extends Fragment {


    private List<Participant> participants = new ArrayList<>();

    public ParticipantsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_participants, container, false);
    }

}
