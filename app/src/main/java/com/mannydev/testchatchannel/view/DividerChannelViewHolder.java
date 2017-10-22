package com.mannydev.testchatchannel.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.mannydev.testchatchannel.model.Channel;

/**
 * Created by manny on 21.10.17.
 */

public class DividerChannelViewHolder extends ChannelViewHolder {

    public DividerChannelViewHolder(View itemView, MyChannelAdapter.OnItemClickListener clickListener) {
        super(itemView, clickListener);
    }

    @Override
    public void bindChannelHolder(Channel ch, String dateString) {

    }
}