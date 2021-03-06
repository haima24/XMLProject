/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package xml.bar.core;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.*;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import xml.bar.binding.discounts.DiscountType;
import xml.bar.binding.discounts.Discounts;
import xml.bar.binding.dishcategories.DishCategories;
import xml.bar.binding.dishcategories.DishCategoryType;
import xml.bar.binding.restaurants.RestaurantType;
import xml.bar.binding.restaurants.Restaurants;

/**
 *
 * @author Tu
 */
public class DbEntities {

    public static boolean insertRestaurant(RestaurantType res) {
        try {
            String sql = "insert into BAR_Restaurant (Name,Latitute,Longtitue,Address,Description,PhoneNum,MinimumOrder,OpenHours,CloseHours) values (?,?,?,?,?,?,?,?,?)";
            Connection con = DataAccessLayer.getConnection();
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setString(1, res.getName());
            pre.setDouble(2, res.getLatitute().doubleValue());
            pre.setDouble(3, res.getLongtitue().doubleValue());
            pre.setString(4, res.getAddress());
            pre.setString(5, res.getDescription());
            pre.setString(6, res.getPhoneNum());
            pre.setDouble(7, res.getMinimumOrder().doubleValue());
            pre.setDate(8, new Date(res.getOpenHours().toGregorianCalendar().getTime().getTime()));
            pre.setDate(9, new Date(res.getCloseHours().toGregorianCalendar().getTime().getTime()));
            return pre.executeUpdate() > 0;

        } catch (SQLException ex) {
            Logger.getLogger(DbEntities.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static Restaurants getRestaurants() throws SQLException, DatatypeConfigurationException {
        String sql = "select Id,Name,Latitute,Longtitue,Address,Description,PhoneNum,MinimumOrder,OpenHours,CloseHours from BAR_Restaurant";
        Connection con = DataAccessLayer.getConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        Restaurants restaurants = new Restaurants();
        try {
            while (rs.next()) {
                RestaurantType res = new RestaurantType();
                res.setId(BigInteger.valueOf(rs.getInt("Id")));
                res.setName(rs.getString("Name"));
                res.setLatitute(BigDecimal.valueOf(rs.getDouble("Latitute")));
                res.setLongtitue(BigDecimal.valueOf(rs.getDouble("Longtitue")));
                res.setAddress(rs.getString("Address"));
                res.setDescription(rs.getString("Description"));
                res.setPhoneNum(rs.getString("PhoneNum"));
                res.setMinimumOrder(BigDecimal.valueOf(rs.getDouble("MinimumOrder")));

                java.util.Date now = new java.util.Date();

                GregorianCalendar cldOpenHours = new GregorianCalendar();
                Time tOpen = rs.getTime("OpenHours");
                if (tOpen != null) {
                    now.setTime(tOpen.getTime());
                }
                cldOpenHours.setTime(now);
                res.setOpenHours(DatatypeFactory.newInstance().newXMLGregorianCalendar(cldOpenHours));

                GregorianCalendar cldCloseHours = new GregorianCalendar();
                Time tClose = rs.getTime("CloseHours");
                if (tClose != null) {
                    now.setTime(tClose.getTime());
                }
                cldCloseHours.setTime(now);
                res.setCloseHours(DatatypeFactory.newInstance().newXMLGregorianCalendar(cldCloseHours));

                restaurants.getRestaurant().add(res);
            }
        } finally {
            rs.close();
            st.close();
            con.close();
        }
        return restaurants;
    }

    public static DishCategories getDishCategories() throws SQLException {
        String sql = "select Id,RestaurantId,Name,isActive from BAR_DishCategory";
        Connection con = DataAccessLayer.getConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        DishCategories dishes = new DishCategories();
        try {
            while (rs.next()) {
                DishCategoryType dishType = new DishCategoryType();
                dishType.setId(BigInteger.valueOf(rs.getInt("Id")));
                dishType.setRestaurantId(BigInteger.valueOf(rs.getInt("RestaurantId")));
                dishType.setName(rs.getString("Name"));
                dishType.setIsActive(rs.getBoolean("isActive"));
                dishes.getDishCategory().add(dishType);
            }
        } finally {
            rs.close();
            st.close();
            con.close();
        }
        return dishes;
    }

    public static Discounts getDiscounts() throws SQLException, DatatypeConfigurationException {
        String sql = "select * from BAR_Discount";
        Connection con = DataAccessLayer.getConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        Discounts discounts = new Discounts();
        try {
            while (rs.next()) {
                DiscountType discountType = new DiscountType();
                discountType.setId(BigInteger.valueOf(rs.getInt("Id")));
                discountType.setRestaunrantId(BigInteger.valueOf(rs.getInt("RestaunrantId")));
                discountType.setValue(BigInteger.valueOf(rs.getInt("Value")));
                GregorianCalendar cldBeginDate = new GregorianCalendar();
                cldBeginDate.setTime(rs.getTime("BeginDate"));
                discountType.setBeginDate(DatatypeFactory.newInstance().newXMLGregorianCalendar(cldBeginDate));
                GregorianCalendar cldEndDate = new GregorianCalendar();
                cldEndDate.setTime(rs.getTime("EndDate"));
                discountType.setEndDate(DatatypeFactory.newInstance().newXMLGregorianCalendar(cldEndDate));

                discounts.getDiscount().add(discountType);
            }
        } finally {
            rs.close();
            st.close();
            con.close();
        }
        return discounts;
    }
}
