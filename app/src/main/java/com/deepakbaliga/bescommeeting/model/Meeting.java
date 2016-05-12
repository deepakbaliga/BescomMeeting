package com.deepakbaliga.bescommeeting.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by baliga on 12/05/16.
 */
public class Meeting {



    @SerializedName("diffgr:id")
    @Expose
    private String diffgrId;
    @SerializedName("msdata:rowOrder")
    @Expose
    private String msdataRowOrder;
    @SerializedName("MeetingCode")
    @Expose
    private String MeetingCode;
    @SerializedName("MeetingNumber")
    @Expose
    private String MeetingNumber;
    @SerializedName("Subject")
    @Expose
    private String Subject;
    @SerializedName("MeetingTime")
    @Expose
    private String MeetingTime;
    @SerializedName("Venue")
    @Expose
    private String Venue;
    @SerializedName("MeetingStatusCode")
    @Expose
    private String MeetingStatusCode;
    @SerializedName("SubscriptionCode")
    @Expose
    private String SubscriptionCode;
    @SerializedName("CreatedUserCode")
    @Expose
    private String CreatedUserCode;
    @SerializedName("MeetingStatusName")
    @Expose
    private String MeetingStatusName;
    @SerializedName("CreatedDateTime")
    @Expose
    private String CreatedDateTime;
    @SerializedName("ProjectCode")
    @Expose
    private String ProjectCode;
    @SerializedName("MeetingName")
    @Expose
    private String MeetingName;

    /**
     * No args constructor for use in serialization
     *
     */
    public Meeting() {
    }

    /**
     *
     * @param MeetingNumber
     * @param Subject
     * @param msdataRowOrder
     * @param MeetingTime
     * @param CreatedUserCode
     * @param SubscriptionCode
     * @param ProjectCode
     * @param Venue
     * @param MeetingCode
     * @param CreatedDateTime
     * @param MeetingName
     * @param MeetingStatusName
     * @param diffgrId
     * @param MeetingStatusCode
     */
    public Meeting(String diffgrId, String msdataRowOrder, String MeetingCode, String MeetingNumber, String Subject, String MeetingTime, String Venue, String MeetingStatusCode, String SubscriptionCode, String CreatedUserCode, String MeetingStatusName, String CreatedDateTime, String ProjectCode, String MeetingName) {
        this.diffgrId = diffgrId;
        this.msdataRowOrder = msdataRowOrder;
        this.MeetingCode = MeetingCode;
        this.MeetingNumber = MeetingNumber;
        this.Subject = Subject;
        this.MeetingTime = MeetingTime;
        this.Venue = Venue;
        this.MeetingStatusCode = MeetingStatusCode;
        this.SubscriptionCode = SubscriptionCode;
        this.CreatedUserCode = CreatedUserCode;
        this.MeetingStatusName = MeetingStatusName;
        this.CreatedDateTime = CreatedDateTime;
        this.ProjectCode = ProjectCode;
        this.MeetingName = MeetingName;
    }

    /**
     *
     * @return
     * The diffgrId
     */
    public String getDiffgrId() {
        return diffgrId;
    }

    /**
     *
     * @param diffgrId
     * The diffgr:id
     */
    public void setDiffgrId(String diffgrId) {
        this.diffgrId = diffgrId;
    }

    /**
     *
     * @return
     * The msdataRowOrder
     */
    public String getMsdataRowOrder() {
        return msdataRowOrder;
    }

    /**
     *
     * @param msdataRowOrder
     * The msdata:rowOrder
     */
    public void setMsdataRowOrder(String msdataRowOrder) {
        this.msdataRowOrder = msdataRowOrder;
    }

    /**
     *
     * @return
     * The MeetingCode
     */
    public String getMeetingCode() {
        return MeetingCode;
    }

    /**
     *
     * @param MeetingCode
     * The MeetingCode
     */
    public void setMeetingCode(String MeetingCode) {
        this.MeetingCode = MeetingCode;
    }

    /**
     *
     * @return
     * The MeetingNumber
     */
    public String getMeetingNumber() {
        return MeetingNumber;
    }

    /**
     *
     * @param MeetingNumber
     * The MeetingNumber
     */
    public void setMeetingNumber(String MeetingNumber) {
        this.MeetingNumber = MeetingNumber;
    }

    /**
     *
     * @return
     * The Subject
     */
    public String getSubject() {
        return Subject;
    }

    /**
     *
     * @param Subject
     * The Subject
     */
    public void setSubject(String Subject) {
        this.Subject = Subject;
    }

    /**
     *
     * @return
     * The MeetingTime
     */
    public String getMeetingTime() {
        return MeetingTime;
    }

    /**
     *
     * @param MeetingTime
     * The MeetingTime
     */
    public void setMeetingTime(String MeetingTime) {
        this.MeetingTime = MeetingTime;
    }

    /**
     *
     * @return
     * The Venue
     */
    public String getVenue() {
        return Venue;
    }

    /**
     *
     * @param Venue
     * The Venue
     */
    public void setVenue(String Venue) {
        this.Venue = Venue;
    }

    /**
     *
     * @return
     * The MeetingStatusCode
     */
    public String getMeetingStatusCode() {
        return MeetingStatusCode;
    }

    /**
     *
     * @param MeetingStatusCode
     * The MeetingStatusCode
     */
    public void setMeetingStatusCode(String MeetingStatusCode) {
        this.MeetingStatusCode = MeetingStatusCode;
    }

    /**
     *
     * @return
     * The SubscriptionCode
     */
    public String getSubscriptionCode() {
        return SubscriptionCode;
    }

    /**
     *
     * @param SubscriptionCode
     * The SubscriptionCode
     */
    public void setSubscriptionCode(String SubscriptionCode) {
        this.SubscriptionCode = SubscriptionCode;
    }

    /**
     *
     * @return
     * The CreatedUserCode
     */
    public String getCreatedUserCode() {
        return CreatedUserCode;
    }

    /**
     *
     * @param CreatedUserCode
     * The CreatedUserCode
     */
    public void setCreatedUserCode(String CreatedUserCode) {
        this.CreatedUserCode = CreatedUserCode;
    }

    /**
     *
     * @return
     * The MeetingStatusName
     */
    public String getMeetingStatusName() {
        return MeetingStatusName;
    }

    /**
     *
     * @param MeetingStatusName
     * The MeetingStatusName
     */
    public void setMeetingStatusName(String MeetingStatusName) {
        this.MeetingStatusName = MeetingStatusName;
    }

    /**
     *
     * @return
     * The CreatedDateTime
     */
    public String getCreatedDateTime() {
        return CreatedDateTime;
    }

    /**
     *
     * @param CreatedDateTime
     * The CreatedDateTime
     */
    public void setCreatedDateTime(String CreatedDateTime) {
        this.CreatedDateTime = CreatedDateTime;
    }

    /**
     *
     * @return
     * The ProjectCode
     */
    public String getProjectCode() {
        return ProjectCode;
    }

    /**
     *
     * @param ProjectCode
     * The ProjectCode
     */
    public void setProjectCode(String ProjectCode) {
        this.ProjectCode = ProjectCode;
    }

    /**
     *
     * @return
     * The MeetingName
     */
    public String getMeetingName() {
        return MeetingName;
    }

    /**
     *
     * @param MeetingName
     * The MeetingName
     */
    public void setMeetingName(String MeetingName) {
        this.MeetingName = MeetingName;
    }


}
