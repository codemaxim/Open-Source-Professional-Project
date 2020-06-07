package com.cookandroid.share;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn1 = findViewById(R.id.btn1);
        final TextView Tv = (TextView) findViewById(R.id.Tv);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Sharing_intent = new Intent(Intent.ACTION_SEND);
                Sharing_intent.setType("text/plain");

                Sharing_intent.putExtra(Intent.EXTRA_TEXT, Tv.getText());

                Intent Sharing = Intent.createChooser(Sharing_intent, "공유하기");
                startActivity(Sharing);
            }
        });
    }
}
