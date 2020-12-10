package com.github.plaban.mixin;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
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
    this.addStatusEffect(new StatusEffectInstance(StatusEffects.HEALTH_BOOST, 2_147_483_647, amp));
  }

  @Inject(at = @At("HEAD"), method = "tick")
  public void tick(CallbackInfo ci) {

    ItemStack chestplateStack = getEquippedStack(EquipmentSlot.CHEST);
    (chestplateStack.getEnchantments()).forEach((enchantment) -> {
      if(enchantment.asString().equals("{lvl:1s,id:\"gg_enchantments:more_health\"}")) {
        if(!(this.getMaxHealth() > 20)) {
          addStatusEff(0);
        }
      } else if(enchantment.asString().equals("{lvl:2s,id:\"gg_enchantments:more_health\"}")){
        if(!(this.getMaxHealth() > 20)) {
          addStatusEff(1);
        }
      } else if(enchantment.asString().equals("{lvl:3s,id:\"gg_enchantments:more_health\"}")){
        if(!(this.getMaxHealth() > 20)) {
          addStatusEff(2);
        }
      } else if(enchantment.asString().equals("{lvl:4s,id:\"gg_enchantments:more_health\"}")){
        if(!(this.getMaxHealth() > 20)) {
          addStatusEff(3);
        }
      }
    });


    if(this.getMaxHealth() > 20 && chestplateStack.getItem() == Items.AIR) {
      this.removeStatusEffect(StatusEffects.HEALTH_BOOST);
    }
  }
}
