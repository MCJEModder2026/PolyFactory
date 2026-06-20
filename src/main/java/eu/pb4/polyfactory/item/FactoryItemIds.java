package eu.pb4.polyfactory.item;

import com.mojang.datafixers.util.Pair;
import eu.pb4.factorytools.api.block.MultiBlock;
import eu.pb4.factorytools.api.item.FactoryBlockItem;
import eu.pb4.factorytools.api.item.MultiBlockItem;
import eu.pb4.polyfactory.ModInit;
import eu.pb4.polyfactory.block.FactoryBlockTags;
import eu.pb4.polyfactory.block.FactoryBlockIds;
import eu.pb4.polyfactory.block.data.AbstractCableBlock;
import eu.pb4.polyfactory.block.fluids.PortableFluidTankBlock;
import eu.pb4.polyfactory.block.fluids.PortableFluidTankBlockEntity;
import eu.pb4.polyfactory.block.mechanical.AxleBlock;
import eu.pb4.polyfactory.block.other.BlockWithTooltip;
import eu.pb4.polyfactory.fluid.FactoryFluids;
import eu.pb4.polyfactory.item.block.*;
import eu.pb4.polyfactory.item.component.FluidComponent;
import eu.pb4.polyfactory.item.configuration.ClipboardItem;
import eu.pb4.polyfactory.item.configuration.WrenchItem;
import eu.pb4.polyfactory.item.tool.*;
import eu.pb4.polyfactory.item.util.ColoredItem;
import eu.pb4.polyfactory.item.util.FluidModelItem;
import eu.pb4.polyfactory.mixin.ToolMaterialAccessor;
import eu.pb4.polyfactory.other.FactoryRegistries;
import eu.pb4.polyfactory.util.DyeColorExtra;
import eu.pb4.polyfactory.util.FactoryUtil;
import eu.pb4.polymer.core.api.block.PolymerBlock;
import eu.pb4.polymer.core.api.item.PolymerCreativeModeTabUtils;
import eu.pb4.polymer.core.api.item.SimplePolymerItem;
import eu.pb4.polymer.resourcepack.api.PolymerResourcePackUtils;
import net.fabricmc.fabric.api.event.player.AttackBlockCallback;
import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.fabricmc.fabric.api.event.player.UseEntityCallback;
import net.fabricmc.fabric.api.registry.FabricPotionBrewingBuilder;
import net.fabricmc.fabric.api.registry.FuelValueEvents;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Unit;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.component.Consumables;
import net.minecraft.world.item.component.DyedItemColor;
import net.minecraft.world.item.component.Tool;
import net.minecraft.world.item.component.Weapon;
import net.minecraft.world.item.consume_effects.RemoveStatusEffectsConsumeEffect;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.ItemEnchantments;
import net.minecraft.world.level.block.Block;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

import static eu.pb4.polyfactory.ModInit.id;

