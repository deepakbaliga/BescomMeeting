package com.deepakbaliga.bescommeeting.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by baliga on 12/05/16.
 */
public class Meetings {

    @SerializedName("Meeting")
    private List<Meeting> meetings =  new ArrayList<>();

    public Meetings(List<Meeting> meetings) {
        this.meetings = meetings;
    }

    public Meetings() {
    }

    public List<Meeting> getMeetings() {
        return meetings;
    }

    public void setMeetings(List<Meeting> meetings) {
        this.meetings = meetings;
    }
}
