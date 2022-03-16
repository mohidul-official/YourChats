package com.xampweb.yourchats.Models;

public class CallModel {
    String profilePic, userName, phone, fromUid, toUid;
    long timestamp;

    public CallModel(String profilePic, String userName, String phone, String fromUid, String toUid, long timestamp) {
        this.profilePic = profilePic;
        this.userName = userName;
        this.phone = phone;
        this.fromUid = fromUid;
        this.toUid = toUid;
        this.timestamp = timestamp;
    }

    public CallModel() {
    }

    public String getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFromUid() {
        return fromUid;
    }

    public void setFromUid(String fromUid) {
        this.fromUid = fromUid;
    }

    public String getToUid() {
        return toUid;
    }

    public void setToUid(String toUid) {
        this.toUid = toUid;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
