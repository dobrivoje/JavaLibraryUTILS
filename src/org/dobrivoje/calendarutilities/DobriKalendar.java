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
 * Klasa DobriKalendar obezbeđuje sve moguće funkcionalnosti u vezi datuma.
 */
public class DobriKalendar {

    private static DobriKalendar instance;

    //<editor-fold defaultstate="collapsed" desc="polja">
    private static final Calendar c = Calendar.getInstance();

    protected static Date DatumStart;
    protected static Date DatumEnd;

    protected static int trajanjeSati;
    protected static int trajanjeMinuti;
    protected static int trajanjeSekunde;

    public static final String DATETIME_MASK_EN = "yyyy-MM-dd HH:mm:ss";
    public static final String DATE_MASK_EN = "yyyy-MM-dd";

    public static final String TODAY_DATE_STR = (new SimpleDateFormat(DATE_MASK_EN)).format(new Date());
    public static final String TODAY_DATETIMR_STR = (new SimpleDateFormat(DATETIME_MASK_EN)).format(new Date());
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Konstruktori">
    protected DobriKalendar() {
    }

    protected DobriKalendar(Date DatumOD, Date DatumDO) {
        DobriKalendar.DatumStart = DatumOD;
        DobriKalendar.DatumEnd = DatumDO;

        setTrajanje();
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="getters">
    public int getTrajanjeSati() {
        return trajanjeSati;
    }

    public int getTrajanjeMinuti() {
        return trajanjeMinuti;
    }

    public int getTrajanjeSekunde() {
        return trajanjeSekunde;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="modified setters">
    public final void setDates(String DatumStart, String DatumEnd) throws ParseException {
        DobriKalendar.DatumStart = convertString2Date(DatumStart);
        DobriKalendar.DatumEnd = convertString2Date(DatumEnd);

        setTrajanje();
    }

    public final void setDates(Date DatumStart, Date DatumEnd) {
        DobriKalendar.DatumStart = DatumStart;
        DobriKalendar.DatumEnd = DatumEnd;

        setTrajanje();
    }
    //</editor-fold>

    public static DobriKalendar getDefault() {
        return instance = (instance == null ? new DobriKalendar() : instance);
    }

    public static Date convertString2Date(String Datum) throws ParseException {
        c.setTime(new SimpleDateFormat(DATE_MASK_EN).parse(Datum));
        return c.getTime();
    }

    public static String convertDate2String(Date Datum) throws ParseException {
        return new SimpleDateFormat(DATE_MASK_EN).format(Datum);
    }

    protected static synchronized void setTrajanje() {
        long dt = DobriKalendar.DatumEnd.getTime() - DobriKalendar.DatumStart.getTime();

        DobriKalendar.trajanjeSekunde = (int) (dt / 1000);
        DobriKalendar.trajanjeMinuti = DobriKalendar.trajanjeSekunde / 60;
        DobriKalendar.trajanjeSati = DobriKalendar.trajanjeMinuti / 60;
    }

    //<editor-fold defaultstate="collapsed" desc="Godina, mesec, dan...">
    public static int getYear(String Datum) throws ParseException {
        c.setTime(Datum == null ? new Date() : DobriKalendar.convertString2Date(Datum));
        return c.get(Calendar.YEAR);
    }

    public static int getMonth(String Datum) throws ParseException {
        c.setTime(Datum == null ? new Date() : DobriKalendar.convertString2Date(Datum));
        return 1 + c.get(Calendar.MONTH);
    }

    public static int getDay(String Datum) throws ParseException {
        c.setTime(Datum == null ? new Date() : DobriKalendar.convertString2Date(Datum));
        return c.get(Calendar.DAY_OF_MONTH);
    }
    //</editor-fold>
}
