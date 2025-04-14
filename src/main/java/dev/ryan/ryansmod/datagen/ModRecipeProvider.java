package dev.ryan.ryansmod.datagen;

import dev.ryan.ryansmod.RyansMod;
import dev.ryan.ryansmod.block.ModBlocks;
import dev.ryan.ryansmod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    private static final List<ItemLike> ZENITH_CRYSTAL_SMELTABLES = List.of(
            ModItems.RAW_ZENITH_CRYSTAL.get(),
            ModBlocks.ZENITH_CRYSTAL_ORE.get(),
            ModBlocks.DEEPSLATE_ZENITH_CRYSTAL_ORE.get(),
            ModBlocks.NETHER_ZENITH_CRYSTAL_ORE.get(),
            ModBlocks.END_STONE_ZENITH_CRYSTAL_ORE.get()
    );

    private static final List<ItemLike> BOEREWORS_SMELTABLES = List.of(
            ModItems.RAW_BOEREWORS.get(),
            ModBlocks.BOEREWORS_ORE.get(),
            ModBlocks.DEEPSLATE_BOEREWORS_ORE.get(),
            ModBlocks.NETHER_BOEREWORS_ORE.get(),
            ModBlocks.END_STONE_BOEREWORS_ORE.get()
    );

    private static final List<ItemLike> ZENITH_CRYSTAL_BLASTABLES = List.of(
            ModItems.RAW_ZENITH_CRYSTAL.get(),
            ModBlocks.ZENITH_CRYSTAL_ORE.get(),
            ModBlocks.DEEPSLATE_ZENITH_CRYSTAL_ORE.get(),
            ModBlocks.NETHER_ZENITH_CRYSTAL_ORE.get(),
            ModBlocks.END_STONE_ZENITH_CRYSTAL_ORE.get()
    );

    private static final List<ItemLike> BOEREWORS_BLASTABLES = List.of(
            ModItems.RAW_BOEREWORS.get(),
            ModBlocks.BOEREWORS_ORE.get(),
            ModBlocks.DEEPSLATE_BOEREWORS_ORE.get(),
            ModBlocks.NETHER_BOEREWORS_ORE.get(),
            ModBlocks.END_STONE_BOEREWORS_ORE.get()
    );


    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        oreSmelting(pWriter, ZENITH_CRYSTAL_SMELTABLES, RecipeCategory.MISC, ModItems.ZENITH_CRYSTAL.get(), 1.4F, 150, "zenith_crystal");
        oreBlasting(pWriter, ZENITH_CRYSTAL_BLASTABLES, RecipeCategory.MISC, ModItems.ZENITH_CRYSTAL.get(), 1.4F, 200, "zenith_crystal");
        oreSmelting(pWriter, BOEREWORS_SMELTABLES, RecipeCategory.MISC, ModItems.COOKED_BOEREWORS.get(), 0.7F, 200, "boerewors");
        oreBlasting(pWriter, BOEREWORS_BLASTABLES, RecipeCategory.MISC, ModItems.COOKED_BOEREWORS.get(), 0.7F, 200, "boerewors");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.ZENITH_CRYSTAL_BLOCK.get())
                .pattern("ZZZ")
                .pattern("ZZZ")
                .pattern("ZZZ")
                .define('Z', ModItems.ZENITH_CRYSTAL.get())
                .unlockedBy(getHasName(ModItems.ZENITH_CRYSTAL.get()), has(ModItems.ZENITH_CRYSTAL.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.RAW_ZENITH_CRYSTAL_BLOCK.get())
                .pattern("ZZZ")
                .pattern("ZZZ")
                .pattern("ZZZ")
                .define('Z', ModItems.RAW_ZENITH_CRYSTAL.get())
                .unlockedBy(getHasName(ModItems.RAW_ZENITH_CRYSTAL.get()), has(ModItems.RAW_ZENITH_CRYSTAL.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.BOEREWORS_ROLL.get())
                .pattern("   ")
                .pattern(" B ")
                .pattern("R  ")
                .define('R', Items.BREAD)
                .define('B', ModItems.COOKED_BOEREWORS.get())
                .unlockedBy(getHasName(ModItems.COOKED_BOEREWORS.get()), has(ModItems.COOKED_BOEREWORS.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.ZENITH_CRYSTAL.get(), 9)
                .requires(ModBlocks.ZENITH_CRYSTAL_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.ZENITH_CRYSTAL_BLOCK.get()), has(ModBlocks.ZENITH_CRYSTAL_BLOCK.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.RAW_ZENITH_CRYSTAL.get(), 9)
                .requires(ModBlocks.RAW_ZENITH_CRYSTAL_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.RAW_ZENITH_CRYSTAL_BLOCK.get()), has(ModBlocks.RAW_ZENITH_CRYSTAL_BLOCK.get()))
                .save(pWriter);
    }

    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike)).save(pFinishedRecipeConsumer,  RyansMod.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }

    }
}
