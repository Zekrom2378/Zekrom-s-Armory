package zekroms.armory.weapons.melee;


import com.google.common.eventbus.Subscribe;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;
import org.apache.logging.log4j.Logger;
import slimeknights.mantle.pulsar.pulse.Pulse;
import slimeknights.tconstruct.common.ModelRegisterUtil;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.Util;
import slimeknights.tconstruct.library.tools.ToolCore;
import slimeknights.tconstruct.tools.AbstractToolPulse;
import slimeknights.tconstruct.tools.TinkerTools;
import slimeknights.tconstruct.tools.melee.TinkerMeleeWeapons;
import zekroms.armory.weapons.melee.GreatSword;
import zekroms.armory.proxy.CommonProxy;

@Pulse(
        id = ArmoryMeleeWeapons.PulseId,
        description = "The new melee weapons added in by Zekrom",
        pulsesRequired = TinkerTools.PulseId,
        forced = true)


public class ArmoryMeleeWeapons extends TinkerMeleeWeapons {
    public static final String PulseId = "ArmoryMeleeWeapons";
    static final Logger log = Util.getLogger(PulseId);

    @SidedProxy(clientSide = "zekroms.armory.proxy.ClientProxy", serverSide = "zekroms.armory.proxy.CommonProxy")
    public static CommonProxy proxy;

    public static ToolCore greatSword;

    @Override
    @SubscribeEvent
    public void registerItems(RegistryEvent.Register<Item> event) {
        super.registerItems(event);
    }



    @Subscribe
    public void preInit(FMLPreInitializationEvent event) {
        proxy.preInit();
    }



    @Override
    protected void registerTools(IForgeRegistry<Item> registry) {
        greatSword = registerTool(registry, new GreatSword(), "greatsword");

        //battleAxe = registerTool(new BattleAxe(), "battleaxe");
    }
    @SubscribeEvent
    public void registerModels(ModelRegistryEvent event) {
        ModelRegisterUtil.registerToolModel(greatSword);
    }
    // INITIALIZATION
    @Override
    @Subscribe
    public void init(FMLInitializationEvent event) {
            super.init(event);
            proxy.init();
    }

    protected void registerToolBuilding(){
        TinkerRegistry.registerToolForgeCrafting(greatSword);
        //TinkerRegistry.registerToolForgeCrafting(battleAxe);
    }

    // POST INITIALIZATION

    @Override
    @Subscribe
    public void postInit(FMLPostInitializationEvent event) {
        super.postInit(event);
        proxy.postInit();
    }

}
