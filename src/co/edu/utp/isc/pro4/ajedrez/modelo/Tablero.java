/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.pro4.ajedrez.modelo;

/**
 *
 * @author utp
 */
public class Tablero {

    private final Casilla[][] casillas;

    public Tablero() {
        casillas = new Casilla[8][];
        for (int i = 0; i < 8; i++) {
            casillas[i] = new Casilla[8];
            for (int j = 0; j < 8; j++) {
                casillas[i][j] = new Casilla(
                        (i + j) % 2 == 0 ? Color.NEGRO : Color.BLANCO,
                        i + 1,
                        (char) ('A' + j));
            }
        }
    }

    public Casilla getCasilla(int fila, int columna) {
        return casillas[fila][columna];
    }

    public Casilla getCasilla(String posicion) {
        int columna = posicion.charAt(0) - 'A';
        int fila = Integer.valueOf(posicion.substring(1)) - 1;
        return getCasilla(fila, columna);
    }
    
    public Casilla getCasilla(int fila,char Columna){
        int columna = Columna - 'A';
        return getCasilla(fila-1,columna);
    }

    public boolean isAmenazada(Color color,Casilla casilla){
        return isAlcanzablePorCaballo(color,casilla)||isAlcanzablePorTorre(color,casilla)||isAlcanzablePorReyna(color,casilla)||isAmenazadaPorRey(color,casilla)||isAlcanzablePorAlfil(color,casilla)||isAmenazadaPorPeon(color,casilla);
    }

    private boolean isAlcanzablePorCaballo(Color color,Casilla casilla) {
        if((casilla.getColumna()>'B')&&(casilla.getFila()>1)){
            if(getCasilla(casilla.getFila()-1,((char)(casilla.getColumna()-2))).isOcupada()){
                if((getCasilla(casilla.getFila()-1,((char)(casilla.getColumna()-2))).getFicha() instanceof Caballo)&&(getCasilla(casilla.getFila()-1,((char)(casilla.getColumna()-2))).getFicha().getColor()!=color))
                {
                    return true;
                }
            }
        }
        if((casilla.getColumna()>'B')&&(casilla.getFila()<8)){
            if(getCasilla(casilla.getFila()+1,((char)(casilla.getColumna()-2))).isOcupada()){
                if((getCasilla(casilla.getFila()+1,((char)(casilla.getColumna()-2))).getFicha() instanceof Caballo)&&(getCasilla(casilla.getFila()+1,((char)(casilla.getColumna()-2))).getFicha().getColor()!=color))
                {
                    return true;
                }
            }  
        }
        if((casilla.getColumna()>'A')&&(casilla.getFila()>2)){
            if(getCasilla(casilla.getFila()-2,((char)(casilla.getColumna()-1))).isOcupada()){
                if((getCasilla(casilla.getFila()-2,((char)(casilla.getColumna()-1))).getFicha() instanceof Caballo)&&(getCasilla(casilla.getFila()-2,((char)(casilla.getColumna()-1))).getFicha().getColor()!=color))
                {
                    return true;
                }
            }   
        }
        if((casilla.getColumna()>'A')&&(casilla.getFila()<7)){
            if(getCasilla(casilla.getFila()+2,((char)(casilla.getColumna()-1))).isOcupada()){
                if((getCasilla(casilla.getFila()+2,((char)(casilla.getColumna()-1))).getFicha() instanceof Caballo)&&(getCasilla(casilla.getFila()+2,((char)(casilla.getColumna()-1))).getFicha().getColor()!=color))
                {
                    return true;
                }
            }
        }
        if((casilla.getColumna()<'G')&&(casilla.getFila()<8)){
            if(getCasilla(casilla.getFila()+1,((char)(casilla.getColumna()+2))).isOcupada()){
                if((getCasilla(casilla.getFila()+1,((char)(casilla.getColumna()+2))).getFicha() instanceof Caballo)&&(getCasilla(casilla.getFila()+1,((char)(casilla.getColumna()+2))).getFicha().getColor()!=color))
                {
                return true;
                }
            }
            
        }
        if((casilla.getColumna()<'G')&&(casilla.getFila()>1)){
            if(getCasilla(casilla.getFila()-1,((char)(casilla.getColumna()+2))).isOcupada()){
                if((getCasilla(casilla.getFila()-1,((char)(casilla.getColumna()+2))).getFicha() instanceof Caballo)&&(getCasilla(casilla.getFila()-1,((char)(casilla.getColumna()+2))).getFicha().getColor()!=color))
                {
                    return true;
                }
            }
        }
        if((casilla.getColumna()<'H')&&(casilla.getFila()>2)){
            if(getCasilla(casilla.getFila()-2,((char)(casilla.getColumna()+1))).isOcupada()){
                if((getCasilla(casilla.getFila()-2,((char)(casilla.getColumna()+1))).getFicha() instanceof Caballo)&&(getCasilla(casilla.getFila()-2,((char)(casilla.getColumna()+1))).getFicha().getColor()!=color))
                {
                    return true;
                }
            }
        }
        if((casilla.getColumna()<'H')&&(casilla.getFila()<7)){
            if(getCasilla(casilla.getFila()+2,((char)(casilla.getColumna()+1))).isOcupada()){
                if((getCasilla(casilla.getFila()+2,((char)(casilla.getColumna()+1))).getFicha() instanceof Caballo)&&(getCasilla(casilla.getFila()+2,((char)(casilla.getColumna()+1))).getFicha().getColor()!=color))
                {
                    return true;
                }
            }    
        }
        return false;
    }

