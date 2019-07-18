import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


 class YatzyTest {

    @Test
    void chance_scores_sum_of_all_dice_15() {
        int expected = 15;
        int actual = Yatzy.chance(2,3,4,5,1);
        assertEquals(expected, actual);
    }

    @Test
    void chance_scores_sum_of_all_dice_16() {
        int expected = 16;
        int actual = Yatzy.chance(3,3,4,5,1);
        assertEquals(expected, actual);
    }

    @Test
    void chance_scores_sum_of_all_dice_14() {
        int expected = 14;
        int actual = Yatzy.chance(1,1,3,3,6);
        assertEquals(expected, actual);
    }

    @Test
    void chance_scores_sum_of_all_dice_21() {
        int expected = 21;
        int actual = Yatzy.chance(4,5,5,6,1);
        assertEquals(expected, actual);
    }

    @Test
    void yatzy_scores_50_with_6() {
        int expected = 50;
        int actual = Yatzy.yatzy(6,6,6,6,6);
        assertEquals(expected, actual);
    }

    @Test
    void yatzy_scores_50_with_4() {
        int expected = 50;
        int actual = Yatzy.yatzy(4,4,4,4,4);
        assertEquals(expected, actual);
    }

    @Test
    void yatzy_scores_50_with_1() {
        int expected = 50;
        int actual = Yatzy.yatzy(1,1,1,1,1);
        assertEquals(expected, actual);
    }

    @Test
    void yatzy_scores_0_with_6_and_3() {
        int expected = 0;
        int actual = Yatzy.yatzy(6,6,6,6,3);
        assertEquals(expected, actual);

    }

    @Test
    void yatzy_scores_0_with_2_and_1() {
        int expected = 0;
        int actual = Yatzy.yatzy(1,1,1,2,1);
        assertEquals(expected, actual);

    }

    @Test
    void sum_of_dices_read_one_scored_0() {
        assertEquals(0, Yatzy.ones(6,2,2,4,5));
    }

    @Test
    void sum_of_dices_read_one_scored_1() {
        assertEquals(1, Yatzy.ones(1, 2, 3, 4, 5));
    }

    @Test
    void sum_of_dices_read_one_scored_2() {
        assertEquals(2, Yatzy.ones(1,2,1,4,5));
    }

    @Test
    void sum_of_dices_read_one_scored_4() {
        assertEquals(4, Yatzy.ones(1,2,1,1,1));
    }

    @Test
    void sum_of_dices_read_two_scored_4() {
        assertEquals(4, Yatzy.twos(1,2,3,2,6));
    }

    @Test
    void sum_of_dices_read_two_scored_10() {
        assertEquals(10, Yatzy.twos(2, 2, 2, 2, 2));
    }

    @Test
    void sum_of_dices_read_two_scored_0() {
        assertEquals(0, Yatzy.twos(3, 5, 4, 6, 1));
    }

    @Test
    void sum_of_dices_read_three_scored_6() {
        assertEquals(6, Yatzy.threes(1,2,3,2,3));
    }

    @Test
    void sum_of_dices_read_three_scored_12() {
        assertEquals(12, Yatzy.threes(2, 3, 3, 3, 3));
    }

    @Test
    void sum_of_dices_read_four_scored_12()
    {
        assertEquals(12, new Yatzy(4,4,4,5,5).fours());

    }

    @Test
    void sum_of_dices_read_four_scored_0()
    {
        assertEquals(0, new Yatzy(1,1,2,5,5).fours());

    }

    @Test
    void sum_of_dices_read_four_scored_8()
    {

        assertEquals(8, new Yatzy(4,4,5,5,5).fours());
    }

    @Test
    void sum_of_dices_read_four_scored_4()
    {
        assertEquals(4, new Yatzy(4,5,5,5,5).fours());
    }

    @Test
    void sum_of_dices_read_five_scored_10() {
        assertEquals(10, new Yatzy(4,4,4,5,5).fives());
    }

    @Test
    void sum_of_dices_read_five_scored_15() {
        assertEquals(15, new Yatzy(4,4,5,5,5).fives());
    }

    @Test
    void sum_of_dices_read_five_scored_20() {
        assertEquals(20, new Yatzy(4,5,5,5,5).fives());
    }

    @Test
    void sum_of_dices_read_five_scored_0() {
        assertEquals(0, new Yatzy(4,1,1,3,4).fives());
    }

    @Test
    void sum_of_dices_read_sixes_scored_0() {
        assertEquals(0, new Yatzy(4,4,4,5,5).sixes());
    }

    @Test
    void sum_of_dices_read_sixes_scored_6() {
        assertEquals(6, new Yatzy(4,4,6,5,5).sixes());
    }

    @Test
    void sum_of_dices_read_sixes_scored_18() {
        assertEquals(18, new Yatzy(6,5,6,6,5).sixes());
    }


    @Test
    void one_pair_of_three() {
        assertEquals(6, Yatzy.score_pair(3,4,3,5,6));
    }

    @Test
    void one_pair_of_none() {
        assertEquals(0, Yatzy.score_pair(3,4,1,5,6));
    }

    @Test
    void one_pair_of_five() {
        assertEquals(10, Yatzy.score_pair(5,3,3,3,5));
    }

    @Test
    void one_pair_of_six() {
        assertEquals(12, Yatzy.score_pair(5,3,6,6,5));
    }

    @Test
    void two_pair_of_none() {
        assertEquals(0, Yatzy.two_pair(3,4,1,5,6));
    }

    @Test
    void two_pair_of_three_and_five() {
        assertEquals(16, Yatzy.two_pair(3,3,5,4,5));
    }

    @Test
    void two_pair_of_three_and_five_2() {
        assertEquals(16, Yatzy.two_pair(3,3,5,5,5));
    }

    @Test
    void three_of_a_kind_with_threes()
    {
        assertEquals(9, Yatzy.three_of_a_kind(3,3,3,4,5));
    }

    @Test
    void three_of_a_kind_with_fives()
    {
        assertEquals(15, Yatzy.three_of_a_kind(5,3,5,4,5));
    }

    @Test
    void three_of_a_kind_with_four_threes()
    {
        assertEquals(9, Yatzy.three_of_a_kind(3,3,3,3,5));

    }

    @Test
    void three_of_a_kind_with_five_threes()
    {
        assertEquals(9, Yatzy.three_of_a_kind(3,3,3,3,3));

    }

    @Test
    void three_of_a_kind_with_none()
    {
        assertEquals(0, Yatzy.three_of_a_kind(2,3,1,3,1));

    }

    @Test
    void four_of_a_kind_with_threes() {
        assertEquals(12, Yatzy.four_of_a_kind(3,3,3,3,5));

    }

    @Test
    void four_of_a_kind_with_fives() {
        assertEquals(20, Yatzy.four_of_a_kind(5,5,5,4,5));

    }

    @Test
    void four_of_a_kind_with_fives_with_five_threes() {

        assertEquals(12, Yatzy.four_of_a_kind(3,3,3,3,3));
    }

    @Test
    void four_of_a_kind_with_fives_with_none() {

        assertEquals(0, Yatzy.four_of_a_kind(3,3,3,4,4));
    }

    @Test
    void small_straight_ordered() {
        assertEquals(15, Yatzy.smallStraight(1,2,3,4,5));
    }

    @Test
    void small_straight_shuffled() {
        assertEquals(15, Yatzy.smallStraight(2,3,4,5,1));
    }

    @Test
    void small_straight_none() {
        assertEquals(0, Yatzy.smallStraight(1,2,2,4,5));
    }

    @Test
    void large_straight_shuffled() {
        assertEquals(20, Yatzy.largeStraight(6,2,3,4,5));
    }

    @Test
    void large_straight_ordered() {
        assertEquals(20, Yatzy.largeStraight(2,3,4,5,6));
    }

    @Test
    void large_straight_none() {
        assertEquals(0, Yatzy.largeStraight(1,2,2,4,5));
    }

    @Test
    void full_house_pair_of_six_three_two() {
        assertEquals(18, Yatzy.fullHouse(6,2,2,2,6));

    }

    @Test
    void full_house_of_none() {
        assertEquals(0, Yatzy.fullHouse(2, 3, 4, 5, 6));
    }
}
