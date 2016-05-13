package com.deepakbaliga.bescommeeting.callback;

import com.deepakbaliga.bescommeeting.model.User;

/**
 * Created by baliga on 13/05/16.
 */
public interface Login {
    public void success(User user);
    public void failed(String err);
}
