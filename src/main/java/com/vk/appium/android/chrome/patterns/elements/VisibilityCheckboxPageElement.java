package com.vk.appium.android.chrome.patterns.elements;

import org.openqa.selenium.By;

public class VisibilityCheckboxPageElement {
    private static final By ALL_FRIEND_CHECKBOX = By.xpath(".//input[@id='field_toFriend']");
    private static final By RELATIVE_CHECKBOX = By.xpath(".//input[@id='field_toRelative']");
    private static final By MY_PARTNER_CHECKBOX = By.xpath(".//input[@id='field_toLove']");
    private static final By BEST_FRIEND_CHECKBOX = By.xpath(".//input[@id='field_toCloseFriend']");
    private static final By COLLEAGUES_CHECKBOX = By.xpath(".//input[@id='field_toCollegue']");
    private static final By CLASSMATES_CHECKBOX = By.xpath(".//input[@id='field_toClassmate']");
    private static final By COURSE_MATES_CHECKBOX = By.xpath(".//input[@id='field_toCursemate']");
    private static final By ARMY_FRIENDS_CHECKBOX = By.xpath(".//input[@id='field_toCompanionInArms']");
    private static final By ONLY_TO_ME = By.xpath(".//input[@id='field_toprivate']");


    public static By getAllFriendCheckbox() {
        return ALL_FRIEND_CHECKBOX;
    }

    public static By getArmyFriendsCheckbox() {
        return ARMY_FRIENDS_CHECKBOX;
    }

    public static By getClassmatesCheckbox() {
        return CLASSMATES_CHECKBOX;
    }

    public static By getColleaguesCheckbox() {
        return COLLEAGUES_CHECKBOX;
    }

    public static By getBestFriendCheckbox() {
        return BEST_FRIEND_CHECKBOX;
    }

    public static By getMyPartnerCheckbox() {
        return MY_PARTNER_CHECKBOX;
    }

    public static By getRelativeCheckbox() {
        return RELATIVE_CHECKBOX;
    }

    public static By getCourseMatesCheckbox() {
        return COURSE_MATES_CHECKBOX;
    }

    public static By getOnlyToMe() {
        return ONLY_TO_ME;
    }
}
