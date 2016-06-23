package com.example.chrissebesta.experiments;

/**
 * Created by chrissebesta on 6/23/16.
 */
public class PlantData implements Comparable<PlantData>{
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOptimal_sun() {
        return optimal_sun;
    }

    public void setOptimal_sun(String optimal_sun) {
        this.optimal_sun = optimal_sun;
    }

    public String getOptimal_soil() {
        return optimal_soil;
    }

    public void setOptimal_soil(String optimal_soil) {
        this.optimal_soil = optimal_soil;
    }

    public String getPlanting_considerations() {
        return planting_considerations;
    }

    public void setPlanting_considerations(String planting_considerations) {
        this.planting_considerations = planting_considerations;
    }

    public String getWhen_to_plant() {
        return when_to_plant;
    }

    public void setWhen_to_plant(String when_to_plant) {
        this.when_to_plant = when_to_plant;
    }

    public String getGrowing_from_seed() {
        return growing_from_seed;
    }

    public void setGrowing_from_seed(String growing_from_seed) {
        this.growing_from_seed = growing_from_seed;
    }

    public String getTransplanting() {
        return transplanting;
    }

    public void setTransplanting(String transplanting) {
        this.transplanting = transplanting;
    }

    public String getSpacing() {
        return spacing;
    }

    public void setSpacing(String spacing) {
        this.spacing = spacing;
    }

    public String getWatering() {
        return watering;
    }

    public void setWatering(String watering) {
        this.watering = watering;
    }

    public String getFeeding() {
        return feeding;
    }

    public void setFeeding(String feeding) {
        this.feeding = feeding;
    }

    public String getOther_care() {
        return other_care;
    }

    public void setOther_care(String other_care) {
        this.other_care = other_care;
    }

    public String getDiseases() {
        return diseases;
    }

    public void setDiseases(String diseases) {
        this.diseases = diseases;
    }

    public String getPests() {
        return pests;
    }

    public void setPests(String pests) {
        this.pests = pests;
    }

    public String getHarvesting() {
        return harvesting;
    }

    public void setHarvesting(String harvesting) {
        this.harvesting = harvesting;
    }

    public String getStorage_use() {
        return storage_use;
    }

    public void setStorage_use(String storage_use) {
        this.storage_use = storage_use;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    private String id; //"id";
    private String name; //"name";
    private String description; //"description";
    private String optimal_sun; //"optimal_sun";
    private String optimal_soil; //"optimal_soil";
    private String planting_considerations; //"planting_considerations";
    private String when_to_plant; //"when_to_plant";
    private String growing_from_seed; //"growing_from_seed";
    private String transplanting; //"transplanting";
    private String spacing; //"spacing";
    private String watering; //"watering";
    private String feeding; //"feeding";
    private String other_care; //"other_care";
    private String diseases; //"diseases";
    private String pests; //"pests";
    private String harvesting; //"harvesting";
    private String storage_use; //"storage_use";
    private String image; //"image";
    PlantData(){};

    PlantData(String id, String name, String description, String optimal_sun, String optimal_soil, String planting_considerations, String when_to_plant, String growing_from_seed, String transplanting, String spacing, String watering, String feeding, String other_care, String diseases, String pests, String harvesting, String storage_use, String image){
        this.id = id;
        this.name = name;
        this.description = description;
        this.optimal_sun = optimal_sun;

        this.optimal_soil = optimal_soil;
        this.planting_considerations = planting_considerations;
        this.when_to_plant = when_to_plant;
        this.growing_from_seed = growing_from_seed;
        this.transplanting = transplanting;
        this.spacing = spacing;
        this.watering = watering;
        this.feeding = feeding;
        this.other_care = other_care;
        this.diseases = diseases;
        this.pests = pests;
        this.harvesting = harvesting;
        this.storage_use = storage_use;
        this.image = image;
    }

    //Useful for alphabetizing lists
    @Override
    public int compareTo(PlantData another) {
        return name.compareTo(another.name);
    }
}
