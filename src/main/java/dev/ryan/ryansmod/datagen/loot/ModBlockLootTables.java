package dev.ryan.ryansmod.datagen.loot;

import dev.ryan.ryansmod.block.ModBlocks;
import dev.ryan.ryansmod.item.ModItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.ZENITH_CRYSTAL_BLOCK.get());
        this.dropSelf(ModBlocks.RAW_ZENITH_CRYSTAL_BLOCK.get());

        this.add(ModBlocks.ZENITH_CRYSTAL_ORE.get(),
            block -> createZenithCrystalOreDrops(ModBlocks.ZENITH_CRYSTAL_ORE.get(), ModItems.RAW_ZENITH_CRYSTAL.get())
        );

        this.add(ModBlocks.DEEPSLATE_ZENITH_CRYSTAL_ORE.get(),
                block -> createZenithCrystalOreDrops(ModBlocks.DEEPSLATE_ZENITH_CRYSTAL_ORE.get(), ModItems.RAW_ZENITH_CRYSTAL.get())
        );

        this.add(ModBlocks.NETHER_ZENITH_CRYSTAL_ORE.get(),
                block -> createZenithCrystalOreDrops(ModBlocks.NETHER_ZENITH_CRYSTAL_ORE.get(), ModItems.RAW_ZENITH_CRYSTAL.get())
        );

        this.add(ModBlocks.END_STONE_ZENITH_CRYSTAL_ORE.get(),
                block -> createZenithCrystalOreDrops(ModBlocks.END_STONE_ZENITH_CRYSTAL_ORE.get(), ModItems.RAW_ZENITH_CRYSTAL.get())
        );

        this.add(ModBlocks.BOEREWORS_ORE.get(),
                block -> createBoereworsOreDrops(ModBlocks.BOEREWORS_ORE.get(), ModItems.RAW_BOEREWORS.get())
        );

        this.add(ModBlocks.DEEPSLATE_BOEREWORS_ORE.get(),
                block -> createBoereworsOreDrops(ModBlocks.DEEPSLATE_BOEREWORS_ORE.get(), ModItems.RAW_BOEREWORS.get())
        );

        this.add(ModBlocks.NETHER_BOEREWORS_ORE.get(),
                block -> createBoereworsOreDrops(ModBlocks.NETHER_BOEREWORS_ORE.get(), ModItems.RAW_BOEREWORS.get())
        );

        this.add(ModBlocks.END_STONE_BOEREWORS_ORE.get(),
                block -> createBoereworsOreDrops(ModBlocks.END_STONE_BOEREWORS_ORE.get(), ModItems.RAW_BOEREWORS.get())
        );
    }

    protected LootTable.Builder createZenithCrystalOreDrops(Block pBlock, Item pItem) {
        return createSilkTouchDispatchTable(pBlock, this.applyExplosionDecay(pBlock, LootItem.lootTableItem(pItem)
                .apply(SetItemCountFunction
                        .setCount(UniformGenerator.between(1.0F, 3.0F)))
                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE)))
        );
    }

    protected LootTable.Builder createBoereworsOreDrops(Block pBlock, Item pItem) {
        return createSilkTouchDispatchTable(pBlock, this.applyExplosionDecay(pBlock, LootItem.lootTableItem(pItem)
                .apply(SetItemCountFunction
                        .setCount(UniformGenerator.between(2.0F, 5.0F)))
                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE)))
        );
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
