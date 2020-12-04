package com.github.plaban;

import net.fabricmc.api.ModInitializer;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class MainFile implements ModInitializer {

	public static final Enchantment LEECH = new LeechEnchantment(
			Enchantment.Rarity.RARE,
			EnchantmentTarget.WEAPON,
			new EquipmentSlot[]{
					EquipmentSlot.MAINHAND
			}
	);

	public static final Enchantment MAKEBOOM = new MakeBoomEnchantment(
	        Enchantment.Rarity.UNCOMMON,
            EnchantmentTarget.TRIDENT,
            new EquipmentSlot[]{
                    EquipmentSlot.MAINHAND
            }
    );



	@Override
	public void onInitialize() {
		Registry.register(Registry.ENCHANTMENT, new Identifier("gg_enchantments", "leech"), LEECH);
	    Registry.register(Registry.ENCHANTMENT, new Identifier("gg_enchantments", "make_boom"), MAKEBOOM);

	}
}



