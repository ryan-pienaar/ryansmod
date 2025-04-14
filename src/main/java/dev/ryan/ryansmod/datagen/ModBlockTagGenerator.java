package dev.ryan.ryansmod.datagen;

import dev.ryan.ryansmod.RyansMod;
import dev.ryan.ryansmod.block.ModBlocks;
import dev.ryan.ryansmod.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.ForgeBlockTagsProvider;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {


    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, RyansMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {

        this.tag(ModTags.Blocks.ORE_DETECTOR_VALUABLES)
                .add(ModBlocks.ZENITH_CRYSTAL_ORE.get())
                .addTags(Tags.Blocks.ORES);

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(

                ModBlocks.ZENITH_CRYSTAL_ORE.get(),
                ModBlocks.DEEPSLATE_ZENITH_CRYSTAL_ORE.get(),
                ModBlocks.NETHER_ZENITH_CRYSTAL_ORE.get(),
                ModBlocks.END_STONE_ZENITH_CRYSTAL_ORE.get(),
                ModBlocks.ZENITH_CRYSTAL_BLOCK.get(),
                ModBlocks.RAW_ZENITH_CRYSTAL_BLOCK.get(),
                ModBlocks.BOEREWORS_ORE.get(),
                ModBlocks.DEEPSLATE_BOEREWORS_ORE.get(),
                ModBlocks.NETHER_BOEREWORS_ORE.get(),
                ModBlocks.END_STONE_BOEREWORS_ORE.get()

        );

        this.tag(BlockTags.NEEDS_STONE_TOOL);

        this.tag(BlockTags.NEEDS_IRON_TOOL);

        this.tag(BlockTags.NEEDS_DIAMOND_TOOL);

        this.tag(Tags.Blocks.NEEDS_NETHERITE_TOOL).add(
                ModBlocks.ZENITH_CRYSTAL_ORE.get(),
                ModBlocks.DEEPSLATE_ZENITH_CRYSTAL_ORE.get(),
                ModBlocks.NETHER_ZENITH_CRYSTAL_ORE.get(),
                ModBlocks.END_STONE_ZENITH_CRYSTAL_ORE.get(),
                ModBlocks.ZENITH_CRYSTAL_BLOCK.get(),
                ModBlocks.RAW_ZENITH_CRYSTAL_BLOCK.get()
        );
        this.tag(ModTags.Blocks.NEEDS_ZENITH_CRYSTAL_TOOL).add(
                ModBlocks.BOEREWORS_ORE.get(),
                ModBlocks.DEEPSLATE_BOEREWORS_ORE.get(),
                ModBlocks.NETHER_BOEREWORS_ORE.get(),
                ModBlocks.END_STONE_BOEREWORS_ORE.get()
        );


    }
}
