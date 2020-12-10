package com.github.plaban;

import com.github.plaban.enchantment.EnchantmentRegister;
import net.fabricmc.api.ModInitializer;


public class MainFile implements ModInitializer {
    public static final String MOD_ID = "gg_enchantments";
    @Override
    public void onInitialize() {
        EnchantmentRegister.registerEnchantment(MOD_ID);
    }
}



