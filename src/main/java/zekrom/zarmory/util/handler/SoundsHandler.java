package zekrom.zarmory.util.handler;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import zekrom.zarmory.util.Reference;

public class SoundsHandler {

    public static SoundEvent WHISPER_MOD_KILL, WHISPER_MOD_STEAL, WHISPER_MOD_RUN, WHISPER_MOD_GIBBERISH, WHISPER_MOD_GIBBERISH1, WHISPER_MOD_GIBBERISH2, WHISPER_MOD_GIBBERISH3, WHISPER_MOD_GIBBERISH4;

    public static void registerSounds(){
        WHISPER_MOD_GIBBERISH = registerSound("modifiers.whisper.gibberish");
        WHISPER_MOD_GIBBERISH1 = registerSound("modifiers.whisper.gibberish1");
        WHISPER_MOD_GIBBERISH2 = registerSound("modifiers.whisper.gibberish2");
        WHISPER_MOD_GIBBERISH3 = registerSound("modifiers.whisper.gibberish3");
        WHISPER_MOD_GIBBERISH4 = registerSound("modifiers.whisper.gibberish4");
        WHISPER_MOD_KILL = registerSound("modifiers.whisper.kill");
        WHISPER_MOD_STEAL = registerSound("modifiers.whisper.steal");
        WHISPER_MOD_RUN = registerSound("modifiers.whisper.run");


    }
    private static SoundEvent registerSound(String name)
    {
        ResourceLocation location = new ResourceLocation(Reference.MODID, name);
        SoundEvent event = new SoundEvent(location);
        event.setRegistryName(name);
        ForgeRegistries.SOUND_EVENTS.register(event);
        return event;
    }
}
