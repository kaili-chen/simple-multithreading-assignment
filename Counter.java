package proj.classes;

public abstract class Counter {

    private String counterName;
    private int nowServing;
    private String counterStaff;    //name of staff at counter
    private boolean isOpen = false;

    public Counter(String counterName, int nowServing, String counterStaff) {
        this.counterName = counterName;
        this.nowServing = nowServing;
        this.counterStaff = counterStaff;
        if (counterStaff.trim().length() != 0) {
            isOpen = true;
        }
    } 

    public String getCounterName() {
        return counterName;
    }

    public int getNowServing() {
        return nowServing;
    }

    public String getCounterStaff() {
        return counterStaff;
    }

    public boolean isCounterOpen() {
        return isOpen;
    }

    public void setCounterName(String newCounterName) {
        counterName = newCounterName;
    }

    public void setNowServing(int newNowServing) {
        nowServing = newNowServing;
    }

    public void setCounterStaff(String newCounterStaff) {
        counterStaff = newCounterStaff;
    }

    public void toggleOpen() {
        if (isOpen) {
            isOpen = false;
        } else {
            isOpen = true;
        }
    }

}