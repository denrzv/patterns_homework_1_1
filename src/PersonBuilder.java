public class PersonBuilder {
    private String name;
    private String surname;
    private Integer age;
    private String address;

    public PersonBuilder setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Указано некорректное имя");
        } else {
            this.name = name;
        }
        return this;
    }
    public PersonBuilder setSurname(String surname) {
        if (surname == null || surname.isBlank()) {
            throw new IllegalArgumentException("Указана некорректная фамилия");
        } else {
            this.surname = surname;
        }
        return this;
    }
    public PersonBuilder setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Указан некорректный возраст: " + age);
        } else {
            this.age = age;
        }
        return this;
    }
    public PersonBuilder setAddress(String address) {
        if (address == null || address.isBlank()) {
            throw new IllegalArgumentException("Указан некорректный адрес: " + address);
        } else {
            this.address = address;
        }
        return this;
    }

    public Person build() {
        if (name == null || surname == null) {
            throw new IllegalStateException("Не указано имя или фамилия человека");
        } else {
            Person person;
            if (age != null) {
                person = new Person(name, surname, age);
            } else {
                person = new Person(name, surname);
            }

            if (address != null) {
                person.setAddress(address);
            }

            return person;
        }
    }
}