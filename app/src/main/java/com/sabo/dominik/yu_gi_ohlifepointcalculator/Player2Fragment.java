package com.sabo.dominik.yu_gi_ohlifepointcalculator;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;



public class Player2Fragment extends Fragment {

    private static final String BUNDLE_MESSAGE = "player";

    private TextView tvLifePoints;
    private ImageView ivDie;
    private ImageView ivCoin;
    private TextView tvCounter1;
    private TextView tvCounter2;
    private TextView tvCounter3;

    private Button btn10;
    private Button btn100;
    private Button btn500;
    private Button btn1000;
    private Button btnM10;
    private Button btnM100;
    private Button btnM500;
    private Button btnM1000;

    private Button btnRoll;
    private Button btnFlip;
    private Button btnKill;

    private ImageView btnCounter1Minus;
    private ImageView btnCounter1Plus;
    private ImageView btnCounter2Minus;
    private ImageView btnCounter2Plus;
    private ImageView btnCounter3Minus;
    private ImageView btnCounter3Plus;

    private ButtonClickListener listener;

    public static Player2Fragment newInstance(String name)
    {
        Player2Fragment fragment = new Player2Fragment();
        Bundle args = new Bundle();
        args.putString(BUNDLE_MESSAGE, name);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_player, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setUpViews(view);
        setUpListeners();
        MainActivity.setFragment2(this);
    }

