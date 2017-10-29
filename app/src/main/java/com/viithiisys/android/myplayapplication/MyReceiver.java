package com.viithiisys.android.myplayapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by anuragdhunna on 26/10/17.
 */

public class MyReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "IntentDetected", Toast.LENGTH_LONG).show();
    }


}
