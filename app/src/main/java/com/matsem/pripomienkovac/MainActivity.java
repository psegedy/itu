package com.matsem.pripomienkovac;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

	FrameLayout btnMorning;
	FrameLayout btnNoon;
	FrameLayout btnAfternoon;
	FrameLayout btnNight;
	FrameLayout btnPodium;
	FrameLayout btnGames;
	FrameLayout btnChurch;

	private AlarmManager alarmMgr;
	private PendingIntent alarmIntent;


	NotificationManager notificationManager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_main);
		notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);


		btnMorning = (FrameLayout) findViewById(R.id.btn_main_1);
		btnNoon = (FrameLayout) findViewById(R.id.btn_main_2);
		btnAfternoon = (FrameLayout) findViewById(R.id.btn_main_3);
		btnNight = (FrameLayout) findViewById(R.id.btn_main_4);
		btnPodium = (FrameLayout) findViewById(R.id.podium);
		btnGames = (FrameLayout) findViewById(R.id.games);
		btnChurch = (FrameLayout) findViewById(R.id.church);

		btnMorning.setOnClickListener(new View.OnClickListener() {
			@Override public void onClick(View view) {
				notificationManager.notify(0, getNotification());
				viewPillsMorning(view);
			}
		});

		btnNoon.setOnClickListener(new View.OnClickListener() {
			@Override public void onClick(View view) {
				scheduleNotification(getNotification(), 10000);
				Toast.makeText(MainActivity.this, "Notifikacia bude zobrazena o 10 sekund", Toast.LENGTH_SHORT).show();
				viewPillsNoon(view);
			}
		});

		btnAfternoon.setOnClickListener(new View.OnClickListener() {
			@Override public void onClick(View view) {
				viewPillsAfternoon(view);
			}
		});

		btnNight.setOnClickListener(new View.OnClickListener() {
			@Override public void onClick(View view) {
				viewPillsNight(view);
			}
		});

		btnPodium.setOnClickListener(new View.OnClickListener() {
			@Override public void onClick(View view) {
				viewPodium(view);
			}
		});

		btnGames.setOnClickListener(new View.OnClickListener() {
			@Override public void onClick(View view) {
				playGames(view);
			}
		});

		btnChurch.setOnClickListener(new View.OnClickListener() {
			@Override public void onClick(View view) {
				viewChurchSchedule(view);
			}
		});

	}

	private Notification getNotification() {
		long vibrator[] = { 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000,
				1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000};
		Notification notification = new NotificationCompat.Builder(this)
				.setSmallIcon(R.drawable.pill_app_icon)
				.setContentTitle("Pripomienkovač")
				.setContentText("Zoberte vaše lieky!")
				.setAutoCancel(true)
				.setOngoing(true)
				.setSmallIcon(R.drawable.pill_app_icon)
				.setContentIntent(this.getNotificationIntent())
				.setCategory(Notification.CATEGORY_REMINDER)
				.setPriority(Notification.PRIORITY_MAX)
				.setVibrate(vibrator)
				.setFullScreenIntent(this.getNotificationIntent(), false)
				.setSound(Uri.parse("android.resource://" + this.getPackageName() + "/" + R.raw.alarm))
				.build();
		return notification;
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

	public PendingIntent getNotificationIntent() {
		TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
		stackBuilder.addParentStack(TakePillsActivity.class);
		stackBuilder.addNextIntent(new Intent(this, TakePillsActivity.class));

		return stackBuilder.getPendingIntent(9, PendingIntent.FLAG_UPDATE_CURRENT);
	}

	public void viewPillsMorning(View view){
		Intent intent = new Intent(this, PillSlideActivity.class);
		startActivity(intent);
	}

	public void viewPillsNoon(View view){
		Intent intent = new Intent(this, PillSlideActivity.class);
		startActivity(intent);
	}

	public void viewPillsAfternoon(View view){
		Intent intent = new Intent(this, PillSlideActivity.class);
		startActivity(intent);
	}

	public void viewPillsNight(View view){
		Intent intent = new Intent(this, PillSlideActivity.class);
		startActivity(intent);
	}

	public void viewPodium(View view){
		Intent intent = new Intent(this, PodiumActivity.class);
		startActivity(intent);
	}

	public void playGames(View view){
		Intent intent = new Intent(this, GamesActivity.class);
		startActivity(intent);
	}

	public void viewChurchSchedule(View view){
		Intent intent = new Intent(this, ChurchActivity.class);
		startActivity(intent);
	}
}
