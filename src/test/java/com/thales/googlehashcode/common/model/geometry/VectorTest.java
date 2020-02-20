package com.thales.googlehashcode.common.model.geometry;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VectorTest {

    @Test
    public void vectorBasicOperations() {
        Vector vector = new Vector(1, -1);
        assertEquals(new Vector(3,0), vector.add(new Vector(2,1)));
        assertEquals(new Vector(-1, 1), vector.negate());
        assertEquals(new Vector(2,-2), vector.multiply(2));
        assertEquals(2, vector.lengthSquare(), 0.0001);
        assertEquals(Math.sqrt(2), vector.length(), 0.0001);
        assertEquals(new Vector(Math.sqrt(2)/2,-Math.sqrt(2)/2), vector.normalized());
        assertEquals(0, vector.dot(new Vector(5,5)), 0.0001);
        assertEquals(-45, vector.angleInDegree(), 0.0001);
        assertEquals(new Vector(1,1), vector.rotateInDegree(90));
        assertEquals(new Vector(0,0), new Vector(0,0).normalized());
    }
}
