import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import kotlin.ArithmeticException

internal class VectorTest {

    @Test
    fun length() {
        val expectedLength = 3.7416573867739413
        assertEquals(expectedLength, Vector(1.0, 2.0, 3.0).length())
    }

    @Test
    fun scalarProduct() {
        val expectedScalarProduct = 1373.0
        val a = Vector(12.0, 36.0, 77.0)
        val b = Vector(10.0, 7.0, 13.0)
        assertEquals(expectedScalarProduct, a.scalarProduct(b))
    }

    @Test
    fun vectorProduct() {
        val expectedVector = Vector(193.0, -260.0, 109.0)
        val a = Vector(89.0, 69.0, 7.0)
        val b = Vector(1.0, 2.0, 3.0)
        val result = a.vectorProduct(b)
        assertEquals(expectedVector.x, result.x)
        assertEquals(expectedVector.y, result.y)
        assertEquals(expectedVector.z, result.z)
    }

    @Test()
    fun cos() {
        val a = Vector(0.0, 0.0, 0.0)
        val b = Vector(5.0, 5.0, 5.0)
        assertThrows(ArithmeticException::class.java) {
            a.cos(b)
        }

        val expectedCos = 0.9980452274793343
        val c = Vector(2.0, 4.0, 5.0)
        val d = Vector(4.0, 7.0, 10.0)
        assertEquals(expectedCos, c.cos(d))
    }

    @Test
    fun cosToRadian() {
        val expectedDegree = 3.5830800741464497
        val a = Vector(2.0, 4.0, 5.0)
        val b = Vector(4.0, 7.0, 10.0)
        val degree = a.cosToRadian(a.cos(b))
        assertEquals(expectedDegree, degree)
    }

    @Test
    fun add() {
        val expectedValue = 16.0
        val a = Vector(19.0, 18.0, 17.0)
        val b = Vector(-3.0, -2.0, -1.0)
        val result = a.add(b)
        assertEquals(expectedValue, result.x)
        assertEquals(expectedValue, result.y)
        assertEquals(expectedValue, result.z)
    }

    @Test
    fun sub() {
        val expectedX = 0.0
        val expectedY = 5.0
        val expectedZ = 15.0
        val a = Vector(-1.0, 3.0, 6.0);
        val b = Vector(-1.0, -2.0, -9.0);
        val result = a.sub(b)
        assertEquals(expectedX, result.x)
        assertEquals(expectedY, result.y)
        assertEquals(expectedZ, result.z)
    }

    @Test
    fun generateRandomVectors() {
        val vectorsCount = 5
        val vector = Vector
        val generateRandomVectors = vector.generateRandomVectors(5)
        assertEquals(vectorsCount, generateRandomVectors.size)
    }
}