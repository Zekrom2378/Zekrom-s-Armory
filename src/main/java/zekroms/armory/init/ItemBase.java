package zekroms.armory.init;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import zekroms.armory.util.IHasModel;

import static zekroms.armory.ZArmory.proxy;


public class ItemBase extends Item implements IHasModel {
    public ItemBase(String name)
    {
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(CreativeTabs.MATERIALS);

        ItemInit.ITEMS.add(this);


    }

    @Override
    public void registerModels()
    {
        proxy.registerItemRenderer(this, 0, "inventory");
    }


}
