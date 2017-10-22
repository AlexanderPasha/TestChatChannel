package com.mannydev.testchatchannel.view;

import android.content.Intent;
import android.view.View;

import com.mannydev.testchatchannel.SenderActivity;
import com.mannydev.testchatchannel.model.Channel;
import com.squareup.picasso.Picasso;

import jp.wasabeef.picasso.transformations.CropCircleTransformation;

/**
 * Created by manny on 21.10.17.
 */

public class ReadedChannelViewHolder extends ChannelViewHolder {

    public ReadedChannelViewHolder(View itemView, MyChannelAdapter.OnItemClickListener clickListener) {
        super(itemView, clickListener);
        setOnItemClickListener();
    }

    @Override
    public void bindChannelHolder(Channel ch, String dateString) {
        txtSender.setText(ch.getLastMessage()
                .getSender().getFirstName()
                +" "+ch.getLastMessage().getSender().getLastName());
        txtLastMessage.setText(cutLongMessageText(ch.getLastMessage().getText()));
        txtCreateDate.setText(dateString);
        Picasso.with(itemView.getContext().getApplicationContext())
                .load(ch.getLastMessage().getSender().getPhoto()+"+"+ch.getLastMessage()
                        .getSender().getId()).transform(new CropCircleTransformation())
                .fit().centerCrop().into(ivAvatar);
    }

}