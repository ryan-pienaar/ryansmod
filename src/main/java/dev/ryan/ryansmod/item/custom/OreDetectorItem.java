package dev.ryan.ryansmod.item.custom;

import dev.ryan.ryansmod.block.ModBlocks;
import dev.ryan.ryansmod.util.ModTags;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class OreDetectorItem extends Item {

    public OreDetectorItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        if (!pContext.getLevel().isClientSide()) {
            BlockPos pos = pContext.getClickedPos();
            Player player = pContext.getPlayer();
            boolean foundBlock = false;

            for (int i = 0; i < pos.getY() + 64; i++) {
                BlockState state = pContext.getLevel().getBlockState(pos.below(i));

                if (isValuableBlock(state)) {
                    foundBlock = true;
                    outputValuableBlock(pos.below(i), player, state);
                    break;
                }
            }
            if (!foundBlock) {
                player.sendSystemMessage(Component.literal("No valuable blocks found below."));
            }
        }

        pContext.getItemInHand().hurtAndBreak(1, pContext.getPlayer(),
                player -> player.broadcastBreakEvent(player.getUsedItemHand()));


        return InteractionResult.SUCCESS;
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("tooltip.ryansmod.ore_detector.tooltip"));
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }

    private void outputValuableBlock(BlockPos below, Player player, BlockState state) {
        player.sendSystemMessage(Component.literal("Found a valuable block: " + state.getBlock().getName().getString()));
    }

    private boolean isValuableBlock(BlockState state) {
        return state.is(ModTags.Blocks.ORE_DETECTOR_VALUABLES);
    }
}
