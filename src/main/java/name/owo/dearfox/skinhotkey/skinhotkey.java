package name.owo.dearfox.skinhotkey;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.player.PlayerModelPart;
//import net.minecraftforge.client.ClientRegistry;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.client.settings.KeyConflictContext;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.glfw.GLFW;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("skinhotkey")
public class skinhotkey {
    private static final Logger LOGGER = LogManager.getLogger();
    //Группы
    private static final KeyMapping skin_key_all = new KeyMapping(
            "option.skin-key-all", KeyConflictContext.UNIVERSAL, InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_UNKNOWN,
            "option.skin-hotkey.group.category");
    private static final KeyMapping skin_key_top = new KeyMapping(
            "option.skin-key-top", KeyConflictContext.UNIVERSAL, InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_UNKNOWN,
            "option.skin-hotkey.group.category");
    private static final KeyMapping skin_key_legs = new KeyMapping(
            "option.skin-key-legs", KeyConflictContext.UNIVERSAL, InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_UNKNOWN,
            "option.skin-hotkey.group.category");

    //Части
    //Голова
    private static final KeyMapping skin_key_hat = new KeyMapping(
            "option.skin-key-hat", KeyConflictContext.UNIVERSAL, InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_UNKNOWN,
            "option.skin-hotkey.part.category");
    //Тело
    private static final KeyMapping skin_key_jacket = new KeyMapping(
            "option.skin-key-jacket", KeyConflictContext.UNIVERSAL, InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_UNKNOWN,
            "option.skin-hotkey.part.category");
    //Рука правая
    private static final KeyMapping skin_key_right_sleeve = new KeyMapping(
            "option.skin-key-right-sleeve", KeyConflictContext.UNIVERSAL, InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_UNKNOWN,
            "option.skin-hotkey.part.category");
    //Рука левая
    private static final KeyMapping skin_key_left_sleeve = new KeyMapping(
            "option.skin-key-left-sleeve", KeyConflictContext.UNIVERSAL, InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_UNKNOWN,
            "option.skin-hotkey.part.category");
    //Нога правая
    private static final KeyMapping skin_key_right_pains_leg = new KeyMapping(
            "option.skin-key-right-pains-leg", KeyConflictContext.UNIVERSAL, InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_UNKNOWN,
            "option.skin-hotkey.part.category");
    //Нога левая
    private static final KeyMapping skin_key_left_pains_leg = new KeyMapping(
            "option.skin-key-left-pains-leg", KeyConflictContext.UNIVERSAL, InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_UNKNOWN,
            "option.skin-hotkey.part.category");
    //Плащ
    private static final KeyMapping skin_key_cape = new KeyMapping(
            "option.skin-key-cape", KeyConflictContext.UNIVERSAL, InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_UNKNOWN,
            "option.skin-hotkey.part.category");

