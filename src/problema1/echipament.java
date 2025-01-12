package problema1;

public abstract class echipament {
    String denumire;
    int nr_inv;
    int pret;
    String zona_mag;
    Tip tip;
    Tip_echipament tip_echipament;

    public echipament(String denumire, int nr_inv, int pret, String zona_mag, Tip tip, Tip_echipament tip_echipament)
    {
        this.denumire = denumire;
        this.nr_inv = nr_inv;
        this.pret = pret;
        this.zona_mag = zona_mag;
        this.tip = tip;
        this.tip_echipament = tip_echipament;
    }

    public echipament(){};

    public int getNrInv() {
        return nr_inv;
    }

    public void setNrInv(int nr_inv) {
        this.nr_inv = nr_inv;
    }

    public void setTip(Tip tip) {
        this.tip = tip;
    }

    public Tip getTip() {
        return tip;
    }

    @Override
    public String toString() {
        return "Echipament {" +
                "denumire='" + denumire + '\'' +
                ", nr_inv=" + nr_inv +
                ", pret=" + pret +
                ", zona_mag='" + zona_mag + '\'' +
                ", tip=" + tip +
                ", tip_echipament=" + tip_echipament +
                '}';
    }

}
