package com.deepakbaliga.bescommeeting.fragments;


import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
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

import com.blogspot.tonyatkins.recorder.activity.RecordSoundActivity;
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
    private int request_Code = 1001;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;

    public RecordDetail getRecordDetail() {
        return recordDetail;
    }


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

                recordDetail.setSubjectAgendaNumber(agendas.get(position).getSubjectAgendaNumber());
                recordDetail.setSubjectCode(agendas.get(position).getSubjectCode());
                recordDetail.setSubjectName(agendas.get(position).getSubjectName());

                Intent recordSoundIntent = new Intent(getActivity(), RecordSoundActivity.class);
                recordSoundIntent.putExtra(RecordSoundActivity.FILE_NAME_KEY, recordDetail.getMeetingSubject()+"-"+System.currentTimeMillis() / 1000L);

                getActivity().startActivityForResult(recordSoundIntent, request_Code);
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

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.e("File", requestCode+" "+resultCode);
        if (requestCode == request_Code) {
            if (resultCode == request_Code) {
                String returnedResult = data.getData().toString();
                Log.e("Files", returnedResult);
            }
        }
    }

}
