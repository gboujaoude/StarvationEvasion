package starvationevasion.common.gamecards;

import java.util.ArrayList;
import java.util.EnumSet;

public class Policy_FertilizerAidCentralAsia extends GameCard
{

  public static final String TITLE =
    "Fertilizer Aid to Central Asia";

  public static final String TEXT =
    "Each region of the United States sends X million dollars in fertilizer to Central Asia.";

  public static final EnumSet<EnumGameState> PLAY_STATES = //when the card can be used
      EnumSet.of(EnumGameState.PLANNING_STATE);
  
  public Policy_FertilizerAidCentralAsia()
  {
    this.setUsableStates(PLAY_STATES);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String getTitle(){ return TITLE;}

  /**
   * {@inheritDoc}
   */
  @Override
  public String getGameText(){ return TEXT;}


  /**
   * Millions of dollars spent by each participating region.
   * {@inheritDoc}
   */
  @Override
  public ArrayList<Integer> getOptionsOfVariable()
  {
    ArrayList<Integer> options=new ArrayList<>();
    options.add(5);
    options.add(10);
    options.add(25);
    return options;
  }

}
