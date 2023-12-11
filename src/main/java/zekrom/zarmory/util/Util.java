package zekrom.zarmory.util;


import net.minecraft.util.ResourceLocation;

import java.util.Locale;

public class Util {
    public static String resource(String name) {
        return String.format("%s:%s", Reference.MODID, name.toLowerCase(Locale.US));
    }
    public static String prefix(String name) {
        return String.format("%s.%s", Reference.MODID, name.toLowerCase(Locale.US));
    }

    public static ResourceLocation getResource(String res) {
        return new ResourceLocation(Reference.MODID, res);
    }
}
