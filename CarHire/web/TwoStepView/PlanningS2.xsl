<?xml version="1.0"?>

<!--
    Document   : PlanningS2.xsl
    Created on : 25 de febrero de 2018, 19:09
    Author     : alejandrohd
    Description:
        Purpose of transformation follows.
-->

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:template match="table">
        <table  border="1" style="margin: 0 auto;">
            <tr>
                <th>Empleado</th>
                <th>Puesto de trabajo</th>
            </tr>
            <xsl:apply-templates/>
        </table>
    </xsl:template>
    <xsl:template match="table/row">
       <xsl:variable name="bgcolor">
          <xsl:choose>
              <xsl:when test="(position() mod 2) = 1">linen</xsl:when>
             <xsl:otherwise>white</xsl:otherwise>
          </xsl:choose>
       </xsl:variable>
       <tr bgcolor="white">
           <xsl:apply-templates/>
       </tr> 
    </xsl:template>
    <xsl:template match="table/row/cell">
        <td>
            <xsl:apply-templates/>
        </td> 
    </xsl:template>
</xsl:stylesheet>
