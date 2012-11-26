package com.example.karoake_helper;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.content.res.Resources;
import android.content.res.Configuration;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.widget.Button;
import android.widget.Toast;
import android.widget.EditText;

public class KaraokeActivity extends Activity {

	
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_karaoke);
		
//		Resources res = getResources();

		
		
		
		Button LyricButton = (Button) findViewById(R.id.SongButton); 

		
		
		LyricButton.setOnClickListener(new View.OnClickListener() {
			String[] home_song = getResources().getStringArray(R.array.home_array);
			int home_length = home_song.length;
			int home_song_total = 0;
			
			String[] over_you_song = getResources().getStringArray(R.array.over_you_array);
			int over_you_length = over_you_song.length;
			int over_you_song_total = 0;
			
			
			EditText songview = (EditText)findViewById(R.id.SongText);
		    
			public void onClick(View v) {
				Toast.makeText(KaraokeActivity.this, "Next Lyric Line ..", Toast.LENGTH_SHORT).show();
				
				
				int ot = getResources().getConfiguration().orientation;
				switch(ot)
				        {

				        case  Configuration.ORIENTATION_LANDSCAPE:
							songview.setText(over_you_song[over_you_song_total]);
							over_you_song_total++;
							if(over_you_song_total >= over_you_length) {
								over_you_song_total = 0;
							}

				        break;
				        case Configuration.ORIENTATION_PORTRAIT:
							songview.setText(home_song[home_song_total]);
							home_song_total++;
							if(home_song_total >= home_length) {
								home_song_total = 0;
							}
				            break;

				        case Configuration.ORIENTATION_SQUARE:
							songview.setText(home_song[home_song_total]);
							home_song_total++;
							if(home_song_total >= home_length) {
								home_song_total = 0;
							}
				            break;
				        case Configuration.ORIENTATION_UNDEFINED:
							songview.setText(home_song[home_song_total]);
							home_song_total++;
							if(home_song_total >= home_length) {
								home_song_total = 0;
							}
				            break;
				            default:
								songview.setText(over_you_song[over_you_song_total]);
								over_you_song_total++;
								if(over_you_song_total >= over_you_length) {
									over_you_song_total = 0;
								}

				            break;
				        }
				
				
				
				

			}	
			
			
				
			
			
		});
		
		
		

		
			AlertDialog.Builder alertDialog = new AlertDialog.Builder(
		KaraokeActivity.this)
		.setTitle("length of home song")
//		.setMessage(home_song[0])
		.setCancelable(false)
			.setPositiveButton("Yes",new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog,int id) {
					// if this button is clicked, close
					// current activity
					dialog.cancel();
				}
			  })
			.setNegativeButton("No",new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog,int id) {
					// if this button is clicked, just close
					// the dialog box and do nothing
					dialog.cancel();
				}
		
			});
			
//			alertDialog.show();
			
			   
		
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_karaoke, menu);
		return true;
	}
	
	

}
