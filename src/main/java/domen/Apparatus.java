package domen;

public class Apparatus extends Invention {
    private Purpose purpose;
    private boolean buildable;

    public Apparatus(Purpose purpose){
        this.purpose = purpose;
        this.setBuildable(true);
    }

    public Purpose getPurpose() {
        return purpose;
    }

}
