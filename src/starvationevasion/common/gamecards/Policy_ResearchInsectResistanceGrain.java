
package starvationevasion.common.gamecards;

import starvationevasion.common.EnumFood;

import java.util.ArrayList;
import java.util.EnumSet;

//TODO: Convert to a research-type card
/**
 * Title: {@value #TITLE}<br><br>
 * Game Text: {@value #TEXT}<br><br>
 *
 * Draft Affects: When drafting this policy, player selects an
 * amount X to be paid by EACH player who approves the policy. <br><br>
 *
 * Votes Required: {@value #VOTES_REQUIRED}<br><br>
 *
 * Model Effects: 5% bonus to effectiveness of total dollars spent for
 * each participating region beyond the drafter.<br><br>
 *
 * Starting 10 years after research, permanent reduction in kg/km<sup>2</sup>
 * of pesticides for target crop. All player and non-player regions in world
 * who permit GMO in their region receive this benefit.<br>
 * Benefit yield is an ease-in-out cubic bezier function of effective
 * dollars spent and grains.
*/
public class Policy_ResearchInsectResistanceGrain extends GameCard
{

  public static final String TITLE =
     "Research GMO Insect Resistance for Grains";

  public static final String TEXT =
    "Each participating region spends X million dollars to fund GMO seed research " +
    "for increasing insect resistance of a grain crop.";
  
  public static final EnumSet<EnumGameState> PLAY_STATES = //when the card can be used
      EnumSet.of(EnumGameState.PLANNING_STATE);
  
  public Policy_ResearchInsectResistanceGrain()
  {
    this.setUsableStates(PLAY_STATES);
  }

  /**
   * The number of votes required for this policy.  A value of 1 means that
   * only one player must vote to enact this policy.
  */
  public final static int VOTES_REQUIRED = 1;



  /**
   * {@inheritDoc}
  */
  @Override
  public int votesRequired() {return VOTES_REQUIRED;}

  /**
   * {@inheritDoc}
  */
  @Override
  public boolean voteWaitForAll() {return true;}

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
   * {@inheritDoc}
   */
  @Override
  public EnumFood[] getValidTargetFoods()
  { return EnumFood.CROP_FOODS;
  }

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
    options.add(15);
    return options;
  }

}
