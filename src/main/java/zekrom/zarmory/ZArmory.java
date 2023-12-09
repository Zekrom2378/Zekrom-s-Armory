package zekrom.zarmory;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;

import org.apache.logging.log4j.Logger;

import zekrom.zarmory.util.Reference;
import zekrom.zarmory.weapons.ArmoryPlugin;

import static slimeknights.tconstruct.TConstruct.pulseManager;


@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION)
public class ZArmory
{

    @Instance
    public static ZArmory instance;


    static{
        pulseManager.registerPulse(new ArmoryPlugin());
    }

    public static Logger logger;

    @EventHandler
    public static void preInit(FMLPreInitializationEvent event) {}
    @EventHandler
    public static void init(FMLInitializationEvent event) {

    }
    @EventHandler
    public static void postInit(FMLPostInitializationEvent event) {}

}

