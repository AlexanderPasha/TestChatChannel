
package com.mannydev.testchatchannel.model;

import android.support.annotation.NonNull;

import java.util.Comparator;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Channel implements Comparable<Integer> {

    @SerializedName("last_message")
    @Expose
    private LastMessage lastMessage;
    @SerializedName("users")
    @Expose
    private List<User> users = null;
    @SerializedName("unread_messages_count")
    @Expose
    private Integer unreadMessagesCount;
    @SerializedName("id")
    @Expose
    private Integer id;

    public LastMessage getLastMessage() {
        return lastMessage;
    }

    public void setLastMessage(LastMessage lastMessage) {
        this.lastMessage = lastMessage;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Integer getUnreadMessagesCount() {
        return unreadMessagesCount;
    }

    public void setUnreadMessagesCount(Integer unreadMessagesCount) {
        this.unreadMessagesCount = unreadMessagesCount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int compareTo(@NonNull Integer integer) {
        return 0;
    }


}
