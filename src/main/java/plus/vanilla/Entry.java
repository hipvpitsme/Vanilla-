package plus.vanilla;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Entry implements ModInitializer {
    //Custom item group
    public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.build(
		new Identifier("vanplus", "all"),
		() -> new ItemStack(Blocks.BEDROCK));

    public static final Block COPPER_ORE = new Block(FabricBlockSettings.of(Material.STONE).hardness(3).build());
    public static final Block COPPER_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).hardness(4).build());
    @Override
    public void onInitialize() {
        /*
        Copper
        */
        //Ore
        Registry.register(Registry.BLOCK, new Identifier("vanplus", "copper_ore"), COPPER_ORE);
        Registry.register(Registry.ITEM, new Identifier("vanplus", "copper_ore"), new BlockItem(COPPER_ORE, new Item.Settings().group(ITEM_GROUP)));
        //Block
        Registry.register(Registry.BLOCK, new Identifier("vanplus", "copper_block"), COPPER_BLOCK);
        Registry.register(Registry.ITEM, new Identifier("vanplus", "copper_block"), new BlockItem(COPPER_BLOCK, new Item.Settings().group(ITEM_GROUP)));
    }
    
}