package sjklein92.sleepapp;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class AlarmActivity extends AppCompatActivity {
    private int hour, min;
    private Intent intent;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);
        intent = getIntent();
        setAlarm();
    }

    private void setAlarm() {
        // Get user selected time
        hour = intent.getIntExtra(EXTRA_ALARM_HOUR);
        min = intent.getIntExtra(EXTRA_ALARM_MIN);

        // Set calendar to start at user-selected time
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, min);

        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(context, AlarmReceiver.class);
        alarmIntent = PendingIntent.getBroadcast(context, 0, intent, 0);
        alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), alarmIntent);   // Maybe wrong type of alarm?

    }
}