    private boolean isAlcanzablePorReyna(Color color,Casilla casilla) {
        for (int i = casilla.getFila()-1; i >= 1; i--){
            if(getCasilla(i, casilla.getColumna()).isOcupada()){
                if((this.getCasilla(i,casilla.getColumna()).getFicha() instanceof Reina)&&(this.getCasilla(i,casilla.getColumna()).getFicha().getColor()!=color)){
                    return true;
                }
                break;
            }
        }
        for (int i = casilla.getFila()+1; i <= 8; i++){
            if(getCasilla(i, casilla.getColumna()).isOcupada()){
                if((this.getCasilla(i,casilla.getColumna()).getFicha() instanceof Reina)&&(this.getCasilla(i,casilla.getColumna()).getFicha().getColor()!=color)){
                    return true;
                }
                break;
            }
        }
        for (int i = casilla.getColumna()-'A'-1;i>=0;i--){
            if(getCasilla(casilla.getFila()-1,i).isOcupada()){
                if((this.getCasilla(casilla.getFila()-1,i).getFicha() instanceof Reina)&&(this.getCasilla(casilla.getFila()-1,i).getFicha().getColor()!=color)){
                    return true;
                }
                break;
            }
        }
        for (int i = casilla.getColumna()-'A'+1;i<=7;i++){
            if(getCasilla(casilla.getFila()-1,i).isOcupada()){
                if((this.getCasilla(casilla.getFila()-1,i).getFicha() instanceof Reina)&&(this.getCasilla(casilla.getFila()-1,i).getFicha().getColor()!=color)){
                    return true;
                }
                break;
            }
        }
        int inicio1 = casilla.getFila()-1;
        char inicio2 = (char)(casilla.getColumna()-1);
        while(inicio1>=1&&inicio2>='A'){
            if(this.getCasilla(inicio1, inicio2).isOcupada()){
                if((this.getCasilla(inicio1, inicio2).getFicha() instanceof Reina)&&(this.getCasilla(inicio1, inicio2).getFicha().getColor()!=color)){
                    return true;
                }
                break;
            }
            inicio1--;
            inicio2 = (char)(inicio2-1);
        }
        inicio1 = casilla.getFila()-1;
        inicio2 = (char)(casilla.getColumna()+1);
        while(inicio1>=1&&inicio2<='H'){
            if(this.getCasilla(inicio1, inicio2).isOcupada()){
                if((this.getCasilla(inicio1, inicio2).getFicha() instanceof Reina)&&(this.getCasilla(inicio1, inicio2).getFicha().getColor()!=color)){
                    return true;
                }
                break;
            }
            inicio1--;
            inicio2 = (char)(inicio2+1);
        }
        inicio1 = casilla.getFila()+1;
        inicio2 = (char)(casilla.getColumna()-1);
        while(inicio1<=8&&inicio2>='A'){
            if(this.getCasilla(inicio1, inicio2).isOcupada()){
                if((this.getCasilla(inicio1, inicio2).getFicha() instanceof Reina)&&(this.getCasilla(inicio1, inicio2).getFicha().getColor()!=color)){
                    return true;
                }
                break;
            }
            inicio1++;
            inicio2 = (char)(inicio2-1);
        }
        inicio1 = casilla.getFila()+1;
        inicio2 = (char)(casilla.getColumna()+1);
        while(inicio1<=8&&inicio2<='H'){
            if(this.getCasilla(inicio1, inicio2).isOcupada()){
                if((this.getCasilla(inicio1, inicio2).getFicha() instanceof Reina)&&(this.getCasilla(inicio1, inicio2).getFicha().getColor()!=color)){
                    return true;
                }
                break;
            }
            inicio1++;
            inicio2 = (char)(inicio2+1);
        }
        return false;
    }

