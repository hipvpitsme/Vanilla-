package plus.vanilla;

import com.google.common.base.Supplier;

import net.minecraft.recipe.Ingredient;
import net.minecraft.util.Lazy;
import plus.vanilla.copper.LoadCopper;
import plus.vanilla.obsidian.LoadObsidian;
import net.minecraft.item.ToolMaterial;

public enum CustomToolMaterial implements ToolMaterial {
    COPPER(2, 150, 3.0f, 1.0f, 10, () -> {
        return Ingredient.ofItems(LoadCopper.COPPER_INGOT);
    }),
    OBSIDIAN(4, 2000, 10f, 5f, 14, () -> {
        return Ingredient.ofItems(LoadObsidian.OBSIDIAN);
    });


    private final int miningLevel;
    private final int itemDurability;
    private final float miningSpeed;
    private final float attackDamage;
    private final int enchantability;
    private final Lazy<Ingredient> repairIngredient;

    private CustomToolMaterial(int miningLevel, int itemDurability, float miningSpeed, float attackDamage, int enchantibility, Supplier<Ingredient> repairIngredient) {
        this.miningLevel = miningLevel;
        this.itemDurability = itemDurability;
        this.miningSpeed = miningSpeed;
        this.attackDamage = attackDamage;
        this.enchantability = enchantibility;
        this.repairIngredient = new Lazy<Ingredient>(repairIngredient);
    }

    public int getDurability() {
        return this.itemDurability;
    }

    public float getMiningSpeedMultiplier() {
        return this.miningSpeed;
    }

    public float getAttackDamage() {
        return this.attackDamage;
    }

    public int getMiningLevel() {
        return this.miningLevel;
    }

    public int getEnchantability() {
        return this.enchantability;
    }

    public Ingredient getRepairIngredient() {
        return (Ingredient)this.repairIngredient.get();
    }
}