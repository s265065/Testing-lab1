package domen;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Planet extends SpaceObject{

    private double x;
    private double y;
    private double z;
    private String name;


    public void setName(String name) {
        this.name = name;
    }

    @Override
    public double distanceTo(SpaceObject object) {
        return Math.sqrt((object.getX() - this.x)*(object.getX() - this.x)
                + (object.getY() - this.y)*(object.getY() - this.y)
                + (object.getZ() - this.z)*(object.getZ() - this.z));
    }


    @Override
    public double getX() {
        return x;
    }

    @Override
    public double getY() {
        return y;
    }

    @Override
    public double getZ() {
        return z;
    }
}
