import problema1.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.exit;
import static java.util.Locale.filter;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        List<echipament> Echipamente=new ArrayList<>();
        try {
            File file= new File("src/problema1/echipamente.txt");
            Scanner scanner= new Scanner(file);

            while(scanner.hasNext())
            {
                String line=scanner.nextLine();
                String data[]=line.split(";");
                String denumire=data[0];
                int nr_inv= Integer.parseInt(data[1]);
                int pret=Integer.parseInt(data[2]);
                String zona_mag=data[3];
                Tip tip= Tip.valueOf(data[4]);
                Tip_echipament tip_echipament= Tip_echipament.valueOf(data[5]);

                if(tip_echipament== Tip_echipament.imprimanta)
                {
                    int ppm= Integer.parseInt(data[6]);
                    String rezolutie= data[7];
                    int p_car= Integer.parseInt(data[8]);
                    String mod_tiparire = data[9];
                    Echipamente.add(new imprimanta(denumire, nr_inv, pret, zona_mag, tip, tip_echipament, ppm, rezolutie,p_car,mod_tiparire));
                }
                else if(tip_echipament== Tip_echipament.copiator)
                {
                    int p_ton= Integer.parseInt(data[6]);
                    String format_copiere= data[7];
                    Echipamente.add(new copiator(denumire, nr_inv, pret, zona_mag, tip, tip_echipament, p_ton, format_copiere));
                }
                else if(tip_echipament== Tip_echipament.Sisteme_de_calcul)
                {
                    String tip_mon= data[6];
                    int viteza_proc= Integer.parseInt(data[7]);
                    int c_hdd= Integer.parseInt(data[8]);
                    String sist_operare= data[9];
                    Echipamente.add(new Sisteme_de_calcul(denumire, nr_inv, pret, zona_mag, tip, tip_echipament, tip_mon, viteza_proc, c_hdd, sist_operare));
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        Scanner scanner=new Scanner(System.in);

        do{
            System.out.println("\nMeniul de forma:");
            System.out.println("0.Iesire");
            System.out.println("1.Afişarea tuturor echipamentelor");
            System.out.println("2.Afişarea imprimantelor");
            System.out.println("3.Afişarea copiatoarelor");
            System.out.println("4.Afişarea sistemelor de calcul");
            System.out.println("5.Modificarea stării în care se află un echipament");
            System.out.println("6.Setarea unui anumit mod de scriere pentru o imprimantă");
            System.out.println("7.Setarea unui format de copiere pentru copiatoare");
            System.out.println("8.Instalarea unui anumit sistem de operare pe un sistem de calcul ");
            System.out.println("9.Afişarea echipamentelor vândute");
            System.out.print("Introduceti optiunea dorita: ");
            int opt= scanner.nextInt();
            scanner.nextLine();

            switch(opt)
            {
                case 0: exit(0);
                case 1:
                    Echipamente.forEach(System.out::println);
                    break;
                case 2:
                    Echipamente.stream().
                    filter(echipament -> echipament instanceof imprimanta).
                            forEach(System.out::println);
                    break;
                case 3:
                    Echipamente.stream().
                            filter(echipament -> echipament instanceof copiator).
                            forEach(System.out::println);
                    break;
                case 4:
                    Echipamente.stream().
                            filter(echipament -> echipament instanceof Sisteme_de_calcul).
                            forEach(System.out::println);
                    break;
                    case 5:
                        Scanner input = new Scanner(System.in);

                        System.out.print("Introdu numărul de inventar al echipamentului pentru care vrei să schimbi starea: ");
                        int nrInventarCautat = input.nextInt();

                        echipament echipamentGasit=null;
                        for(echipament e:Echipamente)
                        {
                            if(e.getNrInv()== nrInventarCautat)
                            {
                                echipamentGasit=e;
                                break;
                            }
                        }

                        if (echipamentGasit == null) {
                            System.out.println("Nu există niciun echipament cu numărul de inventar specificat.");
                            break;
                        }
                        System.out.println("Stările posibile: ");
                        for (Tip tip : Tip.values()) {
                            System.out.println("- " + tip);
                        }

                        System.out.print("Introdu noua stare: ");
                        String stareNoua = input.next().toLowerCase();

                        try {
                            // Conversia textului introdus într-un enum Tip
                            Tip stareEnum = Tip.valueOf(stareNoua);
                            echipamentGasit.setTip(stareEnum); // Actualizează starea echipamentului
                            System.out.println("Starea echipamentului a fost actualizată cu succes.");
                        } catch (IllegalArgumentException ex) {
                            System.out.println("Stare invalidă! Introdu una dintre opțiunile afișate.");
                        }

                        break;

                case 6:
                    Echipamente.stream().
                            filter(echipament -> echipament instanceof imprimanta).
                            forEach(System.out::println);

                    System.out.print("Introdu numărul de inventar al imprimantei: ");
                    int nrInventar = scanner.nextInt();

                    imprimanta imprimantaGasita = null;
                    for (echipament e : Echipamente) {
                        if (e instanceof imprimanta && e.getNrInv() == nrInventar) {
                            imprimantaGasita = (imprimanta) e;
                            break;
                        }
                    }

                    if (imprimantaGasita == null) {
                        System.out.println("Nu a fost găsită nicio imprimantă cu acest număr de inventar.");
                        break;
                    }

                    System.out.print("Introdu noul mod de tipărire: ");
                    scanner.nextLine();
                    String modNouTiparire = scanner.nextLine();

                    imprimantaGasita.setModTiparire(modNouTiparire);
                    System.out.println("Modul de tipărire al imprimantei a fost actualizat cu succes.");
                    break;

                case 7:
                    Echipamente.stream().
                            filter(echipament -> echipament instanceof copiator).
                            forEach(System.out::println);

                    System.out.print("Introdu numărul de inventar al copiatorului: ");
                    int nrInventar1 = scanner.nextInt();

                    copiator copiatorGasit = null;

                    for (echipament e : Echipamente) {
                        if (e instanceof copiator && e.getNrInv() == nrInventar1) {
                            copiatorGasit = (copiator) e;
                            break;
                        }
                    }

                    if (copiatorGasit == null)
                    {
                        System.out.println("Nu a fost găsită niciun copiator cu acest număr de inventar.");
                        break;
                    }

                    System.out.print("Introdu noul format de copiere: ");
                    scanner.nextLine();
                    String modNouCopiere = scanner.nextLine();

                    copiatorGasit.setFormat_copiere(modNouCopiere);
                    System.out.println("Modul de tipărire al imprimantei a fost actualizat cu succes.");
                    break;

                case 8:
                    Echipamente.stream().
                            filter(echipament -> echipament instanceof Sisteme_de_calcul).
                            forEach(System.out::println);

                    System.out.print("Introdu numărul de inventar al Sistemului de calcul: ");
                    int nrInventar2 = scanner.nextInt();

                    Sisteme_de_calcul sistemeGasit = null;

                    for (echipament e : Echipamente) {
                        if (e instanceof Sisteme_de_calcul && e.getNrInv() == nrInventar2) {
                            sistemeGasit = (Sisteme_de_calcul) e;
                            break;
                        }
                    }

                    if (sistemeGasit == null)
                    {
                        System.out.println("Nu a fost găsită niciun Sistem de calcul cu acest număr de inventar.");
                        break;
                    }

                    System.out.print("Introdu noul sistem de operare (Windows sau Linux): ");
                    scanner.nextLine();
                    String SistemNou = scanner.nextLine();

                    sistemeGasit.setSistem_operare(SistemNou);
                    System.out.println("Modul de tipărire al imprimantei a fost actualizat cu succes.");
                    break;

                case 9:
                    Echipamente.stream().
                            filter(e -> e.getTip() == Tip.vandut).
                            forEach(System.out::println);
                    break;
            }
        }while(true);
    }
}