package reghzy.graphics.maths;

import java.util.Arrays;

public class Matrix4 {
    // A row is a list of items going left to right
    // A column is a list of items going top to bottom
    // this matrix is row-column
    public float[] m;

    public Matrix4() {
        m = new float[16];
    }

    public Matrix4(float[] m) {
        this.m = m;
    }

    public void makeIdentity() {
        m[0]  = 1.0f; m[1]  = 0.0f; m[2]  = 0.0f; m[3]  = 0.0f;
        m[4]  = 0.0f; m[5]  = 1.0f; m[6]  = 0.0f; m[7]  = 0.0f;
        m[8]  = 0.0f; m[9]  = 0.0f; m[10] = 1.0f; m[11] = 0.0f;
        m[12] = 0.0f; m[13] = 0.0f; m[14] = 0.0f; m[15] = 1.0f;
    }

    public void makeRotationX(float r) {
        float cosR = (float) Math.cos(r);
        float sinR = (float) Math.sin(r);
        m[0]  = 1.0f; m[1]  = 0.0f; m[2]  = 0.0f;  m[3]  = 0.0f;
        m[4]  = 0.0f; m[5]  = cosR; m[6]  = -sinR; m[7]  = 0.0f;
        m[8]  = 0.0f; m[9]  = sinR; m[10] = cosR;  m[11] = 0.0f;
        m[12] = 0.0f; m[13] = 0.0f; m[14] = 0.0f;  m[15] = 1.0f;
    }

    public void makeRotationY(float r) {
        float cosR = (float) Math.cos(r);
        float sinR = (float) Math.sin(r);
        m[0]  = cosR;  m[1]  = 0.0f; m[2]  = sinR; m[3]  = 0.0f;
        m[4]  = 0.0f;  m[5]  = 1.0f; m[6]  = 0.0f; m[7]  = 0.0f;
        m[8]  = -sinR; m[9]  = 0.0f; m[10] = cosR; m[11] = 0.0f;
        m[12] = 0.0f;  m[13] = 0.0f; m[14] = 0.0f; m[15] = 1.0f;
    }

    public void makeRotationZ(float r) {
        float cosR = (float) Math.cos(r);
        float sinR = (float) Math.sin(r);
        m[0]  = cosR; m[1]  = -sinR; m[2]  = 0.0f; m[3]  = 0.0f;
        m[4]  = sinR; m[5]  = cosR;  m[6]  = 0.0f; m[7]  = 0.0f;
        m[8]  = 0.0f; m[9]  = 0.0f;  m[10] = 1.0f; m[11] = 0.0f;
        m[12] = 0.0f; m[13] = 0.0f;  m[14] = 0.0f; m[15] = 1.0f;
    }

    public void makeTranslation(Vector3 v) {
        m[0]  = 1.0f; m[1]  = 0.0f; m[2]  = 0.0f; m[3]  = v.x;
        m[4]  = 0.0f; m[5]  = 1.0f; m[6]  = 0.0f; m[7]  = v.y;
        m[8]  = 0.0f; m[9]  = 0.0f; m[10] = 1.0f; m[11] = v.z;
        m[12] = 0.0f; m[13] = 0.0f; m[14] = 0.0f; m[15] = 1.0f;
    }

    public void makeTranslation(float x, float y, float z) {
        m[0]  = 1.0f; m[1]  = 0.0f; m[2]  = 0.0f; m[3]  = x;
        m[4]  = 0.0f; m[5]  = 1.0f; m[6]  = 0.0f; m[7]  = y;
        m[8]  = 0.0f; m[9]  = 0.0f; m[10] = 1.0f; m[11] = z;
        m[12] = 0.0f; m[13] = 0.0f; m[14] = 0.0f; m[15] = 1.0f;
    }

