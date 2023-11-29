package zekroms.armory.objects.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import zekroms.armory.ZArmory;
import zekroms.armory.init.ItemInit;
import zekroms.armory.util.ModelInterface;

public class ItemBase extends Item implements ModelInterface {
    public ItemBase (String name)
    {
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(CreativeTabs.COMBAT);

        ItemInit.ITEMS.add(this);
    }

    @Override
    public void registerModels()
    {
        ZArmory.proxy.registerItemRenderer(this, 0, "inventory");
    }

}
