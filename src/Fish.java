public class Fish extends Thread {
    private int x;
    private int y;
    private int life;
    private Gender gender;
    private Aquarium aquarium;

    public Fish(int x, int y, int life, Gender gender, Aquarium aquarium) {
        this.x = x;
        this.y = y;
        this.life = life;
        this.gender = gender;
        this.aquarium = aquarium;
    }


    @Override
    public void run() {
        while (life > 0) {
            move();
            try {
                Thread.sleep(1000);
                life--;
                aquarium.checkForCollision(this);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        aquarium.removeFish(this);
    }
    public void move() {
        // x y;
        int direction = AquariumUtil.getRandom(4); // 0,1,2,3
        // 0-up,1-right,2-down,3-left
        switch (direction) {
            case 0:
                if (y < AquariumUtil.coordinateY) {
                    y++;
                }
                break;
            case 1:
                if (x < AquariumUtil.coordinateX) {
                    x++;
                }
                break;
            case 2:
                if (y > 0) {
                    y--;
                }
                break;
            case 3:
                if (x > 0) {
                    x--;
                }
                break;
        }

    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Fish{" +
                "name=" + getName() +
                ", x=" + x +
                ", y=" + y +
                ", life=" + life +
                ", gender=" + gender +
                '}';
    }

    public boolean collision(Fish f) {
        if (this.x == f.x && this.y == f.y && !this.gender.equals(f.gender)) {
            return true;
        }
        return false;
    }
}
