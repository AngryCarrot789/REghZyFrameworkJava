package reghzy.graphics.collision;

import reghzy.graphics.maths.Vector3;
import sun.font.TrueTypeGlyphMapper;

import javax.swing.*;

public class RayCast {
    public Vector3 start;
    public Vector3 end;

    private Vector3 directionFraction;

    /**
     * The length (or distance travelled) of the ray before it hit a bounding box (or 0 if it hit nothing)
     */
    public float lengthBeforeHit;

    public RayCast(Vector3 start, Vector3 end, float distance) {
        this.start = start;
        this.end = end;
        this.end.z = distance;
        this.lengthBeforeHit = 0.0f;
    }

    /*
                                      |         |
                                     /|         |
                                    / |         |
                                   /  |         |
                                  /   |         |
                                 /    |         |
                                /     |         |                                   5   + Z
                               /      |         |/
                              /       |        /|
                             /        |      /  |
       - X _________________/_________|____/____|_________________________________  4   + X
                           /          |         |
                          /           |   AABB  |
                         /           /|         |
       _________________/__________/__|_________|_________________________________  3
                       /         /    |         |
                      /        /      |         |
                     /       /        |         |
                    /      /          |         |                                   2
                   /     /            |         |
                  /    /              A  PlaneZ B
                 /   /
                /  /                                                                1   - Z
            RAYS /

            angle: 0.6
                degrees: 30~                                                        0

        0               1             2             3               4               5

     */

    public boolean hitsBox(AxisAlignedBB aabb) {
        return false;
    }

    public boolean hitsPlaneAX(AxisAlignedBB aabb) {
        return this.start.x < aabb.minX && this.end.x > aabb.minX;
    }

    public boolean hitsPlaneBX(AxisAlignedBB aabb) {
        return this.start.x < aabb.maxX && this.end.x > aabb.maxX;
    }

    public boolean hitsPlaneAY(AxisAlignedBB aabb) {
        return this.start.x < aabb.minX && this.end.x > aabb.minX;
    }

    public boolean hitsPlaneBY(AxisAlignedBB aabb) {
        return this.start.x < aabb.maxX && this.end.x > aabb.maxX;
    }

    public boolean hitsPlaneAZ(AxisAlignedBB aabb) {
        return this.start.z < aabb.minZ && this.end.z > aabb.minZ;
    }

    public boolean hitsPlaneBZ(AxisAlignedBB aabb) {
        return this.start.z < aabb.maxZ && this.end.z > aabb.maxZ;
    }
}
