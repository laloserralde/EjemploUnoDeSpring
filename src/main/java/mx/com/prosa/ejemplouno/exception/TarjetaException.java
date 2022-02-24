package mx.com.prosa.ejemplouno.exception;

public class TarjetaException extends Exception {

    private int errorCode;
    private String message;

    public TarjetaException(int errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
        this.message = message;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
