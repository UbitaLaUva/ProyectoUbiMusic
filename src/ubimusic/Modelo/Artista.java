/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ubimusic.Modelo;

/**
 *
 * @author Pilum
 */
public class Artista {
    private int idArtista;
    private String nombreArtista;
    private int numeroDiscos;
    private String nombreDiscografica;

    public Artista() {
    }

    public Artista(int idArtista, String nombreArtista, int numeroDiscos, String nombreDiscografica) {
        this.idArtista = idArtista;
        this.nombreArtista = nombreArtista;
        this.numeroDiscos = numeroDiscos;
        this.nombreDiscografica = nombreDiscografica;
    }

    public int getIdArtista() {
        return idArtista;
    }

    public void setIdArtista(int idArtista) {
        this.idArtista = idArtista;
    }

    public String getNombreArtista() {
        return nombreArtista;
    }

    public void setNombreArtista(String nombreArtista) {
        this.nombreArtista = nombreArtista;
    }

    public int getNumeroDiscos() {
        return numeroDiscos;
    }

    public void setNumeroDiscos(int numeroDiscos) {
        this.numeroDiscos = numeroDiscos;
    }

    public String getNombreDiscografica() {
        return nombreDiscografica;
    }

    public void setNombreDiscografica(String nombreDiscografica) {
        this.nombreDiscografica = nombreDiscografica;
    }
    
    
    
}
