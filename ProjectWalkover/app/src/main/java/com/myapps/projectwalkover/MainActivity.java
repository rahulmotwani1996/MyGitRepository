package com.myapps.projectwalkover;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

<<<<<<< HEAD
        android.widget.Toast.makeText(this, "Successfully open!", Toast.LENGTH_SHORT).show();
=======
        Dexter.withActivity(MainActivity.this)
                .withPermission(Manifest.permission.ACCESS_FINE_LOCATION)
                .withListener(new LocationPermissionListener(this))
                .onSameThread()
                .check();






    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch(requestCode)
        {
            case 101: if(resultCode==RESULT_OK)
            {
                Toast.makeText(this, "starting new activity", Toast.LENGTH_SHORT).show();
            }
            break;
        }
    }
}

class LocationPermissionListener implements PermissionListener
{
    private Activity ctx;
    public LocationPermissionListener(Activity ctx) {
        this.ctx = ctx;

    }

    @Override
    public void onPermissionGranted(PermissionGrantedResponse response) {
        Toast.makeText(ctx, "Permission granted", Toast.LENGTH_SHORT).show();


    }

    @Override
    public void onPermissionDenied(final PermissionDeniedResponse response) {
        //do nothing wait for user to agree for permission
        if(response.isPermanentlyDenied())
        {
            Intent intent = new Intent(ctx,Location_Permission_Required.class);
            ctx.startActivityForResult(intent,101);

        }


    }

    @Override
    public void onPermissionRationaleShouldBeShown(PermissionRequest permission, final PermissionToken token) {
            new AlertDialog.Builder(ctx)
                    .setTitle("Location permission required")
                    .setMessage("Permission required to access location for better functioning")
                    .setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            token.cancelPermissionRequest();
                        }
                    })
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            token.continuePermissionRequest();
                        }
                    }).create().show();
>>>>>>> 4f5c2159798a3888bce3800509c2fbe454a456bc
    }
}
