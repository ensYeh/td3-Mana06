package fr.uvsq.cprog.collex;

import java.nio.file.Paths;

public class MainDns {
    public static void main(String[] args) {
        try {
            // Charge la base DNS depuis un fichier
            Dns dns = new Dns(Paths.get("dns.txt"));

            // Crée la TUI en lui passant l'instance de Dns
            DnsTUI tui = new DnsTUI(dns);

            // Boucle principale pour lire et exécuter les commandes
            tui.run();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}