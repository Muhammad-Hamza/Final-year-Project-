package com.example.hamza.finalyearproject;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;

import static android.R.attr.data;

public class ComplainSubmision extends AppCompatActivity {

    private static final int IMAGE_REQUEST = 1888;



    String[] towns ={"Baldia Town","Bin Qasim Town","Kimari Town","Korangi Town","New karachi Town","North Nazimabad Town","Gadap Town","Gulshan Town",
            "Gulberg Town","Landhi town","Lyari town","Liaquatabad town","Orangi Town","Jamshed town","Malir town","Sadar Town",
            "Shah faisal Town","SITE town"};
    String[] complainTypes = {"Complain1","Complain1","Complain1","Complain1","Complain1","Complain1"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit_complain);


        //Item Town List Autocomplete TextvIew
        AutoCompleteTextView textView = (AutoCompleteTextView) findViewById(R.id.townfield);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.select_dialog_item,towns);
        textView.setAdapter(arrayAdapter);
        textView.setThreshold(1);

        //ComplainType List

        AutoCompleteTextView compTypes = (AutoCompleteTextView) findViewById(R.id.complainlist);
        ArrayAdapter<String> complainTypesadapter = new ArrayAdapter<String>(this,android.R.layout.select_dialog_item,complainTypes);
        compTypes.setAdapter(complainTypesadapter);
        compTypes.setThreshold(1);

        //Camera Intent
        ImageView cameraIntent = (ImageView) findViewById(R.id.camera);
        cameraIntent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,IMAGE_REQUEST );
            }
        });

        //NextButton Of Complainsubmision
        Button complainNextButton = (Button) findViewById(R.id.button_next);
        complainNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ComplainSubmision.this,ComplainSubmisionAuthentication.class);
                startActivity(intent);
            }
        });



    }

    //On camera Intent Result

    protected void onActivityResult(int requestCode,int resultCode,Intent intent)
    {
        if(requestCode==IMAGE_REQUEST && resultCode == Activity.RESULT_OK)

        {
          //  http://stackoverflow.com/questions/5991319/capture-image-from-camera-and-display-in-activity
        }
    }
}
