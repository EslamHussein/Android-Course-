package com.suitepad.sessionone.network;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Eslam Hussein on 3/30/18.
 */

public class NetworkReceiver extends BroadcastReceiver {
    private static final String TAG = "NetworkReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {


        Log.d(TAG, "onReceive() returned: " + intent.getAction());

        Toast.makeText(context, "State "+String.valueOf(isOnline(context)), Toast.LENGTH_SHORT).show();
    }

    public boolean isOnline(Context context) {

        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        //should check null because in airplane mode it will be null
        return (netInfo != null && netInfo.isConnected());
    }
}