    public void makeScale(Vector3 v) {
        m[0]  = v.x;  m[1]  = 0.0f; m[2]  = 0.0f; m[3]  = 0.0f;
        m[4]  = 0.0f; m[5]  = v.y;  m[6]  = 0.0f; m[7]  = 0.0f;
        m[8]  = 0.0f; m[9]  = 0.0f; m[10] = v.z;  m[11] = 0.0f;
        m[12] = 0.0f; m[13] = 0.0f; m[14] = 0.0f; m[15] = 1.0f;
    }

    public void makeScale(float x, float y, float z) {
        m[0]  = x;    m[1]  = 0.0f; m[2]  = 0.0f; m[3]  = 0.0f;
        m[4]  = 0.0f; m[5]  = y;    m[6]  = 0.0f; m[7]  = 0.0f;
        m[8]  = 0.0f; m[9]  = 0.0f; m[10] = z;    m[11] = 0.0f;
        m[12] = 0.0f; m[13] = 0.0f; m[14] = 0.0f; m[15] = 1.0f;
    }

    public Matrix4 transposed() {
        Matrix4 n = new Matrix4();
        n.m[0]  = m[0]; n.m[1]  = m[4]; n.m[2]  = m[8];  n.m[3]  = m[12];
        n.m[4]  = m[1]; n.m[5]  = m[5]; n.m[6]  = m[9];  n.m[7]  = m[13];
        n.m[8]  = m[2]; n.m[9]  = m[6]; n.m[10] = m[10]; n.m[11] = m[14];
        n.m[12] = m[3]; n.m[13] = m[7]; n.m[14] = m[11]; n.m[15] = m[15];
        return n;
    }

    /**
     * Gets a vector which contains the value of the matrix going left to right at the given column index
     * (which is the offset index where 0 is the top of the matrix if imagined as a 4x4 grid. 0 for the top, 3 for the bottom)
     */
    public Vector4 getRow(int column) {
        int offset = column * 4;
        return new Vector4(m[offset], m[offset + 1], m[offset + 2], m[offset + 3]);
    }

    /**
     * Gets a vector which contains the values of the matrix going from top to bottom at the given row offset
     * (which is the offset index where 0 is the left of the matrix, 3 is the very right.
     * @param row
     * @return
     */
    public Vector4 getColumn(int row) {
        return new Vector4(m[row], m[row + 4], m[row + 8], m[row + 12]);
    }

    /**
     * Returns the value in the 4x4 matrix at the given row and column index
     * @param row the value that goes across
     * @param column the value that goes down
     * @return
     */
    public float getAt(int row, int column) {
        return m[(column * 4) + row];
    }

