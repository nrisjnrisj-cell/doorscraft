package gerder06.doors;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModSounds {
  public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, DoorsMod.MODID);
  static {
    SOUNDS.register("rooms_door_sound", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(DoorsMod.MODID, "rooms_door_sound")));
    SOUNDS.register("skeleton_door_break", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(DoorsMod.MODID, "skeleton_door_break")));
    SOUNDS.register("flashlight_close", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(DoorsMod.MODID, "flashlight_close")));
    SOUNDS.register("lighter_close", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(DoorsMod.MODID, "lighter_close")));
    SOUNDS.register("flashlight_open", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(DoorsMod.MODID, "flashlight_open")));
    SOUNDS.register("lighter_open", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(DoorsMod.MODID, "lighter_open")));
    SOUNDS.register("shakelight_shake", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(DoorsMod.MODID, "shakelight_shake")));
    SOUNDS.register("shears_use", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(DoorsMod.MODID, "shears_use")));
    SOUNDS.register("fuse_place", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(DoorsMod.MODID, "fuse_place")));
    SOUNDS.register("generator_level_open", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(DoorsMod.MODID, "generator_level_open")));
    SOUNDS.register("hide_heartbeat", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(DoorsMod.MODID, "hide_heartbeat")));
    SOUNDS.register("hide_whisper", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(DoorsMod.MODID, "hide_whisper")));
    SOUNDS.register("hide_static", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(DoorsMod.MODID, "hide_static")));
    SOUNDS.register("hide_leave", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(DoorsMod.MODID, "hide_leave")));
    SOUNDS.register("crucifix_success", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(DoorsMod.MODID, "crucifix_success")));
    SOUNDS.register("crucifix_fail", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(DoorsMod.MODID, "crucifix_fail")));
    SOUNDS.register("holy_grenade.chant", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(DoorsMod.MODID, "holy_grenade.chant")));
    SOUNDS.register("subspace_tripmine", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(DoorsMod.MODID, "subspace_tripmine")));
  }
}
