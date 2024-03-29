package cat.itb.roomba.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import cat.itb.roomba.Database.AppDatabase;
import cat.itb.roomba.Database.Pregunta;
import cat.itb.roomba.Database.PreguntaDao;
import cat.itb.roomba.Database.Puntuacio;
import cat.itb.roomba.Database.PuntuacioDao;
import cat.itb.roomba.Database.Repository;
import cat.itb.roomba.R;

public class MainActivity extends AppCompatActivity {

    private Button b_play, b_records;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b_play = findViewById(R.id.b_play);
        b_records = findViewById(R.id.b_records);

        b_records.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ScoreActivity.class);
                startActivity(intent);
            }
        });

        b_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, InputName.class);
                startActivity(intent);
            }
        });
    }
}