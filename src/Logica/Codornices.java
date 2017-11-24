
package Logica;

import java.util.Random;

/**
 *
 * @author esau.brizuela
 */
public class Codornices {
    
    private String idCodorniz;
    private String nombre;
    private int edad;
    private String especie;
    private String duenno;
    
    public Codornices()
    {
        
    }
    
    public Codornices(String idCodorniz, String nombre, int edad, String especie, String duenno)
    {
        this.idCodorniz = idCodorniz;
        this.nombre = nombre;
        this.edad = edad;
        this.especie = especie;
        this.duenno = duenno;
       
    }
    
    private void setIdCodorniz()
    {   
        String idcodorniz;
        
        Random rnd = new Random(System.currentTimeMillis());
        int num = rnd.nextInt(999);
        String subString = nombre.substring(0,3);
        
        String hilera = subString+num;
        
        idcodorniz = hilera;
        
        this.idCodorniz = idcodorniz;
    }
    
    public String getIdCodorniz()
    {
        return idCodorniz;
    }
    
    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }
    
    public String getNombre()
    {
        return nombre;
    }
    
    public void setEdad(int edad)
    {
        this.edad = edad;
    }
    
    public int getEdad()
    {
        return edad;
    }
    
    public void setEspecie(String especie)
    {
        this.especie = especie;
    }
    
    public String getEspecie()
    {
        return especie;
    }
    
    public void setDuenno(String duenno)
    {
        this.duenno = duenno;
    }
    
    public String getDuenno()
    {
        return duenno;
    }

    @Override
    public String toString() {
        return "Codornices{" + "idCodorniz=" + idCodorniz + ", nombre=" + nombre + ", edad=" + edad + ", especie=" + especie + ", duenno=" + duenno + '}';
    }
    
    
    
    
    
    
}
