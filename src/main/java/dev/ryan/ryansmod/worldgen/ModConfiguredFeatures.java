package dev.ryan.ryansmod.worldgen;

import dev.ryan.ryansmod.RyansMod;
import dev.ryan.ryansmod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class ModConfiguredFeatures {

    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_ZENITH_CRYSTAL_ORE_KEY = registerKey("boerewors_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> NETHER_ZENITH_CRYSTAL_ORE_KEY = registerKey("nether_boerewors_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> END_ZENITH_CRYSTAL_ORE_KEY = registerKey("end_boerewors_ore");

    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_BOEREWORS_ORE_KEY = registerKey("zenith_crystal_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> NETHER_BOEREWORS_ORE_KEY = registerKey("nether_zenith_crystal_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> END_BOEREWORS_ORE_KEY = registerKey("end_zenith_crystal_ore");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplaceable = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceable = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherrackReplaceable = new BlockMatchTest(Blocks.NETHERRACK);
        RuleTest endStoneReplaceable = new BlockMatchTest(Blocks.END_STONE);

        List<OreConfiguration.TargetBlockState> overworldZenithCrystalOres = List.of(
                OreConfiguration.target(stoneReplaceable, ModBlocks.ZENITH_CRYSTAL_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceable, ModBlocks.DEEPSLATE_ZENITH_CRYSTAL_ORE.get().defaultBlockState())
        );

        List<OreConfiguration.TargetBlockState> overworldBoereworsOres = List.of(
                OreConfiguration.target(stoneReplaceable, ModBlocks.BOEREWORS_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceable, ModBlocks.DEEPSLATE_BOEREWORS_ORE.get().defaultBlockState())
        );

        register(context, OVERWORLD_ZENITH_CRYSTAL_ORE_KEY, Feature.ORE, new OreConfiguration(overworldZenithCrystalOres, 7));
        register(context, NETHER_ZENITH_CRYSTAL_ORE_KEY, Feature.ORE, new OreConfiguration(netherrackReplaceable, ModBlocks.NETHER_ZENITH_CRYSTAL_ORE.get().defaultBlockState(), 4));
        register(context, END_ZENITH_CRYSTAL_ORE_KEY, Feature.ORE, new OreConfiguration(endStoneReplaceable, ModBlocks.END_STONE_ZENITH_CRYSTAL_ORE.get().defaultBlockState(), 4));

        register(context, OVERWORLD_BOEREWORS_ORE_KEY, Feature.ORE, new OreConfiguration(overworldBoereworsOres, 7));
        register(context, NETHER_BOEREWORS_ORE_KEY, Feature.ORE, new OreConfiguration(netherrackReplaceable, ModBlocks.NETHER_BOEREWORS_ORE.get().defaultBlockState(), 7));
        register(context, END_BOEREWORS_ORE_KEY, Feature.ORE, new OreConfiguration(endStoneReplaceable, ModBlocks.END_STONE_BOEREWORS_ORE.get().defaultBlockState(), 7));
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(RyansMod.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
