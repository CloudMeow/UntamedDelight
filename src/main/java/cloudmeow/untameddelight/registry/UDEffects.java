package cloudmeow.untameddelight.registry;

import cloudmeow.untameddelight.UntamedDelight;
import cloudmeow.untameddelight.effect.BearPowerEffect;
import cloudmeow.untameddelight.effect.MomoraMoraEffect;
import net.minecraft.world.effect.MobEffect;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class UDEffects {
    public static final DeferredRegister<MobEffect> EFFECTS = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, UntamedDelight.MODID);

    public static final RegistryObject<MobEffect> BEAR_POWER = EFFECTS.register("bear_power", BearPowerEffect::new);
    public static final RegistryObject<MobEffect> MOMORA_MORA = EFFECTS.register("momora_mora", MomoraMoraEffect::new);
    public static void register(IEventBus eventBus){
        EFFECTS.register(eventBus);
    }
}