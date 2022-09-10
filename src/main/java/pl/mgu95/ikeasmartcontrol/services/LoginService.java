package pl.mgu95.ikeasmartcontrol.services;

import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

@Service
public class LoginService {

    public boolean validateCredentials(String ip, String identity, String key) {
        if (!validateFromTxtFile(ip, identity, key)) {return false;}
        return true;
    }

    private boolean validateFromTxtFile(String ip, String identity, String key) {

        Path path = Paths.get("src/main/resources/credentials.txt");
        Map<String, String> credentialsMap = new TreeMap<>();

        try {
            File credentialsFile = new File(String.valueOf(path));
            Scanner scanner = new Scanner(credentialsFile);
            while (scanner.hasNextLine()) {
                StringTokenizer stringTokenizer = new StringTokenizer(scanner.nextLine(),"=");
                credentialsMap.put(stringTokenizer.nextToken(), stringTokenizer.nextToken());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        if (!ip.equals(credentialsMap.get("ip"))) {
            System.out.println("Invalid IP address!");
            return false;
        }
        if (!identity.equals(credentialsMap.get("identity"))) {
            System.out.println("Invalid Identity!");
            return false;
        }
        if (!key.equals(credentialsMap.get("key"))) {
            System.out.printf("Invalid Key!");
            return false;
        }
        return true;
    }

    public void createNewFile() {
        Path path = Paths.get("src/main/resources/credentials.txt");
        try {
            File myObj = new File(String.valueOf(path));
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
