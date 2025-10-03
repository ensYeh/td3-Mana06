package fr.uvsq.cprog.collex;
import java.util.Objects;



public class DnsItem {
    private AdresseIP adresseIP;
    private NomMachine nomMachine;

    public DnsItem(AdresseIP ip, NomMachine nom) {
        this.adresseIP = ip;
        this.nomMachine = nom;
    }

    public AdresseIP getAdresseIP() {
        return adresseIP;
    }

    public NomMachine getNomMachine() {
        return nomMachine;
    }
}
