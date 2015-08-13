package io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class CloseFinally {

    public static void main(String[] args) {
        InputStream is = null;
        try {
            is = new FileInputStream("test.properties");
            int b;
            System.out.println("=== Vypis suboru ===");
            while ((b = is.read()) != -1) {
                System.out.printf("%c",b);
            }
            System.out.println("====== Koniec ======");
        } catch (IOException ex) {
            //spracovanie chyby
            System.err.println("Error: " + ex.getLocalizedMessage());
        } finally { // tato cast aktualne potrebna len na zatvorenie streamu
            try {
                if (is != null) {
                    is.close();
                }
            } catch (IOException ex) {
                //spracovanie chyby pri zatvarani streamu
                System.err.println("Error closing: " + ex.getLocalizedMessage());
            }
        }
    }

}
