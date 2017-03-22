package com.prac.birdtung.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class PhotoTaken extends AppCompatActivity implements View.OnClickListener{
    Uri imgUri;
    ImageView imv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_taken);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_NOSENSOR);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        imv = (ImageView) findViewById(R.id.imageView2);
        Button phototakenbtn = (Button) findViewById(R.id.PhotoTaken);
        phototakenbtn.setOnClickListener(this);
        Button backmain =(Button) findViewById(R.id.backmain);
        backmain.setOnClickListener(this);
    }

    public void onGet(View v){
//        String dir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).toString();
//        String fname = "p" + System.currentTimeMillis() + ".jpg";//設定為預設位置
//        imgUri = Uri.parse("file://" + dir + "/" + fname);
        Intent phototaken_it = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//        phototaken_it.putExtra(MediaStore.EXTRA_OUTPUT, imgUri);//將Uri加到Intent的額外資料中
        startActivityForResult(phototaken_it, 100);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == Activity.RESULT_OK && requestCode == 100){
            Bundle extras = data.getExtras();
            Bitmap bmp = (Bitmap) extras.get("data");
            imv.setImageBitmap(bmp);
            //imv.setAdjustViewBounds(true);
            //showImage();
        }
        else {
            Toast.makeText(this, "沒有拍到照片", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.PhotoTaken){
            onGet(v);
        }
        else if(v.getId() == R.id.backmain) {
            finish();
        }

    }

    /*void showImage(){
        int iw, ih, vw, vh;
        BitmapFactory.Options option = new BitmapFactory.Options();
        option.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(imgUri.getPath(), option);

        iw = option.outWidth;
        ih = option.outHeight;
        vw = imv.getWidth();
        vh = imv.getHeight();

        int scaleFactor = Math.min(iw/vw, ih/vh);

        option.inJustDecodeBounds = false;
        option.inSampleSize = scaleFactor;
        Bitmap bmp = BitmapFactory.decodeFile(imgUri.getPath(), option);
        imv.setImageBitmap(bmp);

        new AlertDialog.Builder(this).setTitle("圖檔資訊").setMessage("圖檔資訊:"+imgUri.getPath()
                +"\n原始尺寸"+iw+"x"+ih)
                .setNeutralButton("關閉", null)
                .show();
    }*/


}
