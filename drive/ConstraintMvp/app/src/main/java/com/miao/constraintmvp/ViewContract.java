package com.miao.constraintmvp;

import android.view.View;

public interface ViewContract {


    interface ChartTab < V extends FragmentView > {

        void onAttach ( V fragmentView );

        void onButtonClick ( View view );

        void setupButton ( View rootView );

        void adjustViewSize ( boolean enable );

    }

    interface FragmentView {

        void moreButtonClicked ( );

        void lessButtonClicked ( );

    }

}
