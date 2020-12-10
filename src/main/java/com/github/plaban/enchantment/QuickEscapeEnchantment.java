package com.github.plaban.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

public class QuickEscapeEnchantment extends Enchantment {
  protected QuickEscapeEnchantment(Rarity weight, EnchantmentTarget type, EquipmentSlot[] slotTypes) {
    super(weight, type, slotTypes);
  }

  @Override
  public int getMinPower(int level) {
    return (level * 5) + 10;
  }

  @Override
  public int getMaxLevel() {
    return 3;
  }

  @Override
  public void onUserDamaged(LivingEntity user, Entity attacker, int level) {
    if(user.getHealth() <= (user.getMaxHealth() * 0.3)) {
      int time = (level * 20 * 5);
      user.applyStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, time, level));
    }
  }

  @Override
  public Text getName(int level) {
    return super.getName(level).shallowCopy().formatted(Formatting.GREEN);
  }

}
