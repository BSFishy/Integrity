package com.lousylynx.integrity.integrations.enderio;

import com.lousylynx.integrity.api.integration.Integration;
import crazypants.enderio.render.IHaveRenderers;
import crazypants.enderio.render.IHaveTESR;
import crazypants.util.ClientUtil;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModObjectIntegration extends Integration {

    @Override
    @SideOnly(Side.CLIENT)
    public void preInit(FMLPreInitializationEvent event) {
        for (ModObject mo : ModObject.values()) {
            final Block block = mo.getBlock();
            if (block instanceof IHaveRenderers) {
                ((IHaveRenderers) block).registerRenderers();
            } else if (block == null) {
                final Item item = mo.getItem();
                if (item instanceof IHaveRenderers) {
                    ((IHaveRenderers) item).registerRenderers();
                } else if (item != null) {
                    ClientUtil.registerRenderer(item, mo.getUnlocalisedName());
                }
            }
            if (block instanceof IHaveTESR) {
                ((IHaveTESR) block).bindTileEntitySpecialRenderer();
            }
        }
    }
}
