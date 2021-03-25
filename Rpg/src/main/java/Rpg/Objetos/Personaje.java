package Rpg.Objetos;

//La clase tipo objeto que se va a crear va a ser la encargada de almacenar las estadisticas de los personajes
public class Personaje {
    //por temas de seguridad las acciones de modidificaciones de los atributos se realizaran por los setters
    private int ataque;
    private int vida;
    private int defensa;
    //esto puede cambiar porque el peronaje puede tener por defecto unos atributos bases iguales
    public Personaje(int ataque, int vida, int defensa) {
        this.ataque = ataque;
        this.vida = vida;
        this.defensa = defensa;
    }
    
    @Override
    public String toString() {
        return "Personaje [ataque=" + ataque + ", defensa=" + defensa + ", vida=" + vida + "]";
    }
    public int getAtaque() {
        return ataque;
    }
    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }
    public int getVida() {
        return vida;
    }
    public void setVida(int vida) {
        this.vida = vida;
    }
    public int getDefensa() {
        return defensa;
    }
    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }
  
    
}
