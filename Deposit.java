package UAS;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;

public class Deposit {

    private String type;

    private String ID;

    private String from;

    private String to;

    private String amount;

    private String estimate;

    private Connection CRUDconnection;

    private PreparedStatement CRUDpsmt;

    private Statement CRUDstat;

    private ResultSet result;

    private String CRUDquery;

    private String generatedWallet;

    public Deposit() {
        try {
            Koneksi connection = new Koneksi();
            CRUDconnection = connection.getConnection();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setTransactionID(String ID) {
        this.ID = ID;
    }

    public void setReceiveFrom(String from) {
        this.from = from;
    }

    public void setSendTo(String to) {
        this.to = to;
    }

    public void setGeneratedWallet(String generatedWallet) {
        this.generatedWallet = generatedWallet;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public void setEstimate(String estimate) {
        this.estimate = estimate;
    }

    public String getType() {
        return type;
    }

    public String getTransactionID() {
        return ID;
    }

    public String getReceiveFrom() {
        return from;
    }

    public String getSendTo() {
        return to;
    }

    public String getGeneratedWallet() {
        return generatedWallet;
    }

    public String getAmount() {
        return amount;
    }

    public String getEstimate() {
        return estimate;
    }

    public String getAlphaNumericString(int n) {
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";

        StringBuilder sb = new StringBuilder(n);

        for (int i = 0; i < n; i++) {
            int index
                    = (int) (AlphaNumericString.length()
                    * Math.random());
            sb.append(AlphaNumericString
                    .charAt(index));
        }

        return sb.toString();
    }

    public void saveWalletETH(String userID) {
        int n = 40;
        String settingWallet = "0x" + getAlphaNumericString(n);
        CRUDquery = "UPDATE `user` SET `ETH_Wallet`= ? WHERE user_id = ?";
        try {
            CRUDpsmt = CRUDconnection.prepareStatement(CRUDquery);
            CRUDpsmt.setString(1, settingWallet);
            CRUDpsmt.setString(2, userID);
            CRUDpsmt.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void saveWalletBTC(String userID) {
        int n = 33;
        String settingWallet = "1" + getAlphaNumericString(n);
        CRUDquery = "UPDATE `user` SET `BTC_Wallet`= ? WHERE user_id = ?";
        try {
            CRUDpsmt = CRUDconnection.prepareStatement(CRUDquery);
            CRUDpsmt.setString(1, settingWallet);
            CRUDpsmt.setString(2, userID);
            CRUDpsmt.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void saveWalletBCH(String userID) {
        int n = 33;
        String settingWallet = "3" + getAlphaNumericString(n);
        CRUDquery = "UPDATE `user` SET `BCH_Wallet`= ? WHERE user_id = ?";
        try {
            CRUDpsmt = CRUDconnection.prepareStatement(CRUDquery);
            CRUDpsmt.setString(1, settingWallet);
            CRUDpsmt.setString(2, userID);
            CRUDpsmt.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void saveWalletXRP(String userID) {
        int n = 33;
        String settingWallet = "r" + getAlphaNumericString(n);
        CRUDquery = "UPDATE `user` SET `XRP_Wallet`= ? WHERE user_id = ?";
        try {
            CRUDpsmt = CRUDconnection.prepareStatement(CRUDquery);
            CRUDpsmt.setString(1, settingWallet);
            CRUDpsmt.setString(2, userID);
            CRUDpsmt.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void saveWalletDASH(String userID) {
        int n = 34;
        String settingWallet = "X" + getAlphaNumericString(n);
        CRUDquery = "UPDATE `user` SET `DASH_Wallet`= ? WHERE user_id = ?";
        try {
            CRUDpsmt = CRUDconnection.prepareStatement(CRUDquery);
            CRUDpsmt.setString(1, settingWallet);
            CRUDpsmt.setString(2, userID);
            CRUDpsmt.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void saveWalletLTC(String userID) {
        int n = 34;
        String settingWallet = "L" + getAlphaNumericString(n);
        CRUDquery = "UPDATE `user` SET `LTC_Wallet`= ? WHERE user_id = ?";
        try {
            CRUDpsmt = CRUDconnection.prepareStatement(CRUDquery);
            CRUDpsmt.setString(1, settingWallet);
            CRUDpsmt.setString(2, userID);
            CRUDpsmt.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void saveData(String type, String from, String to, String amount, String estimate) {
        CRUDquery = "INSERT INTO `deposit`(`cryptotype`, `receivedfrom`, `sendto`, `amount`, `estimate`) VALUES (?,?,?,?,?)";
        try {
            CRUDpsmt = CRUDconnection.prepareStatement(CRUDquery);
            CRUDpsmt.setString(1, type);
            CRUDpsmt.setString(2, from);
            CRUDpsmt.setString(3, to);
            CRUDpsmt.setString(4, amount);
            CRUDpsmt.setString(5, estimate);
            CRUDpsmt.executeUpdate();
            CRUDpsmt.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public ResultSet seeData() {
        CRUDquery = "SELECT `cryptotype`, `id`, `receivedfrom`, `sendto`, `amount`, `estimate` FROM `deposit`";
        try {
            CRUDstat = CRUDconnection.createStatement();
            result = CRUDstat.executeQuery(CRUDquery);
        } catch (Exception e) {
        }
        return result;
    }

    public ResultSet seeUpdatedWallet(String userID) {
        CRUDquery = "SELECT `wallet` from `user` where `user_id` = ?";
        try {
            CRUDstat = CRUDconnection.createStatement();
            result = CRUDstat.executeQuery(CRUDquery);
            CRUDpsmt.setString(1, userID);
        } catch (Exception e) {
        }
        return result;
    }

    public void deleteHistory(String ID) {
        CRUDquery = "delete from deposit where id=?";
        try {
            CRUDpsmt = CRUDconnection.prepareStatement(CRUDquery);
            CRUDpsmt.setString(1, ID);
            CRUDpsmt.executeUpdate();
            CRUDpsmt.close();
        } catch (Exception e) {
        }
    }
}
