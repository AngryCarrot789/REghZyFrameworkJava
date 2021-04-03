package reghzy.graphics.collision;

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

    public float sizeX() {
        return maxX - minX;
    }

    public float sizeY() {
        return maxY - minY;
    }

    public float sizeZ() {
        return maxZ - minZ;
    }

    public float intersectAmountX(AxisAlignedBB box) {
        float size = box.sizeX();
        float scale = size / 2;
        float center = box.maxX - scale;
        if (this.maxX < center) {
            return this.maxX - box.minX;
        }
        else {
            return box.maxX - this.maxX;
        }
    }

    public float intersectAmountY(AxisAlignedBB box) {
        float size = box.sizeY();
        float scale = size / 2;
        float center = box.maxY - scale;
        if (this.maxY < center) {
            return this.maxY - box.minY;
        }
        else {
            return box.maxY - this.maxY;
        }
    }

    public float intersectAmountZ(AxisAlignedBB box) {
        float size = box.sizeZ();
        float scale = size / 2;
        float center = box.maxZ - scale;
        if (this.maxZ < center) {
            return this.maxZ - box.minZ;
        }
        else {
            return box.maxZ - this.maxZ;
        }
    }

    public boolean intersectsAABB(AxisAlignedBB box) {
        return intersectsAABBX(box) &&
               intersectsAABBY(box) &&
               intersectsAABBZ(box);
    }

    public boolean intersectsAABBX(AxisAlignedBB box) {
        return (this.maxX > box.minX) && (this.minX < box.maxX);
    }

    public boolean intersectsAABBY(AxisAlignedBB box) {
        return (this.maxY > box.minY) && (this.minY < box.maxY);
    }

    public boolean intersectsAABBZ(AxisAlignedBB box) {
        return (this.maxZ > box.minZ) && (this.minZ < box.maxZ);
    }
}
