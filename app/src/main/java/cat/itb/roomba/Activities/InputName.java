package cat.itb.roomba.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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

        b_start.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String nom = et_name.getText().toString();
                if (nom.matches("")) {
                    Toast.makeText(InputName.this, "Has d'introduir un nom.", Toast.LENGTH_SHORT).show();
                }else {
                    //Activity
                }

            }
        });

    }
}