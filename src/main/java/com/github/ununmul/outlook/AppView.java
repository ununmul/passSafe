package com.github.ununmul.outlook;

import com.github.ununmul.files.FilesFacade;
import com.github.ununmul.generator.GeneratorType;
import com.github.ununmul.model.PasswordEntry;
import com.github.ununmul.model.PasswordFacade;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AppView {

    public void run() {
        Scanner skaner = new Scanner(System.in);

        int question;
        System.out.println("Co chcesz zrobic:\n1) Wygenerowac i zapisac haslo do pliku\n2) Sprawdzic haslo\n0) Wyjscie");
        question = skaner.nextInt();

        switch (question) {
            case 1:
                generatePass();
                break;

            case 2:
                break;

            case 0:
                break;
            }
    }

    public void generatePass () {

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
        filesFacade.writeToFile("test.txt", passwordEntries);

    }

}
