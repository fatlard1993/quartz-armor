package justfatlard.quartz_armor;

import eu.pb4.polymer.core.api.item.PolymerItemGroupUtils;
import eu.pb4.polymer.resourcepack.api.PolymerResourcePackUtils;
import net.fabricmc.api.ModInitializer;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.component.type.AttributeModifiersComponent;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.item.ItemGroups;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;

public class Main implements ModInitializer {
	public static final String MOD_ID = "quartz-armor-justfatlard";

	// Quartz armor stats - high protection, low durability, high enchantability
	public static final int BASE_DURABILITY = 10; // Very low (iron is 15, diamond is 33)

	// Defense values (higher than diamond!)
	public static final int HELMET_DEFENSE = 4;
	public static final int CHESTPLATE_DEFENSE = 9;
	public static final int LEGGINGS_DEFENSE = 7;
	public static final int BOOTS_DEFENSE = 4;

	// Armor toughness (higher than diamond's 2)
	public static final double ARMOR_TOUGHNESS = 3.0;

	private static RegistryKey<Item> keyOf(String name) {
		return RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MOD_ID, name));
	}

	private static AttributeModifiersComponent createArmorAttributes(int defense, double toughness, AttributeModifierSlot slot) {
		return AttributeModifiersComponent.builder()
			.add(
				EntityAttributes.ARMOR,
				new EntityAttributeModifier(
					Identifier.of(MOD_ID, "armor_protection"),
					defense,
					EntityAttributeModifier.Operation.ADD_VALUE
				),
				slot
			)
			.add(
				EntityAttributes.ARMOR_TOUGHNESS,
				new EntityAttributeModifier(
					Identifier.of(MOD_ID, "armor_toughness"),
					toughness,
					EntityAttributeModifier.Operation.ADD_VALUE
				),
				slot
			)
			.build();
	}

	// Armor items - using leather armor as Polymer item to enable custom color rendering on player model
	public static final Item QUARTZ_HELMET = new QuartzArmorItem(
		EquipmentType.HELMET,
		HELMET_DEFENSE,
		new Item.Settings()
			.registryKey(keyOf("quartz_helmet"))
			.maxCount(1)
			.maxDamage(EquipmentType.HELMET.getMaxDamage(BASE_DURABILITY))
			.attributeModifiers(createArmorAttributes(HELMET_DEFENSE, ARMOR_TOUGHNESS, AttributeModifierSlot.HEAD)),
		Items.LEATHER_HELMET
	);

	public static final Item QUARTZ_CHESTPLATE = new QuartzArmorItem(
		EquipmentType.CHESTPLATE,
		CHESTPLATE_DEFENSE,
		new Item.Settings()
			.registryKey(keyOf("quartz_chestplate"))
			.maxCount(1)
			.maxDamage(EquipmentType.CHESTPLATE.getMaxDamage(BASE_DURABILITY))
			.attributeModifiers(createArmorAttributes(CHESTPLATE_DEFENSE, ARMOR_TOUGHNESS, AttributeModifierSlot.CHEST)),
		Items.LEATHER_CHESTPLATE
	);

	public static final Item QUARTZ_LEGGINGS = new QuartzArmorItem(
		EquipmentType.LEGGINGS,
		LEGGINGS_DEFENSE,
		new Item.Settings()
			.registryKey(keyOf("quartz_leggings"))
			.maxCount(1)
			.maxDamage(EquipmentType.LEGGINGS.getMaxDamage(BASE_DURABILITY))
			.attributeModifiers(createArmorAttributes(LEGGINGS_DEFENSE, ARMOR_TOUGHNESS, AttributeModifierSlot.LEGS)),
		Items.LEATHER_LEGGINGS
	);

	public static final Item QUARTZ_BOOTS = new QuartzArmorItem(
		EquipmentType.BOOTS,
		BOOTS_DEFENSE,
		new Item.Settings()
			.registryKey(keyOf("quartz_boots"))
			.maxCount(1)
			.maxDamage(EquipmentType.BOOTS.getMaxDamage(BASE_DURABILITY))
			.attributeModifiers(createArmorAttributes(BOOTS_DEFENSE, ARMOR_TOUGHNESS, AttributeModifierSlot.FEET)),
		Items.LEATHER_BOOTS
	);

	@Override
	public void onInitialize() {
		PolymerResourcePackUtils.addModAssets(MOD_ID);
		PolymerResourcePackUtils.markAsRequired();

		Registry.register(Registries.ITEM, keyOf("quartz_helmet"), QUARTZ_HELMET);
		Registry.register(Registries.ITEM, keyOf("quartz_chestplate"), QUARTZ_CHESTPLATE);
		Registry.register(Registries.ITEM, keyOf("quartz_leggings"), QUARTZ_LEGGINGS);
		Registry.register(Registries.ITEM, keyOf("quartz_boots"), QUARTZ_BOOTS);

		ItemGroup quartzArmorGroup = PolymerItemGroupUtils.builder()
			.displayName(Text.literal("Quartz Armor"))
			.icon(() -> new ItemStack(QUARTZ_CHESTPLATE))
			.entries((context, entries) -> {
				entries.add(new ItemStack(QUARTZ_HELMET));
				entries.add(new ItemStack(QUARTZ_CHESTPLATE));
				entries.add(new ItemStack(QUARTZ_LEGGINGS));
				entries.add(new ItemStack(QUARTZ_BOOTS));
			})
			.build();
		PolymerItemGroupUtils.registerPolymerItemGroup(Identifier.of(MOD_ID, "quartz_armor"), quartzArmorGroup);

		// Add armor to vanilla Combat creative tab
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entries -> {
			entries.add(QUARTZ_HELMET);
			entries.add(QUARTZ_CHESTPLATE);
			entries.add(QUARTZ_LEGGINGS);
			entries.add(QUARTZ_BOOTS);
		});

		System.out.println("[quartz-armor] Loaded quartz-armor (server-side with Polymer)");
	}
}
