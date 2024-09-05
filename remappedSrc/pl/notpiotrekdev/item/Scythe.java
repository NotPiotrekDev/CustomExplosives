package pl.notpiotrekdev.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

public class Scythe extends SwordItem {

    public Scythe(ToolMaterial toolMaterial, net.minecraft.item.Item.Settings settings) {
        super(toolMaterial, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (target instanceof PlayerEntity player) {
            if (!player.hasStatusEffect(StatusEffects.WITHER)) {
                player.sendMessage(Text.literal("You feel a little strange..").formatted(Formatting.DARK_GRAY), true);
            }
        }
        target.addStatusEffect(new StatusEffectInstance(StatusEffects.WITHER, 200, 1, true, true), attacker);
        return super.postHit(stack, target, attacker);
    }
}
