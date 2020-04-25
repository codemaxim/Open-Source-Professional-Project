package com.cookandroid.catchnoteproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BuyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy);

        Button siteBtn = (Button)findViewById(R.id.siteBtn);
        Button eventBtn = (Button)findViewById(R.id.eventBtn);

        siteBtn.setOnClickListener(OnClickListener);
        eventBtn.setOnClickListener(OnClickListener);
    }

    //버튼 클릭 시 화면 전환
    View.OnClickListener OnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch(v.getId()){
                case R.id.siteBtn:
                    GoSiteViewActivity();
                    break;
                case R.id.eventBtn:
                    GoEventViewOptionActivity();
                    break;
            }
        }
    };

    //SiteViewActivity로 이동
    private void GoSiteViewActivity(){
        Intent intent = new Intent(this, SiteViewActivity.class);
        startActivity(intent);
    }

    //EventViewActivity로 이동
    private void GoEventViewOptionActivity(){
        Intent intent = new Intent(this, EventViewActivity.class);
        startActivity(intent);
    }
}

