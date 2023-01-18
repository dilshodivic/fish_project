import java.util.LinkedList;

public class Aquarium {
    private LinkedList<Fish> fishLinkedList = new LinkedList<>();

    public void start() {
        int size = AquariumUtil.getRandom(10);
        for (int i = 0; i < size; i++) {
            fishLinkedList.add(FishFactory.createFish(this));
        }
//        fishLinkedList.forEach(fish -> System.out.println(fish));
        for (Fish fish : fishLinkedList) {
            fish.start();
        }
    }

    public void checkForCollision(Fish fish) {
        synchronized (fishLinkedList) {
            if (fishLinkedList.size() < AquariumUtil.totalAmount) {
                Fish babyFish = null;
                for (Fish f : fishLinkedList) {
                    if (fish.collision(f)) {
                        babyFish = FishFactory.createFish(this);
                        String str = String.format("Collision: Fish1 - {%s}, Fish2 - {%s}, baby - {%s}", fish.getName(), f.getName(), babyFish.getName());
                        System.out.println(str);
                        break;
                    }
                }
                if (babyFish != null) {
                    fishLinkedList.add(babyFish);
                }
            }

            printDetail();
        }
    }

    public synchronized void printDetail() {
        int totalSize = fishLinkedList.size();
        int m = 0;
        int f = 0;
        for (Fish fish : fishLinkedList) {
            if (fish.getGender().equals(Gender.M)) {
                m++;
            } else {
                f++;
            }
        }
        System.out.println("==============================");
        System.out.println("TotalCount:" + totalSize);
        System.out.println("Male:" + m);
        System.out.println("Female:" + f);
        System.out.println("==============================");
    }

    public void removeFish(Fish fish) {
        synchronized (fishLinkedList) {
            fishLinkedList.remove(fish);
            System.out.println("------------------------");
            System.out.println("Fish dead: " + fish);
            System.out.println("------------------------");
            printDetail();
        }
    }
}
