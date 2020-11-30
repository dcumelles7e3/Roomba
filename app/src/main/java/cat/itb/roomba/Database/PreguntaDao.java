package cat.itb.roomba.Database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface PreguntaDao {
    @Insert
    void insert(Pregunta p);

    @Query("SELECT COUNT(*) FROM pregunta_table")
    int getCountPreguntes();

    @Query("SELECT * FROM pregunta_table ORDER BY RANDOM() LIMIT 5")
    List<Pregunta> getFive();

    @Query("DELETE FROM pregunta_table")
    void dropPreguntes();
}
