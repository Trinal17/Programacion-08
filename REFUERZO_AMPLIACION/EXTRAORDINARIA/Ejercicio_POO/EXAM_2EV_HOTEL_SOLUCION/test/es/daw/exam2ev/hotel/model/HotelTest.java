/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package es.daw.exam2ev.hotel.model;

import es.daw.exam2ev.hotel.model.interfaces.Reservable;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author melola
 */
public class HotelTest {
    
    public HotelTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of obtenerReservasHabitacionOrdenadasDeFormaNatural method, of class Hotel.
     */
    @Test
    public void testObtenerReservasHabitacionOrdenadasDeFormaNatural() {
        System.out.println("obtenerReservasHabitacionOrdenadasDeFormaNatural");
        Hotel instance = null;
        ArrayList<Habitacion> expResult = null;
        ArrayList<Habitacion> result = instance.obtenerReservasHabitacionOrdenadasDeFormaNatural();
        
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerReservasServicioSPAOrdenadosPorReferenciaCliente method, of class Hotel.
     */
    @Test
    public void testObtenerReservasServicioSPAOrdenadosPorReferenciaCliente() {
        System.out.println("obtenerReservasServicioSPAOrdenadosPorReferenciaCliente");
        Hotel instance = null;
        ArrayList<ServicioSPA> expResult = null;
        ArrayList<ServicioSPA> result = instance.obtenerReservasServicioSPAOrdenadosPorReferenciaCliente();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerReservasPorReferenciaCliente method, of class Hotel.
     */
    @Test
    public void testObtenerReservasPorReferenciaCliente() throws Exception {
        System.out.println("obtenerReservasPorReferenciaCliente");
        String referenciaCliente = "";
        Hotel instance = null;
        ArrayList<Reservable> expResult = null;
        ArrayList<Reservable> result = instance.obtenerReservasPorReferenciaCliente(referenciaCliente);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerReservasHabitacionPorCliente method, of class Hotel.
     */
    @Test
    public void testObtenerReservasHabitacionPorCliente() {
        System.out.println("obtenerReservasHabitacionPorCliente");
        Cliente cliente = null;
        Hotel instance = null;
        ArrayList<Habitacion> expResult = null;
        ArrayList<Habitacion> result = instance.obtenerReservasHabitacionPorCliente(cliente);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerFacturaReservaPorPosicion method, of class Hotel.
     */
    @Test
    public void testObtenerFacturaReservaPorPosicion() {
        System.out.println("obtenerFacturaReservaPorPosicion");
        int posicion = 0;
        Hotel instance = null;
        String expResult = "";
        String result = instance.obtenerFacturaReservaPorPosicion(posicion);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");

    }
    
}
