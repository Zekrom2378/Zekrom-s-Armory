package zekroms.armory.weapons.melee;

import java.util.List;
import javax.annotation.Nonnull;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import slimeknights.tconstruct.library.materials.ExtraMaterialStats;
import slimeknights.tconstruct.library.materials.HandleMaterialStats;
import slimeknights.tconstruct.library.materials.HeadMaterialStats;
import slimeknights.tconstruct.library.materials.Material;
import slimeknights.tconstruct.library.materials.MaterialTypes;
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
        super(PartMaterialType.handle(TinkerTools.toughToolRod),
                PartMaterialType.head(TinkerTools.largeSwordBlade),
                PartMaterialType.extra(TinkerTools.wideGuard));

        // This is designating the item to a tool category
        addCategory(Category.WEAPON);
    }


    @Override
    public float damagePotential() {
        // This is the damage multiplier
        return 1.45F;
    }
    @Override
    public double attackSpeed() {
        // This is the attack speed of the melee weapon
        return 0.9;
    }
    @Override
    public float damageCutoff() {
        // This is the maximum amount of damage you can achieve on this weapon type
        return 30.0F;
    }
    @Override
    public int[] getRepairParts() {
        // Unsure as of 11/28/2023 11:18PM
        return new int[]{1, 2};
    }
    @Override
    public boolean dealDamage(ItemStack stack, EntityLivingBase player, Entity entity, float damage) {
        // Unsure, I think this just does the damage sweep...
        boolean hit = super.dealDamage(stack, player, entity, damage);

        return hit;
    }
    @Override
    public float getRepairModifierForPart(int index) {
        return DURABILITY_MODIFIER;
    }
    @Override
    public ToolNBT buildTagData(List<Material> materials) {
        // The modifier and stats come from this I am fairly certain.
        HandleMaterialStats handle = materials.get(0).getStatsOrUnknown(MaterialTypes.HANDLE);
        HeadMaterialStats head = materials.get(1).getStatsOrUnknown(MaterialTypes.HEAD);
        ExtraMaterialStats guard = materials.get(2).getStatsOrUnknown(MaterialTypes.EXTRA);

        ToolNBT data = new ToolNBT();
        data.head(head);
        data.extra(guard);
        data.handle(handle);
        data.attack *= 1.3F;
        data.attack += 3.0F;
        data.durability *= DURABILITY_MODIFIER;
        return data;
    }

}


