package com.matsem.pripomienkovac;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

	FrameLayout btn1;
	FrameLayout btn2;

	NotificationManager notificationManager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

		btn1 = (FrameLayout) findViewById(R.id.btn_main_1);
		btn2 = (FrameLayout) findViewById(R.id.btn_main_2);

		btn1.setOnClickListener(new View.OnClickListener() {
			@Override public void onClick(View view) {
				notificationManager.notify(0, getNotificaiton());
			}
		});

		btn2.setOnClickListener(new View.OnClickListener() {
			@Override public void onClick(View view) {
				scheduleNotification(getNotificaiton(), 10000);
				Toast.makeText(MainActivity.this, "Notifikacia bude zobrazena o 10 sekund", Toast.LENGTH_SHORT).show();
			}
		});
	}


	private Notification getNotificaiton() {
		Notification notifcation = new Notification.Builder(this)
				.setContentTitle("Moja notifikacia")
				.setContentText("Pojeb sa")
				.setAutoCancel(true)
				.setSmallIcon(R.mipmap.ic_launcher)
				.setContentIntent(getNotificationIntent())
				.build();

		return notifcation;
	}

	private PendingIntent getNotificationIntent() {
		TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
		stackBuilder.addParentStack(MainActivity.class);
		stackBuilder.addNextIntent(new Intent(this, MainActivity.class));

		return stackBuilder.getPendingIntent(9, PendingIntent.FLAG_UPDATE_CURRENT);
	}

	private void scheduleNotification(Notification notification, int delay) {

		Intent notificationIntent = new Intent(this, NotificationPublisher.class);
		notificationIntent.putExtra(NotificationPublisher.NOTIFICATION_ID, 1);
		notificationIntent.putExtra(NotificationPublisher.NOTIFICATION, notification);
		PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);

		long futureInMillis = SystemClock.elapsedRealtime() + delay;
		AlarmManager alarmManager = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
		alarmManager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP, futureInMillis, pendingIntent);
	}

	private Notification getNotification(String content) {
		Notification.Builder builder = new Notification.Builder(this);
		builder.setContentTitle("Scheduled Notification");
		builder.setContentText(content);
		builder.setSmallIcon(R.mipmap.ic_launcher);
		return builder.build();
	}
}
