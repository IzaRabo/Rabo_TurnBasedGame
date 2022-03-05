package mcm.edu.ph.rabo_turnbasedgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

public class Activity2 extends AppCompatActivity implements View.OnClickListener {


    int humanHP = 500;
    int humanMinDPT = 65;
    int humanMaxDPT = 100;
    String humanName = "Viking";

    int monsHP = 300;
    int monsMinDPT = 80;
    int monsMaxDPT = 150;
    String monsName = "Rhino Beetle";

    int turnNumber = 1;


    @Override
    protected void onCreate(Bundle s) {
        super.onCreate(s);
        setContentView(R.layout.activity_2);

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        Button nextTurn = findViewById(R.id.btnNextTurn);

        TextView txtMonsname = findViewById(R.id.txtEnemy_name);
        TextView txtMonsHP = findViewById(R.id.txtEnemy_hp);
        TextView txtMonsDPT = findViewById(R.id.txtEnemyDPT);
        TextView txtHumanname = findViewById(R.id.txtPlayer_name);
        TextView txtHumanHP = findViewById(R.id.txtPlayer_hp);
        TextView txtHumanDPT = findViewById(R.id.txtPlayerDPT);

        txtHumanname.setText(humanName);
        txtMonsname.setText(monsName);

        txtHumanHP.setText(String.valueOf(humanHP));
        txtMonsHP.setText(String.valueOf(monsHP));

        txtMonsDPT.setText(monsMinDPT + " ~ " + monsMaxDPT);
        txtHumanDPT.setText(humanMinDPT + " ~ " + humanMaxDPT);
        nextTurn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        Random randomizer = new Random();

        Button nextTurn = findViewById(R.id.btnNextTurn);
        TextView txtMonsHP = findViewById(R.id.txtEnemy_hp);
        TextView txtHumanHP = findViewById(R.id.txtPlayer_hp);
        TextView txtCombatLog = findViewById(R.id.txtTurnLog);

        txtMonsHP.setText(String.valueOf(monsHP));
        txtHumanHP.setText(String.valueOf(humanHP));

        int humanDPT = randomizer.nextInt(humanMaxDPT - humanMinDPT) + humanMinDPT;
        int monsDPT = randomizer.nextInt(monsMaxDPT - monsMinDPT) + monsMinDPT;

        switch (v.getId()) {
            case R.id.btnNextTurn:

                if (turnNumber%2 == 1){

                    monsHP = monsHP - humanDPT;
                    turnNumber++;

                    txtCombatLog.setText("The Viking dealt " +humanDPT+ " damage to the Rhino Beetle");
                    txtMonsHP.setText(String.valueOf(monsHP));
                    nextTurn.setText("Rhino Beetle's turn (" +turnNumber+ ")");

                    if (monsHP < 0){
                        txtCombatLog.setText("The Viking dealt " +humanDPT+ " damage to the Rhino Beetle. The Viking was Victorious!");
                        humanHP = 500;
                        monsHP = 300;
                        turnNumber = 1;
                        nextTurn.setText("Reset Game");
                    }
                }
                    else if (turnNumber%2 != 1){
                    humanHP = humanHP - monsDPT;
                    turnNumber++;

                    txtCombatLog.setText("The Rhino Beetle dealt " +monsDPT+ " damage to the Viking");
                    txtHumanHP.setText(String.valueOf(humanHP));
                    nextTurn.setText("The Viking's Turn (" +turnNumber+ ")");

                    if (humanHP < 0) {
                        txtCombatLog.setText("The Rhino Beetle dealt" +monsDPT+ " damage to the Viking");
                        humanHP = 500;
                        monsHP = 300;
                        turnNumber = 1;
                        nextTurn.setText("Reset Game");
                    }
                }
                break;
        }
    }
}


