package canciones;


public class PlayList {

    /*Se construye a partir de la cantidad máxima de Canciones que puede tener. 
Como máximo supondremos que una lista no supera las 10000 canciones,
pero puede ser construida con una cantidad menor. */

    private Cancion[] canciones = new Cancion[10000];
    private int cant=0;

    public String getDuracionString(int segundos2) {
        int horas = 0, minutos = 0, segundos = segundos2;
        minutos = segundos / 60;
        horas = minutos / 60;
        minutos = minutos % 60;
        segundos = segundos % 60;
        if (horas == 0) {
            return String.format("%02d", minutos) + ":" + String.format("%02d", segundos);
        } else {
            return String.format("%02d", horas) + ":" + String.format("%02d", minutos) + ":" + String.format("%02d", segundos);
        }
    }

    /*Cada Canción está compuesta de su  título, álbum, artista y duración. 
Proveer todos los constructores de Canción que crea convenientes, 
pero se debe tener en cuenta que una canción por lo menos se debe
crear a partir de su título y duración.*/
    public void agregarCancion(String titulo, int duracion) {
        canciones[this.getCantidadCancion()] = new Cancion(titulo, duracion);
        this.setCantidadCancion(cant+1);

    }

    public void agregarCancion(String titulo, String artista, int duracion) {
        canciones[this.getCantidadCancion()] = new Cancion(titulo, artista, duracion);
        this.setCantidadCancion(cant+1);
    }

    public void agregarCancion(String titulo, int duracion, String album) {
        canciones[this.getCantidadCancion()] = new Cancion(titulo, duracion, album);
        this.setCantidadCancion(cant+1);
    }

    public void agregarCancion(String titulo, String artista, String album, int duracion) {
        canciones[this.getCantidadCancion()] = new Cancion(titulo, artista, album, duracion);
        this.setCantidadCancion(cant+1);
    }

    /*Se puede consultar la duración de una canción pasándole el título. 
Si varias canciones tienen el mismo título, devuelve la duración de todas. 
Si la canción no existe, devuelve (-1). Las búsquedas no deben ser "case sensitive”.*/
    public String[] consultarDuracion(String titulo) {
        int size = getCantidadCancion();
        int duracion = 0;
        int f=0;
        for (int x = 0; x < size; x++) {
            if (canciones[x].getTitulo().equalsIgnoreCase(titulo)) {
                duracion = duracion + 1;
            }
        }
        String[] cancionDuracion = new String[duracion];
        if (duracion == 0) {
            cancionDuracion[f]= "-1";
        } else {
            if (duracion >= 1) {
                for (int s = 0; s < size; s++) {
                    if (canciones[s].getTitulo().equalsIgnoreCase(titulo)) {
                        cancionDuracion[f]= this.getDuracionString(canciones[s].getDuracion());
                        f++;
                    }
                }
            }
        }
        return cancionDuracion;
    }

    /*Se puede quitar una canción buscándola previamente por alguno de los datos que la compone.  */
    public void eliminarCancion(String eliminar) {
        Cancion cancionDeControl;
        
        for (int x = 0; x < cant; x++) { 
            if (canciones[x].getTitulo().equalsIgnoreCase(eliminar) || canciones[x].getAlbum().equalsIgnoreCase(eliminar) || canciones[x].getArtista().equalsIgnoreCase(eliminar) || eliminar.equalsIgnoreCase(this.getDuracionString(canciones[x].getDuracion()))) {
                for (int s = x; s < (cant - 1); s++) {
                    canciones[s] = canciones[s + 1];
                    
                }
                canciones[cant-1]=null;
            }
        }
        
    }

    public void eliminarCancion(int eliminar) {
        Cancion cancionDeControl;
        
        for (int x = 0; x < cant; x++) {
            if (canciones[x].getDuracion() == eliminar) {
                for (int s = x; s < (cant - 1); s++) {
                    canciones[s] = canciones[s + 1];
                    
                }
                canciones[cant-1]=null;  
            }
        }
    }

    /*Se puede consultar la duración completa de la playlist. */
    public String consultarDuracionPlaylist() {
        
        int total = 0;
        for (int x = 0; x <cant; x++) {
            total = total + canciones[x].getDuracion();

        }

        return this.getDuracionString(total);
    }

    //Se puede consultar la cantidad de canciones. 
    public int getCantidadCancion() {
        int cantidad = 0;
        int x = 0;
        while (canciones[x] != null) {
            cantidad++;
            x++;
        }
        return cantidad;
    }
    
    public void setCantidadCancion(int cantidad){
        this.cant= cantidad;
    }

