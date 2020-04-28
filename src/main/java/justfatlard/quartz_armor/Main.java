package justfatlard.quartz_armor;

import net.fabricmc.api.ModInitializer;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

class QuartzArmorItem extends ArmorItem {
	public QuartzArmorItem(EquipmentSlot slot) {
		super(Main.QUARTZ_ARMOR_MATERIAL, slot, new Settings().maxCount(1).group(ItemGroup.COMBAT));
	}
}

public class Main implements ModInitializer {
	private final static String MOD_ID = "quartz-armor-justfatlard";

	public final static QuartzArmorMaterial QUARTZ_ARMOR_MATERIAL = new QuartzArmorMaterial();

	public final static QuartzArmorItem QUARTZ_HELMET_ITEM = new QuartzArmorItem(EquipmentSlot.HEAD);
	public final static QuartzArmorItem QUARTZ_CHESTPLATE_ITEM = new QuartzArmorItem(EquipmentSlot.CHEST);
	public final static QuartzArmorItem QUARTZ_LEGGINGS_ITEM = new QuartzArmorItem(EquipmentSlot.LEGS);
	public final static QuartzArmorItem QUARTZ_BOOTS_ITEM = new QuartzArmorItem(EquipmentSlot.FEET);

	@Override
	public void onInitialize(){
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "quartz_helmet"), QUARTZ_HELMET_ITEM);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "quartz_chestplate"), QUARTZ_CHESTPLATE_ITEM);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "quartz_leggings"), QUARTZ_LEGGINGS_ITEM);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "quartz_boots"), QUARTZ_BOOTS_ITEM);
	}
}
