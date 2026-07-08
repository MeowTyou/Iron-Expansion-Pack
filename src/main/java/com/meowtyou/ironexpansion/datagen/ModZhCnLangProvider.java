package com.meowtyou.ironexpansion.datagen;

import com.meowtyou.ironexpansion.IronExpansion;
import com.meowtyou.ironexpansion.block.Modblocks;
import com.meowtyou.ironexpansion.item.Moditems;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;

public class ModZhCnLangProvider extends LanguageProvider {
    public ModZhCnLangProvider(PackOutput output) {
        super(output, IronExpansion.MOD_ID, "zh_cn");
    }

    @Override
    protected void addTranslations() {
        add(Moditems.Steel_Ingot.get(),"钢锭");
        add(Moditems.Steel_Nugget.get(),"钢粒");

        add(Modblocks.STEEL_BLOCK.get(),"钢块");
    }
}
