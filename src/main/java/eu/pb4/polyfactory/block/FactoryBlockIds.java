package eu.pb4.polyfactory.block;

import eu.pb4.polyfactory.ModInit;
import eu.pb4.polyfactory.block.creative.CreativeContainerBlock;
import eu.pb4.polyfactory.block.creative.CreativeDrainBlock;
import eu.pb4.polyfactory.block.creative.CreativeMotorBlock;
import eu.pb4.polyfactory.block.data.CableBlock;
import eu.pb4.polyfactory.block.data.GatedCableBlock;
import eu.pb4.polyfactory.block.data.WallWithCableBlock;
import eu.pb4.polyfactory.block.data.creative.TpsProviderBlock;
import eu.pb4.polyfactory.block.data.io.*;
import eu.pb4.polyfactory.block.data.output.*;
import eu.pb4.polyfactory.block.data.providers.*;
import eu.pb4.polyfactory.block.electric.ElectricGeneratorBlock;
import eu.pb4.polyfactory.block.electric.ElectricMotorBlock;
import eu.pb4.polyfactory.block.fluids.*;
import eu.pb4.polyfactory.block.fluids.smeltery.*;
import eu.pb4.polyfactory.block.fluids.transport.*;
import eu.pb4.polyfactory.block.fluids.transport.PipeBlock;
import eu.pb4.polyfactory.block.mechanical.*;
import eu.pb4.polyfactory.block.mechanical.conveyor.ConveyorBlock;
import eu.pb4.polyfactory.block.mechanical.conveyor.FunnelBlock;
import eu.pb4.polyfactory.block.mechanical.conveyor.SlotAwareFunnelBlock;
import eu.pb4.polyfactory.block.mechanical.conveyor.SplitterBlock;
import eu.pb4.polyfactory.block.mechanical.machines.MinerBlock;
import eu.pb4.polyfactory.block.mechanical.machines.PlacerBlock;
import eu.pb4.polyfactory.block.mechanical.machines.PlanterBlock;
import eu.pb4.polyfactory.block.mechanical.machines.crafting.GrinderBlock;
import eu.pb4.polyfactory.block.mechanical.machines.crafting.MCrafterBlock;
import eu.pb4.polyfactory.block.mechanical.machines.crafting.MixerBlock;
import eu.pb4.polyfactory.block.mechanical.machines.crafting.PressBlock;
import eu.pb4.polyfactory.block.mechanical.source.HandCrankBlock;
import eu.pb4.polyfactory.block.mechanical.source.SteamEngineBlock;
import eu.pb4.polyfactory.block.mechanical.source.WindmillBlock;
import eu.pb4.polyfactory.block.other.*;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.fabricmc.fabric.api.event.registry.RegistryEntryAddedCallback;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.storage.loot.LootTable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import static eu.pb4.polyfactory.ModInit.id;

// ,([a-zA-Z \->\(\)\._,\:0-9?"\n]*);

public class FactoryBlockIds {
    private static final List<Block> BLOCKS = new ArrayList<>();
    public static final ResourceKey<Block> CONVEYOR = register("conveyor");
    public static final ResourceKey<Block> STICKY_CONVEYOR = register("sticky_conveyor");
    public static final ResourceKey<Block> FUNNEL = register("funnel");
    public static final ResourceKey<Block> SLOT_AWARE_FUNNEL = register("slot_aware_funnel");
    public static final ResourceKey<Block> SPLITTER = register("splitter");
    public static final ResourceKey<Block> FAN = register("fan");
    public static final ResourceKey<Block> EJECTOR = register("ejector");
    public static final ResourceKey<Block> METAL_GRID = register("metal_grid");
    public static final ResourceKey<Block> HAND_CRANK = register("hand_crank");
    public static final ResourceKey<Block> STEAM_ENGINE = register("steam_engine");
    public static final ResourceKey<Block> GRINDER = register("grinder");
    public static final ResourceKey<Block> PRESS = register("press");
    public static final ResourceKey<Block> MIXER = register("mixer");
    public static final ResourceKey<Block> CRAFTER = register("crafter");
    public static final ResourceKey<Block> MINER = register("miner");
    public static final ResourceKey<Block> PLACER = register("placer");
    public static final ResourceKey<Block> PLANTER = register("planter");
    public static final ResourceKey<Block> AXLE = register("axle");
    public static final ResourceKey<Block> CHAIN_DRIVE = register("chain_drive");
    public static final ResourceKey<Block> AXLE_WITH_GEAR = register("axle_with_gear");
    public static final ResourceKey<Block> AXLE_WITH_LARGE_GEAR = register("axle_with_large_gear");
    public static final ResourceKey<Block> TURNTABLE = register("turntable");
    public static final ResourceKey<Block> GEARBOX = register("gearbox");
    public static final ResourceKey<Block> CLUTCH = register("clutch");
    public static final ResourceKey<Block> GEARSHIFT = register("gearshift");
    public static final ResourceKey<Block> WINDMILL = register("windmill");
    public static final ResourceKey<Block> CONTAINER = register("wooden_container");
    public static final ResourceKey<Block> DEEP_STORAGE_CONTAINER = register("deep_storage_container");
    public static final ResourceKey<Block> ITEM_OUTPUT_BUFFER = register("item_output_buffer");
    public static final ResourceKey<Block> ITEM_PACKER = register("item_packer");
    public static final ResourceKey<Block> CABLE = register("cable");
    public static final ResourceKey<Block> GATED_CABLE = register("gated_cable");
    //public static final Map<Block, WallWithCableBlock> WALL_WITH_CABLE = WallWithCableBlock.MAP;
    public static final ResourceKey<Block> ITEM_COUNTER = register("item_counter");

