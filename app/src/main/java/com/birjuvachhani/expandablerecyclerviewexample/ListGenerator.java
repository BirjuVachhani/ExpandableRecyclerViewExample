package com.birjuvachhani.expandablerecyclerviewexample;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.support.v7.graphics.Palette;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by birju.vachhani on 30/01/18.
 */

public class ListGenerator {

    Context context;
    String[] titles;
    String[] desc;
    int[] images = {R.drawable.img1, R.drawable.img2, R.drawable.img3, R.drawable.img4, R.drawable.img5, R.drawable.img6, R.drawable.img7, R.drawable.img8};

    public ListGenerator(Context context) {
        this.context = context;
        this.titles = context.getResources().getStringArray(R.array.titles);
        this.desc = context.getResources().getStringArray(R.array.descriptions);
    }

    protected List<ItemHolder> generate() {
        List<ItemHolder> mlist = new ArrayList<>();

        for (int i = 0; i < titles.length && i < desc.length && i < images.length; i++) {
            Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), images[i]);
            int color = context.getResources().getColor(R.color.default_bg);

            if (Build.VERSION.SDK_INT >= 21) {
                Palette palette = Palette.from(bitmap).generate();
                color = palette.getDarkVibrantColor(color);
            }
            bitmap.recycle();
            bitmap = null;
            ItemHolder itemHolder = new ItemHolder(titles[i], desc[i], images[i], color);
            mlist.add(itemHolder);
        }
        return mlist;
    }
}
