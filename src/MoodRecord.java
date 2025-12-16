public class MoodRecord {
    private int value;
    private int date;

    public int getValue() { return value; }
    public void setValue(int amount) { value = amount; }
    
    public int getDate() { return date; }
    public void setDate(int amount) { date = amount; }

    public MoodRecord(int value, int date){
        this.value = value;
        this.date = date;
    }
}