package cat.itb.roomba.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import cat.itb.roomba.R;

public class InputName extends AppCompatActivity {

    private EditText et_name;
    private Button b_start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_name);

        et_name = findViewById(R.id.et_name);
        b_start = findViewById(R.id.b_start);

        et_name.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_UP && keyCode == 66) {
                    next();
                }
                return false;
            }
        });

        b_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                next();
            }
        });
    }

    public void next(){
        String nom = et_name.getText().toString();
        if (nom.matches("")) {
            Toast.makeText(InputName.this, "Introduce un nombre.", Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent(InputName.this, PreguntesActivity.class);
            intent.putExtra("nom",nom);
            startActivity(intent);
            finish();
        }
    }
}