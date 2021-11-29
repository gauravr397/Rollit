package com.gauravr.rollit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.util.ObjectsCompat;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rollit.R;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    ImageView imageView;
    Button button;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        //this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.scoreText);
        button = findViewById(R.id.buttonToss);
        imageView = findViewById(R.id.diceImage);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random random = new Random();
                int score = random.nextInt(6)+1;
                startAnimation();
                final Handler handler = new Handler(Looper.getMainLooper());
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        textView.setText(String.valueOf(score));
                        switch (score){
                            case 1:
                                imageView.setImageResource(R.drawable.dice1);
                                break;
                            case 2:
                                imageView.setImageResource(R.drawable.dice2);
                                break;
                            case 3:
                                imageView.setImageResource(R.drawable.dice3);
                                break;
                            case 4:
                                imageView.setImageResource(R.drawable.dice4);
                                break;
                            case 5:
                                imageView.setImageResource(R.drawable.dice5);
                                break;
                            case 6:
                                imageView.setImageResource(R.drawable.dice6);
                                break;
                        }
                    }
                },700);

            }
        });
    }
    public void startAnimation(){
        ObjectAnimator animator = ObjectAnimator.ofFloat(imageView, "rotation",0f,360f);
        animator.setDuration(700);
        AnimatorSet animatorSet=new AnimatorSet();
        animatorSet.playTogether(animator);
        animatorSet.start();
    }
}