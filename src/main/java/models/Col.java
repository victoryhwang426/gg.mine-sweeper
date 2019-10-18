package models;

public class Col {
    private boolean isSafety;
    private boolean isUsed;
    private String message;

    public Col(boolean isSafety, boolean isUsed){
        this.isSafety = isSafety;
        this.isUsed = isUsed;
    }

    public boolean isSafety() {
        return isSafety;
    }

    public boolean isMineZone(){
        return !isSafety;
    }

    public boolean isUsed() {
        return isUsed;
    }

    public void setUsed(boolean used) {
        this.isUsed = used;
    }

    public void setSafety(boolean isSafeZone) {
        this.isSafety = isSafeZone;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
