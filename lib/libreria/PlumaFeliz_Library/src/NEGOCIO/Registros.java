/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NEGOCIO;

import CLASES.Codornices;
import CLASES.Carreras;
import CLASES.Participante;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import javax.swing.JOptionPane;


/**
 *
 * @author esau_br
 */
public class Registros implements Serializable{
   // File archivo = new File("codorniz.txt");
    
   // archivo
    public Codornices codorniz;
    public Carreras carrera;
    
    public Participante participante;
    public FileInputStream lee ;  
    public ObjectInputStream bLee;
    
 
    public FileOutputStream escribe;
    public ObjectOutputStream bEscribe;
    
    
    
    String arch_codornices = "codornices.txt";
    String arch_Carreras = "carreras.txt";
    
    
    
    public Registros(){
      codorniz = null;
      escribe =null ;    
    
    }
    
    public boolean GeneraArchivo(String nombArchivo) throws IOException{
        boolean resultado;
          
        escribe= new FileOutputStream(nombArchivo);
        bEscribe = new ObjectOutputStream(escribe);
        escribe.close();
        bEscribe.close();
       
        resultado = true;
        return resultado;
    }
    

//******** Metodos Sobrecargados para generar Registros de Codornices y Carreras
public void GeneraRegistro(Codornices cod) throws IOException{
  
            
      escribe= new FileOutputStream(arch_codornices, true);
                bEscribe = new ObjectOutputStream(escribe);

    
    String id= "";
   // cod = new Codornices(id,nombreCod, edadCod, especieCod, pesoCod, propietarioCod);
        boolean existe;
        
            existe = ValidaRegistro(arch_codornices,codorniz.getNumID());
               if(existe==false){

                
                bEscribe.writeObject(cod);
                bEscribe.flush();   
                bEscribe.close();
                escribe.flush();
                escribe.close();
                
                 }else {
                       JOptionPane.showMessageDialog(null,"El Codorniz "+codorniz.getNumID()+"no existe" + "Por favor Genere el registro del AVE");
                }
 
}
            
public void GeneraRegistro(String idCarrera,String fecha, String listaPart,String idParticipante) throws IOException{
  
    escribe= new FileOutputStream(arch_Carreras, true);
                bEscribe = new ObjectOutputStream(escribe);
    String id= "";
    Carreras _carrera  = new Carreras();
    
    _carrera.agregaParticipante(idParticipante);
    
            carrera = new Carreras (idCarrera, fecha, _carrera.getListParticipante());
 
              bEscribe.writeObject(carrera);
                bEscribe.flush();   
                bEscribe.close();
                escribe.flush();
                escribe.close();

}  

//**************FIn de metodos sobrecargados**********
        

public void MuestraRegistros(String nombArchivoCod) throws IOException, ClassNotFoundException{
    String resultado= null;
    lee = new FileInputStream(nombArchivoCod);
    bLee = new ObjectInputStream(lee);
    boolean fin = true;
    
    Codornices cod;
    try{

        while(bLee.readObject() != null){
        
        
        cod = (Codornices)bLee.readObject();     
        resultado +=cod.toString();
          bEscribe.flush();   
                bEscribe.close();
                escribe.flush();
                escribe.close();
     
        }


            } catch(EOFException endOfFileException){
          
     }   
  //  return resultado;
}    

//***** Metodo busca el registro que se esta buscando segun el archivo y el ID que se requiera  e Imprime
public Object BuscaRegistro(String nombArchivo,String id) throws IOException{
    Object resultado= null;
    int cont= 0;
    String valor = null;
    boolean existe = false;
    
    Codornices cod;
    Carreras ca;
    
   lee = new FileInputStream(nombArchivo);
    bLee = new ObjectInputStream(lee);
    try{
        switch(nombArchivo){
            
            case "codornices.txt":
                    
                while(bLee.readObject()!= null){
                    cod = (Codornices)bLee.readObject();    
                    valor = cod.getNumID();
                
                
        
                 if(valor.equals(id.toUpperCase()))
                         
                 resultado= cod;
                 break;
       
                 }
                
                  bEscribe.flush();   
                bEscribe.close();
                escribe.flush();
                escribe.close();
                break;
                
            case "carreras.txt":
                while(bLee.readObject()!= null){
                
                    ca = (Carreras)bLee.readObject();
                    valor = ca.getCarreraID();
                    
                 if(valor.equals(id)){
                     resultado= ca;
                     break;
                 }
                
       
                 }
                
                        bEscribe.flush();   
                bEscribe.close();
                escribe.flush();
                escribe.close();
                    break;
                
          

        }
    
        }catch(Exception e){
         System.out.println(e.getMessage());
    }
    return resultado;
}



///retorna true si el registro existe
public boolean ValidaRegistro(String nombArchivo,String id) throws IOException{
    boolean resultado= false;
    int cont= 0;
    String valor = null;
    boolean existe = false;
    
    Codornices cod;
    Carreras ca;
    
   lee = new FileInputStream(nombArchivo);
    bLee = new ObjectInputStream(lee);
    try{
        switch(nombArchivo){
            
            case "codornices.txt":
                    
                while(bLee.readObject()!= null){
                    cod = (Codornices)bLee.readObject();    
                    valor = cod.getNumID();
                
                
        
                 if(valor.equals(id.toUpperCase()))
                         
                 resultado= true;
                 break;
       
                 }
                
                  bEscribe.flush();   
                bEscribe.close();
                escribe.flush();
                escribe.close();
                break;
                
            case "carreras.txt":
                while(bLee.readObject()!= null){
                
                    ca = (Carreras)bLee.readObject();
                    valor = ca.getCarreraID();
                    
                 if(valor.equals(id)){
                     resultado= true;
                     break;
                 }
                
       
                 }
                
                        bEscribe.flush();   
                bEscribe.close();
                escribe.flush();
                escribe.close();
                    break;
                
          

        }
    
        }catch(Exception e){
         System.out.println(e.getMessage());
    }
    return resultado;
}

    
}


