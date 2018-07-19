package com.pristinetravel.pristinetravels;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

public class application_page extends AppCompatActivity {

    private ImageButton about_us, custom, packages;
    public ViewFlipper v_cust, v_pack, v_about;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_application_page);
        about_us = (ImageButton) findViewById(R.id.imagebutton_contact);
        about_us.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                open_next(Contact_about_us.class);
            }
        });
        int image_cust[] = {R.drawable.itin,R.drawable.customized };
        int image_pack[] = {R.drawable.packages, R.drawable.pop};
        int image_about[] = {R.drawable.about_us, R.drawable.about};
        v_cust = findViewById(R.id.vf_custom);
        for (int image : image_cust) {
            flip_setting(image, v_cust, 2000);
        }
        v_pack = findViewById(R.id.vf_pack);
        for (int image : image_pack) {
            flip_setting(image, v_pack, 4000);
        }
        v_about = findViewById(R.id.vf_about);
        for (int image : image_about) {
            flip_setting(image, v_about, 8000);
        }
        custom = (ImageButton) findViewById(R.id.imagebutton_custom);
        custom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                open_next(Custom_Itinerary.class);
            }
        });
        packages = (ImageButton) findViewById(R.id.imagebutton_pack);
        packages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                open_next(Packages_activity.class);
            }
        });
    }

    public void open_next(Class cls) {
        Intent intent = new Intent(this, cls);
        startActivity(intent);
    }

    public void flip_setting(int image, ViewFlipper v_flip, int time_d) {
        ImageView imgview = new ImageView(this);
        Glide
                .with(this)
                .load(image)
                .skipMemoryCache(true)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .into(imgview);
        v_flip.addView(imgview);
        v_flip.setFlipInterval(time_d);
        v_flip.setAutoStart(true);
        v_flip.setInAnimation(this, android.R.anim.slide_in_left);
        v_flip.setOutAnimation(this, android.R.anim.slide_out_right);
    }
}