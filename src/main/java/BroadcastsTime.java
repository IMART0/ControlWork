public class BroadcastsTime implements Comparable<BroadcastsTime> {
    private final byte hour;
    private final byte minutes;
    BroadcastsTime(byte hour, byte minutes) {
        this.hour = hour;
        this.minutes = minutes;
    }
    BroadcastsTime(String data) {
        this.hour = Byte.parseByte("" + data.charAt(0) + data.charAt(1));
        this.minutes = Byte.parseByte("" + data.charAt(3) + data.charAt(4));
    }
    byte hour() {return hour;}
    byte minutes() {return minutes;}
    boolean after(BroadcastsTime t) {return ((hour() >= t.hour()) && (minutes() > t.minutes()));}
    boolean befor(BroadcastsTime t) {return ((hour() <= t.hour()) && (minutes() < t.minutes()));}
    boolean between(BroadcastsTime t1, BroadcastsTime t2) {
        if ( (hour() < t2.hour()) && (hour() > t1.hour()))
            return true;
        else if ((hour() > t2.hour()) && (hour() < t1.hour()))
            return false;
        else {
            return ( (minutes() < t2.minutes()) && (minutes() > t1.minutes()));
        }
    }
    @Override
    public int compareTo(BroadcastsTime bt) {
        if (hour() != bt.hour())
            return hour() - bt.hour();
        else
            return minutes() - bt.minutes();
    }

    @Override
    public String toString() {
        return "" + hour + ":" + minutes;
    }

    @Override
    public boolean equals(Object obj) {
        BroadcastsTime bt = (BroadcastsTime) obj;
        return ((bt.hour() == hour()) && (bt.minutes() == minutes()));
    }
}
