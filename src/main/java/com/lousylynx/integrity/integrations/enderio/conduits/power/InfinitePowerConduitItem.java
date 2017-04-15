package com.lousylynx.integrity.integrations.enderio.conduits.power;

import com.lousylynx.integrity.integrations.enderio.ModObject;
import crazypants.enderio.EnderIO;
import crazypants.enderio.conduit.AbstractItemConduit;
import crazypants.enderio.conduit.IConduit;
import crazypants.enderio.conduit.ItemConduitSubtype;
import crazypants.enderio.machine.power.PowerDisplayUtil;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

public class InfinitePowerConduitItem extends AbstractItemConduit {

    private static String PREFIX;
    private static String POSTFIX;

    private InfinitePowerConduitItem() {
        super(ModObject.itemInfinitePowerConduit, new ItemConduitSubtype(ModObject.itemInfinitePowerConduit.name(), "enderio:itemPowerConduit"));
    }

    public static InfinitePowerConduitItem create() {
        InfinitePowerConduitItem result = new InfinitePowerConduitItem();
        result.init();
        return result;
    }

    @Override
    public Class<? extends IConduit> getBaseConduitType() {
        return IInfinitePowerConduit.class;
    }

    @Override
    public IConduit createConduit(ItemStack itemStack, EntityPlayer entityPlayer) {
        return new InfinitePowerConduit(itemStack.getItemDamage());
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack itemStack, EntityPlayer par2EntityPlayer, List list, boolean par4) {
        if (PREFIX == null) {
            POSTFIX = " " + PowerDisplayUtil.abrevation() + PowerDisplayUtil.perTickStr();
            PREFIX = EnderIO.lang.localize("power.maxOutput") + " ";
        }
        super.addInformation(itemStack, par2EntityPlayer, list, par4);
        int cap = InfinitePowerConduit.getMaxEnergyIO(itemStack.getMetadata());
        list.add(PREFIX + PowerDisplayUtil.formatPower(cap) + POSTFIX);
    }

    @Override
    public boolean shouldHideFacades(ItemStack itemStack, EntityPlayer entityPlayer) {
        return true;
    }
}
