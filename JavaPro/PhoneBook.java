import java.util.*;
public class PhoneBook {
    private final HashMap<String, List<String>> phoneBook;

    public PhoneBook() {
        phoneBook = new HashMap<>();
    }

    // Метод для добавления записи в телефонную книгу
    public void addContact(String name, String phone) {
        phoneBook.putIfAbsent(name, new ArrayList<>());
        if (!phoneBook.get(name).contains(phone)) {
            phoneBook.get(name).add(phone);
        }
    }

    // Метод для получения всех записей, отсортированных по убыванию числа телефонов
    public List<Map.Entry<String, List<String>>> getSortedContacts() {
        List<Map.Entry<String, List<String>>> sortedContacts = new ArrayList<>(phoneBook.entrySet());
        sortedContacts.sort((entry1, entry2) -> Integer.compare(entry2.getValue().size(), entry1.getValue().size()));
        return sortedContacts;
    }

    // Метод для вывода телефонной книги
    public void printPhoneBook() {
        List<Map.Entry<String, List<String>>> sortedContacts = getSortedContacts();
        for (Map.Entry<String, List<String>> entry : sortedContacts) {
            System.out.println(entry.getKey() + ": " + String.join(", ", entry.getValue()));
        }
    }

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.addContact("Jo", "254-768-7890");
        phoneBook.addContact("Dori", "234-567-8901");
        phoneBook.addContact("Sven", "345-678-9012");
        phoneBook.addContact("Tod", "456-789-0123");
        phoneBook.addContact("Sven", "567-890-1234");
        phoneBook.addContact("Dori", "576-900-2655");

        phoneBook.printPhoneBook();
    }
}
