package justfatlard.quartz_armor;

import justfatlard.quartz_armor.QuartzArmor;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemGroup;

public class QuartzArmorItem extends ArmorItem {
	public QuartzArmorItem(EquipmentSlot slot) {
		super(QuartzArmor.QUARTZ_ARMOR_MATERIAL, slot, new Settings().maxCount(1).group(ItemGroup.COMBAT));
	}
}
