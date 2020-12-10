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

public class LeviosaEnchantment extends Enchantment {
  protected LeviosaEnchantment(Rarity weight, EnchantmentTarget type, EquipmentSlot[] slotTypes) {
    super(weight, type, slotTypes);
  }

  @Override
  public int getMinPower(int level) {
    return 5 + (level - 1) * 8;
  }

  @Override
  public int getMaxLevel() {
    return 4;
  }

  @Override
  public void onTargetDamaged(LivingEntity user, Entity target, int level) {
    if(target instanceof LivingEntity) {
      int time = 40 + user.getRandom().nextInt(10 * level);
      ((LivingEntity)target).applyStatusEffect(new StatusEffectInstance(StatusEffects.LEVITATION, time, 2));
    }
  }

  @Override
  public Text getName(int level) {
    return super.getName(level).shallowCopy().formatted(Formatting.GREEN);
  }
}
