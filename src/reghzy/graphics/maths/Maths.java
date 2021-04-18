package reghzy.graphics.maths;

public class Maths {
    public static final float PI = 3.1415926535897931f;
    public static final float PI_NEGATIVE = -3.141592653589f;
    public static final float PI_DOUBLE = 6.283185307178f;
    public static final float PI_DOUBLE_NEGATIVE = -6.283185307178f;
    public static final float PI_HALF = 1.5707963267945f;
    public static final float PI_HALF_NEGATIVE = -1.5707963267945f;
    public static final float RADIAN_TO_DEGREES = 57.29577951309679f;
    public static final float DEGREES_TO_RADIANS = 0.017453292519943f;

    public static float clamp(float value, float min, float max) {
        if (value > max) return max;
        if (value < min) return min;
        return value;
    }

    public static float min3(float a, float b, float c) {
        return Math.min(Math.min(a, b), c);
    }

    public static float max3(float a, float b, float c) {
        return Math.max(Math.max(a, b), c);
    }

    public static Vector2 clamp(Vector2 value, float min, float max) {
        return new Vector2(clamp(value.x, min, max), clamp(value.y, min, max));
    }

    public static Vector3 clamp(Vector3 value, float min, float max) {
        return new Vector3(clamp(value.x, min, max), clamp(value.y, min, max), clamp(value.z, min, max));
    }

    public static Vector2 clampInstance(Vector2 instance, float min, float max) {
        instance.x = clamp(instance.x, min, max);
        instance.y = clamp(instance.y, min, max);
        return instance;
    }

    public static Vector3 clampInstance(Vector3 instance, float min, float max) {
        instance.x = clamp(instance.x, min, max);
        instance.y = clamp(instance.y, min, max);
        instance.z = clamp(instance.z, min, max);
        return instance;
    }

    public static float degreesToRadians(float degrees) {
        return degrees * DEGREES_TO_RADIANS;
    }

    public static float radiansToDegrees(float radians) {
        return radians * RADIAN_TO_DEGREES;
    }

    public static float distanceBetween(Vector3 a, Vector3 b) {
        return (float) Math.pow((float) Math.pow(b.x - a.x, 2) +
                                (float) Math.pow(b.y - a.y, 2) +
                                (float) Math.pow(b.z - a.z, 2), 0.5);
    }
}
