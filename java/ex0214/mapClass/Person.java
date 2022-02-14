package ex0214.mapClass;

public class Person {
    private String id;
    private String name;
    private int age;

    public Person() {
    }

    public Person(String id, String name) {
        //super();
        this.id = id;
        this.name = name;
    }

    public Person(String id, String name, int age) {
        this(id, name);
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("id='").append(id).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", age=").append(age);
        sb.append("   ");
        return sb.toString();
    }
}
