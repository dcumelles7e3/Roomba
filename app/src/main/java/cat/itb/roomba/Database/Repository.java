package cat.itb.roomba.Database;

import java.util.List;

public class Repository {
    PreguntaDao pDao;
    PuntuacioDao punDao;

    public Repository(PreguntaDao pDao, PuntuacioDao punDao){
        this.pDao = pDao;
        this.punDao = punDao;
    }

    public List<Pregunta> getPreguntes(){
        return this.pDao.getFive();
    }

    public int getCountPreguntes(){return this.pDao.getCountPreguntes();}
}
