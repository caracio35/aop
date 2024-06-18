package persistencia;

import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

import model.Concursante;
import model.Concurso;
import model.Log;
import model.RegistroConcursantes;

public class LeerDisco implements RegistroConcursantes {

    @Override
    @Log
    public void registrarConcursante(Concursante concursante, Concurso concurso) throws IOException {
        String inscription = concursante.apellido() + "," + concursante.nombre() + "," + concursante.telefono() + ","
                + concursante.email() + "," + concurso.getIdConcurso();
        FileWriter fw = new FileWriter("inscriptions.txt", true);
        fw.write(inscription);
        fw.close();
    }

    @Override
    @Log
    public List<Concurso> cualesConcursosHay() throws IOException, SQLException {
        List<Concurso> concursos = new ArrayList<>();
        String path = "/home/jose/Escritorio/aop/src/main/java/persistencia/concursos.txt";
        File file = new File(path);
        Scanner scanner = new Scanner(file);
        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }
        while (scanner.hasNextLine()) {
            String fila = scanner.nextLine();
            StringTokenizer atributo = new StringTokenizer(fila, ",");
            while (atributo.hasMoreTokens()) {
                int id = Integer.parseInt(atributo.nextToken());
                String nombre = atributo.nextToken();
                String fechaInicio = atributo.nextToken();
                String fechaFin = atributo.nextToken();
                concursos.add(new Concurso(nombre, id, fechaInicio, fechaFin));
            }
        }
        return concursos;
    }

    public void agregarConcurso(Concurso concurso) throws IOException {
        String path = "/home/jose/Escritorio/aop/src/main/java/persistencia/concursos.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path, true))) {
            String Linea = String.format("%d,%s,%s,%s", obtenerUltimoIdConcurso(), concurso.getNombre(),
                    concurso.getFechaInicio(), concurso.getFechaFin());

        }

    }

    private int obtenerUltimoIdConcurso() {
        int id = 0;
        String path = "/home/jose/Escritorio/aop/src/main/java/persistencia/concursos.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(",\\s*");
                int idParte = Integer.parseInt(partes[0]);
                id = Math.max(id, idParte);
            }
        } catch (Exception e) {
            throw new RuntimeException("no se pudo obtener el ultimo id de concursos", e);
        }
        return id;
    }
}