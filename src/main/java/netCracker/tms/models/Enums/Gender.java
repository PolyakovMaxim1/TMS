package netCracker.tms.models.Enums;

public enum Gender {
    MALE("Male"),
    FEMALE("Female");

    String name;
    Gender(String name){
        this.name = name;
    }

    @Override
    public String toString(){
        return name;
    }
}
