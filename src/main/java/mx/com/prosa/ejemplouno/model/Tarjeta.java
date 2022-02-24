package mx.com.prosa.ejemplouno.model;

import java.util.Date;

public class Tarjeta {

    private int idTarjeta;
    private String nCuenta;
    private Date fechaAlta;
    private String cvv;

    public Tarjeta(){

    }

    public Tarjeta(int idTarjeta) {
        this.idTarjeta = idTarjeta;
    }

    public Tarjeta(int idTarjeta, String nCuenta, Date fechaAlta, String cvv) {
        this.idTarjeta = idTarjeta;
        this.nCuenta = nCuenta;
        this.fechaAlta = fechaAlta;
        this.cvv = cvv;
    }

    public int getIdTarjeta() {
        return idTarjeta;
    }

    public void setIdTarjeta(int idTarjeta) {
        this.idTarjeta = idTarjeta;
    }

    public Tarjeta(String nCuenta, Date fechaAlta, String cvv) {
        this.nCuenta = nCuenta;
        this.fechaAlta = fechaAlta;
        this.cvv = cvv;
    }

    public Tarjeta(String nCuenta){
        this.nCuenta = nCuenta;
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

    @Override
    public String toString() {
        return "Tarjeta{" +
                "idTarjeta=" + idTarjeta +
                ", nCuenta='" + nCuenta + '\'' +
                ", fechaAlta=" + fechaAlta +
                ", cvv='" + cvv + '\'' +
                '}';
    }
}
