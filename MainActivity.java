package com.sistem.pro;

import android.app.Activity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
    EditText numaraInput, mesajInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numaraInput = findViewById(R.id.numara);
        mesajInput = findViewById(R.id.mesaj);
    }

    // --- GERÇEK SMS GÖNDERME FONKSİYONU ---
    public void smsGonder(View v) {
        String tel = numaraInput.getText().toString();
        String msg = mesajInput.getText().toString();

        try {
            SmsManager sms = SmsManager.getDefault();
            sms.sendTextMessage(tel, null, msg, null, null);
            Toast.makeText(this, "SMS Gönderildi!", Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            Toast.makeText(this, "Hata: SMS Yetkisi Yok!", Toast.LENGTH_LONG).show();
        }
    }

    // --- GERÇEK ARAMA YAPMA FONKSİYONU ---
    public void aramaYap(View v) {
        String tel = numaraInput.getText().toString();
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + tel));
        startActivity(intent);
    }
}
