package org.velezreyes.quiz.question6;

public class VendingMachineImpl implements VendingMachine{

  private int moneyInserted = 0;

  public static VendingMachine getInstance() {
    return new VendingMachineImpl();
  }
  @Override
  public void insertQuarter() {
    moneyInserted += 25;
  }

  @Override
  public Drink pressButton(String name) throws NotEnoughMoneyException, UnknownDrinkException {
    if (name.equals("ScottCola")) {
      if (moneyInserted >= 75) {
        moneyInserted -= 75;
        return new DrinkImpl("ScottCola", true);
      } else {
        throw new NotEnoughMoneyException();
      }
    } else if (name.equals("KarenTea")) {
      if (moneyInserted >= 100) {
        moneyInserted -= 100;
        return new DrinkImpl("KarenTea", false);
      } else {
        throw new NotEnoughMoneyException();
      } 
    } else {
      throw new UnknownDrinkException();
    }
  }

  private class DrinkImpl implements Drink {
    private String name;
    private boolean isFizzy;

    public DrinkImpl(String name, boolean isFizzy) {
      this.name = name;
      this.isFizzy = isFizzy;
    }

    @Override
    public String getName() {
      return name;
    }

    @Override
    public boolean isFizzy() {
      return isFizzy;
    }
  }
}
