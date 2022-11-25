package com.github.rexblane.ocmechanic.mechanic;

import io.th0rgal.oraxen.OraxenPlugin;
import io.th0rgal.oraxen.mechanics.Mechanic;
import io.th0rgal.oraxen.mechanics.MechanicFactory;
import io.th0rgal.oraxen.mechanics.MechanicsManager;
import org.bukkit.configuration.ConfigurationSection;

/*
 * @author Rok, Pedro Lucas N M Machado created on 23/11/2022
 */
public class ScrewdriverMechanicFactory extends MechanicFactory {

	private static ScrewdriverMechanicFactory instance;

	public ScrewdriverMechanicFactory(ConfigurationSection section) {
		super(section);
		MechanicsManager.registerListeners(OraxenPlugin.get(), new ScrewdriverMechanicManager(this));
		instance = this;
	}

	@Override
	public Mechanic parse(ConfigurationSection itemMechanicConfiguration) {
		Mechanic mechanic = new ScrewdriverMechanic(this, itemMechanicConfiguration);
		addToImplemented(mechanic);
		return mechanic;
	}

	public static ScrewdriverMechanicFactory get() {
		return instance;
	}
}
