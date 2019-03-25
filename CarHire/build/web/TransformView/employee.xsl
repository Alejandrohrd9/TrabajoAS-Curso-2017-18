<?xml version="1.0" encoding="UTF-8"?>

<!--
    Document   : Employee.xsl
    Created on : 20 de febrero de 2018, 9:17
    Author     : alejandrohd
    Description:
        Purpose of transformation follows.
-->

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method = "html" indent = "yes"/>
    <xsl:template match = "/">
        <html>
            <body>
                <xsl:apply-templates/>
            </body>
        </html>
   </xsl:template>
    

    <xsl:template match="employees">
        <div>
            <table border="1" style="margin: 0 auto;">
                <tr>
                    <th>Nombre</th>
                    <th>Nombre de usuario</th>
                    <th>Rol</th>
                </tr>
            <xsl:for-each select = "employee">
                <tr>
                    <td>
                        <xsl:value-of select = "name"/>
                    </td>
               
                    <td>
                        <xsl:value-of select = "username"/>
                    </td>
               
                    <td>
                        <xsl:value-of select = "role"/>
                    </td>
                </tr>
            </xsl:for-each>
            </table>
        </div>
    </xsl:template>

</xsl:stylesheet>
