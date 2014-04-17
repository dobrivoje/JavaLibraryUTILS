/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dobrivoje.calendarutilities.exceptions;

/**
 *
 * @author dobri
 */
public class DatumException extends Exception {

    public DatumException() {
        super();
    }

    public DatumException(String Poruka) {
        super(Poruka);
    }
}
