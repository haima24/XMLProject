<?xml version="1.0" encoding="UTF-8"?>

<!--
    Document   : Dishes.xsl
    Created on : January 25, 2013, 12:12 AM
    Author     : Sean
    Description:
        Purpose of transformation follows.
-->

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:a="http://xml.netbeans.org/schema/restaurants" version="1.0">
   <xsl:output method="html" indent="yes" version="1.0"/>
    <xsl:param name="resid" select="0"/>

    <!-- TODO customize transformation rules 
         syntax recommendation http://www.w3.org/TR/xslt 
    -->
    <xsl:template match="/">
        <table border="1">
            <thead>
                <tr>Id</tr>
                <tr>RestaurantId</tr>
                <tr>Name</tr>
                <tr>Description</tr>
                <tr>Price</tr>
                <tr>CategoryId</tr>
                <tr>IsActive</tr>
            </thead>
            <tbody>
                <xsl:for-each select="bar:Dishes/bar:Dish">
                    <tr>
                       <td><xsl:value-of select="bar:Id"/></td>
                       <td><xsl:value-of select="bar:RestaurantId"/></td>
                       <td><xsl:value-of select="bar:Name"/></td>
                       <td><xsl:value-of select="bar:Description"/></td>
<td><xsl:value-of select="bar:Price"/></td>
<td><xsl:value-of select="bar:CategoryId"/></td>
<td><xsl:value-of select="bar:IsActive"/></td>
                    </tr>
                </xsl:for-each>
            </tbody>
        </table>
    </xsl:template>

</xsl:stylesheet>
