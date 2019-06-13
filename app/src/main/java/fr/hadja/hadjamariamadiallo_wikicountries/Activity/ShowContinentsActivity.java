package fr.hadja.hadjamariamadiallo_wikicountries.Activity;
import fr.hadja.hadjamariamadiallo_wikicountries.R;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ShowContinentsActivity extends AppCompatActivity {
    Button africa;
    Button europa;
    Button asia;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_continents);
        africa = findViewById(R.id.edit_afrique);
        europa = findViewById(R.id.edit_europe);
        asia = findViewById(R.id.edit_asie);
        africa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent continentChoiceActivity = new Intent(v.getContext(),AfricanCountriesActivity.class);
                v.getContext().startActivity(continentChoiceActivity);
            }
        });
        europa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent continentChoiceActivity = new Intent(v.getContext(),EuropeanCountriesActivity.class);
                v.getContext().startActivity(continentChoiceActivity);
            }
        });
        asia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent continentChoiceActivity = new Intent(v.getContext(),AsianCountriesActivity.class);
                v.getContext().startActivity(continentChoiceActivity);
            }
        });

    }
}

