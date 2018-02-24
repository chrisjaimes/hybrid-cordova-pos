/*
       Licensed to the Apache Software Foundation (ASF) under one
       or more contributor license agreements.  See the NOTICE file
       distributed with this work for additional information
       regarding copyright ownership.  The ASF licenses this file
       to you under the Apache License, Version 2.0 (the
       "License"); you may not use this file except in compliance
       with the License.  You may obtain a copy of the License at

         http://www.apache.org/licenses/LICENSE-2.0

       Unless required by applicable law or agreed to in writing,
       software distributed under the License is distributed on an
       "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
       KIND, either express or implied.  See the License for the
       specific language governing permissions and limitations
       under the License.
 */

package io.cordova.hellocordova;

import android.os.Bundle;
import org.apache.cordova.*;
import com.squareup.sdk.pos.*;
import android.util.Log;
import android.content.Intent;
import android.widget.EditText;
import android.content.DialogInterface;
import android.content.ActivityNotFoundException;
import com.squareup.sdk.pos.CurrencyCode;
import android.widget.Toast;
import android.content.Context;
import android.webkit.JavascriptInterface;


public class MainActivity extends CordovaActivity
{

    private static final String TAG = "MyCordovaPlugin";
    private PosClient posClient;
    private static final int CHARGE_REQUEST_CODE = 1;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        // enable Cordova apps to be started in the background
        Bundle extras = getIntent().getExtras();
        if (extras != null && extras.getBoolean("cdvStartInBackground", false)) {
            moveTaskToBack(true);
        }

        Log.d("tag", "main created");

        // posClient = PosSdk.createClient(this, "sq0idp-lzPrfz3kBmUhuQfOBvjnRA");
        // ChargeRequest request = new ChargeRequest.Builder(1_00, CurrencyCode.valueOf("USD")).build();
        
        // try {
        //     Intent intent = posClient.createChargeIntent(request);
        //     startActivityForResult(intent, CHARGE_REQUEST_CODE);
        // } catch (ActivityNotFoundException e) {
        //     //showDialog("Error", "Square Point of Sale is not installed", null);
        //     posClient.openPointOfSalePlayStoreListing();
        // }
        
        // Set by <content src="index.html" /> in config.xml
        loadUrl(launchUrl);
    }
}
