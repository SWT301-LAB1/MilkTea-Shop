/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import context.DBContext;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Shipping;

/**
 *
 * @author Admin
 */
public class ShippingDBcontext extends DBContext{
    public int createReturnId(Shipping shipping) {
        String sql = "INSERT INTO [dbo].[Shipping] ([name], [phone], [address]) OUTPUT INSERTED.ID VALUES (?, ?, ?)";

        try (PreparedStatement stm = connection.prepareStatement(sql)) {
            // Set the values for the name, phone, and address parameters
            stm.setString(1, shipping.getName());
            stm.setString(2, shipping.getPhone());
            stm.setString(3, shipping.getAddress());

            // Execute the insert statement
            ResultSet rs = stm.executeQuery();

            // Retrieve the generated ID from the result set
            if (rs.next()) {
                return rs.getInt("ID");
            }
        } catch (Exception ex) {
            // Log the exception with SEVERE level
            Logger.getLogger(ShippingDBcontext.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Return 0 if no key was generated or an exception occurred
        return 0;
    }

}
