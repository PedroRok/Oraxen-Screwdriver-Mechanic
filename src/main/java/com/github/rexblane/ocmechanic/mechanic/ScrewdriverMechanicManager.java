package com.github.rexblane.ocmechanic.mechanic;

import io.th0rgal.oraxen.api.OraxenItems;
import io.th0rgal.oraxen.api.events.OraxenFurnitureInteractEvent;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.entity.ItemFrame;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

/*
 * @author Rok, Pedro Lucas N M Machado created on 23/11/2022
 */
public class ScrewdriverMechanicManager implements Listener {

	private final ScrewdriverMechanicFactory factory;

	public ScrewdriverMechanicManager(ScrewdriverMechanicFactory factory) {
		this.factory = factory;
	}

	@EventHandler(priority = EventPriority.HIGH, ignoreCancelled = true)
	public void onInteract(OraxenFurnitureInteractEvent e) {

		Player player = e.getPlayer();
		ItemStack itemInMainHand = player.getInventory().getItemInMainHand();
		String itemID = OraxenItems.getIdByItem(itemInMainHand);
		if (factory.isNotImplementedIn(itemID))
			return;

		ItemFrame itemFrame = e.getItemFrame();
		if (((ScrewdriverMechanic) factory.getMechanic(itemID)).canRotate()) {
			itemFrame.setRotation(itemFrame.getRotation().rotateClockwise());
		}

		player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText("§e§lRotation: §c§n" + itemFrame.getRotation().toString() +
				                                                                                     "§r §7| §e§lFacing: §c§n" + itemFrame.getFacing().toString() +
				                                                                                     "§r §7| §e§lType: §c§n" + itemFrame.getItem().getType().toString() +
				                                                                                     "§r §7| §e§lCM: §c§n" + itemFrame.getItem().getItemMeta().getCustomModelData()));

		e.setCancelled(true);
	}
}
