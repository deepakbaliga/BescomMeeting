package com.deepakbaliga.bescommeeting.retrofit;

import android.util.Log;

import com.deepakbaliga.bescommeeting.App;
import com.deepakbaliga.bescommeeting.callback.DetailsCallback;
import com.deepakbaliga.bescommeeting.callback.Login;
import com.deepakbaliga.bescommeeting.callback.MeetingsCallback;
import com.deepakbaliga.bescommeeting.model.Meeting;
import com.deepakbaliga.bescommeeting.model.MeetingDetail;
import com.deepakbaliga.bescommeeting.model.Meetings;
import com.deepakbaliga.bescommeeting.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by baliga on 12/05/16.
 */
public class APIAdapter {

    private Retrofit retrofit;
    private Api endPoints;
    String TAG = "RESPONSE";

    public APIAdapter() {

        retrofit = new Retrofit.Builder()
                .baseUrl(App.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        endPoints = retrofit.create(Api.class);
    }

    public void getMeetings(final MeetingsCallback callback){
        Call<Meetings> call = endPoints.getMeetings();

        call.enqueue(new Callback<Meetings>() {
            @Override
            public void onResponse(Call<Meetings> call, Response<Meetings> response) {
                callback.onSuccess(response.body().getMeetings());
            }

            @Override
            public void onFailure(Call<Meetings> call, Throwable t) {
                callback.onFailed(t.getMessage());
            }
        });
    }


    public void getMeetingDetails( int id, final DetailsCallback callback){
        Call<MeetingDetail> call = endPoints.getDetails(id);

        call.enqueue(new Callback<MeetingDetail>() {
            @Override
            public void onResponse(Call<MeetingDetail> call, Response<MeetingDetail> response) {
                callback.onSuccess(response.body());
                Log.d(TAG, "onResponse: " + response.code());
                Log.d(TAG, "onResponse: " + response.body().getMeeting().getMeetingName());
            }

            @Override
            public void onFailure(Call<MeetingDetail> call, Throwable t) {
                callback.onFailed(t.getMessage());
            }
        });
    }


    public void login(String username, String password, final Login callback){
        Call<User> call = endPoints.login(username, password);

        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {

                if(!(response.code()==404))
                    callback.success(response.body());
                else
                    callback.failed(response.message());

            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                callback.failed(t.getMessage());
            }
        });
    }
}
