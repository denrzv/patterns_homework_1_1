import java.util.OptionalInt;

public class Person {
    protected final String name;
    protected final String surname;
    protected Integer age;
    protected String address;


    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public boolean hasAge() {
        return age != null;
    }
    public boolean hasAddress() {
        return address != null;
    }

    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public OptionalInt getAge() {
        return OptionalInt.of(age);
    }
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        if (address != null && !address.isBlank()) {
            this.address = address;
        }
    }
    public void happyBirthday() {
        age++;
    }

    @Override
    public String toString() {
        return surname + " " + name
                + (hasAge() ? " возраст: " + age + ", " : "")
                + (hasAddress() ? " адрес: " + address : "");
    }

    @Override
    public int hashCode() {
        return (name + surname).hashCode();
    }

    public PersonBuilder newChildBuilder() {
        PersonBuilder childBuilder = new PersonBuilder()
                .setSurname(surname)
                .setAge(0);

        if (hasAddress()) {
            childBuilder.setAddress(address);
        }
        return childBuilder;
    }
}