package com.github.plaban.modmenu;

import com.github.plaban.config.GoodGameEnchantmentsConfig;
import io.github.prospector.modmenu.api.ConfigScreenFactory;
import io.github.prospector.modmenu.api.ModMenuApi;
import me.sargunvohra.mcmods.autoconfig1u.AutoConfig;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.Screen;

@Environment(EnvType.CLIENT)
public class GoodGameEnchantmentsMenuIntegration implements ModMenuApi {
  @Override
  public ConfigScreenFactory<?> getModConfigScreenFactory() {
    return parent -> (Screen) AutoConfig.getConfigScreen(GoodGameEnchantmentsConfig.class, parent);
  }
}
