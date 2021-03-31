import domen.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Domen model tests")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class DomenTest {

    private static final double DELTA = 0.05;

    private Human firstHuman;
    private Human secondHuman;

    private Apparatus genApparatus;

    private Star farAwayStar;
    private Star notSoFarStar;
    private Planet earth;

    private Spaceship spaceship;

    @BeforeEach
    void init() {
        firstHuman = new Human("Kevin", 23);
        secondHuman = new Human("Martha", 21);

        genApparatus = new Apparatus(Purpose.GENERATE);

        this.farAwayStar = new Star(1100, 554, 789);
        this.notSoFarStar = new Star(110,50,64);

        this.earth = new Planet(1,1,1, "Earth");

        this.spaceship = new Spaceship(earth);
    }

    @Test
    @DisplayName("Distance to faraway star greater than 1300")
    void farAwayDistance() {
        assertTrue(this.earth.distanceTo(this.farAwayStar) > 1300);
    }

    @Test
    @DisplayName("makeAnnouncement change property buildable of invetion")
    void buildableChage() {
        boolean prev = this.genApparatus.isBuildable();
        this.firstHuman.makeAnnouncementAbout(this.genApparatus);
        assertTrue(prev != this.genApparatus.isBuildable());
    }

    @Test
    @DisplayName("human does not make peace with failure ")
    void makePeaceWithTest() {
        assertFalse(firstHuman.makePeaceWith(Result.FAILURE));
        assertFalse(secondHuman.makePeaceWith(Result.FAILURE));
        assertTrue(secondHuman.makePeaceWith(Result.SUCCESS));
        assertTrue(firstHuman.makePeaceWith(Result.SUCCESS));
    }

    @Test
    @DisplayName("Distance for spaceship sets only if its not too far away")
    void farAwayDistanceSet() {
        assertTrue(spaceship.setDestination(notSoFarStar));
        assertFalse(spaceship.setDestination(farAwayStar));
    }

    @Test
    @DisplayName("Distance count correct")
    void distanceCountTest() {
        assertEquals(1461.01, earth.distanceTo(farAwayStar), DELTA);
        assertEquals(135.05, earth.distanceTo(notSoFarStar), DELTA);
        assertEquals(1326.55, notSoFarStar.distanceTo(farAwayStar), DELTA);
        assertEquals(1326.55, farAwayStar.distanceTo(notSoFarStar), DELTA);
    }

}