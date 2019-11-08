/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UAS;

/**
 *
 * @author Lenovo
 */
public class Session {

    private static String name, userID, password, loginStatus;
    private static String BTCWallet, ETHWallet, BCHWallet, XRPWallet, DASHWallet, LTCWallet;

    public static void setName(String name) {
        Session.name = name;
    }

    public static void setUserID(String userID) {
        Session.userID = userID;
    }

    public static void setPassword(String password) {
        Session.password = password;
    }

    public static void setLoginStatus(String loginStatus) {
        Session.loginStatus = loginStatus;
    }

    public static void setBTCWallet(String BTCWallet) {
        Session.BTCWallet = BTCWallet;
    }

    public static void setETHWallet(String ETHWallet) {
        Session.ETHWallet = ETHWallet;
    }

    public static void setBCHWallet(String BCHWallet) {
        Session.BCHWallet = BCHWallet;
    }

    public static void setXRPWallet(String XRPWallet) {
        Session.XRPWallet = XRPWallet;
    }

    public static void setDASHWallet(String DASHWallet) {
        Session.DASHWallet = DASHWallet;
    }

    public static void setLTCWallet(String LTCWallet) {
        Session.LTCWallet = LTCWallet;
    }

    public static String getName() {
        return name;
    }

    public static String getUserID() {
        return userID;
    }

    public static String getPassword() {
        return password;
    }

    public static String getLoginStatus() {
        return loginStatus;
    }

    public static String getBTCWallet() {
        return BTCWallet;
    }

    public static String getETHWallet() {
        return ETHWallet;
    }

    public static String getBCHWallet() {
        return BCHWallet;
    }

    public static String getXRPWallet() {
        return XRPWallet;
    }

    public static String getDASHWallet() {
        return DASHWallet;
    }

    public static String getLTCWallet() {
        return LTCWallet;
    }
}
