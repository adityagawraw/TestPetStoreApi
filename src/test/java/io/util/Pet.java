package io.util;

public class Pet {
    private String petId;
    private String additionalMetaData;
    private String filepath;

    public String getPetId() {
        return petId;
    }

    public void setPetId(String petId) {
        this.petId = petId;
    }

    public String getAdditionalMetaData() {
        return additionalMetaData;
    }

    public void setAdditionalMetaData(String additionalMetaData) {
        this.additionalMetaData = additionalMetaData;
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }
}
