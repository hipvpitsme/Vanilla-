package plus.vanilla.obsidian;

import net.minecraft.item.Item;
import net.minecraft.item.SwordItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import plus.vanilla.CustomToolMaterial;
import plus.vanilla.Entry;
import plus.vanilla.toolbase.AxeBase;
import plus.vanilla.toolbase.HoeBase;
import plus.vanilla.toolbase.PickaxeBase;
import plus.vanilla.toolbase.ShovelBase;

public class LoadObsidian {
    
    //Obsidian chunk item
    public static final Item OBSIDIAN = new Item(new Item.Settings().group(Entry.ITEM_GROUP));

    //Obsidian Tools
    public static final Item OBSIDIAN_SWORD = new SwordItem(CustomToolMaterial.OBSIDIAN, 4, -2.4F, new Item.Settings().maxCount(1).group(Entry.ITEM_GROUP));
    public static final Item OBSIDIAN_PICKAXE = new PickaxeBase(CustomToolMaterial.OBSIDIAN, 1, -2.8F, new Item.Settings().maxCount(1).group(Entry.ITEM_GROUP));
    public static final Item OBSIDIAN_AXE = new AxeBase(CustomToolMaterial.OBSIDIAN, 5.0F, -3.0F, new Item.Settings().maxCount(1).group(Entry.ITEM_GROUP));
    public static final Item OBSIDIAN_SHOVEL = new ShovelBase(CustomToolMaterial.OBSIDIAN, 1.5F, -3.0F, new Item.Settings().maxCount(1).group(Entry.ITEM_GROUP));
    public static final Item OBSIDIAN_HOE = new HoeBase(CustomToolMaterial.OBSIDIAN, -3, 0f, new Item.Settings().maxCount(1).group(Entry.ITEM_GROUP));

    public void loadObsidian(){
        //Obsidian item
        Registry.register(Registry.ITEM, new Identifier("vanplus", "obsidian"), OBSIDIAN);

        //Obsidian tools
        Registry.register(Registry.ITEM, new Identifier("vanplus", "obsidian_sword"), OBSIDIAN_SWORD);
        Registry.register(Registry.ITEM, new Identifier("vanplus", "obsidian_pickaxe"), OBSIDIAN_PICKAXE);
        Registry.register(Registry.ITEM, new Identifier("vanplus", "obsidian_axe"), OBSIDIAN_AXE);
        Registry.register(Registry.ITEM, new Identifier("vanplus", "obsidian_shovel"), OBSIDIAN_SHOVEL);
        Registry.register(Registry.ITEM, new Identifier("vanplus", "obsidian_hoe"), OBSIDIAN_HOE);
    }
}