package com.example.vishruthkrishnaprasad.deardiary;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by vishruthkrishnaprasad on 22/12/18.
 */

// This class is used to learn if the user has internet access

class ConnectionDetector {

    private Context context;

    ConnectionDetector(Context context) {
        this.context = context;
    }

    boolean isConnectingToInternet() {

        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        assert cm != null;
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null;
    }
}