public class FactoryItemIds {
    // Util
    public static final ResourceKey<Item> FLUID_MODEL = register("fluid_model");
    // Actual items
    public static final ResourceKey<Item> WRENCH = register("wrench");
    public static final ResourceKey<Item> GUIDE_BOOK = register("guidebook");
    public static final ResourceKey<Item> CLIPBOARD = register("clipboard");
    public static final ResourceKey<Item> CONVEYOR = register(FactoryBlockIds.CONVEYOR);
    public static final ResourceKey<Item> STICKY_CONVEYOR = register(FactoryBlockIds.STICKY_CONVEYOR);
    public static final ResourceKey<Item> FUNNEL = register(FactoryBlockIds.FUNNEL);
    public static final ResourceKey<Item> SLOT_AWARE_FUNNEL = register(FactoryBlockIds.SLOT_AWARE_FUNNEL);
    public static final ResourceKey<Item> SPLITTER = register(FactoryBlockIds.SPLITTER);
    public static final ResourceKey<Item> FAN = register(FactoryBlockIds.FAN);
    public static final ResourceKey<Item> EJECTOR = register(FactoryBlockIds.EJECTOR);
    public static final ResourceKey<Item> HAND_CRANK = register(FactoryBlockIds.HAND_CRANK);
    public static final ResourceKey<Item> STEAM_ENGINE = register(FactoryBlockIds.STEAM_ENGINE);
    public static final ResourceKey<Item> SMELTERY_CORE = register(FactoryBlockIds.SMELTERY_CORE);
    public static final ResourceKey<Item> SMELTERY = register(FactoryBlockIds.SMELTERY);
    public static final ResourceKey<Item> PRIMITIVE_SMELTERY = register(FactoryBlockIds.PRIMITIVE_SMELTERY);
    public static final ResourceKey<Item> CASTING_TABLE = register(FactoryBlockIds.CASTING_TABLE);
    public static final ResourceKey<Item> SMELTERY_FAUCET = register(FactoryBlockIds.FAUCET);
    public static final ResourceKey<Item> GRINDER = register(FactoryBlockIds.GRINDER);
    public static final ResourceKey<Item> PRESS = register(FactoryBlockIds.PRESS);
    public static final ResourceKey<Item> CRAFTER = register(FactoryBlockIds.CRAFTER);
    public static final ResourceKey<Item> MIXER = register(FactoryBlockIds.MIXER);
    public static final ResourceKey<Item> MINER = register(FactoryBlockIds.MINER);
    public static final ResourceKey<Item> PLACER = register(FactoryBlockIds.PLACER);
    public static final ResourceKey<Item> PLANTER = register(FactoryBlockIds.PLANTER);
    public static final ResourceKey<Item> AXLE = register(FactoryBlockIds.AXLE);
    public static final ResourceKey<Item> CHAIN_DRIVE = register(FactoryBlockIds.CHAIN_DRIVE);
    public static final ResourceKey<Item> TURNTABLE = register(FactoryBlockIds.TURNTABLE);
    public static final ResourceKey<Item> GEARBOX = register(FactoryBlockIds.GEARBOX);
    public static final ResourceKey<Item> CLUTCH = register(FactoryBlockIds.CLUTCH);
    public static final ResourceKey<Item> GEARSHIFT = register(FactoryBlockIds.GEARSHIFT);
    public static final ResourceKey<Item> CONTAINER = register( FactoryBlockIds.CONTAINER);
    public static final ResourceKey<Item> DEEP_STORAGE_CONTAINER = register( FactoryBlockIds.DEEP_STORAGE_CONTAINER);
    public static final ResourceKey<Item> ITEM_OUTPUT_BUFFER = register(FactoryBlockIds.ITEM_OUTPUT_BUFFER);
    public static final ResourceKey<Item> NIXIE_TUBE = register(FactoryBlockIds.NIXIE_TUBE);
    public static final ResourceKey<Item> WINDMILL_SAIL = register("windmill_sail");
    public static final ResourceKey<Item> METAL_GRID = register(FactoryBlockIds.METAL_GRID);
    public static final ResourceKey<Item> STRING_MESH = register("string_mesh");
    public static final ResourceKey<Item> SAW_DUST = register("saw_dust");
    public static final ResourceKey<Item> COAL_DUST = register("coal_dust");
    public static final ResourceKey<Item> NETHERRACK_DUST = register("netherrack_dust");
    public static final ResourceKey<Item> ENDER_DUST = register("ender_dust");
    public static final ResourceKey<Item> ENDER_INFUSED_AMETHYST_SHARD = register("ender_infused_amethyst_shard");
    public static final ResourceKey<Item> STEEL_ALLOY_MIXTURE = register("steel_alloy_mixture");
    public static final ResourceKey<Item> STEEL_INGOT = register("steel_ingot");
    public static final ResourceKey<Item> STEEL_NUGGET = register("steel_nugget");
    public static final ResourceKey<Item> STEEL_BLOCK = register(FactoryBlockIds.STEEL_BLOCK);
    public static final ResourceKey<Item> STEEL_PLATE = register("steel_plate");
    public static final ResourceKey<Item> COPPER_PLATE = register("copper_plate");
    public static final ResourceKey<Item> BRITTLE_GLASS_BOTTLE = register("brittle_glass_bottle");
    public static final ResourceKey<Item> BRITTLE_POTION = register("brittle_potion");
    public static final ResourceKey<Item> THROWABLE_GLASS_BOTTLE = register("throwable_glass_bottle");
    public static final ResourceKey<Item> LINGERING_THROWABLE_GLASS_BOTTLE = register("lingering_throwable_glass_bottle");
    public static final ResourceKey<Item> STEEL_GEAR = register("steel_gear");
    public static final ResourceKey<Item> LARGE_STEEL_GEAR = register("large_steel_gear");
    public static final ResourceKey<Item> STEEL_MACHINE_GEARBOX = register("generic_machine_part");
    public static final ResourceKey<Item> WOODEN_PLATE = register("wooden_plate");
    public static final ResourceKey<Item> TREATED_DRIED_KELP = register("treated_dried_kelp");
    public static final ResourceKey<Item> INTEGRATED_CIRCUIT = register("integrated_circuit");
    public static final ResourceKey<Item> REDSTONE_CHIP = register("redstone_chip");
    public static final ResourceKey<Item> CHAIN_LIFT = register("chain_lift");

    public static final ResourceKey<Item> ITEM_FILTER = register("item_filter");

