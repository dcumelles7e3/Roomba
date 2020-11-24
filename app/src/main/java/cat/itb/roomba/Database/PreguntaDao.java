package cat.itb.roomba.Database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface PreguntaDao {
    @Query("SELECT * FROM pregunta_table")
    List<Pregunta> getAll();

    @Insert
    void insert(Pregunta p);

    @Update
    void update(Pregunta p);

    @Delete
    void delete(Pregunta p);

    @Query("SELECT * FROM pregunta_table WHERE id_pregunta = :idPregunta")
    Pregunta findById(int idPregunta);

}