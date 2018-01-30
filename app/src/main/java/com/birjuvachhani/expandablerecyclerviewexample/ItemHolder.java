package com.birjuvachhani.expandablerecyclerviewexample;

/**
 * Created by birju.vachhani on 30/01/18.
 */

public class ItemHolder {

    private String title;
    private String desc;
    private int ImageId;

    public ItemHolder(String title, String desc, int imageId) {
        this.title = title;
        this.desc = desc;
        ImageId = imageId;
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
}
