package org.example.entities;

public class StudentEntity {
    private int id;
    private String name;
    private String address;
    private String phone_number;
    private String local_current;
    private int age;
    private ClassEntity classEntity;
    public StudentEntity(){}

    public StudentEntity(int id, String name, String address, String phone_number, String local_current, int age, ClassEntity classEntity) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone_number = phone_number;
        this.local_current = local_current;
        this.age = age;
        this.classEntity = classEntity;
    }

    @Override
    public String toString() {
        return "StudentEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone_number='" + phone_number + '\'' +
                ", local_current='" + local_current + '\'' +
                ", age=" + age +
                ", classEntity=" + classEntity +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getLocal_current() {
        return local_current;
    }

    public void setLocal_current(String local_current) {
        this.local_current = local_current;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public ClassEntity getClassEntity() {
        return classEntity;
    }

    public void setClassEntity(ClassEntity classEntity) {
        this.classEntity = classEntity;
    }
}
