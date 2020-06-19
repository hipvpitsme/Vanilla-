package plus.vanilla.enchants;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class LoadEnchants {
    public void loadEnchants(){
        Registry.register(Registry.ENCHANTMENT, new Identifier("vanplus", "melting"), new MeltingEnchantment(Enchantment.Rarity.UNCOMMON, new EquipmentSlot[]{EquipmentSlot.MAINHAND}));
    }
}