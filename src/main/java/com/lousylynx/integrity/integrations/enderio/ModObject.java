package com.lousylynx.integrity.integrations.enderio;

import com.lousylynx.integrity.integrations.enderio.conduits.power.InfinitePowerConduitItem;
import crazypants.enderio.BlockEio;
import crazypants.enderio.IModObject;
import crazypants.enderio.Log;
import crazypants.util.NullHelper;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.*;

public enum ModObject implements IModObject {

    itemInfinitePowerConduit(InfinitePowerConduitItem.class);

    @Nonnull
    private final String unlocalisedName;
    protected Block block;
    protected Item item;
    protected final Class<?> clazz;
    @Nonnull
    protected final String methodName;
    @Nullable
    protected final Class<? extends TileEntity> teClazz;

    ModObject() {
        this((Class) null);
    }

    ModObject(Class<?> clazz) {
        this(clazz, "create", (Class) null);
    }

    ModObject(Class<?> clazz, Class<? extends TileEntity> teClazz) {
        this(clazz, "create", teClazz);
    }

    ModObject(Class<?> clazz, @Nonnull String methodName) {
        this(clazz, methodName, (Class) null);
    }

    ModObject(Class<?> clazz, @Nonnull String methodName, Class<? extends TileEntity> teClazz) {
        this.unlocalisedName = NullHelper.notnullJ(this.name(), "Enum.name()");
        this.clazz = clazz;
        this.methodName = methodName;
        this.teClazz = teClazz;
    }

    @Nonnull
    public String getUnlocalisedName() {
        return this.unlocalisedName;
    }

    public Block getBlock() {
        return this.block;
    }

    public Item getItem() {
        return this.item;
    }

    protected void preInitElem(FMLPreInitializationEvent event) {
        if (this.clazz == null) {
            Log.debug(this + ".preInitElem() missing");
        } else {
            Object obj = null;

            try {
                obj = this.clazz.getDeclaredMethod(this.methodName, (Class[]) null).invoke((Object) null, (Object[]) null);
            } catch (Throwable var5) {
                String str = "ModObject:create: Could not create instance for " + this.clazz + " using method " + this.methodName;
                Log.error(str + " Exception: " + var5);
                throw new RuntimeException(str, var5);
            }

            if (obj instanceof Item) {
                this.item = (Item) obj;
            } else {
                this.block = (Block) obj;
                this.item = Item.getItemFromBlock(this.block);
            }

            if (this.block instanceof BlockEio) {
                ((BlockEio) this.block).preInit(event);
            }

        }
    }

    protected void initElem(FMLInitializationEvent event) {
        if (this.block instanceof BlockEio) {
            ((BlockEio) this.block).init(event);
        }

    }

    private static void registerTeClasses() {
        HashMap<Class<? extends TileEntity>, List> clazzes = new HashMap<>();
        ModObject[] var1 = values();
        int entry = var1.length;

        for (int params = 0; params < entry; ++params) {
            ModObject i = var1[params];
            if (i.teClazz != null) {
                if (!clazzes.containsKey(i.teClazz)) {
                    clazzes.put(i.teClazz, new ArrayList());
                }

                (clazzes.get(i.teClazz)).add(i.unlocalisedName + "TileEntity");
            }
        }

        Iterator<Map.Entry<Class<? extends TileEntity>, List>> var5 = clazzes.entrySet().iterator();

        while (true) {
            while (var5.hasNext()) {
                Map.Entry<Class<? extends TileEntity>, List> var6 = var5.next();
                if ((var6.getValue()).size() == 1) {
                    GameRegistry.registerTileEntity(var6.getKey(), (String) (var6.getValue()).get(0));
                } else {
                    Collections.sort(var6.getValue());
                    String[] var7 = new String[(var6.getValue()).size() - 1];

                    for (int var8 = 0; var8 < var7.length; ++var8) {
                        var7[var8] = (String) (var6.getValue()).get(var8 + 1);
                    }

                    GameRegistry.registerTileEntityWithAlternatives(var6.getKey(), (String) (var6.getValue()).get(0), var7);
                }
            }

            return;
        }
    }

    public static void preInit(FMLPreInitializationEvent event) {
        ModObject[] var1 = values();
        int var2 = var1.length;

        for (int var3 = 0; var3 < var2; ++var3) {
            ModObject elem = var1[var3];
            elem.preInitElem(event);
        }

        registerTeClasses();
    }

    public static void init(FMLInitializationEvent event) {
        ModObject[] var1 = values();
        int var2 = var1.length;

        for (int var3 = 0; var3 < var2; ++var3) {
            ModObject elem = var1[var3];
            elem.initElem(event);
        }

    }
}
