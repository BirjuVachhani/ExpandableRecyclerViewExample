package com.birjuvachhani.expandablerecyclerviewexample;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by birju.vachhani on 30/01/18.
 */

public class ListGenerator {

    String[] titles;
    String[] desc;
    int[] images = {R.drawable.img1, R.drawable.img2, R.drawable.img3, R.drawable.img4, R.drawable.img5, R.drawable.img6, R.drawable.img7, R.drawable.img8};

    public ListGenerator(Context context) {
        this.titles = context.getResources().getStringArray(R.array.titles);
        this.desc = context.getResources().getStringArray(R.array.descriptions);
    }

    protected List<ItemHolder> generate() {
        List<ItemHolder> mlist = new ArrayList<>();

        for (int i = 0; i < titles.length && i < desc.length && i < images.length; i++) {
            ItemHolder itemHolder = new ItemHolder(titles[i], desc[i], images[i]);
            mlist.add(itemHolder);
        }
        return mlist;
    }
}
