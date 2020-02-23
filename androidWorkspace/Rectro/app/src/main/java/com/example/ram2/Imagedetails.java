package com.example.ram2;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Imagedetails extends Activity {
    private ImageView imageView, like, download, share;
    private TextView counter;


    @SuppressLint("WrongThread")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.image_show);
        imageView = findViewById(R.id.imageview);
        counter = findViewById(R.id.counter);
        // Toast.makeText(this, getIntent().getStringExtra("url"), Toast.LENGTH_SHORT).show();
        Glide.with(Imagedetails.this).load(getIntent().getStringExtra("https://reqres.in/api/users?page=1")).into(imageView);


        like = findViewById(R.id.like);
//
        like.setOnClickListener(new View.OnClickListener() {
            private int count;

            @Override
            public void onClick(View v) {
                count++;
                counter.setText(Integer.toString(count));
                Toast.makeText(Imagedetails.this, " Thank You!!", Toast.LENGTH_SHORT).show();

                if (count >= 1) {
                    count--;
                    //counter.setText(Integer.toString(count));
                    Toast.makeText(Imagedetails.this, " dont like  twice!", Toast.LENGTH_SHORT).show();

                }

            }

        });

        share = findViewById(R.id.share);
        share.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                Dexter.withActivity(Imagedetails.this)
                        .withPermission(Manifest.permission.CAMERA)
                        .withListener(new PermissionListener() {
                            @Override public void onPermissionGranted(PermissionGrantedResponse response) {/* ... */}
                            @Override public void onPermissionDenied(PermissionDeniedResponse response) {/* ... */}
                            @Override public void onPermissionRationaleShouldBeShown(PermissionRequest permission, PermissionToken token) {/* ... */}
                        }).check();

                Intent myIntent = new Intent(Intent.ACTION_SEND);
            myIntent.setType("text/plane");
            String shareBody = "Internal Storage/dcim/my image/";
            String shareSub = "image";
            myIntent.putExtra(Intent.EXTRA_SUBJECT, shareSub);
            myIntent.putExtra(Intent.EXTRA_TEXT, shareBody);
            startActivity(Intent.createChooser(myIntent, "share using"));



            }
        });



        download = findViewById(R.id.download);
        download.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                FileOutputStream fileOutputStream = null;
                File file = getdisc();
                if (!file.exists() && !file.mkdirs()) {
                    Toast.makeText(getApplicationContext(), "sorry can not make dir", Toast.LENGTH_LONG).show();
                    return;
                }
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyymmsshhmmss");
                String date = simpleDateFormat.format(new Date());
                String name = "img" + date + ".jpeg";
                String file_name = file.getAbsolutePath() + "/" + name;
                File new_file = new File(file_name);
                try {
                    fileOutputStream = new FileOutputStream(new_file);
                    Bitmap bitmap = viewToBitmap(imageView, imageView.getWidth(), imageView.getHeight());
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
                    Toast.makeText(getApplicationContext(), "download successfully", Toast.LENGTH_LONG).show();
                    fileOutputStream.flush();
                    fileOutputStream.close();
                } catch
                (FileNotFoundException e) {

                } catch (IOException e) {

                }
                refreshGallary(file);
            }

            private void refreshGallary(File file) {
                Intent i = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
                i.setData(Uri.fromFile(file));
                sendBroadcast(i);
            }

            private File getdisc() {
                File file = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
                return new File(file, "My Image");
            }
        });
    }

    private static Bitmap viewToBitmap(View view, int widh, int hight) {
        Bitmap bitmap = Bitmap.createBitmap(widh, hight, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        view.draw(canvas);
        return bitmap;
    }
}