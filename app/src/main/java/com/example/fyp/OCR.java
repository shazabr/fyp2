package com.example.fyp;

import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.google.firebase.ml.vision.common.FirebaseVisionImage;

public class OCR extends AppCompatActivity {

    private static final int imgrequest = 1;

    private Button uploadimg;
    private Button importimg;
    private ImageView imageview;

    private Uri imgURI;

   // private StorageReference = mStorageRef

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ocr);

        uploadimg = findViewById(R.id.euploadimg);
        importimg = findViewById(R.id.eimport);
        imageview = findViewById(R.id.eimageview);

     //   mStorageRef = FirebaseStorage.getInstance().getReference("uploadedimg");


        importimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              importImage();
            }
        });

        uploadimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == imgrequest && resultCode == RESULT_OK && data != null && data.getData() != null) {
            imgURI = data.getData();

            imageview.setImageURI(imgURI);
        }
    }

    private void importImage() {
        Intent intent = new Intent();
        intent.setType("image/*"); // limiting to only image file types when choosing
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, imgrequest);

  //      private String getFileExtension (Uri uri) {
    //        ContentResolver econtent = new ContentResolver() {

            }
        }

//    }
//}


// addoing delete later
