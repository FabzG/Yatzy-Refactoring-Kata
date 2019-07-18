import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;


public class Yatzy {

    private Integer[] dice;

    public static int chance(int d1, int d2, int d3, int d4, int d5){

        return Arrays.asList(d1, d2, d3, d4, d5).stream().reduce(0, (a,b) -> a + b);
    }

    public static int yatzy(int... dice)
    {
        Map<Integer, Long> classifiedDices = classifyDices(dice);

        if(classifiedDices.containsValue(new Long(5)))
            return 50;
        else
            return 0;

    }

    public static int ones(int d1, int d2, int d3, int d4, int d5) {

        return reads_score(Arrays.asList(d1, d2, d3, d4, d5), 1);

    }


    private static int reads_score(List<Integer> dice_values, int filter){

        return dice_values.stream().filter(a -> a == filter).reduce(0, (a,b) -> a + b);

    }


    public static int twos(int d1, int d2, int d3, int d4, int d5) {
        return reads_score(Arrays.asList(d1, d2, d3, d4, d5), 2);
    }

    public static int threes(int d1, int d2, int d3, int d4, int d5) {
        return reads_score(Arrays.asList(d1, d2, d3, d4, d5), 3);
    }

    public Yatzy(int d1, int d2, int d3, int d4, int d5)
    {
        dice = new Integer[5];
        dice[0] = d1;
        dice[1] = d2;
        dice[2] = d3;
        dice[3] = d4;
        dice[4] = d5;
    }

    public int fours()
    {
        return reads_score(Arrays.asList(this.dice), 4);
    }

    public int fives()
    {
        return reads_score(Arrays.asList(this.dice), 5);
    }

    public int sixes()
    {
        return reads_score(Arrays.asList(this.dice), 6);
    }

    public static int score_pair(int d1, int d2, int d3, int d4, int d5)
    {

        Map<Integer, Long> classifiedDices = classifyDices(d1, d2, d3, d4, d5);
        Optional<Map.Entry<Integer, Long>> maxKey = classifiedDices.entrySet().stream().filter(a -> a.getValue() >= 2).max(Map.Entry.comparingByKey());

        if(maxKey.isPresent())
            return maxKey.get().getKey()*2;
        else
            return 0;

    }

    private static Map<Integer, Long> classifyDices(int... dice){
        List<Integer> convertedTab = Arrays.stream( dice ).boxed().collect(Collectors.toList());

        return convertedTab.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

    }

    public static int two_pair(int d1, int d2, int d3, int d4, int d5)
    {
        Map<Integer, Long> classifiedDices = classifyDices(d1, d2, d3, d4, d5);
        Map<Integer, Long> maxKey = classifiedDices.entrySet().stream().filter(a -> a.getValue() >= 2).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        if(maxKey != null && maxKey.keySet().size() == 2)
            return maxKey.keySet().stream().reduce(0, (a,b) -> a + b*2);
        else
            return 0;
    }

    public static int four_of_a_kind(int d1, int d2, int d3, int d4, int d5)
    {
        Map<Integer, Long> classifiedDices = classifyDices(d1, d2, d3, d4, d5);
        Optional<Map.Entry<Integer, Long>> maxKey = classifiedDices.entrySet().stream().filter(a -> a.getValue() >= 4).findFirst();

        if(maxKey.isPresent())
            return maxKey.get().getKey()*4;
        else
            return 0;
    }

    public static int three_of_a_kind(int d1, int d2, int d3, int d4, int d5)
    {
        Map<Integer, Long> classifiedDices = classifyDices(d1, d2, d3, d4, d5);
        Optional<Map.Entry<Integer, Long>> maxKey = classifiedDices.entrySet().stream().filter(a -> a.getValue() >= 3).findFirst();

        if(maxKey.isPresent())
            return maxKey.get().getKey()*3;
        else
            return 0;
    }

    //Assuming a small straight is values 1,2,3,4,5 in random order only
    public static int smallStraight(int d1, int d2, int d3, int d4, int d5)
    {
        Map<Integer, Long> classifiedDices = classifyDices(d1, d2, d3, d4, d5);
        List<Integer> maxKey = classifiedDices.entrySet().stream().filter(a -> a.getValue() == 1).map(a -> a.getKey()).collect(Collectors.toList());

        if(maxKey.contains(1) && maxKey.contains(2) && maxKey.contains(3) && maxKey.contains(4) && maxKey.contains(5))
            return 15;
        else
            return 0;
    }

    //Assuming a large straight is values 2,3,4,5,6 in random order only
    public static int largeStraight(int d1, int d2, int d3, int d4, int d5)
    {
        Map<Integer, Long> classifiedDices = classifyDices(d1, d2, d3, d4, d5);
        List<Integer> maxKey = classifiedDices.entrySet().stream().filter(a -> a.getValue() == 1).map(a -> a.getKey()).collect(Collectors.toList());

        if(maxKey.contains(2) && maxKey.contains(3) && maxKey.contains(4) && maxKey.contains(5) && maxKey.contains(6))
            return 20;
        else
            return 0;
    }

    public static int fullHouse(int d1, int d2, int d3, int d4, int d5)
    {
        int score_one_pair = score_pair(d1, d2, d3, d4, d5);
        int score_three_of_a_kind = three_of_a_kind(d1, d2, d3, d4, d5);

        if(score_one_pair != 0 && score_three_of_a_kind != 0)
            return score_one_pair + score_three_of_a_kind;
        else
            return 0;

    }
}



