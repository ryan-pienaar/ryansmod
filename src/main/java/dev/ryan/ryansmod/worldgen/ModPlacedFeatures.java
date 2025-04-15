package dev.ryan.ryansmod.worldgen;

import dev.ryan.ryansmod.RyansMod;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;

import java.util.List;

public class ModPlacedFeatures {
    public static final ResourceKey<PlacedFeature> ZENITH_CRYSTAL_ORE_PLACED_KEY = registerKey("zenith_crystal_ore_placed");
    public static final ResourceKey<PlacedFeature> NETHER_ZENITH_CRYSTAL_PLACED_KEY = registerKey("nether_zenith_crystal_placed");
    public static final ResourceKey<PlacedFeature> END_ZENITH_CRYSTAL_PLACED_KEY = registerKey("end_zenith_crystal_placed");

    public static final ResourceKey<PlacedFeature> BOEREWORS_ORE_PLACED_KEY = registerKey("boerewors_ore_placed");
    public static final ResourceKey<PlacedFeature> NETHER_BOEREWORS_PLACED_KEY = registerKey("nether_boerewors_placed");
    public static final ResourceKey<PlacedFeature> END_BOEREWORS_PLACED_KEY = registerKey("end_boerewors_placed");

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, ZENITH_CRYSTAL_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_ZENITH_CRYSTAL_ORE_KEY),
                ModOrePlacement.commonOrePlacement(7,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(80))));
        register(context, NETHER_ZENITH_CRYSTAL_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.NETHER_ZENITH_CRYSTAL_ORE_KEY),
                ModOrePlacement.commonOrePlacement(7,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(80))));
        register(context, END_ZENITH_CRYSTAL_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.END_ZENITH_CRYSTAL_ORE_KEY),
                ModOrePlacement.commonOrePlacement(7,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(80))));

        register(context, BOEREWORS_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_BOEREWORS_ORE_KEY),
                ModOrePlacement.commonOrePlacement(12,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(80))));
        register(context, NETHER_BOEREWORS_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.NETHER_BOEREWORS_ORE_KEY),
                ModOrePlacement.commonOrePlacement(12,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(80))));
        register(context, END_BOEREWORS_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.END_BOEREWORS_ORE_KEY),
                ModOrePlacement.commonOrePlacement(12,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(80))));
    }


    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(RyansMod.MOD_ID, name));
    }

    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
