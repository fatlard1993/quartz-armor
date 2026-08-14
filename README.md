# Quartz Armor

A Fabric mod that adds a full set of armor crafted from smooth quartz blocks. It's a glass-cannon armor tier: the highest protection and toughness in the game, but with durability so low it breaks quickly, trading longevity for raw defense.

## Features

- Helmet, chestplate, leggings, and boots crafted from smooth quartz blocks using standard vanilla armor crafting patterns
- Highest defense values in the game: more protection per piece than diamond armor
- Higher armor toughness than diamond
- Triple the enchantability of diamond, making these pieces easy to enchant well
- Very low base durability: the tradeoff for the stat boost
- Repairable with smooth quartz blocks
- Added to the vanilla Combat creative tab

### Armor Stats

| Stat | Quartz | Diamond |
|------|--------|---------|
| Helmet Defense | 4 | 3 |
| Chestplate Defense | 9 | 8 |
| Leggings Defense | 7 | 6 |
| Boots Defense | 4 | 3 |
| **Total Defense** | **24** | **20** |
| Armor Toughness | 3.0 | 2.0 |
| Base Durability | 10 | 33 |
| Enchantability | 30 | 10 |

## Requirements

Targets the Minecraft, Fabric Loader, and Fabric API versions declared in this mod's `gradle.properties`; check there for the exact currently-supported version.

## Pandorical

Quartz Armor is a server-side mod. If Pandorical is installed on the server, the mod uses `PandoricalApi.content().registerModAssets()` to sync its custom armor textures and models to Pandorical clients. Pandorical must be installed client-side to see the actual quartz armor appearance. Without it, the armor still functions with all of its stats; it just falls back to looking like diamond armor visually, since the vanilla-facing equipment asset is mapped to diamond as a fallback.

## Installation

Install alongside its declared dependencies (see `fabric.mod.json`).

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
