package plus.vanilla.copper;

import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.fabricmc.fabric.api.event.registry.RegistryEntryAddedCallback;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import plus.vanilla.CustomArmorMaterial;
import plus.vanilla.Entry;

public class LoadCopper {

    //Armor
    public static final Item COPPER_HELMET = new ArmorItem(CustomArmorMaterial.COPPER, EquipmentSlot.HEAD, (new Item.Settings().group(Entry.ITEM_GROUP)));
    public static final Item COPPER_CHESTPLATE = new ArmorItem(CustomArmorMaterial.COPPER, EquipmentSlot.CHEST, (new Item.Settings().group(Entry.ITEM_GROUP)));
    public static final Item COPPER_LEGGINGS = new ArmorItem(CustomArmorMaterial.COPPER, EquipmentSlot.LEGS, (new Item.Settings().group(Entry.ITEM_GROUP)));
    public static final Item COPPER_BOOTS = new ArmorItem(CustomArmorMaterial.COPPER, EquipmentSlot.FEET, (new Item.Settings().group(Entry.ITEM_GROUP)));

    //Ingot item
    public static final Item COPPER_INGOT = new Item(new Item.Settings().group(Entry.ITEM_GROUP));

    //Blocks
    public static final Block COPPER_ORE = new Block(FabricBlockSettings.of(Material.STONE).hardness(3).build());
    public static final Block COPPER_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).hardness(4).build());

    //Tools and weapons
    public static final Item COPPER_SWORD = new Item(new Item.Settings().group(Entry.ITEM_GROUP));
    public static final Item COPPER_PICKAXE = new Item(new Item.Settings().group(Entry.ITEM_GROUP));
    public static final Item COPPER_AXE = new Item(new Item.Settings().group(Entry.ITEM_GROUP));
    public static final Item COPPER_SHOVEL = new Item(new Item.Settings().group(Entry.ITEM_GROUP));
    public static final Item COPPER_HOE = new Item(new Item.Settings().group(Entry.ITEM_GROUP));

    public void loadCopper(){
        /*
        Copper
        */
        //Ore
        Registry.register(Registry.BLOCK, new Identifier("vanplus", "copper_ore"), COPPER_ORE);
        Registry.register(Registry.ITEM, new Identifier("vanplus", "copper_ore"), new BlockItem(COPPER_ORE, new Item.Settings().group(Entry.ITEM_GROUP)));
        //Ore generation
        Registry.BIOME.forEach(this::handleBiome);
        RegistryEntryAddedCallback.event(Registry.BIOME).register((i, identifier, biome) -> handleBiome(biome));

        //Ingot
        Registry.register(Registry.ITEM, new Identifier("vanplus", "copper_ingot"), COPPER_INGOT);

        //Block
        Registry.register(Registry.BLOCK, new Identifier("vanplus", "copper_block"), COPPER_BLOCK);
        Registry.register(Registry.ITEM, new Identifier("vanplus", "copper_block"), new BlockItem(COPPER_BLOCK, new Item.Settings().group(Entry.ITEM_GROUP)));

        //Armor
        Registry.register(Registry.ITEM, new Identifier("vanplus", "copper_helmet"), COPPER_HELMET);
        Registry.register(Registry.ITEM, new Identifier("vanplus", "copper_chestplate"), COPPER_CHESTPLATE);
        Registry.register(Registry.ITEM, new Identifier("vanplus", "copper_leggings"), COPPER_LEGGINGS);
        Registry.register(Registry.ITEM, new Identifier("vanplus", "copper_boots"), COPPER_BOOTS);

        //Tools and weapons
        Registry.register(Registry.ITEM, new Identifier("vanplus", "copper_sword"), COPPER_SWORD);
        Registry.register(Registry.ITEM, new Identifier("vanplus", "copper_pickaxe"), COPPER_PICKAXE);
        Registry.register(Registry.ITEM, new Identifier("vanplus", "copper_axe"), COPPER_AXE);
        Registry.register(Registry.ITEM, new Identifier("vanplus", "copper_shovel"), COPPER_SHOVEL);
        Registry.register(Registry.ITEM, new Identifier("vanplus", "copper_hoe"), COPPER_HOE);
    }

    public void handleBiome(Biome biome) {
        if(biome.getCategory() != Biome.Category.NETHER && biome.getCategory() != Biome.Category.THEEND) {
            biome.addFeature(
                    GenerationStep.Feature.UNDERGROUND_ORES,
                    Feature.ORE.configure(
                new OreFeatureConfig(
                    OreFeatureConfig.Target.NATURAL_STONE,
                    COPPER_ORE.getDefaultState(),
                    6 //Ore vein size
               )).createDecoratedFeature(
                Decorator.COUNT_RANGE.configure(new RangeDecoratorConfig(
                    127, //Number of veins per chunk
                    0, //Bottom Offset
                    50, //Min y level
                    256 //Max y level
            ))));
        }
    }
}