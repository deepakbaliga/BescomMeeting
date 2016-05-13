package com.deepakbaliga.bescommeeting.model;

/**
 * Created by baliga on 13/05/16.
 */
public class Minute
{
    private String MeetingMinutesDetailDesc;

    private String MeetingMinutesDetailCode;

    private String MeetingCode;

    private String SubjectCode;

    public String getMeetingMinutesDetailDesc ()
    {
        return MeetingMinutesDetailDesc;
    }

    public void setMeetingMinutesDetailDesc (String MeetingMinutesDetailDesc)
    {
        this.MeetingMinutesDetailDesc = MeetingMinutesDetailDesc;
    }

    public String getMeetingMinutesDetailCode ()
    {
        return MeetingMinutesDetailCode;
    }

    public void setMeetingMinutesDetailCode (String MeetingMinutesDetailCode)
    {
        this.MeetingMinutesDetailCode = MeetingMinutesDetailCode;
    }

    public String getMeetingCode ()
    {
        return MeetingCode;
    }

    public void setMeetingCode (String MeetingCode)
    {
        this.MeetingCode = MeetingCode;
    }

    public String getSubjectCode ()
    {
        return SubjectCode;
    }

    public void setSubjectCode (String SubjectCode)
    {
        this.SubjectCode = SubjectCode;
    }


}

