package com.birjuvachhani.expandablerecyclerviewexample;


import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.Collections;
import java.util.List;

/**
 * Created by birju.vachhani on 30/01/18.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> {

    private LayoutInflater inflater;
    private Context context;
    List<ItemHolder> mlist = Collections.emptyList();

    public RecyclerAdapter(Context context, List<ItemHolder> mlist) {
        inflater = LayoutInflater.from(context);
        this.context = context;
        this.mlist = mlist;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.group_view, parent, false);
        RecyclerViewHolder holder = new RecyclerViewHolder(context, view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        ItemHolder itemHolder = mlist.get(position);
        holder.bind(itemHolder);
    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }


    class RecyclerViewHolder extends RecyclerView.ViewHolder {

        ImageView mimg;
        TextView mtitle;
        TextView mdesc;
        Context context;
        LinearLayout container, child;
        ImageView arrow;

        public RecyclerViewHolder(final Context context, final View itemView) {
            super(itemView);
            this.context = context;
            mimg = (ImageView) itemView.findViewById(R.id.iv_image);
            mtitle = (TextView) itemView.findViewById(R.id.tv_title);
            mdesc = (TextView) itemView.findViewById(R.id.tv_desc);
            container = (LinearLayout) itemView.findViewById(R.id.container);
            arrow = (ImageView) itemView.findViewById(R.id.arrow);
            child = (LinearLayout) itemView.findViewById(R.id.child);

            arrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (child.getVisibility() == View.GONE) {
                        ObjectAnimator.ofFloat(arrow, "rotation", 0, 180).start();
                        child.setVisibility(View.VISIBLE);

                    } else {
                        child.setVisibility(View.GONE);
                        ObjectAnimator.ofFloat(arrow, "rotation", 180, 0).start();
                        arrow.setImageResource(R.drawable.ic_keyboard_arrow_down_white_36dp);
                    }
                }
            });
        }

        public void bind(ItemHolder itemHolder) {
            Picasso.with(context).load(itemHolder.getImageId()).centerCrop().fit().into(mimg);
            mtitle.setText(itemHolder.getTitle());
            mdesc.setText(itemHolder.getDesc());
            container.setBackgroundColor(itemHolder.getBackgroundColor());
        }
    }
}
