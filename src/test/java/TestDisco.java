import java.io.IOException;

import org.junit.Test;

import model.Concurso;
import model.RegistroConcursantes;
import persistencia.LeerDisco;

public class TestDisco {
    @Test
    public void test() throws IOException {
        RegistroConcursantes registro = new LeerDisco();
        registro.agregarConcurso(new Concurso("concu1", 1, "17/12/24", "21/12/24"));
    }
}
