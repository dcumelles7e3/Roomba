package cat.itb.roomba.Database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface PuntuacioDao {
    @Query("SELECT * FROM puntuacio_table ORDER BY puntuacio DESC")
    List<Puntuacio> getAll();

    @Insert
    void insert(Puntuacio p);

    @Query("DELETE FROM puntuacio_table")
    void dropPuntuacio();
}
