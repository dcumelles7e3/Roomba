package cat.itb.roomba.Database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface PuntuacioDao {
    @Query("SELECT * FROM puntuacio_table")
    List<Puntuacio> getAll();

    @Insert
    void insert(Puntuacio p);

    @Update
    void update(Puntuacio p);

    @Delete
    void delete(Puntuacio p);

    @Query("SELECT * FROM puntuacio_table WHERE id_puntuacio = :idPuntuacio")
    Puntuacio findById(int idPuntuacio);

}
