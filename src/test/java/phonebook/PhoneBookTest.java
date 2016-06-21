package phonebook;


import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class PhoneBookTest {
    private static PhoneBook phoneBook;

    public PhoneBookTest() {
    }

    @BeforeClass
    public static void initializePhoneBookTest() {
        phoneBook = new PhoneBook();
    }

    @Test
    public void testGetPhonesWithProperLastName() {
        List<String> phones = phoneBook.getPhones("Иванов И.И.");

        assertNotNull(phones);
        assertTrue(phones.contains("+8 800 2000 500"));
        assertTrue(phones.contains("+8 800 200 600"));
    }

    @Test
    public void testGetPhonesWithNotExistingLastName()  {
        List<String> phones = phoneBook.getPhones("Some last name");

        assertNotNull(phones);
        assertTrue(phones.size() == 0);
    }

    @Test()
    public void testGetPhonesWithNull()  {
        List<String> phones = phoneBook.getPhones(null);
        assertNotNull(phones);
        assertTrue(phones.size() == 0);
    }
}
