package cat.itb.roomba.Database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Pregunta.class,Puntuacio.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase{
    public static AppDatabase INSTANCE;

    public abstract PreguntaDao preguntaDao();
    public abstract PuntuacioDao puntuacioDao();

    public static AppDatabase getInstance(Context context){
        if (INSTANCE==null){
            INSTANCE = Room.databaseBuilder(context, AppDatabase.class, "Preguntes.db").allowMainThreadQueries().fallbackToDestructiveMigration().build();
        }
        return INSTANCE;
    }
}
