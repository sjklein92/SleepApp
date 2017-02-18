package sjklein92.sleepapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TimePicker;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity {
    private timePicker tPicker;
    private int hour, min;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void setTime(View view) {
        Intent intent = new Intent(this, AlarmActivity.class);
        tPicker = (TimePicker) findViewById(R.id.timePicker1);
        hour = tPicker.getCurrentHour();
        min = tPicker.getCurrentMinute();
        intent.putExtra("EXTRA_ALARM_HOUR", hour);
        intent.putExtra("EXTRA_ALARM_MIN", min);
        startActivity(intent);

    }


}
