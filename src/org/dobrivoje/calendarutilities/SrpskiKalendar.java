/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dobrivoje.calendarutilities;

/**
 *
 * @author dobri
 */
public class SrpskiKalendar {

    private static final String[] meseciLatinica = new String[]{
        "Januar",
        "Februar",
        "Mart",
        "April",
        "Maj",
        "Jun",
        "Jul",
        "Avgust",
        "Septembar",
        "Oktobar",
        "Novembar",
        "Decembar"
    };

    private static final String[] meseciCirilica = new String[]{
        "Јануар",
        "Фебруар",
        "Март",
        "Април",
        "Мај",
        "Јун",
        "Јул",
        "Август",
        "Септембар",
        "Октобар",
        "Новембар",
        "Децембар"
    };

    public static String getMesecNazivLatinica(int Mesec) {
        return meseciLatinica[Mesec - 1];
    }

    public static String getMesecNazivCirilica(int Mesec) {
        return meseciCirilica[Mesec - 1];
    }
}
