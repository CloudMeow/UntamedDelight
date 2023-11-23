package cloudmeow.untameddelight.registry;

import cloudmeow.untameddelight.UntamedDelight;
import cloudmeow.untameddelight.block.DonerKebabBlock;
import cloudmeow.untameddelight.block.PizzaBlock;
import cloudmeow.untameddelight.block.SourSunfishBrothBlock;
import cloudmeow.untameddelight.block.SteamedKingCrabBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class UDBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, UntamedDelight.MODID);

    public static final RegistryObject<Block> STEAMED_KING_CRAB_BLOCK = BLOCKS.register("steamed_king_crab_block",
            () -> new SteamedKingCrabBlock(Block.Properties.copy(Blocks.CAKE)));
    public static final RegistryObject<Block> SOUR_SUNFISH_BROTH_BLOCK = BLOCKS.register("sour_sunfish_broth_block",
            () -> new SourSunfishBrothBlock(Block.Properties.copy(Blocks.WHITE_WOOL), UDItems.SOUR_SUNFISH_BROTH, true));
    public static final RegistryObject<Block> BISON_PIZZA_BLOCK = BLOCKS.register("bison_pizza_block",
            () -> new PizzaBlock(Block.Properties.copy(Blocks.WHITE_WOOL), UDItems.BISON_PIZZA_SLICE, false));
    public static final RegistryObject<Block> DONER_KEBAB_BLOCK = BLOCKS.register("doner_kebab_block",
            () -> new DonerKebabBlock(Block.Properties.copy(Blocks.IRON_BLOCK), UDItems.DONER_KEBAB, true));

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
