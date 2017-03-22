package com.prac.birdtung.myapplication;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_NOSENSOR);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        Button starbtn = (Button)findViewById(R.id.startbtn);
        starbtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent it;
        if(v.getId() == R.id.startbtn){
            it = new Intent(this, PhotoTaken.class);
            startActivity(it);
        }
//        else if(v.getId() == R.id.settingbtn){
//            it = new Intent(this, videoact.class);
//            startActivity(it);
//        }
        //quitbtn
    }
}
