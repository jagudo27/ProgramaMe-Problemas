import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CarreraPopular {

    public ArrayList<String>[] LecturaDatos(String rutaArchivo){
        try(BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))){
            int numVeces = Integer.parseInt(br.readLine());
            ArrayList<String>[] listas = new ArrayList[numVeces];
            for (int i = 0; i < numVeces; i++) {
                ArrayList<String> partes = new ArrayList<String>();
                String linea;
                while (!(linea = br.readLine()).equals("====")) {
                    linea = linea.trim();
                    partes.add(linea);
                }
                listas[i] = partes;
            }
            return listas;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void procesarSalida(ArrayList<String>[] listas){
        for (int i = 0; i < listas.length; i++) {
            Map<String, Integer> apellidoyVeces = new HashMap<>();
            for(String linea : listas[i]){
                String apellido = linea.split(",")[0].toLowerCase();
                apellidoyVeces.put(apellido, apellidoyVeces.getOrDefault(apellido, 0) + 1);
            }
            int hermanosCont = 0;
            for (Map.Entry<String, Integer> entry: apellidoyVeces.entrySet()) {
                if (entry.getValue() >= 2){
                    hermanosCont+= entry.getValue();
                }
            }
            System.out.println(listas[i].size() + " " + hermanosCont);
        }
    }

    public static void main(String[] args) {
        CarreraPopular cp = new CarreraPopular();
        cp.procesarSalida(cp.LecturaDatos("src/texto.txt"));
    }
}