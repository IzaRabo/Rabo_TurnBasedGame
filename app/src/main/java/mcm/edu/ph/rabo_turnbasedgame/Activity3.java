package mcm.edu.ph.rabo_turnbasedgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Random;

public class Activity3 extends AppCompatActivity implements View.OnClickListener {


    int trollHP = 1000;
    int trollMinDPT = 80;
    int trollMaxDPT = 200;
    String trollName = "Troll";

    int steamHP = 900;
    int steamMinDPT = 55;
    int steamMaxDPT = 150;
    String steamName = "Steam Man";

    int turnNumber = 1;


    @Override
    protected void onCreate(Bundle s) {
        super.onCreate(s);
        setContentView(R.layout.activity_3);

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        Button nextTurn = findViewById(R.id.btnNextTurn2);

        TextView txtSteamname = findViewById(R.id.txtEnemy_name2);
        TextView txtSteamHP = findViewById(R.id.txtEnemy_hp2);
        TextView txtSteamDPT = findViewById(R.id.txtEnemyDPT2);
        TextView txtTrollname = findViewById(R.id.txtPlayer_name2);
        TextView txtTrollHP = findViewById(R.id.txtPlayer_hp2);
        TextView txtTrollDPT = findViewById(R.id.txtPlayerDPT2);

        txtTrollname.setText(trollName);
        txtSteamname.setText(steamName);

        txtTrollHP.setText(String.valueOf(trollHP));
        txtSteamHP.setText(String.valueOf(steamHP));

        txtSteamDPT.setText(steamMinDPT + " ~ " + steamMaxDPT);
        txtTrollDPT.setText(trollMinDPT + " ~ " + trollMaxDPT);
        nextTurn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        Random randomizer = new Random();

        Button nextTurn = findViewById(R.id.btnNextTurn2);
        TextView txtSteamHP = findViewById(R.id.txtEnemy_hp2);
        TextView txtTrollHP = findViewById(R.id.txtPlayer_hp2);
        TextView txtCombatLog = findViewById(R.id.txtTurnLog2);

        txtSteamHP.setText(String.valueOf(steamHP));
        txtTrollHP.setText(String.valueOf(trollHP));

        int trollDPT = randomizer.nextInt(trollMaxDPT - trollMinDPT) + trollMinDPT;
        int steamDPT = randomizer.nextInt(steamMaxDPT - steamMinDPT) + steamMinDPT;

        switch  (v.getId()) {
            case R.id.btnNextTurn2:

                if (turnNumber%2 == 1){

                    steamHP = steamHP - trollDPT;
                    turnNumber++;

                    txtCombatLog.setText("The Troll dealt " +trollDPT+ " damage to the Steam Man");
                    txtSteamHP.setText(String.valueOf(steamHP));
                    nextTurn.setText("Steam Man's turn (" +turnNumber+ ")");

                    if (steamHP < 0){
                        txtCombatLog.setText("The Troll dealt " +trollDPT+ " damage to the Steam Man. The Troll was Victorious!");
                        trollHP = 500;
                        steamHP = 300;
                        turnNumber = 1;
                        nextTurn.setText("Reset Game");
                    }
                }
                    else if (turnNumber%2 != 1){
                    trollHP = trollHP - trollDPT;
                    turnNumber++;

                    txtCombatLog.setText("The Steam Man dealt " +steamDPT+ " damage to the Troll");
                    txtTrollHP.setText(String.valueOf(trollHP));
                    nextTurn.setText("The Troll's Turn (" +turnNumber+ ")");

                    if (trollHP < 0) {
                        txtCombatLog.setText("The Steam Man dealt" +steamDPT+ " damage to the Troll");
                        trollHP = 500;
                        steamHP = 300;
                        turnNumber = 1;
                        nextTurn.setText("Reset Game");
                    }
                }
                break;
        }
    }
}