    public static Matrix4 inverse(Matrix4 m) {
        Matrix4 inv = new Matrix4();
        inv.m[0] = m.m[5] * m.m[10] * m.m[15] -
                   m.m[5] * m.m[11] * m.m[14] -
                   m.m[9] * m.m[6] * m.m[15] +
                   m.m[9] * m.m[7] * m.m[14] +
                   m.m[13] * m.m[6] * m.m[11] -
                   m.m[13] * m.m[7] * m.m[10];

        inv.m[4] = -m.m[4] * m.m[10] * m.m[15] +
                   m.m[4] * m.m[11] * m.m[14] +
                   m.m[8] * m.m[6] * m.m[15] -
                   m.m[8] * m.m[7] * m.m[14] -
                   m.m[12] * m.m[6] * m.m[11] +
                   m.m[12] * m.m[7] * m.m[10];

        inv.m[8] = m.m[4] * m.m[9] * m.m[15] -
                   m.m[4] * m.m[11] * m.m[13] -
                   m.m[8] * m.m[5] * m.m[15] +
                   m.m[8] * m.m[7] * m.m[13] +
                   m.m[12] * m.m[5] * m.m[11] -
                   m.m[12] * m.m[7] * m.m[9];

        inv.m[12] = -m.m[4] * m.m[9] * m.m[14] +
                    m.m[4] * m.m[10] * m.m[13] +
                    m.m[8] * m.m[5] * m.m[14] -
                    m.m[8] * m.m[6] * m.m[13] -
                    m.m[12] * m.m[5] * m.m[10] +
                    m.m[12] * m.m[6] * m.m[9];

        inv.m[1] = -m.m[1] * m.m[10] * m.m[15] +
                   m.m[1] * m.m[11] * m.m[14] +
                   m.m[9] * m.m[2] * m.m[15] -
                   m.m[9] * m.m[3] * m.m[14] -
                   m.m[13] * m.m[2] * m.m[11] +
                   m.m[13] * m.m[3] * m.m[10];

        inv.m[5] = m.m[0] * m.m[10] * m.m[15] -
                   m.m[0] * m.m[11] * m.m[14] -
                   m.m[8] * m.m[2] * m.m[15] +
                   m.m[8] * m.m[3] * m.m[14] +
                   m.m[12] * m.m[2] * m.m[11] -
                   m.m[12] * m.m[3] * m.m[10];

        inv.m[9] = -m.m[0] * m.m[9] * m.m[15] +
                   m.m[0] * m.m[11] * m.m[13] +
                   m.m[8] * m.m[1] * m.m[15] -
                   m.m[8] * m.m[3] * m.m[13] -
                   m.m[12] * m.m[1] * m.m[11] +
                   m.m[12] * m.m[3] * m.m[9];

        inv.m[13] = m.m[0] * m.m[9] * m.m[14] -
                    m.m[0] * m.m[10] * m.m[13] -
                    m.m[8] * m.m[1] * m.m[14] +
                    m.m[8] * m.m[2] * m.m[13] +
                    m.m[12] * m.m[1] * m.m[10] -
                    m.m[12] * m.m[2] * m.m[9];

        inv.m[2] = m.m[1] * m.m[6] * m.m[15] -
                   m.m[1] * m.m[7] * m.m[14] -
                   m.m[5] * m.m[2] * m.m[15] +
                   m.m[5] * m.m[3] * m.m[14] +
                   m.m[13] * m.m[2] * m.m[7] -
                   m.m[13] * m.m[3] * m.m[6];

        inv.m[6] = -m.m[0] * m.m[6] * m.m[15] +
                   m.m[0] * m.m[7] * m.m[14] +
                   m.m[4] * m.m[2] * m.m[15] -
                   m.m[4] * m.m[3] * m.m[14] -
                   m.m[12] * m.m[2] * m.m[7] +
                   m.m[12] * m.m[3] * m.m[6];

        inv.m[10] = m.m[0] * m.m[5] * m.m[15] -
                    m.m[0] * m.m[7] * m.m[13] -
                    m.m[4] * m.m[1] * m.m[15] +
                    m.m[4] * m.m[3] * m.m[13] +
                    m.m[12] * m.m[1] * m.m[7] -
                    m.m[12] * m.m[3] * m.m[5];

        inv.m[14] = -m.m[0] * m.m[5] * m.m[14] +
                    m.m[0] * m.m[6] * m.m[13] +
                    m.m[4] * m.m[1] * m.m[14] -
                    m.m[4] * m.m[2] * m.m[13] -
                    m.m[12] * m.m[1] * m.m[6] +
                    m.m[12] * m.m[2] * m.m[5];

        inv.m[3] = -m.m[1] * m.m[6] * m.m[11] +
                   m.m[1] * m.m[7] * m.m[10] +
                   m.m[5] * m.m[2] * m.m[11] -
                   m.m[5] * m.m[3] * m.m[10] -
                   m.m[9] * m.m[2] * m.m[7] +
                   m.m[9] * m.m[3] * m.m[6];

        inv.m[7] = m.m[0] * m.m[6] * m.m[11] -
                   m.m[0] * m.m[7] * m.m[10] -
                   m.m[4] * m.m[2] * m.m[11] +
                   m.m[4] * m.m[3] * m.m[10] +
                   m.m[8] * m.m[2] * m.m[7] -
                   m.m[8] * m.m[3] * m.m[6];

        inv.m[11] = -m.m[0] * m.m[5] * m.m[11] +
                    m.m[0] * m.m[7] * m.m[9] +
                    m.m[4] * m.m[1] * m.m[11] -
                    m.m[4] * m.m[3] * m.m[9] -
                    m.m[8] * m.m[1] * m.m[7] +
                    m.m[8] * m.m[3] * m.m[5];

        inv.m[15] = m.m[0] * m.m[5] * m.m[10] -
                    m.m[0] * m.m[6] * m.m[9] -
                    m.m[4] * m.m[1] * m.m[10] +
                    m.m[4] * m.m[2] * m.m[9] +
                    m.m[8] * m.m[1] * m.m[6] -
                    m.m[8] * m.m[2] * m.m[5];

        float det = m.m[0] * inv.m[0] + m.m[1] * inv.m[4] + m.m[2] * inv.m[8] + m.m[3] * inv.m[12];
        inv = Matrix4.divide(inv, det);
        return inv;
    }

