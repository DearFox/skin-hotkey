package name.owo.dearfox.skinhotkey;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.client.util.InputMappings;
import net.minecraftforge.client.settings.KeyConflictContext;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.glfw.GLFW;


import static net.minecraft.entity.player.PlayerModelPart.*;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("skinhotkey")
public class Skinhotkey {

    private static final Logger LOGGER = LogManager.getLogger();
    //Группы
    private static final KeyBinding skin_key_all = new KeyBinding(
            "option.skin-key-all", KeyConflictContext.UNIVERSAL, InputMappings.Type.KEYSYM, GLFW.GLFW_KEY_UNKNOWN,
            "option.skin-hotkey.group.category");
    private static final KeyBinding skin_key_top = new KeyBinding(
            "option.skin-key-top", KeyConflictContext.UNIVERSAL, InputMappings.Type.KEYSYM, GLFW.GLFW_KEY_UNKNOWN,
            "option.skin-hotkey.group.category");
    private static final KeyBinding skin_key_legs = new KeyBinding(
            "option.skin-key-legs", KeyConflictContext.UNIVERSAL, InputMappings.Type.KEYSYM, GLFW.GLFW_KEY_UNKNOWN,
            "option.skin-hotkey.group.category");

    //Части
    //Голова
    private static final KeyBinding skin_key_hat = new KeyBinding(
            "option.skin-key-hat", KeyConflictContext.UNIVERSAL, InputMappings.Type.KEYSYM, GLFW.GLFW_KEY_UNKNOWN,
            "option.skin-hotkey.part.category");
    //Тело
    private static final KeyBinding skin_key_jacket = new KeyBinding(
            "option.skin-key-jacket", KeyConflictContext.UNIVERSAL, InputMappings.Type.KEYSYM, GLFW.GLFW_KEY_UNKNOWN,
            "option.skin-hotkey.part.category");
    //Рука правая
    private static final KeyBinding skin_key_right_sleeve = new KeyBinding(
            "option.skin-key-right-sleeve", KeyConflictContext.UNIVERSAL, InputMappings.Type.KEYSYM, GLFW.GLFW_KEY_UNKNOWN,
            "option.skin-hotkey.part.category");
    //Рука левая
    private static final KeyBinding skin_key_left_sleeve = new KeyBinding(
            "option.skin-key-left-sleeve", KeyConflictContext.UNIVERSAL, InputMappings.Type.KEYSYM, GLFW.GLFW_KEY_UNKNOWN,
            "option.skin-hotkey.part.category");
    //Нога правая
    private static final KeyBinding skin_key_right_pains_leg = new KeyBinding(
            "option.skin-key-right-pains-leg", KeyConflictContext.UNIVERSAL, InputMappings.Type.KEYSYM, GLFW.GLFW_KEY_UNKNOWN,
            "option.skin-hotkey.part.category");
    //Нога левая
    private static final KeyBinding skin_key_left_pains_leg = new KeyBinding(
            "option.skin-key-left-pains-leg", KeyConflictContext.UNIVERSAL, InputMappings.Type.KEYSYM, GLFW.GLFW_KEY_UNKNOWN,
            "option.skin-hotkey.part.category");
    //Плащ
    private static final KeyBinding skin_key_cape = new KeyBinding(
            "option.skin-key-cape", KeyConflictContext.UNIVERSAL, InputMappings.Type.KEYSYM, GLFW.GLFW_KEY_UNKNOWN,
            "option.skin-hotkey.part.category");

    //Переключатели Групп (переменные)
    final boolean[] SkinHotkeyAll = {false};
    final boolean[] SkinHotkeyTop = {false};
    final boolean[] SkinHotkeyLegs = {false};
    public Skinhotkey() {
        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
        //Группы
        ClientRegistry.registerKeyBinding(skin_key_all);
        ClientRegistry.registerKeyBinding(skin_key_top);
        ClientRegistry.registerKeyBinding(skin_key_legs);
        //Части
        ClientRegistry.registerKeyBinding(skin_key_hat);
        ClientRegistry.registerKeyBinding(skin_key_jacket);
        ClientRegistry.registerKeyBinding(skin_key_right_sleeve);
        ClientRegistry.registerKeyBinding(skin_key_left_sleeve);
        ClientRegistry.registerKeyBinding(skin_key_right_pains_leg);
        ClientRegistry.registerKeyBinding(skin_key_left_pains_leg);
        ClientRegistry.registerKeyBinding(skin_key_cape);
    }

