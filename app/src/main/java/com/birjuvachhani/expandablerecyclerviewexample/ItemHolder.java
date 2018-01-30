package com.birjuvachhani.expandablerecyclerviewexample;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

/**
 * Created by birju.vachhani on 30/01/18.
 */

public class ItemHolder {

    private String title;
    private String desc;
    private int ImageId;
    private int backgroundColor;

    public ItemHolder(String title, String desc, int imageId, int backgroundColor) {
        this.title = title;
        this.desc = desc;
        ImageId = imageId;
        this.backgroundColor=backgroundColor;
    }

    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return desc;
    }

    public int getImageId() {
        return ImageId;
    }

    public int getBackgroundColor() {
        return backgroundColor;
    }
}
