package eu.pb4.polyfactory.mixin;

import org.spongepowered.asm.mixin.gen.Invoker;

@org.spongepowered.asm.mixin.Mixin(net.minecraft.world.entity.Entity.class)
public interface EntityAccessor {
    @Invoker
    boolean callOmnidirectionalAirMover();
}
