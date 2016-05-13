package com.deepakbaliga.bescommeeting.fragments;


import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import com.deepakbaliga.bescommeeting.Adapter.ChooseAgendaAdapter;
import com.deepakbaliga.bescommeeting.R;
import com.deepakbaliga.bescommeeting.callback.OnClickMeeting;
import com.deepakbaliga.bescommeeting.model.Agenda;
import com.deepakbaliga.bescommeeting.model.RecordDetail;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ChooseSubjectDialog extends DialogFragment {

    private RecordDetail recordDetail =  new RecordDetail();
    private List<Agenda> agendas =  new ArrayList<>();
    private ChooseAgendaAdapter adapter;

    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    public ChooseSubjectDialog() {
        // Required empty public constructor
    }

    public void setRecordDetail(RecordDetail recordDetail) {
        this.recordDetail = recordDetail;
    }

    public void setAgendas(List<Agenda> agendas) {
        this.agendas = agendas;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_choose_subject_dialog, container, false);


        linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(linearLayoutManager);

        adapter =  new ChooseAgendaAdapter(getActivity(), agendas, new OnClickMeeting() {
            @Override
            public void clicked(int position) {
                Log.e("Selected", "clicked: "+position );
            }
        });

        recyclerView.setAdapter(adapter);

        return view;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog = super.onCreateDialog(savedInstanceState);
        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);

        return dialog;
    }

    @Override
    public void onStart() {
        super.onStart();

        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        }
    }


}
