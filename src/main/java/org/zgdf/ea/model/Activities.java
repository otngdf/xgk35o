package org.zgdf.ea.model;

public class Activities {

    private int activityID;
    private int userID;
    private String uName;
    private int customerID;
    private String cName;
    private String start;
    private String stop;
    private String comment;

    public int getActivityID() {
        return activityID;
    }

    public void setActivityID(int activityID) {
        this.activityID = activityID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getStop() {
        return stop;
    }

    public void setStop(String stop) {
        this.stop = stop;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    @Override
    public String toString() {
        return "Activities{" + "activityID=" + activityID + ", userID=" + userID + ", uName=" + uName + ", customerID=" + customerID + ", cName=" + cName + ", start=" + start + ", stop=" + stop + ", comment=" + comment + '}';
    }

}
