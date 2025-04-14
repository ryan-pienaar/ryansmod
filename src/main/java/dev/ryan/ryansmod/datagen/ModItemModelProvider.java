package dev.ryan.ryansmod.datagen;

import dev.ryan.ryansmod.RyansMod;
import dev.ryan.ryansmod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {

    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, RyansMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.ZENITH_CRYSTAL);
        simpleItem(ModItems.RAW_ZENITH_CRYSTAL);
        simpleItem(ModItems.ORE_DETECTOR);

        simpleItem(ModItems.BOEREWORS_ROLL);
        simpleItem(ModItems.RAW_BOEREWORS);
        simpleItem(ModItems.COOKED_BOEREWORS);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/generated")).texture("layer0",
                ResourceLocation.tryBuild(RyansMod.MOD_ID, "item/" + item.getId().getPath()));
    }
}
