package zekrom.zarmory.init;


import net.minecraft.item.Item;
import zekrom.zarmory.util.IHasModel;
import zekrom.zarmory.weapons.ArmoryPlugin;

import static zekrom.zarmory.init.ZeksRegistry.tabZeksArmory;


public class ItemBase extends Item implements IHasModel {
    public ItemBase(String name)
    {
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(tabZeksArmory);

        ItemInit.ZITEMS.add(this);


    }

    @Override
    public void registerModels()
    {
        ArmoryPlugin.proxy.registerItemRenderer(this, 0, "inventory");
    }


}
