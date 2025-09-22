package com.mafuyu404.moveslikemafuyu;

import com.mafuyu404.moveslikemafuyu.network.NetworkHandler;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraft.client.KeyMapping;
import com.mojang.blaze3d.platform.InputConstants;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;


// The value here should match an entry in the META-INF/mods.toml file
@Mod(MovesLikeMafuyu.MODID)
public class MovesLikeMafuyu {

    // Define mod id in a common place for everything to reference
    public static final String MODID = "moveslikemafuyu";
    public static KeyMapping customActionKey;

    public MovesLikeMafuyu() {
        NetworkHandler.register();
        ModLoadingContext.get().registerConfig(
                ModConfig.Type.COMMON,
                Config.SPEC
        );
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientSetup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::registerKeyMappings);
    }

    private void clientSetup(final FMLClientSetupEvent event) {
        // Client-side specific setup, if any
    }

    @SubscribeEvent
    public void registerKeyMappings(RegisterKeyMappingsEvent event) {
        customActionKey = new KeyMapping(
            "key.moveslikemafuyu.custom_action", // 翻译键
            InputConstants.Type.KEYSYM,          // 键盘按键
            InputConstants.KEY_X,                // 默认按键为 'X'
            "category.moveslikemafuyu.keys"      // 类别
        );
        event.register(customActionKey);
    }
}