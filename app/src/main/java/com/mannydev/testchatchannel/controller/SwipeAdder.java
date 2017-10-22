package com.mannydev.testchatchannel.controller;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.DisplayMetrics;
import android.view.View;

import com.mannydev.testchatchannel.R;
import com.mannydev.testchatchannel.model.Channel;
import com.mannydev.testchatchannel.view.MyChannelAdapter;

import java.util.List;

/**
 * Created by manny on 21.10.17.
 */

public class SwipeAdder {
    Context context;
    public SwipeAdder() {

    }

    public void addSwipes(RecyclerView rv, final MyChannelAdapter adapter, final List<Channel> list){
        ItemTouchHelper.SimpleCallback simpleCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false;
            }

            public static final float ALPHA_FULL = 1.0f;

            public void onChildDraw(Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {

                context = recyclerView.getContext();

                if(viewHolder.getItemViewType()!=-1){
                    if (actionState == ItemTouchHelper.ACTION_STATE_SWIPE) {
                        View itemView = viewHolder.itemView;
                        Paint p = new Paint();
                        Bitmap icon = BitmapFactory.decodeResource(context.getResources(), R.mipmap.ic_delete_white_24dp);
                        p.setColor(context.getResources().getColor(R.color.dark_sky_blue));

                        if (dX > 0) {

                            c.drawRect((float) itemView.getLeft(), (float) itemView.getTop(), dX,
                                    (float) itemView.getBottom(), p);

                            c.drawBitmap(icon,
                                    (float) itemView.getLeft() + convertDpToPx(16),
                                    (float) itemView.getTop() + ((float) itemView.getBottom() - (float) itemView.getTop() - icon.getHeight())/2,
                                    p);
                        } else {

                            c.drawRect((float) itemView.getRight() + dX, (float) itemView.getTop(),
                                    (float) itemView.getRight(), (float) itemView.getBottom(), p);

                            c.drawBitmap(icon,
                                    (float) itemView.getRight() - convertDpToPx(16) - icon.getWidth(),
                                    (float) itemView.getTop() + ((float) itemView.getBottom() - (float) itemView.getTop() - icon.getHeight())/2,
                                    p);
                        }

                        final float alpha = ALPHA_FULL - Math.abs(dX) / (float) viewHolder.itemView.getWidth();
                        viewHolder.itemView.setAlpha(alpha);
                        viewHolder.itemView.setTranslationX(dX);

                    } else {
                        super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
                    }
                }
            }
            private int convertDpToPx(int dp){
                return Math.round(dp * (context.getResources().getDisplayMetrics().xdpi / DisplayMetrics.DENSITY_DEFAULT));
            }

            @Override
            public void onSwiped(final RecyclerView.ViewHolder viewHolder, int direction) {
                final int position = viewHolder.getAdapterPosition();

                if(direction == ItemTouchHelper.RIGHT){
                    list.remove(position);
                    adapter.notifyItemRemoved(position);


                }else if(direction==ItemTouchHelper.LEFT){
                    list.remove(position);
                    adapter.notifyItemRemoved(position);
                }

            }
        };
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleCallback);
        itemTouchHelper.attachToRecyclerView(rv);
    }
}
