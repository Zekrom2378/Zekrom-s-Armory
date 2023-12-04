package zekroms.armory.weapons.melee;


import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;
import org.apache.logging.log4j.Logger;
import slimeknights.mantle.pulsar.pulse.Pulse;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.Util;
import slimeknights.tconstruct.library.tools.ToolCore;
import slimeknights.tconstruct.tools.AbstractToolPulse;
import slimeknights.tconstruct.tools.TinkerTools;
import zekroms.armory.weapons.melee.GreatSword;
import zekroms.armory.proxy.CommonProxy;

@Pulse(
        id = ArmoryMeleeWeapons.PulseId,
        description = "The new melee weapons added in by Zekrom",
        pulsesRequired = TinkerTools.PulseId,
        forced = true)


public class ArmoryMeleeWeapons extends AbstractToolPulse {
    public static final String PulseId = "ArmoryMeleeWeapons";
    static final Logger log = Util.getLogger(PulseId);

    public static slimeknights.tconstruct.common.CommonProxy proxy;

    public static ToolCore greatSword;
    @Override
    protected void registerTools(IForgeRegistry<Item> registry) {
        greatSword = registerTool(registry, new GreatSword(), "greatsword");

        //battleAxe = registerTool(new BattleAxe(), "battleaxe");
    }

    // INITIALIZATION

    @Override
    protected void registerToolBuilding() {
        TinkerRegistry.registerToolForgeCrafting(greatSword);
        //TinkerRegistry.registerToolForgeCrafting(battleAxe);

    }


}
