package domen;

public abstract class Invention {
    private boolean buildable = true;

    public boolean isBuildable() {
        return buildable;
    }

    public void setBuildable(boolean buildable) {
        this.buildable = buildable;
    }
}
