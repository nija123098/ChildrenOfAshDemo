import basicjavautillibrary.um.nija123098.general.AdvancedArray;
import basicjavautillibrary.um.nija123098.math.algibra.Range;
import um.nija123098.game.elements.body.Body;
import um.nija123098.game.elements.body.position.positions.PoofPosition;
import um.nija123098.game.elements.living.qualities.BodyType;
import um.nija123098.game.elements.living.qualities.Quirk;
import um.nija123098.game.elements.living.qualities.Sex;
import um.nija123098.game.elements.living.qualities.race.Race;
import um.nija123098.game.elements.living.qualities.Stats;
import um.nija123098.resorce.NotARangeRange;

/**
 * Made by Dev on 2/13/2016
 */
public class TestRace extends Race{
    public TestRace() {
        super(1, 1, 1, 1, 1, new Stats());
    }
    @Override
    public Body getBody(Sex sex, BodyType bodyType) {
        return new Body("b", new PoofPosition());
    }
    @Override
    public AdvancedArray<Quirk> getQuirks() {
        return new AdvancedArray<>();
    }
    @Override
    public AdvancedArray<Sex> getPossibleSexes() {
        return new AdvancedArray<Sex>(Sex.FEMALE, Sex.MALE);
    }
    @Override
    public AdvancedArray<BodyType> getPossibleBodyTypes(Sex sex) {
        return new AdvancedArray<BodyType>(BodyType.ATHLETIC, BodyType.BURLY, BodyType.THICK, BodyType.NORMAL);
    }
    @Override
    public Range getHeightRange(Sex sex, BodyType bodyType) {
        return new NotARangeRange(1);
    }
    @Override
    public Range getWeightRange(Sex sex, BodyType bodyType) {
        return new NotARangeRange(1);
    }
}
