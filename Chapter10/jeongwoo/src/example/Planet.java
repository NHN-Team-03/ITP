package example;

abstract class Planet {
    private String name;
    private String soilCondition;
    public Planet(String name, String soilCondition){
        this.name = name;
        this.soilCondition = soilCondition;
    }

    public void visit(){
        SpaceShip.visit(name,soilCondition);
    }

    public String getSoilCondition() {
        return soilCondition;
    }

    public String getName() {
        return name;
    }
}
