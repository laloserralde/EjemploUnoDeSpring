package mx.com.prosa.ejemplouno.model;

import java.util.Date;
import java.util.GregorianCalendar;

public class Person {
    private int idPerson;
    private String name;
    private String cellphone;
    private Date fechaNacimiento;
    private double favoriteNumber;
    private Tarjeta tarjeta;

    public Person(String name, String cellphone, Date fechaNacimiento, double favoriteNumber) {
        this.name = name;
        this.cellphone = cellphone;
        this.fechaNacimiento = fechaNacimiento;
        this.favoriteNumber = favoriteNumber;
    }

    public Person(int idPerson, String name, String cellphone, Date fechaNacimiento, double favoriteNumber, Tarjeta tarjeta) {
        this.idPerson = idPerson;
        this.name = name;
        this.cellphone = cellphone;
        this.fechaNacimiento = fechaNacimiento;
        this.favoriteNumber = favoriteNumber;
        this.tarjeta = tarjeta;
    }

    public Tarjeta getTarjeta() {
        return tarjeta;
    }

    public void String(String name){
        this.name = name;
    }

    public Person(){

    }

    public void setTarjeta(Tarjeta tarjeta) {
        this.tarjeta = tarjeta;
    }

    public Person(String name, String cellphone, int year, int month, int day, double favoriteNumber) {
        this.name = name;
        this.cellphone = cellphone;
        this.favoriteNumber = favoriteNumber;

        GregorianCalendar calendar = new GregorianCalendar(year, month,day);
        fechaNacimiento = calendar.getTime();
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public double getFavoriteNumber() {
        return favoriteNumber;
    }

    public void setFavoriteNumber(double favoriteNumber) {
        this.favoriteNumber = favoriteNumber;
    }

    public int getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(int idPerson) {
        this.idPerson = idPerson;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", cellphone='" + cellphone + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", favoriteNumber=" + favoriteNumber +
                ", tarjeta=" + tarjeta +
                '}';
    }
}
