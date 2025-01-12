package problema1;

public class imprimanta extends echipament{
    int ppm;
    String rezolutie;
    int p_car;
    String mod_tiparire;

    public imprimanta(String denumire, int nr_inv, int pret, String zona_mag, Tip tip, Tip_echipament tip_echipament,
                      int ppm, String rezolutie, int p_car, String mod_tiparire)
    {
        super(denumire, nr_inv, pret, zona_mag, tip, tip_echipament);
        this.ppm = ppm;
        this.rezolutie = rezolutie;
        this.p_car = p_car;
        this.mod_tiparire = mod_tiparire;
    }

    public String getModTiparire() {
        return mod_tiparire;
    }

    public void setModTiparire(String mod_tiparire) {
        this.mod_tiparire = mod_tiparire;
    }

    @Override
    public String toString() {
        return "Imprimanta {" +
                "denumire='" + denumire + '\'' +
                ", nr_inv=" + nr_inv +
                ", pret=" + pret +
                ", zona_mag='" + zona_mag + '\'' +
                ", tip=" + tip +
                ", tip_echipament=" + tip_echipament +
                ", ppm=" + ppm +
                ", rezolutie='" + rezolutie + '\'' +
                ", p_car=" + p_car +
                ", mod_tiparire='" + mod_tiparire + '\'' +
                '}';
    }

}