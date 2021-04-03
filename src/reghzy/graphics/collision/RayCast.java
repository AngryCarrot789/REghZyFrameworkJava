package reghzy.graphics.collision;

import reghzy.graphics.maths.Vector3;

public class RayCast {
    public Vector3 center;
    public Vector3 direction;

    private Vector3 directionFraction;

    /**
     * The length (or distance travelled) of the ray before it hit a bounding box (or 0 if it hit nothing)
     */
    public float lengthBeforeHit;

    public RayCast(Vector3 center, Vector3 direction) {
        this.center = center;
        this.direction = direction;
        this.lengthBeforeHit = 0.0f;

        directionFraction = new Vector3(1.0f / direction.x, 1.0f / direction.y, 1.0f / direction.z);
    }

    public boolean hits(AxisAlignedBB box) {
        float t1 = (box.minX - this.center.x) * directionFraction.x;
        float t2 = (box.maxX - this.center.x) * directionFraction.x;
        float t3 = (box.minY - this.center.y) * directionFraction.y;
        float t4 = (box.maxY - this.center.y) * directionFraction.y;
        float t5 = (box.minZ - this.center.z) * directionFraction.z;
        float t6 = (box.maxZ - this.center.z) * directionFraction.z;

        float tMin = Math.max(Math.max(Math.min(t1, t2), Math.min(t3, t4)), Math.min(t5, t6));
        float tMax = Math.min(Math.min(Math.max(t1, t2), Math.max(t3, t4)), Math.max(t5, t6));

        // if tMax < 0, ray (line) is intersecting AABB, but the whole AABB is behind us
        if (tMax < 0) {
            lengthBeforeHit = tMax;
            return false;
        }

        // if tMin > tMax, ray doesn't intersect AABB
        if (tMin > tMax) {
            lengthBeforeHit = tMax;
            return false;
        }

        lengthBeforeHit = tMin;
        return true;
    }
}
