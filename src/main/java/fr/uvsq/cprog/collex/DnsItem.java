package fr.uvsq.cprog.collex;
import java.util.Objects;

public class DnsItem {
    private final NomMachine nom;
    private final AdresseIP ip;

    public DnsItem(NomMachine nom, AdresseIP ip) {
        this.nom = nom;
        this.ip = ip;
    }

    public NomMachine getNom() {
        return nom;
    }

    public AdresseIP getIp() {
        return ip;
    }

    @Override
    public String toString() {
        return ip + " " + nom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DnsItem)) return false;
        DnsItem dnsItem = (DnsItem) o;
        return Objects.equals(nom, dnsItem.nom) && Objects.equals(ip, dnsItem.ip);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom, ip);
    }
}
