package cat.itb.roomba.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.List;

import cat.itb.roomba.Database.AppDatabase;
import cat.itb.roomba.Database.Pregunta;
import cat.itb.roomba.Database.PreguntaDao;
import cat.itb.roomba.Database.Puntuacio;
import cat.itb.roomba.Database.PuntuacioDao;
import cat.itb.roomba.Database.Repository;
import cat.itb.roomba.R;

public class PreguntesActivity extends AppCompatActivity {

    private TextView tv_pregunta;
    private TextView tv_current;
    private EditText et_resposta;
    private Button b_back;
    private ProgressBar pb;

    private MyCountDownTimer myCountDownTimer;
    private int timerProgress = 100;
    private List<Pregunta> preguntes;

    static AppDatabase db;
    static PreguntaDao pDao;
    static PuntuacioDao punDao;
    static Repository repo;

    int actual = 0;
    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preguntes);

        tv_pregunta = findViewById(R.id.tv_pregunta);
        tv_current = findViewById(R.id.tv_current);
        et_resposta = findViewById(R.id.et_resposta);
        b_back = findViewById(R.id.b_back);
        pb = findViewById(R.id.pb);

        db = AppDatabase.getInstance(this.getApplicationContext());
        pDao = db.preguntaDao();
        punDao = db.puntuacioDao();
        repo = new Repository(pDao, punDao);

        //Comprova si el repositori de preguntes està buit per a afegir-les
        int count = repo.getCountPreguntes();
        if (count==0) {
            String[] preguntesArr = getResources().getStringArray(R.array.preguntes);
            String[] respostesArr = getResources().getStringArray(R.array.respostes);

            for (int i = 0; i < preguntesArr.length; i++) {
                pDao.insert(new Pregunta(preguntesArr[i], respostesArr[i]));
            }
        }
        preguntes = repo.getPreguntes();

        update();

        et_resposta.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_UP && keyCode == 66) {
                    myCountDownTimer.cancel();
                    if (et_resposta.getText().toString().equalsIgnoreCase(preguntes.get(actual-1).getResposta())){
                        score++;
                    }
                    if (actual < preguntes.size()) {
                        update();
                    } else {
                        finalizar();
                    }
                }
                return false;
            }
        });

        b_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void finalizar(){
        tv_pregunta.setText("Puntuación: "+score);
        et_resposta.setVisibility(View.INVISIBLE);
        tv_current.setVisibility(View.INVISIBLE);
        b_back.setVisibility(View.VISIBLE);
        pb.setVisibility(View.INVISIBLE);
        addScore();
    }

    public void addScore(){
        final Bundle bundle = getIntent().getExtras();
        String nom = bundle.getString("nom");
        punDao.insert(new Puntuacio(nom,score));
    }

    public void update() {
        pb.setProgress(timerProgress);
        myCountDownTimer = new MyCountDownTimer(10000, 100);
        myCountDownTimer.start();
        tv_pregunta.setText(preguntes.get(actual).getEnunciat());
        et_resposta.getText().clear();
        actual++;
        tv_current.setText(actual + " de 5");
    }

    //Timer
    public class MyCountDownTimer extends CountDownTimer {
        public MyCountDownTimer(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            int progress = (int) (millisUntilFinished / 100);
            pb.setProgress(progress);
        }

        @Override
        public void onFinish() {
            pb.setProgress(0);
            Toast.makeText(PreguntesActivity.this, "Se acabó el tiempo!", Toast.LENGTH_SHORT).show();

            if (actual<preguntes.size()){
                update();
            }else {
                finalizar();
            }
        }
    }
}