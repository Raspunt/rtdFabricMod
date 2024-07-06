package org.giga.rtdfabricmod.server.actions;

import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;

import java.util.Random;

public class ItemsGiverAction {

    public static void giveRandomSword(ServerPlayerEntity player) {
        Random random = new Random();
        ItemStack[] swords = new ItemStack[]{
                new ItemStack(Items.IRON_SWORD),
                new ItemStack(Items.DIAMOND_SWORD),
                new ItemStack(Items.GOLDEN_SWORD),
                new ItemStack(Items.STONE_SWORD),
                new ItemStack(Items.WOODEN_SWORD)
        };

        ItemStack randomSword = swords[random.nextInt(swords.length)];
        player.getInventory().insertStack(randomSword);

    }

    public static void giveStick(ServerPlayerEntity player) {
        ItemStack enchantedStick = new ItemStack(Items.STICK);
        enchantedStick.addEnchantment(Enchantments.KNOCKBACK, 10);
        enchantedStick.setCustomName(Text.of("Дужегуб пусечек over9999"));

        player.getInventory().insertStack(enchantedStick);
    }

    public static void give9999PoisonPotatoes(ServerPlayerEntity player) {
        player.sendMessage(Text.of("нужна еда? вот еда!!"));
        ItemStack poisonPotato = new ItemStack(Items.POISONOUS_POTATO, 9999);

        player.getInventory().insertStack(poisonPotato);
    }

    public static void giveDiamondPants(ServerPlayerEntity player) {
        player.sendMessage(Text.of("за 40 гривен штаны!"));
        ItemStack diamondPants = new ItemStack(Items.DIAMOND_LEGGINGS);
        diamondPants.addEnchantment(Enchantments.PROJECTILE_PROTECTION, 4);
        diamondPants.setCustomName(Text.of("Гомогейсие подштаники"));

        player.getInventory().insertStack(diamondPants);
    }

    public static void giveIronSet(ServerPlayerEntity player) {
        player.sendMessage(Text.of("За императора человечества!"));

        ItemStack spaceSword = new ItemStack(Items.IRON_SWORD);
        ItemStack cosmicPickaxe = new ItemStack(Items.IRON_PICKAXE);
        ItemStack astralAxe = new ItemStack(Items.IRON_AXE);
        ItemStack spaceHelmet = new ItemStack(Items.IRON_HELMET);
        ItemStack spaceChestplate = new ItemStack(Items.IRON_CHESTPLATE);
        ItemStack spaceLeggings = new ItemStack(Items.IRON_LEGGINGS);
        ItemStack spaceBoots = new ItemStack(Items.IRON_BOOTS);

        spaceSword.addEnchantment(Enchantments.SHARPNESS, 3);
        cosmicPickaxe.addEnchantment(Enchantments.EFFICIENCY, 3);
        astralAxe.addEnchantment(Enchantments.EFFICIENCY, 3);
        spaceHelmet.addEnchantment(Enchantments.PROTECTION, 2);
        spaceChestplate.addEnchantment(Enchantments.PROTECTION, 2);
        spaceLeggings.addEnchantment(Enchantments.PROTECTION, 2);
        spaceBoots.addEnchantment(Enchantments.PROTECTION, 2);

        spaceHelmet.setCustomName(Text.of("Space Helmet"));
        spaceChestplate.setCustomName(Text.of("Cosmo-Commando Chestplate"));
        spaceLeggings.setCustomName(Text.of("Astral Leggings"));
        spaceBoots.setCustomName(Text.of("Stellar Boots"));

        player.equipStack(EquipmentSlot.MAINHAND, spaceSword);
        player.equipStack(EquipmentSlot.OFFHAND, cosmicPickaxe);
        player.equipStack(EquipmentSlot.HEAD, spaceHelmet);
        player.equipStack(EquipmentSlot.CHEST, spaceChestplate);
        player.equipStack(EquipmentSlot.LEGS, spaceLeggings);
        player.equipStack(EquipmentSlot.FEET, spaceBoots);

        player.getInventory().insertStack(spaceSword);
        player.getInventory().insertStack(cosmicPickaxe);
        player.getInventory().insertStack(astralAxe);

    }
}