    public static Matrix4 Zero() {
        return new Matrix4();
    }

    public static Matrix4 Identity() {
        Matrix4 matrix4 = new Matrix4();
        matrix4.makeIdentity();
        return matrix4;
    }

    public static Matrix4 RotationX(float r) {
        Matrix4 matrix4 = new Matrix4();
        matrix4.makeRotationX(r);
        return matrix4;
    }

    public static Matrix4 RotationY(float r) {
        Matrix4 matrix4 = new Matrix4();
        matrix4.makeRotationY(r);
        return matrix4;
    }

    public static Matrix4 RotationZ(float r) {
        Matrix4 matrix4 = new Matrix4();
        matrix4.makeRotationZ(r);
        return matrix4;
    }

    public static Matrix4 Translation(Vector3 v) {
        Matrix4 matrix4 = new Matrix4();
        matrix4.makeTranslation(v);
        return matrix4;
    }

    public static Matrix4 Translation(float x, float y, float z) {
        Matrix4 matrix4 = new Matrix4();
        matrix4.makeTranslation(x, y, z);
        return matrix4;
    }

    public static Matrix4 Scale(Vector3 v) {
        Matrix4 matrix4 = new Matrix4();
        matrix4.makeScale(v);
        return matrix4;
    }

    public static Matrix4 Scale(float x, float y, float z) {
        Matrix4 matrix4 = new Matrix4();
        matrix4.makeScale(x, y, z);
        return matrix4;
    }

