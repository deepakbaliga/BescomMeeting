package com.deepakbaliga.bescommeeting.retrofit;

import com.deepakbaliga.bescommeeting.model.Meeting;
import com.deepakbaliga.bescommeeting.model.Meetings;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by baliga on 12/05/16.
 */
public interface Api {

    @GET("meetings")
    Call<Meetings> getMeetings();
}
