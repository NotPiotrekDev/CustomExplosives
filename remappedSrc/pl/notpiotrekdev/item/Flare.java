package pl.notpiotrekdev.item;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.DustParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.joml.Vector3f;
import pl.notpiotrekdev.CustomExplosives;

public class Flare extends Item {
    public Flare(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        Vector3f redColor = new Vector3f(210 / 255.0f, 43 / 255.0f, 43 / 255.0f);
        DustParticleEffect dustParticleEffect = new DustParticleEffect(redColor, 25.0f);
        double y;
        for (int i = 1; i <= 1500; i++) {
            y = user.getY() + i;
            world.addParticle(dustParticleEffect, user.getX(), y, user.getZ(), 0.2, 0.2, 0.2);
            world.addParticle(dustParticleEffect, user.getX(), y, user.getZ(), 0.2, 0.2, 0.2);
            world.addParticle(dustParticleEffect, user.getX(), y, user.getZ(), 0.2, 0.2, 0.2);
            world.addParticle(dustParticleEffect, user.getX(), y, user.getZ(), 0.2, 0.2, 0.2);

        }
        user.getStackInHand(hand).damage(1, user, playerEntity -> playerEntity.sendToolBreakStatus(playerEntity.getActiveHand()));

        return super.use(world, user, hand);
    }

}
