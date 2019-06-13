package fr.hadja.hadjamariamadiallo_wikicountries.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import fr.hadja.hadjamariamadiallo_wikicountries.R;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

public class WelcomeActivity extends AppCompatActivity {
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        this.button = findViewById(R.id.start_button);
        this.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent continentChoiceActivity = new Intent(getApplicationContext(),ShowContinentsActivity.class);
                getApplicationContext().startActivity(continentChoiceActivity);
                //finish();
            }
        });
    }
}
