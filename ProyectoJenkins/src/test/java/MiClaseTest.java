import org.example.MiClase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;
class MiClaseTest {
    // Prueabs poara dias laborales
    @ParameterizedTest(name = "Dia laboral : {0}")
    @CsvSource({
            "Lunes",
            "Martes",
            "Miercoles",
            "Jueves",
            "Viernes"
    })
    void testDiasLaborales_DebeRetornarTrue(String dia) {
// Asegura que para los dias de la lista, la funcion retorna true
    Assertions.assertTrue(MiClase.dia_laboral(dia), "El dia '" + dia + "' deberia ser laboral.");
    }
    // Pruebas para Fines de Semana
    @ParameterizedTest(name = "Dia No Laboral: {0}")
    @CsvSource({
            "Sabado",
            "Domingo"
    })
    void testFinesDeSemana_DebeRetornarFalse(String dia) {
// Asegura que para los fines de semana, la funcion retorna false
        assertFalse(MiClase.dia_laboral(dia), "El dia '" + dia + "' no deberia ser laboral.");
    }
    // Pruebas de Casos Limite y No Validos
    @Test
    void testCasoSensible_Minusculas_DebeRetornarFalse() {
// La implementacion actual es sensible a mayusculas, por lo que una entrada en
//        minusculas debe fallar
        assertFalse(MiClase.dia_laboral("lunes"), "Las minusculas no deben coincidir (la implementacion no es robusta a mayusculas).");
    }
    @Test
    void testEntradaInvalida_DebeRetornarFalse() {
// Cualquier cadena que no sea un dia definido debe retornar falso
        assertFalse(MiClase.dia_laboral("Vacaciones"), "Una entrada no valida debe retornar falso.");
    }
    @Test
    void testEntradaVacia_DebeRetornarFalse() {
// Una cadena vacia tampoco debe coincidir
        assertFalse(MiClase.dia_laboral(""), "Una cadena vacia debe retornar falso.");
    }
}

