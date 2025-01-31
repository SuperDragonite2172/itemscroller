package fi.dy.masa.itemscroller.gui;

import javax.annotation.Nullable;
import com.google.common.collect.ImmutableList;
import net.minecraft.client.gui.GuiScreen;
import fi.dy.masa.itemscroller.Reference;
import fi.dy.masa.itemscroller.config.Configs;
import fi.dy.masa.itemscroller.config.Hotkeys;
import fi.dy.masa.malilib.gui.config.BaseConfigScreen;
import fi.dy.masa.malilib.gui.config.BaseConfigTab;
import fi.dy.masa.malilib.gui.config.ConfigTab;
import fi.dy.masa.malilib.util.data.ModInfo;

public class ConfigScreen
{
    public static final ModInfo MOD_INFO = Reference.MOD_INFO;

    private static final BaseConfigTab GENERIC = new BaseConfigTab(MOD_INFO, "generic",  -1, Configs.Generic.OPTIONS, ConfigScreen::create);
    private static final BaseConfigTab HOTKEYS = new BaseConfigTab(MOD_INFO, "hotkeys", 200, Hotkeys.HOTKEY_LIST,     ConfigScreen::create);
    private static final BaseConfigTab LISTS   = new BaseConfigTab(MOD_INFO, "lists",   200, Configs.Lists.OPTIONS,   ConfigScreen::create);
    private static final BaseConfigTab TOGGLES = new BaseConfigTab(MOD_INFO, "toggles",  -1, Configs.Toggles.OPTIONS, ConfigScreen::create);

    private static final ImmutableList<ConfigTab> TABS = ImmutableList.of(
            GENERIC,
            TOGGLES,
            HOTKEYS,
            LISTS
    );

    public static BaseConfigScreen create(@Nullable GuiScreen currentScreen)
    {
        return new BaseConfigScreen(MOD_INFO, null, TABS, GENERIC, "itemscroller.gui.title.configs");
    }

    public static ImmutableList<ConfigTab> getConfigTabs()
    {
        return TABS;
    }
}
