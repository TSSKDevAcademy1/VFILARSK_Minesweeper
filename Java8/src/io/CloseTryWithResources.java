package io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class CloseTryWithResources {

	//Java 7
    public static void main(String[] args) {
//         zabezpeci automaticky zavolanie close() nad premennymi definovanymi v "try (..tu..) {"
//         nie je potrebne finally na tuto cinnost
        try (InputStream is = new FileInputStream("test.properties")) { 
            int b;
            System.out.println("=== Vypis suboru ===");
            while ((b = is.read()) != -1) {
                System.out.printf("%c",b);
            }
            System.out.println("====== Koniec ======");
        } catch (IOException ex) {
            //spracovanie chyby
            System.err.println("Error: " + ex.getLocalizedMessage());
        } 
    }

}
