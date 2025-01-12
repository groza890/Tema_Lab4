package problema1;

public class Sisteme_de_calcul extends echipament {
    String tip_mon;
    int viteza_proc;
    int c_hdd;
    String sist_operare;

    public Sisteme_de_calcul(String denumire, int nr_inv, int pret, String zona_mag, Tip tip, Tip_echipament tip_echipament,
                             String tip_mon, int viteza_proc, int c_hdd, String sist_operare)
    {
        super(denumire, nr_inv, pret, zona_mag, tip, tip_echipament);
        this.tip_mon = tip_mon;
        this.viteza_proc = viteza_proc;
        this.c_hdd = c_hdd;
        this.sist_operare = sist_operare;
    }

    public String getSiste_operare() {
        return sist_operare;
    }

    public void setSistem_operare(String sist_operare) {
        this.sist_operare = sist_operare;
    }

    @Override
    public String toString() {
        return "Sisteme de calcul {" +
                "denumire='" + denumire + '\'' +
                ", nr_inv=" + nr_inv +
                ", pret=" + pret +
                ", zona_mag='" + zona_mag + '\'' +
                ", tip=" + tip +
                ", tip_echipament=" + tip_echipament +
                ", tip_mon='" + tip_mon + '\'' +
                ", viteza_proc=" + viteza_proc +
                ", c_hdd=" + c_hdd +
                ", sist_operare='" + sist_operare + '\'' +
                '}';
    }

}
