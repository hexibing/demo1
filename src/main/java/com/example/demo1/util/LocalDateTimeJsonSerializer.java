package com.example.demo1.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.time.LocalDateTime;
/**
 * 本地时间转成字符串
 *
 * @author: hexibing
 * @date: 2019-01-15 11:51
 * @version 1.0
 */
public class LocalDateTimeJsonSerializer  extends JsonSerializer<LocalDateTime> {

    @Override
    public void serialize(LocalDateTime localDateTime, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeString(LocalDateTimeUtil.toDefaultString(localDateTime));
    }
}
