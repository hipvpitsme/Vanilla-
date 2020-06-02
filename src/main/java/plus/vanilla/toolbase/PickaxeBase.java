package plus.vanilla.toolbase;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;

public class PickaxeBase extends PickaxeItem {

    public PickaxeBase(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }
    @Override
    public boolean isEffectiveOn(BlockState state) {
        Block block = state.getBlock();
        int i = this.getMaterial().getMiningLevel();
        if (block == Blocks.OBSIDIAN) {
            return i >= 3;
        }
        return super.isEffectiveOn(state);
    }
}