package lab1;

public class Vector {
    private double x, y, z;

    public Vector() {
    }

    public Vector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public double length() {
        return Math.sqrt(x * x + y * y + z * z);
    }

    public double scalarProduct(Vector vec) {
        return x * vec.x + y * vec.y + z * vec.z;
    }

    public Vector vectorProduct(Vector vec) {
        double newX = y * vec.z - z * vec.y;
        double newY = z * vec.x - x * vec.z;
        double newZ = x * vec.y - y * vec.x;
        return new Vector(newX, newY, newZ);
    }

    public double cos(Vector vec) throws Exception {
        double denominator = length() * vec.length();
        if (denominator == 0) {
            throw new ArithmeticException("Division by zero");
        } else {
            return scalarProduct(vec) / denominator;
        }
    }

    public double cosToRadian(double cos) {
        double angleA = Math.acos(cos);
        return angleA * 180.0d / Math.PI;
    }

    public Vector add(Vector vec) {
        double newX = x + vec.x;
        double newY = y + vec.y;
        double newZ = z + vec.z;
        return new Vector(newX, newY, newZ);
    }

    public Vector sub(Vector vec) {
        double newX = x - vec.x;
        double newY = y - vec.y;
        double newZ = z - vec.z;
        return new Vector(newX, newY, newZ);
    }

    public static Vector[] generateRandomVectors(int n) {
        Vector[] randomVectors = new Vector[n];
        for (int i = 0; i < n; i++) {
            randomVectors[i] = new Vector(Math.random(), Math.random(), Math.random());
        }
        return randomVectors;
    }

    @Override
    public String toString() {
        return "Vector{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }
}