    private boolean isAlcanzablePorTorre(Color color,Casilla casilla) {
        for (int i = casilla.getFila()-1; i >= 1; i--){
            if(getCasilla(i, casilla.getColumna()).isOcupada()){
                if((this.getCasilla(i,casilla.getColumna()).getFicha() instanceof Torre)&&(this.getCasilla(i,casilla.getColumna()).getFicha().getColor()!=color)){
                    return true;
                }
                break;
            }
        }
        for (int i = casilla.getFila()+1; i <= 8; i++){
            if(getCasilla(i, casilla.getColumna()).isOcupada()){
                if((this.getCasilla(i,casilla.getColumna()).getFicha() instanceof Torre)&&(this.getCasilla(i,casilla.getColumna()).getFicha().getColor()!=color)){
                    return true;
                }
                break;
            }
        }
        for (int i = casilla.getColumna()-'A'-1;i>=0;i--){
            if(getCasilla(casilla.getFila()-1,i).isOcupada()){
                if((this.getCasilla(casilla.getFila()-1,i).getFicha() instanceof Torre)&&(this.getCasilla(casilla.getFila()-1,i).getFicha().getColor()!=color)){
                    return true;
                }
                break;
            }
        }
        for (int i = casilla.getColumna()-'A'+1;i<=7;i++){
            if(getCasilla(casilla.getFila()-1,i).isOcupada()){
                if((this.getCasilla(casilla.getFila()-1,i).getFicha() instanceof Torre)&&(this.getCasilla(casilla.getFila()-1,i).getFicha().getColor()!=color)){
                    return true;
                }
                break;
            }
        }
        return false;
    }

