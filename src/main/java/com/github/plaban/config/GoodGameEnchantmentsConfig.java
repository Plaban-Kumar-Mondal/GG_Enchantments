package com.github.plaban.config;


import com.github.plaban.MainFile;
import me.sargunvohra.mcmods.autoconfig1u.ConfigData;
import me.sargunvohra.mcmods.autoconfig1u.annotation.Config;
import me.sargunvohra.mcmods.autoconfig1u.shadowed.blue.endless.jankson.Comment;

@Config(name = MainFile.MOD_ID)
public class GoodGameEnchantmentsConfig implements ConfigData {
  @Comment("Enable Fire in Make BOOM Enchantment")
  public boolean enableFireInMakeBOOM = true;
}
