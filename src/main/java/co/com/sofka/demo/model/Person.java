package co.com.sofka.demo.model;
public class Person {

    private String name;
    private String edad;

    public Person() {
    }

    public Person(String nombre) {
        this.name = nombre;
    }

    public Person(String nombre, String edad) {
        this.name = nombre;
        this.edad = edad;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }
}
