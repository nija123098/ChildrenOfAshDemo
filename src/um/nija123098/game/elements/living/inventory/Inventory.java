package um.nija123098.game.elements.living.inventory;

import um.nija123098.game.elements.item.Container;
import um.nija123098.game.elements.item.Item;
import um.nija123098.game.elements.item.equipable.Equipable;
import um.nija123098.game.elements.item.equipable.AdditionalMethodVerificationElement;
import um.nija123098.game.elements.living.Living;

import java.util.ArrayList;

/**
 * Made by Dev on 12/22/2015
 */
public class Inventory extends Container{
    public Container container;
    public Living living;
    public ArrayList<Integer> equippedIndex;
    public Inventory(int inventorySize){
        this.container = new Container(inventorySize);
        this.equippedIndex = new ArrayList<Integer>(inventorySize/8);
    }
    public Inventory(int inventorySize, Item... items){
        this(inventorySize);
        for (Item item : items){
            this.addItem(item);
        }
    }
    public boolean equip(Item item){
        return item instanceof Equipable && ((Equipable) item).canEquip(this.living) && (!(this instanceof AdditionalMethodVerificationElement) || ((AdditionalMethodVerificationElement) item).additionalVerification(this.living)) && this.living.body.canEquip(((Equipable) item));
    }
    public void unequip(Item item){
        if (this.equippedIndex.contains(this.container.items.indexOf(item)) && !(item instanceof InventoryExpander)){
            this.equippedIndex.remove(this.container.items.indexOf(item));
        }
    }
}
