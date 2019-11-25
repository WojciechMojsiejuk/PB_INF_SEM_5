package pl.edu.pb.sensorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SensorDetailsActivity extends AppCompatActivity implements SensorEventListener {
    private SensorManager sensorManager;
    private Sensor sensor;
    private TextView sensorNameTextView;
    private TextView sensorValueTextView;
    private int type;
    private LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        type = (int) getIntent().getSerializableExtra(SensorActivity.SensorHolder.SENSOR_TYPE);

        setContentView(R.layout.activity_sensor_details);

        sensorNameTextView = findViewById(R.id.sensor_label);
        sensorValueTextView = findViewById(R.id.sensor_value);
        layout = findViewById(R.id.details_view);

        if (type == Sensor.TYPE_PROXIMITY) {
            sensorNameTextView.setText(getResources().getString(R.string.proximity_sensor_label));
        } else if (type == Sensor.TYPE_LIGHT) {
            sensorNameTextView.setText(getResources().getString(R.string.light_sensor_label));
        }

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(type);

        if (sensor == null) {
            sensorNameTextView.setText(R.string.missing_sensor);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();

        if (sensor != null) {
            sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();

        sensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        int sensorType = event.sensor.getType();
        float currentValue = event.values[0];

        switch (sensorType) {
            case Sensor.TYPE_PROXIMITY:
            case Sensor.TYPE_LIGHT:
                sensorValueTextView.setText(String.valueOf(currentValue));
                if (currentValue >= 5) {
                    layout.setBackgroundColor(0);
                } else {
                    layout.setBackgroundColor(getResources().getColor(R.color.dark));
                }
                break;
            default:
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        Log.d("Sensor", "Accuracy changed");
    }
}