    @SubscribeEvent
    public void clientTick (TickEvent.ClientTickEvent event) {
// Группы

        // вкл/выкл все слои
        while (skin_key_all.isPressed()) {
            //Minecraft.getInstance().options.toggleModelPart(PlayerModelPart.CAPE, SkinHotkeyAll[0]);
            Minecraft.getInstance().gameSettings.setModelPartEnabled(JACKET, SkinHotkeyAll[0]);
            Minecraft.getInstance().gameSettings.setModelPartEnabled(LEFT_SLEEVE, SkinHotkeyAll[0]);
            Minecraft.getInstance().gameSettings.setModelPartEnabled(RIGHT_SLEEVE, SkinHotkeyAll[0]);
            Minecraft.getInstance().gameSettings.setModelPartEnabled(LEFT_PANTS_LEG, SkinHotkeyAll[0]);
            Minecraft.getInstance().gameSettings.setModelPartEnabled(RIGHT_PANTS_LEG, SkinHotkeyAll[0]);
            Minecraft.getInstance().gameSettings.setModelPartEnabled(HAT, SkinHotkeyAll[0]);
            SkinHotkeyAll[0] = !SkinHotkeyAll[0];
        }
        // вкл/выкл рукова и торс
        while (skin_key_top.isPressed()) {
            Minecraft.getInstance().gameSettings.setModelPartEnabled(JACKET, SkinHotkeyTop[0]);
            Minecraft.getInstance().gameSettings.setModelPartEnabled(LEFT_SLEEVE, SkinHotkeyTop[0]);
            Minecraft.getInstance().gameSettings.setModelPartEnabled(RIGHT_SLEEVE, SkinHotkeyTop[0]);
            SkinHotkeyTop[0] = !SkinHotkeyTop[0];
        }
        // вкл/выкл ноги
        while (skin_key_legs.isPressed()) {
            Minecraft.getInstance().gameSettings.setModelPartEnabled(LEFT_PANTS_LEG, SkinHotkeyLegs[0]);
            Minecraft.getInstance().gameSettings.setModelPartEnabled(RIGHT_PANTS_LEG, SkinHotkeyLegs[0]);
            SkinHotkeyLegs[0] = !SkinHotkeyLegs[0];
        }
        // Отдельные части

        // вкл/выкл Голова
        while (skin_key_hat.isPressed()) {
            Minecraft.getInstance().gameSettings.setModelPartEnabled(HAT, !Minecraft.getInstance().gameSettings.getModelParts().contains(HAT));
            if (skin_key_hat.getKey().equals(skin_key_jacket.getKey())){
                Minecraft.getInstance().gameSettings.setModelPartEnabled(JACKET, !Minecraft.getInstance().gameSettings.getModelParts().contains(JACKET));
            }
            if (skin_key_hat.getKey().equals(skin_key_right_sleeve.getKey())){
                Minecraft.getInstance().gameSettings.setModelPartEnabled(RIGHT_SLEEVE, !Minecraft.getInstance().gameSettings.getModelParts().contains(RIGHT_SLEEVE));
            }
            if (skin_key_hat.getKey().equals(skin_key_left_sleeve.getKey())){
                Minecraft.getInstance().gameSettings.setModelPartEnabled(LEFT_SLEEVE, !Minecraft.getInstance().gameSettings.getModelParts().contains(LEFT_SLEEVE));
            }
            if (skin_key_hat.getKey().equals(skin_key_right_pains_leg.getKey())){
                Minecraft.getInstance().gameSettings.setModelPartEnabled(RIGHT_PANTS_LEG, !Minecraft.getInstance().gameSettings.getModelParts().contains(RIGHT_PANTS_LEG));
            }
            if (skin_key_hat.getKey().equals(skin_key_left_pains_leg.getKey())){
                Minecraft.getInstance().gameSettings.setModelPartEnabled(LEFT_PANTS_LEG, !Minecraft.getInstance().gameSettings.getModelParts().contains(LEFT_PANTS_LEG));
            }
            if (skin_key_hat.getKey().equals(skin_key_cape.getKey())){
                Minecraft.getInstance().gameSettings.setModelPartEnabled(CAPE, !Minecraft.getInstance().gameSettings.getModelParts().contains(CAPE));
            }
        }
        // вкл/выкл Тело
        while (skin_key_jacket.isPressed()) {
            if (skin_key_jacket.getKey().equals(skin_key_hat.getKey())){
                Minecraft.getInstance().gameSettings.setModelPartEnabled(HAT, !Minecraft.getInstance().gameSettings.getModelParts().contains(HAT));
            }
            Minecraft.getInstance().gameSettings.setModelPartEnabled(JACKET, !Minecraft.getInstance().gameSettings.getModelParts().contains(JACKET));
            if (skin_key_jacket.getKey().equals(skin_key_right_sleeve.getKey())){
                Minecraft.getInstance().gameSettings.setModelPartEnabled(RIGHT_SLEEVE, !Minecraft.getInstance().gameSettings.getModelParts().contains(RIGHT_SLEEVE));
            }
            if (skin_key_jacket.getKey().equals(skin_key_left_sleeve.getKey())){
                Minecraft.getInstance().gameSettings.setModelPartEnabled(LEFT_SLEEVE, !Minecraft.getInstance().gameSettings.getModelParts().contains(LEFT_SLEEVE));
            }
            if (skin_key_jacket.getKey().equals(skin_key_right_pains_leg.getKey())){
                Minecraft.getInstance().gameSettings.setModelPartEnabled(RIGHT_PANTS_LEG, !Minecraft.getInstance().gameSettings.getModelParts().contains(RIGHT_PANTS_LEG));
            }
            if (skin_key_jacket.getKey().equals(skin_key_left_pains_leg.getKey())){
                Minecraft.getInstance().gameSettings.setModelPartEnabled(LEFT_PANTS_LEG, !Minecraft.getInstance().gameSettings.getModelParts().contains(LEFT_PANTS_LEG));
            }
            if (skin_key_jacket.getKey().equals(skin_key_cape.getKey())){
                Minecraft.getInstance().gameSettings.setModelPartEnabled(CAPE, !Minecraft.getInstance().gameSettings.getModelParts().contains(CAPE));
            }
        }
        // вкл/выкл Рука правая
        while (skin_key_right_sleeve.isPressed()) {
            if (skin_key_right_sleeve.getKey().equals(skin_key_hat.getKey())){
                Minecraft.getInstance().gameSettings.setModelPartEnabled(HAT, !Minecraft.getInstance().gameSettings.getModelParts().contains(HAT));
            }
            if (skin_key_right_sleeve.getKey().equals(skin_key_jacket.getKey())){
                Minecraft.getInstance().gameSettings.setModelPartEnabled(JACKET, !Minecraft.getInstance().gameSettings.getModelParts().contains(JACKET));
            }
            Minecraft.getInstance().gameSettings.setModelPartEnabled(RIGHT_SLEEVE, !Minecraft.getInstance().gameSettings.getModelParts().contains(RIGHT_SLEEVE));
            if (skin_key_right_sleeve.getKey().equals(skin_key_left_sleeve.getKey())){
                Minecraft.getInstance().gameSettings.setModelPartEnabled(LEFT_SLEEVE, !Minecraft.getInstance().gameSettings.getModelParts().contains(LEFT_SLEEVE));
            }
            if (skin_key_right_sleeve.getKey().equals(skin_key_right_pains_leg.getKey())){
                Minecraft.getInstance().gameSettings.setModelPartEnabled(RIGHT_PANTS_LEG, !Minecraft.getInstance().gameSettings.getModelParts().contains(RIGHT_PANTS_LEG));
            }
            if (skin_key_right_sleeve.getKey().equals(skin_key_left_pains_leg.getKey())){
                Minecraft.getInstance().gameSettings.setModelPartEnabled(LEFT_PANTS_LEG, !Minecraft.getInstance().gameSettings.getModelParts().contains(LEFT_PANTS_LEG));
            }
            if (skin_key_right_sleeve.getKey().equals(skin_key_cape.getKey())){
                Minecraft.getInstance().gameSettings.setModelPartEnabled(CAPE, !Minecraft.getInstance().gameSettings.getModelParts().contains(CAPE));
            }
        }
        // вкл/выкл Рука левая
        while (skin_key_left_sleeve.isPressed()) {
            if (skin_key_left_sleeve.getKey().equals(skin_key_hat.getKey())){
                Minecraft.getInstance().gameSettings.setModelPartEnabled(HAT, !Minecraft.getInstance().gameSettings.getModelParts().contains(HAT));
            }
            if (skin_key_left_sleeve.getKey().equals(skin_key_jacket.getKey())){
                Minecraft.getInstance().gameSettings.setModelPartEnabled(JACKET, !Minecraft.getInstance().gameSettings.getModelParts().contains(JACKET));
            }
            if (skin_key_left_sleeve.getKey().equals(skin_key_right_sleeve.getKey())){
                Minecraft.getInstance().gameSettings.setModelPartEnabled(RIGHT_SLEEVE, !Minecraft.getInstance().gameSettings.getModelParts().contains(RIGHT_SLEEVE));
            }
            Minecraft.getInstance().gameSettings.setModelPartEnabled(LEFT_SLEEVE, !Minecraft.getInstance().gameSettings.getModelParts().contains(LEFT_SLEEVE));
            if (skin_key_left_sleeve.getKey().equals(skin_key_right_pains_leg.getKey())){
                Minecraft.getInstance().gameSettings.setModelPartEnabled(RIGHT_PANTS_LEG, !Minecraft.getInstance().gameSettings.getModelParts().contains(RIGHT_PANTS_LEG));
            }
            if (skin_key_left_sleeve.getKey().equals(skin_key_left_pains_leg.getKey())){
                Minecraft.getInstance().gameSettings.setModelPartEnabled(LEFT_PANTS_LEG, !Minecraft.getInstance().gameSettings.getModelParts().contains(LEFT_PANTS_LEG));
            }
            if (skin_key_left_sleeve.getKey().equals(skin_key_cape.getKey())){
                Minecraft.getInstance().gameSettings.setModelPartEnabled(CAPE, !Minecraft.getInstance().gameSettings.getModelParts().contains(CAPE));
            }
        }
        // вкл/выкл Нога правая
        while (skin_key_right_pains_leg.isPressed()) {
            if (skin_key_right_pains_leg.getKey().equals(skin_key_hat.getKey())){
                Minecraft.getInstance().gameSettings.setModelPartEnabled(HAT, !Minecraft.getInstance().gameSettings.getModelParts().contains(HAT));
            }
            if (skin_key_right_pains_leg.getKey().equals(skin_key_jacket.getKey())){
                Minecraft.getInstance().gameSettings.setModelPartEnabled(JACKET, !Minecraft.getInstance().gameSettings.getModelParts().contains(JACKET));
            }
            if (skin_key_right_pains_leg.getKey().equals(skin_key_right_sleeve.getKey())){
                Minecraft.getInstance().gameSettings.setModelPartEnabled(RIGHT_SLEEVE, !Minecraft.getInstance().gameSettings.getModelParts().contains(RIGHT_SLEEVE));
            }
            if (skin_key_right_pains_leg.getKey().equals(skin_key_left_sleeve.getKey())){
                Minecraft.getInstance().gameSettings.setModelPartEnabled(LEFT_SLEEVE, !Minecraft.getInstance().gameSettings.getModelParts().contains(LEFT_SLEEVE));
            }
            Minecraft.getInstance().gameSettings.setModelPartEnabled(RIGHT_PANTS_LEG, !Minecraft.getInstance().gameSettings.getModelParts().contains(RIGHT_PANTS_LEG));
            if (skin_key_right_pains_leg.getKey().equals(skin_key_left_pains_leg.getKey())){
                Minecraft.getInstance().gameSettings.setModelPartEnabled(LEFT_PANTS_LEG, !Minecraft.getInstance().gameSettings.getModelParts().contains(LEFT_PANTS_LEG));
            }
            if (skin_key_right_pains_leg.getKey().equals(skin_key_cape.getKey())){
                Minecraft.getInstance().gameSettings.setModelPartEnabled(CAPE, !Minecraft.getInstance().gameSettings.getModelParts().contains(CAPE));
            }
        }
        // вкл/выкл Нога левая
        while (skin_key_left_pains_leg.isPressed()) {
            if (skin_key_left_pains_leg.getKey().equals(skin_key_hat.getKey())){
                Minecraft.getInstance().gameSettings.setModelPartEnabled(HAT, !Minecraft.getInstance().gameSettings.getModelParts().contains(HAT));
            }
            if (skin_key_left_pains_leg.getKey().equals(skin_key_jacket.getKey())){
                Minecraft.getInstance().gameSettings.setModelPartEnabled(JACKET, !Minecraft.getInstance().gameSettings.getModelParts().contains(JACKET));
            }
            if (skin_key_left_pains_leg.getKey().equals(skin_key_right_sleeve.getKey())){
                Minecraft.getInstance().gameSettings.setModelPartEnabled(RIGHT_SLEEVE, !Minecraft.getInstance().gameSettings.getModelParts().contains(RIGHT_SLEEVE));
            }
            if (skin_key_left_pains_leg.getKey().equals(skin_key_left_sleeve.getKey())){
                Minecraft.getInstance().gameSettings.setModelPartEnabled(LEFT_SLEEVE, !Minecraft.getInstance().gameSettings.getModelParts().contains(LEFT_SLEEVE));
            }
            if (skin_key_left_pains_leg.getKey().equals(skin_key_right_pains_leg.getKey())){
                Minecraft.getInstance().gameSettings.setModelPartEnabled(RIGHT_PANTS_LEG, !Minecraft.getInstance().gameSettings.getModelParts().contains(RIGHT_PANTS_LEG));
            }
            Minecraft.getInstance().gameSettings.setModelPartEnabled(LEFT_PANTS_LEG, !Minecraft.getInstance().gameSettings.getModelParts().contains(LEFT_PANTS_LEG));
            if (skin_key_left_pains_leg.getKey().equals(skin_key_cape.getKey())){
                Minecraft.getInstance().gameSettings.setModelPartEnabled(CAPE, !Minecraft.getInstance().gameSettings.getModelParts().contains(CAPE));
            }
        }
        // вкл/выкл Плащ
        while (skin_key_cape.isPressed()) {
            if (skin_key_cape.getKey().equals(skin_key_hat.getKey())){
                Minecraft.getInstance().gameSettings.setModelPartEnabled(HAT, !Minecraft.getInstance().gameSettings.getModelParts().contains(HAT));
            }
            if (skin_key_cape.getKey().equals(skin_key_jacket.getKey())){
                Minecraft.getInstance().gameSettings.setModelPartEnabled(JACKET, !Minecraft.getInstance().gameSettings.getModelParts().contains(JACKET));
            }
            if (skin_key_cape.getKey().equals(skin_key_right_sleeve.getKey())){
                Minecraft.getInstance().gameSettings.setModelPartEnabled(RIGHT_SLEEVE, !Minecraft.getInstance().gameSettings.getModelParts().contains(RIGHT_SLEEVE));
            }
            if (skin_key_cape.getKey().equals(skin_key_left_sleeve.getKey())){
                Minecraft.getInstance().gameSettings.setModelPartEnabled(LEFT_SLEEVE, !Minecraft.getInstance().gameSettings.getModelParts().contains(LEFT_SLEEVE));
            }
            if (skin_key_cape.getKey().equals(skin_key_right_pains_leg.getKey())){
                Minecraft.getInstance().gameSettings.setModelPartEnabled(RIGHT_PANTS_LEG, !Minecraft.getInstance().gameSettings.getModelParts().contains(RIGHT_PANTS_LEG));
            }
            if (skin_key_cape.getKey().equals(skin_key_left_pains_leg.getKey())){
                Minecraft.getInstance().gameSettings.setModelPartEnabled(LEFT_PANTS_LEG, !Minecraft.getInstance().gameSettings.getModelParts().contains(LEFT_PANTS_LEG));
            }
            Minecraft.getInstance().gameSettings.setModelPartEnabled(CAPE, !Minecraft.getInstance().gameSettings.getModelParts().contains(CAPE));
        }
    }
}
