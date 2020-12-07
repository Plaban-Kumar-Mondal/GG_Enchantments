package com.github.plaban;

import net.fabricmc.api.ModInitializer;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class MainFile implements ModInitializer {

    public static final Enchantment COMBAT_HEAL = new CombatHealEnchantment(
            Enchantment.Rarity.RARE,
            EnchantmentTarget.WEAPON,
            new EquipmentSlot[]{
                    EquipmentSlot.MAINHAND
            }
    );

    public static final Enchantment MAKE_BOOM = new MakeBoomEnchantment(
            Enchantment.Rarity.RARE,
            EnchantmentTarget.TRIDENT,
            new EquipmentSlot[]{
                    EquipmentSlot.MAINHAND
            }
    );

    public static final Enchantment POKE = new PokeEnchantment(
            Enchantment.Rarity.UNCOMMON,
            EnchantmentTarget.TRIDENT,
            new EquipmentSlot[]{
                    EquipmentSlot.MAINHAND
            }
    );

    public static final Enchantment BANE_OF_ILLAGER = new BaneOfIllagerEnchantment(
            Enchantment.Rarity.UNCOMMON,
            EnchantmentTarget.WEAPON,
            new EquipmentSlot[]{
                    EquipmentSlot.MAINHAND
            }
    );


    @Override
    public void onInitialize() {
        Registry.register(Registry.ENCHANTMENT, new Identifier("gg_enchantments", "combat_heal"), COMBAT_HEAL);
        Registry.register(Registry.ENCHANTMENT, new Identifier("gg_enchantments", "make_boom"), MAKE_BOOM);
        Registry.register(Registry.ENCHANTMENT, new Identifier("gg_enchantments", "poke"), POKE);
        Registry.register(Registry.ENCHANTMENT, new Identifier("gg_enchantments", "bane_of_illager"), BANE_OF_ILLAGER);
    }
}



