package com.deepakbaliga.bescommeeting.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.deepakbaliga.bescommeeting.Adapter.MinutesAdapter;
import com.deepakbaliga.bescommeeting.Adapter.TodoAdapter;
import com.deepakbaliga.bescommeeting.R;
import com.deepakbaliga.bescommeeting.callback.OnClickMeeting;
import com.deepakbaliga.bescommeeting.model.Minute;
import com.deepakbaliga.bescommeeting.model.Todo;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class TodoFragment extends Fragment {

    private List<Todo> todos =  new ArrayList<>();
    private TodoAdapter adapter;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;


    public TodoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_todo, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);
        linearLayoutManager =  new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);

        TextView notfound = (TextView) view.findViewById(R.id.notfound);

        if(todos.size()==0){
            notfound.setVisibility(View.VISIBLE);
        }

        OnClickMeeting clickMeeting =  new OnClickMeeting() {
            @Override
            public void clicked(int position) {

            }
        };


        adapter =  new TodoAdapter(getContext(), todos);
        recyclerView.setAdapter(adapter);
        return view;
    }

    public void setTodos(List<Todo> todos) {
        this.todos = todos;
    }
}