    //Переключатели Групп (переменные)
    final boolean[] SkinHotkeyAll = {false};
    final boolean[] SkinHotkeyTop = {false};
    final boolean[] SkinHotkeyLegs = {false};
    public skinhotkey() {
        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::registerKeyBinding);
        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }
    // > = 1.19
    //private void setup(final FMLCommonSetupEvent event) {
        //Группы
        //ClientRegistry.registerKeyBinding(skin_key_all);
        //ClientRegistry.registerKeyBinding(skin_key_top);
        //ClientRegistry.registerKeyBinding(skin_key_legs);
        ////Части
        //ClientRegistry.registerKeyBinding(skin_key_hat);
        //ClientRegistry.registerKeyBinding(skin_key_jacket);
        //ClientRegistry.registerKeyBinding(skin_key_right_sleeve);
        //ClientRegistry.registerKeyBinding(skin_key_left_sleeve);
        //ClientRegistry.registerKeyBinding(skin_key_right_pains_leg);
        //ClientRegistry.registerKeyBinding(skin_key_left_pains_leg);
        //ClientRegistry.registerKeyBinding(skin_key_cape);

    //}

    private void registerKeyBinding(RegisterKeyMappingsEvent event) {
        // 1.19.4 +
        //Группы
        event.register(skin_key_all);
        event.register(skin_key_top);
        event.register(skin_key_legs);
        //Части
        event.register(skin_key_hat);
        event.register(skin_key_jacket);
        event.register(skin_key_right_sleeve);
        event.register(skin_key_left_sleeve);
        event.register(skin_key_right_pains_leg);
        event.register(skin_key_left_pains_leg);
        event.register(skin_key_cape);
    }

    @SubscribeEvent
    public void clientTick (TickEvent.ClientTickEvent event) {
// Группы

        // вкл/выкл все слои
        while (skin_key_all.consumeClick()) {
            //Minecraft.getInstance().options.toggleModelPart(PlayerModelPart.CAPE, SkinHotkeyAll[0]);
            Minecraft.getInstance().options.toggleModelPart(PlayerModelPart.JACKET, SkinHotkeyAll[0]);
            Minecraft.getInstance().options.toggleModelPart(PlayerModelPart.LEFT_SLEEVE, SkinHotkeyAll[0]);
            Minecraft.getInstance().options.toggleModelPart(PlayerModelPart.RIGHT_SLEEVE, SkinHotkeyAll[0]);
            Minecraft.getInstance().options.toggleModelPart(PlayerModelPart.LEFT_PANTS_LEG, SkinHotkeyAll[0]);
            Minecraft.getInstance().options.toggleModelPart(PlayerModelPart.RIGHT_PANTS_LEG, SkinHotkeyAll[0]);
            Minecraft.getInstance().options.toggleModelPart(PlayerModelPart.HAT, SkinHotkeyAll[0]);
            SkinHotkeyAll[0] = !SkinHotkeyAll[0];
        }
        // вкл/выкл рукова и торс
        while (skin_key_top.consumeClick()) {
            Minecraft.getInstance().options.toggleModelPart(PlayerModelPart.JACKET, SkinHotkeyTop[0]);
            Minecraft.getInstance().options.toggleModelPart(PlayerModelPart.LEFT_SLEEVE, SkinHotkeyTop[0]);
            Minecraft.getInstance().options.toggleModelPart(PlayerModelPart.RIGHT_SLEEVE, SkinHotkeyTop[0]);
            SkinHotkeyTop[0] = !SkinHotkeyTop[0];
        }
        // вкл/выкл ноги
        while (skin_key_legs.consumeClick()) {
            Minecraft.getInstance().options.toggleModelPart(PlayerModelPart.LEFT_PANTS_LEG, SkinHotkeyLegs[0]);
            Minecraft.getInstance().options.toggleModelPart(PlayerModelPart.RIGHT_PANTS_LEG, SkinHotkeyLegs[0]);
            SkinHotkeyLegs[0] = !SkinHotkeyLegs[0];
        }
        // Отдельные части

        // вкл/выкл Голова
        while (skin_key_hat.consumeClick()) {
            //LOGGER.info("Голова");
            Minecraft.getInstance().options.toggleModelPart(PlayerModelPart.HAT, !Minecraft.getInstance().options.isModelPartEnabled(PlayerModelPart.HAT));
            //if (skin_key_hat.getKey().equals(skin_key_jacket.getKey())){
            //    Minecraft.getInstance().options.toggleModelPart(PlayerModelPart.JACKET, !Minecraft.getInstance().options.isModelPartEnabled(PlayerModelPart.JACKET));
            //}
            //if (skin_key_hat.getKey().equals(skin_key_right_sleeve.getKey())){
            //    Minecraft.getInstance().options.toggleModelPart(PlayerModelPart.RIGHT_SLEEVE, !Minecraft.getInstance().options.isModelPartEnabled(PlayerModelPart.RIGHT_SLEEVE));
            //}
            //if (skin_key_hat.getKey().equals(skin_key_left_sleeve.getKey())){
            //    Minecraft.getInstance().options.toggleModelPart(PlayerModelPart.LEFT_SLEEVE, !Minecraft.getInstance().options.isModelPartEnabled(PlayerModelPart.LEFT_SLEEVE));
            //}
            //if (skin_key_hat.getKey().equals(skin_key_right_pains_leg.getKey())){
            //    Minecraft.getInstance().options.toggleModelPart(PlayerModelPart.RIGHT_PANTS_LEG, !Minecraft.getInstance().options.isModelPartEnabled(PlayerModelPart.RIGHT_PANTS_LEG));
            //}
            //if (skin_key_hat.getKey().equals(skin_key_left_pains_leg.getKey())){
            //    Minecraft.getInstance().options.toggleModelPart(PlayerModelPart.LEFT_PANTS_LEG, !Minecraft.getInstance().options.isModelPartEnabled(PlayerModelPart.LEFT_PANTS_LEG));
            //}
            //if (skin_key_hat.getKey().equals(skin_key_cape.getKey())){
            //    Minecraft.getInstance().options.toggleModelPart(PlayerModelPart.CAPE, !Minecraft.getInstance().options.isModelPartEnabled(PlayerModelPart.CAPE));
            //}
        }
        // вкл/выкл Тело
        while (skin_key_jacket.consumeClick()) {
            //LOGGER.info("Тело");
            //if (skin_key_jacket.getKey().equals(skin_key_hat.getKey())){
            //    Minecraft.getInstance().options.toggleModelPart(PlayerModelPart.HAT, !Minecraft.getInstance().options.isModelPartEnabled(PlayerModelPart.HAT));
            //}
            Minecraft.getInstance().options.toggleModelPart(PlayerModelPart.JACKET, !Minecraft.getInstance().options.isModelPartEnabled(PlayerModelPart.JACKET));
            //if (skin_key_jacket.getKey().equals(skin_key_right_sleeve.getKey())){
            //    Minecraft.getInstance().options.toggleModelPart(PlayerModelPart.RIGHT_SLEEVE, !Minecraft.getInstance().options.isModelPartEnabled(PlayerModelPart.RIGHT_SLEEVE));
            //}
            //if (skin_key_jacket.getKey().equals(skin_key_left_sleeve.getKey())){
            //    Minecraft.getInstance().options.toggleModelPart(PlayerModelPart.LEFT_SLEEVE, !Minecraft.getInstance().options.isModelPartEnabled(PlayerModelPart.LEFT_SLEEVE));
            //}
            //if (skin_key_jacket.getKey().equals(skin_key_right_pains_leg.getKey())){
            //    Minecraft.getInstance().options.toggleModelPart(PlayerModelPart.RIGHT_PANTS_LEG, !Minecraft.getInstance().options.isModelPartEnabled(PlayerModelPart.RIGHT_PANTS_LEG));
            //}
            //if (skin_key_jacket.getKey().equals(skin_key_left_pains_leg.getKey())){
            //    Minecraft.getInstance().options.toggleModelPart(PlayerModelPart.LEFT_PANTS_LEG, !Minecraft.getInstance().options.isModelPartEnabled(PlayerModelPart.LEFT_PANTS_LEG));
            //}
            //if (skin_key_jacket.getKey().equals(skin_key_cape.getKey())){
            //    Minecraft.getInstance().options.toggleModelPart(PlayerModelPart.CAPE, !Minecraft.getInstance().options.isModelPartEnabled(PlayerModelPart.CAPE));
            //}
        }
        // вкл/выкл Рука правая
        while (skin_key_right_sleeve.consumeClick()) {
            //LOGGER.info("Рука правая");
            //if (skin_key_right_sleeve.getKey().equals(skin_key_hat.getKey())){
            //    Minecraft.getInstance().options.toggleModelPart(PlayerModelPart.HAT, !Minecraft.getInstance().options.isModelPartEnabled(PlayerModelPart.HAT));
            //}
            //if (skin_key_right_sleeve.getKey().equals(skin_key_jacket.getKey())){
            //    Minecraft.getInstance().options.toggleModelPart(PlayerModelPart.JACKET, !Minecraft.getInstance().options.isModelPartEnabled(PlayerModelPart.JACKET));
            //}
            Minecraft.getInstance().options.toggleModelPart(PlayerModelPart.RIGHT_SLEEVE, !Minecraft.getInstance().options.isModelPartEnabled(PlayerModelPart.RIGHT_SLEEVE));
            //if (skin_key_right_sleeve.getKey().equals(skin_key_left_sleeve.getKey())){
            //    Minecraft.getInstance().options.toggleModelPart(PlayerModelPart.LEFT_SLEEVE, !Minecraft.getInstance().options.isModelPartEnabled(PlayerModelPart.LEFT_SLEEVE));
            //}
            //if (skin_key_right_sleeve.getKey().equals(skin_key_right_pains_leg.getKey())){
            //    Minecraft.getInstance().options.toggleModelPart(PlayerModelPart.RIGHT_PANTS_LEG, !Minecraft.getInstance().options.isModelPartEnabled(PlayerModelPart.RIGHT_PANTS_LEG));
            //}
            //if (skin_key_right_sleeve.getKey().equals(skin_key_left_pains_leg.getKey())){
            //    Minecraft.getInstance().options.toggleModelPart(PlayerModelPart.LEFT_PANTS_LEG, !Minecraft.getInstance().options.isModelPartEnabled(PlayerModelPart.LEFT_PANTS_LEG));
            //}
            //if (skin_key_right_sleeve.getKey().equals(skin_key_cape.getKey())){
            //    Minecraft.getInstance().options.toggleModelPart(PlayerModelPart.CAPE, !Minecraft.getInstance().options.isModelPartEnabled(PlayerModelPart.CAPE));
            //}
        }
        // вкл/выкл Рука левая
        while (skin_key_left_sleeve.consumeClick()) {
            //LOGGER.info("Рука левая");
            //if (skin_key_left_sleeve.getKey().equals(skin_key_hat.getKey())){
            //    Minecraft.getInstance().options.toggleModelPart(PlayerModelPart.HAT, !Minecraft.getInstance().options.isModelPartEnabled(PlayerModelPart.HAT));
            //}
            //if (skin_key_left_sleeve.getKey().equals(skin_key_jacket.getKey())){
            //    Minecraft.getInstance().options.toggleModelPart(PlayerModelPart.JACKET, !Minecraft.getInstance().options.isModelPartEnabled(PlayerModelPart.JACKET));
            //}
            //if (skin_key_left_sleeve.getKey().equals(skin_key_right_sleeve.getKey())){
            //    Minecraft.getInstance().options.toggleModelPart(PlayerModelPart.RIGHT_SLEEVE, !Minecraft.getInstance().options.isModelPartEnabled(PlayerModelPart.RIGHT_SLEEVE));
            //}
            Minecraft.getInstance().options.toggleModelPart(PlayerModelPart.LEFT_SLEEVE, !Minecraft.getInstance().options.isModelPartEnabled(PlayerModelPart.LEFT_SLEEVE));
            //if (skin_key_left_sleeve.getKey().equals(skin_key_right_pains_leg.getKey())){
            //    Minecraft.getInstance().options.toggleModelPart(PlayerModelPart.RIGHT_PANTS_LEG, !Minecraft.getInstance().options.isModelPartEnabled(PlayerModelPart.RIGHT_PANTS_LEG));
            //}
            //if (skin_key_left_sleeve.getKey().equals(skin_key_left_pains_leg.getKey())){
            //    Minecraft.getInstance().options.toggleModelPart(PlayerModelPart.LEFT_PANTS_LEG, !Minecraft.getInstance().options.isModelPartEnabled(PlayerModelPart.LEFT_PANTS_LEG));
            //}
            //if (skin_key_left_sleeve.getKey().equals(skin_key_cape.getKey())){
            //    Minecraft.getInstance().options.toggleModelPart(PlayerModelPart.CAPE, !Minecraft.getInstance().options.isModelPartEnabled(PlayerModelPart.CAPE));
            //}
        }
        // вкл/выкл Нога правая
        while (skin_key_right_pains_leg.consumeClick()) {
            //LOGGER.info("Нога правая");
            //if (skin_key_right_pains_leg.getKey().equals(skin_key_hat.getKey())){
            //    Minecraft.getInstance().options.toggleModelPart(PlayerModelPart.HAT, !Minecraft.getInstance().options.isModelPartEnabled(PlayerModelPart.HAT));
            //}
            //if (skin_key_right_pains_leg.getKey().equals(skin_key_jacket.getKey())){
            //    Minecraft.getInstance().options.toggleModelPart(PlayerModelPart.JACKET, !Minecraft.getInstance().options.isModelPartEnabled(PlayerModelPart.JACKET));
            //}
            //if (skin_key_right_pains_leg.getKey().equals(skin_key_right_sleeve.getKey())){
            //    Minecraft.getInstance().options.toggleModelPart(PlayerModelPart.RIGHT_SLEEVE, !Minecraft.getInstance().options.isModelPartEnabled(PlayerModelPart.RIGHT_SLEEVE));
            //}
            //if (skin_key_right_pains_leg.getKey().equals(skin_key_left_sleeve.getKey())){
            //    Minecraft.getInstance().options.toggleModelPart(PlayerModelPart.LEFT_SLEEVE, !Minecraft.getInstance().options.isModelPartEnabled(PlayerModelPart.LEFT_SLEEVE));
            //}
            Minecraft.getInstance().options.toggleModelPart(PlayerModelPart.RIGHT_PANTS_LEG, !Minecraft.getInstance().options.isModelPartEnabled(PlayerModelPart.RIGHT_PANTS_LEG));
            //if (skin_key_right_pains_leg.getKey().equals(skin_key_left_pains_leg.getKey())){
            //    Minecraft.getInstance().options.toggleModelPart(PlayerModelPart.LEFT_PANTS_LEG, !Minecraft.getInstance().options.isModelPartEnabled(PlayerModelPart.LEFT_PANTS_LEG));
            //}
            //if (skin_key_right_pains_leg.getKey().equals(skin_key_cape.getKey())){
            //    Minecraft.getInstance().options.toggleModelPart(PlayerModelPart.CAPE, !Minecraft.getInstance().options.isModelPartEnabled(PlayerModelPart.CAPE));
            //}
        }
        // вкл/выкл Нога левая
        while (skin_key_left_pains_leg.consumeClick()) {
            //LOGGER.info("Нога левая");
            //if (skin_key_left_pains_leg.getKey().equals(skin_key_hat.getKey())){
            //    Minecraft.getInstance().options.toggleModelPart(PlayerModelPart.HAT, !Minecraft.getInstance().options.isModelPartEnabled(PlayerModelPart.HAT));
            //}
            //if (skin_key_left_pains_leg.getKey().equals(skin_key_jacket.getKey())){
            //    Minecraft.getInstance().options.toggleModelPart(PlayerModelPart.JACKET, !Minecraft.getInstance().options.isModelPartEnabled(PlayerModelPart.JACKET));
            //}
            //if (skin_key_left_pains_leg.getKey().equals(skin_key_right_sleeve.getKey())){
            //    Minecraft.getInstance().options.toggleModelPart(PlayerModelPart.RIGHT_SLEEVE, !Minecraft.getInstance().options.isModelPartEnabled(PlayerModelPart.RIGHT_SLEEVE));
            //}
            //if (skin_key_left_pains_leg.getKey().equals(skin_key_left_sleeve.getKey())){
            //    Minecraft.getInstance().options.toggleModelPart(PlayerModelPart.LEFT_SLEEVE, !Minecraft.getInstance().options.isModelPartEnabled(PlayerModelPart.LEFT_SLEEVE));
            //}
            //if (skin_key_left_pains_leg.getKey().equals(skin_key_right_pains_leg.getKey())){
            //    Minecraft.getInstance().options.toggleModelPart(PlayerModelPart.RIGHT_PANTS_LEG, !Minecraft.getInstance().options.isModelPartEnabled(PlayerModelPart.RIGHT_PANTS_LEG));
            //}
            Minecraft.getInstance().options.toggleModelPart(PlayerModelPart.LEFT_PANTS_LEG, !Minecraft.getInstance().options.isModelPartEnabled(PlayerModelPart.LEFT_PANTS_LEG));
            //if (skin_key_left_pains_leg.getKey().equals(skin_key_cape.getKey())){
            //    Minecraft.getInstance().options.toggleModelPart(PlayerModelPart.CAPE, !Minecraft.getInstance().options.isModelPartEnabled(PlayerModelPart.CAPE));
            //}
        }
        // вкл/выкл Плащ
        while (skin_key_cape.consumeClick()) {
            //LOGGER.info("Плащ");
            //if (skin_key_cape.getKey().equals(skin_key_hat.getKey())){
            //    Minecraft.getInstance().options.toggleModelPart(PlayerModelPart.HAT, !Minecraft.getInstance().options.isModelPartEnabled(PlayerModelPart.HAT));
            //}
            //if (skin_key_cape.getKey().equals(skin_key_jacket.getKey())){
            //    Minecraft.getInstance().options.toggleModelPart(PlayerModelPart.JACKET, !Minecraft.getInstance().options.isModelPartEnabled(PlayerModelPart.JACKET));
            //}
            //if (skin_key_cape.getKey().equals(skin_key_right_sleeve.getKey())){
            //    Minecraft.getInstance().options.toggleModelPart(PlayerModelPart.RIGHT_SLEEVE, !Minecraft.getInstance().options.isModelPartEnabled(PlayerModelPart.RIGHT_SLEEVE));
            //}
            //if (skin_key_cape.getKey().equals(skin_key_left_sleeve.getKey())){
            //    Minecraft.getInstance().options.toggleModelPart(PlayerModelPart.LEFT_SLEEVE, !Minecraft.getInstance().options.isModelPartEnabled(PlayerModelPart.LEFT_SLEEVE));
            //}
            //if (skin_key_cape.getKey().equals(skin_key_right_pains_leg.getKey())){
            //    Minecraft.getInstance().options.toggleModelPart(PlayerModelPart.RIGHT_PANTS_LEG, !Minecraft.getInstance().options.isModelPartEnabled(PlayerModelPart.RIGHT_PANTS_LEG));
            //}
            //if (skin_key_cape.getKey().equals(skin_key_left_pains_leg.getKey())){
            //    Minecraft.getInstance().options.toggleModelPart(PlayerModelPart.LEFT_PANTS_LEG, !Minecraft.getInstance().options.isModelPartEnabled(PlayerModelPart.LEFT_PANTS_LEG));
            //}
            Minecraft.getInstance().options.toggleModelPart(PlayerModelPart.CAPE, !Minecraft.getInstance().options.isModelPartEnabled(PlayerModelPart.CAPE));
        }
    }
}
