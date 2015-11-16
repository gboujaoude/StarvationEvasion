package starvationevasion.sim;

import starvationevasion.common.*;
import starvationevasion.sim.io.LogLevel;
import starvationevasion.sim.io.Logger;

import java.io.BufferedReader;
import java.util.ArrayList;

/**
 * This is the main API point of the Starvation Evasion Simulator.
 * This constructor should be called once at the start of each game by the Server.
 */
public class Simulator
{
  private final int startYear;
  private int year;

  //private final String stateDataPath = System.getenv("PWD")+"/data/sim/UnitedStatesData/UnitedStatesFarmAreaAndIncome.csv";
  private BufferedReader reader;

  /**
   * This constructor should be called once at the start of each game by the Server.
   * Initializes the model
   * Generates a random 80 card deck for each player (both
   * human and AI players)
   */
  public Simulator(int startYear)
  {
    Logger.setLogLevel(LogLevel.ALL);

    if (startYear < Constant.FIRST_YEAR || startYear > Constant.LAST_YEAR)
    {
      String errMsg = "Simulator(startYear=" + startYear +
                      ") start year must be between [" +
                      Constant.FIRST_YEAR + ", " + Constant.LAST_YEAR + "].";
      Logger.log(LogLevel.ERROR, errMsg);
      throw new IllegalArgumentException(errMsg);
    }

    this.startYear = startYear;
    year = startYear;
    Logger.log(LogLevel.INFO, "Starting Simulation at year " + startYear);
  }

  /**
   * The server must call this for each playerRegion before the first turn
   * and during each turn's draw phase. This method will return the proper number of
   * cards from the top of the given playerRegion's deck taking into account cards played
   * and discarded by that player.
   * @param playerRegion
   * @return list of cards.
   */
  public ArrayList<EnumPolicy> drawCards(EnumRegion playerRegion)
  {
    Logger.log(LogLevel.INFO, "Cards drawn");
    return null;
  }

  /**
   * The server should call nextTurn(cards) when it is ready to advance the simulator
   * a turn (Constant.YEARS_PER_TURN years)
   * @param cards List of PolicyCards played this turn.
   * @return the simulation year after nextTurn() has finished.
   */
  public int nextTurn(ArrayList<PolicyCard> cards)
  {
    Logger.log(LogLevel.INFO, "Advancing Turn...");
    nextYear();
    nextYear();
    nextYear();
    Logger.log(LogLevel.INFO, "Turn complete, year is now " + year);
    return year;
  }

  /**
   * @param region Any US or world region.
   * @param food Any food catagory.
   * @return Number of square km used for farming of the given food in the given region.
   */
  public int getLandUsed(EnumRegion region, EnumFood food)
  {
    int landUsed = 0;
    Logger.log(LogLevel.DEBUG, "Land used for food " + food + " in region "
                               + region + " = " + landUsed + " km^2");
    return landUsed;
  }

  private int nextYear()
  {
    year++;
    Logger.log(LogLevel.DEBUG, "Advancing year to " + year);
    return year;
  }

  //Temporary main for testing & debugging Simulator and State Objs.
  public static void main(String[] args)
  {
    new Simulator(Constant.FIRST_YEAR);
  }
}
