package com.pristinetravel.pristinetravels;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import static android.view.View.INVISIBLE;
import static android.view.View.VISIBLE;

public class Packages_activity extends AppCompatActivity {
    EditText et_childage,et_child,et_adults,et_rooms,et_date_to,et_date_from;
    Button bt_dub,bt_thai,bt_aus,bt_nz,bt_eu1,bt_eu2,bt_uk,bt_sing;
    Button but_change,but_confirm;
    public String details,title_pack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_packages_activity);
        et_adults = (EditText)findViewById(R.id.et_number_adult);
        et_date_to = (EditText)findViewById(R.id.et_date_to_pack);
        et_date_from = (EditText)findViewById(R.id.et_date_from_pack);
        et_child = (EditText)findViewById(R.id.et_child_pack);
        et_childage = (EditText)findViewById(R.id.et_childage_pack);
        et_rooms = (EditText)findViewById(R.id.et_rooms);
        but_confirm = (Button) findViewById(R.id.but_conf_pack);
        but_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                but_confirm.setVisibility(INVISIBLE);
                but_change.setVisibility( VISIBLE);
                et_childage.setEnabled(false);
                et_child.setEnabled(false);
                et_rooms.setEnabled(false);
                et_adults.setEnabled(false);
                et_date_from.setEnabled(false);
                et_date_to.setEnabled(false);
            }
        });
        bt_thai = (Button) findViewById(R.id.but_Thai);
        bt_thai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String people =" ."+ et_adults.getText().toString() + " adults and " + et_child.getText().toString() + " child(ren) having age " +
                        et_childage.getText().toString() + "will be travelling in lieu of which we will require " + et_rooms.getText().toString() + " rooms." +
                        " We wish to start our journey on "+
                        et_date_from.getText().toString() + " to " + et_date_to.getText().toString();
                details  = getString(R.string.Thailand_pack);
                title_pack = "Thailand Package";
                if(
                        TextUtils.isEmpty(et_adults.getText().toString()) ||
                                TextUtils.isEmpty(et_date_from.getText().toString()) ||
                                TextUtils.isEmpty(et_date_to.getText().toString())
                        )
                    Toast.makeText(Packages_activity.this," First add the number of people going ",0).show();
                else{
                    openDialog(details,people,title_pack);
                }
            }
        });
        bt_sing = (Button) findViewById(R.id.but_Sing);
        bt_sing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String people =" ."+ et_adults.getText().toString() + " adults and " + et_child.getText().toString() + " child(ren) having age " +
                        et_childage.getText().toString() + "will be travelling in lieu of which we will require " + et_rooms.getText().toString() + " rooms." +
                        " We wish to start our journey on "+
                        et_date_from.getText().toString() + " to " + et_date_to.getText().toString();
                details  = getString(R.string.Singapore_pack);
                title_pack = "Singapore package";
                if(
                        TextUtils.isEmpty(et_adults.getText().toString()) ||
                                TextUtils.isEmpty(et_date_from.getText().toString()) ||
                                TextUtils.isEmpty(et_date_to.getText().toString())
                        )
                    Toast.makeText(Packages_activity.this," First add the number of people going ",0).show();
                else{
                    openDialog(details,people,title_pack);
                }
            }
        });
        bt_dub = (Button) findViewById(R.id.but_Dub);
        bt_dub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String people =" ."+ et_adults.getText().toString() + " adults and " + et_child.getText().toString() + " child(ren) having age " +
                        et_childage.getText().toString() + "will be travelling in lieu of which we will require " + et_rooms.getText().toString() + " rooms." +
                        " We wish to start our journey on "+
                        et_date_from.getText().toString() + " to " + et_date_to.getText().toString();
                details  = getString(R.string.Dubai_pack);
                title_pack = "Dubai package";
                if(
                        TextUtils.isEmpty(et_adults.getText().toString()) ||
                                TextUtils.isEmpty(et_date_from.getText().toString()) ||
                                TextUtils.isEmpty(et_date_to.getText().toString())
                        )
                    Toast.makeText(Packages_activity.this," First add the number of people going ",0).show();
                else{
                    openDialog(details,people,title_pack);
                }
            }
        });
        bt_eu1 = (Button) findViewById(R.id.but_Eur1);
        bt_eu1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String people =" ."+ et_adults.getText().toString() + " adults and " + et_child.getText().toString() + " child(ren) having age " +
                        et_childage.getText().toString() + "will be travelling in lieu of which we will require " + et_rooms.getText().toString() + " rooms." +
                        " We wish to start our journey on "+
                        et_date_from.getText().toString() + " to " + et_date_to.getText().toString();
                details = getString(R.string.Europe1_pack);
                title_pack = "Europe 1 package";
                if(
                        TextUtils.isEmpty(et_adults.getText().toString()) ||
                                TextUtils.isEmpty(et_date_from.getText().toString()) ||
                                TextUtils.isEmpty(et_date_to.getText().toString())
                        )
                    Toast.makeText(Packages_activity.this," First add the number of people going ",0).show();
                else{
                    openDialog(details,people,title_pack);
                }
            }
        });
        bt_eu2 = (Button) findViewById(R.id.but_Eur2);
        bt_eu2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String people =" ."+ et_adults.getText().toString() + " adults and " + et_child.getText().toString() + " child(ren) having age " +
                        et_childage.getText().toString() + "will be travelling in lieu of which we will require " + et_rooms.getText().toString() + " rooms." +
                        " We wish to start our journey on "+
                        et_date_from.getText().toString() + " to " + et_date_to.getText().toString();
                details = getString(R.string.Europe2_pack);
                title_pack = "Europe package 2";
                if(
                        TextUtils.isEmpty(et_adults.getText().toString()) ||
                                TextUtils.isEmpty(et_date_from.getText().toString()) ||
                                TextUtils.isEmpty(et_date_to.getText().toString())
                        )
                    Toast.makeText(Packages_activity.this," First add the number of people going ",0).show();
                else{
                    openDialog(details,people,title_pack);
                }
            }
        });
        bt_uk = (Button) findViewById(R.id.but_UK);
        bt_uk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String people =" ."+ et_adults.getText().toString() + " adults and " + et_child.getText().toString() + " child(ren) having age " +
                        et_childage.getText().toString() + "will be travelling in lieu of which we will require " + et_rooms.getText().toString() + " rooms." +
                        " We wish to start our journey on "+
                        et_date_from.getText().toString() + " to " + et_date_to.getText().toString();
                details = getString(R.string.UK_pack);
                title_pack = "UK package";
                if(
                        TextUtils.isEmpty(et_adults.getText().toString()) ||
                                TextUtils.isEmpty(et_date_from.getText().toString()) ||
                                TextUtils.isEmpty(et_date_to.getText().toString())
                        )
                    Toast.makeText(Packages_activity.this," First add the number of people going ",0).show();
                else{
                    openDialog(details,people,title_pack);
                }
            }
        });
        bt_aus = (Button) findViewById(R.id.but_Aus);
        bt_aus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String people =" ."+ et_adults.getText().toString() + " adults and " + et_child.getText().toString() + " child(ren) having age " +
                        et_childage.getText().toString() + "will be travelling in lieu of which we will require " + et_rooms.getText().toString() + " rooms." +
                        " We wish to start our journey on "+
                        et_date_from.getText().toString() + " to " + et_date_to.getText().toString();
                details = getString(R.string.Australia_pack);
                title_pack = "Australia Package";
                if(
                        TextUtils.isEmpty(et_adults.getText().toString()) ||
                                TextUtils.isEmpty(et_date_from.getText().toString()) ||
                                TextUtils.isEmpty(et_date_to.getText().toString())
                        )
                    Toast.makeText(Packages_activity.this," First add the number of people going ",0).show();
                else{
                    openDialog(details,people,title_pack);
                }
            }
        });
        bt_nz = (Button) findViewById(R.id.but_NZ);
        bt_nz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String people =" ."+ et_adults.getText().toString() + " adults and " + et_child.getText().toString() + " child(ren) having age " +
                        et_childage.getText().toString() + "will be travelling in lieu of which we will require " + et_rooms.getText().toString() + " rooms." +
                        " We wish to start our journey on "+
                        et_date_from.getText().toString() + " to " + et_date_to.getText().toString();
                details = getString(R.string.New_Zealand_pack);
                title_pack = "New Zealand package";
                if(
                        TextUtils.isEmpty(et_adults.getText().toString()) ||
                                TextUtils.isEmpty(et_date_from.getText().toString()) ||
                                TextUtils.isEmpty(et_date_to.getText().toString())
                        )
                    Toast.makeText(Packages_activity.this," First add the number of people going ",0).show();
                else{
                    openDialog(details,people,title_pack);
                }
            }
        });
        but_change = (Button) findViewById(R.id.but_change_pack);
        but_change.setVisibility(INVISIBLE);
        but_change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                but_change.setVisibility(INVISIBLE);
                but_confirm.setVisibility( VISIBLE);
                et_childage.setEnabled(true);
                et_child.setEnabled(true);
                et_rooms.setEnabled(true);
                et_adults.setEnabled(true);
                et_date_from.setEnabled(true);
                et_date_to.setEnabled(true);
            }
        });
    }
    public void openDialog(final String package_det, final String dets, final String title_pack){
        AlertDialog.Builder builder = new AlertDialog.Builder(Packages_activity.this);
        View layout_view = getLayoutInflater().inflate(R.layout.dialog_layout,null);
        TextView tv_title = (TextView) layout_view.findViewById(R.id.tV_title);
        TextView tv_message = (TextView) layout_view.findViewById(R.id.tV_message);
        Button but_invis = (Button)  layout_view.findViewById(R.id.but_submit_package);
        but_invis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendmessage(title_pack,dets);
            }
        });
        tv_title.setText(" Pacakage details - ");
        tv_message.setText(package_det);
        builder.setView(layout_view);
        AlertDialog alert = builder.create();
        alert.show();
    }

    public void sendmessage(String pack_dets,String dets){
        String temp = " Hello there, \n This is a message for confirmation of the booking of the package " +
                pack_dets + "\n" + dets;
        //package name to be added, people travelling added.
        Intent emailntent = new Intent(Intent.ACTION_SEND);
        emailntent.setType("message/rfc822");
        emailntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"sarrof@yahoo.co.uk"});
        //emailntent.putExtra(Intent.EXTRA_CC, new String[]{"yashrajsarrof18121998@gmail.com"});
        emailntent.putExtra(Intent.EXTRA_SUBJECT,"Booking request ");
        emailntent.putExtra(Intent.EXTRA_TEXT,temp);
        try{
            startActivity(Intent.createChooser(emailntent," Choose Email Client ..."));
        }catch(android.content.ActivityNotFoundException ex){
            Toast.makeText(Packages_activity.this,"NO email clients installed",0).show();
        }
    }
}
