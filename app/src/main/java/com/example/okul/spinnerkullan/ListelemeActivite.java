package com.example.okul.spinnerkullan;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;


public class ListelemeActivite extends ActionBarActivity {
ListView lst;
    ArrayList<String> lstOs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listeleme_activite);
        lst=(ListView) findViewById(R.id.lst);
        String[] strArOs = getResources().getStringArray(R.array.isletim_sistemleri);

        /*lstOs = new ArrayList<String>();
         String[] isimler=new String[]{"aa","bb","cc","dd","ee"};
        for(int i=0;i<isimler.lenght;i++){
         lstOs.add(isimler[i];
         }
         */

        lstOs = new ArrayList<String>();
        lstOs.addAll(Arrays.asList(strArOs));
        ListeDoldur();
        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                lstOs.remove(position);
                ListeDoldur();

                /*
                Intent i=new Intent();
                i.putExtra("neysene", lstOs.get(position));
                setResult(44,i);
                finish();
                */
            }
        });
    }

    private void ListeDoldur() {
        ArrayAdapter<String> adp=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,lstOs);
        lst.setAdapter(adp);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_listeleme_activite, menu);
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
