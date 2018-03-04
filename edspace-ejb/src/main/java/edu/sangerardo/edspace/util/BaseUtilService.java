/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sangerardo.edspace.util;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author jorgemalla
 */
@Stateless
public class BaseUtilService implements Serializable {

    /**
     * Permite devolver una lista de fechas de tipo string, las fechas se las
     * obtiene de un rango entre la fecha actual y una fecha enviada por
     * parámetro.
     *
     * @param monthRange
     * @param monthEndRange
     * @param formatDate
     * @return
     */
    public List<String> getDatesRangeString(Integer monthRange, Date monthEndRange, String formatDate) {
        List<String> dateStr = new ArrayList<String>();
        Calendar inicio = Calendar.getInstance();
        inicio.add(Calendar.MONTH, -monthRange);
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(inicio.getTime());
        Calendar endCalendar = new GregorianCalendar();
        endCalendar.setTime(monthEndRange);
        while (calendar.before(endCalendar) || calendar.equals(endCalendar)) {
            Date result = calendar.getTime();
            SimpleDateFormat fechaFormat = new SimpleDateFormat(formatDate);
            dateStr.add(fechaFormat.format(result));
            calendar.add(Calendar.MONTH, 1);
        }
        return dateStr;
    }
}
