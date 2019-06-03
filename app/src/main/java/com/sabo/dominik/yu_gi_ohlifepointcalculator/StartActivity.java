package com.sabo.dominik.yu_gi_ohlifepointcalculator;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.Random;

public class StartActivity extends AppCompatActivity {

    EditText etPlayer1, etPlayer2, etStartingLifePoints;
    Button btnJanken, btnPlay;
    ImageView ivJankenLeft, ivJankenRight;
    Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_start);
        initializeUI();

        btnJanken.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int left, right;
                left = random.nextInt(3)+1;
                do{
                    right = random.nextInt(3)+1;
                }while(right==left);
                setJankenResources(left, right);
            }
        });

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StartActivity.this, MainActivity.class);
                intent.putExtra("player1name", etPlayer1.getText().toString());
                intent.putExtra("player2name", etPlayer2.getText().toString());
                intent.putExtra("lifePoints", getLifePoints());
                clear();
                startActivity(intent);
            }
        });

        etPlayer1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(etPlayer1.getText().toString().length()!=0 && etPlayer2.getText().toString().length()!=0){
                    btnPlay.setEnabled(true);
                    if(etPlayer1.getText().toString().equals(etPlayer2.getText().toString())) btnPlay.setEnabled(false);
                }
                else btnPlay.setEnabled(false);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        etPlayer2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(etPlayer1.getText().toString().length()!=0 && etPlayer2.getText().toString().length()!=0){
                    btnPlay.setEnabled(true);
                    if(etPlayer1.getText().toString().equals(etPlayer2.getText().toString())) btnPlay.setEnabled(false);
                }
                else btnPlay.setEnabled(false);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }

    private void initializeUI() {
        this.etPlayer1 = findViewById(R.id.etPlayer1);
        this.etPlayer2 = findViewById(R.id.etPlayer2);
        this.etStartingLifePoints = findViewById(R.id.etStartingLifePoints);
        this.btnJanken = findViewById(R.id.btnJanken);
        this.btnPlay = findViewById(R.id.btnPlay);
        this.ivJankenLeft = findViewById(R.id.ivJanken1);
        this.ivJankenRight = findViewById(R.id.ivJanken2);
        btnPlay.setEnabled(false);
    }

    private void setJankenResources(int left, int right) {
        switch (left) {
            case 1:
                ivJankenLeft.setImageResource(R.drawable.paper_left);
                break;
            case 2:
                ivJankenLeft.setImageResource(R.drawable.rock_left);
                break;
            case 3:
                ivJankenLeft.setImageResource(R.drawable.scissors_left);
        }

        switch (right) {
            case 1:
                ivJankenRight.setImageResource(R.drawable.paper_right);
                break;
            case 2:
                ivJankenRight.setImageResource(R.drawable.rock_right);
                break;
            case 3:
                ivJankenRight.setImageResource(R.drawable.scissors_right);
                break;
        }
    }

    private String getLifePoints() {
        if(etStartingLifePoints.getText().toString().length()==0) return "8000";
        return etStartingLifePoints.getText().toString();
    }

    void clear(){
        btnPlay.setEnabled(false);
        etPlayer1.setText(null);
        etPlayer2.setText(null);
        etStartingLifePoints.setText(null);
        ivJankenLeft.setImageResource(0);
        ivJankenRight.setImageResource(0);
    }


}

