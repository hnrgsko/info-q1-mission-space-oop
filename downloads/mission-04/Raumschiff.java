public class Raumschiff {
    public String name;
    public double x;
    public double y;
    public double treibstoff;

    public Raumschiff(String name, double x, double y, double treibstoff) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.treibstoff = treibstoff;
    }

    public void tanke(double menge) {
        if (menge > 0) {
            treibstoff = treibstoff + menge;
        }
    }

    public void fliege(double dx, double dy) {
        if (treibstoff >= 1) {
            x = x + dx;
            y = y + dy;
            treibstoff = treibstoff - 1;
        }
    }
}
