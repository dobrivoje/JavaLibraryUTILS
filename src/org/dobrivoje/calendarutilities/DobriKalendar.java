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
public class DobriKalendar {

    private static DobriKalendar instance;

    //<editor-fold defaultstate="collapsed" desc="polja">
    private static final Calendar c = Calendar.getInstance();

    protected static Date DatumStart;
    protected static Date DatumEnd;

    protected static int trajanjeSati;
    protected static int trajanjeMinuti;
    protected static int trajanjeSekunde;
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

    protected synchronized static Date convertString2Date(String Datum) throws ParseException {
        c.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(Datum));
        return c.getTime();
    }

    protected static synchronized void setTrajanje() {
        long dt = DobriKalendar.DatumEnd.getTime() - DobriKalendar.DatumStart.getTime();

        DobriKalendar.trajanjeSekunde = (int) (dt / 1000);
        DobriKalendar.trajanjeMinuti = DobriKalendar.trajanjeSekunde / 60;
        DobriKalendar.trajanjeSati = DobriKalendar.trajanjeMinuti / 60;
    }
}
