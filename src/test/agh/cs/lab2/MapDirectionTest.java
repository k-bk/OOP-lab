package agh.cs.lab2;

import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

public class MapDirectionTest {

    private MapDirection dir = MapDirection.East;

    @Test
    public void testNext() throws Exception {
        assertEquals(MapDirection.South, dir.next());
    }

    @Test
    public void testPrevious() throws Exception {
        assertEquals(MapDirection.North, dir.previous());
    }

    @Test
    public void testToString() throws Exception {
        assertEquals("Wschód", dir.toString());
    }

}