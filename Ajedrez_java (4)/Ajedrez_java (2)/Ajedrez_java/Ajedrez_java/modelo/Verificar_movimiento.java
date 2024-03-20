package modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import controlador.Controlador;


public class Verificar_movimiento {
    
    Map<String, String> diccionario;
    Map<String, Boolean> peones;
    boolean agarrandoB;
    boolean agarrandoN;
    String fichaSeleccionada;
    String numeroFichaSeleccionada;
    boolean turno1;
    ArrayList<Integer> nFichas;
    Integer nJugada;
    Controlador controlador;
    CrearDiccionario crearDiccionario;
    

    public Verificar_movimiento(Controlador controlador){
  
        turno1 = true;
        this.controlador = controlador;
        agarrandoB = false;
        agarrandoN = false;
        nJugada = 0;
        nFichas = new ArrayList<>();
        diccionario = new HashMap<>();
        peones = new HashMap<>();
        crearDiccionario = new CrearDiccionario(diccionario);
        crearDiccionario.crearPeones(peones);
        

    }
    
    public void verificarMovimientos(String pieza){
        System.out.println(diccionario.get(pieza));

        for (Map.Entry<String, String> entrada : diccionario.entrySet()) {

            if(pieza.equals(entrada.getKey())&& entrada.getValue().equals("Casilla")){

                moverCasilla(entrada.getKey(), entrada.getValue());
            }
            else if(pieza.equals(entrada.getKey()) && entrada.getValue().equals("Caballo blanco")){

                moverFichaBlanca(entrada.getKey(), entrada.getValue());
            }
            else if(pieza.equals(entrada.getKey()) && entrada.getValue().equals("Peon blanco")){
                
                moverFichaBlanca(entrada.getKey(), entrada.getValue());
            }
            else if(pieza.equals(entrada.getKey()) && entrada.getValue().equals("Alfil blanco")){
                
                moverFichaBlanca(entrada.getKey(), entrada.getValue());
            }
            else if(pieza.equals(entrada.getKey())  && entrada.getValue().equals("Rey blanco")){
                
                moverFichaBlanca(entrada.getKey(), entrada.getValue());
            }
            else if(pieza.equals(entrada.getKey()) && entrada.getValue().equals("Dama blanca")){
                
                moverFichaBlanca(entrada.getKey(), entrada.getValue());
            }
            else if(pieza.equals(entrada.getKey()) && entrada.getValue().equals("Torre blanca")){
                
                moverFichaBlanca(entrada.getKey(), entrada.getValue());
            }
            else if(pieza.equals(entrada.getKey()) && entrada.getValue().equals("Caballo negro")){
                
                moverFichaNegra(entrada.getKey(), entrada.getValue());
            }
            else if(pieza.equals(entrada.getKey()) && entrada.getValue().equals("Peon negro")){
                
                moverFichaNegra(entrada.getKey(), entrada.getValue());
            }
            else if(pieza.equals(entrada.getKey()) && entrada.getValue().equals("Alfil negro")){
                
                moverFichaNegra(entrada.getKey(), entrada.getValue());
            }
            else if(pieza.equals(entrada.getKey()) && entrada.getValue().equals("Rey negro")){
                
                moverFichaNegra(entrada.getKey(), entrada.getValue());
            }
            else if(pieza.equals(entrada.getKey()) && entrada.getValue().equals("Dama negra")){
                
                moverFichaNegra(entrada.getKey(), entrada.getValue());
            }
            else if(pieza.equals(entrada.getKey()) && entrada.getValue().equals("Torre negra")){
                
                moverFichaNegra(entrada.getKey(), entrada.getValue());
            }
            

        }
        System.out.println("Agarrando negras: "+agarrandoN+", Agarrando blancas: "+agarrandoB);


    }
    public void moverCasilla(String clave, String valor){

        System.out.println("clave: "+ clave);
        for (Integer ficha : nFichas) {
            System.out.println("Ficha: "+ficha);
        }
        if(agarrandoB == true && nFichas.contains(Integer.parseInt(clave))){

            if (peones.containsKey(numeroFichaSeleccionada)) {
                if(fichaSeleccionada.equals("Peon blanco") && peones.get(numeroFichaSeleccionada) == false){

                    peones.remove(numeroFichaSeleccionada);
                    peones.put(clave, true);
                }
            }
            
            controlador.cambiarVista(numeroFichaSeleccionada, clave);
            diccionario.put(clave, fichaSeleccionada);
            diccionario.put(numeroFichaSeleccionada,"Casilla");

            agarrandoB = false;
            turno1 = false;
            nJugada ++;
        }
        if(agarrandoN == true && nFichas.contains(Integer.parseInt(clave))){

            if(peones.containsKey(numeroFichaSeleccionada)){
                if(fichaSeleccionada.equals("Peon negro") && peones.get(numeroFichaSeleccionada) == false){
                    peones.remove(numeroFichaSeleccionada);
                    peones.put(clave, true);
                }
            }
            
            System.out.println("Entra");
            controlador.cambiarVista(numeroFichaSeleccionada, clave);
            diccionario.put(clave, fichaSeleccionada);
            diccionario.put(numeroFichaSeleccionada,"Casilla");

            agarrandoN = false;
            turno1 = true;
            nJugada++;
        }
    }
    public void moverFichaBlanca(String clave, String valor){

        if(agarrandoB == true && turno1 == true){

            fichaSeleccionada = diccionario.get(clave);
            numeroFichaSeleccionada = clave;
            nMovimiento(valor, clave);

        }
        else if(agarrandoB == false && turno1 == true){
            fichaSeleccionada = diccionario.get(clave);
            numeroFichaSeleccionada = clave;
            agarrandoB = true;
            nMovimiento(valor, clave);
        }
        else if(agarrandoN == true && turno1 == false && nFichas.contains(Integer.parseInt(clave))){

            controlador.cambiarVista(numeroFichaSeleccionada, clave);
            diccionario.put(clave, fichaSeleccionada);
            diccionario.put(numeroFichaSeleccionada, "Casilla");
            agarrandoN = false;
            turno1 = true;
        }

    }
    public void moverFichaNegra(String clave, String valor){
        if(agarrandoN == true && turno1 == false){
            fichaSeleccionada = diccionario.get(clave);
            numeroFichaSeleccionada = clave;
            nMovimiento(valor, clave);
        }
        else if(agarrandoN == false && turno1 == false){
            
            fichaSeleccionada = diccionario.get(clave);
            numeroFichaSeleccionada = clave;
            agarrandoN = true;
            nMovimiento(valor, clave);

        }
        else if(agarrandoB == true && turno1 == true && nFichas.contains(Integer.parseInt(clave))){
            controlador.cambiarVista(numeroFichaSeleccionada, clave);
            diccionario.put(clave, fichaSeleccionada);
            diccionario.put(numeroFichaSeleccionada, "Casilla");
            agarrandoB = false;
            turno1 = false;
        }

    }
    public ArrayList<Integer> nMovimiento(String value, String clave){
    
        nFichas.clear();

        if(value.equals("Caballo blanco") || value.equals("Caballo negro")){
            
            if( (Integer.parseInt(clave) + 6) < 65 && (Integer.parseInt(clave) + 6) > 0){
                nFichas.add(Integer.parseInt(clave) + 6);
            }
            if( (Integer.parseInt(clave) + 10) < 65 && (Integer.parseInt(clave)) + 10 > 0){
                nFichas.add(Integer.parseInt(clave) + 10);
            }
            if( (Integer.parseInt(clave) + 17) < 65 && (Integer.parseInt(clave) + 17) > 0){
                nFichas.add(Integer.parseInt(clave) + 17);
            }
            if( (Integer.parseInt(clave) + 15) < 65 && (Integer.parseInt(clave) + 15) > 0){
                nFichas.add(Integer.parseInt(clave) + 15);
            }
            if( (Integer.parseInt(clave) - 10) < 65 && (Integer.parseInt(clave) - 10) > 0){
                nFichas.add(Integer.parseInt(clave) - 10);
            }
            if( (Integer.parseInt(clave) - 6) < 65 && (Integer.parseInt(clave) - 6) > 0){
                nFichas.add(Integer.parseInt(clave) - 6);
            }
            if( (Integer.parseInt(clave) - 15) < 65 && (Integer.parseInt(clave) - 15) > 0){
                nFichas.add(Integer.parseInt(clave) - 15);
            }
            if( (Integer.parseInt(clave) - 17) < 64 && (Integer.parseInt(clave) - 17) > 0){
                nFichas.add(Integer.parseInt(clave) - 17);
            }
        }

        else if((value.equals("Rey blanco")) || (value.equals("Rey negro"))){
            
            if( (Integer.parseInt(clave) + 1) < 64 && (Integer.parseInt(clave) + 1) > 0){
                nFichas.add(Integer.parseInt(clave) + 1);
            }
            if( (Integer.parseInt(clave) + 7) < 64 && (Integer.parseInt(clave) + 7) > 0){
                nFichas.add(Integer.parseInt(clave) + 7);
            }
            if( (Integer.parseInt(clave) + 8) < 64 && (Integer.parseInt(clave) + 8) > 0){
                nFichas.add(Integer.parseInt(clave) + 8);
            }
            if( (Integer.parseInt(clave) + 9) < 64 && (Integer.parseInt(clave) + 9) > 0){
                nFichas.add(Integer.parseInt(clave) + 9);
            }
            if( (Integer.parseInt(clave) - 1) < 64 && (Integer.parseInt(clave) - 1) > 0){
                nFichas.add(Integer.parseInt(clave) - 1);
            }
            if( (Integer.parseInt(clave) - 7) < 64 && (Integer.parseInt(clave) - 7) > 0){
                nFichas.add(Integer.parseInt(clave) - 7);
            }
            if( (Integer.parseInt(clave) - 8) < 64 && (Integer.parseInt(clave) - 8) > 0){
                nFichas.add(Integer.parseInt(clave) - 8);
            }
            if( (Integer.parseInt(clave) - 9) < 64 && (Integer.parseInt(clave) - 9) > 0){
                nFichas.add(Integer.parseInt(clave) - 9);
            }

        }
        else if(value.equals("Peon blanco") || value.equals("Peon negro")){
            boolean contiene;

            contiene = peones.containsKey(clave);
            
            if(value.equals("Peon blanco")){
                if(contiene){
                    if(peones.get(clave) == false && contiene){
                        nFichas.add(Integer.parseInt(clave)- 16);
                    }
                }
                
                if( (Integer.parseInt(clave) - 8) < 64 && (Integer.parseInt(clave) -8) > 0 && diccionario.get(""+(Integer.parseInt(clave) - 8)).equals("Casilla")){
                    nFichas.add(Integer.parseInt(clave) -8);
                }
                if(diccionario.get(""+(Integer.parseInt(clave) - 7)).matches(".*\\b(negro|negra)")){
                    nFichas.add(Integer.parseInt(clave) -7);
                }
                if(diccionario.get(""+(Integer.parseInt(clave) - 9)).matches(".*\\b(negro|negra)")){
                    nFichas.add(Integer.parseInt(clave) -9);
                }
            }
            if(value.equals("Peon negro")){
                if(contiene){
                    if(peones.get(clave) == false){
                        nFichas.add(Integer.parseInt(clave) + 16);
                    }
                }
                
                if( (Integer.parseInt(clave) + 8) < 64 && (Integer.parseInt(clave) +8) > 0 && diccionario.get(""+(Integer.parseInt(clave) + 8)).equals("Casilla")){
                    nFichas.add(Integer.parseInt(clave) +8);
                }
                if(diccionario.get(""+(Integer.parseInt(clave) + 7)).matches(".*\\b(blanco|blanca)")){
                    nFichas.add(Integer.parseInt(clave) +7);
                }
                if(diccionario.get(""+(Integer.parseInt(clave) + 9)).matches(".*\\b(blanco|blanca)")){
                    nFichas.add(Integer.parseInt(clave) +9);
                }
            }
            
        
        }

        else if(value.equals("Alfil blanco")||value.equals("Alfil negro")){
            for (int i = Integer.parseInt(clave) + 7 ; i < 64; i +=7) {
                if(!(diccionario.get(""+ (i)).equals("Casilla"))){
                    nFichas.add(i);
                    i = 64;
                }
                else{
                    nFichas.add(i);
                }
                
            }
            for (int i = Integer.parseInt(clave) + 9; i < 64; i += 9) {
                if(!diccionario.get(""+ (i)).equals("Casilla")){
                    nFichas.add(i);
                    i = 64;
                }
                else{
                    nFichas.add(i);
                }
            }
            for (int i = Integer.parseInt(clave) - 7; i >= 0; i -=7) {
                if(!diccionario.get(""+ (i)).equals("Casilla")){
                    nFichas.add(i);
                    
                    i = -1;
                }
                else{
                    nFichas.add(i);
                }
                
            }
            for (int i = Integer.parseInt(clave) - 9; i >= 0; i -=9) {
                
                if(!diccionario.get(""+ (i)).equals("Casilla")){
                    nFichas.add(i);
                    i = -1;
                }
                else{
                    nFichas.add(i);
                    System.out.println("entra");
                }
            }
        }
        
        else if(value.equals("Torre blanca")|| value.equals("Torre negra")){
            for(int i = Integer.parseInt(clave); i < 64 ; i++){

                
                if(((!diccionario.get(""+ (i)).equals("Casilla")) && Integer.parseInt(clave) != i) || (i % 8 == 7)){
                    nFichas.add(i);
                    i = 64;
                }
                else{
                    nFichas.add(i);
                }

            }
            for(int i = Integer.parseInt(clave); i >= 0 ; i--){

                if(((!diccionario.get(""+ (i)).equals("Casilla")) && Integer.parseInt(clave) != i)|| (i % 8 == 0)){
                    nFichas.add(i);
                    i = -1;
                }
                else{
                    nFichas.add(i);
                }

            }
            for(int i = Integer.parseInt(clave)+8; i < 64 ; i +=8){

                if(!diccionario.get(""+ (i)).equals("Casilla")){
                    nFichas.add(i);
                    i = 64;
                }
                else{
                    nFichas.add(i);
                }

            }
            for(int i = Integer.parseInt(clave)- 8; i >= 0 ; i -=8){

                if(!diccionario.get(""+ (i)).equals("Casilla")){
                    nFichas.add(i);
                    i = -1;
                }
                else{
                    nFichas.add(i);
                }

            }

        }
        else if(value.equals("Dama blanca") || value.equals("Dama negra")){
            for (int i = Integer.parseInt(clave) + 7 ; i < 64; i +=7) {
                if(!(diccionario.get(""+ (i)).equals("Casilla"))){
                    nFichas.add(i);
                    i = 64;
                }
                else{
                    nFichas.add(i);
                }
                
            }
            for (int i = Integer.parseInt(clave) + 9; i < 64; i += 9) {
                if(!diccionario.get(""+ (i)).equals("Casilla")){
                    nFichas.add(i);
                    i = 64;
                }
                else{
                    nFichas.add(i);
                }
            }
            for (int i = Integer.parseInt(clave) - 7; i >= 0; i -=7) {
                if(!diccionario.get(""+ (i)).equals("Casilla")){
                    nFichas.add(i);
                    
                    i = -1;
                }
                else{
                    nFichas.add(i);
                }
                
            }
            for (int i = Integer.parseInt(clave) - 9; i >= 0; i -=9) {
                
                if(!diccionario.get(""+ (i)).equals("Casilla")){
                    nFichas.add(i);
                    i = -1;
                }
                else{
                    nFichas.add(i);
                    System.out.println("entra");
                }
            }
            for(int i = Integer.parseInt(clave); i < 64 ; i++){

                
                if(((!diccionario.get(""+ (i)).equals("Casilla")) && Integer.parseInt(clave) != i) || (i % 8 == 7)){
                    nFichas.add(i);
                    i = 64;
                }
                else{
                    nFichas.add(i);
                }

            }
            for(int i = Integer.parseInt(clave); i >= 0 ; i--){

                if(((!diccionario.get(""+ (i)).equals("Casilla")) && Integer.parseInt(clave) != i)|| (i % 8 == 0)){
                    nFichas.add(i);
                    i = -1;
                }
                else{
                    nFichas.add(i);
                }

            }
            for(int i = Integer.parseInt(clave)+8; i < 64 ; i +=8){

                if(!diccionario.get(""+ (i)).equals("Casilla")){
                    nFichas.add(i);
                    i = 64;
                }
                else{
                    nFichas.add(i);
                }

            }
            for(int i = Integer.parseInt(clave)- 8; i >= 0 ; i -=8){

                if(!diccionario.get(""+ (i)).equals("Casilla")){
                    nFichas.add(i);
                    i = -1;
                }
                else{
                    nFichas.add(i);
                }

            }
        }
    return nFichas;

    }
}
