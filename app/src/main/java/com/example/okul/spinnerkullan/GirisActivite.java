package com.example.okul.spinnerkullan;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;


public class GirisActivite extends ActionBarActivity {
    EditText txtUser, txtPass;
    CheckBox cb;
    Button btnLogin;
    String user, pass;
    Boolean girisTamam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giris_activite);
        txtUser = (EditText) findViewById(R.id.txtuser);
        txtPass = (EditText) findViewById(R.id.txtPass);
        cb = (CheckBox) findViewById(R.id.cbParola);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        girisTamam = false;
        cb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cb.isChecked()) {
                    txtPass.setInputType(InputType.TYPE_CLASS_TEXT);
                } else {
                    txtPass.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                }
            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user = txtUser.getText().toString();
                pass = txtPass.getText().toString();
                if (user.equals("Aksaray") && pass.equals("68")) {
                    girisTamam = true;
                    Toast.makeText(GirisActivite.this, "Giriþ Ok",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(GirisActivite.this, "Giriþ Yapýlmadý",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_giris_activite, menu);
        return true;
    }

 /*   @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 44) {
        txtUser.setText(data.getStringExtra("neysene"));
        }
    }*/

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
       /* if (id == R.id.action_settings) {
            return true;
        }*/
        switch (id) {
            case R.id.mnExit:
                finish();
                break;
            case R.id.action_settings:
                //ayarlar ile ilgili kod
                break;
            case R.id.mnMain:
                if (girisTamam) {
                    Intent intmn = new Intent(GirisActivite.this, MainActivity.class);
                    intmn.putExtra("username",user);
                    intmn.putExtra("password",pass);

                    startActivity(intmn);
                } else {
                    Toast.makeText(this, "Lütfen Giriþ Yapýnýz", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.mnListeleme:
                Intent i=new Intent(GirisActivite.this,ListelemeActivite.class);
                startActivity(i);
                //startActivityForResult(i,44);//intenti çalýþtýrýp geri kod 44 gönderiri istenen sayý,baþka aktiviteden deðer almak için
                break;

        }

        return super.onOptionsItemSelected(item);
    }
}
