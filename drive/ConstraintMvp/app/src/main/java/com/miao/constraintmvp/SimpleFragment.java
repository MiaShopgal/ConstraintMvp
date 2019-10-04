package com.miao.constraintmvp;


import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class SimpleFragment
        extends Fragment
        implements View.OnClickListener {


    private static final String SHRINK_RATION = "H,1:0.6";

    private static final String ENLARGE_RATION = "H,1:0.9";

    private ConstraintLayout mConstraintView;

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
        mConstraintView = view.findViewById ( R.id.constraint_view );

        view.findViewById ( R.id.button_more )
            .setOnClickListener ( this );
        view.findViewById ( R.id.button_less )
            .setOnClickListener ( this );

        return view;
    }

    @Override
    public void onClick ( View v ) {

        switch ( v.getId ( ) ) {
            case R.id.button_more:
                adjustViewSize ( true );
                break;
            case R.id.button_less:
                adjustViewSize ( false );
                break;
        }
    }

    private void adjustViewSize ( boolean moreItem ) {

        ConstraintSet constraintSet = new ConstraintSet ( );
        constraintSet.clone ( mConstraintView );

        if ( moreItem ) {

            constraintSet.setVisibility ( R.id.view_2,
                                          View.VISIBLE );
            constraintSet.setDimensionRatio ( R.id.view_1,
                                              SHRINK_RATION );
        }
        else {

            constraintSet.setVisibility ( R.id.view_2,
                                          View.GONE );
            constraintSet.setDimensionRatio ( R.id.view_1,
                                              ENLARGE_RATION );
        }

        constraintSet.applyTo ( mConstraintView );
    }

}
