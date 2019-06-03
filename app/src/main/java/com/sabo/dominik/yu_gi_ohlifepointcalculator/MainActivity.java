package com.sabo.dominik.yu_gi_ohlifepointcalculator;

import android.content.pm.ActivityInfo;
import android.os.Handler;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;
import java.util.Random;


public class MainActivity extends AppCompatActivity implements ButtonClickListener {

    private static String Player1Name;
    private static String Player2Name;
    private static String lifePoints;
    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    private Random random = new Random();
    private boolean doubleTap = false;

    private static PlayerFragment playerOne = new PlayerFragment();
    private static Player2Fragment playerTwo = new Player2Fragment();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_main);
        initializeUI();
        setUpPager();
    }

    private void initializeUI() {
        mViewPager = findViewById(R.id.viewPager);
        mTabLayout = findViewById(R.id.tab);
        Player1Name = getIntent().getStringExtra("player1name");
        Player2Name = getIntent().getStringExtra("player2name");
        lifePoints = getIntent().getStringExtra("lifePoints");
    }

    private void setUpPager() {
        PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(pagerAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
    }

    public static String getPlayer1Name() {
        return Player1Name;
    }

    public static String getPlayer2Name() {
        return Player2Name;
    }

    public static String getLifePoints() {
        return lifePoints;
    }

    public static void setFragment(PlayerFragment fragment) {
        playerOne = fragment;
    }

    public static void setFragment2(Player2Fragment fragment) {
        playerTwo = fragment;
    }


    @Override
    public void onButtonClicked(String playerName, int event) {
        if (playerName.equals(getPlayer1Name())) {
            switch (event) {
                case 0:
                    playerOne.killPlayer();
                    break;
                case 7:
                    playerOne.flipCoin(random.nextInt(2));
                    break;
                case 8:
                    playerOne.rollDie(random.nextInt(6));
                    break;
                default:
                    if (event > 0 && event < 10) playerOne.changeCounters(event);
                    else playerOne.changeLifePoints(event);
                    break;
            }
        } else {
            switch (event) {
                case 0:
                    playerTwo.killPlayer();
                    break;
                case 7:
                    playerTwo.flipCoin(random.nextInt(2));
                    break;
                case 8:
                    playerTwo.rollDie(random.nextInt(6));
                    break;
                default:
                    if (event > 0 && event < 10) playerTwo.changeCounters(event);
                    else playerTwo.changeLifePoints(event);
                    break;
            }
        }
    }

    @Override
    public void onBackPressed() {
        if(doubleTap){
            super.onBackPressed();
        }
        else{
            Toast.makeText(this, "Press back again to restart", Toast.LENGTH_SHORT).show();
            doubleTap = true;
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    doubleTap = false;
                }
            }, 2000);
        }
    }


}
