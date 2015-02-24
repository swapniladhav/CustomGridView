package com.example.gridviewdemo;

import java.util.ArrayList;
import java.util.List;

import org.matrimony.DO.FaceBookProfile;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

public class MainActivity extends Activity {
	//
	ImageView profileIcon;
	List<FaceBookProfile> profiles = new ArrayList<FaceBookProfile>();
	Animation animation;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		populateprofileDO();
		populateProfileList();
		viewProfile();

	}

	private void populateprofileDO() {
		profiles.add(new FaceBookProfile(R.drawable.images1, "rffs sdfsdf ",
				"Maratha", "34", "Hindu"));
		profiles.add(new FaceBookProfile(R.drawable.images2, "qwe cvd ",
				"Maratha", "34", "Hindu"));
		profiles.add(new FaceBookProfile(R.drawable.images3, "yt asdasd ",
				"Maratha", "34", "Hindu"));
		profiles.add(new FaceBookProfile(R.drawable.images4, "qweqwe qe ",
				"Maratha", "34", "Hindu"));
		profiles.add(new FaceBookProfile(R.drawable.images5, "GFHGGH FGFDF",
				"Maratha", "34", "Hindu"));
		profiles.add(new FaceBookProfile(R.drawable.images6, "GFDG ERTRET",
				"Maratha", "34", "Hindu"));
		profiles.add(new FaceBookProfile(R.drawable.images1, "ERT UIEEW",
				"Maratha", "34", "Hindu"));
		profiles.add(new FaceBookProfile(R.drawable.images2, "WEREWEER HYYYEE",
				"Maratha", "34", "Hindu"));
		profiles.add(new FaceBookProfile(R.drawable.images3, "WER 4Y53WE",
				"Maratha", "34", "Hindu"));
		profiles.add(new FaceBookProfile(R.drawable.images4, "WER RWTET3",
				"Maratha", "34", "Hindu"));
		profiles.add(new FaceBookProfile(R.drawable.images3, "WERR", "Maratha",
				"34", "Hindu"));
		profiles.add(new FaceBookProfile(R.drawable.images1, "WERR  RRWR",
				"Maratha", "34", "Hindu"));
		profiles.add(new FaceBookProfile(R.drawable.images6, "RWEE WERWER",
				"Maratha", "34", "Hindu"));
		profiles.add(new FaceBookProfile(R.drawable.images2, "WERWEER RWEEER",
				"Maratha", "34", "Hindu"));
		profiles.add(new FaceBookProfile(R.drawable.images1, "WRE W4RWER",
				"Maratha", "34", "Hindu"));
	}

	private void populateProfileList() {

		ArrayAdapter<FaceBookProfile> adapter = new ProfileAdapter();
		GridView list = (GridView) findViewById(R.id.gridView1);
		list.setAdapter(adapter);

	}

	public class ProfileAdapter extends ArrayAdapter<FaceBookProfile> {

		public ProfileAdapter() {
			super(MainActivity.this, R.layout.grid_with, profiles);

		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			View profileView = convertView;
			if (profileView == null) {
				profileView = getLayoutInflater().inflate(R.layout.grid_with,
						parent, false);
			}
			FaceBookProfile faceBookProfile = profiles.get(position);

			final ViewSwitcher viewSwitcher = (ViewSwitcher) profileView
					.findViewById(R.id.viewSwitcher1);
			final Button Switcher = (Button) profileView
					.findViewById(R.id.button1);

			Switcher.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					viewSwitcher.setAnimation(AnimationUtils.loadAnimation(
							v.getContext(), R.anim.fade));
					viewSwitcher.showNext();
				}
			});
			final Button Switcher2 = (Button) profileView
					.findViewById(R.id.button2);

			Switcher2.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					viewSwitcher.setAnimation(AnimationUtils.loadAnimation(
							v.getContext(), R.anim.fade));
					viewSwitcher.showNext();
				}
			});

			profileIcon = (ImageView) profileView.findViewById(R.id.iconID);

			profileIcon.setImageResource(faceBookProfile.getIconID());

			TextView fullName = (TextView) profileView
					.findViewById(R.id.fullName);
			fullName.setText(faceBookProfile.getFullName());

			TextView fullName1 = (TextView) profileView
					.findViewById(R.id.fullName1);
			fullName1.setText(faceBookProfile.getFullName());

			TextView religion = (TextView) profileView
					.findViewById(R.id.religion);
			religion.setText(faceBookProfile.getReligion());

			TextView cast = (TextView) profileView.findViewById(R.id.cast);
			cast.setText(faceBookProfile.getCast());

			return profileView;
		}

	}

	private void viewProfile() {

		final GridView list = (GridView) findViewById(R.id.gridView1);
		list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View clickVIew,
					int position, long id) {
				System.out.println("Clicked");
				int evntId = (int) list.getSelectedItemId();
				switch (evntId) {
				case R.id.fullName:
					Toast.makeText(MainActivity.this, "you clicked name",
							Toast.LENGTH_LONG).show();
					break;
				case R.id.iconID:
					Toast.makeText(MainActivity.this, "you clicked icon",
							Toast.LENGTH_LONG).show();
					break;
				case R.id.cast:
					Toast.makeText(MainActivity.this, "you clicked cast",
							Toast.LENGTH_LONG).show();
					break;

				}
				/*
				 * FaceBookProfile clkickedProfile = profiles.get(position);
				 * Toast.makeText(MainActivity.this, "you clicked " + position,
				 * Toast.LENGTH_LONG).show(); Intent i = new
				 * Intent(MainActivity.this, Profile_View.class);
				 * i.putExtra("Name", clkickedProfile.getFullName());
				 * startActivity(i);
				 */

			}

		});

	}

}
