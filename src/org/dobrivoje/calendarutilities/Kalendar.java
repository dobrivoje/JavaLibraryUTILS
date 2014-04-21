package org.dobrivoje.calendarutilities;

import java.text.ParseException;

/**
 * Kalendar klasa služi za rukovanje promenama u modulima
 *
 */
public class Kalendar {

    private static Kalendar instance;

    //<editor-fold defaultstate="collapsed" desc="polja">
    private static int Godina;
    private static int Mesec;

    private static int prethodnaGodina;
    private static int prethodniMesec;

    private static boolean godinaIzmenjena;
    private static boolean mesecIzmenjen;

    private static String Datum;
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Konstruktor, getter/setter">
    protected Kalendar() {
    }

    protected Kalendar(String Datum) {
        Kalendar.Datum = Datum;
    }

    public static String getDatum() {
        return Datum;
    }

    public static int getGodina() {
        return Godina;
    }

    public static void setGodina(int Godina) {
        Kalendar.Godina = Godina;
    }

    public static int getMesec() {
        return Mesec;
    }

    public static void setMesec(int Mesec) {
        Kalendar.Mesec = Mesec;
    }

    public static int getPrethGod() {
        return prethodnaGodina;
    }

    public static void setPrethGod(int prethGod) {
        Kalendar.prethodnaGodina = prethGod;
    }

    public static int getPrethMesec() {
        return prethodniMesec;
    }

    public static void setPrethMesec(int prethMesec) {
        Kalendar.prethodniMesec = prethMesec;
    }

    public static boolean isGodinaIzmenjena() {
        return godinaIzmenjena;
    }

    public static void setGodinaIzmenjena(boolean godinaIzmenjena) {
        Kalendar.godinaIzmenjena = godinaIzmenjena;
    }

    public static boolean isMesecIzmenjen() {
        return mesecIzmenjen;
    }

    public static void setMesecIzmenjen(boolean mesecIzmenjen) {
        Kalendar.mesecIzmenjen = mesecIzmenjen;
    }

    public static void setDatum(String Datum) throws ParseException {
        Kalendar.Datum = Datum;
        int G = DobriKalendar.getYear(Datum);
        int M = DobriKalendar.getMonth(Datum);

        if (G != Godina) {
            godinaIzmenjena = true;
            Godina = G;
        } else {
            godinaIzmenjena = false;
        }

        if (M != Mesec) {
            mesecIzmenjen = true;
            Mesec = M;
        } else {
            mesecIzmenjen = false;
        }

        prethodnaGodina = (Mesec == 1 ? Godina - 1 : Godina);
        prethodniMesec = (Mesec == 1 ? 12 : Mesec - 1);
    }
    //</editor-fold>

    public static Kalendar getDefault() {
        return instance = (instance == null ? new Kalendar() : instance);
    }
}
