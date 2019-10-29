# CraftingSimulator
Item Object: double basecost, int numberOfGoodMods, int numberOfOkayMods, int numberOfBadMods, boolean hasCraftedMod.

Assumptions: 
Annulment orb cost 40c
crafting a new mod cost 1c
Annuling is one step
Buying new base is one step
Crafting mod on is one step

Simulator will continue crafting until all badmods are annuled.
If an okaymod is annuled and not all badmods are annuled, continue crafting.
If all badmods are annuled and not all okaymods are annuled, end crafting.
If a goodmod is annuled, the simulator will purchase a new base at its basecost and add its cost to total, assuming original states. 
hasCraftedMod is to indicate whether a mod is crafted on before an annul operation for this item. 
This simulation is for figuring out if adding craftedmod before annuling hurts or helps the player. 

Key initial observations: no matter what the conditions are adding crafted mod before annuling never helpful. 

Data: 
Basecost has been set to 0. Instead number of bases used have been recorded. Hence totalcost will be sum of everything except base costs/purchasing new base. Actual total cost can be easily calculated. 
1,000,000 simulations per conditions seems to produce consistent results. This value is not based on calculated statistical significance but seems to be at most 0.05. 


Base cost: 0
Good Mod: 5
Bad Mod: 1
Okay Mod: 0

Avg cost Has Crafted over 1000000 sims: 281.247668

Avg steps Has Crafted over 1000000 sims: 13.012334

Avg bases used Has Crafted over 1000000 sims: 6.005179

Avg cost No Crafted over 1000000 sims: 239.62348

Avg steps No Crafted over 1000000 sims: 10.981174

Avg bases used No Crafted over 1000000 sims: 5.990587


Used 700,000 instead because my laptop have small memory, started running slow. 

Base cost: 0
Good Mod: 4
Bad Mod: 2
Okay Mod: 0

Avg cost Has Crafted over 700000 sims: 943.6551371428571

Avg steps Has Crafted over 700000 sims: 41.0087

Avg bases used Has Crafted over 700000 sims: 15.001038571428571

Avg cost No Crafted over 700000 sims: 800.9065142857143

Avg steps No Crafted over 700000 sims: 34.041157142857145

Avg bases used No Crafted over 700000 sims: 15.018494285714286

Used 500,000

Base cost: 0
Good Mod: 3
Bad Mod: 3
Okay Mod: 0

Avg cost Has Crafted over 500000 sims: 1614.403088

Avg steps Has Crafted over 500000 sims: 65.445946

Avg bases used Has Crafted over 500000 sims: 19.933806

Avg cost No Crafted over 500000 sims: 1361.27648

Avg steps No Crafted over 500000 sims: 53.055292

Avg bases used No Crafted over 500000 sims: 20.02338

