package com.cloud.work.utils;

import com.cloud.work.converter.StringToTimestampConverter;
import com.cloud.work.converter.TimestampToStringConverter;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

public class ConvertObjectUtils {
    private static final ModelMapper modelMapper = new ModelMapper();

    static {
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT)
                .setPropertyCondition(context -> context.getSource() != null);
    }

    public static <T> T mapToEntity(Object objectDTO, Class<T> objectEntity) {
        modelMapper.addConverter(new StringToTimestampConverter());
        modelMapper.addConverter(new TimestampToStringConverter());
        return modelMapper.map(objectDTO, objectEntity);
    }

    public static <T> T mapToDTO(Object objectEntity, Class<T> objectDTO) {
        modelMapper.addConverter(new StringToTimestampConverter());
        modelMapper.addConverter(new TimestampToStringConverter());
        return modelMapper.map(objectEntity, objectDTO);
    }
}
