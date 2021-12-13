package edu.neu.csye6200.controller.Util;

import java.io.*;
import java.util.*;

public class FileUtil {
    public static synchronized void write(String fileName, List<String> content) {
        try (BufferedWriter out = new BufferedWriter(new FileWriter(fileName))){
            for (String line : content) {
                out.write(line);
                out.newLine();
            }
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static synchronized List<String> read(String fileName) {
        String thisLine;
        List<String> list = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(fileName))){
            while ((thisLine = in.readLine()) != null) {
                list.add(thisLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return list;
    }
}
