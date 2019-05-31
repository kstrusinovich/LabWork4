package model;

public class Student {

    private Long id;
    private String name;
    private int age;
    private int group_t;
    private double average_mark;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public int getGroup_t() {
        return group_t;
    }

    public void setGroup_t(int group_t) {
        this.group_t = group_t;
    }

    public double getAverage_mark() {
        return average_mark;
    }

    public void setAverage_mark(double average_mark) {
        this.average_mark = average_mark;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", group_t=" + group_t +
                ", average_mark=" + average_mark +
                '}';
    }
}
