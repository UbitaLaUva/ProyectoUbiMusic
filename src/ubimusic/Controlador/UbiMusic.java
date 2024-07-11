/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ubimusic.Controlador;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import ubimusic.Conexion.Conexion;
import ubimusic.Modelo.Artista;
import ubimusic.Modelo.generoMusica;
import ubimusic.Vista.genMusica;
import ubimusic.Vista.art;

/**
 *
 * @author Pilum
 */
public class UbiMusic {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Conexion conn = new Conexion();
        conn.conectar();

        Scanner sc = new Scanner(System.in);
        genMusica gb = new genMusica();
        generoMusica ub = new generoMusica();
        List<generoMusica> l = new LinkedList<generoMusica>();

        art artis = new art();
        Artista artista = new Artista();
        List<Artista> l2 = new LinkedList<Artista>();

        int op = Integer.MAX_VALUE;

        do {
            System.out.println("==========================");
            System.out.println("QUE DESEA HACER?"
                    + "\n 1. MIRAR GENEROS DE MUSICA"
                    + "\n 2. MIRAR ARTISTAS"
                    + "\n 3. DISCOS"
                    + "\n 4. MIRAR MUSICA"
                    + "\n 0. SALIR");
            do {
                try {
                    op = sc.nextInt();
                } catch (Exception e) {
                    System.out.println("Digite un numero valido");
                    sc.nextLine();
                }
            } while (op == Integer.MAX_VALUE);

            switch (op) {
                case 1:
                    do {
                        System.out.println("==========================");
                        System.out.println("QUE DESEA HACER?"
                                + "\n 1. Insertar Genero de Musica"
                                + "\n 2. Actualizar Genero"
                                + "\n 3. Eliminar Genero"
                                + "\n 4. Mostrar los Generos"
                                + "\n 0. Salir al menu principal");

                        do {
                            try {
                                op = sc.nextInt();
                            } catch (Exception e) {
                                System.out.println("Digite un numero valido");
                                sc.nextLine();
                            }
                        } while (op == Integer.MAX_VALUE);
                        switch (op) {
                            case 1:
                                System.out.println("=======================================");
                                System.out.println("============INSERTAR GENERO============");
                                System.out.println("=======================================");
                                ub.setTipo_Genero_Cancion(sc.next());
                                sc.nextLine();
                                gb.insert(ub);
                                break;
                            case 2:
                                System.out.println("=========================================");
                                System.out.println("============ACTUALIZAR GENERO============");
                                System.out.println("=========================================");
                                ub = new generoMusica();
                                l = gb.SeleccionarTodos();
                                System.out.println("ID" + "\t" + "GENERO MUSICA");
                                for (generoMusica genero : l) {
                                    System.out.println(genero.getGenero_Cancion() + "\t" + genero.getTipo_Genero_Cancion());
                                }
                                System.out.println("====================================");
                                System.out.println("DIGITE EL ID DEL GENERO A ACTUALIZAR");

                                ub.setGenero_Cancion(Integer.MAX_VALUE);
                                while (ub.getGenero_Cancion() == Integer.MAX_VALUE) {
                                    try {
                                        op = sc.nextInt();
                                        ub.setGenero_Cancion(op);
                                    } catch (Exception e) {
                                        System.out.println("DIGITE NUMERO VALIDO");
                                        sc.nextLine();
                                    }
                                }
                                sc.nextLine();
                                System.out.println("ESCRIBE EL NUEVO GENERO");
                                ub.setTipo_Genero_Cancion(sc.next());
                                gb.updateGenMusica(ub);
                                break;
                            case 3:
                                System.out.println("=========================================");
                                System.out.println("=============ELIMINAR GENERO=============");
                                System.out.println("=========================================");
                                l = gb.SeleccionarTodos();
                                System.out.println("ID" + "\t" + "GENERO MUSICA");
                                for (generoMusica genero : l) {
                                    System.out.println(genero.getGenero_Cancion() + "\t" + genero.getTipo_Genero_Cancion());
                                }
                                System.out.println("====================================");
                                System.out.println(" DIGITE EL ID DEL GENERO A ELIMINAR ");
                                gb.deleteGenMusic(sc.nextInt());
                                System.out.println("====================================");
                                break;
                            case 4:
                                System.out.println("===========================================");
                                System.out.println("=============TODOS LOS GENEROS=============");
                                System.out.println("===========================================");
                                l = gb.SeleccionarTodos();
                                System.out.println("ID" + "\t" + "GENERO MUSICA");
                                for (generoMusica genero : l) {
                                    System.out.println(genero.getGenero_Cancion() + "\t" + genero.getTipo_Genero_Cancion());
                                }
                                System.out.println("====================================");
                                break;
                            default:
                                System.out.println("DIGITE NUMERO VALIDO");
                        }
                    } while (op != 0);
                    break;
                case 2:
                    System.out.println("ARTISTA");
                    do {
                        System.out.println("==========================");
                        System.out.println("QUE DESEA HACER?"
                                + "\n 1. Insertar Un artista"
                                + "\n 2. Actualizar Artista"
                                + "\n 3. Eliminar Artista"
                                + "\n 4. Mostrar los Artistas"
                                + "\n 0. Salir al menu principal");
                        do {
                            try {
                                op = sc.nextInt();
                            } catch (Exception e) {
                                System.out.println("Digite un numero valido");
                                sc.nextLine();
                            }
                        } while (op == Integer.MAX_VALUE);
                        switch (op) {
                            case 1:
                                System.out.println("========================================");
                                System.out.println("============INSERTAR ARTISTA============");
                                System.out.println("========================================");
                                System.out.println("DIGITE NOMBRE DEL ARTISTA");
                                artista.setNombreArtista(sc.next());
                                sc.nextLine();
                                System.out.println("DIGITE EL NUMERO DE DISCOS");
                                artista.setNumeroDiscos(sc.nextInt());
                                sc.nextLine();
                                System.out.println("DIGITE NOMBRE DE LA DISCOGRAFICA");
                                artista.setNombreDiscografica(sc.next());
                                artis.insert(artista);
                                break;
                            case 2:
                                System.out.println("=========================================");
                                System.out.println("============ACTUALIZAR ARTISTA============");
                                System.out.println("=========================================");
                                artista = new Artista();
                                l2 = artis.SeleccionarTodos();
                                System.out.println("id_Artista" + "\t" + "NOMBRE ARTISTA" + "\t" + "NUMERO DISCOS" + "\t" + "NOMBRE DISCOGRAFIA");
                                for (Artista artistas : l2) {
                                    System.out.println(artistas.getIdArtista() + "\t" + artistas.getNombreArtista() + "\t" + artistas.getNumeroDiscos() + "\t" + artistas.getNombreDiscografica());
                                }
                                System.out.println("====================================");
                                System.out.println("DIGITE EL ID DEL ARTISTA A ACTUALIZAR");

                                artista.setIdArtista(Integer.MAX_VALUE);
                                while (artista.getIdArtista() == Integer.MAX_VALUE) {
                                    try {
                                        op = sc.nextInt();
                                        artista.setIdArtista(op);
                                    } catch (Exception e) {
                                        System.out.println("DIGITE NUMERO VALIDO");
                                        sc.nextLine();
                                    }
                                }
                                sc.nextLine();
                                System.out.println("ESCRIBE EL NOMBRE DEL ARTISTA");
                                artista.setNombreArtista(sc.next());
                                artis.updateArtista(artista);
                                break;
                            case 3:
                                System.out.println("=========================================");
                                System.out.println("=============ELIMINAR ARTISTA=============");
                                System.out.println("=========================================");
                                l2 = artis.SeleccionarTodos();
                                System.out.println("id_Artista" + "\t" + "NOMBRE ARTISTA" + "\t" + "NUMERO DISCOS" + "\t" + "NOMBRE DISCOGRAFIA");
                                for (Artista artistas : l2) {
                                    System.out.println(artistas.getIdArtista() + "\t" + artistas.getNombreArtista() + "\t" + artistas.getNumeroDiscos() + "\t" + artistas.getNombreDiscografica());
                                }
                                System.out.println("====================================");
                                System.out.println("DIGITE EL ID DEL ARTISTA A ELIMINAR");

                                artis.deleteArtista(sc.nextInt());
                                break;
                            case 4:
                                System.out.println("===========================================");
                                System.out.println("=============TODOS LOS ARTISTAS=============");
                                System.out.println("===========================================");
                                l2 = artis.SeleccionarTodos();
                                System.out.println("id_Artista" + "\t" + "NOMBRE ARTISTA" + "\t" + "NUMERO DISCOS" + "\t" + "NOMBRE DISCOGRAFIA");
                                for (Artista artistas : l2) {
                                    System.out.println(artistas.getIdArtista() + "\t" + artistas.getNombreArtista() + "\t" + artistas.getNumeroDiscos() + "\t" + artistas.getNombreDiscografica());
                                }
                                System.out.println("====================================");
                                break;
                            default:
                                System.out.println("DIGITE NUMERO VALIDO");
                        }
                    } while (op != 0);

                    break;

                default:
                    System.out.println("DIGITE NUMERO VALIDO");
            }
        } while (op != 0);

    }

}
