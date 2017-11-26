/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CLASES;

import java.util.Date;
import java.util.Random;
import jdk.internal.dynalink.linker.ConversionComparator;



/**
 *
 * @author esau_br
 */
public class Participante {
    
    private String codornizID;
    private String tiempo;
    
    


      
    public Participante(){
        this.codornizID = "";
        this. tiempo = "";
        
    }
    
 
     public Participante(String codornizID){
        this.codornizID = codornizID;
                
    }
    public Participante(String codornizID,String tiempo){
        
       
        this.codornizID = codornizID;
        
        
        this.tiempo = tiempo;
        
    }

    public String getCodornizID() {
        return codornizID;
    }

    public void setCodornizID(String codornizID) {
             
        this.codornizID = codornizID;
    }

    public String getTiempo() {
        return tiempo;
    }

    public void setTiempo(String tiempo) {
        
        this.tiempo = tiempo;
    }

    @Override
    public String toString() {
        return "Participante{" + "codornizID=" + codornizID + ", tiempo=" + tiempo + '}';
    }

  
}
