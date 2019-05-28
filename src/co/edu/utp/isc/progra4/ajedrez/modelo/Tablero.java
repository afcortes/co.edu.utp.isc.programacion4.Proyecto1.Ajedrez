/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.progra4.ajedrez.modelo;

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
    
    public boolean validarJaque(Color color, Casilla casilla){
        return this.isAmenazada(color, casilla);  
    } 
    
    private boolean isAlcanzablePorPeon(Color color,Casilla casilla){
        if((casilla.getFila()<=8)&&(color==Color.BLANCO)){
            if(this.getCasilla(casilla.getFila()+1, casilla.getColumna()).isOcupada()){
                if((this.getCasilla(casilla.getFila()+1, casilla.getColumna()).getFicha() instanceof Peon)&&(this.getCasilla(casilla.getFila()+1, casilla.getColumna()).getFicha().getColor()!=color)){
                    return true;
                }
                return false;
            }
        }
        if((casilla.getFila()>=1)&&(color==Color.NEGRO)){
            if(this.getCasilla(casilla.getFila()-1, casilla.getColumna()).isOcupada()){
                if((this.getCasilla(casilla.getFila()-1, casilla.getColumna()).getFicha() instanceof Peon)&&(this.getCasilla(casilla.getFila()-1, casilla.getColumna()).getFicha().getColor()!=color)){
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    public boolean validarJaqueMate(Color color, Casilla rey) {
        Ficha f = rey.getFicha();
        rey.setFicha(null);
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if((((rey.getFila()+i)<=8)&&((rey.getFila()+i)>=1))&&((((char)(rey.getColumna()+j))<='H')&&(((char)(rey.getColumna()+j))>='A'))){
                    if(!((i==0)&&(j==0))){
                        if(!this.isAmenazada(color,getCasilla(rey.getFila()+i,((char)(rey.getColumna()+j))))){
                            if(this.getCasilla(rey.getFila()+i,((char)(rey.getColumna()+j))).isOcupada()){
                                if(this.getCasilla(rey.getFila()+i,((char)(rey.getColumna()+j))).getFicha().getColor()!=color){
                                    rey.setFicha(f);
                                    return false;
                                }
                            }
                            else{
                                rey.setFicha(f);
                                return false;
                            }
                        }
                    }
                }  
            }
            
        }
        rey.setFicha(f);
        if(!isAlcanzablePorCaballo(color, rey)&&!isAmenazadaPorPeon(color, rey)){
            int cont = 0;
            if(isAlcanzablePorAlfil(color, rey)){
                cont++;
            }
            if(isAlcanzablePorReyna(color, rey)){
                cont++;
            }
            if(isAlcanzablePorTorre(color, rey)){
                cont++;
            }
            if(cont>1){
                return true;
            }
            System.out.println("Llegue aqui");
            return !isProtegible(color,rey);
        }
        return true;
    }

    private boolean isProtegible(Color color, Casilla rey) {
        boolean protegible = false;
        Color contrario = color == color.BLANCO ? color.NEGRO : color.BLANCO;
        int inicio1 = rey.getFila()-1;
        char inicio2 = (char)(rey.getColumna()-1);
        while(inicio1>=1&&inicio2>='A'){
            if(this.getCasilla(inicio1, inicio2).isOcupada()){
                if(((this.getCasilla(inicio1, inicio2).getFicha() instanceof Alfil)||(this.getCasilla(inicio1, inicio2).getFicha() instanceof Reina))&&(this.getCasilla(inicio1, inicio2).getFicha().getColor()!=color)){
                    if(protegible == false){
                        return isAmenazadaSinRey(contrario, this.getCasilla(inicio1, inicio2));
                    }
                    return true;
                }
                break;
            }
            if(this.isAlcanzable(color, this.getCasilla(inicio1,inicio2))){
                protegible = true;
            }
            inicio1--;
            inicio2 = (char)(inicio2-1);
        }
        protegible = false;
        inicio1 = rey.getFila()-1;
        inicio2 = (char)(rey.getColumna()+1);
        while(inicio1>=1&&inicio2<='H'){
            if(this.getCasilla(inicio1, inicio2).isOcupada()){
                if(((this.getCasilla(inicio1, inicio2).getFicha() instanceof Alfil)||(this.getCasilla(inicio1, inicio2).getFicha() instanceof Reina))&&(this.getCasilla(inicio1, inicio2).getFicha().getColor()!=color)){
                    if(protegible == false){
                        return isAmenazadaSinRey(contrario, this.getCasilla(inicio1, inicio2));
                    }
                    return true;
                }
                break;
            }
            if(this.isAlcanzable(color, this.getCasilla(inicio1,inicio2))){
                protegible = true;
                System.out.println(protegible);
            }
            inicio1--;
            inicio2 = (char)(inicio2+1);
        }
        protegible = false;
        inicio1 = rey.getFila()+1;
        inicio2 = (char)(rey.getColumna()-1);
        while(inicio1<=8&&inicio2>='A'){
            if(this.getCasilla(inicio1, inicio2).isOcupada()){
                if(((this.getCasilla(inicio1, inicio2).getFicha() instanceof Alfil)||(this.getCasilla(inicio1, inicio2).getFicha() instanceof Reina))&&(this.getCasilla(inicio1, inicio2).getFicha().getColor()!=color)){
                    if(protegible == false){
                        return isAmenazadaSinRey(contrario, this.getCasilla(inicio1, inicio2));
                    }
                    return true;
                }
                break;
            }
            if(this.isAlcanzable(color, this.getCasilla(inicio1,inicio2))){
                protegible = true;
            }
            inicio1++;
            inicio2 = (char)(inicio2-1);
        }
        protegible = false;
        inicio1 = rey.getFila()+1;
        inicio2 = (char)(rey.getColumna()+1);
        while(inicio1<=8&&inicio2<='H'){
            if(this.getCasilla(inicio1, inicio2).isOcupada()){
                if(((this.getCasilla(inicio1, inicio2).getFicha() instanceof Alfil)||(this.getCasilla(inicio1, inicio2).getFicha() instanceof Reina))&&(this.getCasilla(inicio1, inicio2).getFicha().getColor()!=color)){
                    if(protegible == false){
                        return isAmenazadaSinRey(contrario, this.getCasilla(inicio1, inicio2));
                    }
                    return false;
                }
                break;
            }
            if(this.isAlcanzable(color, this.getCasilla(inicio1,inicio2))){
                protegible = true;
            }
            inicio1++;
            inicio2 = (char)(inicio2+1);
        }
        protegible = false;
        for (int i = rey.getFila()-1; i >= 1; i--){
            if(getCasilla(i, rey.getColumna()).isOcupada()){
                System.out.println("estoy aqui");
                if(((this.getCasilla(i,rey.getColumna()).getFicha() instanceof Torre)||(this.getCasilla(i,rey.getColumna()).getFicha() instanceof Reina))&&(this.getCasilla(i,rey.getColumna()).getFicha().getColor()!=color)){
                    if(protegible == false){
                        return isAmenazadaSinRey(contrario, this.getCasilla(i,rey.getColumna()));
                    }
                    return true;
                }
                break;
            }else{
                System.out.println(" !! "+this.isAlcanzable(color, this.getCasilla(inicio1,inicio2)));
                if(this.isAlcanzable(color, this.getCasilla(inicio1,inicio2))){
                    protegible = true;
                }
            }
        }
        protegible = false;
        for (int i = rey.getFila()+1; i <= 8; i++){
            if(this.getCasilla(i, rey.getColumna()).isOcupada()){
                if(((this.getCasilla(i,rey.getColumna()).getFicha() instanceof Torre)||(this.getCasilla(i,rey.getColumna()).getFicha() instanceof Reina))&&(this.getCasilla(i,rey.getColumna()).getFicha().getColor()!=color)){
                    if(protegible == false){
                        return isAmenazadaSinRey(contrario, this.getCasilla(i, rey.getColumna()));
                    }
                    return true;
                }
                break;
            }
            System.out.println("!!"+this.isAlcanzable(color, this.getCasilla(inicio1,inicio2)));
            if(this.isAlcanzable(color, this.getCasilla(inicio1,inicio2))){
                protegible = true;
            }
        }
        protegible = false;
        for (int i = rey.getColumna()-'A'-1;i>=0;i--){
            if(getCasilla(rey.getFila()-1,i).isOcupada()){
                if(((this.getCasilla(rey.getFila()-1,i).getFicha() instanceof Torre)||(this.getCasilla(i,rey.getColumna()).getFicha() instanceof Reina))&&(this.getCasilla(rey.getFila()-1,i).getFicha().getColor()!=color)){
                   if(protegible == false){
                        return isAmenazadaSinRey(contrario, this.getCasilla(rey.getFila()-1,i));
                    }
                    return true;
                }
                break;
            }
            if(this.isAlcanzable(color, this.getCasilla(inicio1,inicio2))){
                protegible = true;
            }
        }
        protegible = false;
        for (int i = rey.getColumna()-'A'+1;i<=7;i++){
            if(getCasilla(rey.getFila()-1,i).isOcupada()){
                if(((this.getCasilla(rey.getFila()-1,i).getFicha() instanceof Torre)||(this.getCasilla(i,rey.getColumna()).getFicha() instanceof Reina))&&(this.getCasilla(rey.getFila()-1,i).getFicha().getColor()!=color)){
                    if(protegible == false){
                        return isAmenazadaSinRey(contrario, getCasilla(rey.getFila()-1,i));
                    }
                    return true;
                }
                break;
            }
            if(this.isAlcanzable(color, this.getCasilla(inicio1,inicio2))){
                protegible = true;
            }
        }
        return false;
    }
    
    public boolean isAlcanzable(Color color, Casilla casilla){
        Color color2 = (color == color.BLANCO ? color.NEGRO : color.BLANCO);
        return isAlcanzablePorAlfil(color2, casilla)||isAlcanzablePorCaballo(color2, casilla)||isAlcanzablePorReyna(color2, casilla)||isAlcanzablePorPeon(color2, casilla)||isAlcanzablePorTorre(color2, casilla);
    }
    
    public boolean isAmenazadaSinRey(Color color,Casilla casilla){
        return isAlcanzablePorAlfil(color, casilla)||isAlcanzablePorCaballo(color, casilla)||isAmenazadaPorPeon(color, casilla)||isAlcanzablePorReyna(color, casilla)||isAlcanzablePorTorre(color, casilla);
    }
}
