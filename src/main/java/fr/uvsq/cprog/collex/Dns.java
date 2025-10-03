package fr.uvsq.cprog.collex;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Dns {
    private List<DnsItem> items;
    private Path fichier;  // fichier texte qui stocke la base

    // Constructeur : charge la base depuis un fichier
    public Dns(Path fichier) throws IOException {
        this.fichier = fichier;
        this.items = new ArrayList<>();
        chargerBase();
    }

    // Chargement du fichier dans items
    private void chargerBase() throws IOException {
        List<String> lignes = Files.readAllLines(fichier);
        for (String ligne : lignes) {
            String[] parts = ligne.split(" ");
            if (parts.length == 2) {
                AdresseIP ip = new AdresseIP(parts[1]);
                NomMachine nom = new NomMachine(parts[0]);
                items.add(new DnsItem(ip, nom));
            }
        }
    }

    // Sauvegarde dans le fichier (utile après addItem)
    private void sauvegarderBase() throws IOException {
        List<String> lignes = new ArrayList<>();
        for (DnsItem item : items) {
            lignes.add(item.getNomMachine().toString() + " " + item.getAdresseIP().toString());
        }
        Files.write(fichier, lignes);
    }

    // Récupérer un item à partir d’une adresse IP
    public DnsItem getItem(AdresseIP ip) {
        for (DnsItem item : items) {
            if (item.getAdresseIP().equals(ip)) {
                return item;
            }
        }
        return null;
    }

    // Récupérer un item à partir d’un nom de machine
    public DnsItem getItem(NomMachine nom) {
        for (DnsItem item : items) {
            if (item.getNomMachine().equals(nom)) {
                return item;
            }
        }
        return null;
    }

    // Retourne tous les items d’un domaine
    public List<DnsItem> getItems(String domaine) {
        List<DnsItem> result = new ArrayList<>();
        for (DnsItem item : items) {
            if (item.getNomMachine().getDomaine().equals(domaine)) {
                result.add(item);
            }
        }
        return result;
    }

    // Ajouter un item à la base
    public void addItem(AdresseIP ip, NomMachine nom) throws Exception {
        if (getItem(ip) != null) {
            throw new Exception("ERREUR : L’adresse existe déjà !");
        }
        if (getItem(nom) != null) {
            throw new Exception("ERREUR : Le nom de machine existe déjà !");
        }
        items.add(new DnsItem(ip, nom));
        sauvegarderBase();
    }
}
