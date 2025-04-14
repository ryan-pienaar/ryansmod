package dev.ryan.ryansmod.item;

import dev.ryan.ryansmod.RyansMod;
import dev.ryan.ryansmod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, RyansMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> RYANS_MOD_TAB = CREATIVE_MODE_TABS.register("ryans_mod_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.COOKED_BOEREWORS.get()))
                    .title(Component.translatable("creativetab.ryans_mod_tab"))
                    .displayItems((pParameters, pOutput) -> {

                        // Add items to the creative tab
                        pOutput.accept(ModItems.ZENITH_CRYSTAL.get());
                        pOutput.accept(ModItems.RAW_ZENITH_CRYSTAL.get());
                        pOutput.accept(ModItems.ORE_DETECTOR.get());

                        //Boerewors items
                        pOutput.accept(ModItems.RAW_BOEREWORS.get());
                        pOutput.accept(ModItems.COOKED_BOEREWORS.get());
                        pOutput.accept(ModItems.BOEREWORS_ROLL.get());

                        // Add blocks to the creative tab
                        pOutput.accept(ModBlocks.ZENITH_CRYSTAL_BLOCK.get());
                        pOutput.accept(ModBlocks.RAW_ZENITH_CRYSTAL_BLOCK.get());
                        //pOutput.accept(ModBlocks.RAW_BOEREWORS_BLOCK.get());
                        //pOutput.accept(ModBlocks.COOKED_BOEREWORS_BLOCK.get());

                        // Add ores to the creative tab
                        pOutput.accept(ModBlocks.ZENITH_CRYSTAL_ORE.get());
                        pOutput.accept(ModBlocks.DEEPSLATE_ZENITH_CRYSTAL_ORE.get());
                        pOutput.accept(ModBlocks.NETHER_ZENITH_CRYSTAL_ORE.get());
                        pOutput.accept(ModBlocks.END_STONE_ZENITH_CRYSTAL_ORE.get());
                        pOutput.accept(ModBlocks.BOEREWORS_ORE.get());
                        pOutput.accept(ModBlocks.DEEPSLATE_BOEREWORS_ORE.get());
                        pOutput.accept(ModBlocks.NETHER_BOEREWORS_ORE.get());
                        pOutput.accept(ModBlocks.END_STONE_BOEREWORS_ORE.get());

                        // Add tools to the creative tab
                        pOutput.accept(ModItems.ZENITH_CRYSTAL_SWORD.get());
                        pOutput.accept(ModItems.ZENITH_CRYSTAL_PICKAXE.get());
                        pOutput.accept(ModItems.ZENITH_CRYSTAL_AXE.get());
                        pOutput.accept(ModItems.ZENITH_CRYSTAL_SHOVEL.get());
                        pOutput.accept(ModItems.ZENITH_CRYSTAL_HOE.get());

                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
