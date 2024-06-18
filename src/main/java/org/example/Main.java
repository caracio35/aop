package org.example;

import java.io.IOException;
import java.sql.SQLException;

import javax.swing.SwingUtilities;

import UI.UICompeticion;
import model.Concurso;
import model.RegistroConcursantes;
import persistencia.LeerDisco;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new Main().start();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    protected void start() throws IOException, SQLException {

        RegistroConcursantes persistencia = new LeerDisco();
        persistencia.agregarConcurso(new Concurso("Concurso 1", 1, "2020-01-01", "2020-01-31"));
        persistencia.agregarConcurso(new Concurso("Concurso 2", 2, "2020-01-01", "2020-01-31"));

        new UICompeticion(persistencia);
    }
}