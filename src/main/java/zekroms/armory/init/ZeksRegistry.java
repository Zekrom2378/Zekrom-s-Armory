package zekroms.armory.init;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import slimeknights.mantle.client.CreativeTab;
import zekroms.armory.util.handler.SoundsHandler;

public final class ZeksRegistry {

    public static CreativeTab tabZeksArmory = new CreativeTab("Zekrom's Armory", new ItemStack(Items.BAKED_POTATO));

    public static void initRegistries()
    {
        SoundsHandler.registerSounds();
    }





}
