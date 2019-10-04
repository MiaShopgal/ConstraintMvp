package com.miao.constraintmvp;

import android.view.View;
import android.widget.LinearLayout;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

public class ViewPresenter < V extends ViewContract.FragmentView >
        implements ViewContract.ChartTab < V > {

    private static final String SHRINK_RATION = "H,1:0.6";

    private static final String ENLARGE_RATION = "H,1:0.9";

    private V mFragment;

    private ConstraintLayout mConstraintLayout;

    @Override
    public void onAttach ( V fragmentView ) {

        this.mFragment = fragmentView;
    }

    @Override
    public void onButtonClick ( View view ) {

        switch ( view.getId ( ) ) {
            case R.id.button_more:
                adjustViewSize ( true );
                mFragment.moreButtonClicked ( );
                break;
            case R.id.button_less:
                adjustViewSize ( false );
                mFragment.lessButtonClicked ( );
                break;
        }
    }

    @Override
    public void setupButton ( View rootView ) {

        mConstraintLayout = rootView.findViewById ( R.id.constraint_view );
        LinearLayout buttonParent = rootView.findViewById ( R.id.button_parent );

        for ( int i = 0 ;
              i < buttonParent.getChildCount ( ) ;
              i++ ) {

            buttonParent.getChildAt ( i )
                        .setOnClickListener ( new View.OnClickListener ( ) {

                            @Override
                            public void onClick ( View v ) {

                                onButtonClick ( v );
                            }
                        } );
        }

    }

    @Override
    public void adjustViewSize ( boolean moreItem ) {

        ConstraintSet constraintSet = new ConstraintSet ( );
        constraintSet.clone ( mConstraintLayout );

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

        constraintSet.applyTo ( mConstraintLayout );
    }

}
