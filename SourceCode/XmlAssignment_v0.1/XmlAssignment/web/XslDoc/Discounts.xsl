<?xml version="1.0" encoding="UTF-8"?>

<!--
    Document   : Discounts.xsl
    Created on : January 25, 2013, 1:23 AM
    Author     : TuanDTA
    Description:
        Purpose of transformation follows.
-->

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:bar="http://xml.netbeans.org/schema/discounts" exclude-result-prefixes="bar" version="1.0">
    <xsl:output method="html" indent="yes" version="1.0"/>

    <!-- TODO customize transformation rules 
         syntax recommendation http://www.w3.org/TR/xslt 
    -->
    <xsl:template match="/">
        <table border="1">
            <thead>
                <tr>
                    <th>Restaurantid</th>
                    <th>Value</th>
                    <th>Begin Date</th>
                    <th>End Date</th>
                </tr>
            </thead>
            <tbody>
                <xsl:for-each select="bar:Discounts/bar:Discount">
                    <tr>
                       <td><xsl:value-of select="bar:RestaunrantId"/></td>                                               
                       <td><xsl:value-of select="bar:Value"/></td>                                                
                       <td><xsl:value-of select="bar:BeginDate"/></td>                                               
                       <td><xsl:value-of select="bar:EndDate"/></td>                                                

                    </tr>
                </xsl:for-each>
            </tbody>
        </table>

    </xsl:template>

</xsl:stylesheet>
