package name.owo.dearfox.skinhotkey.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.render.entity.PlayerModelPart;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

@Environment(EnvType.CLIENT)
public class SkinHotkeyClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        final boolean[] SkinHotkeyAll = {false};
        final boolean[] SkinHotkeyTop = {false};
        final boolean[] SkinHotkeyLegs = {false};
        // Группы
        KeyBinding skin_key_all = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "option.skin-key-all",
                InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_UNKNOWN,
                "option.skin-hotkey.group.category"));
        KeyBinding skin_key_top = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "option.skin-key-top",
                InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_UNKNOWN,
                "option.skin-hotkey.group.category"));
        KeyBinding skin_key_legs = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "option.skin-key-legs",
                InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_UNKNOWN,
                "option.skin-hotkey.group.category"));

        // Отдельные части

        //Голова
        KeyBinding skin_key_hat = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "option.skin-key-hat",
                InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_UNKNOWN,
                "option.skin-hotkey.part.category"));
        //Тело
        KeyBinding skin_key_jacket = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "option.skin-key-jacket",
                InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_UNKNOWN,
                "option.skin-hotkey.part.category"));
        //Рука правая
        KeyBinding skin_key_right_sleeve = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "option.skin-key-right-sleeve",
                InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_UNKNOWN,
                "option.skin-hotkey.part.category"));
        //Рука левая
        KeyBinding skin_key_left_sleeve = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "option.skin-key-left-sleeve",
                InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_UNKNOWN,
                "option.skin-hotkey.part.category"));
        //Нога правая
        KeyBinding skin_key_right_pains_leg = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "option.skin-key-right-pains-leg",
                InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_UNKNOWN,
                "option.skin-hotkey.part.category"));
        //Нога левая
        KeyBinding skin_key_left_pains_leg = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "option.skin-key-left-pains-leg",
                InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_UNKNOWN,
                "option.skin-hotkey.part.category"));
        //Плащ
        KeyBinding skin_key_cape = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "option.skin-key-cape",
                InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_UNKNOWN,
                "option.skin-hotkey.part.category"));

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            // Группы

            // вкл/выкл все слои
            while (skin_key_all.wasPressed()) {
                //MinecraftClient.getInstance().options.togglePlayerModelPart(PlayerModelPart.CAPE, SkinHotkeyAll[0]);
                MinecraftClient.getInstance().options.togglePlayerModelPart(PlayerModelPart.JACKET, SkinHotkeyAll[0]);
                MinecraftClient.getInstance().options.togglePlayerModelPart(PlayerModelPart.LEFT_SLEEVE, SkinHotkeyAll[0]);
                MinecraftClient.getInstance().options.togglePlayerModelPart(PlayerModelPart.RIGHT_SLEEVE, SkinHotkeyAll[0]);
                MinecraftClient.getInstance().options.togglePlayerModelPart(PlayerModelPart.LEFT_PANTS_LEG, SkinHotkeyAll[0]);
                MinecraftClient.getInstance().options.togglePlayerModelPart(PlayerModelPart.RIGHT_PANTS_LEG, SkinHotkeyAll[0]);
                MinecraftClient.getInstance().options.togglePlayerModelPart(PlayerModelPart.HAT, SkinHotkeyAll[0]);
                SkinHotkeyAll[0] = !SkinHotkeyAll[0];
            }
            // вкл/выкл рукова и торс
            while (skin_key_top.wasPressed()) {
                MinecraftClient.getInstance().options.togglePlayerModelPart(PlayerModelPart.JACKET, SkinHotkeyTop[0]);
                MinecraftClient.getInstance().options.togglePlayerModelPart(PlayerModelPart.LEFT_SLEEVE, SkinHotkeyTop[0]);
                MinecraftClient.getInstance().options.togglePlayerModelPart(PlayerModelPart.RIGHT_SLEEVE, SkinHotkeyTop[0]);
                SkinHotkeyTop[0] = !SkinHotkeyTop[0];
            }
            // вкл/выкл ноги
            while (skin_key_legs.wasPressed()) {
                MinecraftClient.getInstance().options.togglePlayerModelPart(PlayerModelPart.LEFT_PANTS_LEG, SkinHotkeyLegs[0]);
                MinecraftClient.getInstance().options.togglePlayerModelPart(PlayerModelPart.RIGHT_PANTS_LEG, SkinHotkeyLegs[0]);
                SkinHotkeyLegs[0] = !SkinHotkeyLegs[0];
            }
            // Отдельные части

            // вкл/выкл Голову
            while (skin_key_hat.wasPressed()) {
                MinecraftClient.getInstance().options.togglePlayerModelPart(PlayerModelPart.HAT, !MinecraftClient.getInstance().options.isPlayerModelPartEnabled(PlayerModelPart.HAT));
            }
            // вкл/выкл Тело
            while (skin_key_jacket.wasPressed()) {
                MinecraftClient.getInstance().options.togglePlayerModelPart(PlayerModelPart.JACKET, !MinecraftClient.getInstance().options.isPlayerModelPartEnabled(PlayerModelPart.JACKET));
            }
            // вкл/выкл Рука правая
            while (skin_key_right_sleeve.wasPressed()) {
                MinecraftClient.getInstance().options.togglePlayerModelPart(PlayerModelPart.RIGHT_SLEEVE, !MinecraftClient.getInstance().options.isPlayerModelPartEnabled(PlayerModelPart.RIGHT_SLEEVE));
            }
            // вкл/выкл Рука левая
            while (skin_key_left_sleeve.wasPressed()) {
                MinecraftClient.getInstance().options.togglePlayerModelPart(PlayerModelPart.LEFT_SLEEVE, !MinecraftClient.getInstance().options.isPlayerModelPartEnabled(PlayerModelPart.LEFT_SLEEVE));
            }
            // вкл/выкл Нога правая
            while (skin_key_right_pains_leg.wasPressed()) {
                MinecraftClient.getInstance().options.togglePlayerModelPart(PlayerModelPart.RIGHT_PANTS_LEG, !MinecraftClient.getInstance().options.isPlayerModelPartEnabled(PlayerModelPart.RIGHT_PANTS_LEG));
            }
            // вкл/выкл Нога левая
            while (skin_key_left_pains_leg.wasPressed()) {
                MinecraftClient.getInstance().options.togglePlayerModelPart(PlayerModelPart.LEFT_PANTS_LEG, !MinecraftClient.getInstance().options.isPlayerModelPartEnabled(PlayerModelPart.LEFT_PANTS_LEG));
            }
            // вкл/выкл Плащ
            while (skin_key_cape.wasPressed()) {
                MinecraftClient.getInstance().options.togglePlayerModelPart(PlayerModelPart.CAPE, !MinecraftClient.getInstance().options.isPlayerModelPartEnabled(PlayerModelPart.CAPE));
            }
        });
    }
}
