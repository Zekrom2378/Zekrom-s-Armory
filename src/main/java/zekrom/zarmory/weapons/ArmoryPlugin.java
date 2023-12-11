package zekrom.zarmory.weapons;

import com.google.common.eventbus.Subscribe;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;
import slimeknights.mantle.pulsar.pulse.Pulse;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.materials.Material;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.ToolCore;
import slimeknights.tconstruct.library.tools.ToolPart;
import zekrom.zarmory.init.ZeksRegistry;
import zekrom.zarmory.proxy.CommonProxy;
import zekrom.zarmory.util.PulseBase;
import zekrom.zarmory.init.ItemInit;
import zekrom.zarmory.weapons.melee.GreatSword;
//import zekrom.zarmory.weapons.ranged.Rifle;
import zekrom.zarmory.weapons.modifiers.ModWhispering;

import javax.tools.Tool;


@Pulse(id = ArmoryPlugin.pulseID, description = "Add more weapons to TConstruct", modsRequired = "tconstruct")
public class ArmoryPlugin extends PulseBase {

    public static final String pulseID = "ArmoryPlugin";

    @SidedProxy(clientSide = "zekrom.zarmory.weapons.ArmoryClientProxy", serverSide = "zekrom.zarmory.proxy.CommonProxy")
    public static CommonProxy proxy;

    public static ToolCore greatSword;

    public static ToolCore rifle;
    public static ToolPart fireGroup;
    public static ToolPart barrel;
    public static ToolPart stock;


    public static Modifier modWhispering;

    @Subscribe
    public void preInit(FMLPreInitializationEvent event) {
        proxy.preInit();
    }

    @SubscribeEvent
    public void registerItems(RegistryEvent.Register<Item> event){
        IForgeRegistry<Item> r = event.getRegistry();

        if(isToolsLoaded()) {
//            rifle = registerItem(r, new Rifle(), "rifle");
//            barrel = registerItem(r, new ToolPart(Material.VALUE_Ingot), "barrel");
//            stock = registerItem(r, new ToolPart(Material.VALUE_Ingot), "stock");
//            fireGroup = registerItem(r, new ToolPart(Material.VALUE_Ingot), "fire_group");
            greatSword = registerItem(r, new GreatSword(), "greatsword");
            modWhispering = new ModWhispering();
            modWhispering.addItem(ItemInit.WHISPERING_SOUL);
        }
    }

    @Subscribe
    public void init(FMLInitializationEvent event) {
        if(isToolsLoaded()) {
            TinkerRegistry.registerToolForgeCrafting(greatSword);
//            TinkerRegistry.registerToolForgeCrafting(rifle);
//            registerStencil(fireGroup);
//            registerStencil(barrel);
//            registerStencil(stock);

        }
//        ZeksRegistry.initRegistries();
        proxy.init();
    }

}
