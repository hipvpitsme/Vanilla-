package plus.vanilla.addition.iron;

import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import plus.vanilla.Entry;

public class LoadIron {

    //Custom iron items
    public static final Item IRON_ROD = new Item(new Item.Settings().group(Entry.ITEM_GROUP));

    public void loadIron(){
        //Modded iron item
        Registry.register(Registry.ITEM, new Identifier("vanplus", "iron_rod"), IRON_ROD);
    }
}