package pl.notpiotrekdev.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.TntBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.text.TextColor;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class DynamiteBlock extends TntBlock {
    public DynamiteBlock(Settings settings) {
        super(settings);
    }

    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        LightningEntity lightning = new LightningEntity(EntityType.LIGHTNING_BOLT, world);
        lightning.setPosition(pos.getX(), pos.getY(), pos.getZ());
        lightning.setCosmetic(true);
        world.spawnEntity(lightning);
        world.createExplosion(null, pos.getX(), pos.getY(), pos.getZ(), 9f, World.ExplosionSourceType.TNT);
    }

    @Override
    public void onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        world.createExplosion(null, pos.getX(), pos.getY(), pos.getZ(), 9f, World.ExplosionSourceType.TNT);
    }

    @Override
    public void neighborUpdate(BlockState state, World world, BlockPos pos, Block sourceBlock, BlockPos sourcePos, boolean notify) {
        boolean powered = world.isReceivingRedstonePower(pos);
        if (powered) {
            world.createExplosion(null, pos.getX(), pos.getY(), pos.getZ(), 10f, World.ExplosionSourceType.TNT);
        }

        super.neighborUpdate(state, world, pos, sourceBlock, sourcePos, notify);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable BlockView world, List<Text> tooltip, TooltipType options) {
        tooltip.add(Text.translatable("tooltip.customexplosives.dynamite_block.tooltip"));
        super.appendTooltip(stack, world, tooltip, options);
    }
}
