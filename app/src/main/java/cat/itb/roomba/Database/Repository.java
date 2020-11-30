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

    public List<Puntuacio> getPuntuacions(){
        return this.punDao.getAll();
    }

    public void deleteAllPreguntes(){this.pDao.dropPreguntes();}
    public int getCountPreguntes(){return this.pDao.getCountPreguntes();}
    public void insertPregunta(Pregunta p) {this.pDao.insert(p);}
    public void deletePregunta(Pregunta p) {this.pDao.delete(p);}
    public Pregunta findPreguntaById(int idPregunta){return this.pDao.findById(idPregunta);}
    public void insertPuntuacio(Puntuacio p) {this.punDao.insert(p);}
    public void deletePuntuacio(Puntuacio p) {this.punDao.delete(p);}
    public Puntuacio findPuntuacioById(int idPuntuacio){return this.punDao.findById(idPuntuacio);}
}
