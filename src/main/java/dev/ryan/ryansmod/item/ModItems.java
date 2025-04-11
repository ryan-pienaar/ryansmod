package dev.ryan.ryansmod.item;

import dev.ryan.ryansmod.RyansMod;
import dev.ryan.ryansmod.item.custom.ZenithCrystalOreDetectorItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, RyansMod.MOD_ID);

    public static final RegistryObject<Item> ZENITH_CRYSTAL = ITEMS.register("zenith_crystal",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> RAW_ZENITH_CRYSTAL = ITEMS.register("raw_zenith_crystal",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> ZENITH_CRYSTAL_ORE_DETECTOR = ITEMS.register("zenith_crystal_ore_detector",
            () -> new ZenithCrystalOreDetectorItem(new Item.Properties().durability(100)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
