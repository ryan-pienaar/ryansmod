package dev.ryan.ryansmod.item;

import dev.ryan.ryansmod.RyansMod;
import dev.ryan.ryansmod.item.custom.OreDetectorItem;
import net.minecraft.world.item.*;
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

    public static final RegistryObject<Item> ORE_DETECTOR = ITEMS.register("ore_detector",
            () -> new OreDetectorItem(new Item.Properties().durability(150)));

    //Boerewors
    public static final RegistryObject<Item> RAW_BOEREWORS = ITEMS.register("raw_boerewors",
            () -> new Item(new Item.Properties().food(ModFoods.RAW_BOEREWORS)));

    //Cooked Boerewors
    public static final RegistryObject<Item> COOKED_BOEREWORS = ITEMS.register("cooked_boerewors",
            () -> new Item(new Item.Properties().food(ModFoods.COOKED_BOEREWORS)));

    //Boerewors Roll
    public static final RegistryObject<Item> BOEREWORS_ROLL = ITEMS.register("boerewors_roll",
            () -> new Item(new Item.Properties().food(ModFoods.BOEREWORS_ROLL)));

    public static final RegistryObject<Item> ZENITH_CRYSTAL_SWORD = ITEMS.register("zenith_crystal_sword",
            () -> new SwordItem(ModToolTiers.ZENITH_CRYSTAL, 11,2.0F, new Item.Properties()));

    public static final RegistryObject<Item> ZENITH_CRYSTAL_PICKAXE = ITEMS.register("zenith_crystal_pickaxe",
            () -> new PickaxeItem(ModToolTiers.ZENITH_CRYSTAL, 4,1.0F, new Item.Properties()));

    public static final RegistryObject<Item> ZENITH_CRYSTAL_AXE = ITEMS.register("zenith_crystal_axe",
            () -> new AxeItem(ModToolTiers.ZENITH_CRYSTAL, 7,1.5F, new Item.Properties()));

    public static final RegistryObject<Item> ZENITH_CRYSTAL_SHOVEL = ITEMS.register("zenith_crystal_shovel",
            () -> new ShovelItem(ModToolTiers.ZENITH_CRYSTAL, 4,1.0F, new Item.Properties()));

    public static final RegistryObject<Item> ZENITH_CRYSTAL_HOE = ITEMS.register("zenith_crystal_hoe",
            () -> new HoeItem(ModToolTiers.ZENITH_CRYSTAL, 3,1.0F, new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
