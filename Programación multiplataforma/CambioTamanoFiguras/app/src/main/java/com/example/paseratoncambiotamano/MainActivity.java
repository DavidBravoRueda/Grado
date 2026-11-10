package com.example.paseratoncambiotamano;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ImageView view1 = findViewById(R.id.imageView);
        ImageView view2 = findViewById(R.id.imageView2);

        view1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_MOVE:
                        view1.setScaleX(1.5f);
                        view1.setScaleY(1.5f);
                        Toast.makeText(MainActivity.this, "Dedo sobre view1", Toast.LENGTH_SHORT).show();
                        break;
                    case MotionEvent.ACTION_UP:
                    case MotionEvent.ACTION_CANCEL:

                        view1.setScaleX(1f);
                        view1.setScaleY(1f);
                        break;
                }
                return true;
            }
        });

        view2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_MOVE:
                        view2.setScaleX(1.5f);
                        view2.setScaleY(1.5f);
                        Toast.makeText(MainActivity.this, "Dedo sobre view2", Toast.LENGTH_SHORT).show();
                        break;
                    case MotionEvent.ACTION_UP:
                    case MotionEvent.ACTION_CANCEL:

                        view2.setScaleX(1f);
                        view2.setScaleY(1f);
                        break;
                }
                return true;
            }
        });
    }
}



