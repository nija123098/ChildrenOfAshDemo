package um.nija123098.game.elements.item;

/**
 * Made by Dev on 1/10/2016
 */
public interface ContainerType {
    boolean roomImInventorty();
    boolean add(Item item);
    boolean remove(Item item);
    boolean remove(int index);
    boolean itemQualifies(Item item);
}