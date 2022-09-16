package lab1;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;


class VectorTest {

    private Vector vectorA;
    private Vector vectorB;

    @Test
    void length() {
        vectorA = new Vector(1, 2, 3);
        assertEquals(3.7416573867739413, vectorA.length());

        vectorB = new Vector(-2, 7, 9);
        assertEquals(11.575836902790225, vectorB.length());

    }

    @Test
    void scalarProduct() {
        vectorA = new Vector(12, 36, 77);
        vectorB = new Vector(10, 7, 13);

        assertEquals(1373, vectorA.scalarProduct(vectorB));
    }

    @Test
    void vectorProduct() {
        vectorA = new Vector(89, 69, 7);
        vectorB = new Vector(1, 2, 3);

        Vector result = vectorA.vectorProduct(vectorB);
        assertEquals(193, result.getX());
        assertEquals(-260, result.getY());
        assertEquals(109, result.getZ());
    }

    @Test
    void cos() throws Exception {
        vectorA = new Vector(0, 0, 0);
        vectorB = new Vector(5, 5, 5);

        assertThrows(ArithmeticException.class, () -> vectorA.cos(vectorB));

        Vector vectorC = new Vector(2, 4, 5);
        Vector vectorD = new Vector(4, 7, 10);

        assertEquals(0.9980452274793343, vectorC.cos(vectorD));
    }

    @Test
    void cosToRadian() throws Exception {
        vectorA = new Vector(2, 4, 5);
        vectorB = new Vector(4, 7, 10);

        double degree = vectorA.cosToRadian(vectorA.cos(vectorB));
        assertEquals(3.5830800741464497, degree);
    }

    @Test
    void add() {
        vectorA = new Vector(19, 18, 17);
        vectorB = new Vector(-3, -2, -1);

        Vector result = vectorA.add(vectorB);
        assertEquals(16, result.getX());
        assertEquals(16, result.getY());
        assertEquals(16, result.getZ());
    }

    @Test
    void sub() {
        vectorA = new Vector(-1, 3, 6);
        vectorB = new Vector(-1, -2, -9);

        Vector result = vectorA.sub(vectorB);
        assertEquals(0, result.getX());
        assertEquals(5, result.getY());
        assertEquals(15, result.getZ());
    }

    @Test
    void generateRandomVectors() {
        int countVectors = 5;
        vectorA = new Vector();
        Vector[] vectors = vectorA.generateRandomVectors(countVectors);

        assertEquals(countVectors, vectors.length);
    }
}