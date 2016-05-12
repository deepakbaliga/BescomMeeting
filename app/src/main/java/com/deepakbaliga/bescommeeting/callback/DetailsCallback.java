package com.deepakbaliga.bescommeeting.callback;

import com.deepakbaliga.bescommeeting.model.Meeting;
import com.deepakbaliga.bescommeeting.model.MeetingDetail;

import java.util.List;

/**
 * Created by baliga on 12/05/16.
 */
public interface DetailsCallback {
    public void onSuccess(MeetingDetail detail);
    public void onFailed(String error);

}
