package com.mannydev.testchatchannel.view;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by manny on 21.10.17.
 */


public class SpacesItemDecoration extends RecyclerView.ItemDecoration {
    private int space;

    public SpacesItemDecoration(int space) {
        this.space = space;
    }
    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        int lastIndex = parent.getChildCount()-1;

        if(parent.getChildAdapterPosition(view)==lastIndex){
            outRect.bottom=space;
        }

        if(parent.getChildAdapterPosition(view) == 0){
            outRect.top = space;
        }
    }
}
