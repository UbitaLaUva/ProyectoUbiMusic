/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ubimusic.Modelo;

/**
 *
 * @author Pilum
 */
public class generoMusica {
    
    private int genero_Cancion;
    private String tipo_Genero_Cancion;

    public generoMusica() {
    }

    
    public generoMusica(int genero_Cancion, String tipo_Genero_Cancion) {
        this.genero_Cancion = genero_Cancion;
        this.tipo_Genero_Cancion = tipo_Genero_Cancion;
    }

    public int getGenero_Cancion() {
        return genero_Cancion;
    }

    public void setGenero_Cancion(int genero_Cancion) {
        this.genero_Cancion = genero_Cancion;
    }

    public String getTipo_Genero_Cancion() {
        return tipo_Genero_Cancion;
    }

    public void setTipo_Genero_Cancion(String tipo_Genero_Cancion) {
        this.tipo_Genero_Cancion = tipo_Genero_Cancion;
    }
    
    
}
