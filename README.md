# Quartz Armor

A Fabric mod that adds a full set of armor crafted from smooth quartz blocks. It's a glass-cannon armor tier: the highest protection and toughness in the game, but with durability so low it breaks quickly, trading longevity for raw defense.

## Screenshots

![The full set worn on an armour stand](img.png)
![Helmet, chestplate, leggings and boots](img2.png)

## Features

- Helmet, chestplate, leggings, and boots crafted from smooth quartz blocks using standard vanilla armor crafting patterns
- Highest defense values in the game: more protection per piece than diamond armor
- Higher armor toughness than diamond
- Triple the enchantability of diamond, making these pieces easy to enchant well
- Very low base durability: the tradeoff for the stat boost
- Repairable with smooth quartz blocks
- Accepts armor trims
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

## Pandorical

Quartz Armor runs server-side, and Pandorical is required: the server will not load this mod without it. It syncs the armor's textures and models through Pandorical's content sync.

Clients are the optional half. A player on a Pandorical client sees quartz armor. The worn armor's look is the mod's own `quartz` equipment asset, which reaches clients only through the content sync, so a vanilla client does not have it and cannot draw the worn armor as quartz (it is not mapped to diamond's). The stats are identical either way.

## Development

Installing is in [DEVELOPMENT.md](DEVELOPMENT.md).

## License

MIT, see [LICENSE](LICENSE).
