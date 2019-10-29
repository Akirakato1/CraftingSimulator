import java.util.Random;

public class Item {
  double cost;
  int goodmod, badmod, okaymod;
  int originalbadmod, originalokaymod;
  boolean hasCraftedMod;
  static double ANNUL_COST = 40;
  static double ADD_CRAFTED_MOD_COST = 1;
  double totalCost;
  int craftSteps = 0;
  int basesUsed=1;
  String craftHistory = "";


  public Item(double cost, int goodmod, int okaymod, int badmod, boolean hasCraftedMod) {
    this.cost = cost;
    this.totalCost = cost;
    this.goodmod = goodmod;
    this.originalokaymod = okaymod;
    this.originalbadmod = badmod;
    this.badmod = badmod;
    this.okaymod = okaymod;
    this.hasCraftedMod = hasCraftedMod;
  }

  double calcCost() {
    if (badmod == 0) {
      return totalCost;
    }
    int roll = this.annulItem();
    if (roll == 1) {
      badmod--;
      craftHistory += "hit bad mod\n";
    } else if (roll == 0) {
      craftSteps++;
      craftHistory += "hit cafted mod\n";
      this.addToTotalCost(ADD_CRAFTED_MOD_COST);
    } else if (roll == -1) {
      craftSteps++;
      craftHistory += "hit good mod\n";
      this.addToTotalCost(cost);
      basesUsed++;
      badmod = originalbadmod;
      okaymod = originalokaymod;
    } else {
      craftHistory += "hit okay mod\n";
      okaymod--;
    }
    return this.calcCost();
  }

  // 0 if hit crafted, 1 if hit bad, -1 if hit good, 2 if hit okaymod
  int annulItem() {
    this.addToTotalCost(ANNUL_COST);
    craftSteps++;
    craftHistory += "Annuled ";
    int maxcap = goodmod + badmod;
    Random r = new Random();
    if (hasCraftedMod) {
      maxcap++;
    }
    int roll = r.nextInt(maxcap);
    if (roll < goodmod) {
      return -1;
    } else if (roll < goodmod + badmod) {
      return 1;
    } else if (roll < goodmod + badmod + okaymod) {
      return 2;
    } else {
      return 0;
    }

  }

  void addToTotalCost(double value) {
    this.totalCost += value;
  }

  String getCraftHistory() {
    return craftHistory;
  }

  int getCraftSteps() {
    return craftSteps;
  }
  
  int getBasesUsed() {
    return basesUsed;
  }

}
