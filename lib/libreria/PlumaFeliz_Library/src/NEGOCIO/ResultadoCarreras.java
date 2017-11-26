/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NEGOCIO;

import CLASES.Carreras;
import CLASES.Participante;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author esau_br
 */
public class ResultadoCarreras {
    
  
   Registros registro;
   public HashMap<String,Participante> lista;
   Carreras carrera;
    
   public void registraResultadosCarrera(String NomArchivo, String idCarrera) throws IOException{
       
       Carreras car;
       Participante part = new Participante();
       
        
       car = (Carreras) registro.BuscaRegistro(NomArchivo,idCarrera);

            for(Map.Entry list: car.getListParticipante().entrySet()){
                  Random rnd = new Random();
                    int minutos= rnd.nextInt(61);
                     int segundos = rnd.nextInt(61);
                    String tiempo = String.valueOf(minutos)+":"+String.valueOf(segundos); 
                    
                    
                   String key = (String) list.getKey();
                   
                   
                   Participante valor =  (Participante) list.getValue();
                    valor = new Participante(valor.getCodornizID(),tiempo);
                   
                 list.setValue(valor);
                
            }
            
   
   }
   
  

}
