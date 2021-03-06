package com.deepakbaliga.bescommeeting.model;

import java.io.Serializable;

import javax.security.auth.Subject;

import io.realm.RealmObject;

/**
 * Created by baliga on 13/05/16.
 */
public class RecordDetail extends RealmObject {

    private String subjectAgendaNumber;
    private String SubjectCode;
    private String SubjectName;
    private String file;
    private String meetingCode;
    private String meetingSubject;

    public RecordDetail() {
    }

    public String getSubjectAgendaNumber() {
        return subjectAgendaNumber;
    }

    public void setSubjectAgendaNumber(String subjectAgendaNumber) {
        this.subjectAgendaNumber = subjectAgendaNumber;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getSubjectCode() {
        return SubjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        SubjectCode = subjectCode;
    }

    public String getSubjectName() {
        return SubjectName;
    }

    public void setSubjectName(String subjectName) {
        SubjectName = subjectName;
    }

    public String getMeetingCode() {
        return meetingCode;
    }

    public void setMeetingCode(String meetingCode) {
        this.meetingCode = meetingCode;
    }

    public String getMeetingSubject() {
        return meetingSubject;
    }

    public void setMeetingSubject(String meetingSubject) {
        this.meetingSubject = meetingSubject;
    }
}
