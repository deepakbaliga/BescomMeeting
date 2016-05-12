package com.deepakbaliga.bescommeeting.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by baliga on 12/05/16.
 */
public class MeetingDetail {

    @SerializedName("Meeting")
    private Meeting meeting = new Meeting();

    @SerializedName("MeetingParticipant")
    private List<Participant> participants = new ArrayList<>();

    @SerializedName("Agenda")
    private List<Agenda> agendas = new ArrayList<>();

    public MeetingDetail() {
    }

    public Meeting getMeeting() {
        return meeting;
    }

    public void setMeeting(Meeting meeting) {
        this.meeting = meeting;
    }

    public List<Participant> getParticipants() {
        return participants;
    }

    public void setParticipants(List<Participant> participants) {
        this.participants = participants;
    }

    public List<Agenda> getAgendas() {
        return agendas;
    }

    public void setAgendas(List<Agenda> agendas) {
        this.agendas = agendas;
    }
}
