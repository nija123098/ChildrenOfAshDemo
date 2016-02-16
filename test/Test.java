import um.nija123098.game.elements.dossier.Dossier;
import um.nija123098.game.elements.dossier.qualities.BodyType;
import um.nija123098.game.elements.dossier.qualities.Sex;
import um.nija123098.game.elements.dossier.qualities.race.races.Tes;
import um.nija123098.game.elements.dossier.qualities.Stats;

/**
 * Made by Dev on 2/15/2016
 */
public class Test {
    public static void main(String[] args) {
        int level = 10;
        Dossier b = new Dossier("d", level, 9, 9, Sex.FEMALE, new Tes(), new Stats(1,1,1,1,1), BodyType.BURLY, null);
        Dossier a = new Dossier("d", level, 9, 9, Sex.FEMALE, new Tes(), new Stats(1,1,1,1,1), BodyType.ATHLETIC, null);
        System.out.print(b.getStrength());
        System.out.print(" - ");
        System.out.println(a.getStrength());
        System.out.print(b.getCharisma());
        System.out.print(" - ");
        System.out.println(a.getCharisma());
        System.out.print(b.getConstitution());
        System.out.print(" - ");
        System.out.println(a.getConstitution());
        System.out.print(b.getAgility());
        System.out.print(" - ");
        System.out.println(a.getAgility());
        System.out.print(b.getIntelligence());
        System.out.print(" - ");
        System.out.println(a.getIntelligence());
    }
}
