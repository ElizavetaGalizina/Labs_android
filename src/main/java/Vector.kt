import kotlin.math.*
import kotlin.random.Random

class Vector {
    var x: Double
    var y: Double
    var z: Double

    constructor(x: Double, y: Double, z: Double) {
        this.x = x
        this.y = y
        this.z = z
    }

    fun length(): Double {
        return sqrt(x * x + y * y + z * z)
    }

    fun scalarProduct(vector: Vector): Double {
        return x * vector.x + y * vector.y + z * vector.z
    }

    fun vectorProduct(vector: Vector): Vector {
        val newX: Double = y * vector.z - z * vector.y;
        val newY: Double = z * vector.x - x * vector.z;
        val newZ: Double = x * vector.y - y * vector.x;
        return Vector(newX, newY, newZ)
    }

    fun cos(vector: Vector): Double {
        val denominator = length() * vector.length()
        if (denominator == 0.0) {
            return throw ArithmeticException("Divide by zero");
        } else {
            return scalarProduct(vector) / denominator;
        }
    }

    fun cosToRadian(cos: Double): Double {
        return (acos(cos) * 180.0) / PI
    }

    fun add(vector: Vector): Vector {
        val newX = x + vector.x
        val newY = y + vector.y
        val newZ = z + vector.z
        return Vector(newX, newY, newZ)
    }

    fun sub(vector: Vector): Vector {
        val newX = x - vector.x
        val newY = y - vector.y
        val newZ = z - vector.z
        return Vector(newX, newY, newZ)
    }

    companion object {
        fun generateRandomVectors(count: Int): MutableList<Vector> {
            val vectors = mutableListOf<Vector>()
            for (i in 1..count) {
                vectors.add(
                    Vector(
                        Random.nextDouble(0.0, 10.0),
                        Random.nextDouble(0.0, 10.0),
                        Random.nextDouble(0.0, 10.0)
                    )
                )
            }
            return vectors
        }
    }

    override fun toString(): String {
        return "Vector(x=$x, y=$y, z=$z)"
    }
}