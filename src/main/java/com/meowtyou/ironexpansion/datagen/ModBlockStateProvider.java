package com.meowtyou.ironexpansion.datagen;

import com.meowtyou.ironexpansion.IronExpansion;
import com.meowtyou.ironexpansion.block.Modblocks;
import net.minecraft.client.Minecraft;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, IronExpansion.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlockWithItem(Modblocks.STEEL_BLOCK.get(),cubeAll(Modblocks.STEEL_BLOCK.get()));

        stairsBlock(Modblocks.STEEL_STAIR.get(),blockTexture(Modblocks.STEEL_BLOCK.get()));
        slabBlock(Modblocks.STEEL_SLAB.get(),blockTexture(Modblocks.STEEL_BLOCK.get()),blockTexture(Modblocks.STEEL_BLOCK.get()));
        buttonBlock(Modblocks.STEEL_BUTTON.get(),blockTexture(Modblocks.STEEL_BLOCK.get()));
        pressurePlateBlock(Modblocks.STEEL_PRESSURE_PLATE.get(),blockTexture(Modblocks.STEEL_BLOCK.get()));
        fenceBlock(Modblocks.STEEL_FENCE.get(),blockTexture(Modblocks.STEEL_BLOCK.get()));
        fenceGateBlock(Modblocks.STEEL_FENCE_GATE.get(),blockTexture(Modblocks.STEEL_BLOCK.get()));

        doorBlockWithRenderType(Modblocks.STEEL_DOOR.get(),modLoc("block/steel_door_bottom"),modLoc("block/steel_door_top"),"cutout");
        trapdoorBlockWithRenderType(Modblocks.STEEL_TRAPDOOR.get(),modLoc("block/steel_trapdoor"),true,"cutout");

        stairsBlock(Modblocks.IRON_STAIR.get(),blockTexture(Blocks.IRON_BLOCK));
        slabBlock(Modblocks.IRON_SLAB.get(),blockTexture(Blocks.IRON_BLOCK),blockTexture(Blocks.IRON_BLOCK));
        fenceBlock(Modblocks.IRON_FENCE.get(),blockTexture(Blocks.IRON_BLOCK));
        fenceGateBlock(Modblocks.IRON_FENCE_GATE.get(),blockTexture(Blocks.IRON_BLOCK));
    }

    private <T extends Block> void blockItem(RegistryObject<T> block){
        simpleBlockItem(block.get(), new ModelFile.UncheckedModelFile(IronExpansion.MOD_ID + ":block/" + block.getId().getPath()));
    }
    private <T extends Block> void blockItem(RegistryObject<T> block, String append){
        simpleBlockItem(block.get(), new ModelFile.UncheckedModelFile(IronExpansion.MOD_ID + ":block/" + block.getId().getPath() + append));
    }


}
