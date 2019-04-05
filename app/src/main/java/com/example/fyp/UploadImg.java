package com.example.fyp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class UploadImg extends AppCompatActivity {


    private String simageurl;

    public class imgUrl {

    }

    public UploadImg() {

    }


    public UploadImg(String imageurl) {
        simageurl = imageurl;
    }

    public String getImageUrl() {
        return simageurl;
    }

    public void setImageUrl(String imageurl) {
       simageurl = imageurl;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_img);
    }
}
