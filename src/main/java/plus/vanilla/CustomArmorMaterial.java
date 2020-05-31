package plus.vanilla;

import com.google.common.base.Supplier;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Lazy;
import plus.vanilla.copper.LoadCopper;

public enum CustomArmorMaterial implements ArmorMaterial {

    COPPER("copper", 5, new int[]{1,3,4,2}, 15, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F, () -> {
        return Ingredient.ofItems(LoadCopper.COPPER_INGOT);
    });


    private static final int[] baseDurability = {13, 15, 16, 11};
    private final String name;
    private final int durabilityMultiplier;
    private final int[] armorValues;
    private final int enchantability;
    private final SoundEvent equipSound;
    private final float toughness;
    private final Lazy<Ingredient> repairIngredient;
 
    CustomArmorMaterial(String name, int durabilityMultiplier, int[] armorValueArr, int enchantability, SoundEvent soundEvent, float toughness, Supplier<Ingredient> repairIngredient) {
        this.name = name;
        this.durabilityMultiplier = durabilityMultiplier;
        this.armorValues = armorValueArr;
        this.enchantability = enchantability;
        this.equipSound = soundEvent;
        this.toughness = toughness;
        this.repairIngredient = new Lazy<Ingredient>(repairIngredient);
    }
 
    public int getDurability(EquipmentSlot equipmentSlot_1) {
        return baseDurability[equipmentSlot_1.getEntitySlotId()] * this.durabilityMultiplier;
    }
 
    public int getProtectionAmount(EquipmentSlot equipmentSlot_1) {
        return this.armorValues[equipmentSlot_1.getEntitySlotId()];
    }
 
    public int getEnchantability() {
        return this.enchantability;
    }
 
    public SoundEvent getEquipSound() {
        return this.equipSound;
    }
 
    public Ingredient getRepairIngredient() {
        // We needed to make it a Lazy type so we can actually get the Ingredient from the Supplier.
        return this.repairIngredient.get();
    }
 
    @Environment(EnvType.CLIENT)
    public String getName() {
        return this.name;
    }
 
    public float getToughness() {
        return this.toughness;
    }
}