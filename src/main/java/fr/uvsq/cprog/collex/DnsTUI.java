package fr.uvsq.cprog.collex;

import java.util.List;
import java.util.Scanner;

public class DnsTUI {
    private Scanner scanner;
    private Dns dns; // instance de ton DNS

    public DnsTUI(Dns dns) {
        this.scanner = new Scanner(System.in);
        this.dns = dns;
    }

    // Lit la ligne utilisateur et exécute directement l'action
    public void nextCommande() {
        System.out.print("> ");
        String ligne = scanner.nextLine().trim();

        if (ligne.isEmpty()) return;

        try {
            if (ligne.startsWith("add ")) {
                String[] parts = ligne.split(" ");
                if (parts.length == 3) {
                    dns.addItem(new AdresseIP(parts[1]), new NomMachine(parts[2]));
                    System.out.println("Ajout effectué.");
                } else {
                    System.out.println("Erreur : syntaxe 'add IP nom_machine'");
                }
            } else if (ligne.startsWith("ls ")) {
                String[] parts = ligne.split(" ");
                boolean sortByIP = false;
                String domaine = "";
                if (parts.length == 2) {
                    domaine = parts[1];
                } else if (parts.length == 3 && "-a".equals(parts[1])) {
                    domaine = parts[2];
                    sortByIP = true;
                }
                List<DnsItem> items = dns.getItems(domaine);
                final boolean sort = sortByIP; // variable finale pour la lambda
                items.sort((i1, i2) -> sort ?
                        i1.getAdresseIP().toString().compareTo(i2.getAdresseIP().toString()) :
                        i1.getNomMachine().toString().compareTo(i2.getNomMachine().toString()));
                for (DnsItem item : items) {
                    System.out.println(item);
                }
            } else if (ligne.matches("\\d+\\.\\d+\\.\\d+\\.\\d+")) {
                DnsItem item = dns.getItem(new AdresseIP(ligne));
                System.out.println(item != null ? item : "Non trouvé");
            } else {
                DnsItem item = dns.getItem(new NomMachine(ligne));
                System.out.println(item != null ? item : "Non trouvé");
            }
        } catch (Exception e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }

    // Boucle principale
    public void run() {
        while (true) {
            nextCommande();
        }
    }
}
