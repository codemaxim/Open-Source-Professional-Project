package com.cookandroid.catchnoteproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buyBtn = (Button)findViewById(R.id.buyBtn);
        Button recommendBtn = (Button)findViewById(R.id.recommendBtn);

        buyBtn.setOnClickListener(OnClickListener);
        recommendBtn.setOnClickListener(OnClickListener);
    }

    //버튼 클릭 시 화면 전환
    View.OnClickListener OnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch(v.getId()){
                case R.id.buyBtn:
                    GoBuyActivity();
                    break;
                case R.id.recommendBtn:
                    GoSelectOptionActivity();
                    break;
            }
        }
    };

    //BuyActivity로 이동
    private void GoBuyActivity(){
        Intent intent = new Intent(this, BuyActivity.class);
        startActivity(intent);
    }

    //SelectOptionActivity로 이동
    private void GoSelectOptionActivity(){
        Intent intent = new Intent(this, SelectOptionActivity.class);
        startActivity(intent);
    }
}
