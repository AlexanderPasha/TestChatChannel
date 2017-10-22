package com.mannydev.testchatchannel.view;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mannydev.testchatchannel.R;
import com.mannydev.testchatchannel.model.Channel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created by manny on 21.10.17.
 */

public class MyChannelAdapter extends RecyclerView.Adapter<ChannelViewHolder> {

    private static final int UNREAD = 1;
    private static final int READ = 0;
    private static final int DIVIDER = -1;

    private static final String DATE_FORMAT_I = "yyyy-MM-dd'T'HH:mm:ss";
    private static final String DATE_FORMAT_O = "dd-MM, HH:mm";
    private static final String DATE_FORMAT_CURRENT = "dd";
    private static final String DATE_FORMAT_TODAY = "HH:mm";

    private final SimpleDateFormat formatInput;
    private final SimpleDateFormat formatOutput;
    private final SimpleDateFormat formatCurrent;
    private final SimpleDateFormat formatToday;

    private final Date currentDate;

    private List<Channel> list;

    private OnItemClickListener onItemClickListener;

    public MyChannelAdapter() {
        final Locale locale = Locale.getDefault();

        currentDate = new Date();
        formatInput = new SimpleDateFormat(DATE_FORMAT_I,locale);
        formatOutput = new SimpleDateFormat(DATE_FORMAT_O,locale);
        formatCurrent = new SimpleDateFormat(DATE_FORMAT_CURRENT,locale);
        formatToday = new SimpleDateFormat(DATE_FORMAT_TODAY,locale);

    }

    public void setData(List<Channel> list) {
        this.list = list;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public ChannelViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType==UNREAD) {
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.channels_view_unreaded, parent, false);
            return new UnreadedChannelViewHolder(v, onItemClickListener);
        }else if(viewType==DIVIDER) {
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.channels_view_zaglushka, parent, false);
            return new DividerChannelViewHolder(v, onItemClickListener);
        }else {
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.channels_view_readed, parent, false);
            return new ReadedChannelViewHolder(v, onItemClickListener);
        }

    }

    @Override
    public void onBindViewHolder(ChannelViewHolder holder, int position) {
        final Channel channel = list.get(position);
        if(getItemViewType(position)!=DIVIDER){
            holder.bindChannelHolder(channel, parseDate(channel.getLastMessage().getCreateDate()));
        }else holder.bindChannelHolder(channel, "null");

    }

    @Override
    public int getItemViewType(int position) {
        Channel ch = list.get(position);
        if(ch.getUnreadMessagesCount()>0&&ch.getUnreadMessagesCount()<1000){
            return UNREAD;
        }else if(ch.getLastMessage().getSender().getId()==0||ch.getUnreadMessagesCount()==-1
                ||ch.getUnreadMessagesCount()==1000){
            return DIVIDER;
        }else if(ch.getUnreadMessagesCount()==0) {
            return READ;
        }return READ;

    }

    @Override
    public int getItemCount() {
        if (list == null)
            return 0;
        return list.size();
    }


    private String parseDate(String s) {

        Date date = null;
        try {
            date = formatInput.parse(s);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        if (Integer.parseInt(formatCurrent.format(currentDate)) == Integer.parseInt(formatCurrent.format(date)) + 1) {
            return "Yesterday, " + formatToday.format(date);
        } else if (Integer.parseInt(formatCurrent.format(currentDate)) == Integer.parseInt(formatCurrent.format(date))) {
            return formatToday.format(date);
        } else {
            return formatOutput.format(date);
        }

    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

}