package com.miao.constraintmvp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

public class MainActivity
        extends AppCompatActivity {

    @Override
    protected void onCreate ( Bundle savedInstanceState ) {

        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );

        FragmentManager fragmentManager = getSupportFragmentManager ( );
        String tag = "fragment";
        SimpleFragment frag = new SimpleFragment ( );
        fragmentManager.beginTransaction ( )
                       .replace ( R.id.content_frame,
                                  frag,
                                  tag )
                       .addToBackStack ( frag.getClass ( )
                                             .getName ( ) )
                       .commit ( );
    }

}
