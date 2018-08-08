package com.pristinetravel.pristinetravels;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

    ViewFlipper v_flip ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int images[] = {R.drawable.secong,R.drawable.third,R.drawable.fourth,R.drawable.fifth};
        v_flip = findViewById(R.id.viewflip);
        v_flip.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                open_next();
                return false;
            }
        });
        for (int image:images){
            flip_setting(image);
        }
    }
    public void open_next(){
        Intent intent = new Intent(this,application_page.class);
        startActivity(intent);
    }

    public void flip_setting(int image){
        ImageView imgview = new ImageView(this);
        Glide
                .with(this)
                .load(image)
                .into(imgview);
        v_flip.addView(imgview);
        v_flip.setFlipInterval(3000);
        v_flip.setAutoStart(true);
        v_flip.setInAnimation(this, android.R.anim.slide_in_left);
        v_flip.setOutAnimation(this, android.R.anim.slide_out_right);


    }

}
