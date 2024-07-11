/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ubimusic.Vista;

import ubimusic.Conexion.Conexion;
import ubimusic.Modelo.Artista;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;
import ubimusic.Modelo.generoMusica;

/**
 *
 * @author Pilum
 */
public class art {

    public boolean insert(Artista artis) {

        boolean flag = false;
        Conexion conexion = new Conexion();
        String sql = "INSERT INTO ubimusic.artista (Nombre_Artista, Numero_Discos, nombre_Discografica) VALUES (?,?,?);";
        try {
            PreparedStatement ps = conexion.conectar().prepareStatement(sql);
            ps.setString(1, artis.getNombreArtista());
            ps.setInt(2, artis.getNumeroDiscos());
            ps.setString(3, artis.getNombreDiscografica());
            if (ps.executeUpdate() == 1) {
                flag = true;
                System.out.println("DATO INSERTADO");
            } else {
                System.out.println("NO SE HA INSERTADO");
            }
            conexion.desconectar();
        } catch (Exception e) {
            System.out.println("ERROR " + e);
        }
        return flag;
    }

    public boolean updateArtista(Artista art) {
        boolean flag = false;
        String sql = "UPDATE ubimusic.artista SET Nombre_Artista = ?, Numero_Discos = ?, nombre_Discografica = ? WHERE (id_Artista=?);";
        try {
            Conexion conexion = new Conexion();
            PreparedStatement ps = conexion.conectar().prepareStatement(sql);

            ps.setString(1, art.getNombreArtista());
            ps.setInt(2, art.getNumeroDiscos());
            ps.setString(3, art.getNombreDiscografica());
            ps.setInt(4, art.getIdArtista());
            if (ps.executeUpdate() == 1) {
                flag = true;
                System.out.println("DATO ACTUALIZADO");
            } else {
                System.out.println("DATO NO ACTUALIZADO");
            }
            conexion.desconectar();
        } catch (Exception e) {
            System.out.println("ERROR " + e);
        }
        return flag;
    }

    public List<Artista> SeleccionarTodos() {
        List<Artista> lista = new LinkedList<Artista>();
        String sql = "SELECT * FROM ubimusic.artista;";
        try {
            Conexion conexion = new Conexion();
            PreparedStatement ps = conexion.conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            Artista gene;
            while (rs.next()) {
                gene = new Artista(rs.getInt("id_Artista"), rs.getString("Nombre_Artista"), rs.getInt("Numero_Discos"), rs.getString("nombre_Discografica"));
                lista.add(gene);
            }
            if (lista.size() > 0) {
                System.out.println("Lista Llena");
            }
            conexion.desconectar();
        } catch (Exception e) {
            System.out.println("ERROR " + e);
        }
        return lista;
    }

    public boolean deleteArtista(int id) {
        boolean flag = false;
        String sql = "DELETE FROM ubimusic.artista WHERE (id_Artista=?);";
        try {
            Conexion conexion = new Conexion();
            PreparedStatement ps = conexion.conectar().prepareStatement(sql);
            ps.setInt(1, id);
            if (ps.executeUpdate() == 1) {
                flag = true;
                System.out.println("DATO ELIMINADO");
            } else {
                System.out.println("DATO NO ELIMINADO");
            }
            conexion.desconectar();
        } catch (Exception e) {
            System.out.println("ERROR " + e);
        }
        return flag;
    }
}
