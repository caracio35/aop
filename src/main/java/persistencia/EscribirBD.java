package persistencia;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Concursante;
import model.Concurso;
import model.RegistroConcursantes;

public class EscribirBD implements RegistroConcursantes {
    private final String coneccion = "jdbc:mysql://localhost:3306/concursos";
    private final String usuario = "root";
    private final String password = "";

    @Override
    public void registrarConcursante(Concursante concursante, Concurso concurso) throws IOException {
        var sql = "INSERT INTO concursantes (nombre, apellido, dni, telefono, email, idConcurso) VALUES (?,?,?,?,?,?,?)";
        try (Connection con = DriverManager.getConnection(coneccion, usuario, password);
                PreparedStatement statement = con.prepareStatement(sql)) {
            statement.setString(1, concursante.nombre());
            statement.setString(2, concursante.apellido());
            statement.setString(3, concursante.dni());
            statement.setString(4, concursante.telefono());
            statement.setString(5, concursante.email());
            statement.setInt(6, concurso.getIdConcurso());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("no se pudo conectar a la base de datos", e);
        }
    }

    @Override
    public List<Concurso> cualesConcursosHay() throws IOException {
        String sql = "SELECT id ,nombre ,fechaInicio,fechaFin FROM concursos";
        List<Concurso> concursos = new ArrayList<>();
        try (Connection con = DriverManager.getConnection(coneccion, usuario, password);
                PreparedStatement statement = con.prepareStatement(sql)) {
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                // String nombre, int idConcurso, String fechaInicio, String fechaFin
                int id = rs.getInt(1);
                String nombre = rs.getString(2);
                String fechaInicio = rs.getString(3);
                String fechaFin = rs.getString(4);

                Concurso concu = new Concurso(nombre, id, fechaInicio, fechaFin);
                concursos.add(concu);
            }

        } catch (SQLException e) {
            throw new RuntimeException("no se pudo conectar a la base de datos", e);
        }
        return concursos;
    }

    @Override
    public void agregarConcurso(Concurso concurso) throws IOException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'agregarConcurso'");
    }

}
