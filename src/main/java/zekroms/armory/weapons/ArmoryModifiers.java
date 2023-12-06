package zekroms.armory.weapons;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent.Register;
import slimeknights.mantle.pulsar.pulse.Pulse;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.tools.TinkerModifiers;
import slimeknights.tconstruct.tools.TinkerTools;
import zekroms.armory.proxy.CommonProxy;
import zekroms.armory.weapons.modifiers.ModWhispering;



@Pulse(
        id = ArmoryModifiers.PulseId,
        description = "All Armory Modifiers",
        pulsesRequired = TinkerTools.PulseId,
        forced = true)
public class ArmoryModifiers extends TinkerModifiers {

    public static final String PulseId = "ArmoryModifiers";

    public static CommonProxy proxy;

    public static Modifier modWhispering;


    @SubscribeEvent
    public void registerItems(Register<Item> event) {
        registerModifiers();
    }

    @Override
    protected void registerModifiers()
    {
        modWhispering = registerModifier(new ModWhispering());
        modWhispering.addItem("whispering_soul");
    }



}