    private boolean isAmenazadaPorRey(Color color,Casilla casilla) {
        if(casilla.getFila()>1){
            if(this.getCasilla(casilla.getFila()-1,casilla.getColumna()).isOcupada()){
                if((this.getCasilla(casilla.getFila()-1,casilla.getColumna()).getFicha() instanceof Rey)&&(this.getCasilla(casilla.getFila()-1,casilla.getColumna()).getFicha().getColor()!=color)){
                    return true;
                }
            }
        }
        if(casilla.getFila()<8){
            if(this.getCasilla(casilla.getFila()+1,casilla.getColumna()).isOcupada()){
                if((this.getCasilla(casilla.getFila()+1,casilla.getColumna()).getFicha() instanceof Rey)&&(this.getCasilla(casilla.getFila()+1,casilla.getColumna()).getFicha().getColor()!=color)){
                    return true;
                }
            }
        }
        if(casilla.getColumna()>'A'){
            if(this.getCasilla(casilla.getFila(),((char)(casilla.getColumna()-1))).isOcupada()){
                if((this.getCasilla(casilla.getFila(),((char)(casilla.getColumna()-1))).getFicha() instanceof Rey)&&(this.getCasilla(casilla.getFila(),((char)(casilla.getColumna()-1))).getFicha().getColor()!=color)){
                    return true;
                }
            }
        }
        if(casilla.getColumna()<'H'){
            if(this.getCasilla(casilla.getFila(),((char)(casilla.getColumna()+1))).isOcupada()){
                if((this.getCasilla(casilla.getFila(),((char)(casilla.getColumna()+1))).getFicha() instanceof Rey)&&(this.getCasilla(casilla.getFila(),((char)(casilla.getColumna()+1))).getFicha().getColor()!=color)){
                    return true;
                }
            }
        }
        if(casilla.getFila()>1&&casilla.getColumna()>'A'){
            if(this.getCasilla(casilla.getFila()-1,((char)(casilla.getColumna()-1))).isOcupada()){
                if((this.getCasilla(casilla.getFila()-1,((char)(casilla.getColumna()-1))).getFicha() instanceof Rey)&&(this.getCasilla(casilla.getFila()-1,((char)(casilla.getColumna()-1))).getFicha().getColor()!=color)){
                    return true;
                }
            }
        }
        if(casilla.getFila()>1&&casilla.getColumna()<'H'){
            if(this.getCasilla(casilla.getFila()-1,((char)(casilla.getColumna()+1))).isOcupada()){
                if((this.getCasilla(casilla.getFila()-1,((char)(casilla.getColumna()+1))).getFicha() instanceof Rey)&&(this.getCasilla(casilla.getFila()-1,((char)(casilla.getColumna()+1))).getFicha().getColor()!=color)){
                    return true;
                }
            }
        }
        if(casilla.getFila()<8&&casilla.getColumna()>'A'){
            if(this.getCasilla(casilla.getFila()+1,((char)(casilla.getColumna()-1))).isOcupada()){
                if((this.getCasilla(casilla.getFila()+1,((char)(casilla.getColumna()-1))).getFicha() instanceof Rey)&&(this.getCasilla(casilla.getFila()+1,((char)(casilla.getColumna()-1))).getFicha().getColor()!=color)){
                    return true;
                }
            }
        }
        if(casilla.getFila()<8&&casilla.getColumna()<'H'){
            if(this.getCasilla(casilla.getFila()+1,((char)(casilla.getColumna()+1))).isOcupada()){
                if((this.getCasilla(casilla.getFila()+1,((char)(casilla.getColumna()+1))).getFicha() instanceof Rey)&&(this.getCasilla(casilla.getFila()+1,((char)(casilla.getColumna()+1))).getFicha().getColor()!=color)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isAlcanzablePorAlfil(Color color,Casilla casilla) {
        int inicio1 = casilla.getFila()-1;
        char inicio2 = (char)(casilla.getColumna()-1);
        while(inicio1>=1&&inicio2>='A'){
            if(this.getCasilla(inicio1, inicio2).isOcupada()){
                if((this.getCasilla(inicio1, inicio2).getFicha() instanceof Alfil)&&(this.getCasilla(inicio1, inicio2).getFicha().getColor()!=color)){
                    return true;
                }
                break;
            }
            inicio1--;
            inicio2 = (char)(inicio2-1);
        }
        inicio1 = casilla.getFila()-1;
        inicio2 = (char)(casilla.getColumna()+1);
        while(inicio1>=1&&inicio2<='H'){
            if(this.getCasilla(inicio1, inicio2).isOcupada()){
                if((this.getCasilla(inicio1, inicio2).getFicha() instanceof Alfil)&&(this.getCasilla(inicio1, inicio2).getFicha().getColor()!=color)){
                    return true;
                }
                break;
            }
            inicio1--;
            inicio2 = (char)(inicio2+1);
        }
        inicio1 = casilla.getFila()+1;
        inicio2 = (char)(casilla.getColumna()-1);
        while(inicio1<=8&&inicio2>='A'){
            if(this.getCasilla(inicio1, inicio2).isOcupada()){
                if((this.getCasilla(inicio1, inicio2).getFicha() instanceof Alfil)&&(this.getCasilla(inicio1, inicio2).getFicha().getColor()!=color)){
                    return true;
                }
                break;
            }
            inicio1++;
            inicio2 = (char)(inicio2-1);
        }
        inicio1 = casilla.getFila()+1;
        inicio2 = (char)(casilla.getColumna()+1);
        while(inicio1<=8&&inicio2<='H'){
            if(this.getCasilla(inicio1, inicio2).isOcupada()){
                if((this.getCasilla(inicio1, inicio2).getFicha() instanceof Alfil)&&(this.getCasilla(inicio1, inicio2).getFicha().getColor()!=color)){
                    return true;
                }
                break;
            }
            inicio1++;
            inicio2 = (char)(inicio2+1);
        }
        return false;
    }

    private boolean isAmenazadaPorPeon(Color color,Casilla casilla) {
            int incremento = (color == Color.BLANCO ? 1 : -1);
        if((color == Color.BLANCO && casilla.getFila()<8)||(color == Color.NEGRO && casilla.getFila()>1)){
            if(casilla.getColumna()>'A'){
                if(((this.getCasilla(casilla.getFila()+incremento,(char)(casilla.getColumna()-1)).getFicha() instanceof Peon))&&(this.getCasilla(casilla.getFila()+incremento,(char)(casilla.getColumna()-1)).getFicha().getColor()!=color)){
                   return true;
                }
            }
        
            if(casilla.getColumna()<'H')
            {
                if((this.getCasilla(casilla.getFila()+incremento,(char)(casilla.getColumna()+1)).getFicha() instanceof Peon)&&(this.getCasilla(casilla.getFila()+incremento,(char)(casilla.getColumna()+1)).getFicha().getColor()!=color)){
                    return true;
                }
            }
        }
        return false;
            
            
    }
    
    private boolean isAlcanzablePorPeon(Color color,Casilla casilla){
        return false;
    }
}
