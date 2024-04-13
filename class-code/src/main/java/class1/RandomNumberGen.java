package class1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//inhertiance example - reusing parent class method implementation in child class
public class RandomNumberGen {

    List<Integer> nums;

    public void init() {
        nums = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 1000; i++) {
            nums.add(random.nextInt());
        }
    }

    public int get() {
        return nums.get(new Random().nextInt(nums.size()));
    }

}
