package cloudmeow.untameddelight.event;

import cloudmeow.untameddelight.UntamedDelight;
import cloudmeow.untameddelight.registry.UDEffects;
import cloudmeow.untameddelight.tag.UDTags;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.event.entity.player.ItemFishedEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = UntamedDelight.MODID)
public class UDEvent {
    @SubscribeEvent
    public static void onUseItem(LivingEntityUseItemEvent.Finish event){
        LivingEntity eater = event.getEntity();
        if (eater.getEffect(UDEffects.BEAR_POWER.get()) != null) {
            ItemStack stack = event.getItem();
            if(stack.is(UDTags.ENHANCE_BEARPOWER_ITEM)){
                MobEffectInstance morepower = eater.getEffect(UDEffects.BEAR_POWER.get());
                if (morepower.getAmplifier() < 5) {
                    MobEffectInstance enhance = new MobEffectInstance(morepower.getEffect(), morepower.getDuration(), morepower.getAmplifier() + 1, morepower.isAmbient(), morepower.isVisible(), morepower.showIcon());
                    eater.removeEffectNoUpdate(UDEffects.BEAR_POWER.get());
                    eater.addEffect(enhance);
                }
            }
        }
    }

    @SubscribeEvent
    public  static void onFish(ItemFishedEvent event){
        LivingEntity fisher = event.getEntity();
        if (fisher.getEffect(UDEffects.MOMORA_MORA.get()) != null) {
            event.setCanceled(true);
        }
    }
}
