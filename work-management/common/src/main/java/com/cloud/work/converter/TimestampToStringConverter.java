package com.cloud.work.converter;

import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class TimestampToStringConverter implements Converter<Timestamp, String> {

    @Override
    public String convert(MappingContext<Timestamp, String> context) {
        Timestamp timestamp = context.getSource();
        return parseString(timestamp);
    }


    public static String parseString(Timestamp timestamp){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.format(timestamp);
    }
}
