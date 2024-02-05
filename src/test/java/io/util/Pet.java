package io.util;

public class Pet {
    private String TCID;
    private String excecution;
    private String petId;
    private String additionalMetaData;
    private String filepath;
    private String status;

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

    public String getTCID() {
        return TCID;
    }

    public void setTCID(String TCID) {
        this.TCID = TCID;
    }

    public String getExcecution() {
        return excecution;
    }

    public void setExcecution(String excecution) {
        this.excecution = excecution;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
