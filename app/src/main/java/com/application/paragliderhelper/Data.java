package com.application.paragliderhelper;


class Data {

    private static Integer valueSeekBarUp = 0;
    private static Integer valueSeekBarDown = 0;
    private static String firstName = "";
    private static String surname = "";
    private static String city = "";
    private static String phoneNumber1 = "";
    private static String phoneNumber2 = "";
    private static String phoneNumber3 = "";

    static Integer getValueSeekBarDown() {
        return valueSeekBarDown;
    }

    static Integer getValueSeekBarUp() {
        return valueSeekBarUp;
    }

    public static String getFirstName() {
        return firstName;
    }

    public static String getSurname() {
        return surname;
    }

    public static String getCity() {
        return city;
    }

    public static String getPhoneNumber1() {
        return phoneNumber1;
    }

    public static String getPhoneNumber2() {
        return phoneNumber2;
    }

    public static String getPhoneNumber3() {
        return phoneNumber3;
    }

    static void setValueSeekBarDown(Integer valueSeekBarDown) {
        Data.valueSeekBarDown = valueSeekBarDown;
    }

    static void setValueSeekBarUp(Integer valueSeekBarUp) {
        Data.valueSeekBarUp = valueSeekBarUp;
    }

    public static void setFirstName(String firstName) {
        Data.firstName = firstName;
    }

    public static void setSurname(String surname) {
        Data.surname = surname;
    }

    public static void setCity(String city) {
        Data.city = city;
    }

    public static void setPhoneNumber1(String phoneNumber1) {
        Data.phoneNumber1 = phoneNumber1;
    }

    public static void setPhoneNumber2(String phoneNumber2) {
        Data.phoneNumber2 = phoneNumber2;
    }

    public static void setPhoneNumber3(String phoneNumber3) {
        Data.phoneNumber3 = phoneNumber3;
    }
}
