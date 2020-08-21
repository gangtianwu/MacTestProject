package com.ding.pokedex.entity;

import androidx.room.Entity;

import java.io.Serializable;
import java.util.List;

@Entity
public class Pokemon implements Serializable {
    /**
     * name : Bulbasaur
     * id : #001
     * imageurl : https://assets.pokemon.com/assets/cms2/img/pokedex/full/001.png
     * xdescription : Bulbasaur can be seen napping in bright sunlight. There is a seed on its back. By soaking up the sun's rays, the seed grows progressively larger.
     * ydescription : Bulbasaur can be seen napping in bright sunlight. There is a seed on its back. By soaking up the sun's rays, the seed grows progressively larger.
     * height : 2' 04"
     * category : Seed
     * weight : 15.2 lbs
     * typeofpokemon : ["Grass","Poison"]
     * weaknesses : ["Fire","Flying","Ice","Psychic"]
     * evolutions : ["#001","#002","#003"]
     * abilities : ["Overgrow"]
     * hp : 20
     * attack : 30
     * defense : 20
     * special_attack : 30
     * special_defense : 30
     * speed : 30
     * total : 160
     * male_percentage : 87.5%
     * female_percentage : 12.5%
     * genderless : 0
     * cycles : 20
     * egg_groups : Grass, Monster
     * evolvedfrom :
     * reason :
     * base_exp : 64
     */

    private String name;
    private String id;
    private String imageurl;
    private String xdescription;
    private String ydescription;
    private String height;
    private String category;
    private String weight;
    private int hp;
    private int attack;
    private int defense;
    private int special_attack;
    private int special_defense;
    private int speed;
    private int total;
    private String male_percentage;
    private String female_percentage;
    private int genderless;
    private String cycles;
    private String egg_groups;
    private String evolvedfrom;
    private String reason;
    private String base_exp;
    private List<String> typeofpokemon;
    private List<String> weaknesses;
    private List<String> evolutions;
    private List<String> abilities;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public String getXdescription() {
        return xdescription;
    }

    public void setXdescription(String xdescription) {
        this.xdescription = xdescription;
    }

    public String getYdescription() {
        return ydescription;
    }

    public void setYdescription(String ydescription) {
        this.ydescription = ydescription;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getSpecial_attack() {
        return special_attack;
    }

    public void setSpecial_attack(int special_attack) {
        this.special_attack = special_attack;
    }

    public int getSpecial_defense() {
        return special_defense;
    }

    public void setSpecial_defense(int special_defense) {
        this.special_defense = special_defense;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getMale_percentage() {
        return male_percentage;
    }

    public void setMale_percentage(String male_percentage) {
        this.male_percentage = male_percentage;
    }

    public String getFemale_percentage() {
        return female_percentage;
    }

    public void setFemale_percentage(String female_percentage) {
        this.female_percentage = female_percentage;
    }

    public int getGenderless() {
        return genderless;
    }

    public void setGenderless(int genderless) {
        this.genderless = genderless;
    }

    public String getCycles() {
        return cycles;
    }

    public void setCycles(String cycles) {
        this.cycles = cycles;
    }

    public String getEgg_groups() {
        return egg_groups;
    }

    public void setEgg_groups(String egg_groups) {
        this.egg_groups = egg_groups;
    }

    public String getEvolvedfrom() {
        return evolvedfrom;
    }

    public void setEvolvedfrom(String evolvedfrom) {
        this.evolvedfrom = evolvedfrom;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getBase_exp() {
        return base_exp;
    }

    public void setBase_exp(String base_exp) {
        this.base_exp = base_exp;
    }

    public List<String> getTypeofpokemon() {
        return typeofpokemon;
    }

    public void setTypeofpokemon(List<String> typeofpokemon) {
        this.typeofpokemon = typeofpokemon;
    }

    public List<String> getWeaknesses() {
        return weaknesses;
    }

    public void setWeaknesses(List<String> weaknesses) {
        this.weaknesses = weaknesses;
    }

    public List<String> getEvolutions() {
        return evolutions;
    }

    public void setEvolutions(List<String> evolutions) {
        this.evolutions = evolutions;
    }

    public List<String> getAbilities() {
        return abilities;
    }

    public void setAbilities(List<String> abilities) {
        this.abilities = abilities;
    }
}
