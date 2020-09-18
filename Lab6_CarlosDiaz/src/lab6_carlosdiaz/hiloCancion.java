package lab6_carlosdiaz;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;

public class hiloCancion extends Thread{
    private JProgressBar barraS;
    private double limiteS;
    private JComboBox cb;
    private PlayList p;
    private boolean avanzar;
    private boolean vive;

    public hiloCancion(JProgressBar barraS, double limiteS, JComboBox cb, PlayList p) {
        this.barraS = barraS;
        this.limiteS = limiteS;
        this.cb = cb;
        this.p = p;
        this.avanzar=true;
        this.vive=true;
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
        int i=0;
        while(vive){
            
            if(avanzar){
                barraS.setValue(barraS.getValue()+1);
                
                if(barraS.getValue()==limiteS){
                    System.out.println(i);
                    DefaultComboBoxModel dc = (DefaultComboBoxModel) cb.getModel();
                    dc.addElement(p.getRolitas().get(i));
                    cb.setModel(dc);
                    
                    barraS.setValue(0);
                    limiteS = p.getRolitas().get(i).getDuarion();
                    System.out.println("Se añadió la "+p.getRolitas().get(i).getNombreC()+" "+limiteS);
                            
                    i++;
                }
                
                if(i==p.getRolitas().size()){
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
