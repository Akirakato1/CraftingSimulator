import java.util.ArrayList;
import java.util.List;

public class CraftSimulator {
  public static void main(String[] args) {
    int baseCost = 170;
    int goodmod = 2;
    int badmod = 1;
    int okaymod = 1;
    //simulation num must be > 0
    int simulationNum = 1000000;
    double avgCostHasCrafted = 0;
    double avgCostNoCrafted = 0;
    double avgStepsHasCrafted = 0;
    double avgStepsNoCrafted = 0;
    double avgBasesUsedHasCrafted=0;
    double avgBasesUsedNoCrafted=0;

    List<Item> itemsHasCrafted = new ArrayList<>();
    List<Item> itemsNoCrafted = new ArrayList<>();
    List<Double> totalCostHasCrafted = new ArrayList<>();
    List<Double> totalCostNoCrafted = new ArrayList<>();
    List<Integer> stepsCostHasCrafted = new ArrayList<>();
    List<Integer> stepsCostNoCrafted = new ArrayList<>();

    for (int i = 0; i < simulationNum; i++) {
      itemsHasCrafted.add(new Item(baseCost, goodmod, okaymod, badmod, true));
      itemsNoCrafted.add(new Item(baseCost, goodmod, okaymod, badmod, false));
    }

    for (int i = 0; i < simulationNum; i++) {
      totalCostHasCrafted.add(i, itemsHasCrafted.get(i).calcCost());
      totalCostNoCrafted.add(i, itemsNoCrafted.get(i).calcCost());
      
      //made separate list for steps and cost to make histogram later
      stepsCostHasCrafted.add(i, itemsHasCrafted.get(i).getCraftSteps());
      stepsCostNoCrafted.add(i, itemsNoCrafted.get(i).getCraftSteps());
      
      avgCostHasCrafted += totalCostHasCrafted.get(i);
      avgCostNoCrafted += totalCostNoCrafted.get(i);
      avgStepsHasCrafted += stepsCostHasCrafted.get(i);
      avgStepsNoCrafted += stepsCostNoCrafted.get(i);
      avgBasesUsedHasCrafted+=itemsHasCrafted.get(i).getBasesUsed();
      avgBasesUsedNoCrafted+=itemsNoCrafted.get(i).getBasesUsed();
      System.out.println(
          i + ": Has Crafted steps = \n" + itemsHasCrafted.get(i).getCraftHistory() + "\n");
      System.out.println(totalCostHasCrafted.get(i) + "\n");
      System.out
          .println(i + ": No Crafted steps = \n" + itemsNoCrafted.get(i).getCraftHistory() + "\n");
      System.out.println(totalCostNoCrafted.get(i) + "\n");
    }
    System.out.println("Base cost: " + baseCost + "\nGood Mod: " + goodmod + "\nBad Mod: " + badmod
        + "\nOkay Mod: " + okaymod + "\n");

    System.out.println("Avg cost Has Crafted over " + simulationNum + " sims: "
        + avgCostHasCrafted / (double) simulationNum + "\n");
    System.out.println("Avg steps Has Crafted over " + simulationNum + " sims: "
        + avgStepsHasCrafted / (double) simulationNum + "\n");
    System.out.println("Avg bases used Has Crafted over " + simulationNum + " sims: "
        + avgBasesUsedHasCrafted / (double) simulationNum + "\n");
    
    System.out.println("Avg cost No Crafted over " + simulationNum + " sims: "
        + avgCostNoCrafted / (double) simulationNum + "\n");
    System.out.println("Avg steps No Crafted over " + simulationNum + " sims: "
        + avgStepsNoCrafted / (double) simulationNum + "\n");
    System.out.println("Avg bases used No Crafted over " + simulationNum + " sims: "
        + avgBasesUsedNoCrafted / (double) simulationNum + "\n");


  }
}
