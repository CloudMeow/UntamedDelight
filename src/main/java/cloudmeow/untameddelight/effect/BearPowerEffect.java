package cloudmeow.untameddelight.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.*;

public class BearPowerEffect extends MobEffect {
    public BearPowerEffect() {
        super(MobEffectCategory.BENEFICIAL, 0);
        this.addAttributeModifier(Attributes.ATTACK_DAMAGE, "984C2030-4313-464B-9679-70C9ACCE58E5", 0.0F, AttributeModifier.Operation.ADDITION);
    }

    public double getAttributeModifierValue(int amplifier, AttributeModifier modifier) {
        return amplifier + 1;
    }

    public void applyEffectTick(LivingEntity entity, int amplifier) {
        this.addAttributeModifiers(entity, entity.getAttributes(), amplifier);
    }

    public boolean isDurationEffectTick(int duration, int amplifier) {
        return true;
    }
}
