public class Raumschiff {
    private String name;
    private double x;
    private double y;
    private double treibstoff;

    public Raumschiff(String name, double x, double y, double treibstoff) {
        this.name = name;
        this.x = x;
        this.y = y;
        if (treibstoff < 0) {
            this.treibstoff = 0;
        } else if (treibstoff > 100) {
            this.treibstoff = 100;
        } else {
            this.treibstoff = treibstoff;
        }
    }

    public void tanke(double menge) {
        if (menge > 0) {
            treibstoff = Math.min(100, treibstoff + menge);
        }
    }

    public boolean fliege(double dx, double dy) {
        if (treibstoff >= 1) {
            x = x + dx;
            y = y + dy;
            treibstoff = treibstoff - 1;
            return true;
        }
        return false;
    }

    public boolean hatTreibstoff() {
        return treibstoff > 0;
    }

    public double berechneEntfernung(double zielX, double zielY) {
        double dx = zielX - x;
        double dy = zielY - y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    public String getName() { return name; }
    public double getX() { return x; }
    public double getY() { return y; }
    public double getTreibstoff() { return treibstoff; }
}
