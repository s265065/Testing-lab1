package domen;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Human implements Action{

    private String name;
    private int age;

    @Override
    public boolean makeAnnouncementAbout(Invention invention) {
        invention.setBuildable(!invention.isBuildable());
        return invention.isBuildable();
    }

    @Override
    public boolean makePeaceWith(Result result) {
        if (result.equals(Result.FAILURE)){
            return false;
        } else {
            return true;
        }
    }
}
