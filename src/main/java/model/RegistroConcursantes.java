package model;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface RegistroConcursantes {
    public void registrarConcursante(Concursante concursante, Concurso concurso) throws IOException;

    public void agregarConcurso(Concurso concurso) throws IOException;

    public List<Concurso> cualesConcursosHay() throws IOException, SQLException;
}
