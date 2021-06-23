package game;

import java.util.ArrayList;

/**
 * Construction management
 *
 * @author CHARGÉ Maxime - IUT Vannes
 * @version 1.0
 */
public class Construction {
    private Cards itemToBuild;
    private int stone;
    private int wood;
    private int knowledge;
    private int tile;
    private boolean progress;
    private ArrayList<Cards> constructionWorkers;

    /**
     * Construction constructor
     *
     * @param cardToBuild building to be constructed
     */
    public Construction(Cards cardToBuild) {
        if (cardToBuild != null) {
            this.itemToBuild = cardToBuild;
            this.progress = false;
            this.constructionWorkers = new ArrayList<>();
        } else {
            System.err.println("ERREUR Construction : carte à construire null");
        }
    }

    public boolean getProgress() {
        return this.progress;
    }

    /**
     * Checks if all resources are reached
     *
     * @return True if everything is reached, otherwise false
     */
    public boolean calculateProgress() {
        boolean ret = false;
        if (calcutaleStone() && calculateWood() && calculateKnowledge() && calcutaleTile()) {
            this.progress = true;
            ret = true;
        }
        return ret;
    }

    /**
     * Calculate the total number of stones
     *
     * @return True if the number is reached or exceeded, otherwise false
     */
    private boolean calcutaleStone() {
        boolean ret = false;
        for (int i = 0; i < this.constructionWorkers.size() && !ret; i++) {
            this.stone += this.constructionWorkers.get(i).getStone();
            if (this.stone >= this.itemToBuild.getStone()) {
                ret = true;
            }
        }
        return ret;
    }

    /**
     * Calculate the total number of wood
     *
     * @return True if the number is reached or exceeded, otherwise false
     */
    private boolean calculateWood() {
        boolean ret = false;
        for (int i = 0; i < this.constructionWorkers.size() && !ret; i++) {
            this.wood += this.constructionWorkers.get(i).getWood();
            if (this.wood >= this.itemToBuild.getWood()) {
                ret = true;
            }
        }
        return ret;
    }

    /**
     * Calculate the total number of knowledge
     *
     * @return True if the number is reached or exceeded, otherwise false
     */
    private boolean calculateKnowledge() {
        boolean ret = false;
        for (int i = 0; i < this.constructionWorkers.size() && !ret; i++) {
            this.knowledge += this.constructionWorkers.get(i).getKnowledge();
            if (this.knowledge >= this.itemToBuild.getKnowledge()) {
                ret = true;
            }
        }
        return ret;
    }

    /**
     * Calculate the total number of tiles
     *
     * @return True if the number is reached or exceeded, otherwise false
     */
    private boolean calcutaleTile() {
        boolean ret = false;
        for (int i = 0; i < this.constructionWorkers.size() && !ret; i++) {
            this.tile += this.constructionWorkers.get(i).getTile();
            if (this.tile >= this.itemToBuild.getTile()) {
                ret = true;
            }
        }
        return ret;
    }

    /**
     * Add workers to the constrcution site
     *
     * @param worker Worker to add to the construction site
     */
    public void addWorker(Cards worker) {
        if (worker != null) {
            this.constructionWorkers.add(worker);
        } else {
            System.err.println("ERREUR addWorker : carte à ajouter null");
        }
    }

    /**
     * Return the building under construction
     *
     * @return A Building
     */
    public Cards getItemToBuild() {
        return this.itemToBuild;
    }
}