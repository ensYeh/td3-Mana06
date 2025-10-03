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

    @Override
    public String toString() {
        return nomMachine.toString() + " " + adresseIP.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DnsItem)) return false;
        DnsItem dnsItem = (DnsItem) o;
        return Objects.equals(adresseIP, dnsItem.adresseIP) &&
                Objects.equals(nomMachine, dnsItem.nomMachine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(adresseIP, nomMachine);
    }
}