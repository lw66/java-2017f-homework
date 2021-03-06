import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Queue {
    private Position[] positions;

    public Position[] getPositions() {
        return positions;
    }

    public Creature[] getCreatures() {
        return creatures;
    }

    private Creature[] creatures;

    public Queue(Creature[] brothers) {

        this.positions = new Position[brothers.length];

        this.creatures = brothers;

        for (int i = 0; i < brothers.length; i++) {

            this.positions[i] = new Position(i);
            this.creatures[i].setPosition(this.positions[i]);
        }
    }


    public void rollCall() {
        for (Creature creature : this.creatures) {
            creature.report();
        }
        System.out.println("\n");
        System.out.flush();

    }

    public void shuffle() {
        Random rnd = ThreadLocalRandom.current();
        for (int i = creatures.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            Position position = creatures[index].getPosition();
            creatures[index].setPosition(creatures[i].getPosition());
            creatures[i].setPosition(position);
        }
    }
}
