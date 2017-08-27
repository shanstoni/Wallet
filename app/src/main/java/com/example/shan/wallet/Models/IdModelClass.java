package com.example.shan.wallet.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by shan on 27.08.2017.
 */

public class IdModelClass {

    @SerializedName("Id")
    @Expose
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
