package com.example.broadcastbestpractice;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class ForceOffLineReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(final Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        /*AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("warning");
        builder.setMessage("You are forced to be offline .Please try to login again.");
        builder.setCancelable(false);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                ActivityCollector.finishAll();
                Intent i = new Intent(context,LoginActivity.class);
                context.startActivity(i);
            }
        });
        builder.show();*/
        Toast.makeText(context, "force offline", Toast.LENGTH_SHORT).show();

    }

}
