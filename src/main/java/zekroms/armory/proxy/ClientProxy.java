package zekroms.armory.proxy;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.IStateMapper;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.client.renderer.color.ItemColors;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelBakeEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.MinecraftForge;
import slimeknights.mantle.item.ItemMetaDynamic;
import slimeknights.tconstruct.shared.client.BakedTableModel;

public class ClientProxy extends CommonProxy{
    @Override
    public void preInit(){
        super.preInit();

        MinecraftForge.EVENT_BUS.register(this);
        }
    @Override
    public void registerItemRenderer(Item item, int meta, String id){
        ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(item.getRegistryName(), id));
    }



//    protected void registerItemModelDynamic(ItemMetaDynamic item) {
//        if (item != null) {
//            item.registerItemModels();
//        }
//    }
//    protected static void setModelStateMapper(Block block, IStateMapper mapper) {
//        if(block != null) {
//            ModelLoader.setCustomStateMapper(block, mapper);
//        }
//    }

//    protected static void registerItemColors(ItemColors colors, IItemColor handler, Item... items) {
//        for (Item item : items) {
//            if (item != null) {
//                colors.registerItemColorHandler(handler, item);
//            }
//        }
//    }
//    protected static void wrapTableModel(ModelBakeEvent event, ModelResourceLocation loc) {
//        IBakedModel model = event.getModelRegistry().getObject(loc);
//        if(model != null) {
//            event.getModelRegistry().putObject(loc, new BakedTableModel(model, null, DefaultVertexFormats.BLOCK));
//        }
//    }


}
