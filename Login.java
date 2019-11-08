package UAS;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Login {

    private String userID;

    private String password;

    private Connection CRUDconnection;

    private PreparedStatement CRUDpsmt;

    private Statement CRUDstat;

    private ResultSet userData;

    private String CRUDquery;

    private String massage;

    public Login() {
        try {
            Koneksi connection = new Koneksi();
            CRUDconnection = connection.getConnection();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserID() {
        return userID;
    }

    public String getPassword() {
        return password;
    }

    public String loginCheck(String userID, String password) {
        CRUDquery = "SELECT `name`, `BTC_Wallet`, `BTC_Wallet`, `ETH_Wallet`, `BCH_Wallet`, `XRP_Wallet`, `DASH_Wallet`, `LTC_Wallet` FROM user WHERE `user_id` = ? AND `password` = md5(?)";
        try {
            CRUDpsmt = CRUDconnection.prepareStatement(CRUDquery);
            CRUDpsmt.setString(1, userID);
            CRUDpsmt.setString(2, password);
            userData = CRUDpsmt.executeQuery();
            if (userData.next()) {
                Session.setUserID(userID);
                Session.setName(userData.getString("name"));
                Session.setLoginStatus("Active");
                Session.setBTCWallet(userData.getString("BTC_Wallet"));
                Session.setETHWallet(userData.getString("ETH_Wallet"));
                Session.setBCHWallet(userData.getString("BCH_Wallet"));
                Session.setXRPWallet(userData.getString("XRP_Wallet"));
                Session.setDASHWallet(userData.getString("DASH_Wallet"));
                Session.setLTCWallet(userData.getString("LTC_Wallet"));
                CRUDquery = "INSERT INTO login_log (user_id) VALUES (?)";
                try {
                    CRUDpsmt = CRUDconnection.prepareStatement(CRUDquery);
                    CRUDpsmt.setString(1, userID);
                    CRUDpsmt.executeUpdate();
                    CRUDpsmt.close();
                } catch (Exception e) {
                    massage = "Log Can't Saved";
                }
            } else {
                massage = "Can't Login";
            }
        } catch (Exception e) {
            massage = "Error Query";
        }
        return massage;
    }

    public void logout(String userID) {
        CRUDquery = "UPDATE login_log SET logout_time = CURRENT_TIMESTAMP() WHERE user_id = ? ORDER BY id DESC LIMIT 1";
        try {
            CRUDpsmt = CRUDconnection.prepareStatement(CRUDquery);
            CRUDpsmt.setString(1, userID);
            CRUDpsmt.executeUpdate();
            CRUDpsmt.close();
            CRUDconnection.close();
            Session.setUserID(null);
            Session.setName(null);
            Session.setLoginStatus(null);
        } catch (Exception e) {

        }
    }
}
