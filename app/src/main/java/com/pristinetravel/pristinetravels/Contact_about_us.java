package com.pristinetravel.pristinetravels;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;

public class Contact_about_us extends AppCompatActivity {

    private MapView mapView;
    private GoogleMap gmap;
    TextView link_website;
    Spanned Text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_about_us);
        link_website = (TextView)findViewById(R.id.textView_link);
        Text = Html.fromHtml("\t\tWebsite -- " +
                "<a href='https://www.pristinetravels.com//'>pristinetravels.com</a>");
        link_website.setMovementMethod(LinkMovementMethod.getInstance());
        link_website.setText(Text);

    }

}
