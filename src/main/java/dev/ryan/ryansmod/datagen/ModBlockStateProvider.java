package dev.ryan.ryansmod.datagen;

import dev.ryan.ryansmod.RyansMod;
import dev.ryan.ryansmod.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, RyansMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.ZENITH_CRYSTAL_BLOCK);
        blockWithItem(ModBlocks.RAW_ZENITH_CRYSTAL_BLOCK);
        blockWithItem(ModBlocks.ZENITH_CRYSTAL_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_ZENITH_CRYSTAL_ORE);
        blockWithItem(ModBlocks.NETHER_ZENITH_CRYSTAL_ORE);
        blockWithItem(ModBlocks.END_STONE_ZENITH_CRYSTAL_ORE);

        blockWithItem(ModBlocks.BOEREWORS_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_BOEREWORS_ORE);
        blockWithItem(ModBlocks.NETHER_BOEREWORS_ORE);
        blockWithItem(ModBlocks.END_STONE_BOEREWORS_ORE);
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