    //Se puede consultar la canción de mayor duración y también la de menor duración
    public void cancionMayorDuracion() {
        int size = getCantidadCancion();
        int band = 0;
        Cancion max = new Cancion(null, 0);
        
        for (int x = 0; x < size; x++) {
            if (band == 0) {
                max = new Cancion(canciones[x].getTitulo(), canciones[x].getAlbum(), canciones[x].getArtista(), canciones[x].getDuracion());
                band = 1;
            } else {
                if (canciones[x].getDuracion()>max.getDuracion()) {
                    max = new Cancion(canciones[x].getTitulo(), canciones[x].getAlbum(), canciones[x].getArtista(), canciones[x].getDuracion());
                }
            }
        }
        System.out.println( "Cancion con mayor duracion: " + max.getTitulo() + ", Artista: " + max.getArtista() + ", Album: " + max.getAlbum() + ". \nDuracion: " + this.getDuracionString(max.getDuracion()));
    }
    
    public Cancion menorDuracion(){  
        int band2=0;
        
        Cancion min= new Cancion(null, 0);
        for (int x = 0; x < cant; x++) {
            if (band2 == 0) {
                min = new Cancion(canciones[x].getTitulo(), canciones[x].getAlbum(), canciones[x].getArtista(), canciones[x].getDuracion());
                band2 = 1;
            } else {
                if (canciones[x].getDuracion()<min.getDuracion()) {
                    min = new Cancion(canciones[x].getTitulo(), canciones[x].getAlbum(), canciones[x].getArtista(), canciones[x].getDuracion());
                }
            }
        }
        return min;
   
        
    }

    //Se puede mostrar la lista ordenada por título de la canción.
    public Cancion[] ordenadaTitulo(){
        int intercambio=0;
        Cancion auxiliar;
        boolean ordenado= false;
        while(!ordenado){
            for(int x=0; x<cant-1; x++){
                if(canciones[x].getTitulo().compareToIgnoreCase( canciones[x+1].getTitulo())>0){
                    auxiliar= canciones[x];
                    canciones[x]= canciones[x+1];
                    canciones[x+1]= auxiliar;
                    intercambio++;
                }
            }
            if (intercambio==0){
                ordenado= true;
            }
            intercambio=0;
        }
        Cancion []prueba= new Cancion[cant];
        for(int d=0; d<cant; d++){
            prueba[d]= canciones[d];
        }
        return prueba;
    }
    
    public Cancion[] ordenArtista(){
        
        int intercambio=0;
        Cancion auxiliar;
        Cancion []aux2 = new Cancion[cant];
        boolean ordenado= false;
        while(!ordenado){
            for(int x=0; x<cant-1; x++){
                if((canciones[x].getArtista() + canciones[x].getTitulo()).compareToIgnoreCase(canciones[x+1].getArtista()+ canciones[x+1].getTitulo())>0){
                    
                    auxiliar= canciones[x];
                    canciones[x]= canciones[x+1];
                    canciones[x+1]= auxiliar;
                    intercambio++;
                }
            }
            if (intercambio==0){
                ordenado= true;
            }
            intercambio=0;
        }
        for(int d=0; d<cant; d++){
            aux2[d]=canciones[d];
        }
        return aux2;
    }
    //Simular la reproducción de la playlist eligiendo alguno de los criterios anteriores y además en orden aleatorio. 
    public void play(){
        
        
        int f=0, num=0;
        int [] reproduccion= new int[cant];
        for(int x=0; x<cant; x++){
            for(int y=0; y<cant; y++){
                if (reproduccion[x]==reproduccion[y] && x!=y){
                    
                    reproduccion[y]= (int) Math.floor(Math.random()*cant);
                    x=0;
                    }
                }
            }
        for(int s=0; s<cant; s++){
            num= reproduccion[s];
            System.out.println(num);
            System.out.println("Escuchando: " + canciones[num].getTitulo() + " - " + canciones[num].getArtista());            
            }
        f++;
    }
    

}

class test8{
    public static void main(String[] args) {
        PlayList nuevito= new PlayList();
        nuevito.agregarCancion("Baby one more time", 200);
        nuevito.agregarCancion("america", 120, "Adele");
        nuevito.agregarCancion("Hello", 222,"Adele");
        nuevito.agregarCancion("Four minutes","Madonna y Justin Timberlake", "Madonna", 240);
        nuevito.agregarCancion("Maria", 120, "Ricky Martin");
        nuevito.agregarCancion("La tortura", 211, "Shakira");
        nuevito.agregarCancion("Heart attack", 118, "Me");
        System.out.println(nuevito.getCantidadCancion());
        nuevito.eliminarCancion("heart attack");
        Cancion[] otro= nuevito.ordenadaTitulo();
        for(int i=0; i<7; i++){
            System.out.println(otro[i].getTitulo());
        }
    }
}


