package com.cloud.work.converter;


import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringToTimestampConverter implements Converter<String, Timestamp> {

    @Override
    public Timestamp convert(MappingContext<String, Timestamp> context) {
        try {
            String source = context.getSource();
            return parseTimestamp(source);
        } catch (ParseException e) {
            return null;
        }
    }

    public static Timestamp parseTimestamp(String s) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date parsedDate = dateFormat.parse(s);
        return new Timestamp(parsedDate.getTime());
    }
}
