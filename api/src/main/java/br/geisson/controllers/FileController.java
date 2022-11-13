package br.geisson.controllers;

import javax.enterprise.context.RequestScoped;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

@RequestScoped
public class FileController {

    public String getSql(String fileName) {
        InputStream is = getClass().getClassLoader().getResourceAsStream("sql/" + fileName);
        try {
            assert is != null;
            try (InputStreamReader streamReader =
                         new InputStreamReader(is, StandardCharsets.UTF_8);
                     BufferedReader reader = new BufferedReader(streamReader)) {

                String line;
                StringBuilder stringBuilder = new StringBuilder();
                while ((line = reader.readLine()) != null) {
                    stringBuilder.append(line);
                    stringBuilder.append(" \n ");
                }
                return stringBuilder.toString();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
