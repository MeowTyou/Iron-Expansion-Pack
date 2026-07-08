package com.meowtyou.ironexpansion.datagen;

import com.meowtyou.ironexpansion.IronExpansion;
import com.meowtyou.ironexpansion.block.Modblocks;
import com.meowtyou.ironexpansion.item.Moditems;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;

public class ModEnUsLangProvider extends LanguageProvider {
    public ModEnUsLangProvider(PackOutput output) {
        super(output, IronExpansion.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {
        add(Moditems.Steel_Ingot.get(),"Steel Ingot");
        add(Moditems.Steel_Nugget.get(),"Steel Nugget");

        add(Modblocks.STEEL_BLOCK.get(),"Steel Block");
    }
}
