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
            () -> new ZenithCrystalOreDetectorItem(new Item.Properties().durability(150)));

    //Boerewors
    public static final RegistryObject<Item> RAW_BOEREWORS = ITEMS.register("raw_boerewors",
            () -> new Item(new Item.Properties()));

    //Cooked Boerewors
    public static final RegistryObject<Item> COOKED_BOEREWORS = ITEMS.register("cooked_boerewors",
            () -> new Item(new Item.Properties()));

    //Boerewors Roll
    public static final RegistryObject<Item> BOEREWORS_ROLL = ITEMS.register("boerewors_roll",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
