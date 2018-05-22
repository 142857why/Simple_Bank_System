import java.io.*;

public class TestPerson {
    public static void main(String[] args) {
        writeSerializableObject();
        readSerializableObject();
    }

    public static void writeSerializableObject() {
        try {
            Man man = new Man("zhourui", "1234");
            Person person = new Person(man, "Rui", 21);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("zhourui.dat"));
            objectOutputStream.writeObject(person);
            objectOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readSerializableObject() {
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("zhourui.dat"));
            Person person = (Person) objectInputStream.readObject();
            objectInputStream.close();
            System.out.println("age: " + person.getAge() + ", man username: " + person.getMan().getUserName());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
