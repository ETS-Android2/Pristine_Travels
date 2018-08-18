package com.pristinetravel.pristinetravels;

import android.annotation.SuppressLint;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;

import static android.view.View.INVISIBLE;
import static android.view.View.VISIBLE;

public class Custom_Itinerary extends AppCompatActivity {

    AutoCompleteTextView actv_place,actv_days,actv_hotels;
    String[] places_option;
    String[] category;
    public String book_dets;
    ArrayAdapter<String> adap_places,category_hotels;
    Button but_confirm,but_change,but_finish,but_next,but_back;
    ImageButton btn_help;
    StringBuilder emailbody;
    public int page_number = 0 ;
    String[] activities_selected, places_selected,hotels_selected,dates_selected;
    EditText et_activity,et_place,et_date_to,et_date_from,et_budget,et_rooms,et_age,et_name,et_date;
    TextView tv_dis;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        emailbody = new StringBuilder();
        setContentView(R.layout.activity_custom__itinerary);
        activities_selected = new String[14];
        places_selected = new String[14];
        Arrays.fill(activities_selected,"");
        Arrays.fill(places_selected,"");
        hotels_selected = new String[14];
        Arrays.fill(hotels_selected,"");
        dates_selected = new String[15];
        places_option = getResources().getStringArray(R.array.places_options);
        category = getResources().getStringArray(R.array.category_of_hotels);
        Arrays.fill(dates_selected,"");
        btn_help = (ImageButton) findViewById(R.id.imgbtn_help);
        et_budget = (EditText) findViewById(R.id.et_budget);
        et_rooms = (EditText) findViewById(R.id.et_rooms_req);
        et_activity = (EditText) findViewById(R.id.et_activity);
        et_place = (EditText) findViewById(R.id.et_place);
        et_date_from = (EditText)findViewById(R.id.et_date_from);
        et_date_to = (EditText) findViewById(R.id.et_date_to);
        but_confirm = (Button) findViewById(R.id.but_conf);
        but_change = (Button) findViewById(R.id.but_change);
        but_next = (Button) findViewById(R.id.but_next);
        but_back = (Button) findViewById(R.id.but_back);
        but_finish = (Button) findViewById(R.id.but_finish);
        but_change.setVisibility(INVISIBLE);
        actv_days = (AutoCompleteTextView) findViewById(R.id.actv_days);
        actv_place = (AutoCompleteTextView) findViewById(R.id.actv_places);
        actv_hotels = (AutoCompleteTextView) findViewById(R.id.actv_hotel);
        adap_places = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,places_option);
        category_hotels = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,category);
        actv_place.setAdapter(adap_places);
        actv_hotels.setAdapter(category_hotels);
        final String msg = getString(R.string.help_content);
        btn_help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Custom_Itinerary.this);
                View layout_view = getLayoutInflater().inflate(R.layout.dialog_layout,null);
                TextView tv_title = (TextView) layout_view.findViewById(R.id.tV_title);
                TextView tv_message = (TextView) layout_view.findViewById(R.id.tV_message);
                Button but_invis = (Button)  layout_view.findViewById(R.id.but_submit_package);
                but_invis.setVisibility(INVISIBLE);
                tv_title.setText(R.string.title_layout_help);
                tv_message.setText(msg);
                builder.setView(layout_view);
                AlertDialog alert = builder.create();
                alert.show();
            }
        });
        but_change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                but_change.setVisibility(INVISIBLE);
                but_confirm.setVisibility( VISIBLE);
                actv_place.setEnabled(true);
                actv_days.setEnabled(true);
                et_rooms.setEnabled(true);
                et_budget.setEnabled(true);
            }
        });
        but_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                but_confirm.setVisibility(INVISIBLE);
                but_change.setVisibility( VISIBLE);
                actv_place.setEnabled(false);
                actv_days.setEnabled(false);
                et_rooms.setEnabled(false);
                et_budget.setEnabled(false);
            }
        });
        but_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    activities_selected[page_number] = et_activity.getText().toString();
                    places_selected[page_number] = et_place.getText().toString();
                    hotels_selected[page_number] = actv_hotels.getText().toString();
                    dates_selected[page_number] = et_date_from.getText().toString();
                    dates_selected[page_number+1] = et_date_to.getText().toString();
                    page_number++;
                    actv_hotels.setText(hotels_selected[page_number]);
                    et_place.setText(places_selected[page_number]);
                    et_activity.setText(activities_selected[page_number]);
                    et_date_to.setText(dates_selected[page_number+1]);
                    et_date_from.setText(dates_selected[page_number]);
                }catch (Exception e){
                }
            }
        });
        but_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    page_number--;
                    actv_hotels.setText(hotels_selected[page_number]);
                    et_place.setText(places_selected[page_number]);
                    et_activity.setText(activities_selected[page_number]);
                    et_date_to.setText(dates_selected[page_number+1]);
                    et_date_from.setText(dates_selected[page_number]);
                }catch (Exception e){

                }
            }
        });
        but_finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String details = "";
                String temp = " Hello there, \n This is a request for an itinerary for "
                        + actv_days.getText().toString() + " days in " + actv_place.getText().toString()+
                        " We require "+ et_rooms.getText().toString() + " rooms, in all of our stays. Our approximate" +
                        "budget per person is -" + et_budget.getText().toString()+
                        "\n\n We would like for the following to be included in the itinerary - \n\n";
                details = details + temp;
                int i;
                for (i = 0;i<= page_number; i++){
                    temp = String.format(" %d. Place - %s\n%s to %s\nHotel preference - %s\nActivies to be included - %s\n\n",i+1,
                            places_selected[i],dates_selected[i],dates_selected[i+1],hotels_selected[i],activities_selected[i]);
                    details = details + temp;
                }
                add_details(details);
            }
        });
    }
    public void add_details(final String title_pack){
        AlertDialog.Builder builder2 = new AlertDialog.Builder(Custom_Itinerary.this);
        View layout_view2 = getLayoutInflater().inflate(R.layout.add_people_layout,null);
        Button add_people = (Button) layout_view2.findViewById(R.id.button_add);
        et_date = (EditText) layout_view2.findViewById(R.id.editText_stdate);
        et_date.setVisibility(INVISIBLE);
        tv_dis = (TextView) layout_view2.findViewById(R.id.textView7);
        tv_dis.setVisibility(INVISIBLE);
        et_age = (EditText) layout_view2.findViewById(R.id.editTextage);
        et_name = (EditText) layout_view2.findViewById(R.id.editText_name);
        book_dets = "\n\n The details of the passengers travelling are - \n";
        add_people.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                book_dets = book_dets + et_name.getText().toString() + " of age - " + et_age.getText().toString() + "\n" ;
                et_name.setText("");
                et_age.setText("");
                // Get the text add it to the string..
            }
        });
        Button book_final = (Button)layout_view2.findViewById(R.id.button_book);
        book_final.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                book_dets = book_dets + et_name.getText().toString() + " of age - " + et_age.getText().toString() + "\n";
                sendmessage(title_pack,book_dets);
            }
        });
        builder2.setView(layout_view2);
        AlertDialog alert = builder2.create();
        alert.show();
    }
    @SuppressLint("WrongConstant")
    public void sendmessage(String package_dets,String passenger_dets){

        //package name to be added, people travelling added.
        Intent emailntent = new Intent(Intent.ACTION_SEND);
        emailntent.setType("message/rfc822");
        emailntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"sarrof@yahoo.co.uk"});
        //emailntent.putExtra(Intent.EXTRA_CC, new String[]{"yashrajsarrof18121998@gmail.com"});
        emailntent.putExtra(Intent.EXTRA_SUBJECT,"Booking request ");
        emailntent.putExtra(Intent.EXTRA_TEXT,package_dets + passenger_dets);
        try{
            startActivity(Intent.createChooser(emailntent," Choose Email Client ..."));
        }catch(android.content.ActivityNotFoundException ex){
            Toast.makeText(Custom_Itinerary.this,"NO email clients installed", 0).show();
        }
    }

}
