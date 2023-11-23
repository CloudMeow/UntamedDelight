package cloudmeow.untameddelight;

import cloudmeow.untameddelight.registry.UDEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import vectorwing.farmersdelight.common.registry.ModEffects;

public class UDFoodValues {
    public static final FoodProperties STEAMED_KING_CRAB = (new FoodProperties.Builder())
            .nutrition(14).saturationMod(0.6f)
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), 6000, 0), 1.0F).build();
    public static final FoodProperties STEAMED_KING_CRAB_LEGS = (new FoodProperties.Builder())
            .nutrition(10).saturationMod(0.6f)
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), 6000, 0), 1.0F).build();
    public static final FoodProperties STEAMED_EGG_WITH_KING_CRAB_ROE = (new FoodProperties.Builder())
            .nutrition(7).saturationMod(0.75f)
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), 2400, 0), 1.0F).build();
    public static final FoodProperties SOUR_SUNFISH_BROTH = (new FoodProperties.Builder())
            .nutrition(10).saturationMod(0.9f)
            .effect(() -> new MobEffectInstance(ModEffects.COMFORT.get(), 6000, 0), 1.0F)
            .effect(() -> new MobEffectInstance(UDEffects.MOMORA_MORA.get(), 6000, 0), 1.0F).build();
    public static final FoodProperties DONER_KEBAB = (new FoodProperties.Builder())
            .nutrition(9).saturationMod(0.75f).build();

    public static final FoodProperties CATFISH = (new FoodProperties.Builder())
            .nutrition(3).saturationMod(0.3f).build();
    public static final FoodProperties COOKED_CATFISH = (new FoodProperties.Builder())
            .nutrition(6).saturationMod(0.4f).build();
    public static final FoodProperties FOOTBALL_FISH = (new FoodProperties.Builder())
            .nutrition(2).saturationMod(0.3f).build();
    public static final FoodProperties COOKED_FOOTBALL_FISH = (new FoodProperties.Builder())
            .nutrition(6).saturationMod(0.5f).build();
    public static final FoodProperties SPADEFISH = (new FoodProperties.Builder())
            .nutrition(2).saturationMod(0.4f).build();
    public static final FoodProperties COOKED_SPADEFISH = (new FoodProperties.Builder())
            .nutrition(6).saturationMod(0.5f).build();
    public static final FoodProperties SUNFISH = (new FoodProperties.Builder())
            .nutrition(6).saturationMod(0.5f).build();
    public static final FoodProperties COOKED_SUNFISH = (new FoodProperties.Builder())
            .nutrition(10).saturationMod(0.7f).build();
    public static final FoodProperties TREVALLY = (new FoodProperties.Builder())
            .nutrition(3).saturationMod(0.3f).build();
    public static final FoodProperties COOKED_TREVALLY = (new FoodProperties.Builder())
            .nutrition(7).saturationMod(0.5f).build();
    public static final FoodProperties TRIGGERFISH = (new FoodProperties.Builder())
            .nutrition(2).saturationMod(0.3f).build();
    public static final FoodProperties COOKED_TRIGGERFISH = (new FoodProperties.Builder())
            .nutrition(5).saturationMod(0.5f).build();
    public static final FoodProperties AROWANA = (new FoodProperties.Builder())
            .nutrition(3).saturationMod(0.3f).build();
    public static final FoodProperties COOKED_AROWANA = (new FoodProperties.Builder())
            .nutrition(8).saturationMod(0.8f).build();
    public static final FoodProperties SLICED_BEAR = (new FoodProperties.Builder())
            .nutrition(2).saturationMod(0.4f).meat().fast().build();
    public static final FoodProperties BEAR_STEAK = (new FoodProperties.Builder())
            .nutrition(4).saturationMod(1.0f).meat().fast().build();
    public static final FoodProperties BOAR_CHOP = (new FoodProperties.Builder())
            .nutrition(3).saturationMod(0.3f).meat().build();
    public static final FoodProperties COOKED_BOAR_CHOP = (new FoodProperties.Builder())
            .nutrition(6).saturationMod(0.7f).meat().build();
    public static final FoodProperties BISON_MEAT = (new FoodProperties.Builder())
            .nutrition(3).saturationMod(0.3f).meat().build();
    public static final FoodProperties COOKED_BISON_MEAT = (new FoodProperties.Builder())
            .nutrition(6).saturationMod(0.7f).meat().build();
    public static final FoodProperties CAMEL_MEAT = (new FoodProperties.Builder())
            .nutrition(4).saturationMod(0.3f).meat().build();
    public static final FoodProperties COOKED_CAMEL_MEAT = (new FoodProperties.Builder())
            .nutrition(7).saturationMod(0.7f).meat().build();

    public static final FoodProperties CAMEL_MEAT_KARAHI = (new FoodProperties.Builder())
            .nutrition(12).saturationMod(0.65f)
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), 4800, 0), 1.0F).build();
    public static final FoodProperties GALICIAN_STYLE_FOOTBALL_FISH = (new FoodProperties.Builder())
            .nutrition(13).saturationMod(0.8f)
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), 4800, 0), 1.0F).build();
    public static final FoodProperties GOLDEN_AROWANA = (new FoodProperties.Builder())
            .nutrition(12).saturationMod(0.75f)
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 100, 0), 1.0F)
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), 4800, 0), 1.0F).build();
    public static final FoodProperties SEARED_TRIGGERFISH = (new FoodProperties.Builder())
            .nutrition(16).saturationMod(0.8f)
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), 9600, 0), 1.0F).build();
    public static final FoodProperties PASTA_BISON = (new FoodProperties.Builder())
            .nutrition(12).saturationMod(0.8f)
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), 3600, 0), 1.0F).build();
    public static final FoodProperties BOAR_STEW = (new FoodProperties.Builder())
            .nutrition(13).saturationMod(0.8f)
            .effect(() -> new MobEffectInstance(ModEffects.COMFORT.get(), 6000, 0), 1.0F).build();
    public static final FoodProperties BAKED_CHEESE_TREVALLY = (new FoodProperties.Builder())
            .nutrition(14).saturationMod(0.65f)
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), 6000, 0), 1.0F).build();
    public static final FoodProperties TREVALLY_TATAKI = (new FoodProperties.Builder())
            .nutrition(4).saturationMod(1.0f).build();
    public static final FoodProperties SPICY_CATFISH = (new FoodProperties.Builder())
            .nutrition(9).saturationMod(0.7f).build();
    public static final FoodProperties GLAZED_SPADEFISH = (new FoodProperties.Builder())
            .nutrition(12).saturationMod(0.75f)
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), 4800, 0), 1.0F).build();
    public static final FoodProperties BEAR_SANDWICH = (new FoodProperties.Builder())
            .nutrition(11).saturationMod(0.8f)
            .effect(() -> new MobEffectInstance(UDEffects.BEAR_POWER.get(), 2400, 0), 1.0F).build();
    public static final FoodProperties BOAR_HAMBURGER = (new FoodProperties.Builder())
            .nutrition(12).saturationMod(0.75f).build();
    public static final FoodProperties VIETNAMESE_BLACK_BEAR_PATE_CHAUD = (new FoodProperties.Builder())
            .nutrition(12).saturationMod(0.7f)
            .effect(() -> new MobEffectInstance(UDEffects.BEAR_POWER.get(), 1800, 0), 1.0F).build();
    public static final FoodProperties MARINE_BARBECUE_STICK = (new FoodProperties.Builder())
            .nutrition(11).saturationMod(0.8f).build();
    public static final FoodProperties BISON_PIZZA_SLICE = (new FoodProperties.Builder())
            .nutrition(3).saturationMod(1.0f).build();
    public static final FoodProperties FRIED_SEA_ANEMONE = (new FoodProperties.Builder())
            .nutrition(10).saturationMod(0.8f)
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), 3600, 0), 1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.WATER_BREATHING, 3600, 0), 1.0F).build();
    public static final FoodProperties SWEET_ZONGZI = (new FoodProperties.Builder())
            .nutrition(7).saturationMod(0.6f)
            .effect(() -> new MobEffectInstance(ModEffects.COMFORT.get(), 2400, 0), 1.0F).build();
    public static final FoodProperties YOLK_PORK_ZONGZI = (new FoodProperties.Builder())
            .nutrition(13).saturationMod(0.6f)
            .effect(() -> new MobEffectInstance(ModEffects.COMFORT.get(), 4800, 0), 1.0F).build();
    public static final FoodProperties SUNFISH_SLICE = (new FoodProperties.Builder())
            .nutrition(1).saturationMod(0.1f).fast().build();
    public static final FoodProperties COOKED_SUNFISH_SLICE = (new FoodProperties.Builder())
            .nutrition(2).saturationMod(0.5f).fast().build();
    public static final FoodProperties TREVALLY_SLICE = (new FoodProperties.Builder())
            .nutrition(1).saturationMod(0.1f).fast().build();
    public static final FoodProperties COOKED_TREVALLY_SLICE = (new FoodProperties.Builder())
            .nutrition(2).saturationMod(0.5f).fast().build();
    public static final FoodProperties SMOKED_CATFISH = (new FoodProperties.Builder())
            .nutrition(7).saturationMod(0.6f).build();
}
