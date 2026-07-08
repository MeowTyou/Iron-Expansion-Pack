package com.meowtyou.ironexpansion.block;

import com.meowtyou.ironexpansion.IronExpansion;
import com.meowtyou.ironexpansion.item.Moditems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

import static net.minecraft.world.level.block.Blocks.IRON_BLOCK;

public class Modblocks {
    public static final DeferredRegister<Block> BLOCKS=
            DeferredRegister.create(ForgeRegistries.BLOCKS, IronExpansion.MOD_ID);

    public static final RegistryObject<Block> STEEL_BLOCK=
            registerBlock("steel_block", () -> new Block(BlockBehaviour.Properties.of().strength(5.0F,6.0F).sound(SoundType.METAL).requiresCorrectToolForDrops()));
    public static final RegistryObject<StairBlock> STEEL_STAIR =
            registerBlock("steel_stair",
                    () -> new StairBlock(() -> STEEL_BLOCK.get().defaultBlockState(),BlockBehaviour.Properties.of().strength(3.0F,2.0F).sound(SoundType.METAL).requiresCorrectToolForDrops()));
    public static final RegistryObject<SlabBlock> STEEL_SLAB =
            registerBlock("steel_slab",
                    () -> new SlabBlock(BlockBehaviour.Properties.of().strength(3.0F,2.0F).sound(SoundType.METAL).requiresCorrectToolForDrops()));
    public static final RegistryObject<ButtonBlock> STEEL_BUTTON =
            registerBlock("steel_button",
                    () -> new ButtonBlock(BlockBehaviour.Properties.of().strength(3.0F,2.0F).sound(SoundType.METAL).requiresCorrectToolForDrops(), BlockSetType.IRON,40,false));
    public static final RegistryObject<PressurePlateBlock> STEEL_PRESSURE_PLATE =
            registerBlock("steel_pressure_plate",
                    () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING,BlockBehaviour.Properties.of().strength(1.0F,2.0F).requiresCorrectToolForDrops(),BlockSetType.IRON));
    public static final RegistryObject<FenceGateBlock> STEEL_FENCE_GATE =
            registerBlock("steel_fence_gate",
                    () -> new UnopenableSteelFenceGateBlock(BlockBehaviour.Properties.of().strength(3.0F,2.0F).sound(SoundType.METAL).requiresCorrectToolForDrops(), WoodType.OAK));
    public static final RegistryObject<FenceBlock> STEEL_FENCE =
            registerBlock("steel_fence",
                    () -> new FenceBlock(BlockBehaviour.Properties.of().strength(3.0F,2.0F).sound(SoundType.METAL).requiresCorrectToolForDrops()));
    public static final RegistryObject<DoorBlock> STEEL_DOOR =
            registerBlock("steel_door",
                    () -> new DoorBlock(BlockBehaviour.Properties.of().strength(3.0F,2.0F).sound(SoundType.METAL).requiresCorrectToolForDrops().noOcclusion(),BlockSetType.IRON));
    public static final RegistryObject<TrapDoorBlock> STEEL_TRAPDOOR =
            registerBlock("steel_trapdoor",
                    () -> new TrapDoorBlock(BlockBehaviour.Properties.of().strength(3.0F,2.0F).sound(SoundType.METAL).requiresCorrectToolForDrops().noOcclusion(),BlockSetType.IRON));

    public static final RegistryObject<StairBlock> IRON_STAIR =
            registerBlock("iron_stair",
                    () -> new StairBlock(() -> Blocks.IRON_BLOCK.defaultBlockState(),BlockBehaviour.Properties.of().strength(3.0F,2.0F).sound(SoundType.METAL).requiresCorrectToolForDrops()));
    public static final RegistryObject<SlabBlock> IRON_SLAB =
            registerBlock("iron_slab",
                    () -> new SlabBlock(BlockBehaviour.Properties.of().strength(3.0F,2.0F).sound(SoundType.METAL).requiresCorrectToolForDrops()));
    public static final RegistryObject<FenceGateBlock> IRON_FENCE_GATE =
            registerBlock("iron_fence_gate",
                    () -> new UnopenableSteelFenceGateBlock(BlockBehaviour.Properties.of().strength(3.0F,2.0F).sound(SoundType.METAL).requiresCorrectToolForDrops(), WoodType.OAK));
    public static final RegistryObject<FenceBlock> IRON_FENCE =
            registerBlock("iron_fence",
                    () -> new FenceBlock(BlockBehaviour.Properties.of().strength(3.0F,2.0F).sound(SoundType.METAL).requiresCorrectToolForDrops()));
    public static final RegistryObject<ButtonBlock> IRON_BUTTON =
            registerBlock("iron_button",
                    () -> new ButtonBlock(BlockBehaviour.Properties.of().strength(3.0F,2.0F).sound(SoundType.METAL).requiresCorrectToolForDrops(), BlockSetType.IRON,40,false));

    private static <T extends Block> void registerBlockItems(String name, RegistryObject<T> block){
        Moditems.ITEMS.register(name,()->new BlockItem(block.get(),new Item.Properties()));
    }

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block){
        RegistryObject<T> blocks=BLOCKS.register(name,block);
        registerBlockItems(name,blocks);
        return blocks;
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
