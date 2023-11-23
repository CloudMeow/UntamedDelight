package cloudmeow.untameddelight.tag;

import cloudmeow.untameddelight.UntamedDelight;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class UDTags {
    public static final TagKey<Item> ENHANCE_BEARPOWER_ITEM = modItemTag("enhance_bearpower_items");

    private static TagKey<Item> modItemTag(String path) {
        return TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation(UntamedDelight.MODID, path));
    }
}
