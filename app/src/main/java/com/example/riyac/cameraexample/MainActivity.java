package com.example.riyac.cameraexample;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import static android.R.attr.bitmap;
import static android.R.attr.data;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView) findViewById(R.id.imageView);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, 1888);   //for camera, its 1888 or 1889
            }

        });
    }
        public void onActivityResult(int requestCode, int resultCode, Intent data) {
            if (requestCode == 1888) {
                Bitmap bitmap = (Bitmap) data.getExtras().get("data");
                imageView.setImageBitmap(bitmap);
            }

        }


}
