package problem1;

public interface FrequentFlyerInterface {

  String getAccountId();

  Name getName();

  String getEmail();

  MilesBalance getMilesBalance();

  void transferMiles(Deposit deposit);
}
