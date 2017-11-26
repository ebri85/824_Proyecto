/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CLASES;

import java.io.Serializable;
import java.util.Random;

/**
 *
 * @author esau_br
 */
public class Codornices implements Serializable{
    
    private String nombre;
    private int edad;
    private String especie;
    private double peso;
    private String numID;
    private String propietario;
    
    public Codornices(){
        numID = "";
        nombre= "";
        int edad= 0;
        especie= "";
        peso = 0.0;
        propietario = "";
        
    }
    public Codornices(String numID,String nombre,int edad,String especie,double peso,String propietario){
        
        this.numID = numID;
        this.nombre = nombre;
        this.edad = edad;
        this.especie = especie;
        this.peso = peso;        
        this.propietario = propietario;
    }
    
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public void setEdad(int edad){
        this.edad= edad;
    }
    
    public int getEdad(){
        return edad;        
    }
    
    public void setEspecie(String especie){
        this.especie = especie;
    }
    
    public String getEspecie(){
        return especie;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getNumID() {
        return numID;
    }

    public void setNumID(String numID) {
        Random rnd = new Random();
        int valor;
        valor= rnd.nextInt(100-999);
        String hilera;
        hilera = getEspecie().substring(0,3)+getPropietario().substring(0,3)+valor;
        numID = hilera.toUpperCase();
        this.numID = numID;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    @Override
    public String toString() {
        return "Codorniz{" +  "numID=" + numID + ", edad=" + edad + ", especie=" + especie + ", peso=" + peso + ", propietario=" + propietario + '}';
    }



   
    
    
}
