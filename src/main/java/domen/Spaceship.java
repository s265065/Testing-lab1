package domen;

public class Spaceship extends Invention{
    private SpaceObject destination;
    private SpaceObject origin;

    public Spaceship(SpaceObject origin){
        this.origin = origin;
        this.setBuildable(true);
    }

    public SpaceObject getOrigin() {
        return origin;
    }

    public boolean setDestination(SpaceObject destination) {
        if (this.origin.distanceTo(destination) <= 1300){
            this.destination = destination;
            return true;
        }
        return false;
    }

}
