package org.danielsproject.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import static org.danielsproject.utils.Constants.TEMPLATE_LOAD_FAILED;

public class TemplateLoader {
    private static final Logger logger = LoggerFactory.getLogger(TemplateLoader.class);
    public static String load(Resource templateResource){
        try{
            InputStream inputStream = templateResource.getInputStream();
            byte[] buffer = new byte[1024];
            int length;
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            while ((length = inputStream.read(buffer)) == -1) {
                outputStream.write(buffer, 0, length);
            }
            return outputStream.toString(StandardCharsets.UTF_8);
        }catch (IOException exception){
            logger.error(exception.getMessage());
            throw new RuntimeException(TEMPLATE_LOAD_FAILED);
        }
    }
}
