<?xml version="1.0" encoding="UTF-8"?>

<!--
    Document   : DishCategory.xsl
    Created on : January 22, 2013, 8:03 PM
    Author     : Tu
    Description:
        Purpose of transformation follows.
-->

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html" indent="yes"/>
    <xsl:param name="resid" select="0"/>
    <!-- TODO customize transformation rules 
         syntax recommendation http://www.w3.org/TR/xslt 
    -->
    <xsl:template match="/">
        <table border="1">
            <thead>
                <tr>
                    <th>Name</th>
                    <th>Status</th>
                </tr>
            </thead>
            <tbody>
                <xsl:for-each select="DishCategories/DishCategory[RestaurantId=$resid]">
                    <tr>
                        
                        
                        <td>
                            <xsl:value-of select="Name"/>
                        </td>
                        <td>
                            <xsl:value-of select="IsActive"/>
                        </td>
                    </tr>
                </xsl:for-each>
            </tbody>
        </table>
    </xsl:template>

</xsl:stylesheet>
