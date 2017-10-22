package com.mannydev.testchatchannel.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mannydev.testchatchannel.model.Channel;
import com.mannydev.testchatchannel.model.Channels;
import com.mannydev.testchatchannel.model.LastMessage;
import com.mannydev.testchatchannel.model.Sender;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by manny on 20.10.17.
 */

public class Data {

    private int unreadedMessages;
    private List<Channel>list;

    public Data(){
        getData();
    }

    public List<Channel> getList() {
        return list;
    }

    public int getUnreadedMessages() {
        return unreadedMessages;
    }

    public void getData(){
        unreadedMessages=0;
        String JSONstring = "{\"channels\":[{\"last_message\":{\"sender\":{\"last_name\":\"Clar\",\"photo\":\"https://placeimg.com/400/400/people\",\"first_name\":\"Alex\",\"id\":1747,\"username\":\"alexclar\"},\"is_read\":false,\"create_date\":\"2017-06-01T11:26:18.722663Z\",\"text\":\"Hey, how are you?\"},\"users\":[{\"last_name\":\"Clar\",\"photo\":\"https://placeimg.com/400/400/people\",\"first_name\":\"Alex\",\"id\":1747,\"username\":\"alexclar\"},{\"last_name\":\"Rock\",\"photo\":\"https://placeimg.com/400/400/people\",\"first_name\":\"Nick\",\"id\":1947,\"username\":\"nickrock\"}],\"unread_messages_count\":3,\"id\":860},{\"last_message\":{\"sender\":{\"last_name\":\"Nicholson\",\"photo\":\"https://placeimg.com/400/400/people\",\"first_name\":\"Ryan\",\"id\":84,\"username\":\"ryannicholson\"},\"is_read\":false,\"create_date\":\"2017-05-30T12:15:42.065181Z\",\"text\":\"Yes, I think so :D\"},\"users\":[{\"last_name\":\"Nicholson\",\"photo\":\"https://placeimg.com/400/400/people\",\"first_name\":\"Ryan\",\"id\":84,\"username\":\"ryannicholson\"},{\"last_name\":\"Rock\",\"photo\":\"https://placeimg.com/400/400/people\",\"first_name\":\"Nick\",\"id\":1947,\"username\":\"nickrock\"}],\"unread_messages_count\":1,\"id\":857},{\"last_message\":{\"sender\":{\"last_name\":\"Rock\",\"photo\":\"https://placeimg.com/400/400/people\",\"first_name\":\"Nick\",\"id\":1947,\"username\":\"nickrock\"},\"is_read\":true,\"create_date\":\"2017-05-21T10:11:42.065181Z\",\"text\":\"So beautiful, i really like it :)\"},\"users\":[{\"last_name\":\"Austin\",\"photo\":\"https://placeimg.com/400/400/people\",\"first_name\":\"Julie\",\"id\":191,\"username\":\"julieaustin\"},{\"last_name\":\"Rock\",\"photo\":\"https://placeimg.com/400/400/people\",\"first_name\":\"Nick\",\"id\":1947,\"username\":\"nickrock\"}],\"unread_messages_count\":0,\"id\":134},{\"last_message\":{\"sender\":{\"last_name\":\"Rock\",\"photo\":\"https://placeimg.com/400/400/people\",\"first_name\":\"Nick\",\"id\":1947,\"username\":\"nickrock\"},\"is_read\":true,\"create_date\":\"2017-05-20T12:15:42.065181Z\",\"text\":\"because I reach the high level ))\"},\"users\":[{\"last_name\":\"Barnes\",\"photo\":\"https://placeimg.com/400/400/people\",\"first_name\":\"Denise\",\"id\":678,\"username\":\"denisebarnes\"},{\"last_name\":\"Rock\",\"photo\":\"https://placeimg.com/400/400/people\",\"first_name\":\"Nick\",\"id\":1947,\"username\":\"nickrock\"}],\"unread_messages_count\":0,\"id\":454},{\"last_message\":{\"sender\":{\"last_name\":\"Moore\",\"photo\":\"https://placeimg.com/400/400/people\",\"first_name\":\"Tyler\",\"id\":4567,\"username\":\"tylermoore\"},\"is_read\":true,\"create_date\":\"2017-05-18T12:15:42.065181Z\",\"text\":\"Do you belive me?\"},\"users\":[{\"last_name\":\"Moore\",\"photo\":\"https://placeimg.com/400/400/people\",\"first_name\":\"Tyler\",\"id\":4567,\"username\":\"tylermoore\"},{\"last_name\":\"Rock\",\"photo\":\"https://placeimg.com/400/400/people\",\"first_name\":\"Nick\",\"id\":1947,\"username\":\"nickrock\"}],\"unread_messages_count\":0,\"id\":789},{\"last_message\":{\"sender\":{\"last_name\":\"Alba\",\"photo\":\"https://placeimg.com/400/400/people\",\"first_name\":\"Jessica\",\"id\":3498,\"username\":\"jessicaalba\"},\"is_read\":true,\"create_date\":\"2017-05-11T12:15:42.065181Z\",\"text\":\"I love your last single! :)\"},\"users\":[{\"last_name\":\"Alba\",\"photo\":\"https://placeimg.com/400/400/people\",\"first_name\":\"Jessica\",\"id\":3498,\"username\":\"jessicaalba\"},{\"last_name\":\"Rock\",\"photo\":\"https://placeimg.com/400/400/people\",\"first_name\":\"Nick\",\"id\":1947,\"username\":\"nickrock\"}],\"unread_messages_count\":0,\"id\":789},{\"last_message\":{\"sender\":{\"last_name\":\"Alba1\",\"photo\":\"https://placeimg.com/400/400/people\",\"first_name\":\"Jessica\",\"id\":3498,\"username\":\"jessicaalba\"},\"is_read\":true,\"create_date\":\"2017-05-11T12:15:42.065181Z\",\"text\":\"lalala 1\"},\"users\":[{\"last_name\":\"Alba1\",\"photo\":\"https://placeimg.com/400/400/people\",\"first_name\":\"Jessica\",\"id\":3498,\"username\":\"jessicaalba\"},{\"last_name\":\"Rock\",\"photo\":\"https://placeimg.com/400/400/people\",\"first_name\":\"Nick\",\"id\":1947,\"username\":\"nickrock\"}],\"unread_messages_count\":0,\"id\":789},{\"last_message\":{\"sender\":{\"last_name\":\"Alba2\",\"photo\":\"https://placeimg.com/400/400/people\",\"first_name\":\"Jessica\",\"id\":3498,\"username\":\"jessicaalba\"},\"is_read\":true,\"create_date\":\"2017-05-11T12:15:42.065181Z\",\"text\":\"lalala 2\"},\"users\":[{\"last_name\":\"Alba2\",\"photo\":\"https://placeimg.com/400/400/people\",\"first_name\":\"Jessica\",\"id\":3498,\"username\":\"jessicaalba\"},{\"last_name\":\"Rock\",\"photo\":\"https://placeimg.com/400/400/people\",\"first_name\":\"Nick\",\"id\":1947,\"username\":\"nickrock\"}],\"unread_messages_count\":0,\"id\":789},{\"last_message\":{\"sender\":{\"last_name\":\"Alba3\",\"photo\":\"https://placeimg.com/400/400/people\",\"first_name\":\"Jessica\",\"id\":3498,\"username\":\"jessicaalba\"},\"is_read\":true,\"create_date\":\"2017-05-11T12:15:42.065181Z\",\"text\":\"lalala 3\"},\"users\":[{\"last_name\":\"Alba3\",\"photo\":\"https://placeimg.com/400/400/people\",\"first_name\":\"Jessica\",\"id\":3498,\"username\":\"jessicaalba\"},{\"last_name\":\"Rock\",\"photo\":\"https://placeimg.com/400/400/people\",\"first_name\":\"Nick\",\"id\":1947,\"username\":\"nickrock\"}],\"unread_messages_count\":0,\"id\":789},{\"last_message\":{\"sender\":{\"last_name\":\"Alba4\",\"photo\":\"https://placeimg.com/400/400/people\",\"first_name\":\"Jessica\",\"id\":3498,\"username\":\"jessicaalba\"},\"is_read\":true,\"create_date\":\"2017-05-11T12:15:42.065181Z\",\"text\":\"lalala 4\"},\"users\":[{\"last_name\":\"Alba4\",\"photo\":\"https://placeimg.com/400/400/people\",\"first_name\":\"Jessica\",\"id\":3498,\"username\":\"jessicaalba\"},{\"last_name\":\"Rock\",\"photo\":\"https://placeimg.com/400/400/people\",\"first_name\":\"Nick\",\"id\":1947,\"username\":\"nickrock\"}],\"unread_messages_count\":0,\"id\":789},{\"last_message\":{\"sender\":{\"last_name\":\"Alba5\",\"photo\":\"https://placeimg.com/400/400/people\",\"first_name\":\"Jessica\",\"id\":3498,\"username\":\"jessicaalba\"},\"is_read\":true,\"create_date\":\"2017-05-11T12:15:42.065181Z\",\"text\":\"lalala 5\"},\"users\":[{\"last_name\":\"Alba5\",\"photo\":\"https://placeimg.com/400/400/people\",\"first_name\":\"Jessica\",\"id\":3498,\"username\":\"jessicaalba\"},{\"last_name\":\"Rock\",\"photo\":\"https://placeimg.com/400/400/people\",\"first_name\":\"Nick\",\"id\":1947,\"username\":\"nickrock\"}],\"unread_messages_count\":0,\"id\":789},{\"last_message\":{\"sender\":{\"last_name\":\"Alba6\",\"photo\":\"https://placeimg.com/400/400/people\",\"first_name\":\"Jessica\",\"id\":3498,\"username\":\"jessicaalba\"},\"is_read\":true,\"create_date\":\"2017-05-11T12:15:42.065181Z\",\"text\":\"lalala 6\"},\"users\":[{\"last_name\":\"Alba6\",\"photo\":\"https://placeimg.com/400/400/people\",\"first_name\":\"Jessica\",\"id\":3498,\"username\":\"jessicaalba\"},{\"last_name\":\"Rock\",\"photo\":\"https://placeimg.com/400/400/people\",\"first_name\":\"Nick\",\"id\":1947,\"username\":\"nickrock\"}],\"unread_messages_count\":0,\"id\":789}]}";
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        Channels channels = gson.fromJson(JSONstring, Channels.class);
        list =  channels.getChannels();
        for(Channel ch:list){
            if(ch.getUnreadMessagesCount()!=0){
                unreadedMessages+=ch.getUnreadMessagesCount();
            }
        }

        addDividers(list);

        Collections.sort(list,new SortedByMessages());
        Collections.reverse(list);
    }

