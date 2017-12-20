package model;

import java.util.ArrayList;
import java.util.List;

import model.interfaces.IList;

/**
 * Liste d'objet immuables.
 */
public class ListObject implements IList<NonMoveableObject> {
    List<NonMoveableObject> listObject;

    public ListObject() {
        listObject = new ArrayList<NonMoveableObject>();
    }

    /**
     * @param t
     *            indice de l'objet e recuperer
     * @return l'objet non mobile associ�
     */
    public NonMoveableObject getObject(int t) {
        return listObject.get(t);
    }

    /**
     * @param nMO
     *            l'objet non mobile a ajouter.
     */
    public void add(NonMoveableObject nMO) {
        this.listObject.add(nMO);
    }

    /**
     * @param sle
     *            nom de lobjet que l'on souhaite recuperer
     * @return l'objet associe a l'objet.
     */
    public NonMoveableObject getByNameObject(String s) {
        // TODO ajouter exception s'il n'existe pas ?
        for (NonMoveableObject n : this.listObject) {
            if (n.getName().equals(s))
                return n;
        }
        return null;
    }

}
