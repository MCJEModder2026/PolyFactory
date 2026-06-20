package eu.pb4.polyfactory.fluid;

import eu.pb4.polyfactory.other.FactoryRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;

import static eu.pb4.polyfactory.ModInit.id;

public class FactoryFluidIds {
    public static final ResourceKey<FluidType<?>> WATER = register(Identifier.withDefaultNamespace("water"));
    public static final ResourceKey<FluidType<?>> LAVA = register(Identifier.withDefaultNamespace("lava"));

    public static final ResourceKey<FluidType<?>> MILK = register(Identifier.withDefaultNamespace("milk"));

    public static final ResourceKey<FluidType<?>> GLASS = register(Identifier.withDefaultNamespace("glass"));

    public static final ResourceKey<FluidType<?>> IRON = register(Identifier.withDefaultNamespace("iron"));

    public static final ResourceKey<FluidType<?>> STEEL = register(id("steel"));


    public static final ResourceKey<FluidType<?>> GOLD = register(Identifier.withDefaultNamespace("gold"));

    public static final ResourceKey<FluidType<?>> COPPER = register(Identifier.withDefaultNamespace("copper"));

    public static final ResourceKey<FluidType<?>> EXPERIENCE = register(Identifier.withDefaultNamespace("experience"));

    public static final ResourceKey<FluidType<?>> POTION = register(Identifier.withDefaultNamespace("potion"));

    public static final ResourceKey<FluidType<?>> HONEY = register(Identifier.withDefaultNamespace("honey"));

    public static final ResourceKey<FluidType<?>> SLIME = register(Identifier.withDefaultNamespace("slime"));

    public static final ResourceKey<FluidType<?>> SNOW = register(Identifier.withDefaultNamespace("snow"));

    public static ResourceKey<FluidType<?>> register(Identifier identifier) {
        return ResourceKey.create(FactoryRegistries.FLUID_TYPES_KEY, identifier);
    }

    public static ResourceKey<FluidType<?>> register(String path) {
        return register(id(path));
    }
}
