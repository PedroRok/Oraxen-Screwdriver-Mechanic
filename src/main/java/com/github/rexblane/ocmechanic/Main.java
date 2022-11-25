package com.github.rexblane.ocmechanic;

import com.github.rexblane.ocmechanic.mechanic.ScrewdriverMechanicFactory;
import io.th0rgal.oraxen.mechanics.MechanicsManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

	@Override
	public void onEnable() {
		MechanicsManager.registerMechanicFactory("screwdriver", ScrewdriverMechanicFactory::new);
	}

	@Override
	public void onDisable() {
	}
}
