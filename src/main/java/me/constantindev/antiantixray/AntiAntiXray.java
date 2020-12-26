package me.constantindev.antiantixray;

import me.constantindev.antiantixray.Etc.Logger;
import me.constantindev.antiantixray.Etc.RefreshingJob;
import me.constantindev.antiantixray.Etc.Runner;
import me.constantindev.antiantixray.GUI.ProgressBar;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.options.KeyBinding;

import java.util.ArrayList;
import java.util.List;

import static org.lwjgl.glfw.GLFW.*;

public class AntiAntiXray implements ClientModInitializer {
    public static KeyBinding rvn = new KeyBinding("key.aax.refresh", GLFW_KEY_G, "key.categories.aax");
    public static KeyBinding removeBlockBeta = new KeyBinding("key.aax.remove", GLFW_KEY_M, "key.categories.aax");
    public static List<RefreshingJob> jobs = new ArrayList<>();

    public static Thread revealNewBlocks(int rad, long delayInMS) {
        ProgressBar pbar = new ProgressBar();
        MinecraftClient.getInstance().getToastManager().add(pbar);
        RefreshingJob rfj = new RefreshingJob(new Runner(rad, delayInMS, pbar), pbar);
        jobs.add(rfj);
        return rfj.runner;
    }

    @Override
    public void onInitializeClient() {
        Logger.info("Loading and initializing AAX...");

    }
}
