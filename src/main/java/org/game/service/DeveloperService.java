package org.game.service;

import java.io.*;

public class DeveloperService {
    public static void main(String[] args) throws FileNotFoundException {
        String fullDictionaryFilePath = "src/main/java/service/russian-nouns.txt";
        String shortDictionaryFilePath = "src/main/java/service/dictionary.txt";
//        createDictionary(fullDictionaryFilePath, shortDictionaryFilePath);

        String abc = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";
        for (char ch : abc.toCharArray())
            System.out.println((int) ch);

    }

    private static void createDictionary(String fullDictionaryFilePath, String shortDictionaryFilePath) throws FileNotFoundException {
        BufferedReader reader = new BufferedReader(new FileReader(fullDictionaryFilePath));
        PrintWriter writer = new PrintWriter(shortDictionaryFilePath);
        try (reader; writer) {
            while (reader.ready()) {
                String word = reader.readLine();
                if (word.length() > 8) break;
                if (word.length() < 6) continue;
                writer.println(word);
            }
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