    public static Matrix4 multiply(Matrix4 a, Matrix4 b) {
        Matrix4 m = new Matrix4();
        m.m[0]  = b.m[0] * a.m[0]  + b.m[4] * a.m[1]  + b.m[8]  * a.m[2]  + b.m[12] * a.m[3];
        m.m[1]  = b.m[1] * a.m[0]  + b.m[5] * a.m[1]  + b.m[9]  * a.m[2]  + b.m[13] * a.m[3];
        m.m[2]  = b.m[2] * a.m[0]  + b.m[6] * a.m[1]  + b.m[10] * a.m[2]  + b.m[14] * a.m[3];
        m.m[3]  = b.m[3] * a.m[0]  + b.m[7] * a.m[1]  + b.m[11] * a.m[2]  + b.m[15] * a.m[3];
        m.m[4]  = b.m[0] * a.m[4]  + b.m[4] * a.m[5]  + b.m[8]  * a.m[6]  + b.m[12] * a.m[7];
        m.m[5]  = b.m[1] * a.m[4]  + b.m[5] * a.m[5]  + b.m[9]  * a.m[6]  + b.m[13] * a.m[7];
        m.m[6]  = b.m[2] * a.m[4]  + b.m[6] * a.m[5]  + b.m[10] * a.m[6]  + b.m[14] * a.m[7];
        m.m[7]  = b.m[3] * a.m[4]  + b.m[7] * a.m[5]  + b.m[11] * a.m[6]  + b.m[15] * a.m[7];
        m.m[8]  = b.m[0] * a.m[8]  + b.m[4] * a.m[9]  + b.m[8]  * a.m[10] + b.m[12] * a.m[11];
        m.m[9]  = b.m[1] * a.m[8]  + b.m[5] * a.m[9]  + b.m[9]  * a.m[10] + b.m[13] * a.m[11];
        m.m[10] = b.m[2] * a.m[8]  + b.m[6] * a.m[9]  + b.m[10] * a.m[10] + b.m[14] * a.m[11];
        m.m[11] = b.m[3] * a.m[8]  + b.m[7] * a.m[9]  + b.m[11] * a.m[10] + b.m[15] * a.m[11];
        m.m[12] = b.m[0] * a.m[12] + b.m[4] * a.m[13] + b.m[8]  * a.m[14] + b.m[12] * a.m[15];
        m.m[13] = b.m[1] * a.m[12] + b.m[5] * a.m[13] + b.m[9]  * a.m[14] + b.m[13] * a.m[15];
        m.m[14] = b.m[2] * a.m[12] + b.m[6] * a.m[13] + b.m[10] * a.m[14] + b.m[14] * a.m[15];
        m.m[15] = b.m[3] * a.m[12] + b.m[7] * a.m[13] + b.m[11] * a.m[14] + b.m[15] * a.m[15];
        return m;
    }

    public static Vector4 multiply(Matrix4 m, Vector4 v) {
        return new Vector4(m.m[0] * v.x + m.m[1] * v.y + m.m[2] * v.z + m.m[3] * v.w,
                           m.m[4]  * v.x + m.m[5]  * v.y + m.m[6]  * v.z + m.m[7]  * v.w,
                           m.m[8]  * v.x + m.m[9]  * v.y + m.m[10] * v.z + m.m[11] * v.w,
                           m.m[12] * v.x + m.m[13] * v.y + m.m[14] * v.z + m.m[15] * v.w);
    }

    public static Matrix4 divide(Matrix4 m, float a) {
        Matrix4 n = new Matrix4();
        for (int i = 0; i < 16; i++) {
            n.m[i] = m.m[i] / a;
        }
        return n;
    }

    public static Matrix4 worldToLocal(Vector3 position, Vector3 rotation, Vector3 scale) {
        Matrix4 a = Matrix4.Scale(1.0f / scale.x, 1.0f / scale.y, 1.0f / scale.z);
        Matrix4 b = Matrix4.RotationZ(-rotation.z);
        Matrix4 c = Matrix4.RotationX(-rotation.x);
        Matrix4 d = Matrix4.RotationY(-rotation.y);
        Matrix4 e = Matrix4.Translation(-position.x, -position.y, -position.z);
        return Matrix4.multiply(Matrix4.multiply(Matrix4.multiply(Matrix4.multiply(a, b), c), d), e);
    }

    public static Matrix4 localToWorld(Vector3 position, Vector3 rotation, Vector3 scale) {
        Matrix4 a = Matrix4.Translation(position);
        Matrix4 b = Matrix4.RotationY(rotation.y);
        Matrix4 c = Matrix4.RotationX(rotation.x);
        Matrix4 d = Matrix4.RotationZ(rotation.z);
        Matrix4 e = Matrix4.Scale(scale);
        return Matrix4.multiply(Matrix4.multiply(Matrix4.multiply(Matrix4.multiply(a, b), c), d), e);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Matrix4))
            return false;

        Matrix4 matrix4 = (Matrix4) obj;
        return Arrays.equals(matrix4.m, this.m);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(this.m);
    }

    @Override
    public String toString() {
        StringBuilder sb= new StringBuilder(128);
        sb.append("Matrix4{");
        for(int i = 0; i < 16; i++) {
            sb.append(this.m[i]).append(',');
        }
        sb.append("}");
        return sb.toString();
    }
}
