package optional.domain.monster;

import optional.domain.common.Entity;

public class Zombie implements Entity,Monster {
    private final String name;
    private final double hp;
    private final double damage;
    private final double speed;

    public Zombie(String name, double hp, double damage, double speed) {
        this.name = name;
        this.hp = hp;
        this.damage = damage;
        this.speed = speed;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getHealth() {
        return hp;
    }

    @Override
    public double getDamage() {
        return damage;
    }

    @Override
    public double getSpeed() {
        return speed;
    }
}
