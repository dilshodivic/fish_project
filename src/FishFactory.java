public class FishFactory {

    public static Fish createFish( Aquarium aquarium) {
        int x = AquariumUtil.getRandom(AquariumUtil.coordinateX + 1); // 0,1,2,3,4,5
        int y = AquariumUtil.getRandom(AquariumUtil.coordinateY + 1); // 0,1,2,3,4,5
        int life = AquariumUtil.getRandomBetween(5, 20);
        Gender gender = AquariumUtil.getRandomGender();
        Fish fish = new Fish(x, y, life, gender, aquarium);
        return fish;
    }
}
