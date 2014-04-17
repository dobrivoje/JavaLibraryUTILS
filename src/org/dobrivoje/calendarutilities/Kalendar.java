/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dobrivoje.calendarutilities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author dobri
 */
public class Kalendar {

    //<editor-fold defaultstate="collapsed" desc="polja">
    private static final Calendar c = Calendar.getInstance();

    private int Godina;
    private int Mesec;

    private int prethodnaGod;
    private int prethodniMesec;

    private boolean godinaIzmenjena;
    private boolean mesecIzmenjen;

    public static final String DATETIME_MASK_EN = "yyyy-MM-dd HH:mm:ss";
    public static final String DATE_MASK_EN = "yyyy-MM-dd";

    private static Kalendar instance;

    private static String Datum;
    private boolean datumIzmenjen;
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Konstruktor, getter/setter">
    protected Kalendar() {
    }

    public String getDatum() {
        return Datum;
    }

    public int getGodina() {
        return Godina;
    }

    public int getMesec() {
        return Mesec;
    }

    public int getPrethodnaGod() {
        return prethodnaGod;
    }

    public int getPrethodniMesec() {
        return prethodniMesec;
    }

    public boolean isGodinaIzmenjena() {
        return godinaIzmenjena;
    }

    public boolean isMesecIzmenjen() {
        return mesecIzmenjen;
    }

    public synchronized void setDatum(String Datum) {
        if (Datum == null) {
            Kalendar.Datum = instance.convertDate2String(new Date());
            datumIzmenjen = true;
        } else if (!Kalendar.Datum.equals(Datum)) {
            Kalendar.Datum = Datum;
            datumIzmenjen = true;
        } else {
            datumIzmenjen = false;
        }

        if (datumIzmenjen) {
            try {
                c.setTime(convertString2Date(Kalendar.Datum));

                if (c.get(Calendar.YEAR) != Godina) {
                    Godina = c.get(Calendar.YEAR);
                    godinaIzmenjena = true;
                    mesecIzmenjen = true;
                } else {
                    godinaIzmenjena = false;
                }

                if (1 + c.get(Calendar.MONTH) != Mesec) {
                    Mesec = 1 + c.get(Calendar.MONTH);
                    mesecIzmenjen = true;
                } else {
                    mesecIzmenjen = false;
                }

                prethodnaGod = (Mesec == 1 ? Godina - 1 : Godina);
                prethodniMesec = (Mesec == 1 ? 12 : Mesec - 1);

            } catch (ParseException ex) {
            }
        }
    }
    //</editor-fold>

    public static Kalendar getDefault() {
        if (instance == null) {
            instance = new Kalendar();
            Kalendar.Datum = instance.convertDate2String(new Date());
        }

        return instance;
    }

    public static Date convertString2Date(String Datum) throws ParseException {
        return (new SimpleDateFormat(DATE_MASK_EN)).parse(Datum);
    }

    public String convertDate2String(Date Datum) {
        return (new SimpleDateFormat(DATE_MASK_EN)).format(Datum);
    }
}
