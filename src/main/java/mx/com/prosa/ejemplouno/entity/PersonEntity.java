package mx.com.prosa.ejemplouno.entity;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "persona")
public class PersonEntity implements Serializable {

    private static final long serialVersionID = 2345L;

    @Id
    @Column(name = "idPersona")
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int idPersona;
    @Column(name = "name",length = 50)
    private String name;
    @Column(name = "cellphone",length = 12)
    private String cellphone;
    @Column(name="fechaNacimiento")
    private Date fechaNacimiento;
    @Column(name = "favoriteNumber")
    private double favoriteNumber;



    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
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

}
