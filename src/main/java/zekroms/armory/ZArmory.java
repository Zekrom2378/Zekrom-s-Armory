package zekroms.armory;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import zekroms.armory.util.Reference;
import org.apache.logging.log4j.Logger;
import zekroms.armory.proxy.CommonProxy;



@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION)
public class ZArmory
{
    @Mod.Instance()
    public static ZArmory instance;

    public static Logger logger;


    @SidedProxy(clientSide = Reference.CLIENT, serverSide = Reference.COMMON)
    public static CommonProxy proxy;

    @Mod.EventHandler
    public static void preInit(FMLPreInitializationEvent event) {}
    @Mod.EventHandler
    public static void init(FMLInitializationEvent event) {}
    @Mod.EventHandler
    public static void postInit(FMLPostInitializationEvent event) {}

}

