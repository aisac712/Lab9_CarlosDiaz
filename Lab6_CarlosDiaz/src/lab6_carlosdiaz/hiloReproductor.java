package lab6_carlosdiaz;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;

public class hiloReproductor extends Thread{
    private JProgressBar barraP;
    private JProgressBar barraS;
    private double limiteP;
    private double limiteS;
    private JComboBox cb;
    private PlayList p;
    private boolean avanzar;
    private boolean vive;

    public hiloReproductor(JProgressBar barraP, JProgressBar barraS, double limiteP, double limiteS, JComboBox cb, PlayList p) {
        this.barraP = barraP;
        this.barraS = barraS;
        this.limiteP = limiteP;
        this.limiteS = limiteS;
        this.cb = cb;
        this.p = p;
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
        int cont=1;
        while(vive){
            if(avanzar){
                
                barraP.setValue(barraP.getValue()+1);
                barraS.setValue(barraS.getValue()+1);
                
                if(barraS.getValue()==limiteS){
                    //System.out.println(cont);
                    DefaultComboBoxModel dc = (DefaultComboBoxModel) cb.getModel();
                    if(cont<p.getRolitas().size()){
                        dc.addElement(p.getRolitas().get(cont));
                        cb.setModel(dc);    cb.setSelectedIndex(cont);

                        barraS.setValue(0);
                        
                        limiteS = (int) p.getRolitas().get(cont).getDuarion();
                        
                        System.out.println("Se añadió la "+p.getRolitas().get(cont).getNombreC()+" "+limiteS);
                    }else{
                        //barraS.setValue(0);
                    }
                    cont++;
                }
                
                if(barraP.getValue()==limiteP){
                    JOptionPane.showMessageDialog(null, "Se acabó la diversión. Pongamos otra!\n"+"*Nota: si los bars no están sincronizados es por la diferencia que hacen"
                            + " los ints debido a que originalmente son doubles");
                    barraP.setValue(0);
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
