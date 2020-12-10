package com.github.plaban.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

public class MoreHealthEnchantment extends Enchantment {
  protected MoreHealthEnchantment(Rarity weight, EnchantmentTarget type, EquipmentSlot[] slotTypes) {
    super(weight, type, slotTypes);
  }

  @Override
  public int getMinPower(int level) {
    return  5 + (level - 1) * 8;
  }

  @Override
  public int getMaxLevel() {
    return 4;
  }

  @Override
  protected boolean canAccept(Enchantment other) {
    return super.canAccept(other) && other != Enchantments.MENDING;
  }

  @Override
  public Text getName(int level) {
    return super.getName(level).shallowCopy().formatted(Formatting.GREEN);
  }
}
