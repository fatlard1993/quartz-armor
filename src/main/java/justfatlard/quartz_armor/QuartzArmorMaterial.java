package justfatlard.quartz_armor;

import net.minecraft.block.Blocks;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

public class QuartzArmorMaterial implements ArmorMaterial {
	private final static int[] protection = new int[]{4, 7, 9, 4};

	@Override
	public int getDurability(EquipmentSlot slot){ return 128; }

	@Override
	public Ingredient getRepairIngredient(){
		return Ingredient.ofItems(Blocks.SMOOTH_QUARTZ);
	}

	@Override
	public int getEnchantability(){ return 30; }

	@Override
	public int getProtectionAmount(EquipmentSlot slot){ return protection[slot.getEntitySlotId()]; }

	@Override
	public String getName(){ return "quartz"; }

	@Override
	public SoundEvent getEquipSound(){ return SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND; }

	@Override
	public float getToughness(){ return 3; }
}
