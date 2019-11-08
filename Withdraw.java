package UAS;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Withdraw {

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

    public Withdraw() {
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

    public String getAmount() {
        return amount;
    }

    public String getEstimate() {
        return estimate;
    }

    public void saveData(String type, String from, String to, String amount, String estimate) {
        CRUDquery = "INSERT INTO `withdraw`(`cryptotype`, `receivedfrom`, `sendto`, `amount`, `estimate`) VALUES (?,?,?,?,?)";
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
        CRUDquery = "SELECT `cryptotype`, `id`, `receivedfrom`, `sendto`, `amount`, `estimate` FROM `withdraw`";
        try {
            CRUDstat = CRUDconnection.createStatement();
            result = CRUDstat.executeQuery(CRUDquery);
        } catch (Exception e) {
        }
        return result;
    }
    
    public ResultSet seeWallet(String userID) {
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
        CRUDquery = "delete from withdraw where id=?";
        try {
            CRUDpsmt = CRUDconnection.prepareStatement(CRUDquery);
            CRUDpsmt.setString(1, ID);
            CRUDpsmt.executeUpdate();
            CRUDpsmt.close();
        } catch (Exception e) {
        }
    }
}
