package com.equida.common.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class DateUtils {
    private static final SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

	public static boolean isBetween(Date dateDebut, Date dateFin) {
        return isBetween(dateDebut, dateFin, Calendar.getInstance().getTime());
    }

    public static boolean isBetween(Date dateDebut, Date dateFin, Date date) {
        return date.compareTo(dateDebut) >= 0 && date.compareTo(dateFin) <= 0;
    }
	
	public static String format(Date date) {
        return formatter.format(date);
    }
	
}
