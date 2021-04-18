package reghzy.graphics.maths;

public class Vector2 {
    public float x;
    public float y;

    public static Vector2 One = new Vector2(1, 1);
    public static Vector2 Zero = new Vector2(0 ,0);
    public static Vector2 UnitX = new Vector2(1.0f, 0.0f);
    public static Vector2 UnitY = new Vector2(0.0f, 1.0f);

    public Vector2() { }

    public Vector2(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Vector2 set(float x, float y) {
        this.x = x;
        this.y = y;
        return this;
    }

    public float magnitudeSquared() {
        return x * x + y * y;
    }

    public float magnitude() {
        return (float) Math.sqrt(magnitudeSquared());
    }

    public Vector2 normalised() {
        float mag = magnitude();
        return new Vector2(this.x / mag, this.y / mag);
    }

    public boolean isUnit() {
        return x >= -1.0f && x <= 1.0f && y >= -1.0f && y <= 1.0f;
    }

    @Override
    protected Object clone() {
        return new Vector2(this.x, this.y);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Vector2)) {
            return false;
        }
        Vector2 vector2 = (Vector2) obj;
        return vector2.x == this.x && vector2.y == this.y;
    }

    @Override
    public String toString() {
        return "Vector2{" + this.x + "," + this.y + "}";
    }
}
