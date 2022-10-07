package problem1;

import java.util.Objects;

/**
 * Class Runner contains information about a runner, including name, height, weight, league, the
 * best 5K time, the best half-marathon time, and favorite running event.
 */
public class Runner extends Athlete {

  private Double best5KTime;
  private Double bestHalfMarathonTime;
  private String favoriteRunningEvent;

  /**
   * Constructs a new runner, based upon all the provided input parameters.
   *
   * @param name                 - object Name, containing the first and last name
   * @param height               - runner's height, expressed as a Double in cm
   * @param weight               - runner's weigh, expressed as a Double in pounds
   * @param league               - runner's league, expressed as String
   * @param best5KTime           - runner's best 5K time, expressed as Double
   * @param bestHalfMarathonTime - runner's best half-marathon time, expressed as Double
   * @param favoriteRunningEvent - runner's favorite running event, expressed as String
   */
  public Runner(Name name, Double height, Double weight, String league, Double best5KTime,
      Double bestHalfMarathonTime, String favoriteRunningEvent) {
    super(name, height, weight, league);
    this.best5KTime = best5KTime;
    this.bestHalfMarathonTime = bestHalfMarathonTime;
    this.favoriteRunningEvent = favoriteRunningEvent;
  }

  /**
   * Constructs a new runner, based upon all the provided input parameters.
   *
   * @param name                 - object Name, containing the first and last name
   * @param height               - runner's height, expressed as a Double in cm
   * @param weight               - runner's weigh, expressed as a Double in pounds
   * @param best5KTime           - runner's best 5K time, expressed as Double
   * @param bestHalfMarathonTime - runner's best half-marathon time, expressed as Double
   * @param favoriteRunningEvent - runner's favorite running event, expressed as String
   */
  public Runner(Name name, Double height, Double weight, Double best5KTime,
      Double bestHalfMarathonTime, String favoriteRunningEvent) {
    super(name, height, weight);
    this.best5KTime = best5KTime;
    this.bestHalfMarathonTime = bestHalfMarathonTime;
    this.favoriteRunningEvent = favoriteRunningEvent;
  }

  /**
   * Returns player's best 5K time as Double
   *
   * @return Double player's best 5K time
   */
  public Double getBest5KTime() {
    return this.best5KTime;
  }

  /**
   * Returns player's best half-marathon time as Double
   *
   * @return Double player's best half-marathon time
   */
  public Double getBestHalfMarathonTime() {
    return this.bestHalfMarathonTime;
  }

  /**
   * Returns player's favorite running event as String
   *
   * @return String player's favorite running event
   */
  public String getFavoriteRunningEvent() {
    return this.favoriteRunningEvent;
  }

  /**
   * Test two Runner objects have the same property values
   *
   * @param o tested object
   * @return boolean
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    Runner runner = (Runner) o;
    return Objects.equals(best5KTime, runner.best5KTime)
        && Objects.equals(bestHalfMarathonTime, runner.bestHalfMarathonTime)
        && Objects.equals(favoriteRunningEvent, runner.favoriteRunningEvent);
  }

  /**
   * Returns the hash code of the Runner object
   *
   * @return int hash code
   */
  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), best5KTime, bestHalfMarathonTime, favoriteRunningEvent);
  }

  /**
   * Returns the string represents the runner information
   *
   * @return String about the runner
   */
  @Override
  public String toString() {
    return "Runner{" +
        "Name=" + getName().getFirstName() + ' ' + getName().getLastName() +
        ", height=" + getHeight() +
        ", weight=" + getWeight() +
        ", league=" + getLeague() +
        ", best 5K time=" + getBest5KTime() +
        ", best half-marathon time=" + getBestHalfMarathonTime() +
        ", favorite running event=" + getFavoriteRunningEvent() +
        '}';
  }
}
