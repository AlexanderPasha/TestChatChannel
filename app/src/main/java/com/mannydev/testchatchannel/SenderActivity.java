package com.mannydev.testchatchannel;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by manny on 20.10.17.
 */

public class SenderActivity extends AppCompatActivity {

    @BindView(R.id.btnHome)
    Button btnHome;
    @BindView(R.id.txtTitle)
    TextView txtTitle;
    @BindView(R.id.txtBlock)
    TextView txtBlock;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sender);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        txtTitle.setText(intent.getStringExtra("sender"));
    }

    @OnClick({R.id.btnHome, R.id.txtBlock})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnHome:
                finish();
                break;
            case R.id.txtBlock:
                Toast.makeText(this,"User "+txtTitle.getText()+" was blocked!", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
