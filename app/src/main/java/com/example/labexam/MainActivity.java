
package com.example.labexam;
import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button b1,b2;

        b1 = (Button)this.findViewById(R.id.button_openURL);
        b2 = (Button) findViewById(R.id.button_sendEmail);

        b1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                String url = "https://www.google.com/";
                Uri uri = Uri.parse(url);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);

//                openURL('https://www.google.com/');
                // Here we use an intent without a Chooser unlike the next example
                // start the
                startActivity(intent);

            }
        });

        b2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                String[] recipients = new String[]{"swagatkumarsamantaray@vitbhopal.ac.in"};
                String Subject = "20BCE10072";
                String content = "Have a Nice Day and Welcome to VIT Bhopal";
                Intent intentEmail = new Intent(Intent.ACTION_SEND, Uri.parse("mailto:"));
                intentEmail.putExtra(Intent.EXTRA_EMAIL,recipients);
                intentEmail.putExtra(Intent.EXTRA_SUBJECT,Subject);
                intentEmail.putExtra(Intent.EXTRA_TEXT,content);
                intentEmail.setType("text/plain");

                startActivity(Intent.createChooser(intentEmail,"Choose an email client from...."));





            }
        });
    }
}
