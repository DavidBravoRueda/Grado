package com.example.piano;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnDo = findViewById(R.id.btnDo);
        Button btnRe = findViewById(R.id.btnRe);
        Button btnMi = findViewById(R.id.btnMi);
        Button btnFa = findViewById(R.id.btnFa);
        Button btnSol = findViewById(R.id.btnSol);
        Button btnLa = findViewById(R.id.btnLa);
        Button btnSi = findViewById(R.id.btnSi);
        Button btnDoAlt = findViewById(R.id.btnDoAlt);

        btnDo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reproducirNota(R.raw.nota_do);
            }
        });

        btnRe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reproducirNota(R.raw.nota_re);
            }
        });

        btnMi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reproducirNota(R.raw.nota_mi);
            }
        });

        btnFa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reproducirNota(R.raw.nota_fa);
            }
        });

        btnSol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reproducirNota(R.raw.nota_sol);
            }
        });

        btnLa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reproducirNota(R.raw.nota_la);
            }
        });

        btnSi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reproducirNota(R.raw.nota_si);
            }
        });

        btnDoAlt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reproducirNota(R.raw.nota_do_alt);
            }
        });
    }

    private void reproducirNota(int notaId) {
        if (mp != null) {
            mp.release();
        }
        mp = MediaPlayer.create(this, notaId);
        mp.start();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mp != null) {
            mp.release();
        }
    }
}
