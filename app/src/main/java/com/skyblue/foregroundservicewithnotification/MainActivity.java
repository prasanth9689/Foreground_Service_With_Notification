package com.skyblue.foregroundservicewithnotification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.skyblue.foregroundservicewithnotification.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.startService.setOnClickListener(v ->  startService());
        binding.stopService.setOnClickListener(v -> stopService());
    }

    public void startService(){
        Intent serviceIntent = new Intent(this, ForegroundSerivice.class);
        serviceIntent.putExtra("inputExtra", "Foreground Service Running");
        ContextCompat.startForegroundService(this, serviceIntent);
    }

    public void stopService(){
        Intent serviceIntent = new Intent(this, ForegroundSerivice.class);
        startService(serviceIntent);
    }
}