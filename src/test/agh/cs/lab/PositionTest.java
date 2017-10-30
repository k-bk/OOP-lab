package agh.cs.lab;

import org.junit.Test;

import static org.junit.Assert.*;

public class PositionTest {
    @Test
    public void testSmaller() throws Exception {
        Position a = new Position(10,10);
        Position b = new Position(11,10);
        Position c = new Position(19,9);
        assertTrue(a.smaller(b));
        assertFalse(b.smaller(c));
    }

    @Test
    public void testLarger() throws Exception {
        Position a = new Position(-1,10);
        Position b = new Position(-1,10);
        Position c = new Position(19,9);
        assertTrue(a.larger(b));
        assertFalse(b.larger(c));
    }

    @Test
    public void testAdd() throws Exception {
        Position a = new Position(-1,10);
        Position b = new Position(-1,10);
        assertEquals(new Position(-2, 20), a.add(b));
    }

    @Test
    public void testToString() throws Exception {
        Position a = new Position(-1,10);
        assertEquals("(-1, 10)", a.toString());
    }

}