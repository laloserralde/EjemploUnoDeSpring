package mx.com.prosa.ejemplouno.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="tarjeta")
public class TarjetaEntity implements Serializable {
    @Id
    @Column(name = "idTarjeta")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idTarjeta;
    @Column(name = "nCuenta",length = 16)
    private String nCuenta;
    @Column(name = "fechaAlta")
    private Date fechaAlta;
    @Column(name = "cvv")
    private String cvv;




    public int getIdTarjeta() {
        return idTarjeta;
    }

    public void setIdTarjeta(int idTarjeta) {
        this.idTarjeta = idTarjeta;
    }



    public String getnCuenta() {
        return nCuenta;
    }

    public void setnCuenta(String nCuenta) {
        this.nCuenta = nCuenta;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }
}
