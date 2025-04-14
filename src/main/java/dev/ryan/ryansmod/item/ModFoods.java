package dev.ryan.ryansmod.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties COOKED_BOEREWORS = (new FoodProperties.Builder())
            .nutrition(4)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 200), 0.5f)
            .saturationMod(0.8f)
            .meat()
            .build();

    public static final FoodProperties BOEREWORS_ROLL = (new FoodProperties.Builder())
            .nutrition(8)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 200), 0.5f)
            .saturationMod(2.0f)
            .meat()
            .build();

    public static final FoodProperties RAW_BOEREWORS = (new FoodProperties.Builder())
            .nutrition(1)
            .effect(() -> new MobEffectInstance(MobEffects.WEAKNESS, 300), 0.5f)
            .saturationMod(0f)
            .meat()
            .build();
}
