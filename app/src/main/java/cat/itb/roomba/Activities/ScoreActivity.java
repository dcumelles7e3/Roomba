package cat.itb.roomba.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import cat.itb.roomba.Adapter.ScoreAdapter;
import cat.itb.roomba.Database.AppDatabase;
import cat.itb.roomba.Database.PreguntaDao;
import cat.itb.roomba.Database.Puntuacio;
import cat.itb.roomba.Database.PuntuacioDao;
import cat.itb.roomba.Database.Repository;
import cat.itb.roomba.R;

public class ScoreActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ScoreAdapter adapter;

    Button b_back;

    static AppDatabase db;
    static PreguntaDao pDao;
    static PuntuacioDao punDao;
    static Repository repo;

    List<Puntuacio> scores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        b_back = findViewById(R.id.volver);
        db = AppDatabase.getInstance(this.getApplicationContext());
        pDao = db.preguntaDao();
        punDao = db.puntuacioDao();
        repo = new Repository(pDao, punDao);

        scores = punDao.getAll();

        recyclerView = findViewById(R.id.score_list);
        adapter = new ScoreAdapter(this,scores);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        b_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater =  getMenuInflater();
        inflater.inflate(R.menu.delete_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.clear_score:
                punDao.dropPuntuacio();
                scores.clear();
                adapter.notifyDataSetChanged();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}