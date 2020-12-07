package com.github.plaban;


import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EntityGroup;
import net.minecraft.entity.EquipmentSlot;

public class PokeEnchantment extends Enchantment {
    protected PokeEnchantment(Rarity weight, EnchantmentTarget type, EquipmentSlot[] slotTypes) {
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
    public float getAttackDamage(int level, EntityGroup group) {
        return (1.5f*level)+0.5f;
    }


}
