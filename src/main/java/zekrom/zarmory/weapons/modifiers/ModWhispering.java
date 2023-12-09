package zekrom.zarmory.weapons.modifiers;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import slimeknights.tconstruct.library.modifiers.ModifierAspect;
import slimeknights.tconstruct.tools.modifiers.ToolModifier;
import zekrom.zarmory.util.handler.SoundsHandler;

import java.util.Random;

import static java.lang.Thread.sleep;

public class ModWhispering extends ToolModifier {

    private static final long DELAY = random.nextInt(12000 - 6000 + 1) + 6000; // every 5-10 mins

    public ModWhispering() {
        super("whispering", 0x9562d9);

        addAspects(new ModifierAspect.SingleAspect(this), new ModifierAspect.DataAspect(this), ModifierAspect.freeModifier);
        MinecraftForge.EVENT_BUS.register(this);
    }


    Random rand = new Random();
    public SoundEvent onUpdate(ItemStack tool, World world, Entity entity, int itemSlot, boolean isSelected) {
        int picker = rand.nextInt(8);
        // only in the hotbar of a player
        if (!world.isRemote && entity instanceof EntityLivingBase) {

                if (picker == 0) {
                    return SoundsHandler.WHISPER_MOD_GIBBERISH;
                } else if (picker == 1) {
                    return SoundsHandler.WHISPER_MOD_GIBBERISH1;
                } else if (picker == 2) {
                    return SoundsHandler.WHISPER_MOD_GIBBERISH2;
                } else if (picker == 3) {
                    return SoundsHandler.WHISPER_MOD_GIBBERISH3;
                } else if (picker == 4) {
                    return SoundsHandler.WHISPER_MOD_GIBBERISH4;
                } else if (picker == 5) {
                    return SoundsHandler.WHISPER_MOD_STEAL;
                } else if (picker == 6) {
                    return SoundsHandler.WHISPER_MOD_RUN;
                } else {
                    return SoundsHandler.WHISPER_MOD_KILL;
                }
            }

        return null;
    }
    @Override
    public void applyEffect(NBTTagCompound rootCompound, NBTTagCompound modifierTag) {


    }



}
