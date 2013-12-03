/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.TreeSet;

/**
 *
 * @author ighembaza
 */
public class Dep implements Comparable<Dep> {

    private String num;
    private Collection<Med> lesMeds = new TreeSet<Med>();

    public Dep(String num) {
        this.num = num;
        
    }

    

    public String getNum() {
        return num;
    }

    public Collection<Med> getLesMeds() {
        return lesMeds;
    }

    @Override
    public int compareTo(Dep d) {
        return num.compareTo(d.num);

    }

    public void addUnMed(Med unMed) {
        lesMeds.add(unMed);
    }
}
