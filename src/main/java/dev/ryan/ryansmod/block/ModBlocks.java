package dev.ryan.ryansmod.block;

import dev.ryan.ryansmod.RyansMod;
import dev.ryan.ryansmod.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, RyansMod.MOD_ID);

    public static final RegistryObject<Block> ZENITH_CRYSTAL_BLOCK = register("zenith_crystal_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OBSIDIAN).sound(SoundType.AMETHYST)));

    public static final RegistryObject<Block> RAW_ZENITH_CRYSTAL_BLOCK = register("raw_zenith_crystal_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK)));

    private static <T extends Block> RegistryObject<T> register(final String name, final Supplier<T> block) {
        RegistryObject<T> blockObj = BLOCKS.register(name, block);
        registerBlockItem(name, blockObj);
        return blockObj;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
