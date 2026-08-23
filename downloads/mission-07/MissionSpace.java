public class MissionSpace {
    private Raumschiff schiff;
    private SpaceWindow window;

    public MissionSpace() {
        schiff = new Raumschiff("Orion", 200, 300, 100);
        window = new SpaceWindow(800, 600, "Mission Space");
    }

    public void zeichneSzene() {
        window.beginFrame();
        window.drawShip(schiff.getX(), schiff.getY(), schiff.getName(), schiff.getTreibstoff());
        window.drawText(20, 25, "Erster Flug: Objekt wird sichtbar");
        window.endFrame();
    }
}
