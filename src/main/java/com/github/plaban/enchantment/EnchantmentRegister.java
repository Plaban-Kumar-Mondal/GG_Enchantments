package com.github.plaban.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class EnchantmentRegister {
  public static final Enchantment COMBAT_HEAL = new CombatHealEnchantment(Enchantment.Rarity.RARE, EnchantmentTarget.WEAPON, new EquipmentSlot[]{EquipmentSlot.MAINHAND});
  public static final Enchantment MAKE_BOOM = new MakeBoomEnchantment(Enchantment.Rarity.RARE, EnchantmentTarget.TRIDENT, new EquipmentSlot[]{EquipmentSlot.MAINHAND});
  public static final Enchantment POKE = new PokeEnchantment(Enchantment.Rarity.UNCOMMON, EnchantmentTarget.TRIDENT, new EquipmentSlot[]{EquipmentSlot.MAINHAND});
  public static final Enchantment BANE_OF_ILLAGER = new BaneOfIllagerEnchantment(Enchantment.Rarity.UNCOMMON, EnchantmentTarget.WEAPON, new EquipmentSlot[]{EquipmentSlot.MAINHAND});
  public static final Enchantment QUICK_ESCAPE = new QuickEscapeEnchantment(Enchantment.Rarity.RARE, EnchantmentTarget.ARMOR_FEET, new EquipmentSlot[]{EquipmentSlot.FEET});
  public static final Enchantment LEVIOSA = new LeviosaEnchantment(Enchantment.Rarity.UNCOMMON, EnchantmentTarget.WEAPON, new EquipmentSlot[]{EquipmentSlot.MAINHAND});
  public static final Enchantment MORE_HEALTH = new MoreHealthEnchantment(Enchantment.Rarity.VERY_RARE, EnchantmentTarget.ARMOR, new EquipmentSlot[]{EquipmentSlot.HEAD, EquipmentSlot.CHEST, EquipmentSlot.LEGS, EquipmentSlot.FEET});

  public static void registerEnchantment(String modID) {
    Registry.register(Registry.ENCHANTMENT, new Identifier(modID, "leviosa"), LEVIOSA);
    Registry.register(Registry.ENCHANTMENT, new Identifier(modID, "combat_heal"), COMBAT_HEAL);
    Registry.register(Registry.ENCHANTMENT, new Identifier(modID, "make_boom"), MAKE_BOOM);
    Registry.register(Registry.ENCHANTMENT, new Identifier(modID, "poke"), POKE);
    Registry.register(Registry.ENCHANTMENT, new Identifier(modID, "bane_of_illager"), BANE_OF_ILLAGER);
    Registry.register(Registry.ENCHANTMENT, new Identifier(modID, "quick_escape"), QUICK_ESCAPE);
    Registry.register(Registry.ENCHANTMENT, new Identifier(modID, "more_health"), MORE_HEALTH);
  }
}
