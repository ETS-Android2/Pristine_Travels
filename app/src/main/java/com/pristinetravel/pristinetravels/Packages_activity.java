package com.pristinetravel.pristinetravels;

import android.annotation.SuppressLint;
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
    Button bt_amer,bt_thai,bt_aus,bt_nz,bt_eu1,bt_eu2,bt_uk,bt_sing;
    EditText et_age,et_name,et_date ;
    public String details,title_pack,book_dets;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_packages_activity);
        bt_thai = (Button) findViewById(R.id.but_thai);
        bt_thai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                details  = getString(R.string.Thailand_pack);
                title_pack = "Thailand Package";
                openDialog(details,title_pack);
            }
        });
        bt_sing = (Button) findViewById(R.id.but_Sing);
        bt_sing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                details  = getString(R.string.Singapore_pack);
                title_pack = "Singapore package";
                openDialog(details,title_pack);
            }
        });
        bt_amer = (Button) findViewById(R.id.but_Amer);
        bt_amer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                details  = getString(R.string.America1_pack);
                title_pack = "America Package";
                openDialog(details,title_pack);
            }
        });
        bt_eu1 = (Button) findViewById(R.id.but_Eur1);
        bt_eu1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                details = getString(R.string.Europe1_pack);
                title_pack = "Europe 1 package";
                openDialog(details,title_pack);
            }
        });
        bt_eu2 = (Button) findViewById(R.id.but_Eur2);
        bt_eu2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                details = getString(R.string.Europe2_pack);
                title_pack = "Europe package 2";
                openDialog(details,title_pack);
            }
        });
        bt_uk = (Button) findViewById(R.id.but_UK);
        bt_uk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                details = getString(R.string.UK_pack);
                title_pack = "UK package";
                openDialog(details,title_pack);

            }
        });
        bt_aus = (Button) findViewById(R.id.but_Aus);
        bt_aus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                details = getString(R.string.Australia_pack);
                title_pack = "Australia Package";
                openDialog(details,title_pack);
            }
        });
        bt_nz = (Button) findViewById(R.id.but_nz);
        bt_nz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                details = getString(R.string.New_Zealand_pack);
                title_pack = "New Zealand package";
                    openDialog(details,title_pack);
            }
        });
    }
    public void openDialog(final String package_det, final String title_pack){
        AlertDialog.Builder builder = new AlertDialog.Builder(Packages_activity.this);
        View layout_view = getLayoutInflater().inflate(R.layout.dialog_layout,null);
        TextView tv_title = (TextView) layout_view.findViewById(R.id.tV_title);
        TextView tv_message = (TextView) layout_view.findViewById(R.id.tV_message);
        Button but_invis = (Button)  layout_view.findViewById(R.id.but_submit_package);
        but_invis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                add_details(title_pack);
            }
        });
        tv_title.setText(" Pacakage details - ");
        tv_message.setText(package_det);
        builder.setView(layout_view);
        AlertDialog alert = builder.create();
        alert.show();
    }
    public void add_details(String title_pack){

        AlertDialog.Builder builder2 = new AlertDialog.Builder(Packages_activity.this);
        View layout_view2 = getLayoutInflater().inflate(R.layout.add_people_layout,null);
        Button add_people = (Button) layout_view2.findViewById(R.id.button_add);
        et_age = (EditText) layout_view2.findViewById(R.id.editTextage);
        et_name = (EditText) layout_view2.findViewById(R.id.editText_name);
        et_date = (EditText) layout_view2.findViewById(R.id.editText_stdate);
        book_dets = "This is a message for the request of the booking of the package offered by you in your app  " +
                title_pack + "\n" + "\n The details of "+
                " the passengers travelling are - \n";
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
                book_dets = book_dets + et_name.getText().toString() + " of age - " + et_age.getText().toString() + "\n"+
                    " We would like to start on  " + et_date.getText().toString();
                sendmessage(book_dets);
            }
        });
        builder2.setView(layout_view2);
        AlertDialog alert = builder2.create();
        alert.show();
    }

    @SuppressLint("WrongConstant")
    public void sendmessage(String pack_dets){

        //package name to be added, people travelling added.
        Intent emailntent = new Intent(Intent.ACTION_SEND);
        emailntent.setType("message/rfc822");
        emailntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"sarrof@yahoo.co.uk"});
        //emailntent.putExtra(Intent.EXTRA_CC, new String[]{"yashrajsarrof18121998@gmail.com"});
        emailntent.putExtra(Intent.EXTRA_SUBJECT,"Booking request ");
        emailntent.putExtra(Intent.EXTRA_TEXT,pack_dets);
        try{
            startActivity(Intent.createChooser(emailntent," Choose Email Client ..."));
        }catch(android.content.ActivityNotFoundException ex){
            Toast.makeText(Packages_activity.this,"NO email clients installed", 0).show();
        }
    }
}
