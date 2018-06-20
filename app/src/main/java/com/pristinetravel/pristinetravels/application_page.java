package com.pristinetravel.pristinetravels;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class application_page extends AppCompatActivity {

    private ImageButton about_us,custom,packages;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_application_page);
        about_us = (ImageButton)findViewById(R.id.imagebutton_contact);
        about_us.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                open_next(Contact_about_us.class);
            }
        });
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
    public void open_next(Class cls){
        Intent intent = new Intent(this,cls);
        startActivity(intent);
    }
}
