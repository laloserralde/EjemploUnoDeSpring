package mx.com.prosa.ejemplouno.util;

import mx.com.prosa.ejemplouno.exception.TarjetaException;
import mx.com.prosa.ejemplouno.exception.UtilsException;

import java.util.regex.Pattern;

public class Utils {
    private static final String regex = "[0-9]+";

    public static void rechazarNCuenta(String nCuenta) throws UtilsException {
        if(Pattern.matches(regex,nCuenta) == false){
            throw new UtilsException(-1,"Cadena invalida");
        }
    }

    public static void rechazarCvv (String cvv) throws UtilsException {
        if (Pattern.matches(regex,cvv) == false){
            throw new UtilsException(-2,"cvv incorrecto");
        }
    }

}
