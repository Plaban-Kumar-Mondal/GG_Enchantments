package com.github.plaban;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;


public class CombatHealEnchantment extends Enchantment {
     protected CombatHealEnchantment(Rarity weight, EnchantmentTarget type, EquipmentSlot[] slotTypes) {
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
    public boolean isAvailableForEnchantedBookOffer() {
        return true;
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {

         // looking if the target isn't minecart, chest etc.
         if(target instanceof LivingEntity) {
             if(target instanceof HostileEntity) {
                 if(level == 1) {
                     user.heal(0.25f);
                 } else if(level == 2) {
                     user.heal(0.50f);
                 } else if(level == 3) {
                     user.heal(0.75f);
                 } else {
                     user.heal(1.00f);
                 }
             }
        }
    }

    @Override
    public Text getName(int level) {
        return super.getName(level).shallowCopy().formatted(Formatting.GREEN);
    }
}
