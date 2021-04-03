package reghzy.graphics.collision;

import reghzy.graphics.maths.Vector3;

public class AxisAlignedBB {
    public float minX;
    public float minY;
    public float minZ;
    public float maxX;
    public float maxY;
    public float maxZ;

    public AxisAlignedBB() { }

    public AxisAlignedBB(float minX, float minY, float minZ, float maxX, float maxY, float maxZ) {
        this.minX = minX;
        this.minY = minY;
        this.minZ = minZ;
        this.maxX = maxX;
        this.maxY = maxY;
        this.maxZ = maxZ;
    }

    public AxisAlignedBB(Vector3 center, Vector3 scale) {
        reposition(center, scale);
    }

    public Vector3 getMin() {
        return new Vector3(this.minX, this.minY, this.minZ);
    }

    public Vector3 getMax() {
        return new Vector3(this.maxX, this.maxY, this.maxZ);
    }

    public Vector3 getSize() {
        return new Vector3(getSizeX(), getSizeY(), getSizeZ());
    }

    public Vector3 getScale() {
        return new Vector3(getSizeX() / 2, getSizeY() / 2, getSizeZ() / 2);
    }

    public Vector3 getCenter() {
        return getMin().add(getScale());
    }

    public float getSizeX() {
        return maxX - minX;
    }

    public float getSizeY() {
        return maxY - minY;
    }

    public float getSizeZ() {
        return maxZ - minZ;
    }

    public void setMin(float x, float y, float z) {
        this.minX = x;
        this.minY = y;
        this.minZ = z;
    }

    public void setMax(float x, float y, float z) {
        this.maxX = x;
        this.maxY = y;
        this.maxZ = z;
    }

    public void setMin(Vector3 v) {
        this.minX = v.x;
        this.minY = v.y;
        this.minZ = v.z;
    }

    public void setMax(Vector3 v) {
        this.maxX = v.x;
        this.maxY = v.y;
        this.maxZ = v.z;
    }

    /**
     * Sets the minimums and maximums of this AABB instance using the given center, and scale
     * @param center
     * @param scale
     */
    public void reposition(Vector3 center, Vector3 scale) {
        this.minX = center.x - scale.x;
        this.minY = center.y - scale.y;
        this.minZ = center.z - scale.z;
        this.maxX = center.x + scale.x;
        this.maxY = center.y + scale.y;
        this.maxZ = center.z + scale.z;
    }

    /**
     * Uses the scale of this AABB instance and repositions the minimums
     * and maximums using that scale and the given center
     * @param center
     */
    public void repositionFromCenter(Vector3 center) {
        Vector3 scale = getScale();
        reposition(center, scale);
    }

    /**
     * Resizes this AABB instance using the center of this AABB and the given scale
     * @param scale
     */
    public void resizeFromScale(Vector3 scale) {
        Vector3 center = getCenter();
        reposition(center, scale);
    }

    /**
     * Returns the amount that this AABB instance intersects the given AABB
     * <p>
     *     Returns a positive number if an intersection
     * </p>
     * @param box
     * @return
     */
    public float getIntersectAmountX(AxisAlignedBB box) {
        float size = box.getSizeX();
        float scale = size / 2;
        float center = box.maxX - scale;
        if (this.maxX < center) {
            return this.maxX - box.minX;
        }
        else {
            return box.maxX - this.maxX;
        }
    }

    public float getIntersectAmountY(AxisAlignedBB box) {
        float size = box.getSizeY();
        float scale = size / 2;
        float center = box.maxY - scale;
        if (this.maxY < center) {
            return this.maxY - box.minY;
        }
        else {
            return box.maxY - this.maxY;
        }
    }

    public float getIntersectAmountZ(AxisAlignedBB box) {
        float size = box.getSizeZ();
        float scale = size / 2;
        float center = box.maxZ - scale;
        if (this.maxZ < center) {
            return this.maxZ - box.minZ;
        }
        else {
            return box.maxZ - this.maxZ;
        }
    }

    public boolean intersectsVector(Vector3 v) {
        return intersectsPointX(v.x) &&
               intersectsPointY(v.z) &&
               intersectsPointZ(v.z);
    }

    public boolean intersectsAABB(AxisAlignedBB box) {
        return intersectsAABBX(box) &&
               intersectsAABBY(box) &&
               intersectsAABBZ(box);
    }

    public boolean intersectsAABBX(AxisAlignedBB box) {
        return intersectsRangeX(box.minX, box.maxX);
    }

    public boolean intersectsAABBY(AxisAlignedBB box) {
        return intersectsRangeY(box.minY, box.maxY);
    }

    public boolean intersectsAABBZ(AxisAlignedBB box) {
        return intersectsRangeZ(box.minZ, box.maxZ);
    }

    public boolean intersectsRangeX(float min, float max) {
        return (this.maxX > min) && (this.minX < max);
    }

    public boolean intersectsRangeY(float min, float max) {
        return (this.maxY > min) && (this.minY < max);
    }

    public boolean intersectsRangeZ(float min, float max) {
        return (this.maxZ > min) && (this.minZ < max);
    }

    public boolean intersectsPointX(float x) {
        return (this.maxX > x) && (this.minX < x);
    }

    public boolean intersectsPointY(float y) {
        return (this.maxY > y) && (this.minY < y);
    }

    public boolean intersectsPointZ(float z) {
        return (this.maxZ > z) && (this.minZ < z);
    }

    public AxisAlignedBB copy() {
        return new AxisAlignedBB(this.minX, this.minY, this.minZ, this.maxX, this.maxY, this.maxZ);
    }
}
