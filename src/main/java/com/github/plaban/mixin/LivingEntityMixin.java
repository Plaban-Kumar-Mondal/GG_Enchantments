package com.github.plaban.mixin;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin {

  @Shadow public abstract ItemStack getEquippedStack(EquipmentSlot slot);

  @Shadow public abstract boolean addStatusEffect(StatusEffectInstance effect);

  @Shadow public abstract float getMaxHealth();

  @Shadow public abstract boolean removeStatusEffect(StatusEffect type);

  private void addStatusEff(int amp){
    this.addStatusEffect(new StatusEffectInstance(StatusEffects.HEALTH_BOOST, 2_147_483_647, amp, false, false));
  }

  @Inject(at = @At("HEAD"), method = "tick")
  public void tick(CallbackInfo ci) {

    ItemStack chestplateStack = getEquippedStack(EquipmentSlot.CHEST);
    (chestplateStack.getEnchantments()).forEach((enchantment) -> {
      switch (enchantment.asString()) {
        case "{lvl:1s,id:\"gg_enchantments:more_health\"}":
          if (!(this.getMaxHealth() > 20)) {
            addStatusEff(0);
          }
          break;
        case "{lvl:2s,id:\"gg_enchantments:more_health\"}":
          if (!(this.getMaxHealth() > 20)) {
            addStatusEff(1);
          }
          break;
        case "{lvl:3s,id:\"gg_enchantments:more_health\"}":
          if (!(this.getMaxHealth() > 20)) {
            addStatusEff(2);
          }
          break;
        case "{lvl:4s,id:\"gg_enchantments:more_health\"}":
          if (!(this.getMaxHealth() > 20)) {
            addStatusEff(3);
          }
          break;
      }
    });


    if(this.getMaxHealth() > 20 && chestplateStack.getItem() == Items.AIR) {
      this.removeStatusEffect(StatusEffects.HEALTH_BOOST);
    }
  }
}
