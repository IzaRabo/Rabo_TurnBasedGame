package mcm.edu.ph.rabo_turnbasedgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {


    ImageButton imageButton6, imageButton7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MediaPlayer music = MediaPlayer.create(MainActivity.this, R.raw.music);
        music.start();

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


        imageButton7 = (ImageButton) findViewById(R.id.imageButton7);
        imageButton7.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent intentOpenActivity3 = new Intent(MainActivity. this, Activity3.class);
                startActivity(intentOpenActivity3);

            }
        });

        imageButton6 = (ImageButton) findViewById(R.id.imageButton6);
        imageButton6.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent intentOpenActivity2 = new Intent(MainActivity. this, Activity2.class);
                startActivity(intentOpenActivity2);
            }
        });

        }
    }
