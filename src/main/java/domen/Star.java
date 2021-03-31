package domen;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Star extends SpaceObject{
    private double x;
    private double y;
    private double z;

    @Override
    public double distanceTo(SpaceObject object) {
        return Math.sqrt((object.getX() - this.x)*(object.getX() - this.x)
            + (object.getY() - this.y)*(object.getY() - this.y)
            + (object.getZ() - this.z)*(object.getZ() - this.z));
    }

}
