package com.github.rexblane.ocmechanic.mechanic;

import io.th0rgal.oraxen.mechanics.Mechanic;
import io.th0rgal.oraxen.mechanics.MechanicFactory;
import org.bukkit.configuration.ConfigurationSection;

/*
 * @author Rok, Pedro Lucas N M Machado created on 23/11/2022
 */
public class ScrewdriverMechanic extends Mechanic {

	private final boolean rotate;

	public ScrewdriverMechanic(MechanicFactory mechanicFactory, ConfigurationSection section) {
		super(mechanicFactory, section);
		rotate = section.getBoolean("rotate");
	}

	public boolean canRotate() {
		return rotate;
	}

}
