package com.app.mymvvmsample.view.activities;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.app.mymvvmsample.utils.ConnectionDetector;
import com.app.mymvvmsample.R;
import com.app.mymvvmsample.utils.RetrofitApis;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BaseActivity extends AppCompatActivity {

    public ConnectionDetector connectionDetector;
    public RetrofitApis retrofitApis;
    public Dialog dialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        connectionDetector=new ConnectionDetector(this);
        retrofitApis=RetrofitApis.Factory.create();
    }

    public void printLog(String tag,String msg)
    {
        Log.e(tag,msg);
    }

    public void showDeveloperToast(String msg)
    {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }

    public void showToast(String msg)
    {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }

    public void showInternetToast()
    {
        Toast.makeText(this,"Please check your internet connection and try again.",Toast.LENGTH_SHORT).show();
    }

    public boolean isInternetConnected()
    {
        return connectionDetector.isConnectingToInternet();
    }

    public boolean isEmptyField(String text)
    {
      if(text==null||text.equalsIgnoreCase("null")||text.trim().length()==0)
          return true;
      else
          return false;
    }

    public boolean signupEmail(String email)
    {
        String emailPattern =
                "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        Pattern pattern = Pattern.compile(emailPattern);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public void showDialog()
    {
        dialog = new Dialog(this,
                android.R.style.Theme_Translucent_NoTitleBar_Fullscreen);
        dialog.setContentView(R.layout.loading);
        dialog.setCancelable(false);
        dialog.show();
    }

    public void dismissDialog()
    {
        if(dialog!=null)
            dialog.dismiss();
    }
}