    private void setUpListeners() {
        btnKill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listener != null) listener.onButtonClicked(getArguments().getString(BUNDLE_MESSAGE), 0);
            }
        });

        btnFlip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listener != null) listener.onButtonClicked(getArguments().getString(BUNDLE_MESSAGE), 7);
            }
        });

        btnRoll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listener != null) listener.onButtonClicked(getArguments().getString(BUNDLE_MESSAGE), 8);
            }
        });

        btnCounter1Minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listener != null) listener.onButtonClicked(getArguments().getString(BUNDLE_MESSAGE), 1);
            }
        });

        btnCounter1Plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listener != null) listener.onButtonClicked(getArguments().getString(BUNDLE_MESSAGE), 2);
            }
        });

        btnCounter2Minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listener != null) listener.onButtonClicked(getArguments().getString(BUNDLE_MESSAGE), 3);
            }
        });

        btnCounter2Plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listener != null) listener.onButtonClicked(getArguments().getString(BUNDLE_MESSAGE), 4);
            }
        });

        btnCounter3Minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listener != null) listener.onButtonClicked(getArguments().getString(BUNDLE_MESSAGE), 5);
            }
        });

        btnCounter3Plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listener != null) listener.onButtonClicked(getArguments().getString(BUNDLE_MESSAGE), 6);
            }
        });

        btn10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listener != null) listener.onButtonClicked(getArguments().getString(BUNDLE_MESSAGE), 10);
            }
        });

        btn100.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listener != null) listener.onButtonClicked(getArguments().getString(BUNDLE_MESSAGE), 100);
            }
        });

        btn500.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listener != null) listener.onButtonClicked(getArguments().getString(BUNDLE_MESSAGE), 500);
            }
        });

        btn1000.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listener != null) listener.onButtonClicked(getArguments().getString(BUNDLE_MESSAGE), 1000);
            }
        });

        btnM10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listener != null) listener.onButtonClicked(getArguments().getString(BUNDLE_MESSAGE), -10);
            }
        });

        btnM100.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listener != null) listener.onButtonClicked(getArguments().getString(BUNDLE_MESSAGE), -100);
            }
        });

        btnM500.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listener != null) listener.onButtonClicked(getArguments().getString(BUNDLE_MESSAGE), -500);
            }
        });

        btnM1000.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listener != null) listener.onButtonClicked(getArguments().getString(BUNDLE_MESSAGE), -1000);
            }
        });

    }

    private void setUpViews(View view) {
        this.tvLifePoints = view.findViewById(R.id.tvLifeCount);
        this.tvLifePoints.setText((String.valueOf(MainActivity.getLifePoints())));
        this.ivCoin = view.findViewById(R.id.ivCoinFlip);
        this.ivDie = view.findViewById(R.id.ivDiceRoll);
        this.tvCounter1 = view.findViewById(R.id.tvCounter1);
        this.tvCounter2 = view.findViewById(R.id.tvCounter2);
        this.tvCounter3 = view.findViewById(R.id.tvCounter3);

        this.btn10 = view.findViewById(R.id.btn10);
        this.btn100 = view.findViewById(R.id.btn100);
        this.btn500 = view.findViewById(R.id.btn500);
        this.btn1000 = view.findViewById(R.id.btn1000);
        this.btnM10 = view.findViewById(R.id.btnM10);
        this.btnM100 = view.findViewById(R.id.btnM100);
        this.btnM500 = view.findViewById(R.id.btnM500);
        this.btnM1000 = view.findViewById(R.id.btnM1000);

        this.btnRoll = view.findViewById(R.id.btnDiceRoll);
        this.btnFlip = view.findViewById(R.id.btnCoinFlip);
        this.btnKill = view.findViewById(R.id.btnKill);

        this.btnCounter1Minus = view.findViewById(R.id.btnCounter1Minus);
        this.btnCounter1Plus = view.findViewById(R.id.btnCounter1Plus);
        this.btnCounter2Minus = view.findViewById(R.id.btnCounter2Minus);
        this.btnCounter2Plus = view.findViewById(R.id.btnCounter2Plus);
        this.btnCounter3Minus = view.findViewById(R.id.btnCounter3Minus);
        this.btnCounter3Plus = view.findViewById(R.id.btnCounter3Plus);

        colorCheck();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof ButtonClickListener)
        {
            listener = (ButtonClickListener) context;
        }
    }
    public void killPlayer() {
        this.tvLifePoints.setText((String.valueOf(0)));
        colorCheck();
    }

    public void changeLifePoints(int value){
        this.tvLifePoints.setText(String.valueOf(Integer.parseInt(this.tvLifePoints.getText().toString())+value));
        if(Integer.parseInt(this.tvLifePoints.getText().toString()) < 0) this.tvLifePoints.setText((String.valueOf(0)));
        colorCheck();
    }

    public void colorCheck(){
        if(Integer.parseInt(this.tvLifePoints.getText().toString()) >= 4000) this.tvLifePoints.setTextColor(Color.rgb(34,139,34));
        else if (Integer.parseInt(this.tvLifePoints.getText().toString()) < 1000) this.tvLifePoints.setTextColor(Color.rgb(255,0,0));
        else this.tvLifePoints.setTextColor(Color.rgb(255,165,0));
    }

    public void changeCounters(int value){
        switch(value){
            case 1: if(Integer.parseInt(tvCounter1.getText().toString()) > 0) this.tvCounter1.setText(String.valueOf(Integer.parseInt(tvCounter1.getText().toString())-1)); break;
            case 2: this.tvCounter1.setText(String.valueOf(Integer.parseInt(tvCounter1.getText().toString())+1)); break;
            case 3: if(Integer.parseInt(tvCounter2.getText().toString()) > 0) this.tvCounter2.setText(String.valueOf(Integer.parseInt(tvCounter2.getText().toString())-1)); break;
            case 4: this.tvCounter2.setText(String.valueOf(Integer.parseInt(tvCounter2.getText().toString())+1)); break;
            case 5: if(Integer.parseInt(tvCounter3.getText().toString()) > 0) this.tvCounter3.setText(String.valueOf(Integer.parseInt(tvCounter3.getText().toString())-1)); break;
            case 6: this.tvCounter3.setText(String.valueOf(Integer.parseInt(tvCounter3.getText().toString())+1)); break;
        }
    }

    public void flipCoin(int randomValue){
        if(randomValue == 0) this.ivCoin.setImageResource(R.drawable.coin_heads);
        else this.ivCoin.setImageResource(R.drawable.coin_tails);
    }

    public void rollDie(int randomValue){
        if(randomValue == 0) this.ivDie.setImageResource((R.drawable.die_one));
        else if(randomValue == 1) this.ivDie.setImageResource((R.drawable.die_two));
        else if(randomValue == 2) this.ivDie.setImageResource((R.drawable.die_three));
        else if(randomValue == 3) this.ivDie.setImageResource((R.drawable.die_four));
        else if(randomValue == 4) this.ivDie.setImageResource((R.drawable.die_five));
        else this.ivDie.setImageResource((R.drawable.die_six));
    }


}

