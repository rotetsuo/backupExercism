class Fighter {
    boolean isVulnerable() {
        return true;
    }

    int getDamagePoints(Fighter fighter) {
        return 1;
    }
}

class Warrior extends Fighter {
    // CORREÇÃO: O método toString() deve ser public.
    @Override
    public String toString() {
        return "Fighter is a Warrior";
    }
    
    @Override
    boolean isVulnerable() {
        return false;
    }

    @Override
    int getDamagePoints(Fighter fighter) {
        return fighter.isVulnerable() ? 10 : 6;
    }
}

class Wizard extends Fighter {
    boolean spellPrepared = false;
    
    // CORREÇÃO: O método toString() deve ser public.
    @Override
    public String toString() {
        return "Fighter is a Wizard";
    }
    
    void prepareSpell() {
        this.spellPrepared = true;
    }

     @Override
     boolean isVulnerable() {
         if (this.spellPrepared){ 
            return false;
         }
        return true;
     }

    @Override
    int getDamagePoints(Fighter fighter) {
         if (this.spellPrepared){
            spellPrepared = false;  
            return 12;
         }
        return 3;
    }
}