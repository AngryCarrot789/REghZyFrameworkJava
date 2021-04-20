package reghzy.graphics.maths;

public class Vector3 {
    public float x;
    public float y;
    public float z;

    public Vector3() { }

    public Vector3(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }


    /**
     * returns the squared magnitude of the x, y and z values
     */
    public float magnitudeSquared() {
        return x * x + y * y + z * z;
    }

    /**
     * returns the magnitude of the x, y and z values
     */
    public float magnitude() {
        return (float) Math.sqrt(magnitudeSquared());
    }

    /**
     * returns a normalised copy of this vector, where the x, y and z values are never smaller than 0 or bigger than 1
     */
    public Vector3 normalised() {
        float mag = magnitude();
        if (mag == 0)
            return new Vector3(0, 0, 0);
        return new Vector3(this.x / mag, this.y / mag, this.z / mag);
    }

    /**
     * returns the dot produce between this vector and another vector's value
     */
    public float dot(Vector3 v) {
        return (this.x * v.x) +
               (this.y * v.y) +
               (this.z * v.z);
    }

    /**
     * returns a new vector which is the cross product of this vector and another vector's values
     */
    public Vector3 cross(Vector3 v) {
        return new Vector3(
                (this.y * v.z) - (this.z * this.y),
                (this.z * v.x) - (this.x * this.z),
                (this.x * v.y) - (this.y * this.x));
    }

    /**
     * returns the angle between this vector and another vector
     */
    public float angle(Vector3 v) {
        return (float) Math.acos(this.normalised().dot(v));
    }

    public Vector3 multiply(Vector3 v) {
        return multiply(v.x, v.y, v.z);
    }

    public Vector3 multiply(float a) {
        return multiply(a, a, a);
    }

    public Vector3 multiply(float x, float y, float z) {
        this.x *= x;
        this.y *= y;
        this.z *= z;
        return this;
    }

    public Vector3 divide(Vector3 v) {
        return divide(v.x, v.y, v.z);
    }

    public Vector3 divide(float a) {
        return divide(a, a, a);
    }

    public Vector3 divide(float x, float y, float z) {
        this.x /= x;
        this.y /= y;
        this.z /= z;
        return this;
    }

    public Vector3 add(Vector3 v) {
        return add(v.x, v.y, v.z);
    }

    public Vector3 add(float a) {
        return add(a, a, a);
    }

    public Vector3 add(float x, float y, float z) {
        this.x += x;
        this.y += y;
        this.z += z;
        return this;
    }

    public Vector3 subtract(float a) {
        return subtract(a, a, a);
    }

    public Vector3 subtract(Vector3 v) {
        return subtract(v.x, v.y, v.z);
    }

    public Vector3 subtract(float x, float y, float z) {
        this.x -= x;
        this.y -= y;
        this.z -= z;
        return this;
    }

    public static Vector3 directionFromDegrees(float x, float y, float z) {
        return new Vector3(Maths.degreesToRadians(x), Maths.degreesToRadians(y), Maths.degreesToRadians(z));
    }

    public Vector3 copy() {
        return new Vector3(this.x, this.y, this.z);
    }
}
