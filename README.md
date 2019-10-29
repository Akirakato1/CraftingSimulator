# CraftingSimulator
Item Object: double basecost, int numberOfGoodMods, int numberOfOkayMods, int numberOfBadMods, boolean hasCraftedMod.

Simulator will continue crafting until all badmods are annuled.
If an okaymod is annuled and not all badmods are annuled, continue crafting.
If all badmods are annuled and not all okaymods are annuled, end crafting.
If a goodmod is annuled, the simulator will purchase a new base at its basecost and add its cost to total, assuming original states. 
hasCraftedMod is to indicate whether a mod is crafted on before an annul operation for this item. 
This simulation is for figuring out if adding craftedmod before annuling hurts or helps the player. 
