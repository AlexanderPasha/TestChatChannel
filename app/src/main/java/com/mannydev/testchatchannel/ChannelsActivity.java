package com.mannydev.testchatchannel;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mannydev.testchatchannel.controller.Data;
import com.mannydev.testchatchannel.controller.SwipeAdder;
import com.mannydev.testchatchannel.model.Channel;
import com.mannydev.testchatchannel.view.MyChannelAdapter;
import com.mannydev.testchatchannel.view.SpacesItemDecoration;

import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import me.drakeet.materialdialog.MaterialDialog;

/**
 * Created by manny on 19.10.17.
 */

public class ChannelsActivity extends AppCompatActivity implements MyChannelAdapter.OnItemClickListener{

    @BindView(R.id.txtChat)
    TextView txtChat;
    @BindView(R.id.txtLiveChat)
    TextView txtLiveChat;
    @BindView(R.id.txtTitle)
    TextView txtTitle;
    @BindView(R.id.btnNewMessage)
    Button btnNewMessage;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.btnAllUnreadedMessages)
    Button btnAllUnreadedMessages;
    @BindView(R.id.btnLiveChats)
    Button btnLiveChats;
    @BindView(R.id.llChat)
    LinearLayout llChat;
    @BindView(R.id.llLiveChat)
    LinearLayout llLiveChat;
    @BindView(R.id.btnHome)
    Button btnHome;
    @BindView(R.id.rvChannels)
    RecyclerView rvChannels;

    private MyChannelAdapter myChannelAdapter;
    private List<Channel> list;
    private MaterialDialog materialDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        ButterKnife.bind(this);

        Data data = new Data();
        list = data.getList();

        btnAllUnreadedMessages.setText(String.valueOf(data.getUnreadedMessages()));

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        rvChannels.setLayoutManager(mLayoutManager);

        myChannelAdapter = new MyChannelAdapter();

        myChannelAdapter.setData(list);
        myChannelAdapter.setOnItemClickListener(this);

        new SwipeAdder().addSwipes(rvChannels, myChannelAdapter, list);

        SpacesItemDecoration decoration = new SpacesItemDecoration(2);
        rvChannels.addItemDecoration(decoration);

        rvChannels.setAdapter(myChannelAdapter);

        //Заглушка на New Message
        materialDialog = addFakeDialog();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        myChannelAdapter.setData(null);
        myChannelAdapter.setOnItemClickListener(null);
    }

    @OnClick({R.id.llChat, R.id.llLiveChat, R.id.btnNewMessage, R.id.btnHome})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.llChat:
                setEnabledLayout(llChat, llLiveChat);
                //выводим что-то...
                break;
            case R.id.llLiveChat:
                setEnabledLayout(llLiveChat, llChat);
                //выводим что-то...
                break;
            case R.id.btnNewMessage:
                materialDialog.show();
                break;
            case R.id.btnHome:
                finish();
                break;
        }
    }

    private void setEnabledLayout(LinearLayout firstLayout, LinearLayout secondLayout) {
        firstLayout.setBackgroundResource(R.drawable.enabled_chat_style);
        secondLayout.setBackgroundColor(Color.TRANSPARENT);
        switch (firstLayout.getId()) {
            case R.id.llChat:
                txtChat.setTextColor(getResources().getColor(R.color.charcoal_grey));
                txtLiveChat.setTextColor(getResources().getColor(R.color.another2));

                myChannelAdapter.setData(list);
                myChannelAdapter.notifyDataSetChanged();

                break;
            case R.id.llLiveChat:
                txtLiveChat.setTextColor(getResources().getColor(R.color.charcoal_grey));
                txtChat.setTextColor(getResources().getColor(R.color.another2));

                myChannelAdapter.setData(Collections.<Channel>emptyList());
                myChannelAdapter.notifyDataSetChanged();

                break;
        }

    }

    //Заглушка для кнопки "Новое сообщение"
    private MaterialDialog addFakeDialog() {
        final MaterialDialog materialDialog = new MaterialDialog(ChannelsActivity.this);
        materialDialog.setTitle("Заглушка");
        materialDialog.setMessage("А могла быть форма для создания нового сообщения... ))");
        materialDialog.setPositiveButton("Принял!", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                materialDialog.dismiss();
            }
        });
        return materialDialog;
    }

    @Override
    public void onItemClick(int position) {

        final Channel channel = list.get(position);
        String sender = channel.getLastMessage()
                .getSender().getFirstName()
                +" "+channel.getLastMessage().getSender().getLastName();

        Intent intent = new Intent(this, SenderActivity.class);
        intent.putExtra("sender", sender);
        startActivity(intent);
    }
}



