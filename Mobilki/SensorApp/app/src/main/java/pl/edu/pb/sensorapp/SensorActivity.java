package pl.edu.pb.sensorapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class SensorActivity extends AppCompatActivity {
    private SensorManager sensorManager;
    private List<Sensor> sensorList;
    private RecyclerView recyclerView;
    private SensorAdapter adapter;
    private static final String SENSOR_TAG = "SensorActivity";
    private boolean subtitle_visible;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sensor_activity);

        recyclerView = findViewById(R.id.sensor_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensorList = sensorManager.getSensorList(Sensor.TYPE_ALL);

        if (adapter == null) {
            adapter = new SensorAdapter(sensorList);
            recyclerView.setAdapter(adapter);
        } else {
            adapter.notifyDataSetChanged();
        }
        for (Sensor sensor:sensorList) {
            Log.d(SENSOR_TAG, String.format("Czujnik: %s;\tproducent: %s;\tmaksymalna wartość: %s", sensor.getName(), sensor.getVendor(), sensor.getMaximumRange()));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.sensor_list_menu, menu);
        MenuItem subtitleItem = menu.findItem(R.id.show_sensor_number);
        if (subtitle_visible) {
            subtitleItem.setTitle(R.string.hide_sensor_number);
        } else {
            subtitleItem.setTitle(R.string.show_sensor_number);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.show_sensor_number:
                subtitle_visible = !subtitle_visible;
                invalidateOptionsMenu();
                updateSubtitle();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void updateSubtitle() {
        String subtitle = null;
        if (subtitle_visible) {
            subtitle = getString(R.string.subtitle_format, sensorList.size());
        }
        getSupportActionBar().setSubtitle(subtitle);
    }

    public class SensorHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView sensorIconImageView;
        private TextView sensorNameTextView;
        private Sensor sensor;
        public static final String SENSOR_TYPE = "sensorType";

        public SensorHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.sensor_list_item, parent, false));
            itemView.setOnClickListener(this);

            sensorIconImageView = itemView.findViewById(R.id.sensor_icon);
            sensorNameTextView = itemView.findViewById(R.id.sensor_name);
        }

        public void bind(final Sensor sensor) {
            this.sensor = sensor;
            if (sensor.getType() == Sensor.TYPE_PROXIMITY || sensor.getType() == Sensor.TYPE_LIGHT) {
                sensorNameTextView.setTypeface(null, Typeface.BOLD);
            } else {
                sensorNameTextView.setTypeface(null, Typeface.NORMAL);
            }
            sensorNameTextView.setText((sensor.getName()));
            sensorIconImageView.setImageResource(R.drawable.sensor_icon);
        }

        @Override
        public void onClick(View v) {
            if (sensor.getType() == Sensor.TYPE_PROXIMITY || sensor.getType() == Sensor.TYPE_LIGHT) {
                Intent intent = new Intent(SensorActivity.this, SensorDetailsActivity.class);
                intent.putExtra(SENSOR_TYPE, sensor.getType());
                startActivity(intent);
            }
        }
    }

    private class SensorAdapter extends RecyclerView.Adapter<SensorHolder> {

        public SensorAdapter(List<Sensor> sensors) {
            sensorList = sensors;
        }

        @NonNull
        @Override
        public SensorHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new SensorHolder(getLayoutInflater(), parent);
        }

        @Override
        public void onBindViewHolder(@NonNull SensorHolder holder, int position) {
            Sensor sensor = sensorList.get(position);
            holder.bind(sensor);
        }

        @Override
        public int getItemCount() {
            return sensorList.size();
        }
    }
}
