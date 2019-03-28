package com.equida.common.converter;

import javax.persistence.AttributeConverter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConverter implements AttributeConverter<Date, String> {

    private static final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public String convertToDatabaseColumn(Date date) {
        return formatter.format(date);
    }

    @Override
    public Date convertToEntityAttribute(String s) {
        try {
            return formatter.parse(s);

        } catch (ParseException e) {
            return null;
        }
    }
}
