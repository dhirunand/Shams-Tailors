package com.dhirunand.shamstailors;

import android.graphics.Bitmap;
import android.widget.ImageView;

import java.io.Serializable;

public class ItemMeasurementContainer implements Cloneable, Serializable {
    private String itemName;
    private String deliveryDate;
    private String length;
    private String neck;
    private String shoulder;
    private String chest;
    private String waist;
    private String seat;
    private String sleeves;
    private String sleeveCircum;
    private transient Bitmap itemImageBitmap;

    public ItemMeasurementContainer(String itemName, String deliveryDate, String length, String neck, String shoulder, String chest, String waist, String seat, String sleeves, String sleeveCircum, Bitmap itemImageBitmap) {
        this.itemName = itemName;
        this.deliveryDate = deliveryDate;
        this.length = length;
        this.neck = neck;
        this.shoulder = shoulder;
        this.chest = chest;
        this.waist = waist;
        this.seat = seat;
        this.sleeves = sleeves;
        this.sleeveCircum = sleeveCircum;
        this.itemImageBitmap = itemImageBitmap;
    }

    public String getLength() {
        return length;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getNeck() {
        return neck;
    }

    public void setNeck(String neck) {
        this.neck = neck;
    }

    public String getShoulder() {
        return shoulder;
    }

    public void setShoulder(String shoulder) {
        this.shoulder = shoulder;
    }

    public String getChest() {
        return chest;
    }

    public void setChest(String chest) {
        this.chest = chest;
    }

    public String getWaist() {
        return waist;
    }

    public void setWaist(String waist) {
        this.waist = waist;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public String getSleeves() {
        return sleeves;
    }

    public void setSleeves(String sleeves) {
        this.sleeves = sleeves;
    }

    public String getSleeveCircum() {
        return sleeveCircum;
    }

    public void setSleeveCircum(String sleeveCircum) {
        this.sleeveCircum = sleeveCircum;
    }

    public Bitmap getItemImageBitmap() {
        return itemImageBitmap;
    }

    public void setItemImageBitmap(Bitmap itemImageBitmap) {
        this.itemImageBitmap = itemImageBitmap;
    }
}
