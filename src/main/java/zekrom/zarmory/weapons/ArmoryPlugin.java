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
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.ToolCore;
import zekrom.zarmory.init.ZeksRegistry;
import zekrom.zarmory.proxy.CommonProxy;
import zekrom.zarmory.util.PulseBase;
import zekrom.zarmory.init.ItemInit;
import zekrom.zarmory.weapons.melee.GreatSword;
import zekrom.zarmory.weapons.modifiers.ModWhispering;



@Pulse(id = ArmoryPlugin.pulseID, description = "Add more weapons to TConstruct", modsRequired = "tconstruct")
public class ArmoryPlugin extends PulseBase {

    public static final String pulseID = "ArmoryPlugin";

    @SidedProxy(clientSide = "zekrom.zarmory.weapons.ArmoryClientProxy", serverSide = "zekrom.zarmory.proxy.CommonProxy")
    public static CommonProxy proxy;

    public static ToolCore greatSword;

    public static Modifier modWhispering;

    @Subscribe
    public void preInit(FMLPreInitializationEvent event) {
        proxy.preInit();
    }

    @SubscribeEvent
    public void registerItems(RegistryEvent.Register<Item> event){
        IForgeRegistry<Item> r = event.getRegistry();

        if(isToolsLoaded()) {
            greatSword = registerItem(r, new GreatSword(), "greatsword");
            modWhispering = new ModWhispering();
            modWhispering.addItem(ItemInit.WHISPERING_SOUL);
        }
    }

    @Subscribe
    public void init(FMLInitializationEvent event) {
        if(isToolsLoaded()) {
            TinkerRegistry.registerToolForgeCrafting(greatSword);

        }
        ZeksRegistry.initRegistries();
        proxy.init();
    }

}
