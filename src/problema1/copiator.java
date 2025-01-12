package problema1;

public class copiator extends echipament{
    int p_ton;
    String format_copiere;

    public copiator(String denumire, int nr_inv, int pret, String zona_mag, Tip tip, Tip_echipament tip_echipament,
                    int p_ton, String format_copiere)
    {
        super(denumire, nr_inv, pret, zona_mag, tip, tip_echipament);
        this.p_ton = p_ton;
        this.format_copiere = format_copiere;
    }

    public String getFormat_copiere() {
        return format_copiere;
    }

    public void setFormat_copiere(String format_copiere) {
        this.format_copiere = format_copiere;
    }

    @Override
    public String toString() {
        return "Copiator {" +
                "denumire='" + denumire + '\'' +
                ", nr_inv=" + nr_inv +
                ", pret=" + pret +
                ", zona_mag='" + zona_mag + '\'' +
                ", tip=" + tip +
                ", tip_echipament=" + tip_echipament +
                ", p_ton=" + p_ton +
                ", format_copiere='" + format_copiere + '\'' +
                '}';
    }

}
