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
public class Spe implements Comparable<Spe> {

    private String nomspe;
    private Collection<Med> lesMeds = new TreeSet<Med>();

    public Spe(String nomspe) {
        this.nomspe = nomspe;

    }

    public String getNomSpe() {
        return nomspe;
    }

    public Collection<Med> getLesMeds() {
        return lesMeds;
    }

    @Override
    public int compareTo(Spe s) {
        return nomspe.compareTo(s.nomspe);

    }

    public void addUnMed(Med unMed) {
        lesMeds.add(unMed);
    }
}
