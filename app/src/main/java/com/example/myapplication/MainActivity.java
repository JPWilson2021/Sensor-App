package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.hardware.SensorManager;
import android.hardware.Sensor;
import android.view.View;
import android.widget.TextView;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    TextView tvl=null;
    private SensorManager mSensorManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvl = (TextView) findViewById(R.id.textview);
        tvl.setVisibility(View.GONE);

        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        List<Sensor> mList= mSensorManager.getSensorList(Sensor.TYPE_ALL);

        for (int i = 1; i <mList.size(); i++) {
            tvl.setVisibility(View.VISIBLE);
            tvl.append("\n" + mList.get(i).getName() + "\n" + mList.get(i).getVendor() +
                    "\n" + mList.get(i).getVersion());
        }
    }
}