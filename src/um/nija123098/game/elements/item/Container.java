package um.nija123098.game.elements.item;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Made by Dev on 1/10/2016
 */
public class Container{
    public int size;
    public ArrayList<Item> items;// no multiple items
    public Container(int size){
        this.size = size;
        this.items = new ArrayList<Item>(this.size/4);
    }
    public Container(int size, Item...items){
        this(size);
        Collections.addAll(this.items, items);
    }
    public Container(Item...items){
        this(items.length, items);

    }
    public boolean itemAccpetable(Item item){
        return true;
    }
    public int numbarOfSlots() {
        return this.size;
    }
    public boolean hasRoom() {
        return this.size < this.items.size();
    }
    public boolean addItem(Item item){
        if (!this.hasRoom()){
            return false;
        }
        this.items.add(item);
        return true;
    }
    public boolean removeItem(Item item){
        return this.items.remove(item);
    }
}
