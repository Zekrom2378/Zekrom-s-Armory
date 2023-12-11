package zekrom.zarmory.util;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;
import slimeknights.tconstruct.TConstruct;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.tools.Pattern;
import slimeknights.tconstruct.library.tools.ToolPart;
import slimeknights.tconstruct.tools.TinkerTools;

import zekrom.zarmory.util.Util;

import java.util.Locale;


public class PulseBase {
    /* Loaded */

    /** Returns true if the Tinkers Construct tools pulse is loaded */
    protected static boolean isToolsLoaded() {
        return TConstruct.pulseManager.isPulseLoaded(TinkerTools.PulseId);
    }


    /**
     * Sets the correct unlocalized name and registers the item.
     */
    protected static <T extends Item> T registerItem(IForgeRegistry<Item> registry, T item, String name) {
        if(!name.equals(name.toLowerCase(Locale.US))) {
            throw new IllegalArgumentException(
                    String.format("Unlocalized names need to be all lowercase! Item: %s", name));
        }

        item.setUnlocalizedName(Util.prefix(name));
        item.setRegistryName(Util.getResource(name));
        registry.register(item);
        return item;
    }

    protected static <T extends IForgeRegistryEntry<T>> T register(IForgeRegistry<T> registry, T thing, String name) {
        thing.setRegistryName(Util.getResource(name));
        registry.register(thing);
        return thing;
    }

    protected static <T extends IForgeRegistryEntry<T>> T register(IForgeRegistry<T> registry, T thing,
                                                                   ResourceLocation name) {
        thing.setRegistryName(name);
        registry.register(thing);
        return thing;
    }


    /* Tinkers Registration */
    protected static void registerStencil(ToolPart part) {
        TinkerRegistry.registerStencilTableCrafting(Pattern.setTagForPart(new ItemStack(TinkerTools.pattern), part));
    }
}
