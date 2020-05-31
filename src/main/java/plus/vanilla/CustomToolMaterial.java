package plus.vanilla;

import com.google.common.base.Supplier;

import net.minecraft.recipe.Ingredient;
import net.minecraft.util.Lazy;
import plus.vanilla.copper.LoadCopper;
import net.minecraft.item.ToolMaterial;

public enum CustomToolMaterial implements ToolMaterial {

    COPPER(150, 10, 3.0f, 1.0f, 2, () -> {
        return Ingredient.ofItems(LoadCopper.COPPER_INGOT);
    });


    private final int durability;
    private final int enchantability;
    private final float miningSpeed;
    private final float attackDamage;
    private final int miningLevel;
    private final Lazy<Ingredient> repairIngredient;
 
    CustomToolMaterial(int durability, int enchantability, float miningSpeed, float attackDamage, int miningLevel, Supplier<Ingredient> repairIngredient) {
        this.durability=durability;
        this.enchantability=enchantability;
        this.miningSpeed=miningSpeed;
        this.attackDamage=attackDamage;
        this.miningLevel=miningLevel;
        this.repairIngredient = new Lazy<Ingredient>(repairIngredient);
    }

    @Override
    public int getDurability() {
        return durability;
    }

    @Override
    public int getEnchantability() {
        return enchantability;
    }

    @Override
    public float getMiningSpeed() {
        return miningSpeed;
    }

    @Override
    public float getAttackDamage() {
        return attackDamage;
    }

    @Override
    public int getMiningLevel() {
        return miningLevel;
    }

    @Override
    public Ingredient getRepairIngredient(){
        // We needed to make it a Lazy type so we can actually get the Ingredient from the Supplier.
        return this.repairIngredient.get();
    }
}