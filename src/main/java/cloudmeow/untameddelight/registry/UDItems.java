package cloudmeow.untameddelight.registry;

import cloudmeow.untameddelight.UDFoodValues;
import cloudmeow.untameddelight.UntamedDelight;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import vectorwing.farmersdelight.common.item.ConsumableItem;

public class UDItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, UntamedDelight.MODID);

    public static Item.Properties udTabItem() {
        return new Item.Properties().tab(UntamedDelight.TAB);
    }

    public static Item.Properties udFoodItem(FoodProperties food) {
        return new Item.Properties().food(food).tab(UntamedDelight.TAB);
    }

    public static Item.Properties udBowlFoodItem(FoodProperties food) {
        return new Item.Properties().food(food).craftRemainder(Items.BOWL).stacksTo(16).tab(UntamedDelight.TAB);
    }

    //Feast
    public static final RegistryObject<Item> STEAMED_KING_CRAB_BLOCK = ITEMS.register("steamed_king_crab_block",
            () -> new BlockItem(UDBlocks.STEAMED_KING_CRAB_BLOCK.get(), udTabItem().stacksTo(1)));
    public static final RegistryObject<Item> STEAMED_KING_CRAB = ITEMS.register("steamed_king_crab",
            () -> new ConsumableItem(udBowlFoodItem(UDFoodValues.STEAMED_KING_CRAB), true));
    public static final RegistryObject<Item> STEAMED_KING_CRAB_LEGS = ITEMS.register("steamed_king_crab_legs",
            () -> new ConsumableItem(udBowlFoodItem(UDFoodValues.STEAMED_KING_CRAB_LEGS), true));
    public static final RegistryObject<Item> STEAMED_EGG_WITH_KING_CRAB_ROE = ITEMS.register("steamed_egg_with_king_crab_roe",
            () -> new ConsumableItem(udBowlFoodItem(UDFoodValues.STEAMED_EGG_WITH_KING_CRAB_ROE), true));
    public static final RegistryObject<Item> SOUR_SUNFISH_BROTH_BLOCK = ITEMS.register("sour_sunfish_broth_block",
            () -> new BlockItem(UDBlocks.SOUR_SUNFISH_BROTH_BLOCK.get(), udTabItem().stacksTo(1)));
    public static final RegistryObject<Item> SOUR_SUNFISH_BROTH = ITEMS.register("sour_sunfish_broth",
            () -> new ConsumableItem(udBowlFoodItem(UDFoodValues.SOUR_SUNFISH_BROTH), true));
    public static final RegistryObject<Item> BISON_PIZZA_BLOCK = ITEMS.register("bison_pizza_block",
            () -> new BlockItem(UDBlocks.BISON_PIZZA_BLOCK.get(), udTabItem().stacksTo(1)));
    public static final RegistryObject<Item> BISON_PIZZA_SLICE = ITEMS.register("bison_pizza_slice",
            () -> new Item(udFoodItem(UDFoodValues.BISON_PIZZA_SLICE)));
    public static final RegistryObject<Item> DONER_KEBAB_BLOCK = ITEMS.register("doner_kebab_block",
            () -> new BlockItem(UDBlocks.DONER_KEBAB_BLOCK.get(), udTabItem().stacksTo(1)));
    public static final RegistryObject<Item> DONER_KEBAB = ITEMS.register("doner_kebab",
            () -> new Item(udFoodItem(UDFoodValues.DONER_KEBAB)));

    //Meal
    public static final RegistryObject<Item> GLAZED_SPADEFISH = ITEMS.register("glazed_spadefish",
            () -> new ConsumableItem(udBowlFoodItem(UDFoodValues.GLAZED_SPADEFISH), true));
    public static final RegistryObject<Item> FRIED_SEA_ANEMONE = ITEMS.register("fried_sea_anemone",
            () -> new ConsumableItem(udBowlFoodItem(UDFoodValues.FRIED_SEA_ANEMONE), true));
    public static final RegistryObject<Item> GALICIAN_STYLE_FOOTBALL_FISH = ITEMS.register("galician_style_football_fish",
            () -> new ConsumableItem(udBowlFoodItem(UDFoodValues.GALICIAN_STYLE_FOOTBALL_FISH), true));
    public static final RegistryObject<Item> GOLDEN_AROWANA = ITEMS.register("golden_arowana",
            () -> new ConsumableItem(udBowlFoodItem(UDFoodValues.GOLDEN_AROWANA), true));
    public static final RegistryObject<Item> SEARED_TRIGGERFISH = ITEMS.register("seared_triggerfish",
            () -> new ConsumableItem(udBowlFoodItem(UDFoodValues.SEARED_TRIGGERFISH), true));
    public static final RegistryObject<Item> PASTA_BISON = ITEMS.register("pasta_with_bison_meat",
            () -> new ConsumableItem(udBowlFoodItem(UDFoodValues.PASTA_BISON), true));
    public static final RegistryObject<Item> BOAR_STEW = ITEMS.register("boar_stew",
            () -> new ConsumableItem(udBowlFoodItem(UDFoodValues.BOAR_STEW), true));
    public static final RegistryObject<Item> BAKED_CHEESE_TREVALLY = ITEMS.register("baked_trevally_with_cheese",
            () -> new ConsumableItem(udBowlFoodItem(UDFoodValues.BAKED_CHEESE_TREVALLY), true));
    public static final RegistryObject<Item> CAMEL_MEAT_KARAHI = ITEMS.register("camel_meat_karahi",
            () -> new ConsumableItem(udBowlFoodItem(UDFoodValues.CAMEL_MEAT_KARAHI), true));

    //Item
    public static final RegistryObject<Item> SPICY_CATFISH = ITEMS.register("spicy_catfish",
            () -> new ConsumableItem(udBowlFoodItem(UDFoodValues.SPICY_CATFISH)));
    public static final RegistryObject<Item> TREVALLY_TATAKI = ITEMS.register("trevally_tataki",
            ()-> new ConsumableItem(udBowlFoodItem(UDFoodValues.TREVALLY_TATAKI)));
    public static final RegistryObject<Item> BOAR_HAMBURGER = ITEMS.register("boar_hamburger",
            ()-> new Item(udFoodItem(UDFoodValues.BOAR_HAMBURGER)));
    public static final RegistryObject<Item> BEAR_SANDWICH = ITEMS.register("bear_sandwich",
            ()-> new Item(udFoodItem(UDFoodValues.BEAR_SANDWICH)));
    public static final RegistryObject<Item> VIETNAMESE_BLACK_BEAR_PATE_CHAUD = ITEMS.register("vietnamese_black_bear_pate_chaud",
            ()-> new Item(udFoodItem(UDFoodValues.VIETNAMESE_BLACK_BEAR_PATE_CHAUD)));
    public static final RegistryObject<Item> MARINE_BARBECUE_STICK = ITEMS.register("marine_barbecue_stick",
            ()-> new Item(udFoodItem(UDFoodValues.MARINE_BARBECUE_STICK)));
    public static final RegistryObject<Item> SWEET_ZONGZI = ITEMS.register("sweet_zongzi",
            ()-> new Item(udFoodItem(UDFoodValues.SWEET_ZONGZI)));
    public static final RegistryObject<Item> YOLK_PORK_ZONGZI = ITEMS.register("yolk_pork_zongzi",
            ()-> new Item(udFoodItem(UDFoodValues.YOLK_PORK_ZONGZI)));
    public static final RegistryObject<Item> SMOKED_CATFISH = ITEMS.register("smoked_catfish",
            ()-> new Item(udFoodItem(UDFoodValues.SMOKED_CATFISH)));
    public static final RegistryObject<Item> REED_LEAF = ITEMS.register("reed_leaf",
            ()-> new Item(udTabItem()));
    public static final RegistryObject<Item> KING_CRAB = ITEMS.register("king_crab",
            ()-> new Item(udTabItem()));
    public static final RegistryObject<Item> KING_CRAB_BODY = ITEMS.register("king_crab_body",
            ()-> new Item(udTabItem()));
    public static final RegistryObject<Item> KING_CRAB_LEGS = ITEMS.register("king_crab_legs",
            ()-> new Item(udTabItem()));
    public static final RegistryObject<Item> CATFISH = ITEMS.register("catfish",
            ()-> new Item(udFoodItem(UDFoodValues.CATFISH)));
    public static final RegistryObject<Item> COOKED_CATFISH = ITEMS.register("cooked_catfish",
            ()-> new Item(udFoodItem(UDFoodValues.COOKED_CATFISH)));
    public static final RegistryObject<Item> FOOTBALL_FISH = ITEMS.register("football_fish",
            ()-> new Item(udFoodItem(UDFoodValues.FOOTBALL_FISH)));
    public static final RegistryObject<Item> COOKED_FOOTBALL_FISH = ITEMS.register("cooked_football_fish",
            ()-> new Item(udFoodItem(UDFoodValues.COOKED_FOOTBALL_FISH)));
    public static final RegistryObject<Item> SPADEFISH = ITEMS.register("spadefish",
            ()-> new Item(udFoodItem(UDFoodValues.SPADEFISH)));
    public static final RegistryObject<Item> COOKED_SPADEFISH = ITEMS.register("cooked_spadefish",
            ()-> new Item(udFoodItem(UDFoodValues.COOKED_SPADEFISH)));
    public static final RegistryObject<Item> SUNFISH = ITEMS.register("sunfish",
            ()-> new Item(udFoodItem(UDFoodValues.SUNFISH)));
    public static final RegistryObject<Item> COOKED_SUNFISH = ITEMS.register("cooked_sunfish",
            ()-> new Item(udFoodItem(UDFoodValues.COOKED_SUNFISH)));
    public static final RegistryObject<Item> TREVALLY = ITEMS.register("trevally",
            ()-> new Item(udFoodItem(UDFoodValues.TREVALLY)));
    public static final RegistryObject<Item> COOKED_TREVALLY = ITEMS.register("cooked_trevally",
            ()-> new Item(udFoodItem(UDFoodValues.COOKED_TREVALLY)));
    public static final RegistryObject<Item> TRIGGERFISH = ITEMS.register("triggerfish",
            ()-> new Item(udFoodItem(UDFoodValues.TRIGGERFISH)));
    public static final RegistryObject<Item> COOKED_TRIGGERFISH = ITEMS.register("cooked_triggerfish",
            ()-> new Item(udFoodItem(UDFoodValues.COOKED_TRIGGERFISH)));
    public static final RegistryObject<Item> AROWANA = ITEMS.register("arowana",
            ()-> new Item(udFoodItem(UDFoodValues.AROWANA)));
    public static final RegistryObject<Item> COOKED_AROWANA = ITEMS.register("cooked_arowana",
            ()-> new Item(udFoodItem(UDFoodValues.COOKED_AROWANA)));
    public static final RegistryObject<Item> SUNFISH_SLICE = ITEMS.register("sunfish_slice",
            ()-> new Item(udFoodItem(UDFoodValues.SUNFISH_SLICE)));
    public static final RegistryObject<Item> COOKED_SUNFISH_SLICE = ITEMS.register("cooked_sunfish_slice",
            ()-> new Item(udFoodItem(UDFoodValues.COOKED_SUNFISH_SLICE)));
    public static final RegistryObject<Item> TREVALLY_SLICE = ITEMS.register("trevally_slice",
            ()-> new Item(udFoodItem(UDFoodValues.TREVALLY_SLICE)));
    public static final RegistryObject<Item> COOKED_TREVALLY_SLICE = ITEMS.register("cooked_trevally_slice",
            ()-> new Item(udFoodItem(UDFoodValues.COOKED_TREVALLY_SLICE)));

    public static final RegistryObject<Item> SLICED_BEAR = ITEMS.register("sliced_bear",
            ()-> new Item(udFoodItem(UDFoodValues.SLICED_BEAR)));
    public static final RegistryObject<Item> BEAR_STEAK = ITEMS.register("bear_steak",
            ()-> new Item(udFoodItem(UDFoodValues.BEAR_STEAK)));
    public static final RegistryObject<Item> BOAR_CHOP = ITEMS.register("boar_chop",
            ()-> new Item(udFoodItem(UDFoodValues.BOAR_CHOP)));
    public static final RegistryObject<Item> COOKED_BOAR_CHOP = ITEMS.register("cooked_boar_chop",
            ()-> new Item(udFoodItem(UDFoodValues.COOKED_BOAR_CHOP)));
    public static final RegistryObject<Item> BISON_MEAT = ITEMS.register("bison_meat",
            ()-> new Item(udFoodItem(UDFoodValues.BISON_MEAT)));
    public static final RegistryObject<Item> COOKED_BISON_MEAT = ITEMS.register("cooked_bison_meat",
            ()-> new Item(udFoodItem(UDFoodValues.COOKED_BISON_MEAT)));
    public static final RegistryObject<Item> CAMEL_MEAT = ITEMS.register("camel_meat",
            ()-> new Item(udFoodItem(UDFoodValues.CAMEL_MEAT)));
    public static final RegistryObject<Item> COOKED_CAMEL_MEAT = ITEMS.register("cooked_camel_meat",
            ()-> new Item(udFoodItem(UDFoodValues.COOKED_CAMEL_MEAT)));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
