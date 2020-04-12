package com.example.chucknorrisassignment;

import Helper.Helper;
import Models.ChuckNorris;
import Models.Value;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ThemedSpinnerAdapter;

import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {

    private String API_URL = "https://api.chucknorris.io/jokes/random";

    Button btnJoke;
    TextView txtJoke;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtJoke = (TextView)findViewById(R.id.txtJoke);
        btnJoke = (Button)findViewById(R.id.btnJoke);

        btnJoke.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View v) {
                                           AsyncTask<String, Void, String> asynctask = new AsyncTask<String, Void, String>() {


                                               ProgressDialog mDialog = new ProgressDialog(MainActivity.this);

                                               @Override
                                               protected void onPreExecute() {
                                                   mDialog.setTitle("The screen is loading...");
                                                   mDialog.show();
                                               }

                                               @Override
                                               protected String doInBackground(String... strings) {
                                                   Helper helper = new Helper();
                                                   return helper.getHTTPData(API_URL);
                                               }

                                               @Override
                                               protected void onPostExecute(String s) {
                                               mDialog.dismiss();
                                                   ChuckNorris chuckNorris = new Gson().fromJson(s, ChuckNorris.class);
                                                   txtJoke.setText(ChuckNorris.id);
                                              if (txtJoke.getVisibility() == View.INVISIBLE) txtJoke.setVisibility(View.VISIBLE);

                                               }
                                           };
                                           asynctask.execute();

                                       }
                                   }

            ) ;
    }
}
