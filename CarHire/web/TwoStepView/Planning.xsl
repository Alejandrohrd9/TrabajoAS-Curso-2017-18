<?xml version="1.0" encoding="UTF-8"?>

<!--
    Document   : Planning.xsl
    Created on : 25 de febrero de 2018, 17:14
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
    

    <!-- TODO customize transformation rules 
         syntax recommendation http://www.w3.org/TR/xslt 
    -->
    <xsl:template match="week">
        <div>
            <table border="1" style="margin: 0 auto;" >
                <tr>
                    <th>Hora</th>
                    <th>Lunes</th>
                    <th>Martes</th>
                    <th>Miercoles</th>
                    <th>Jueves</th>
                    <th>Viernes</th>
                    <th>Sabado</th>
                    <th>Domingo</th>
                </tr>
            <xsl:for-each select = "planning">
                <tr>
                    <td>
                        <i><xsl:value-of select = "hora"/></i>
                    </td>
               
                    <td>
                        <xsl:value-of select = "lunes"/>
                    </td>
               
                    <td>
                        <xsl:value-of select = "martes"/>
                    </td>
                    
                    <td>
                        <xsl:value-of select = "miercoles"/>
                    </td>
                    
                    <td>
                        <xsl:value-of select = "jueves"/>
                    </td>
                    
                    <td>
                        <xsl:value-of select = "viernes"/>
                    </td>
                    
                    <td>
                        <xsl:value-of select = "sabado"/>
                    </td>
                    
                    <td>
                        <xsl:value-of select = "domingo"/>
                    </td>
                </tr>
            </xsl:for-each>
            </table>
        </div>
    </xsl:template>

</xsl:stylesheet>
