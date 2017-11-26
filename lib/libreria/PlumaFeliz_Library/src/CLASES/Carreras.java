/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CLASES;

import NEGOCIO.Registros;
import java.io.IOException;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.HashMap;
import java.util.Random;
import javax.swing.JOptionPane;


/**
 *
@author esau_br
 */
public class Carreras implements Serializable {
    
    private String carreraID;
    private String fecha;
    private HashMap<String,String> listParticipante;
    Registros rg = new Registros();
    
    
    
    public Carreras(){
        this.carreraID = "";
        this.fecha = null;
        this.listParticipante = null;
    }

    public Carreras(String carreraID, String fecha, HashMap<String,String> listParticipante) {
        this.carreraID = carreraID;
        this.fecha = fecha;
        this.listParticipante = listParticipante;
    }

    public String getCarreraID() {
        return carreraID;
    }

    public void setCarreraID(String carreraID) {
        Random rnd = new Random();
        int valor;
        valor= rnd.nextInt(100-999);
        String hilera;
        hilera = getFecha().substring(0,3)+valor;
        carreraID = hilera;
        this.carreraID = carreraID;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        
        SimpleDateFormat df = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss");
        df.applyPattern(fecha);
        this.fecha = fecha;
    }

    public HashMap<String,String> getListParticipante() {
        return listParticipante;
    }

    public void setListParticipante(HashMap<String,String> listParticipante) {
       
                  this.listParticipante = listParticipante;
    }

    @Override
    public String toString() {
        return "Carrera{" + "carreraID=" + carreraID + ", fecha=" + fecha + ", listParticipante=" + listParticipante + '}';
    }
    
    public boolean agregaParticipante(String idCod) throws IOException{
        boolean resultado = false;
      
       Participante participante;
    for(int i =1; i<=5; i++){

       if(rg.ValidaRegistro("carreras.txt",idCod)== true){
           
           participante = new Participante(idCod);
           
            listParticipante.put(fecha, participante.getCodornizID().toUpperCase());

           resultado = true;
         }else {
           
          JOptionPane.showMessageDialog(null,"La Codorniz que desea Registrar no Existe, Por favor registrarlo pimero");
         }
       
    }
    

        return resultado;
    }
    
    
}
