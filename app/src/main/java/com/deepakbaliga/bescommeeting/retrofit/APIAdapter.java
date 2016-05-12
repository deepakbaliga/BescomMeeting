package com.deepakbaliga.bescommeeting.retrofit;

import com.deepakbaliga.bescommeeting.App;
import com.deepakbaliga.bescommeeting.callback.MeetingsCallback;
import com.deepakbaliga.bescommeeting.model.Meeting;
import com.deepakbaliga.bescommeeting.model.Meetings;

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
}
