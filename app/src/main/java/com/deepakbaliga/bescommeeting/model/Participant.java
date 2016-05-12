package com.deepakbaliga.bescommeeting.model;

/**
 * Created by baliga on 12/05/16.
 */
public class Participant
{
    private String ParticipantCode;

    private String MeetingCode;

    private String IsMandatoryParticipant;

    private String UserName;

    private String IsManageUser;

    private String MeetingParticipantCode;

    private String IsPresent;

    private String IsOptionalParticipant;

    public String getParticipantCode ()
    {
        return ParticipantCode;
    }

    public void setParticipantCode (String ParticipantCode)
    {
        this.ParticipantCode = ParticipantCode;
    }

    public String getMeetingCode ()
    {
        return MeetingCode;
    }

    public void setMeetingCode (String MeetingCode)
    {
        this.MeetingCode = MeetingCode;
    }

    public String getIsMandatoryParticipant ()
    {
        return IsMandatoryParticipant;
    }

    public void setIsMandatoryParticipant (String IsMandatoryParticipant)
    {
        this.IsMandatoryParticipant = IsMandatoryParticipant;
    }

    public String getUserName ()
    {
        return UserName;
    }

    public void setUserName (String UserName)
    {
        this.UserName = UserName;
    }

    public String getIsManageUser ()
    {
        return IsManageUser;
    }

    public void setIsManageUser (String IsManageUser)
    {
        this.IsManageUser = IsManageUser;
    }

    public String getMeetingParticipantCode ()
    {
        return MeetingParticipantCode;
    }

    public void setMeetingParticipantCode (String MeetingParticipantCode)
    {
        this.MeetingParticipantCode = MeetingParticipantCode;
    }

    public String getIsPresent ()
    {
        return IsPresent;
    }

    public void setIsPresent (String IsPresent)
    {
        this.IsPresent = IsPresent;
    }

    public String getIsOptionalParticipant ()
    {
        return IsOptionalParticipant;
    }

    public void setIsOptionalParticipant (String IsOptionalParticipant)
    {
        this.IsOptionalParticipant = IsOptionalParticipant;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [ParticipantCode = "+ParticipantCode+", MeetingCode = "+MeetingCode+", IsMandatoryParticipant = "+IsMandatoryParticipant+", UserName = "+UserName+", IsManageUser = "+IsManageUser+", MeetingParticipantCode = "+MeetingParticipantCode+", IsPresent = "+IsPresent+", IsOptionalParticipant = "+IsOptionalParticipant+"]";
    }
}

