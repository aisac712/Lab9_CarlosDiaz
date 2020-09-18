package lab6_carlosdiaz;

import java.sql.Time;

public class Cancion {
    private String nombreC;
    private int puntuación;  //(escala del 1 al 10).
    private int año;         //en que salió.
    private String artista;
    private String album;
    private double duarion;

    public Cancion() {
    }

    public Cancion(String nombreC, int puntuación, int año, String artista, String album) {
        this.nombreC = nombreC;
        this.puntuación = puntuación;
        this.año = año;
        this.artista = artista;
        this.album = album;
    }

    public String getNombreC() {
        return nombreC;
    }

    public void setNombreC(String nombreC) {
        this.nombreC = nombreC;
    }

    public int getPuntuación() {
        return puntuación;
    }

    public void setPuntuación(int puntuación) {
        this.puntuación = puntuación;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public double getDuarion() {
        return duarion;
    }

    public void setDuarion(double duarion) {
        this.duarion = duarion;
    }
    
    @Override
    public String toString() {
        return nombreC +";"+ puntuación +";"+ año +";"+ artista +";"+ album+";"+duarion;
    }
    
}
