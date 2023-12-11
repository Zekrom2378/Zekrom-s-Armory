package zekrom.zarmory.weapons.modifiers;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import slimeknights.tconstruct.library.modifiers.ModifierAspect;
import slimeknights.tconstruct.library.modifiers.ModifierTrait;
import slimeknights.tconstruct.library.utils.ModifierTagHolder;
import slimeknights.tconstruct.library.utils.ToolHelper;
import slimeknights.tconstruct.tools.modifiers.ToolModifier;
import zekrom.zarmory.util.handler.SoundsHandler;

import java.util.Random;

import static java.lang.Thread.sleep;

public class ModWhispering extends ModifierTrait {

    private static final long DELAY = random.nextInt(6000 - 3000 + 1) + 3000; // every 2.5-5 mins
    private static long FLAG = 60;

    public ModWhispering() {
        super("whispering", 0x9562d9);

        addAspects(new ModifierAspect.SingleAspect(this), new ModifierAspect.DataAspect(this), ModifierAspect.freeModifier);
        MinecraftForge.EVENT_BUS.register(this);
    }


    @Override
    public void onUpdate(ItemStack tool, World world, EntityLivingBase entityLiving, int itemSlot, boolean isSelected) {
        // only in the hotbar of a player
        if(!world.isRemote) {
            // must be in hotbar or offhand for players
            if(!isSelected) {
                return;
            }

            // needs ot be repaired and is in hotbar or offhand
            whisper(world, entityLiving);
        }
    }

    Random rand = new Random();



    public SoundEvent makeNoise(EntityLivingBase entityLiving) {
        int picker = rand.nextInt(8);
        if (picker == 0) {
            SoundsHandler.PlaySoundForPlayer(entityLiving, SoundsHandler.whisper_gibberish, 2.0f, 1f);
        } else if (picker == 1) {
            SoundsHandler.PlaySoundForPlayer(entityLiving, SoundsHandler.whisper_gibberish1, 2.0f, 1f);
        } else if (picker == 2) {
            SoundsHandler.PlaySoundForPlayer(entityLiving, SoundsHandler.whisper_gibberish2, 2.0f, 1f);
        } else if (picker == 3) {
            SoundsHandler.PlaySoundForPlayer(entityLiving, SoundsHandler.whisper_gibberish3, 2.0f, 1f);
        } else if (picker == 4) {
            SoundsHandler.PlaySoundForPlayer(entityLiving, SoundsHandler.whisper_gibberish4, 2.0f, 1f);
        } else if (picker == 5) {
            SoundsHandler.PlaySoundForPlayer(entityLiving, SoundsHandler.whisper_run, 2.0f, 1f);
        } else if (picker == 6) {
            SoundsHandler.PlaySoundForPlayer(entityLiving, SoundsHandler.whisper_steal, 2.0f, 1f);
        } else {
            SoundsHandler.PlaySoundForPlayer(entityLiving, SoundsHandler.whisper_kill, 2.0f, 1f);
        }


        return null;
    }

    private boolean whisper(World world, EntityLivingBase entityLiving) {

        if (world.getTotalWorldTime() - FLAG > DELAY && entityLiving instanceof EntityPlayer) {
            makeNoise(entityLiving);
            FLAG = world.getTotalWorldTime();
            return true;
        }
        return false;
    }

    @Override
    public void applyEffect(NBTTagCompound rootCompound, NBTTagCompound modifierTag) {


    }


}
