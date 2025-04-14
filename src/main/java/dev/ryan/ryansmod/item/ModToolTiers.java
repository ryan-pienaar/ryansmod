package dev.ryan.ryansmod.item;

import dev.ryan.ryansmod.RyansMod;
import dev.ryan.ryansmod.util.ModTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;

public class ModToolTiers {
    public static final Tier ZENITH_CRYSTAL = TierSortingRegistry.registerTier(
            new ForgeTier(4, 1500, 5F, 4F, 5,
                    ModTags.Blocks.NEEDS_ZENITH_CRYSTAL_TOOL,
                    () -> Ingredient.of(ModItems.ZENITH_CRYSTAL.get())),
            ResourceLocation.fromNamespaceAndPath(RyansMod.MOD_ID, "zenith_crystal"), List.of(Tiers.NETHERITE), List.of());

}
