package plus.vanilla;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import plus.vanilla.addition.copper.LoadCopper;
import plus.vanilla.addition.enchants.LoadEnchants;
import plus.vanilla.addition.iron.LoadIron;
import plus.vanilla.addition.netherstar.LoadNetherstar;
import plus.vanilla.addition.obsidian.LoadObsidian;

public class Entry implements ModInitializer {
    //Custom item group
    public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.build(
		new Identifier("vanplus", "all"),
    () -> new ItemStack(Blocks.BEDROCK));
    
    @Override
    public void onInitialize() {
        new LoadCopper().loadCopper();
        new LoadObsidian().loadObsidian();
        new LoadIron().loadIron();
        new LoadNetherstar().loadNetherstar();
        new LoadEnchants().loadEnchants();
    }
}