package lab6_carlosdiaz;

import javax.swing.JOptionPane;
import javax.swing.JProgressBar;

public class hiloPlayList extends Thread{
    private JProgressBar barra;
    private boolean avanzar;
    private boolean vive;
    private double limite;
    
    public hiloPlayList(JProgressBar barra, double limite) {
        this.barra = barra;
        this.limite = limite;
        avanzar=true;
        vive=true;
    }

    public boolean isAvanzar() {
        return avanzar;
    }

    public void setAvanzar(boolean avanzar) {
        this.avanzar = avanzar;
    }

    public boolean isVive() {
        return vive;
    }

    public void setVive(boolean vive) {
        this.vive = vive;
    }
    
    @Override
    public void run(){
        while(vive){
            if(avanzar){
                barra.setValue(barra.getValue()+1);
                if(barra.getValue()==limite){
                    JOptionPane.showMessageDialog(null, "Se acabó la diversión. Pongamos otra!"+limite);
                    barra.setValue(0);
                    vive=false;
                }
            } //FIN IF
            
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
            }
        }
    }
}