    public static final ResourceKey<Block> REDSTONE_INPUT = register("redstone_input");
    public static final ResourceKey<Block> REDSTONE_OUTPUT = register("redstone_output");
    public static final ResourceKey<Block> SPEAKER = register("speaker");
    public static final ResourceKey<Block> RECORD_PLAYER = register("record_player");
    public static final ResourceKey<Block> ITEM_READER = register("item_reader");
    public static final ResourceKey<Block> BLOCK_OBSERVER = register("block_observer");
    public static final ResourceKey<Block> TEXT_INPUT = register("text_input");
    public static final ResourceKey<Block> DIGITAL_CLOCK = register("digital_clock");
    public static final ResourceKey<Block> ARITHMETIC_OPERATOR = register("arithmetic_operator");

    public static final ResourceKey<Block> DATA_COMPARATOR = register("data_comparator");
    public static final ResourceKey<Block> DATA_EXTRACTOR = register("data_extractor");
    public static final ResourceKey<Block> PROGRAMMABLE_DATA_EXTRACTOR = register("programmable_data_extractor");
    public static final ResourceKey<Block> DATA_MEMORY = register("data_memory");

    public static final ResourceKey<Block> GAUGE = register("gauge");
    public static final ResourceKey<Block> HOLOGRAM_PROJECTOR = register("hologram_projector");
    public static final ResourceKey<Block> NIXIE_TUBE = register("nixie_tube");

    public static final ResourceKey<Block> NIXIE_TUBE_CONTROLLER = register("nixie_tube_controller");
    public static final ResourceKey<Block> WIRELESS_REDSTONE_RECEIVER = register("wireless_redstone_receiver");
    public static final ResourceKey<Block> WIRELESS_REDSTONE_TRANSMITTER = register("wireless_redstone_transmitter");

    public static final ResourceKey<Block> TACHOMETER = register("tachometer");
    public static final ResourceKey<Block> STRESSOMETER = register("stressometer");
    public static final ResourceKey<Block> ELECTRIC_MOTOR = register("electric_motor");
    public static final ResourceKey<Block> ELECTRIC_GENERATOR = register("electric_generator");
    public static final ResourceKey<Block> WORKBENCH = register("workbench");
    public static final ResourceKey<Block> BLUEPRINT_WORKBENCH = register("blueprint_workbench");
    public static final ResourceKey<Block> MOLDMAKING_TABLE = register("moldmaking_table");
    public static final ResourceKey<Block> CREATIVE_MOTOR = register("creative_motor");
    public static final ResourceKey<Block> CREATIVE_CONTAINER = register("creative_container");
    public static final ResourceKey<Block> INVERTED_REDSTONE_LAMP = register("inverted_redstone_lamp");
    public static final ResourceKey<Block> LAMP = register("colored_lamp");
    public static final ResourceKey<Block> INVERTED_LAMP = register("inverted_colored_lamp");

    public static final ResourceKey<Block> CAGED_LAMP = register("caged_lamp");
    public static final ResourceKey<Block> INVERTED_CAGED_LAMP = register("inverted_caged_lamp");
    public static final ResourceKey<Block> FIXTURE_LAMP = register("fixture_lamp");
    public static final ResourceKey<Block> INVERTED_FIXTURE_LAMP = register("inverted_fixture_lamp");
    public static final ResourceKey<Block> STEEL_BUTTON = register("steel_button");
    public static final ResourceKey<Block> TINY_POTATO_SPRING = register("tiny_potato_spring");
    public static final ResourceKey<Block> GOLDEN_TINY_POTATO_SPRING = register("golden_tiny_potato_spring");
    public static final ResourceKey<Block> ROTATION_DEBUG = register("rot_debug");
    public static final ResourceKey<Block> PIPE = register("pipe");
    public static final ResourceKey<Block> FILTERED_PIPE = register("filtered_pipe");
    public static final ResourceKey<Block> REDSTONE_VALVE_PIPE = register("redstone_valve_pipe");
    public static final Map<Block, PipeInWallBlock> WALL_WITH_PIPE = PipeInWallBlock.MAP;
    public static final ResourceKey<Block> SMELTERY_CORE = register("smeltery_core");

    public static final ResourceKey<Block> SMELTERY = register("smeltery");
    public static final ResourceKey<Block> PRIMITIVE_SMELTERY = register("primitive_smeltery");
    public static final ResourceKey<Block> CASTING_TABLE = register("casting_table");
    public static final ResourceKey<Block> CASTING_CAULDRON = register("casting_cauldron");
    public static final ResourceKey<Block> FAUCET = register("faucet");
    public static final ResourceKey<Block> PUMP = register("pump");
    public static final ResourceKey<Block> NOZZLE = register("nozzle");
    public static final ResourceKey<Block> DRAIN = register("drain");
    public static final ResourceKey<Block> MECHANICAL_DRAIN = register("mechanical_drain");
    public static final ResourceKey<Block> MECHANICAL_SPOUT = register("mechanical_spout");
    public static final ResourceKey<Block> CREATIVE_DRAIN = register("creative_drain");
    public static final ResourceKey<Block> FLUID_TANK = register("fluid_tank");
    public static final ResourceKey<Block> PORTABLE_FLUID_TANK = register("portable_fluid_tank");

    public static final ResourceKey<Block> STEEL_BLOCK = register("steel_block");
    public static final ResourceKey<Block> TPS_PROVIDER = register("tps_provider");

    public static  ResourceKey<Block> register(String path) {
        return ResourceKey.create(Registries.BLOCK, id(path));
    }
}
