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

    public Scythe(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (target instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) target;
            if (!player.hasStatusEffect(StatusEffects.WITHER)) {
                player.sendMessage(Text.literal("You feel a little strange..").formatted(Formatting.DARK_GRAY), true);
            }
        }
        target.addStatusEffect(new StatusEffectInstance(StatusEffects.WITHER, 200, 1, true, true), attacker);
        return super.postHit(stack, target, attacker);
    }
}
