package lab6_carlosdiaz;

import java.util.ArrayList;

public class PlayList {
    private String nombreP;
    private double duracion=0;
    
    ArrayList<Cancion> rolitas = new ArrayList();

    public PlayList() {
    }

    public PlayList(String nombreP) {
        this.nombreP = nombreP;
    }
    
    public PlayList(String nombreP, double duracion) {
        this.nombreP = nombreP;
        this.duracion = duracion;
    }
    
    public String getNombreP() {
        return nombreP;
    }

    public void setNombreP(String nombreP) {
        this.nombreP = nombreP;
    }

    public ArrayList<Cancion> getRolitas() {
        return rolitas;
    }

    public void setRolitas(ArrayList<Cancion> rolitas) {
        this.rolitas = rolitas;
    }

    public double getDuracion() {
        return duracion;
    }

    public void setDuracion(double duracion) {
        this.duracion = duracion;
    }
    
    @Override
    public String toString() {
        return nombreP + ", rolitas:" + rolitas;
    }
    
}
