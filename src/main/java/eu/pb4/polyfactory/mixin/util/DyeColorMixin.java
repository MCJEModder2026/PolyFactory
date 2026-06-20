package eu.pb4.polyfactory.mixin.util;

import eu.pb4.polyfactory.util.DyeColorExtra;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.material.MapColor;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(DyeColor.class)
public class DyeColorMixin implements DyeColorExtra {
    @Shadow
    @Final
    private int textureDiffuseColor;

    @Inject(method = "<init>", at = @At("TAIL"))
    private void polyfactory$storeColor(String id, int name, int textureDiffuseColor, String mapColor, int terracottaColor, MapColor fireworkColor, MapColor textColor, int par8, int par9, CallbackInfo ci) {
        DyeColorExtra.BY_COLOR.put(this.textureDiffuseColor, (DyeColor) (Object) this);
    }

    @Override
    public int polyfactory$getColor() {
        return this.textureDiffuseColor;
    }
}
