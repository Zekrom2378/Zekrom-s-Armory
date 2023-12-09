package zekrom.zarmory.weapons;

import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import slimeknights.tconstruct.common.ModelRegisterUtil;
import zekrom.zarmory.proxy.ClientProxy;

public class ArmoryClientProxy extends ClientProxy {
    @SubscribeEvent
    protected void registerModels(ModelRegistryEvent event){
        ModelRegisterUtil.registerToolModel(ArmoryPlugin.greatSword);

        MinecraftForge.EVENT_BUS.register(this);
    }



}