    public static final ResourceKey<Item> CREATIVE_MOTOR = register(FactoryBlockIds.CREATIVE_MOTOR);
    public static final ResourceKey<Item> CREATIVE_CONTAINER = register(FactoryBlockIds.CREATIVE_CONTAINER);
    public static final ResourceKey<Item> TACHOMETER = register(FactoryBlockIds.TACHOMETER);
    public static final ResourceKey<Item> STRESSOMETER = register(FactoryBlockIds.STRESSOMETER);
    public static final ResourceKey<Item> ITEM_COUNTER = register(FactoryBlockIds.ITEM_COUNTER);
    public static final ResourceKey<Item> REDSTONE_INPUT = register(FactoryBlockIds.REDSTONE_INPUT);
    public static final ResourceKey<Item> REDSTONE_OUTPUT = register(FactoryBlockIds.REDSTONE_OUTPUT);
    public static final ResourceKey<Item> SPEAKER = register(FactoryBlockIds.SPEAKER);
    public static final ResourceKey<Item> RECORD_PLAYER = register(FactoryBlockIds.RECORD_PLAYER);
    public static final ResourceKey<Item> ITEM_READER = register(FactoryBlockIds.ITEM_READER);
    public static final ResourceKey<Item> BLOCK_OBSERVER = register(FactoryBlockIds.BLOCK_OBSERVER);
    public static final ResourceKey<Item> TEXT_INPUT = register(FactoryBlockIds.TEXT_INPUT);
    public static final ResourceKey<Item> DIGITAL_CLOCK = register(FactoryBlockIds.DIGITAL_CLOCK);
    public static final ResourceKey<Item> ARITHMETIC_OPERATOR = register(FactoryBlockIds.ARITHMETIC_OPERATOR);
    public static final ResourceKey<Item> DATA_COMPARATOR = register(FactoryBlockIds.DATA_COMPARATOR);
    public static final ResourceKey<Item> DATA_EXTRACTOR = register(FactoryBlockIds.DATA_EXTRACTOR);
    public static final ResourceKey<Item> PROGRAMMABLE_DATA_EXTRACTOR = register(FactoryBlockIds.PROGRAMMABLE_DATA_EXTRACTOR);
    public static final ResourceKey<Item> DATA_MEMORY = register("data_memory");
    public static final ResourceKey<Item> NIXIE_TUBE_CONTROLLER = register(FactoryBlockIds.NIXIE_TUBE_CONTROLLER);
    public static final ResourceKey<Item> GAUGE = register(FactoryBlockIds.GAUGE);
    public static final ResourceKey<Item> HOLOGRAM_PROJECTOR = register(FactoryBlockIds.HOLOGRAM_PROJECTOR);
    public static final ResourceKey<Item> WIRELESS_REDSTONE_RECEIVER = register(FactoryBlockIds.WIRELESS_REDSTONE_RECEIVER);
    public static final ResourceKey<Item> WIRELESS_REDSTONE_TRANSMITTER = register(FactoryBlockIds.WIRELESS_REDSTONE_TRANSMITTER);
    public static final ResourceKey<Item> PORTABLE_REDSTONE_TRANSMITTER = register("portable_redstone_transmitter");

    public static final ResourceKey<Item> PUNCH_CARD = register("punch_card");

    public static final ResourceKey<Item> CABLE = register("cable");
    public static final ResourceKey<Item> GATED_CABLE = register(FactoryBlockIds.GATED_CABLE);
    public static final ResourceKey<Item> LAMP = register(FactoryBlockIds.LAMP);
    public static final ResourceKey<Item> INVERTED_LAMP = register(FactoryBlockIds.INVERTED_LAMP);
    public static final ResourceKey<Item> CAGED_LAMP = register(FactoryBlockIds.CAGED_LAMP);
    public static final ResourceKey<Item> INVERTED_CAGED_LAMP = register(FactoryBlockIds.INVERTED_CAGED_LAMP);
    public static final ResourceKey<Item> FIXTURE_LAMP = register(FactoryBlockIds.FIXTURE_LAMP);
    public static final ResourceKey<Item> INVERTED_FIXTURE_LAMP = register(FactoryBlockIds.INVERTED_FIXTURE_LAMP);
    public static final ResourceKey<Item> STEEL_BUTTON = register(FactoryBlockIds.STEEL_BUTTON);
    public static final ResourceKey<Item> ELECTRIC_MOTOR = register(FactoryBlockIds.ELECTRIC_MOTOR);
    public static final ResourceKey<Item> ELECTRIC_GENERATOR = register(FactoryBlockIds.ELECTRIC_GENERATOR);
    public static final ResourceKey<Item> WORKBENCH = register(FactoryBlockIds.WORKBENCH);
    public static final ResourceKey<Item> BLUEPRINT_WORKBENCH = register(FactoryBlockIds.BLUEPRINT_WORKBENCH);
    public static final ResourceKey<Item> MOLDMAKING_TABLE = register(FactoryBlockIds.MOLDMAKING_TABLE);
    public static final ResourceKey<Item> ARTIFICIAL_DYE = register("artificial_dye");
    public static final ResourceKey<Item> DYNAMITE = register("dynamite");
    public static final ResourceKey<Item> STICKY_DYNAMITE = register("sticky_dynamite");
    public static final ResourceKey<Item> INVERTED_REDSTONE_LAMP = register(FactoryBlockIds.INVERTED_REDSTONE_LAMP);
    public static final ResourceKey<Item> TINY_POTATO_SPRING = register(FactoryBlockIds.TINY_POTATO_SPRING);
    public static final ResourceKey<Item> GOLDEN_TINY_POTATO_SPRING = register(FactoryBlockIds.GOLDEN_TINY_POTATO_SPRING);
    public static final ResourceKey<Item> EXPERIENCE_BUCKET = register("experience_bucket");
    public static final ResourceKey<Item> SLIME_BUCKET = register("slime_bucket");
    public static final ResourceKey<Item> HONEY_BUCKET = register("honey_bucket");

