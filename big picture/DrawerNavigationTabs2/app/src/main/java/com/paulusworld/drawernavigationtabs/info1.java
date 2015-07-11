package com.paulusworld.drawernavigationtabs;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.net.URL;
import java.util.ArrayList;

import static com.paulusworld.drawernavigationtabs.R.id.*;

/**
 * Created by vinay on 18/3/15.
 */
public class info1 extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info);

        //define the all data from the view

        TextView mname=(TextView)findViewById(R.id.movienames);
        TextView verdict=(TextView)findViewById(R.id.verdict);

        ImageView i=(ImageView)findViewById(R.id.imageView);

        TextView director=(TextView)findViewById(R.id.director);
        TextView G=(TextView)findViewById(R.id.genre);
        TextView music=(TextView)findViewById(R.id.Music);

        TextView cast=(TextView)findViewById(R.id.cast);

        TextView description=(TextView)findViewById(R.id.description);

        String t1="";
        String genreT="";
        String thumbnail_url = getIntent().getExtras().getString("thumbnail_url");
        ArrayList<String> genre = getIntent().getExtras().getStringArrayList("genre");
        double rating = getIntent().getExtras().getDouble("rating");
        String title = getIntent().getExtras().getString("title");

        for (int j = 0; j < genre.size(); j++) {
             t1 = genre.get(j);
              G.append(t1);
            if(j - genre.size() != -1){
                G.append(",");
            }
        }

mname.append(title);
        Toast.makeText(getApplicationContext(),thumbnail_url + "\n" + genreT + "\n" + rating,Toast.LENGTH_LONG).show();


    }


    }




