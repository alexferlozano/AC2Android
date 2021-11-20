package com.example.myapplicationmd;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Mostrar el fragment
        if (savedInstanceState == null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.container, new LoginfragmentActivity())
                    .commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.login:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container, new LoginfragmentActivity())
                        .addToBackStack(null)
                        .commit();
                break;
            case  R.id.form:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container, new secondfragment())
                        .addToBackStack(null)
                        .commit();
                break;
            default:
                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.container, new LoginfragmentActivity())
                        .commit();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}