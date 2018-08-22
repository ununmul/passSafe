package com.github.ununmul.outlook;

import com.github.ununmul.files.FilesFacade;
import com.github.ununmul.generator.GeneratorType;
import com.github.ununmul.model.PasswordEntry;
import com.github.ununmul.model.PasswordFacade;

import java.io.FileFilter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class AppView {

    public void run() {
        Scanner skaner = new Scanner(System.in);

        int question;
        System.out.println("Co chcesz zrobic:\n" +
                "1) Wygenerowac i zapisac haslo do pliku\n" +
                "2) Odczytac hasla z pliku\n" +
                "3) Usunac haslo z pliku\n" +
                "0) Wyjscie");
        question = skaner.nextInt();

        switch (question) {
            case 1:
                generatePass();
                break;
            case 2:
                checkPassword();
                break;
            case 3:
                removePassword();
                break;
            case 0:
                break;
        }
    }

    public void generatePass() {

        String website;
        String login;
        int length;
        Scanner skaner = new Scanner(System.in);
        System.out.println("Podaj domene");
        website = skaner.nextLine();
        System.out.println("Podaj login");
        login = skaner.nextLine();
        System.out.println("Z ilu znakow na byc haslo");
        length = skaner.nextInt();

        PasswordFacade passwordFacade = new PasswordFacade();
        FilesFacade filesFacade = new FilesFacade();
        PasswordEntry passwordEntry = passwordFacade.generatePassword(website, login, GeneratorType.LETTERS, length);
        List<PasswordEntry> passwordEntries = new ArrayList<>();
        passwordEntries.add(passwordEntry);
        filesFacade.writeToFile("test.csv", passwordEntries);
    }

    public void checkPassword() {

        FilesFacade filesFacade = new FilesFacade();
        List<String> list = filesFacade.readFile("test.csv");

        for (String linia : list) {
            System.out.println(linia);
        }
    }

    private void removePassword() {
        FilesFacade filesFacade = new FilesFacade();
        List<String> list = filesFacade.readFile("test.csv");
        Scanner skaner = new Scanner(System.in);

        String website;
        System.out.println("Podaj domene do ktorej haslo i login zostana skasowane");
        website = skaner.nextLine();
        String lines[] = new String[3];

        for (String line : list) {
            lines = line.split(";");
        }

        System.out.println(lines[0]);
        System.out.println(lines[1]);
        System.out.println(lines[2]);

    }
}

