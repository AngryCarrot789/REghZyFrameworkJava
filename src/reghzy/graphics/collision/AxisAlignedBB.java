package reghzy.graphics.collision;

import reghzy.graphics.maths.Vector3;

/**
 * <h2>
 *     Axis Aligned Bounding Box
 * </h2>
 * <p>
 *     <h3>
 *         An AABB is a box that contains X, Y and Z coordinates for both the "minimum" and "maximum",
 *     </h3>
 *     <p>
 *         If you imagine standing in the center of a cube/box/AABB looking forward (0,0,0),
 *         with a negative Z forward, positive X right and positive Y up coordinate system (right hand)
 *     </p>
 *     <p>
 *         <b>
 *             the minimum is the bottom left back
 *         </b>
 *     </p>
 *     <p>
 *         <b>
 *             the maximum is the top right front
 *         </b>
 *     </p>
 * </p>
 * <p>
 *     An AABB cannot be rotated due to the math behind it and the name:
 *     Axis aligned; aligned with the axis. no rotation
 * </p>
 */
public class AxisAlignedBB {
    /**
     * The minimum coordinate on the X axis. Standing in the center of the AABB looking forward, this is the on the left
     */
    public float minX;
    /**
     * The minimum coordinate on the Y axis. Standing in the center of the AABB looking forward, this is the on the bottom
     */
    public float minY;
    /**
     * The minimum coordinate on the Y axis. Standing in the center of the AABB looking forward, this is behind
     */
    public float minZ;
    /**
     * The minimum coordinate on the X axis. Standing in the center of the AABB looking forward, this is the on the right
     */
    public float maxX;
    /**
     * The maximum coordinate on the Y axis. Standing in the center of the AABB looking forward, this is the on the top
     */
    public float maxY;
    /**
     * The maximum coordinate on the Y axis. Standing in the center of the AABB looking forward, this is in front
     */
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

    /**
     * Creates an axis aligned bounding box, where the minimum/maximum
     * coordinates are calculated from the given center and scale
     * @param center The center of the AABB
     * @param scale  The scale of the AABB (aka the distance from the center to the edges)
     */
    public static AxisAlignedBB fromCenterScale(Vector3 center, Vector3 scale) {
        AxisAlignedBB aabb = new AxisAlignedBB();
        aabb.repositionFromCenterAndScale(center, scale);
        return aabb;
    }

    /**
     * Creates an axis aligned bounding box, where the minimum/maximum
     * coordinates are the exact values in the min and max vectors
     *
     * @param min The center of the AABB
     * @param max  The scale of the AABB (aka the distance from the center to the edges)
     */
    public static AxisAlignedBB fromMinMax(Vector3 min, Vector3 max) {
        AxisAlignedBB aabb = new AxisAlignedBB();
        aabb.setMin(min);
        aabb.setMax(max);
        return aabb;
    }

    /**
     * Returns the coordinates of this AABB instance's minimum
     * coordinates (in every axis), and returns it in a vector
     */
    public Vector3 getMin() {
        return new Vector3(this.minX, this.minY, this.minZ);
    }

    /**
     * Returns the coordinates of this AABB instance's maximum
     * coordinates (in every axis), and returns it in a vector
     */
    public Vector3 getMax() {
        return new Vector3(this.maxX, this.maxY, this.maxZ);
    }

    /**
     * Gets the size of this AABB instance, and returns it in a vector
     * @return
     */
    public Vector3 getSize() {
        return new Vector3(getSizeX(), getSizeY(), getSizeZ());
    }

    /**
     * Calculates the scale of this AABB instance by halving
     * the sizes in each axis, and returns it in a vector
     * <p>
     *     The scale being the distance from the center and the edges, or half
     *     the size (size being the distance from the maximum or minimum coordinates)
     * </p>
     */
    public Vector3 getScale() {
        return new Vector3(getScaleX(), getScaleY(), getScaleZ());
    }

    /**
     * Returns the scale of this AABB instance in the X axis,
     * that being half of the size in the X axis
     */
    public float getScaleX() {
        return getSizeX() / 2;
    }

    /**
     * Returns the scale of this AABB instance in the Y axis,
     * that being half of the size in the Y axis
     */
    public float getScaleY() {
        return getSizeY() / 2;
    }

    /**
     * Returns the scale of this AABB instance in the Z axis,
     * that being half of the size in the Z axis
     */
    public float getScaleZ() {
        return getSizeZ() / 2;
    }

    /**
     * Calculates the center of this AABB instance using the
     * minimum coordinates and the scale, and returns it in a vector
     */
    public Vector3 getCenter() {
        return getMin().add(getScaleX(), getScaleY(), getScaleZ());
    }

    /**
     * Gets the size of this AABB instance in the X axis, that being the
     * distance from the maximum to the minimum X coordinates
     */
    public float getSizeX() {
        return maxX - minX;
    }

    /**
     * Gets the size of this AABB instance in the Y axis, that being the
     * distance from the maximum to the minimum Y coordinates
     */
    public float getSizeY() {
        return maxY - minY;
    }

    /**
     * Gets the size of this AABB instance in the Z axis, that being the
     * distance from the maximum to the minimum Z coordinates
     */
    public float getSizeZ() {
        return maxZ - minZ;
    }

