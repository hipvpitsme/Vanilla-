package plus.vanilla.netherstar;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.SwordItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import plus.vanilla.CustomArmorMaterial;
import plus.vanilla.CustomToolMaterial;
import plus.vanilla.Entry;
import plus.vanilla.toolbase.AxeBase;
import plus.vanilla.toolbase.HoeBase;
import plus.vanilla.toolbase.PickaxeBase;
import plus.vanilla.toolbase.ShovelBase;

public class LoadNetherstar {

    //Armor
    public static final Item NETHERSTAR_HELMET = new ArmorItem(CustomArmorMaterial.NETHERSTAR, EquipmentSlot.HEAD, (new Item.Settings().maxCount(1).group(Entry.ITEM_GROUP)));
    public static final Item NETHERSTAR_CHESTPLATE = new ArmorItem(CustomArmorMaterial.NETHERSTAR, EquipmentSlot.CHEST, (new Item.Settings().maxCount(1).group(Entry.ITEM_GROUP)));
    public static final Item NETHERSTAR_LEGGINGS = new ArmorItem(CustomArmorMaterial.NETHERSTAR, EquipmentSlot.LEGS, (new Item.Settings().maxCount(1).group(Entry.ITEM_GROUP)));
    public static final Item NETHERSTAR_BOOTS = new ArmorItem(CustomArmorMaterial.NETHERSTAR, EquipmentSlot.FEET, (new Item.Settings().maxCount(1).group(Entry.ITEM_GROUP)));

    //Blocks
    public static final Block NETHERSTAR_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).lightLevel(36).hardness(4));

    //Tools and weapons
    public static final Item NETHERSTAR_SWORD = new SwordItem(CustomToolMaterial.NETHERSTAR, 3, -2.4f, new Item.Settings().maxCount(1).group(Entry.ITEM_GROUP));
    public static final Item NETHERSTAR_PICKAXE = new PickaxeBase(CustomToolMaterial.NETHERSTAR, 0, -2.8f, new Item.Settings().maxCount(1).group(Entry.ITEM_GROUP));
    public static final Item NETHERSTAR_AXE = new AxeBase(CustomToolMaterial.NETHERSTAR, 6, -3.3f, new Item.Settings().maxCount(1).group(Entry.ITEM_GROUP));
    public static final Item NETHERSTAR_SHOVEL = new ShovelBase(CustomToolMaterial.NETHERSTAR, 2, -3f, new Item.Settings().maxCount(1).group(Entry.ITEM_GROUP));
    public static final Item NETHERSTAR_HOE = new HoeBase(CustomToolMaterial.NETHERSTAR, -2, -.5f, new Item.Settings().maxCount(1).group(Entry.ITEM_GROUP));

    public void loadNetherstar(){
        /*
        Netherstar
        */
        //Block
        Registry.register(Registry.BLOCK, new Identifier("vanplus", "nether_star_block"), NETHERSTAR_BLOCK);
        Registry.register(Registry.ITEM, new Identifier("vanplus", "nether_star_block"), new BlockItem(NETHERSTAR_BLOCK, new Item.Settings().group(Entry.ITEM_GROUP)));

        //Armor
        Registry.register(Registry.ITEM, new Identifier("vanplus", "nether_star_helmet"), NETHERSTAR_HELMET);
        Registry.register(Registry.ITEM, new Identifier("vanplus", "nether_star_chestplate"), NETHERSTAR_CHESTPLATE);
        Registry.register(Registry.ITEM, new Identifier("vanplus", "nether_star_leggings"), NETHERSTAR_LEGGINGS);
        Registry.register(Registry.ITEM, new Identifier("vanplus", "nether_star_boots"), NETHERSTAR_BOOTS);

        //Tools and weapons
        Registry.register(Registry.ITEM, new Identifier("vanplus", "nether_star_sword"), NETHERSTAR_SWORD);
        Registry.register(Registry.ITEM, new Identifier("vanplus", "nether_star_pickaxe"), NETHERSTAR_PICKAXE);
        Registry.register(Registry.ITEM, new Identifier("vanplus", "nether_star_axe"), NETHERSTAR_AXE);
        Registry.register(Registry.ITEM, new Identifier("vanplus", "nether_star_shovel"), NETHERSTAR_SHOVEL);
        Registry.register(Registry.ITEM, new Identifier("vanplus", "nether_star_hoe"), NETHERSTAR_HOE);
    }
}