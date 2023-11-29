package zekroms.armory.weapons;

import java.util.List;
import javax.annotation.Nonnull;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import slimeknights.tconstruct.library.client.particle.Particles;
import slimeknights.tconstruct.library.materials.ExtraMaterialStats;
import slimeknights.tconstruct.library.materials.HandleMaterialStats;
import slimeknights.tconstruct.library.materials.HeadMaterialStats;
import slimeknights.tconstruct.library.materials.Material;
import slimeknights.tconstruct.library.tinkering.Category;
import slimeknights.tconstruct.library.tinkering.PartMaterialType;
import slimeknights.tconstruct.library.tools.SwordCore;
import slimeknights.tconstruct.library.tools.ToolNBT;
import slimeknights.tconstruct.tools.TinkerTools;


public class GreatSword extends SwordCore {

    // This is the durability multiplier
    public static final float DURABILITY_MODIFIER = 1.75F;

    public GreatSword() {
        // This is the part requirement for the Tool Forge
        super(new PartMaterialType[]{PartMaterialType.handle(TinkerTools.toughToolRod), PartMaterialType.head(TinkerTools.largeSwordBlade), PartMaterialType.extra(TinkerTools.wideGuard)});

        // This is designating the item to a tool category
        this.addCategory(new Category[]{Category.WEAPON});
    }

    @Nonnull
    public ActionResult<ItemStack> func_77659_a(World worldIn, EntityPlayer playerIn, EnumHand hand) {
        ItemStack itemStackIn = playerIn.func_184586_b(hand);
        return ActionResult.newResult(EnumActionResult.SUCCESS, itemStackIn);
    }


    public float damagePotential() {
        // This is the damage multiplier
        return 1.45F;
    }

    public double attackSpeed() {
        // This is the attack speed of the melee weapon
        return 0.9;
    }

    public float damageCutoff() {
        // This is the maximum amount of damage you can achieve on this weapon type
        return 30.0F;
    }

    public int[] getRepairParts() {
        // Unsure as of 11/28/2023 11:18PM
        return new int[]{1, 2};
    }

    public boolean dealDamage(ItemStack stack, EntityLivingBase player, Entity entity, float damage) {
        // Unsure, I think this just does the damage sweep...
        boolean hit = super.dealDamage(stack, player, entity, damage);

        return hit;
    }

    public float getRepairModifierForPart(int index) {
        return index == 1 ? 2.0F : 1.5F;
    }

    public ToolNBT buildTagData(List<Material> materials) {
        // The modifier and stats come from this I am fairly certain.
        HandleMaterialStats handle = (HandleMaterialStats)((Material)materials.get(0)).getStatsOrUnknown("handle");
        HeadMaterialStats head = (HeadMaterialStats)((Material)materials.get(1)).getStatsOrUnknown("head");
        ExtraMaterialStats guard = (ExtraMaterialStats)((Material)materials.get(3)).getStatsOrUnknown("extra");
        ToolNBT data = new ToolNBT();
        data.head(new HeadMaterialStats[]{head});
        data.extra(new ExtraMaterialStats[]{guard});
        data.handle(new HandleMaterialStats[]{handle});
        data.attack *= 1.3F;
        data.attack += 3.0F;
        data.durability = (int)((float)data.durability * 2.0F);
        return data;
    }

}