    /**
     * Sets this AABB instance's minimum coordinates as the exact given values
     */
    public void setMin(float x, float y, float z) {
        this.minX = x;
        this.minY = y;
        this.minZ = z;
    }

    /**
     * Sets this AABB instance's maximum coordinates as the exact given values
     */
    public void setMax(float x, float y, float z) {
        this.maxX = x;
        this.maxY = y;
        this.maxZ = z;
    }

    /**
     * Sets this AABB instance's minimums coordinates as the exact values within the given vector
     */
    public void setMin(Vector3 v) {
        this.minX = v.x;
        this.minY = v.y;
        this.minZ = v.z;
    }

    /**
     * Sets this AABB instance's maximums coordinates as the exact values within the given vector
     */
    public void setMax(Vector3 v) {
        this.maxX = v.x;
        this.maxY = v.y;
        this.maxZ = v.z;
    }

    /**
     * Calculates new coordinates for this AABB instance's minimum
     * and maximum coordinates using the given center and scale
     * @param center The center of the AABB
     * @param scale  The scale of the AABB (aka the distance from the center to the edges)
     */
    public void repositionFromCenterAndScale(Vector3 center, Vector3 scale) {
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
     * @param center The center of the AABB
     */
    public void repositionFromCenter(Vector3 center) {
        Vector3 scale = getScale();
        repositionFromCenterAndScale(center, scale);
    }

    /**
     * Resizes this AABB instance using the center of this AABB and the given scale
     * @param scale  The scale of the AABB (aka the distance from the center to the edges)
     */
    public void resizeFromScale(Vector3 scale) {
        Vector3 center = getCenter();
        repositionFromCenterAndScale(center, scale);
    }

    /**
     * Returns the amount that this AABB instance intersects the given AABB in the X axis
     * <p>
     *     Returns a positive number if an intersection has happened
     * </p>
     * <p>
     *     Returns a negative number if there is no intersection
     * </p>
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

    /**
     * Returns the amount that this AABB instance intersects the given AABB in the Y axis
     * <p>
     * Returns a positive number if an intersection has happened
     * </p>
     * <p>
     * Returns a negative number if there is no intersection
     * </p>
     */
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

    /**
     * Returns the amount that this AABB instance intersects the given AABB in the Z axis
     * <p>
     * Returns a positive number if an intersection has happened
     * </p>
     * <p>
     * Returns a negative number if there is no intersection
     * </p>
     */
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

    /**
     * Uses the getIntersectAmountX/Y/Z functions and puts it into a vector
     */
    public Vector3 getIntersectAmount(AxisAlignedBB box) {
        return new Vector3(getIntersectAmountX(box), getIntersectAmountY(box), getIntersectAmountZ(box));
    }

    /**
     * Returns true if the given vector is inside (intersecting) this AABB instance
     */
    public boolean intersectsVector(Vector3 v) {
        return intersectsPointX(v.x) &&
               intersectsPointY(v.z) &&
               intersectsPointZ(v.z);
    }

    /**
     * Returns true if this AABB instance is inside (intersecting, in every axis) the given AABB
     */
    public boolean intersectsAABB(AxisAlignedBB box) {
        return intersectsAABBX(box) &&
               intersectsAABBY(box) &&
               intersectsAABBZ(box);
    }

    /**
     * Returns true if this AABB instance is intersecting the given AABB in the X axis
     */
    public boolean intersectsAABBX(AxisAlignedBB box) {
        return intersectsRangeX(box.minX, box.maxX);
    }

    /**
     * Returns true if this AABB instance is intersecting the given AABB in the Y axis
     */
    public boolean intersectsAABBY(AxisAlignedBB box) {
        return intersectsRangeY(box.minY, box.maxY);
    }

    /**
     * Returns true if this AABB instance is intersecting the given AABB in the Z axis
     */
    public boolean intersectsAABBZ(AxisAlignedBB box) {
        return intersectsRangeZ(box.minZ, box.maxZ);
    }

    /**
     * Returns true if this AABB instance is intersecting the given minimum X and maximum X range
     */
    public boolean intersectsRangeX(float min, float max) {
        return (this.maxX > min) && (this.minX < max);
    }

    /**
     * Returns true if this AABB instance is intersecting the given minimum Y and maximum Y range
     */
    public boolean intersectsRangeY(float min, float max) {
        return (this.maxY > min) && (this.minY < max);
    }

    /**
     * Returns true if this AABB instance is intersecting the given minimum Z and maximum Z range
     */
    public boolean intersectsRangeZ(float min, float max) {
        return (this.maxZ > min) && (this.minZ < max);
    }

    /**
     * Returns true if this AABB instance is intersecting the given point in the X axis
     */
    public boolean intersectsPointX(float x) {
        return (this.maxX > x) && (this.minX < x);
    }

    /**
     * Returns true if this AABB instance is intersecting the given point in the Y axis
     */
    public boolean intersectsPointY(float y) {
        return (this.maxY > y) && (this.minY < y);
    }

    /**
     * Returns true if this AABB instance is intersecting the given point in the Z axis
     */
    public boolean intersectsPointZ(float z) {
        return (this.maxZ > z) && (this.minZ < z);
    }

    /**
     * Returns a copy of this AABB instance (same minimum/maximum values, but different object)
     */
    public AxisAlignedBB copy() {
        return new AxisAlignedBB(this.minX, this.minY, this.minZ, this.maxX, this.maxY, this.maxZ);
    }
}
