
class BirdWatcher {
    private final int[] birdsPerDay;

    public BirdWatcher(int[] birdsPerDay) {
        this.birdsPerDay = birdsPerDay.clone();
    }

    public int[] getLastWeek() {
        int[] lastWeek = {0, 2, 5, 3, 7, 8, 4};
        return lastWeek;
    }

    public int getToday() {
        return birdsPerDay[6];
    }

    public void incrementTodaysCount() {
        birdsPerDay[6] += 1;
    }

    public boolean hasDayWithoutBirds() {
        for(int i = 0;i< 7; i++){
            if(birdsPerDay[i] == 0){
                return true;
            }
        }
        return false;
    }

    public int getCountForFirstDays(int numberOfDays) {
        int cont = 0;
        if( numberOfDays > 7){
            numberOfDays = 7;
        }
        for(int i = 0;i< numberOfDays; i++){
            cont += birdsPerDay[i];
        }
        return cont;
    }

    public int getBusyDays() {
        int cont = 0;
        for(int i = 0;i< 7; i++){
            if(birdsPerDay[i] >4){
                cont += 1;    
            }
            
        }
        return cont;
    }
}