    private Channel[] divider(){
        Channel ch = new Channel();
        ch.setUnreadMessagesCount(0);
        Sender sender = new Sender();
        sender.setId(0);
        LastMessage lastMessage = new LastMessage();
        lastMessage.setSender(sender);
        ch.setLastMessage(lastMessage);
        Channel ch0 = new Channel();
        ch0.setUnreadMessagesCount(1000);
        LastMessage lm0 = new LastMessage();
        Sender sender0 = new Sender();
        sender0.setId(-1);
        ch0.setLastMessage(lm0);
        lm0.setSender(sender0);
        Channel chLast = new Channel();
        chLast.setUnreadMessagesCount(-1);
        LastMessage lmLast = new LastMessage();
        Sender senderLast = new Sender();
        senderLast.setId(-1);
        chLast.setLastMessage(lmLast);
        lmLast.setSender(senderLast);
        Channel[]massive = new Channel[]{ch,ch0,chLast};
        return  massive;
    }

    private void addDividers(List<Channel>list){
        Channel[]dividers = divider();
        for(Channel ch:dividers){
            list.add(ch);
        }
    }

}

class SortedByMessages implements Comparator<Channel> {

    public int compare(Channel obj1, Channel obj2) {

        int un1 = obj1.getUnreadMessagesCount();
        int un2 = obj2.getUnreadMessagesCount();
        int id = obj1.getLastMessage().getSender().getId();

        if (un1 > un2 || un1 == un2 && id == 0) {
            return 1;
        } else if (un1 < un2) {
            return -1;
        } else {
            return 0;
        }
    }
}
