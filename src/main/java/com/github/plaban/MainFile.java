package com.github.plaban;

import com.github.plaban.config.GoodGameEnchantmentsConfig;
import com.github.plaban.enchantment.EnchantmentRegister;
import me.sargunvohra.mcmods.autoconfig1u.AutoConfig;
import me.sargunvohra.mcmods.autoconfig1u.serializer.GsonConfigSerializer;
import net.fabricmc.api.ModInitializer;


public class MainFile implements ModInitializer {
    public static final String MOD_ID = "gg_enchantments";
    @Override
    public void onInitialize() {
        //Config File
        AutoConfig.register(GoodGameEnchantmentsConfig.class, GsonConfigSerializer::new);

        EnchantmentRegister.registerEnchantment(MOD_ID);
    }
}



