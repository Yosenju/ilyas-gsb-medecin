/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.util.Collection;

/**
 *
 * @author ighembaza
 */
public class Pays {

    private Collection<Dep> lesDeps;
    private Collection<Spe> lesSpes;

    public Pays() {
        this.lesDeps = PaysDAO.getLesDeps();
        this.lesSpes = PaysDAO.getLesSpes();
        this.assocMedecins(PaysDAO.getLesMeds());
    }

    public Collection<Dep> getLesDeps() {
        return lesDeps;
    }

    public Collection<Spe> getLesSpes() {
        return lesSpes;
    }

    private void assocMedecins(Collection<Med> lesMeds) {
        for (Med unMed : lesMeds) {
            getLeDep(unMed.getDep()).addUnMed(unMed);
            Spe uneSpe = getLaSpe(unMed.getSpe());
            if (uneSpe != null) {
                uneSpe.addUnMed(unMed);
            }
        }
    }

    public Dep getLeDep(String numDep) {
        for (Dep d : lesDeps) {
            if (d.getNum().equals(numDep)) {
                return d;
            }
        }
        return null;
    }

    public Spe getLaSpe(String nomSpe) {
        for (Spe s : lesSpes) {
            if (s.getNomSpe().equals(nomSpe)) {
                return s;
            }
        }
        return null;
    }
}
