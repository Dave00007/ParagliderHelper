package com.application.paragliderhelper;


class Data {

    private static Integer valueSeekBarUp;
    private static Integer valueSeekBarDown;
    private static String firstName;
    private static String surname;
    private static String city;
    private static String phoneNumber1;
    private static String phoneNumber2;
    private static String phoneNumber3;
    private static Boolean selectedEnglish;

    static Integer getValueSeekBarDown() {

        return valueSeekBarDown;
    }

    static Integer getValueSeekBarUp() {
        return valueSeekBarUp;
    }

    static String getFirstName() {
        return firstName;
    }

    static String getSurname() {
        return surname;
    }

    static String getCity() {
        return city;
    }

    static String getPhoneNumber1() {
        return phoneNumber1;
    }

    static String getPhoneNumber2() {
        return phoneNumber2;
    }

    static String getPhoneNumber3() {
        return phoneNumber3;
    }

    static Boolean getSelectedEnglish() {
        return selectedEnglish;
    }

    static void setValueSeekBarDown(Integer valueSeekBarDown) {
        Data.valueSeekBarDown = valueSeekBarDown;
    }

    static void setValueSeekBarUp(Integer valueSeekBarUp) {
        Data.valueSeekBarUp = valueSeekBarUp;
    }

    static void setFirstName(String firstName) {
        Data.firstName = firstName;
    }

    static void setSurname(String surname) {
        Data.surname = surname;
    }

    static void setCity(String city) {
        Data.city = city;
    }

    static void setPhoneNumber1(String phoneNumber1) {
        Data.phoneNumber1 = phoneNumber1;
    }

    static void setPhoneNumber2(String phoneNumber2) {
        Data.phoneNumber2 = phoneNumber2;
    }

    static void setPhoneNumber3(String phoneNumber3) {
        Data.phoneNumber3 = phoneNumber3;
    }

    static void setSelectedEnglish(Boolean selectedEnglish) {
        Data.selectedEnglish = selectedEnglish;
    }
}
