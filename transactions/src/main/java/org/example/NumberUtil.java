package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileWriter;
import java.io.IOException;

@Component
public class NumberUtil {
    @Autowired
    private NumberRepository repository;
    @Transactional // Splitwise ===> split(int amount, List<People> p, People oneWhoPaid)
    public void transfer(int k, long id1, long id2) {
        Number n1 = repository.findById(id1).get();
        Number n2 = repository.findById(id2).get();
        n1.setVal(n1.getVal() - k);
        repository.save(n1);
        // change in else where
        FileWriter fw = null;
        try {
            fw = new FileWriter("D:\\personal\\local-repo\\ppa-class\\transactions\\src\\main\\java\\org\\example\\f1.txt");
            fw.write("Hello");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                fw.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        if (true) throw new RuntimeException("Simulating crash");
        n2.setVal(n2.getVal() + k);
        repository.save(n2);
    }
// images : id|link_to_image
    @Transactional(isolation = Isolation.READ_UNCOMMITTED, propagation = Propagation.REQUIRES_NEW)
    public void triple(Long id) {
        Number n = repository.findById(id).get();
        n.setVal(n.getVal() * 3);
        repository.save(n);
    }
}
// F
//   G
// T1 ..............T2........ T2 ends ......... T1ends

