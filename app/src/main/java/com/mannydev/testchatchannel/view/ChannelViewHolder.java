package com.mannydev.testchatchannel.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.mannydev.testchatchannel.R;
import com.mannydev.testchatchannel.model.Channel;

/**
 * Created by manny on 21.10.17.
 */

abstract class ChannelViewHolder extends RecyclerView.ViewHolder {
    ImageView ivAvatar;
    TextView txtSender;
    TextView txtLastMessage;
    TextView txtCreateDate;
    MyChannelAdapter.OnItemClickListener onItemClickListener;

    ChannelViewHolder(View itemView, MyChannelAdapter.OnItemClickListener clickListener) {
        super(itemView);

        ivAvatar = itemView.findViewById(R.id.ivAvatar);
        txtSender = itemView.findViewById(R.id.txtSender);
        txtLastMessage = itemView.findViewById(R.id.txtLastMessage);
        txtCreateDate = itemView.findViewById(R.id.txtCreateDate);

        this.onItemClickListener = clickListener;



    }

    public abstract void bindChannelHolder(Channel ch, String dateString);

    String cutLongMessageText(String string) {
        if (string.length() > 25) {
            return string.substring(0, 22) + "...";
        } else
            return string;
    }

    protected void setOnItemClickListener(){
        ivAvatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickListener != null)
                    onItemClickListener.onItemClick(getAdapterPosition());
            }
        });
    }

}