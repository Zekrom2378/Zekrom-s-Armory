package zekroms.armory.weapons.modifiers;

import com.google.common.collect.ImmutableList;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import slimeknights.mantle.util.RecipeMatch;
import slimeknights.tconstruct.library.modifiers.ModifierAspect;
import slimeknights.tconstruct.library.modifiers.ModifierTrait;
import slimeknights.tconstruct.library.modifiers.TinkerGuiException;
import slimeknights.tconstruct.library.utils.TagUtil;
import slimeknights.tconstruct.library.utils.TinkerUtil;
import slimeknights.tconstruct.tools.modifiers.ToolModifier;
import zekroms.armory.util.handler.SoundsHandler;

import javax.annotation.Nonnull;

import java.util.List;
import java.util.Random;

import static com.sun.javafx.binding.DoubleConstant.valueOf;
import static scala.runtime.ScalaNumberProxy$class.floatValue;

public class ModWhispering extends ToolModifier {

    private static final int DELAY = random.nextInt(12000 - 6000 + 1) + 6000; // every 5-10 mins

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
            // must be in hotbar or offhand for players
            if (entity instanceof EntityPlayer
                    && !InventoryPlayer.isHotbar(itemSlot)
                    && ((EntityPlayer) entity).getHeldItemOffhand() != tool) {
                return null;
            }
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
