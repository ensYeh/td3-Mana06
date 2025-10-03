package fr.uvsq.cprog.collex;

import java.util.Objects;

public class AdresseIP implements Comparable<AdresseIP> {
    private final String ip;

    public AdresseIP(String ip) {
        if (!estValide(ip)) {
            throw new IllegalArgumentException("Adresse IP invalide : " + ip);
        }
        this.ip = ip;
    }

    public String getIp() {
        return ip;
    }

    private boolean estValide(String ip) {
        String[] parties = ip.split("\\.");
        if (parties.length != 4) return false;
        try {
            for (String p : parties) {
                int val = Integer.parseInt(p);
                if (val < 0 || val > 255) return false;
            }
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @Override
    public String toString() {
        return ip;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AdresseIP)) return false;
        AdresseIP adresseIP = (AdresseIP) o;
        return Objects.equals(ip, adresseIP.ip);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ip);
    }

    @Override
    public int compareTo(AdresseIP autre) {
        String[] a = this.ip.split("\\.");
        String[] b = autre.ip.split("\\.");
        for (int i = 0; i < 4; i++) {
            int va = Integer.parseInt(a[i]);
            int vb = Integer.parseInt(b[i]);
            if (va != vb) return va - vb;
        }
        return 0;
    }
}