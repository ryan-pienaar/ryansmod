package dev.ryan.ryansmod.block;

import dev.ryan.ryansmod.RyansMod;
import dev.ryan.ryansmod.item.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
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

    // Block of Zenith Crystal
    public static final RegistryObject<Block> ZENITH_CRYSTAL_BLOCK = register("zenith_crystal_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK).sound(SoundType.AMETHYST)));

    // Block of Raw Zenith Crystal
    public static final RegistryObject<Block> RAW_ZENITH_CRYSTAL_BLOCK = register("raw_zenith_crystal_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OBSIDIAN)));

    // Zenith Crystal Ore
    public static final RegistryObject<Block> ZENITH_CRYSTAL_ORE = register("zenith_crystal_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(50f)
                    .requiresCorrectToolForDrops(), UniformInt.of(14, 28)
            ));

    // Deepslate Zenith Crystal Ore
    public static final RegistryObject<Block> DEEPSLATE_ZENITH_CRYSTAL_ORE = register("deepslate_zenith_crystal_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE)
                    .strength(40f)
                    .requiresCorrectToolForDrops(), UniformInt.of(12, 24)
            ));

    // Nether Zenith Crystal Ore
    public static final RegistryObject<Block> NETHER_ZENITH_CRYSTAL_ORE = register("nether_zenith_crystal_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.NETHERRACK)
                    .strength(40f)
                    .requiresCorrectToolForDrops(), UniformInt.of(12, 24)
            ));

    // End Stone Zenith Crystal Ore
    public static final RegistryObject<Block> END_STONE_ZENITH_CRYSTAL_ORE = register("end_stone_zenith_crystal_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.END_STONE)
                    .strength(50f)
                    .requiresCorrectToolForDrops(), UniformInt.of(14, 28)
            ));

    // Raw Boerewors Block
    public static final RegistryObject<Block> RAW_BOEREWORS_BLOCK = register("raw_boerewors_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.BROWN_WOOL).sound(SoundType.WOOL)));

    // Cooked Boerewors Block
    public static final RegistryObject<Block> COOKED_BOEREWORS_BLOCK = register("cooked_boerewors_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.BROWN_WOOL).sound(SoundType.WOOL)));

    // Boerewors Roll Block
    public static final RegistryObject<Block> BOEREWORS_ROLL_BLOCK = register("boerewors_roll_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.BROWN_WOOL).sound(SoundType.WOOL)));

    // Boerewors Ore
    public static final RegistryObject<Block> BOEREWORS_ORE = register("boerewors_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(5f)
                    .requiresCorrectToolForDrops(), UniformInt.of(8, 16)
            ));

    // Deepslate Boerewors Ore
    public static final RegistryObject<Block> DEEPSLATE_BOEREWORS_ORE = register("deepslate_boerewors_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE)
                    .strength(4f)
                    .requiresCorrectToolForDrops(), UniformInt.of(6, 12)
            ));

    // Nether Boerewors Ore
    public static final RegistryObject<Block> NETHER_BOEREWORS_ORE = register("nether_boerewors_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.NETHERRACK)
                    .strength(4f)
                    .requiresCorrectToolForDrops(), UniformInt.of(6, 12)
            ));

    // End Stone Boerewors Ore
    public static final RegistryObject<Block> END_STONE_BOEREWORS_ORE = register("end_stone_boerewors_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.END_STONE)
                    .strength(5f)
                    .requiresCorrectToolForDrops(), UniformInt.of(8, 16)
            ));

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