    public static final ResourceKey<Item> CRISPY_HONEY = register("crispy_honey");
    public static final ResourceKey<Item> HONEYED_APPLE = register("honeyed_apple");
    public static final ResourceKey<Item> CRUSHED_RAW_IRON = register("crushed_raw_iron");
    public static final ResourceKey<Item> CRUSHED_RAW_COPPER = register("crushed_raw_copper");
    public static final ResourceKey<Item> CRUSHED_RAW_GOLD = register("crushed_raw_gold");
    public static final ResourceKey<Item> SPRAY_CAN = register("spray_can");

    public static final ResourceKey<Item> DRILL = register("drill");

    public static final ResourceKey<Item> COPPER_DRILL_HEAD = register("copper_drill_head");
    public static final ResourceKey<Item> IRON_DRILL_HEAD = register("iron_drill_head");
    public static final ResourceKey<Item> GOLDEN_DRILL_HEAD = register("golden_drill_head");
    public static final ResourceKey<Item> DIAMOND_DRILL_HEAD = register("diamond_drill_head");
    public static final ResourceKey<Item> NETHERITE_DRILL_HEAD = register("netherite_drill_head");

    public static final ResourceKey<Item> PIPE = register("pipe");
    public static final ResourceKey<Item> FILTERED_PIPE = register(FactoryBlockIds.FILTERED_PIPE);
    public static final ResourceKey<Item> REDSTONE_VALVE_PIPE = register(FactoryBlockIds.REDSTONE_VALVE_PIPE);
    public static final ResourceKey<Item> PUMP = register(FactoryBlockIds.PUMP);
    public static final ResourceKey<Item> NOZZLE = register(FactoryBlockIds.NOZZLE);
    public static final ResourceKey<Item> DRAIN = register(FactoryBlockIds.DRAIN);
    public static final ResourceKey<Item> MECHANICAL_DRAIN = register(FactoryBlockIds.MECHANICAL_DRAIN);
    public static final ResourceKey<Item> MECHANICAL_SPOUT = register(FactoryBlockIds.MECHANICAL_SPOUT);
    public static final ResourceKey<Item> CREATIVE_DRAIN = register(FactoryBlockIds.CREATIVE_DRAIN);
    public static final ResourceKey<Item> FLUID_TANK = register(FactoryBlockIds.FLUID_TANK);
    public static final ResourceKey<Item> PORTABLE_FLUID_TANK = register(FactoryBlockIds.PORTABLE_FLUID_TANK);

    public static final ResourceKey<Item> PRESSURE_FLUID_GUN = register("pressure_fluid_gun");

    public static final ResourceKey<Item> ITEM_PACKER = register(FactoryBlockIds.ITEM_PACKER);

    /*public static final ResourceKey<Item> INGOT_MOLD = SpoutMolds.create("ingot");
    public static final ResourceKey<Item> NUGGET_MOLD = SpoutMolds.create("nugget");
    public static final ResourceKey<Item> PIPE_MOLD = SpoutMolds.create("pipe");
    public static final ResourceKey<Item> BOTTLE_MOLD = SpoutMolds.create("bottle");
    public static final ResourceKey<Item> THROWABLE_BOTTLE_MOLD = SpoutMolds.create("throwable_bottle");
    public static final ResourceKey<Item> BRITTLE_BOTTLE_MOLD = SpoutMolds.create("brittle_bottle");
    public static final ResourceKey<Item> CHAIN_MOLD = SpoutMolds.create("chain");*/


    public static  ResourceKey<Item> register(String path) {
        return ResourceKey.create(Registries.ITEM, id(path));
    }

    public static  ResourceKey<Item> register(ResourceKey<Block> key) {
        return key.dependent(Registries.ITEM, "");
    }
}
