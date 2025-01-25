//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.util;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class Info {
    public static String popheight = "alliframe.style.height=document.body.scrollHeight+";

    public Info() {
    }

    public static HashMap getUser(HttpServletRequest request) {
        HashMap map = (HashMap)(request.getSession().getAttribute("admin") == null ? request.getSession().getAttribute("user") : request.getSession().getAttribute("admin"));
        return map;
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

    public static void main(String[] g) {
        System.out.print(getBetweenDayNumber("2012-11-11 11:19", "2012-11-11 11:11"));
    }

    public static String getselect(String name, String tablename, String zdname) {
        String select = "<select name=\"" + name + "\" id=\"" + name + "\" >";
        return select;
    }

    public static String getselect(String name, String tablename, String zdname, String where) {
        String select = "<select name=\"" + name + "\" id=\"" + name + "\" >";
        select = select + "<option value=\"\">不限</option>";
        return select;
    }

    public static String getradio(String name, String tablename, String zdname, String where) {
        String radio = "";
        boolean dxii = false;
        return radio;
    }

    public static void writeExcel(String fileName, String prosstr, List<List> plist, HttpServletRequest request, HttpServletResponse response) {
        WritableWorkbook wwb = null;
        String cols = "";
        String[] var10;
        int var9 = (var10 = prosstr.split("@")).length;

        for(int var8 = 0; var8 < var9; ++var8) {
            String str = var10[var8];
            cols = cols + str.split("-")[0] + ",";
        }

        cols.substring(0, cols.length() - 1);
        if (request.getAttribute("where") == null) {
            String var10000 = "";
        } else {
            request.getAttribute("where").toString();
        }

        fileName = request.getRealPath("/") + "/upfile/" + generalFileName("a.xls");
        String[] pros = prosstr.split("@");

        try {
            wwb = Workbook.createWorkbook(new File(fileName));
        } catch (IOException var12) {
            var12.printStackTrace();
        }

        if (wwb != null) {
            WritableSheet ws = wwb.createSheet("sheet1", 0);
            ws.setColumnView(0, 20);
            ws.setColumnView(1, 20);
            ws.setColumnView(2, 20);
            ws.setColumnView(3, 20);
            ws.setColumnView(4, 20);
            ws.setColumnView(5, 20);

            try {
                for(int i = 0; i < pros.length; ++i) {
                    Label label1 = new Label(i, 0, "");
                    label1.setString(pros[i]);
                    ws.addCell(label1);
                }
            } catch (RowsExceededException var13) {
                var13.printStackTrace();
            } catch (WriteException var14) {
                var14.printStackTrace();
            }
        }

    }

    public static String getcheckbox(String name, String tablename, String zdname, String where) {
        String checkbox = "";
        return checkbox;
    }

    public static String getcheckboxDk(String name, String tablename, String zdname, String nstr, String where) {
        String checkbox = "";
        boolean i = false;
        return checkbox;
    }

    public static String getFileUpInfo() {
        String jscode = "";
        jscode = jscode + "<script src=/pianotrainwebstie/js/popup.js></script>";
        jscode = jscode + "<font onclick=\"uploaddoc()\" src=\"js/nopic.jpg\" style='cursor:hand' id=txt >点击此处上传</font>";
        jscode = jscode + "&nbsp;&nbsp;<input type=text readonly style='border:0px' size=30  name=\"docname\" id=\"docname\" value=\"\" />";
        return jscode;
    }

    public static String tform(HashMap map) {
        String jscode = "";

        try {
            jscode = jscode + "<script type=\"text/javascript\">\n";
            jscode = jscode + "function getPvalue()\n";
            jscode = jscode + "{\n";
            Set set = map.entrySet();
            Iterator it = set.iterator();

            while(true) {
                String str1;
                String str2;
                do {
                    if (!it.hasNext()) {
                        jscode = jscode + "}\n";
                        jscode = jscode + " getPvalue();\n";
                        jscode = jscode + "</script>\n";
                        return jscode;
                    }

                    String pm = it.next().toString();
                    str1 = "";
                    str2 = "";
                    String[] strs = pm.split("=");
                    str1 = strs[0];
                    if (strs.length == 1) {
                        str2 = "";
                    }

                    if (strs.length == 2) {
                        str2 = strs[1];
                    }

                    str2 = str2.replaceAll("\r\n", "-----");
                } while(str1.equals("content"));

                jscode = jscode + " if(document.getElementsByName(\"" + str1 + "\").length>1)\n";
                jscode = jscode + " {\n";
                jscode = jscode + " var radios = document.getElementsByName(\"" + str1 + "\");\n";
                jscode = jscode + " if(radios[0].type=='radio'){\n";
                jscode = jscode + " for(var i=0;i<radios.length;i++)\n";
                jscode = jscode + " {\n";
                jscode = jscode + " if(radios[i].value==\"" + str2 + "\")\n";
                jscode = jscode + " {\n";
                jscode = jscode + " radios[i].checked=\"checked\";\n";
                jscode = jscode + " }\n";
                jscode = jscode + " }\n";
                jscode = jscode + " }\n";
                jscode = jscode + " if(radios[0].type=='checkbox'){\n";
                jscode = jscode + " for(var i=0;i<radios.length;i++)\n";
                jscode = jscode + " {\n";
                jscode = jscode + " if(\"" + str2 + "\".indexOf(radios[i].value)>-1)\n";
                jscode = jscode + " {\n";
                jscode = jscode + " radios[i].checked=\"checked\";\n";
                if (str2.indexOf(" - ") > -1) {
                    String[] var11;
                    int var10 = (var11 = str2.split(" ~ ")).length;

                    for(int var9 = 0; var9 < var10; ++var9) {
                        String strch = var11[var9];
                        String strchname = strch.substring(0, strch.lastIndexOf(" - "));
                        jscode = jscode + " if(document.getElementsByName('" + strchname + "').length>0)\n";
                        jscode = jscode + " {\n";
                        jscode = jscode + " document.getElementsByName('" + strchname + "')[0].value='" + strch.substring(strch.lastIndexOf(":") + 1) + "';\n";
                        jscode = jscode + " }\n";
                    }
                }

                jscode = jscode + " }\n";
                jscode = jscode + " }\n";
                jscode = jscode + " }\n";
                jscode = jscode + " if(radios.type=='select'){\n";
                jscode = jscode + " f1." + str1 + ".value=\"" + str2 + "\";\n";
                jscode = jscode + " }\n";
                jscode = jscode + " }else{\n";
                jscode = jscode + " if(f1." + str1 + ")\n";
                jscode = jscode + "{\n";
                jscode = jscode + "f1." + str1 + ".value=\"" + str2 + "\";\n";
                jscode = jscode + "}\n";
                jscode = jscode + "}\n";
                jscode = jscode + "if(document.getElementById(\"txt\"))\n";
                jscode = jscode + "{\n";
                jscode = jscode + "document.getElementById(\"txt\").src=\"/pianotrainwebstie/upfile/" + map.get("filename") + "\";\n";
                jscode = jscode + "}\n";
                jscode = jscode + "if(document.getElementById(\"txt2\"))\n";
                jscode = jscode + "{\n";
                jscode = jscode + "document.getElementById(\"txt2\").src=\"/pianotrainwebstie/upfile/" + map.get("filename2") + "\";\n";
                jscode = jscode + "}\n";
                jscode = jscode + "if(document.getElementById(\"txt3\"))\n";
                jscode = jscode + "{\n";
                jscode = jscode + "document.getElementById(\"txt3\").src=\"/pianotrainwebstie/upfile/" + map.get("filename3") + "\";\n";
                jscode = jscode + "}\n";
                jscode = jscode + "if(document.getElementById(\"txt4\"))\n";
                jscode = jscode + "{\n";
                jscode = jscode + "document.getElementById(\"txt4\").src=\"/pianotrainwebstie/upfile/" + map.get("filename4") + "\";\n";
                jscode = jscode + "}\n";
                jscode = jscode + "if(document.getElementById(\"txt5\"))\n";
                jscode = jscode + "{\n";
                jscode = jscode + "document.getElementById(\"txt5\").src=\"/pianotrainwebstie/upfile/" + map.get("filename5") + "\";\n";
                jscode = jscode + "}\n";
            }
        } catch (Exception var13) {
            var13.printStackTrace();
            return jscode;
        }
    }

    public static String generalFileName(String srcFileName) {
        try {
            int index = srcFileName.lastIndexOf(".");
            return StrUtil.generalSrid() + srcFileName.substring(index).toLowerCase();
        } catch (Exception var2) {
            return StrUtil.generalSrid();
        }
    }

    public static synchronized String getID() {
        Random random = new Random();
        StringBuffer ret = new StringBuffer(20);
        String rand = String.valueOf(Math.abs(random.nextInt()));
        ret.append(getDateStr());
        ret.append(rand.substring(0, 6));
        return ret.toString();
    }

    public static String getImgUpInfo(int height) {
        String jscode = "";
        jscode = jscode + "<img style=\"cursor: hand\" onclick=\"uploadimg()\" src=\"/pianotrainwebstie/js/nopic.jpg\" id=txt height=\"" + height + "\"/>";
        jscode = jscode + "<input type=hidden name=\"filename\" id=\"filename\" value=\"\" />";
        jscode = jscode + "<script type=\"text/javascript\"  src=\"/pianotrainwebstie/js/popups.js\"></script>";
        return jscode;
    }

    public static String getImgUpInfo2(int height) {
        String jscode = "";
        jscode = jscode + "<img style=\"cursor: hand\" onclick=\"uploadimg2()\" src=\"/pianotrainwebstie/js/nopic.jpg\" id=txt2 height=\"" + height + "\"/>";
        jscode = jscode + "<input type=hidden name=\"filename2\" id=\"filename2\" value=\"\" />";
        jscode = jscode + "<script type=\"text/javascript\"  src=\"/pianotrainwebstie/js/popup.js\"></script>";
        return jscode;
    }

    public static String getImgUpInfo3(int height) {
        String jscode = "";
        jscode = jscode + "<img style=\"cursor: hand\" onclick=\"uploadimg3()\" src=\"/pianotrainwebstie/js/nopic.jpg\" id=txt3 height=\"" + height + "\"/>";
        jscode = jscode + "<input type=hidden name=\"filename3\" id=\"filename3\" value=\"\" />";
        jscode = jscode + "<script type=\"text/javascript\"  src=\"/pianotrainwebstie/js/popup.js\"></script>";
        return jscode;
    }

    public static String getImgUpInfo4(int height) {
        String jscode = "";
        jscode = jscode + "<img style=\"cursor: hand\" onclick=\"uploadimg4()\" src=\"/pianotrainwebstie/js/nopic.jpg\" id=txt4 height=\"" + height + "\"/>";
        jscode = jscode + "<input type=hidden name=\"filename4\" id=\"filename4\" value=\"\" />";
        jscode = jscode + "<script type=\"text/javascript\"  src=\"/pianotrainwebstie/js/popup.js\"></script>";
        return jscode;
    }

    public static String getImgUpInfo5(int height) {
        String jscode = "";
        jscode = jscode + "<img style=\"cursor: hand\" onclick=\"uploadimg5()\" src=\"/pianotrainwebstie/js/nopic.jpg\" id=txt5 height=\"" + height + "\"/>";
        jscode = jscode + "<input type=hidden name=\"filename5\" id=\"filename5\" value=\"\" />";
        jscode = jscode + "<script type=\"text/javascript\"  src=\"/pianotrainwebstie/js/popup.js\"></script>";
        return jscode;
    }

    public static String fck(int height, String content) {
        String jscode = "<TEXTAREA name=\"content\" id=\"content\">" + content + "</TEXTAREA>";
        jscode = jscode + "<script type=\"text/javascript\"  src=\"/pianotrainwebstie/fckeditor/fckeditor.js\"></script>";
        jscode = jscode + "<script language=\"javascript\">";
        jscode = jscode + "function fckinit()";
        jscode = jscode + "{";
        jscode = jscode + " var of = new FCKeditor(\"content\");";
        jscode = jscode + "of.BasePath=\"/pianotrainwebstie/fckeditor/\";";
        jscode = jscode + "of.Height = \"" + height + "\";";
        jscode = jscode + "of.ToolbarSet=\"Default\";";
        jscode = jscode + "of.ReplaceTextarea();";
        jscode = jscode + "}";
        jscode = jscode + "fckinit();";
        jscode = jscode + "</script>";
        return jscode;
    }

    public static synchronized String subStr(String source, int length) {
        if (source.length() > length) {
            source = source.substring(0, length) + "...";
        }

        return source;
    }

    public static String getDateStr() {
        String dateString = "";

        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date currentTime_1 = new Date();
            dateString = formatter.format(currentTime_1);
        } catch (Exception var3) {
        }

        return dateString;
    }

    public static String getUTFStr(String str) {
        if (str == null) {
            return "";
        } else {
            try {
                str = new String(str.getBytes("utf-8"), "utf-8");
            } catch (UnsupportedEncodingException var2) {
                var2.printStackTrace();
            }

            return str;
        }
    }

    public static String getGBKStr(String str) throws UnsupportedEncodingException {
        return str == null ? "" : new String(str.getBytes("utf-8"), "UTF-8");
    }

    public static String getGB2312Str(String str) throws UnsupportedEncodingException {
        return str == null ? "" : new String(str.getBytes("utf-8"), "UTF-8");
    }

    public static String getDay(String date, int day) {
        String b = date.substring(0, 10);
        String c = b.substring(0, 4);
        String d = b.substring(5, 7);
        String f = b.substring(8, 10);
        String aa = c + "/" + d + "/" + f;
        String a = "";
        DateFormat dateFormat = DateFormat.getDateInstance(2);
        GregorianCalendar grc = new GregorianCalendar();
        grc.setTime(new Date(aa));
        grc.add(5, day);
        String resu = dateFormat.format(grc.getTime());
        String[] t = resu.split("-");
        String sesuu = "";

        for(int i = 0; i < t.length; ++i) {
            if (t[i].length() == 1) {
                t[i] = "0" + t[i];
            }

            sesuu = sesuu + t[i] + "-";
        }

        return sesuu.substring(0, 10);
    }

    public static int dayToday(String DATE1, String DATE2) {
        int i = 0;
        if (DATE1.indexOf(" ") > -1) {
            DATE1 = DATE1.substring(0, DATE1.indexOf(" "));
        }

        if (DATE2.indexOf(" ") > -1) {
            DATE2 = DATE2.substring(0, DATE2.indexOf(" "));
        }

        String[] d1 = DATE1.split("-");
        if (d1[1].length() == 1) {
            DATE1 = d1[0] + "-0" + d1[1];
        } else {
            DATE1 = d1[0] + "-" + d1[1];
        }

        if (d1[2].length() == 1) {
            DATE1 = DATE1 + "-0" + d1[2];
        } else {
            DATE1 = DATE1 + "-" + d1[2];
        }

        String[] d2 = DATE2.split("-");
        if (d2[1].length() == 1) {
            DATE2 = d2[0] + "-0" + d2[1];
        } else {
            DATE2 = d2[0] + "-" + d2[1];
        }

        if (d2[2].length() == 1) {
            DATE2 = DATE2 + "-0" + d2[2];
        } else {
            DATE2 = DATE2 + "-" + d2[2];
        }

        for(int j = 0; j < 10000; ++j) {
            i = j;
            String gday = getDay(DATE1, j);
            if (gday.equals(DATE2)) {
                break;
            }
        }

        return i;
    }

    public static String compare_datezq(String DATE1, String DATE2) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        try {
            Date dt1 = df.parse(DATE1);
            Date dt2 = df.parse(DATE2);
            if (dt1.getTime() > dt2.getTime()) {
                return "big";
            } else {
                return dt1.getTime() < dt2.getTime() ? "small" : "den";
            }
        } catch (Exception var5) {
            var5.printStackTrace();
            return "den";
        }
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

    public static void delPic(String path, String img) {
        if (img != null && !img.equals("")) {
            File file1 = new File(path + "/" + img);
            if (file1.exists()) {
                file1.deleteOnExit();
                file1.delete();
            }
        }

    }
}
