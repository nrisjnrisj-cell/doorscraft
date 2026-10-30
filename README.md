# DoorsCraft -> Minecraft 1.20.1 (Forge 47.x) — partial port

Rebuilt from the 1.16.5 jar (no source was available). Needs JDK 17.

## Build
Easiest: download the official Forge 1.20.1 MDK, copy `src/` from this folder over the MDK's `src/`,
(set `mod_id=doors` in gradle.properties), then run `gradlew build`. The jar appears in `build/libs/`.
This folder's build.gradle is a standard ForgeGradle 6 setup you can also try directly
(add the Gradle wrapper with `gradle wrapper`).

## Ported
- All 40 blocks, with the SAME block states as the original blockstate JSONs (facing/half/open/locked/part/...),
  so the original models, textures and blockstates work unchanged.
- All 83 items (models/textures reused), 18 sounds (sounds.json reused), lang files (en_us, fr_fr).
- 9 creative tabs (+ Halloween). Which item sits in which tab is a GUESS from item names.
- Two-block-tall placement/breaking, right-click open/close for doors, thin door hitboxes,
  lamps emit light, simple self-drop loot tables.
- Locked doors open with a key item (hotel_key / electrical_key / backdoor_key). Rules are a GUESS.

## NOT ported (needs the original logic or a rewrite)
- Block entities: hotel door numbers, hotel chest, long/little table, mine generator, loot locker, sound ambient block
- Multi-block assembly of closets, lockers, long tables, lamps (they place as single blocks)
- Item behaviours: flashlight, lighter, crucifix, shields, grenade, candy, starlight items, shears, etc.
- Snare entity (+ spawn egg), commands, events, network packets, GUI/HUD overlays, entity renderer
- Dropped `assets/minecraft/*` texture overrides (title screen, icons, widgets): they break 1.20.1 GUIs

## Likely tweaks after first run
- Door facing may be mirrored: flip getHorizontalDirection() in DoorsBlock.getStateForPlacement
- Block hardness/sounds are approximations (ModBlocks.java)
