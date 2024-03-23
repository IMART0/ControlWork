public class BroadcastsTime implements Comparable<BroadcastsTime> {
    private final byte hour;
    private final byte minutes;
    BroadcastsTime(byte hour, byte minutes) {
        this.hour = hour;
        this.minutes = minutes;
    }
    byte hour() {return hour;}
    byte minutes() {return minutes;}
    boolean after(BroadcastsTime t) {return ((hour() >= t.hour()) && (minutes() > t.minutes()));}
    boolean befor(BroadcastsTime t) {return ((hour() <= t.hour()) && (minutes() < t.minutes()));}
    boolean between(BroadcastsTime t1, BroadcastsTime t2) {
        return ( (hour() < t2.hour()) && (hour() > t1.hour()) && (minutes() < t2.minutes()) && (minutes() > t1.minutes()) );
    }
    @Override
    public int compareTo(BroadcastsTime bt) {
        if (hour() != bt.hour())
            return hour() - bt.hour();
        else
            return minutes() - bt.minutes();
    }
}
