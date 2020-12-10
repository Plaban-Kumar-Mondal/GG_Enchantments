package com.github.plaban.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityGroup;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

public class BaneOfIllagerEnchantment extends Enchantment {
    protected BaneOfIllagerEnchantment(Rarity weight, EnchantmentTarget type, EquipmentSlot[] slotTypes) {
        super(weight, type, slotTypes);
    }

    @Override
    public int getMinPower(int level) {
        return 1 + 10 * (level - 1);
    }

    @Override
    public int getMaxLevel() {
        return 5;
    }

    @Override
    public float getAttackDamage(int level, EntityGroup group) {
        if(group == EntityGroup.ILLAGER) {
            return 1.5f*level;
        } else {
            return 0f;
        }
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        if(target instanceof LivingEntity) {
            if(((LivingEntity) target).getGroup() == EntityGroup.ILLAGER){
                int time = 40 + user.getRandom().nextInt(10 * level);
                ((LivingEntity) target).applyStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, time, 3));
            }
        }
    }

    @Override
    public Text getName(int level) {
        return super.getName(level).shallowCopy().formatted(Formatting.GREEN);
    }
}
