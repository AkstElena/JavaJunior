package homeworks.homework3;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class Main {

    public static final String FILE_JSON = "src/main/java/homeworks/homework3/hw.json";
    public static final String FILE_BIN = "src/main/java/homeworks/homework3/hw.bin";
    public static final String FILE_XML = "src/main/java/homeworks/homework3/hw.xml";
    private static final ObjectMapper objectMapper = new ObjectMapper(); // по умолчанию рабтает с json документом
    private static final XmlMapper xmlMapper = new XmlMapper(); // с xml документом

    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Elena", 40));
        persons.add(new Person("Renat", 35));
        persons.add(new Person("Karl", 43));
        savePersonsToFile(FILE_JSON, persons);
        savePersonsToFile(FILE_BIN, persons);
        savePersonsToFile(FILE_XML, persons);
        System.out.println("Данные сохранены локально");
        System.out.println(loadPersonsFromFile(FILE_JSON));
        System.out.println(loadPersonsFromFile(FILE_BIN));
        System.out.println(loadPersonsFromFile(FILE_XML));
        System.out.println("Данные выгуржены");




    }

    public static void savePersonsToFile(String fileName, List<Person> persons) {
        try {
            if (fileName.endsWith(".json")) {
                objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
                objectMapper.writeValue(new File(fileName), persons);
            } else if (fileName.endsWith(".bin")) { // стандартная бинарная сериализация
                try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
                    oos.writeObject(persons);
                }
            } else if (fileName.endsWith(".xml")) {
                xmlMapper.writeValue(new File(fileName), persons);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Person> loadPersonsFromFile(String fileName) {
        List<Person> persons = new ArrayList<>();

        File file = new File(fileName);
        if (file.exists()) {
            try {
                if (fileName.endsWith(".json")) {
                    persons = objectMapper.readValue(file, objectMapper.getTypeFactory().constructCollectionType(List.class, Person.class));
                } else if (fileName.endsWith(".bin")) {
                    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
                        persons = (List<Person>) ois.readObject();
                    }
                } else if (fileName.endsWith(".xml")) {
                    persons = xmlMapper.readValue(file, xmlMapper.getTypeFactory().constructCollectionType(List.class, Person.class));
                }
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return persons;
    }
}
