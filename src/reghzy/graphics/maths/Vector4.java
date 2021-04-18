package reghzy.graphics.maths;

public class Vector4 {
    public float x;
    public float y;
    public float z;
    public float w;

    public Vector4() { }

    public Vector4(float x, float y, float z, float w) {
        set(x, y, z, w);
    }

    public void set(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void set(float x, float y, float z, float w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }

    public Vector3 homogenised() {
        return new Vector3(this.x / this.w, this.y / this.w, this.z / this.w);
    }

    public Vector3 xyz() {
        return new Vector3(this.x, this.y, this.z);
    }

    public boolean isUnit() {
        return x >= -1.0f && x <= 1.0f &&
               y >= -1.0f && y <= 1.0f &&
               z >= -1.0f && z <= 1.0f;
    }

    @Override
    protected Object clone() {
        return new Vector4(this.x, this.y, this.z, this.w);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Vector4)) {
            return false;
        }
        Vector4 v = (Vector4) obj;
        return this.x == v.x &&
               this.y == v.y &&
               this.z == v.z &&
               this.w == v.w;
    }

    @Override
    public String toString() {
        return "Vector4{" + this.x + "," + this.y + "," + this.z + "," + this.z + "}";
    }
}
