package eu.pb4.polyfactory.entity;

import eu.pb4.polyfactory.ModInit;
import eu.pb4.polyfactory.entity.splash.*;
import eu.pb4.polymer.core.api.entity.PolymerEntityUtils;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.block.Block;

import static eu.pb4.polyfactory.ModInit.id;

public class FactoryEntityIds {
    public static final ResourceKey<EntityType<?>> DYNAMITE = register("dynamite");

    public static final ResourceKey<EntityType<?>> WATER_SPLASH = register("water_splash");
    public static final ResourceKey<EntityType<?>> LAVA_SPLASH = register("lava_splash");
    public static final ResourceKey<EntityType<?>> POTION_SPLASH = register("potion_splash");
    public static final ResourceKey<EntityType<?>> MILK_SPLASH = register("milk_splash");
    public static final ResourceKey<EntityType<?>> EXPERIENCE_SPLASH = register("experience_splash");

    public static final ResourceKey<EntityType<?>> HONEY_SPLASH = register("honey_splash");

    public static final ResourceKey<EntityType<?>> SLIME_SPLASH = register("slime_splash");

    public static final ResourceKey<EntityType<?>> CHAIN_LIFT = register("chain_lift");
    public static final ResourceKey<EntityType<?>> MINECART_WITH_BLOCKS = register("minecart_with_blocks");
    public static void register() {

    }

    public static  ResourceKey<EntityType<?>> register(String path) {
        return ResourceKey.create(Registries.ENTITY_TYPE, id(path));
    }
}
