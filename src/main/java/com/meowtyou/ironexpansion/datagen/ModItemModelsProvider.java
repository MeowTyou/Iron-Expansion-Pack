package com.meowtyou.ironexpansion.datagen;

import com.meowtyou.ironexpansion.IronExpansion;
import com.meowtyou.ironexpansion.block.Modblocks;
import com.meowtyou.ironexpansion.item.Moditems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelsProvider extends ItemModelProvider {
    public ModItemModelsProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, IronExpansion.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {

        handheldItem(Moditems.STEEL_SWORD);
        handheldItem(Moditems.STEEL_AXE);
        handheldItem(Moditems.STEEL_SHOVEL);
        handheldItem(Moditems.STEEL_HOE);
        handheldItem(Moditems.STEEL_PICKAXE);

        basicItem(Moditems.STEEL_HELMET.get());
        basicItem(Moditems.STEEL_LEGGINGS.get());
        basicItem(Moditems.STEEL_CHESTPLATE.get());
        basicItem(Moditems.STEEL_BOOTS.get());
    }

    private <T extends Block> void buttonItem(RegistryObject<T> block, RegistryObject<Block> base) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/button_inventory"))
                .texture("texture", ResourceLocation.fromNamespaceAndPath(IronExpansion.MOD_ID,
                        "block/" + base.getId().getPath()));
    }
    private <T extends Block> void fenceItem(RegistryObject<T> block, RegistryObject<Block> base) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/fence_inventory"))
                .texture("texture", ResourceLocation.fromNamespaceAndPath(IronExpansion.MOD_ID,
                        "block/" + base.getId().getPath()));
    }
    private <T extends Block> void wallItem(RegistryObject<T> block, RegistryObject<Block> base) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/wall_inventory"))
                .texture("wall", ResourceLocation.fromNamespaceAndPath(IronExpansion.MOD_ID,
                        "block/" + base.getId().getPath()));
    }

    private ItemModelBuilder handheldItem(RegistryObject<Item> item){
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.withDefaultNamespace("item/handheld")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(IronExpansion.MOD_ID,"item/"+item.getId().getPath()));
    }
}
