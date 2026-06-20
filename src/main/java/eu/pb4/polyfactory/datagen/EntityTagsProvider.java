package eu.pb4.polyfactory.datagen;

import eu.pb4.polyfactory.entity.FactoryEntityIds;
import eu.pb4.polyfactory.entity.FactoryEntityTags;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EntityTypeIds;

import java.util.concurrent.CompletableFuture;

class EntityTagsProvider extends FabricTagsProvider.EntityTypeTagsProvider {
    public EntityTagsProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider arg) {
        this.tag(FactoryEntityTags.GRID_PASSABLE)
                .addOptionalTag(EntityTypeTags.ARROWS)
                .addOptionalTag(EntityTypeTags.IMPACT_PROJECTILES)
                .add(EntityTypeIds.ITEM)
                .add(EntityTypeIds.EXPERIENCE_ORB)
                .add(EntityTypeIds.EXPERIENCE_BOTTLE)
                .add(EntityTypeIds.LINGERING_POTION)
                .add(EntityTypeIds.SPLASH_POTION)
                .addOptionalTag(FactoryEntityTags.FLUID_SPLASH)
        ;
        this.tag(FactoryEntityTags.FLUID_SPLASH)
                .add(FactoryEntityIds.EXPERIENCE_SPLASH)
                .add(FactoryEntityIds.HONEY_SPLASH)
                .add(FactoryEntityIds.SLIME_SPLASH)
                .add(FactoryEntityIds.LAVA_SPLASH)
                .add(FactoryEntityIds.MILK_SPLASH)
                .add(FactoryEntityIds.WATER_SPLASH)
                .add(FactoryEntityIds.POTION_SPLASH)
        ;
    }
}
