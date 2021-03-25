package Rpg.Objetos;
public class Arma {
private String nombre;
private String nombreImagen;
private int daño;
public Arma(String nombre, String nombreImagen, int daño) {
    this.nombre = nombre;
    this.nombreImagen = nombreImagen;
    this.daño = daño;
}
@Override
public String toString() {
    return "Arma [daño=" + daño + ", nombre=" + nombre + ", nombreImagen=" + nombreImagen + "]";
}
public String getNombre() {
    return nombre;
}
public void setNombre(String nombre) {
    this.nombre = nombre;
}
public String getNombreImagen() {
    return nombreImagen;
}
public void setNombreImagen(String nombreImagen) {
    this.nombreImagen = nombreImagen;
}
public int getDaño() {
    return daño;
}
public void setDaño(int daño) {
    this.daño = daño;
}
   
    
}
