package com.example.hamza.finalyearproject;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import static android.R.attr.data;

public class ComplainSubmision extends AppCompatActivity {

    AutoCompleteTextView townTextView,complainTypetextView;
    EditText unioncouncils,desc;
    Button complainNextButton;
    private static final int IMAGE_REQUEST = 1888;
    DBHelper complainDB;
    SQLiteDatabase db;



    String[] towns ={"Baldia Town","Bin Qasim Town","Kimari Town","Korangi Town","New karachi Town","North Nazimabad Town","Gadap Town","Gulshan Town",
            "Gulberg Town","Landhi town","Lyari town","Liaquatabad town","Orangi Town","Jamshed town","Malir town","Sadar Town",
            "Shah faisal Town","SITE town"};
    String[] complainTypes = {"Complain1","Complain2","Complain3","Complain4","Complain5","Complain6"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit_complain);

        complainDB = new DBHelper(this);

        //fetchingID's
        unioncouncils = (EditText)findViewById(R.id.ucField);
        desc = (EditText) findViewById(R.id.descField);
        townTextView = (AutoCompleteTextView) findViewById(R.id.townfield);
        complainTypetextView = (AutoCompleteTextView) findViewById(R.id.complainlist);
        complainNextButton = (Button) findViewById(R.id.button_next);



//Parsing UnionCouncilEdit Text To int




        //Item Town List Autocomplete TextvIew

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.select_dialog_item,towns);
        townTextView.setAdapter(arrayAdapter);
        townTextView.setThreshold(1);
        final String text = townTextView.getText().toString();
        Log.v("MyActivity",text);


        //ComplainType List


        ArrayAdapter<String> complainTypesadapter = new ArrayAdapter<String>(this,android.R.layout.select_dialog_item,complainTypes);
        complainTypetextView.setAdapter(complainTypesadapter);
        complainTypetextView.setThreshold(1);

        ImageView cameraIntent = (ImageView) findViewById(R.id.camera);
        cameraIntent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dbmanager = new Intent(ComplainSubmision.this,AndroidDatabaseManager.class);
                startActivity(dbmanager);
            }
        });
        //Camera Intent
      /**  ImageView cameraIntent = (ImageView) findViewById(R.id.camera);
      cameraIntent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,IMAGE_REQUEST );
            }
        });**/

        //NextButton Of Complainsubmision



        insertData();


        }


    public void insertData()



    {
        complainNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




                Boolean isInserted =  complainDB.insertComplain(townTextView.getText().toString(),unioncouncils.getText().toString(),
                        complainTypetextView.getText().toString(),desc.getText().toString());





                if(isInserted)
                {
                    Toast.makeText(getApplicationContext(),"Inserted",Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getApplicationContext(), "Not Inserted", Toast.LENGTH_SHORT).show();
                }


            }
        });

    }


    //On camera Intent Result
/**
    protected void onActivityResult(int requestCode,int resultCode,Intent intent)
    {
        if(requestCode==IMAGE_REQUEST && resultCode == Activity.RESULT_OK)

        {
          //  http://stackoverflow.com/questions/5991319/capture-image-from-camera-and-display-in-activity
        }
    }**/
}
