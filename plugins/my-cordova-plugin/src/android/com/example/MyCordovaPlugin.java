/**
 */
package com.example;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.PluginResult;
import org.apache.cordova.PluginResult.Status;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;
import android.widget.Toast;

import android.os.Bundle;
import org.apache.cordova.*;
import com.squareup.sdk.pos.*;
import android.util.Log;
import android.content.Intent;
import android.widget.EditText;
import android.content.DialogInterface;
import android.content.ActivityNotFoundException;
import com.squareup.sdk.pos.CurrencyCode;
import android.content.Context;

import android.util.Log;

import java.util.Date;

public class MyCordovaPlugin extends CordovaPlugin {
 
  private static final String TAG = "MyCordovaPlugin";
  private PosClient posClient;
  private static final int CHARGE_REQUEST_CODE = 1;

  public void initialize(CordovaInterface cordova, CordovaWebView webView) {
    super.initialize(cordova, webView);

    Log.d(TAG, "Initializing MyCordovaPlugin!");
  }

  public boolean execute(String action, JSONArray args, final CallbackContext callbackContext) throws JSONException {

    Log.d(TAG, "Execute()");

    if(action.equals("echo")) {

      posClient = PosSdk.createClient(cordova.getActivity(), "sq0idp-lzPrfz3kBmUhuQfOBvjnRA");
      ChargeRequest request = new ChargeRequest.Builder(1_00, CurrencyCode.valueOf("USD")).build();
      try {
          Intent intent = posClient.createChargeIntent(request);
          cordova.getActivity().startActivityForResult(intent, CHARGE_REQUEST_CODE);
      } catch (ActivityNotFoundException e) {
  //            showDialog("Error", "Square Point of Sale is not installed", null);
          posClient.openPointOfSalePlayStoreListing();
      }

    } else if(action.equals("getDate")) {
      // An example of returning data back to the web layer
      final PluginResult result = new PluginResult(PluginResult.Status.OK, (new Date()).toString());
      callbackContext.sendPluginResult(result);
    }
    return true;
  }

}

