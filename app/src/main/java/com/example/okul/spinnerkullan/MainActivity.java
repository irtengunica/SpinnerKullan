package com.example.okul.spinnerkullan;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
/*listeler.xml dosyasındaki listeyi açılır kutuya ekleme ve secilen elemanı yazdırma*/

public class MainActivity extends ActionBarActivity {
    ArrayList<String> lstOs;
    TextView lblSonuc;
    ImageButton btnEkle;
    EditText txtEkle;
    Spinner sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sp = (Spinner) findViewById(R.id.spinner);
        lblSonuc = (TextView) findViewById(R.id.lblSonuc);
        btnEkle=(ImageButton) findViewById(R.id.btnEkle);
        txtEkle=(EditText) findViewById(R.id.txtEkle);
        Intent gelenIntent=getIntent();
        String user=gelenIntent.getStringExtra("username");
        lblSonuc.setText(user.toString());
        String[] strArOs = getResources().getStringArray(R.array.isletim_sistemleri);
        lstOs = new ArrayList<String>();
        lstOs.addAll(Arrays.asList(strArOs));
        //lstOs=new ArrayList<String>(Arrays.asList(strArOs));
        ListeDoldur();
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position > 0) {
                    String os = lstOs.get(position) + " yeri:" + position;
                    lblSonuc.setText(os);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        btnEkle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lstOs.add(txtEkle.getText().toString());
                ListeDoldur();
            }
        });

    }

    private void ListeDoldur() {
        ArrayAdapter<String> adp = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, lstOs);
        sp.setAdapter(adp);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
