package com.deepakbaliga.bescommeeting.callback;

import com.deepakbaliga.bescommeeting.model.Meeting;

import java.util.List;

/**
 * Created by baliga on 12/05/16.
 */
public interface MeetingsCallback {
    public void onSuccess(List<Meeting> meetings);
    public void onFailed(String error);

}
