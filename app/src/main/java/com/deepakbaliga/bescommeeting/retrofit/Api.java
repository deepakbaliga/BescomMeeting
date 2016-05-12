package com.deepakbaliga.bescommeeting.retrofit;

import com.deepakbaliga.bescommeeting.model.Meeting;
import com.deepakbaliga.bescommeeting.model.MeetingDetail;
import com.deepakbaliga.bescommeeting.model.Meetings;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by baliga on 12/05/16.
 */
public interface Api {

    @GET("meetings")
    Call<Meetings> getMeetings();

    @FormUrlEncoded
    @POST("meeting")
    Call<MeetingDetail> getDetails(@Field("id") int id);
}
