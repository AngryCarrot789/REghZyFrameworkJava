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

    public Vector3 multiply(float x, float y, float z) {
        this.x *= x;
        this.y *= y;
        this.z *= z;
        return this;
    }

    public Vector3 divide(float x, float y, float z) {
        this.x /= x;
        this.y /= y;
        this.z /= z;
        return this;
    }

    public Vector3 add(float x, float y, float z) {
        this.x += x;
        this.y += y;
        this.z += z;
        return this;
    }

    public Vector3 subtract(float x, float y, float z) {
        this.x -= x;
        this.y -= y;
        this.z -= z;
        return this;
    }

    public Vector3 multiply(Vector3 v) {
        return multiply(v.x, v.y, v.z);
    }

    public Vector3 divide(Vector3 v) {
        return divide(v.x, v.y, v.z);
    }

    public Vector3 add(Vector3 v) {
        return add(v.x, v.y, v.z);
    }

    public Vector3 subtract(Vector3 v) {
        return subtract(v.x, v.y, v.z);
    }

    public static Vector3 directionFromDegrees(float x, float y, float z) {
        return new Vector3(Maths.degreesToRadians(x), Maths.degreesToRadians(y), Maths.degreesToRadians(z));
    }

    public Vector3 copy() {
        return new Vector3(this.x, this.y, this.z);
    }
}
