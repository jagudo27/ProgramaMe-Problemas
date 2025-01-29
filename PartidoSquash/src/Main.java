import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;

public class Main {

    public static void procesar(String rutaArchivo) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(rutaArchivo));
            String linea;
            while ((linea = br.readLine()) != null ) {
                char[] partidos = linea.toCharArray();
                int pA = 0, pB = 0;
                for (int i = 0; i < partidos.length ; i++) {
                    if (i == 0){
                        if (partidos[i] == 'A') {
                            pA++;
                        }
                    }
                    else if (partidos[i] == 'A' && partidos[i-1] == 'A') {
                        pA++;
                    }
                    else if (partidos[i] == 'B' && partidos[i-1] == 'B') {
                        pB++;
                    }
                    if(pA >=8 && pB >=8) {
                        if (pA - pB > 1 || pB - pA > 1) {
                            System.out.print(pA + " - " + pB +"  ");
                            pA = 0;
                            pB = 0;
                        }
                    }

                }
                System.out.println(pA + " - " + pB);


            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static void main(String[] args) {
        procesar("src/datos.txt");
    }
}