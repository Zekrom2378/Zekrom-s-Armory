package zekrom.zarmory.util.handler;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.play.server.SPacketSoundEffect;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import slimeknights.tconstruct.common.Sounds;
import slimeknights.tconstruct.common.TinkerNetwork;
import zekrom.zarmory.util.Reference;
import zekrom.zarmory.util.Util;

import java.util.ArrayList;
import java.util.List;

@Mod.EventBusSubscriber(modid = Reference.MODID)
public class SoundsHandler {


    private SoundsHandler() {

    }

    private static final List<SoundEvent> sounds = new ArrayList<>();


    public static final SoundEvent whisper_kill = sound("kill");
    public static final SoundEvent whisper_run = sound("run");
    public static final SoundEvent whisper_steal = sound("steal");
    public static final SoundEvent whisper_gibberish = sound("gibberish");
    public static final SoundEvent whisper_gibberish1 = sound("gibberish1");
    public static final SoundEvent whisper_gibberish2 = sound("gibberish2");
    public static final SoundEvent whisper_gibberish3 = sound("gibberish3");
    public static final SoundEvent whisper_gibberish4 = sound("gibberish4");

    private static SoundEvent sound(String name) {
        ResourceLocation location = Util.getResource(name);
        SoundEvent event = new SoundEvent(location);
        event.setRegistryName(location);
        sounds.add(event);
        return event;
    }
    public static void playSoundForAll(Entity entity, SoundEvent sound, float volume, float pitch) {
        entity.getEntityWorld().playSound(null, entity.getPosition(), sound, entity.getSoundCategory(), volume, pitch);
    }

    public static void PlaySoundForPlayer(Entity entity, SoundEvent sound, float volume, float pitch) {
        if(entity instanceof EntityPlayerMP) {
            TinkerNetwork.sendPacket(entity, new SPacketSoundEffect(sound, entity.getSoundCategory(), entity.posX, entity.posY, entity.posZ, volume, pitch));
        }
    }

    @SubscribeEvent
    public static void registerSoundEvent(RegistryEvent.Register<SoundEvent> event) {
        IForgeRegistry<SoundEvent> registry = event.getRegistry();
        sounds.forEach(registry::register);
    }



//    public static void registerSounds(){
//        WHISPER_MOD_GIBBERISH = registerSound("modifiers.whisper.gibberish");
//        WHISPER_MOD_GIBBERISH1 = registerSound("modifiers.whisper.gibberish1");
//        WHISPER_MOD_GIBBERISH2 = registerSound("modifiers.whisper.gibberish2");
//        WHISPER_MOD_GIBBERISH3 = registerSound("modifiers.whisper.gibberish3");
//        WHISPER_MOD_GIBBERISH4 = registerSound("modifiers.whisper.gibberish4");
//        WHISPER_MOD_KILL = registerSound("modifiers.whisper.kill");
//        WHISPER_MOD_STEAL = registerSound("modifiers.whisper.steal");
//        WHISPER_MOD_RUN = registerSound("modifiers.whisper.run");
//
//
//    }

}
