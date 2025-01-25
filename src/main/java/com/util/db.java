//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class db {
    private String dbDriver = "com.mysql.jdbc.Driver";
    private String sConnStr = "jdbc:mysql://localhost:3308/jewelry?useUnicode=true&characterEncoding=UTF-8";
    private String date = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(Calendar.getInstance().getTime());
    private List list;
    public Connection connect = null;
    public ResultSet rs = null;
    public String nsa = "root";
    public String nmm = "root";


    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(dbDriver);
            connection = DriverManager.getConnection(sConnStr, nsa, nmm);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public db() {
        try {
            Class.forName(this.dbDriver).newInstance();
        } catch (Exception var2) {
            System.out.println("连接出现异常");
        }

    }

    public ResultSet executeQuery(String sql) {
        try {
            this.connect = DriverManager.getConnection(this.sConnStr, this.nsa, this.nmm);
            Statement stmt = this.connect.createStatement();
            this.rs = stmt.executeQuery(sql);
        } catch (SQLException var3) {
            System.err.println(var3.getMessage());
        }

        return this.rs;
    }

    public String hsggetoption(String ntable, String nzd) {
        StringBuffer imgStr = new StringBuffer();
        imgStr.append("");
        String sql = "";
        sql = "select " + nzd + " from " + ntable + " order by id desc";
        System.out.print(sql);

        try {
            this.connect = DriverManager.getConnection(this.sConnStr, this.nsa, this.nmm);
            Statement stmt = this.connect.createStatement();
            this.rs = stmt.executeQuery(sql);

            while(this.rs.next()) {
                imgStr.append("<option value='" + this.rs.getString(1) + "'>" + this.rs.getString(1) + "</option>\n");
            }

            return imgStr.toString();
        } catch (Exception var6) {
            var6.printStackTrace();
            return imgStr.toString();
        }
    }

    public String hsggetoption2(String ntable, String nzd) {
        StringBuffer imgStr = new StringBuffer();
        imgStr.append("");
        imgStr.append("<option value=''>请选择</option>\n");
        String sql = "";
        sql = "select " + nzd + " from " + ntable + " order by id desc";

        try {
            this.connect = DriverManager.getConnection(this.sConnStr, this.nsa, this.nmm);
            Statement stmt = this.connect.createStatement();
            this.rs = stmt.executeQuery(sql);

            while(this.rs.next()) {
                imgStr.append("<option value='" + this.rs.getString(1) + "'>" + this.rs.getString(1) + "</option>\n");
            }

            return imgStr.toString();
        } catch (Exception var6) {
            var6.printStackTrace();
            return imgStr.toString();
        }
    }

    public String hsggetoptiond(String ntable, String nzd, String nwbk) {
        StringBuffer imgStr = new StringBuffer();
        imgStr.append("");
        String sql = "";
        sql = "select " + nzd + " from " + ntable + " order by id desc";
        System.out.print(sql);

        try {
            this.connect = DriverManager.getConnection(this.sConnStr, this.nsa, this.nmm);
            Statement stmt = this.connect.createStatement();
            this.rs = stmt.executeQuery(sql);

            while(this.rs.next()) {
                imgStr.append("<a onClick=\"hsgxia2shxurxu('" + this.rs.getString(1) + "','" + nwbk + "')\" style='cursor:pointer'>" + this.rs.getString(1) + "</a>\n");
            }

            return imgStr.toString();
        } catch (Exception var7) {
            var7.printStackTrace();
            return imgStr.toString();
        }
    }

    public int hsgexecute(String sql) {
        boolean var2 = false;

        try {
            this.connect = DriverManager.getConnection(this.sConnStr, this.nsa, this.nmm);
            Statement stmt = this.connect.createStatement();
            int i = stmt.executeUpdate(sql);
            return i == 1 ? i : i;
        } catch (Exception var4) {
            var4.printStackTrace();
            return 4;
        }
    }

    public static synchronized String getID() {
        Random random = new Random();
        StringBuffer ret = new StringBuffer(20);
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("MMddHHmmss", Locale.CHINA);
        ret.append(format.format(date));
        String rand = String.valueOf(Math.abs(random.nextInt()));
        ret.append(rand.substring(0, 4));
        return ret.toString();
    }

    public static int getBetweenDayNumber(String dateA, String dateB) {
        long dayNumber = 0L;
        long mins = 60000L;
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        try {
            Date d1 = df.parse(dateA);
            Date d2 = df.parse(dateB);
            dayNumber = (d2.getTime() - d1.getTime()) / mins;
        } catch (Exception var9) {
            var9.printStackTrace();
        }

        return (int)dayNumber;
    }

    public List getShouyebht() {
        String sql = "select id,biaoti,shouyetupian from xinwentongzhi where leibie='站内新闻' order by id desc";
        this.list = new ArrayList();

        try {
            this.connect = DriverManager.getConnection(this.sConnStr, this.nsa, this.nmm);
            Statement stmt = this.connect.createStatement();
            this.rs = stmt.executeQuery(sql);

            while(this.rs.next()) {
                List list2 = new ArrayList();
                list2.add(this.rs.getString(1));
                list2.add(this.rs.getString(2));
                list2.add(this.rs.getString(3));
                this.list.add(list2);
            }

            return this.list;
        } catch (Exception var4) {
            var4.printStackTrace();
            return this.list;
        }
    }

    public String getxwlb() {
        StringBuffer imgStr = new StringBuffer();
        imgStr.append("");
        String sql = "";
        sql = "select distinct(leibie) as ss from xinwentongzhi where leibie<>'变幻图'";
        System.out.print(sql);

        try {
            this.connect = DriverManager.getConnection(this.sConnStr, this.nsa, this.nmm);
            Statement stmt = this.connect.createStatement();
            this.rs = stmt.executeQuery(sql);

            while(this.rs.next()) {
                imgStr.append("<option value='" + this.rs.getString(1) + "'>" + this.rs.getString(1) + "</option>\n");
            }

            return imgStr.toString();
        } catch (Exception var4) {
            var4.printStackTrace();
            return imgStr.toString();
        }
    }

    public String readzd(String ntable, String nzd, String tjzd, String tjz) {
        String sql = "select " + nzd + " from " + ntable + " where " + tjzd + "='" + tjz + "' ";

        try {
            this.connect = DriverManager.getConnection(this.sConnStr, this.nsa, this.nmm);
            Statement stmt = this.connect.createStatement();
            this.rs = stmt.executeQuery(sql);
            this.rs.next();
            String dir = this.rs.getString(1);
            return dir;
        } catch (Exception var8) {
            var8.printStackTrace();
            return null;
        }
    }

    public String getddnr(String nuser) {
        String sql = "select shangpinmingcheng,goumaishuliang from goumaijilu where goumairen = '" + nuser + "' and issh='否' ";
        System.out.print(sql);
        String ddnr = "";

        try {
            this.connect = DriverManager.getConnection(this.sConnStr, this.nsa, this.nmm);
            Statement stmt = this.connect.createStatement();

            for(this.rs = stmt.executeQuery(sql); this.rs.next(); ddnr = ddnr + "商品名称：" + this.rs.getString(1) + "，购买数量：" + this.rs.getString(2) + "；\r\n") {
            }

            return ddnr;
        } catch (Exception var5) {
            var5.printStackTrace();
            return ddnr;
        }
    }

    public List<HashMap> select(String sql) {
        System.out.println(sql);
        Object list = new ArrayList();

        try {
            this.connect = DriverManager.getConnection(this.sConnStr, this.nsa, this.nmm);
            Statement stmt = this.connect.createStatement();
            this.rs = stmt.executeQuery(sql);
            ResultSet rs = stmt.executeQuery(sql);
            ResultSetMetaData rsmd = rs.getMetaData();

            while(rs.next()) {
                HashMap map = new HashMap();
                int i = rsmd.getColumnCount();

                for(int j = 1; j <= i; ++j) {
                    if (!rsmd.getColumnName(j).equals("ID")) {
                        String str = rs.getString(j) == null ? "" : rs.getString(j);
                        if (str.equals("null")) {
                            str = "";
                        }

                        map.put(rsmd.getColumnName(j), str);
                    } else {
                        map.put("id", rs.getString(j));
                    }
                }

                ((List)list).add(map);
            }

            rs.close();
        } catch (SQLException var10) {
            if (sql.equals("show tables")) {
                list = this.select("select table_name from   INFORMATION_SCHEMA.tables");
            } else {
                var10.printStackTrace();
            }
        }

        return (List)list;
    }

    public List<HashMap> select(String sql, int pageno, int rowsize) {
        new ArrayList();
        ArrayList mlist = new ArrayList();

        try {
            List<HashMap> list = this.select(sql);
            int min = (pageno - 1) * rowsize;
            int max = pageno * rowsize;

            for(int i = 0; i < list.size(); ++i) {
                if (i >= min && i <= max - 1) {
                    mlist.add((HashMap)list.get(i));
                }
            }

            return mlist;
        } catch (RuntimeException var9) {
            var9.printStackTrace();
            throw var9;
        }
    }

    public List<HashMap> getpinglun(String nbiao, String nid) {
        ArrayList list = new ArrayList();

        try {
            this.connect = DriverManager.getConnection(this.sConnStr, this.nsa, this.nmm);
            Statement stmt = this.connect.createStatement();
            String tsql = "select * from pinglun where biao='" + nbiao + "' and xinwenID='" + nid + "'";
            this.rs = stmt.executeQuery(tsql);
            ResultSet rs = stmt.executeQuery(tsql);
            ResultSetMetaData rsmd = rs.getMetaData();

            while(rs.next()) {
                HashMap map = new HashMap();
                int i = rsmd.getColumnCount();

                for(int j = 1; j <= i; ++j) {
                    if (!rsmd.getColumnName(j).equals("ID")) {
                        String str = rs.getString(j) == null ? "" : rs.getString(j);
                        if (str.equals("null")) {
                            str = "";
                        }

                        map.put(rsmd.getColumnName(j), str);
                    } else {
                        map.put("id", rs.getString(j));
                    }
                }

                list.add(map);
            }

            rs.close();
        } catch (SQLException var12) {
        }

        return list;
    }

    public String DynamicImage(int width, int height) {
        StringBuffer imgStr = new StringBuffer();
        StringBuffer thePics1 = new StringBuffer();
        StringBuffer theLinks1 = new StringBuffer();
        StringBuffer theTexts1 = new StringBuffer();
        imgStr.append("<div id=picViwer1  style='background-color: #ffffff' align=center></div><SCRIPT src='js/dynamicImage.js' type=text/javascript></SCRIPT>\n<script language=JavaScript>\n");
        thePics1.append("var thePics1=\n'");
        theLinks1.append("var theLinks1='");
        theTexts1.append("var theTexts1='");
        List<HashMap> co = this.select("select * from xinwentongzhi where shouyetupian<>'' and shouyetupian<>'null'  and shouyetupian  like '%.jpg' order by id desc", 1, 6);
        int i = co.size();
        int j = 0;
        Iterator var11 = co.iterator();

        while(var11.hasNext()) {
            HashMap b = (HashMap)var11.next();
            ++j;
            int id = Integer.parseInt(b.get("id").toString());
            String title = Info.subStr(b.get("biaoti").toString(), 21);
            String url = "" + b.get("shouyetupian");
            String purl = "xwtzDetail.do?id=" + b.get("id");
            if (j != i) {
                thePics1.append(url.replaceAll("\n", "") + "|");
                theLinks1.append(purl + "|");
                theTexts1.append(title + "|");
            }

            if (j == i) {
                thePics1.append(url.replaceAll("\n", ""));
                theLinks1.append("xwtzDetail.do?id=" + b.get("id"));
                theTexts1.append(title);
            }
        }

        thePics1.append("';");
        theLinks1.append("';");
        theTexts1.append("';");
        imgStr.append(thePics1 + "\n");
        imgStr.append(theLinks1 + "\n");
        imgStr.append(theTexts1 + "\n");
        imgStr.append("\n setPic(thePics1,theLinks1,theTexts1," + width + "," + height + ",'picViwer1');</script>");
        return imgStr.toString();
    }

    public String getdate() {
        String tt = (new SimpleDateFormat("yyyy-MM-dd")).format(Calendar.getInstance().getTime());
        return tt;
    }

    public String gettime() {
        String tt = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(Calendar.getInstance().getTime());
        return tt;
    }

    public int getwzs(String nbk) {
        int i = 0;

        try {
            this.connect = DriverManager.getConnection(this.sConnStr, this.nsa, this.nmm);
            Statement stmt = this.connect.createStatement();

            for(this.rs = stmt.executeQuery("select * from tiezi where bankuai='" + nbk + "' and fid=0"); this.rs.next(); ++i) {
            }

            return i;
        } catch (Exception var4) {
            var4.printStackTrace();
            return 0;
        }
    }

    public int gettzs(String tzid) {
        int i = 0;

        try {
            this.connect = DriverManager.getConnection(this.sConnStr, this.nsa, this.nmm);
            Statement stmt = this.connect.createStatement();

            for(this.rs = stmt.executeQuery("select * from tiezi where fid=" + tzid); this.rs.next(); ++i) {
            }

            return i;
        } catch (Exception var4) {
            var4.printStackTrace();
            return 0;
        }
    }

    public static synchronized String ensubStr(Object source, int length) {
        String msource = filterStrIgnoreCase(source.toString(), "<", ">");
        if (msource.length() > length) {
            msource = msource.substring(0, length) + "...";
        }

        return msource;
    }

    public static String filterStrIgnoreCase(String source, String from, String to) {
        String sourceLowcase = source.toLowerCase();
        String subLowcase2 = "";
        String subLowcase1 = "";
        String sub2 = "";
        String sub1 = "";
        int start = 0;
        boolean done = true;
        if (source == null) {
            return null;
        } else if (from != null && !from.equals("") && to != null && !to.equals("")) {
            while(done) {
                start = sourceLowcase.indexOf(from, start);
                if (start == -1) {
                    break;
                }

                subLowcase1 = sourceLowcase.substring(0, start);
                sub1 = source.substring(0, start);
                int end = sourceLowcase.indexOf(to, start);
                if (end == -1) {
                    end = sourceLowcase.indexOf("/>", start);
                    if (end == -1) {
                        done = false;
                    }
                } else {
                    end += to.length();
                    subLowcase2 = sourceLowcase.substring(end, source.length());
                    sub2 = source.substring(end, source.length());
                    sourceLowcase = subLowcase1 + subLowcase2;
                    source = sub1 + sub2;
                }
            }

            return source;
        } else {
            return source;
        }
    }
}
