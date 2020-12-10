package com.github.plaban.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.*;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;

public class MakeBoomEnchantment extends Enchantment {
    protected MakeBoomEnchantment(Rarity weight, EnchantmentTarget type, EquipmentSlot[] slotTypes) {
        super(weight, type, slotTypes);
    }

    @Override
    public int getMinPower(int level) {
        return 20;
    }

    @Override
    public boolean isAvailableForEnchantedBookOffer() {
        return true;
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        if(target instanceof LivingEntity) {
            if(target instanceof HostileEntity) {
                World world = user.world;
                world.createExplosion(target, target.getX(), target.getY() + 1, target.getZ(), 1, true, Explosion.DestructionType.DESTROY);
                target.pushAwayFrom(user);
            }
        }
    }

    @Override
    public Text getName(int level) {
        return super.getName(level).shallowCopy().formatted(Formatting.GREEN);
    }
}
