package phonebook;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class PhoneBook {
    private Map<String, List<String>> phoneMap = new HashMap<>();

    public PhoneBook() {
        initializePhoneBook();
    }

    private void initializePhoneBook() {
        phoneMap.put("Иванов И.И.", Arrays.asList("+8 800 2000 500", "+8 800 200 600"));
        phoneMap.put("Петров П.П.", Arrays.asList("+8 800 2000 700"));
        phoneMap.put("Сидоров С.С.", Arrays.asList("+8 800 2000 800", "+8 800 2000 900", "+8 800 2000 000"));
        System.out.println(phoneMap);
    }

    public void readInput() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Enter last name(Example: Иванов И.И.), q - for exit.");
            while (true) {
                String lastName = br.readLine();
                if (lastName.equals("q")) {
                    break;
                }
                printPhones(lastName);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void printPhones(String lastName) {
        if (!phoneMap.containsKey(lastName)) {
            System.out.println("Book doesn't contain " + lastName + ". Try again.");
        } else {
            System.out.println("Phones for " + lastName + ": " + phoneMap.get(lastName));
        }
    }


}
