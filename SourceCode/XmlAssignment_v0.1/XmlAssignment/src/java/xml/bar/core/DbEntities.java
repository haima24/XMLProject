/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package xml.bar.core;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import xml.bar.binding.dishcategory.DishCategories;
import xml.bar.binding.dishcategory.DishCategoryType;
import xml.bar.binding.restaurant.RestaurantType;
import xml.bar.binding.restaurant.Restaurants;

/**
 *
 * @author Tu
 */
public class DbEntities {

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

                GregorianCalendar cldOpenHours = new GregorianCalendar();
                cldOpenHours.setTime(rs.getDate("OpenHours"));
                res.setOpenHours(DatatypeFactory.newInstance().newXMLGregorianCalendar(cldOpenHours));

                GregorianCalendar cldCloseHours = new GregorianCalendar();
                cldCloseHours.setTime(rs.getDate("CloseHours"));
                res.setOpenHours(DatatypeFactory.newInstance().newXMLGregorianCalendar(cldCloseHours));

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
}
