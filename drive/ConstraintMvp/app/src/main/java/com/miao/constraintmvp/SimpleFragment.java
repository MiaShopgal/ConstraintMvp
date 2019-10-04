package com.miao.constraintmvp;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class SimpleFragment
        extends Fragment
        implements ViewContract.FragmentView {

    public SimpleFragment ( ) {
        // Required empty public constructor
    }


    @Override
    public View onCreateView ( LayoutInflater inflater,
                               ViewGroup container,
                               Bundle savedInstanceState ) {
        // Inflate the layout for this fragment
        View view = inflater.inflate ( R.layout.fragment_simple,
                                       container,
                                       false );
        ViewPresenter < SimpleFragment > viewPresenter = new ViewPresenter <> ( );
        viewPresenter.onAttach ( this );
        viewPresenter.setupButton ( view );

        return view;
    }


    @Override
    public void moreButtonClicked ( ) {

        Toast.makeText ( getContext ( ),
                         "Showing more item",
                         Toast.LENGTH_SHORT )
             .show ( );
    }

    @Override
    public void lessButtonClicked ( ) {

        Toast.makeText ( getContext ( ),
                         "Showing less item",
                         Toast.LENGTH_SHORT )
             .show ( );
    }

}
