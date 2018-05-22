import java.io.Serializable;

public class Person implements Serializable {
    private Man man;
    private String userName;
    private transient int age;

    public Man getMan() {
        return this.man;
    }

    public void setMan(Man man) {
        this.man = man;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person() {
        System.out.println("Person constructed");
    }

    public Person(Man man, String userName, int age) {
        this.man = man;
        this.userName = userName;
        this.age = age;
    }


}
