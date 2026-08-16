package justfatlard.quartz_armor;

import justfatlard.pandorical.api.ItemRegistration;
import justfatlard.pandorical.api.PandoricalApi;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.item.equipment.EquipmentAssets;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class Main implements ModInitializer {
	public static final String MOD_ID = "quartz-armor-justfatlard";
	private static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static final TagKey<Item> REPAIR_ITEMS = TagKey.create(
		Registries.ITEM, Identifier.fromNamespaceAndPath(MOD_ID, "quartz_armor_repair_items")
	);

	// Quartz armor material: high protection, low durability, high enchantability
	public static final ArmorMaterial QUARTZ_ARMOR_MATERIAL = new ArmorMaterial(
		10,                                    // durability (very low)
		Map.of(                                // defense per slot (higher than diamond)
			ArmorType.HELMET, 4,
			ArmorType.CHESTPLATE, 9,
			ArmorType.LEGGINGS, 7,
			ArmorType.BOOTS, 4
		),
		30,                                    // enchantability (very high)
		SoundEvents.ARMOR_EQUIP_DIAMOND,       // equip sound
		3.0f,                                  // toughness (higher than diamond's 2)
		0.0f,                                  // knockback resistance
		REPAIR_ITEMS,                          // repair ingredient
		EquipmentAssets.DIAMOND                // asset (visual fallback)
	);

	private static ResourceKey<Item> keyOf(String name) {
		return ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(MOD_ID, name));
	}

	private static final ResourceKey<CreativeModeTab> COMBAT_TAB = ResourceKey.create(
		Registries.CREATIVE_MODE_TAB, Identifier.fromNamespaceAndPath("minecraft", "combat")
	);

	public static final Item QUARTZ_HELMET = new QuartzArmorItem(
		new Item.Properties()
			.setId(keyOf("quartz_helmet"))
			.humanoidArmor(QUARTZ_ARMOR_MATERIAL, ArmorType.HELMET)
	);

	public static final Item QUARTZ_CHESTPLATE = new QuartzArmorItem(
		new Item.Properties()
			.setId(keyOf("quartz_chestplate"))
			.humanoidArmor(QUARTZ_ARMOR_MATERIAL, ArmorType.CHESTPLATE)
	);

	public static final Item QUARTZ_LEGGINGS = new QuartzArmorItem(
		new Item.Properties()
			.setId(keyOf("quartz_leggings"))
			.humanoidArmor(QUARTZ_ARMOR_MATERIAL, ArmorType.LEGGINGS)
	);

	public static final Item QUARTZ_BOOTS = new QuartzArmorItem(
		new Item.Properties()
			.setId(keyOf("quartz_boots"))
			.humanoidArmor(QUARTZ_ARMOR_MATERIAL, ArmorType.BOOTS)
	);

	@Override
	public void onInitialize() {
		if (PandoricalApi.isAvailable()) {
			for (String name : new String[] { "quartz_helmet", "quartz_chestplate", "quartz_leggings", "quartz_boots" }) {
				PandoricalApi.content().registerItem(MOD_ID + ":" + name, new ItemRegistration()
					.model(MOD_ID + ":item/" + name)
					.maxStackSize(1));
			}
			PandoricalApi.content().registerModAssets(MOD_ID);
		}

		Registry.register(BuiltInRegistries.ITEM, keyOf("quartz_helmet"), QUARTZ_HELMET);
		Registry.register(BuiltInRegistries.ITEM, keyOf("quartz_chestplate"), QUARTZ_CHESTPLATE);
		Registry.register(BuiltInRegistries.ITEM, keyOf("quartz_leggings"), QUARTZ_LEGGINGS);
		Registry.register(BuiltInRegistries.ITEM, keyOf("quartz_boots"), QUARTZ_BOOTS);

		CreativeModeTabEvents.modifyOutputEvent(COMBAT_TAB).register(entries -> {
			entries.accept(QUARTZ_HELMET);
			entries.accept(QUARTZ_CHESTPLATE);
			entries.accept(QUARTZ_LEGGINGS);
			entries.accept(QUARTZ_BOOTS);
		});

		LOGGER.info("Loaded quartz-armor (server-side with Pandorical)");
	}
}
