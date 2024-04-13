package oops;

import java.util.List;

//inhertiance example - reusing parent class method implementation in child class
public class EvenRandomNumGen extends RandomNumberGen {

    List<Integer> evenNums;

    public void init() {
        super.init();
        List<Integer> tmp = super.nums;
        for (Integer i : tmp) {
            if (i % 2 == 0) {
                evenNums.add(i);
            }
        }
    }


}
