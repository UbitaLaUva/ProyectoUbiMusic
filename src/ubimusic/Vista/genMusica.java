/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ubimusic.Vista;

import ubimusic.Conexion.Conexion;
import ubimusic.Modelo.generoMusica;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Pilum
 */
public class genMusica {

    public boolean insert(generoMusica genMusic) {

        boolean flag = false;
        Conexion conexion = new Conexion();
        String sql = "INSERT INTO `ubimusic`.`genero_cancion` (`tipo_Gnero_Cancion`) VALUES (?);";
        try {
            PreparedStatement ps = conexion.conectar().prepareStatement(sql);
            ps.setString(1, genMusic.getTipo_Genero_Cancion());
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

    public boolean updateGenMusica(generoMusica genMusic) {
        boolean flag = false;
        String sql = "UPDATE `ubimusic`.`genero_cancion` SET `tipo_Gnero_Cancion` = ? WHERE (`id_Genero_Cancion`=?);";
        try {
            Conexion conexion = new Conexion();
            PreparedStatement ps = conexion.conectar().prepareStatement(sql);
            ps.setString(1, genMusic.getTipo_Genero_Cancion());
            ps.setInt(2, genMusic.getGenero_Cancion());
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

    public boolean deleteGenMusic(int id) {
        boolean flag = false;
        String sql = "DELETE FROM `ubimusic`.`Genero_Cancion` WHERE (`id_Genero_Cancion`=?);";
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

    public generoMusica selectGenMusic(int id) {
        generoMusica genmu = new generoMusica();
        String sql = "SELECT * FROM `ubimusic`.`Genero_Cancion` WHERE (`id_Genero_Cancion`=?);";
        try {
            Conexion conexion = new Conexion();
            PreparedStatement ps = conexion.conectar().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                genmu = new generoMusica(rs.getInt("id"),
                        rs.getString("Genero Musica"));
            }
            conexion.desconectar();
        } catch (Exception e) {
            System.out.println("ERROR " + e);
        }
        return genmu;
    }

    public List<generoMusica> SeleccionarTodos() {
        List<generoMusica> lista = new LinkedList<generoMusica>();
        String sql = "SELECT * FROM ubimusic.Genero_Cancion;";
        try {
            Conexion conexion = new Conexion();
            PreparedStatement ps = conexion.conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            generoMusica gene;
            while (rs.next()) {                
                gene = new generoMusica(rs.getInt("id_Genero_Cancion"), rs.getString("tipo_Gnero_Cancion"));
                lista.add(gene);
            }
            if (lista.size()>0) {
                System.out.println("Lista Llena");
            }
            conexion.desconectar();
        } catch (Exception e) {
            System.out.println("ERROR " + e);
        }
        return lista;
    }

}
